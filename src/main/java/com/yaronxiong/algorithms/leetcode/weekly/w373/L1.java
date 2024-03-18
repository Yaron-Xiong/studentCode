package com.yaronxiong.algorithms.leetcode.weekly.w373;

public class L1 {
    public static void main(String[] args) {
        L1 l1 = new L1();
        System.out.println(l1.areSimilar(new int[][]{{1, 2, 1, 2}, {5, 5, 5, 5}, {6, 3, 6, 3}}, 2));
    }

    public boolean areSimilar(int[][] mat, int k) {
        k %= mat[0].length;
        for (int[] ints : mat) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] != ints[(j + k) % ints.length]) {
                    return false;
                }
            }
        }
        return true;
    }

}
