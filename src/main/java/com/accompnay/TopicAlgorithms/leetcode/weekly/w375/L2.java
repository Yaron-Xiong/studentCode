package com.accompnay.TopicAlgorithms.leetcode.weekly.w375;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class L2 {
    public static void main(String[] args) {
        L2 l2 = new L2();
        System.out.println(l2.getGoodIndices(new int[][]{{2, 3, 3, 10}, {3, 3, 3, 1}, {6, 1, 1, 4}}, 2));
    }

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<>();
        //((aibi % 10)ci) % mi == target
        for (int i = 0; i < variables.length; i++) {
            int[] variable = variables[i];
            if (pow(pow(variable[0], variable[1], variable[2]), variable[2], variable[3]) == target) {
                ans.add(i);
            }
        }
        return ans;
    }

    private long pow(long a, int b, int c) {
        if (b == 1) {
            return a % c;
        }
        if (b % 2 != 0) {
            long pow = pow(a, b / 2, c) % c;
            long pow1 = pow(a, (b / 2) + 1, c) % c;
            return (pow * pow1) % c;
        } else {
            long pow = pow(a, b / 2, c) % c;
            return (pow * pow) % c;
        }
    }
}
