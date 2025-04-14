package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2278. 字母在字符串中的百分比
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s 和一个字符 letter ，返回在 s 中等于 letter 字符所占的 百分比 ，向下取整到最接近的百分比。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "foobar", letter = "o"
 * 输出：33
 * 解释：
 * 等于字母 'o' 的字符在 s 中占到的百分比是 2 / 6 * 100% = 33% ，向下取整，所以返回 33 。
 * 示例 2：
 * <p>
 * 输入：s = "jjjj", letter = "k"
 * 输出：0
 * 解释：
 * 等于字母 'k' 的字符在 s 中占到的百分比是 0% ，所以返回 0 。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 由小写英文字母组成
 * letter 是一个小写英文字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/percentage-of-letter-in-string/description/?envType=daily-question&envId=2025-03-31">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2278_PercentageLetter {
    public static void main(String[] args) {
        L2278_PercentageLetter l2278PercentageLetter = new L2278_PercentageLetter();
        System.out.println(l2278PercentageLetter.percentageLetter("foobar", 'o'));
    }

    public int percentageLetter(String s, char letter) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                cnt++;
            }
        }
        return (int) (((double) cnt / s.length()) * 100);
    }
}
