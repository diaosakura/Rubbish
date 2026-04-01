package com.sakura;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

        public class danzai {
            // 方向：上、右、下、左
            private static final int[] dx = {-1, 0, 1, 0};
            private static final int[] dy = {0, 1, 0, -1};

            // 转向板类型
            private static final char SLASH = '/';
            private static final char BACKSLASH = '\\';
            private static final char BLOCK = '#';
            private static final char EMPTY = '.';

            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int M = sc.nextInt();
                int K = sc.nextInt();

                // 构建地图，边界是空气墙，所以地图大小为 (N+2) x (M+2)
                char[][] map = new char[N+2][M+2];
                // 初始化地图为空地
                for (int i = 0; i < N+2; i++) {
                    for (int j = 0; j < M+2; j++) {
                        map[i][j] = EMPTY;
                    }
                }

                // 标记空气墙（边界）
                for (int i = 0; i < N+2; i++) {
                    map[i][0] = BLOCK;
                    map[i][M+1] = BLOCK;
                }
                for (int j = 0; j < M+2; j++) {
                    map[0][j] = BLOCK;
                    map[N+1][j] = BLOCK;
                }

                // 读取起点和终点坐标
                int Sx = sc.nextInt();
                int Sy = sc.nextInt();
                int Ex = sc.nextInt();
                int Ey = sc.nextInt();

                // 读取组件
                for (int i = 0; i < K; i++) {
                    int R = sc.nextInt();
                    int C = sc.nextInt();
                    char Type = sc.next().charAt(0);
                    map[R][C] = Type;
                }

                // BFS队列，存储 (x, y, steps)
                Queue<int[]> queue = new LinkedList<>();
                // 访问标记，记录到达该位置的最少步数
                int[][] visited = new int[N+2][M+2];
                for (int i = 0; i < N+2; i++) {
                    for (int j = 0; j < M+2; j++) {
                        visited[i][j] = -1;

                    }
                }
                // 起点入队
                queue.offer(new int[]{Sx, Sy, 0});
                visited[Sx][Sy] = 0;

                while (!queue.isEmpty()) {
                    int[] current = queue.poll();
                    int x = current[0];
                    int y = current[1];
                    int steps = current[2];

                    // 如果到达终点，输出步数
                    if (x == Ex && y == Ey) {
                        System.out.println(steps);
                        return;
                    }

                    // 尝试四个方向
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = x;
                        int ny = y;
                        int ndir = dir;
                        boolean moved = false;

                        // 模拟滑行过程
                        while (true) {
                            int nextX = nx + dx[ndir];
                            int nextY = ny + dy[ndir];
                            char cell = map[nextX][nextY];

                            if (cell == BLOCK) {
                                // 遇到障碍物，停止
                                if (moved) {
                                    // 如果移动过，检查新位置是否未访问
                                    if (visited[nx][ny] == -1) {
                                        visited[nx][ny] = steps + 1;
                                        queue.offer(new int[]{nx, ny, steps + 1});
                                    }
                                }
                                break;
                            } else if (cell == SLASH || cell == BACKSLASH) {
                                // 检查转向板是否有效（周围是否有障碍物）
                                boolean valid = true;
                                for (int d = 0; d < 4; d++) {
                                    int checkX = nextX + dx[d];
                                    int checkY = nextY + dy[d];
                                    char checkCell = map[checkX][checkY];
                                    if (checkCell == BLOCK || checkCell == SLASH || checkCell == BACKSLASH) {
                                        valid = false;
                                        break;
                                    }
                                }

                                if (!valid) {
                                    // 转向板无效，视为障碍物
                                    if (moved) {
                                        if (visited[nx][ny] == -1) {
                                            visited[nx][ny] = steps + 1;
                                            queue.offer(new int[]{nx, ny, steps + 1});
                                        }
                                    }
                                    break;
                                } else {
                                    // 转向板有效，计算新方向
                                    ndir = getNewDirection(ndir, cell);
                                    nx = nextX;
                                    ny = nextY;
                                    moved = true;
                                }
                            } else {
                                // 空地，继续滑行
                                nx = nextX;
                                ny = nextY;
                                moved = true;
                            }
                        }
                    }
                }
                // 无法到达终点
                System.out.println(-1);
            }

            // 根据当前方向和转向板类型计算新方向
            private static int getNewDirection(int dir, char type) {
                if (type == SLASH) {
                    // / 型转向板
                    switch (dir) {
                        case 0: return 1; // 上 -> 右
                        case 1: return 0; // 右 -> 上
                        case 2: return 3; // 下 -> 左
                        case 3: return 2; // 左 -> 下
                    }
                } else {
                    // \ 型转向板
                    switch (dir) {
                        case 0: return 3; // 上 -> 左
                        case 1: return 2; // 右 -> 下
                        case 2: return 1; // 下 -> 右
                        case 3: return 0; // 左 -> 上
                    }
                }
                return dir;
            }
        }




