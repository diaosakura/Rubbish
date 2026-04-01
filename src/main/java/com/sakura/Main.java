package com.sakura;

import java.util.LinkedList;
import java.util.Scanner;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        //地图上有n名玩家，每个玩家都有一个出生点pi和一个终点qi，坐标在直线上，速度为1
        //输入整数n表示玩家人数
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //第i行输入pi和qi表示第i名玩家的出生点和终点，保证p1<p2<...<pn
        int[] p = new int[n];
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
            q[i] = sc.nextInt();
        }

        // 记录玩家是否已加入小队
        boolean[] joined = new boolean[n];
        // 记录玩家是否已完成任务
        boolean[] completed = new boolean[n];
        // 记录每个玩家的贡献（作为持伞人时妖伞移动的时间）
        int[] ans = new int[n];
        // 小队队列
        LinkedList<Integer> queue = new LinkedList<>();

        // 初始时，第0号玩家是持伞人，加入队列
        queue.add(0);
        joined[0] = true;
        int current_pos = p[0];
        int u = 0; // 当前持伞人

        while (true) {
            // 计算移动距离
            int s = current_pos;
            int t = q[u];
            int distance = Math.abs(t - s);
            ans[u] += distance;
            current_pos = t;

            // 处理玩家入队：未加入且p[j]在s和t之间
            for (int j = 0; j < n; j++) {
                if (!joined[j]) {
                    // 检查p[j]是否在s和t之间（包括端点）
                    if ((s <= p[j] && p[j] <= t) || (t <= p[j] && p[j] <= s)) {
                        queue.add(j);
                        joined[j] = true;
                    }
                }
            }

            // 处理任务完成：小队中的玩家（除了u）未完成且q[j]在s和t之间
            for (int v : queue) {
                if (v != u && !completed[v]) {
                    // 检查q[v]是否在s和t之间（包括端点）
                    if ((s <= q[v] && q[v] <= t) || (t <= q[v] && q[v] <= s)) {
                        completed[v] = true;
                    }
                }
            }

            // 处理当前持伞人完成任务
            completed[u] = true;
            queue.remove(Integer.valueOf(u)); // 移出队列

            // 寻找下一个持伞人
            if (!queue.isEmpty()) {
                // 找到队列中第一个未完成的玩家
                while (!queue.isEmpty()) {
                    int v = queue.peek();
                    if (completed[v]) {
                        queue.poll();
                    } else {
                        u = v;
                        break;
                    }
                }
                // 如果队列空了，需要找未加入的玩家
                if (queue.isEmpty()) {
                    // 找最小的未加入的玩家
                    int minJ = -1;
                    for (int j = 0; j < n; j++) {
                        if (!joined[j]) {
                            minJ = j;
                            break;
                        }
                    }
                    if (minJ == -1) {
                        break; // 所有玩家都已处理
                    }
                    // 该玩家跑到current_pos，时间不计入贡献
                    queue.add(minJ);
                    joined[minJ] = true;
                    u = minJ;
                }
            } else {
                // 队列为空，找最小的未加入的玩家
                int minJ = -1;
                for (int j = 0; j < n; j++) {
                    if (!joined[j]) {
                        minJ = j;
                        break;
                    }
                }
                if (minJ == -1) {
                    break; // 所有玩家都已处理
                }
                // 该玩家跑到current_pos，时间不计入贡献
                queue.add(minJ);
                joined[minJ] = true;
                u = minJ;
            }
        }

        //输出一行n个整数，第i个整数表示第i名玩家的贡献
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

