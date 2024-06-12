package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2938. 区分黑球与白球
 * 已解答
 * 算术评级: 4
 * 第 372 场周赛
 * Q2
 * 1423
 * 相关标签
 * 相关企业
 * 提示
 * 桌子上有 n 个球，每个球的颜色不是黑色，就是白色。
 * <p>
 * 给你一个长度为 n 、下标从 0 开始的二进制字符串 s，其中 1 和 0 分别代表黑色和白色的球。
 * <p>
 * 在每一步中，你可以选择两个相邻的球并交换它们。
 * <p>
 * 返回「将所有黑色球都移到右侧，所有白色球都移到左侧所需的 最小步数」。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "101"
 * 输出：1
 * 解释：我们可以按以下方式将所有黑色球移到右侧：
 * - 交换 s[0] 和 s[1]，s = "011"。
 * 最开始，1 没有都在右侧，需要至少 1 步将其移到右侧。
 * 示例 2：
 * <p>
 * 输入：s = "100"
 * 输出：2
 * 解释：我们可以按以下方式将所有黑色球移到右侧：
 * - 交换 s[0] 和 s[1]，s = "010"。
 * - 交换 s[1] 和 s[2]，s = "001"。
 * 可以证明所需的最小步数为 2 。
 * 示例 3：
 * <p>
 * 输入：s = "0111"
 * 输出：0
 * 解释：所有黑色球都已经在右侧。
 * <p>
 * 提示：
 * <p>
 * 1 <= n == s.length <= 105
 * s[i] 不是 '0'，就是 '1'。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/separate-black-and-white-balls/description/?envType=daily-question&envId=2024-06-06">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2938_MinimumSteps {
    public long minimumSteps(String s) {
        //将白色球都弄到左侧即可
        int cnt1 = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cnt1++;
            } else {
                //将0挪到1左边去
                ans += cnt1;
            }
        }
        return ans;
    }
}
