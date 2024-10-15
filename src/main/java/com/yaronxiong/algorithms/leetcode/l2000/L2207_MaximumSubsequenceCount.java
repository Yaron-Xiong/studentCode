package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2207. 字符串中最多数目的子序列
 * 算术评级: 4
 * 第 74 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1550
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的字符串 text 和另一个下标从 0 开始且长度为 2 的字符串 pattern ，两者都只包含小写英文字母。
 * <p>
 * 你可以在 text 中任意位置插入 一个 字符，这个插入的字符必须是 pattern[0] 或者 pattern[1] 。注意，这个字符可以插入在 text 开头或者结尾的位置。
 * <p>
 * 请你返回插入一个字符后，text 中最多包含多少个等于 pattern 的 子序列 。
 * <p>
 * 子序列 指的是将一个字符串删除若干个字符后（也可以不删除），剩余字符保持原本顺序得到的字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "abdcdbc", pattern = "ac"
 * 输出：4
 * 解释：
 * 如果我们在 text[1] 和 text[2] 之间添加 pattern[0] = 'a' ，那么我们得到 "abadcdbc" 。那么 "ac" 作为子序列出现 4 次。
 * 其他得到 4 个 "ac" 子序列的方案还有 "aabdcdbc" 和 "abdacdbc" 。
 * 但是，"abdcadbc" ，"abdccdbc" 和 "abdcdbcc" 这些字符串虽然是可行的插入方案，但是只出现了 3 次 "ac" 子序列，所以不是最优解。
 * 可以证明插入一个字符后，无法得到超过 4 个 "ac" 子序列。
 * 示例 2：
 * <p>
 * 输入：text = "aabb", pattern = "ab"
 * 输出：6
 * 解释：
 * 可以得到 6 个 "ab" 子序列的部分方案为 "aaabb" ，"aaabb" 和 "aabbb" 。
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 105
 * pattern.length == 2
 * text 和 pattern 都只包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximize-number-of-subsequences-in-a-string/description/?envType=daily-question&envId=2024-09-24">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2207_MaximumSubsequenceCount {
    public static void main(String[] args) {
        L2207_MaximumSubsequenceCount l2207MaximumSubsequenceCount = new L2207_MaximumSubsequenceCount();
        System.out.println(l2207MaximumSubsequenceCount.maximumSubsequenceCount("zigfj", "ju"));
    }

    public long maximumSubsequenceCount(String text, String pattern) {
        long ans = 0;
        long cntA = 0;
        long cntB = 0;
        char[] charArray = text.toCharArray();
        char a = pattern.charAt(0);
        char b = pattern.charAt(1);
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == b) {
                ans += cntA;
                cntB++;
            }
            if (text.charAt(i) == a) {
                cntA++;
            }
        }
        return ans + Math.max(cntA, cntB);
    }

}
