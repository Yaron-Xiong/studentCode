package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2609. 最长平衡子字符串
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个仅由 0 和 1 组成的二进制字符串 s 。
 * <p>
 * 如果子字符串中 所有的 0 都在 1 之前 且其中 0 的数量等于 1 的数量，则认为 s 的这个子字符串是平衡子字符串。请注意，空子字符串也视作平衡子字符串。
 * <p>
 * 返回  s 中最长的平衡子字符串长度。
 * <p>
 * 子字符串是字符串中的一个连续字符序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "01000111"
 * 输出：6
 * 解释：最长的平衡子字符串是 "000111" ，长度为 6 。
 * 示例 2：
 * <p>
 * 输入：s = "00111"
 * 输出：4
 * 解释：最长的平衡子字符串是 "0011" ，长度为  4 。
 * 示例 3：
 * <p>
 * 输入：s = "111"
 * 输出：0
 * 解释：除了空子字符串之外不存在其他平衡子字符串，所以答案为 0 。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 50
 * '0' <= s[i] <= '1'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-longest-balanced-substring-of-a-binary-string/description/?envType=daily-question&envId=2023-11-08">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2609_FindTheLongestBalancedSubstring {
    public static void main(String[] args) {
        L2609_FindTheLongestBalancedSubstring l2609FindTheLongestBalancedSubstring = new L2609_FindTheLongestBalancedSubstring();
        int theLongestBalancedSubstring = l2609FindTheLongestBalancedSubstring.findTheLongestBalancedSubstring("01000111");
        System.out.println(theLongestBalancedSubstring);
    }

    public int findTheLongestBalancedSubstring(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        int ans = 0;
        int index = 0;
        while (index < n) {
            int zeroNum = 0;
            int oneNum = 0;
            while (index < n && array[index] == '0') {
                zeroNum++;
                index++;
            }
            while (index < n && array[index] == '1') {
                oneNum++;
                index++;
            }
            ans = Math.max(Math.min(oneNum, zeroNum) * 2,ans);
        }
        return ans;
    }
}
