package com.yaronxiong.algorithms.leetcode.weekly.w381;


public class L1 {
    public static void main(String[] args) {
        L1 l1 = new L1();
        int xycdefghij = l1.minimumPushes("xycdefghij");
        System.out.println(xycdefghij);
    }
    public int minimumPushes(String word) {
        //一共是8键
        int length = word.length();
        int ans = 0;
        int a = 1;
        while (length > 0) {
            int size = Math.min(length, 8);
            ans += size * a;
            a++;
            length -= size;
            if (length == 0) {
                break;
            }
        }
        return ans;
    }
}
