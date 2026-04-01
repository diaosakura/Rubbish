package com.sakura;

import java.util.Scanner;

public class meituan3 {
    public static void main(String[] args) {
        //小美的区间
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        //统计有多少区间长度大于1的区间满足区间最大值小于区间左右端点的值
        //区间长度大于1的区间表示区间中至少有两个元素

        //区间最大值小于区间左右端点的值表示区间中所有元素都小于区间左右端点的值

        int count = 0;
        // 遍历所有可能的区间，长度从2到n
        for (int len = 2; len <= n; len++) {
            for (int start = 0; start + len <= n; start++) {
                int end = start + len - 1;
                // 区间左右端点
                int left = a[start];
                int right = a[end];
                // 找到区间最大值
                int max = left;
                for (int i = start + 1; i <= end; i++) {
                    if (a[i] > max) {
                        max = a[i];
                    }
                }
                // 检查最大值是否小于左右端点
                if (max < left && max < right) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
