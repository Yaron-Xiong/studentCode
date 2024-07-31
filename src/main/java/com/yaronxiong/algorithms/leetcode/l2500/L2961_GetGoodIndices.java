package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.ArrayList;
import java.util.List;

/**
 * 2961. 双模幂运算
 * 已解答
 * 算术评级: 3
 * 第 375 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1451
 * 相关标签
 * 相关企业
 * 给你一个下标从 0 开始的二维数组 variables ，其中 variables[i] = [ai, bi, ci, mi]，以及一个整数 target 。
 * <p>
 * 如果满足以下公式，则下标 i 是 好下标：
 * <p>
 * 0 <= i < variables.length
 * ((aibi % 10)ci) % mi == target
 * 返回一个由 好下标 组成的数组，顺序不限 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：variables = [[2,3,3,10],[3,3,3,1],[6,1,1,4]], target = 2
 * 输出：[0,2]
 * 解释：对于 variables 数组中的每个下标 i ：
 * 1) 对于下标 0 ，variables[0] = [2,3,3,10] ，(23 % 10)3 % 10 = 2 。
 * 2) 对于下标 1 ，variables[1] = [3,3,3,1] ，(33 % 10)3 % 1 = 0 。
 * 3) 对于下标 2 ，variables[2] = [6,1,1,4] ，(61 % 10)1 % 4 = 2 。
 * 因此，返回 [0,2] 作为答案。
 * 示例 2：
 * <p>
 * 输入：variables = [[39,3,1000,1000]], target = 17
 * 输出：[]
 * 解释：对于 variables 数组中的每个下标 i ：
 * 1) 对于下标 0 ，variables[0] = [39,3,1000,1000] ，(393 % 10)1000 % 1000 = 1 。
 * 因此，返回 [] 作为答案。
 * <p>
 * 提示：
 * <p>
 * 1 <= variables.length <= 100
 * variables[i] == [ai, bi, ci, mi]
 * 1 <= ai, bi, ci, mi <= 103
 * 0 <= target <= 103
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/double-modular-exponentiation/description/?envType=daily-question&envId=2024-07-30">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2961_GetGoodIndices {
    public static void main(String[] args) {
        L2961_GetGoodIndices l2961GetGoodIndices = new L2961_GetGoodIndices();
        System.out.println(l2961GetGoodIndices.getGoodIndices(new int[][]{{2, 3, 3, 10}, {3, 3, 3, 1}, {6, 1, 1, 4}}, 2));
    }

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> goodIndices = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int value = getValue(getValue(variables[i][0], variables[i][1], 10), variables[i][2], variables[i][3]);
            if (value == target) {
                goodIndices.add(i);
            }
        }
        return goodIndices;
    }

    private int getValue(int a, int b, int c) {
        long ans = 1;
        while (b > 0) {
            ans *= a;
            ans %= c;
            b--;
        }
        return (int) ans;
    }

}
