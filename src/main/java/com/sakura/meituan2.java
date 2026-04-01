package com.sakura;
import java.util.Scanner;

public class meituan2 {
    public static void main(String[] args) {
        //解决交替子序列问题
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            // 动态规划：dp[0]表示以奇数位置结束的最大F值，dp[1]表示以偶数位置结束的最大F值
            long[] dp = new long[2];
            dp[0] = a[0];
            dp[1] = Long.MIN_VALUE;

            for (int i = 1; i < n; i++) {
                long prev0 = dp[0];
                long prev1 = dp[1];

                dp[0] = Math.max(prev0, (prev1 == Long.MIN_VALUE ? a[i] : a[i] - prev1));
                dp[1] = Math.max(prev1, prev0 - a[i]);
            }
            System.out.println(dp[0]);
        }
    }
}