package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1578. 使绳子变成彩色的最短时间
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * Alice 把 n 个气球排列在一根绳子上。给你一个下标从 0 开始的字符串 colors ，其中 colors[i] 是第 i 个气球的颜色。
 * <p>
 * Alice 想要把绳子装扮成 五颜六色的 ，且她不希望两个连续的气球涂着相同的颜色，所以她喊来 Bob 帮忙。Bob 可以从绳子上移除一些气球使绳子变成 彩色 。给你一个 下标从 0 开始 的整数数组 neededTime ，其中 neededTime[i] 是 Bob 从绳子上移除第 i 个气球需要的时间（以秒为单位）。
 * <p>
 * 返回 Bob 使绳子变成 彩色 需要的 最少时间 。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：colors = "abaac", neededTime = [1,2,3,4,5]
 * 输出：3
 * 解释：在上图中，'a' 是蓝色，'b' 是红色且 'c' 是绿色。
 * Bob 可以移除下标 2 的蓝色气球。这将花费 3 秒。
 * 移除后，不存在两个连续的气球涂着相同的颜色。总时间 = 3 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：colors = "abc", neededTime = [1,2,3]
 * 输出：0
 * 解释：绳子已经是彩色的，Bob 不需要从绳子上移除任何气球。
 * 示例 3：
 * <p>
 * <p>
 * 输入：colors = "aabaa", neededTime = [1,2,3,4,1]
 * 输出：2
 * 解释：Bob 会移除下标 0 和下标 4 处的气球。这两个气球各需要 1 秒来移除。
 * 移除后，不存在两个连续的气球涂着相同的颜色。总时间 = 1 + 1 = 2 。
 * <p>
 * 提示：
 * <p>
 * n == colors.length == neededTime.length
 * 1 <= n <= 105
 * 1 <= neededTime[i] <= 104
 * colors 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-number-of-coins-you-can-get/description/?envType=daily-question&envId=2025-01-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1578_MinCost {
    public static void main(String[] args) {
        L1578_MinCost l1578MinCost = new L1578_MinCost();
        System.out.println(l1578MinCost.minCost("aabaa", new int[]{1, 2, 3, 4, 1}));
    }

    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        int tempSum = neededTime[0];
        int maxValue = neededTime[0];
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i-1)) {
                tempSum += neededTime[i];
                maxValue = Math.max(neededTime[i], maxValue);
            } else {
                ans += tempSum - maxValue;
                tempSum = neededTime[i];
                maxValue = neededTime[i];
            }
        }
        ans += tempSum - maxValue;
        return ans;
    }
}
