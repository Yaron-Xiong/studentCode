package com.yaronxiong.algorithms.leetcode.weekly.w395;

public class L3 {
    public static void main(String[] args) {
        L3 l3 = new L3();
        System.out.println(l3.minEnd(2, 7));
    }

    public long minEnd(int n, int x) {
        if (n == 1) {
            return x;
        }
        //先计算右边
        //先找到x右边第一个零的位置
        long ans = 0L;
        long base = 1;
        char[] nBinaryArray = Integer.toBinaryString(n - 1).toCharArray();
        char[] binaryArray = Integer.toBinaryString(x).toCharArray();
        int nIndex = nBinaryArray.length - 1;
        for (int i = binaryArray.length - 1; i >= 0; i--) {
            if (binaryArray[i] == '1' || (nIndex >= 0 && nBinaryArray[nIndex--] == '1')) {
                ans += base;
            }
            base *= 2;
        }
        while (nIndex >= 0) {
            if (nBinaryArray[nIndex--] == '1') {
                ans += base;
            }
            base *= 2;
        }
        return ans;
    }
}
