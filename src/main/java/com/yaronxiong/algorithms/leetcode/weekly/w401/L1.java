package com.yaronxiong.algorithms.leetcode.weekly.w401;

public class L1 {
    public static void main(String[] args) {
        L1 l1 = new L1();
        System.out.println(l1.numberOfChild(3, 3));
    }

    public int numberOfChild(int n, int k) {
        int order = k / (n - 1);
        k = k - ((n - 1) * order);
        if (order % 2 == 0) {
            //正序
            return k;
        }
        return n - k - 1;
    }
}
