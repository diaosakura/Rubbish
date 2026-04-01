package com.sakura;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class meituan1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();
            long sum = 0;
            List<long[]> gains = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                sum += x;
                long g1 = x - (x / 2);
                long g2 = Math.max(0, k);
                long g3 = x - (x / 2) + k;
                gains.add(new long[]{g3, 1, 1});
                gains.add(new long[]{g1, 1, 0});
                gains.add(new long[]{g2, 0, 1});
            }
            gains.sort((o1, o2) -> Long.compare(o2[0], o1[0]));
            for (long[] gain : gains) {
                if (a == 0 && b == 0) break;
                long g = gain[0];
                int needA = (int) gain[1];
                int needB = (int) gain[2];
                if (needA <= a && needB <= b) {
                    sum -= g;
                    a -= needA;
                    b -= needB;
                }
            }
            System.out.println(sum);
        }
    }
}
