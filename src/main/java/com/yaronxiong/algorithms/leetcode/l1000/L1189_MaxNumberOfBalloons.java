package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1189. “气球” 的最大数量
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * <p>
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "nlaebolko"
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：text = "leetcode"
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 104
 * text 全部由小写英文字母组成
 * <p>
 * <p>
 * 注意：本题与 2287. 重排字符形成目标字符串 相同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-number-of-balloons/description/?envType=daily-question&envId=2026-06-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1189_MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] chars = new int[26];
        for (char c : text.toCharArray()) {
            chars[c - 'a']++;
        }
        //balloon
        int ans = chars['b' - 'a'];
        ans = Math.min(ans, chars[0]);
        ans = Math.min(ans, chars['l' - 'a'] / 2);
        ans = Math.min(ans, chars['o' - 'a'] / 2);
        ans = Math.min(ans, chars['n' - 'a']);
        return ans;
    }
}
