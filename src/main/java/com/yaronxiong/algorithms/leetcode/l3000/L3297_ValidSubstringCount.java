package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3297. 统计重新排列后包含另一个字符串的子字符串数目 I
 * 算术评级: 6
 * 第 416 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1847
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个字符串 word1 和 word2 。
 * <p>
 * 如果一个字符串 x 重新排列后，word2 是重排字符串的 前缀，那么我们称字符串 x 是 合法的 。
 * <p>
 * 请你返回 word1 中 合法子字符串的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "bcca", word2 = "abc"
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 唯一合法的子字符串是 "bcca" ，可以重新排列得到 "abcc" ，"abc" 是它的前缀。
 * <p>
 * 示例 2：
 * <p>
 * 输入：word1 = "abcabc", word2 = "abc"
 * <p>
 * 输出：10
 * <p>
 * 解释：
 * <p>
 * 除了长度为 1 和 2 的所有子字符串都是合法的。
 * <p>
 * 示例 3：
 * <p>
 * 输入：word1 = "abcabc", word2 = "aaabc"
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 1 <= word1.length <= 105
 * 1 <= word2.length <= 104
 * word1 和 word2 都只包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-i/description/?envType=daily-question&envId=2025-01-09">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3297_ValidSubstringCount {
    public static void main(String[] args) {
        L3297_ValidSubstringCount l3297ValidSubstringCount = new L3297_ValidSubstringCount();
        System.out.println(l3297ValidSubstringCount.validSubstringCount("abcabc", "abc"));
    }

    public long validSubstringCount(String word1, String word2) {
        int[] counts = new int[26];
        int cnt = 0;
        for (char c : word2.toCharArray()) {
            if (++counts[c - 'a'] == 1) {
                cnt++;
            }
        }
        int left = 0;
        int right = 0;
        long ans = 0;
        int[] win = new int[26];
        while (right < word1.length()) {
            //加入当前节点
            int rightIndex = word1.charAt(right) - 'a';
            if (++win[rightIndex] == counts[rightIndex]) {
                //满足了一个字符
                cnt--;
            }
            while (cnt == 0) {
                //左边界向右边移动
                int leftIndex = word1.charAt(left) - 'a';
                if (win[leftIndex]-- == counts[leftIndex]) {
                    cnt++;
                }
                left++;
            }
            ans += left;
            right++;
        }
        return ans;
    }

}
