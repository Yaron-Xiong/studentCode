package com.accompnay.TopicAlgorithms.leetcode.l2000;

/**
 * 2645. 构造有效字符串的最少插入数
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 word ，你可以向其中任何位置插入 "a"、"b" 或 "c" 任意次，返回使 word 有效 需要插入的最少字母数。
 * <p>
 * 如果字符串可以由 "abc" 串联多次得到，则认为该字符串 有效 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "b"
 * 输出：2
 * 解释：在 "b" 之前插入 "a" ，在 "b" 之后插入 "c" 可以得到有效字符串 "abc" 。
 * 示例 2：
 * <p>
 * 输入：word = "aaa"
 * 输出：6
 * 解释：在每个 "a" 之后依次插入 "b" 和 "c" 可以得到有效字符串 "abcabcabc" 。
 * 示例 3：
 * <p>
 * 输入：word = "abc"
 * 输出：0
 * 解释：word 已经是有效字符串，不需要进行修改。
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 50
 * word 仅由字母 "a"、"b" 和 "c" 组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-additions-to-make-valid-string/description/?envType=daily-question&envId=2024-01-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2645_AddMinimum {
    public static void main(String[] args) {
        L2645_AddMinimum l2645AddMinimum = new L2645_AddMinimum();
        System.out.println(l2645AddMinimum.addMinimum("aaaaac"));
    }

    public int addMinimum(String word) {
        int t = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i - 1) > word.charAt(i)) {
                t++;
            }
        }
        return 3 * t - word.length();
    }
}
