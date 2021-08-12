package com.accompnay.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Demo6 {
    public static void main(String[] args) {
        Demo6 demo6 = new Demo6();
        int i = demo6.numWays(48);
        System.out.println(i);
    }

    private Map<Integer, Integer> temp = new HashMap<>();

    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        if (temp.get(n) != null) {
            return temp.get(n);
        }
        int result = numWays(n - 1) + numWays(n - 2);
        result = result % 1000000007;
        temp.put(n, result);
        return result;
    }
}
