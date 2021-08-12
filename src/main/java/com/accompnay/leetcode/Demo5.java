package com.accompnay.leetcode;

public class Demo5 {
    public static void main(String[] args) {
        Demo5 demo2 = new Demo5();
        int plan = demo2.paintingPlan(6, 24);
        System.out.println(plan);
    }

    public int paintingPlan(int n, int k) {
        int count = 0;
        if (k == 0 || k == n * n) {
            return 1;
        }
        if (k < n) {
            return count;
        }
        int max = (n-1)*2;
        for (int i = 1; i <= max; i++) {
            int x = 0;
            int y = i;
            int grid = i * n;
            while (x <= y) {
                if (grid - (x * y) == k) {
                    int a = C(x, n);
                    int b = C(y, n);
                    int temp = a*b;
                    if (x != y) {
                        temp *= 2;
                    }
                    count += temp;
                }
                x++;
                y--;
            }
        }
        return count;
    }


    public int C(int x, int y) {
        if (x == 0) return 1;
        int n = 1;
        for (int i = 0; i < x; i++) {
            n *= (y - i);
        }
        for (int i = 1; i <= x; i++) {
            n /= i;
        }
        return n;
    }

}
