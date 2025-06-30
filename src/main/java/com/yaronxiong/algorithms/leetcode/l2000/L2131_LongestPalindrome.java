package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2131. 连接两字母单词得到的最长回文串
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串数组 words 。words 中每个元素都是一个包含 两个 小写英文字母的单词。
 * <p>
 * 请你从 words 中选择一些元素并按 任意顺序 连接它们，并得到一个 尽可能长的回文串 。每个元素 至多 只能使用一次。
 * <p>
 * 请你返回你能得到的最长回文串的 长度 。如果没办法得到任何一个回文串，请你返回 0 。
 * <p>
 * 回文串 指的是从前往后和从后往前读一样的字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["lc","cl","gg"]
 * 输出：6
 * 解释：一个最长的回文串为 "lc" + "gg" + "cl" = "lcggcl" ，长度为 6 。
 * "clgglc" 是另一个可以得到的最长回文串。
 * 示例 2：
 * <p>
 * 输入：words = ["ab","ty","yt","lc","cl","ab"]
 * 输出：8
 * 解释：最长回文串是 "ty" + "lc" + "cl" + "yt" = "tylcclyt" ，长度为 8 。
 * "lcyttycl" 是另一个可以得到的最长回文串。
 * 示例 3：
 * <p>
 * 输入：words = ["cc","ll","xx"]
 * 输出：2
 * 解释：最长回文串是 "cc" ，长度为 2 。
 * "ll" 是另一个可以得到的最长回文串。"xx" 也是。
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 105
 * words[i].length == 2
 * words[i] 仅包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-number-of-operations-to-make-array-continuous/description/?envType=daily-question&envId=2024-04-08">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2131_LongestPalindrome {
    public static void main(String[] args) {
        L2131_LongestPalindrome l2131LongestPalindrome = new L2131_LongestPalindrome();
        //System.out.println(l2131LongestPalindrome.longestPalindrome(new String[]{"lc", "cl", "gg"}));
        System.out.println(l2131LongestPalindrome.longestPalindrome(new String[]{"dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc"
        }));
    }

    public int longestPalindrome(String[] words) {
        //挑组
        int[][] arr = new int[26][26];
        for (String word : words) {
            arr[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;
        }
        int ans = 0;
        int special = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i][i] % 2 != 0) {
                arr[i][i]--;
                special++;
            }
            ans += arr[i][i] / 2 * 4;
            for (int j = i + 1; j < 26; j++) {
                //最小组数
                int group = Math.min(arr[i][j], arr[j][i]);
                ans += group * 4;
            }
        }
        return ans + (special > 0 ? 2 : 0);
    }
}
