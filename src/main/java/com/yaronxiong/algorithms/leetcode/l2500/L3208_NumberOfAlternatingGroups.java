package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 3208. 交替组 II
 * 算术评级: 5
 * 第 134 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1722
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 colors 和一个整数 k ，colors表示一个由红色和蓝色瓷砖组成的环，第 i 块瓷砖的颜色为 colors[i] ：
 * <p>
 * colors[i] == 0 表示第 i 块瓷砖的颜色是 红色 。
 * colors[i] == 1 表示第 i 块瓷砖的颜色是 蓝色 。
 * 环中连续 k 块瓷砖的颜色如果是 交替 颜色（也就是说除了第一块和最后一块瓷砖以外，中间瓷砖的颜色与它 左边 和 右边 的颜色都不同），那么它被称为一个 交替 组。
 * <p>
 * 请你返回 交替 组的数目。
 * <p>
 * 注意 ，由于 colors 表示一个 环 ，第一块 瓷砖和 最后一块 瓷砖是相邻的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：colors = [0,1,0,1,0], k = 3
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 交替组包括：
 * <p>
 * 示例 2：
 * <p>
 * 输入：colors = [0,1,0,0,1,0,1], k = 6
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 交替组包括：
 * <p>
 * 示例 3：
 * <p>
 * 输入：colors = [1,1,0,1], k = 4
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 提示：
 * <p>
 * 3 <= colors.length <= 105
 * 0 <= colors[i] <= 1
 * 3 <= k <= colors.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/alternating-groups-ii/description/?envType=daily-question&envId=2024-11-27">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3208_NumberOfAlternatingGroups {
    public static void main(String[] args) {
        L3208_NumberOfAlternatingGroups l3208NumberOfAlternatingGroups = new L3208_NumberOfAlternatingGroups();
        System.out.println(l3208NumberOfAlternatingGroups.numberOfAlternatingGroups(new int[]{0, 1, 0, 0, 1, 0, 1}, 6));
    }

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int preSum = 1;
        int ans = 0;
        int n = colors.length;
        for (int i = 1; i < n * 2; i++) {
            if (colors[i % n] == colors[(i - 1) % n]) {
                preSum = 0;
            }
            preSum++;
            if (i >= n && preSum >= k) {
                ans++;
            }
        }
        return ans;
    }
}
