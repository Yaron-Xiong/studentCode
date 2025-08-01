package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1957. 删除字符使字符串变好
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 一个字符串如果没有 三个连续 相同字符，那么它就是一个 好字符串 。
 * <p>
 * 给你一个字符串 s ，请你从 s 删除 最少 的字符，使它变成一个 好字符串 。
 * <p>
 * 请你返回删除后的字符串。题目数据保证答案总是 唯一的 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leeetcode"
 * 输出："leetcode"
 * 解释：
 * 从第一组 'e' 里面删除一个 'e' ，得到 "leetcode" 。
 * 没有连续三个相同字符，所以返回 "leetcode" 。
 * 示例 2：
 * <p>
 * 输入：s = "aaabaaaa"
 * 输出："aabaa"
 * 解释：
 * 从第一组 'a' 里面删除一个 'a' ，得到 "aabaaaa" 。
 * 从第二组 'a' 里面删除两个 'a' ，得到 "aabaa" 。
 * 没有连续三个相同字符，所以返回 "aabaa" 。
 * 示例 3：
 * <p>
 * 输入：s = "aab"
 * 输出："aab"
 * 解释：没有连续三个相同字符，所以返回 "aab" 。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 只包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/delete-characters-to-make-fancy-string/description/?envType=daily-question&envId=2025-07-21">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1557_MakeFancyString {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                cnt = 0;
            }
            cnt++;
            if (cnt < 3) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
