package com.yaronxiong.algorithms.leetcode.l0;

public class L231_IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
