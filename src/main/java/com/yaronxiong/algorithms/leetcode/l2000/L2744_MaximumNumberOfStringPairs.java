package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2744. 最大字符串配对数目
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的数组 words ，数组中包含 互不相同 的字符串。
 * <p>
 * 如果字符串 words[i] 与字符串 words[j] 满足以下条件，我们称它们可以匹配：
 * <p>
 * 字符串 words[i] 等于 words[j] 的反转字符串。
 * 0 <= i < j < words.length
 * 请你返回数组 words 中的 最大 匹配数目。
 * <p>
 * 注意，每个字符串最多匹配一次。
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["cd","ac","dc","ca","zz"]
 * 输出：2
 * 解释：在此示例中，我们可以通过以下方式匹配 2 对字符串：
 * - 我们将第 0 个字符串与第 2 个字符串匹配，因为 word[0] 的反转字符串是 "dc" 并且等于 words[2]。
 * - 我们将第 1 个字符串与第 3 个字符串匹配，因为 word[1] 的反转字符串是 "ca" 并且等于 words[3]。
 * 可以证明最多匹配数目是 2 。
 * 示例 2：
 * <p>
 * 输入：words = ["ab","ba","cc"]
 * 输出：1
 * 解释：在此示例中，我们可以通过以下方式匹配 1 对字符串：
 * - 我们将第 0 个字符串与第 1 个字符串匹配，因为 words[1] 的反转字符串 "ab" 与 words[0] 相等。
 * 可以证明最多匹配数目是 1 。
 * 示例 3：
 * <p>
 * 输入：words = ["aa","ab"]
 * 输出：0
 * 解释：这个例子中，无法匹配任何字符串。
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 50
 * words[i].length == 2
 * words 包含的字符串互不相同。
 * words[i] 只包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-maximum-number-of-string-pairs/description/?envType=daily-question&envId=2024-01-17">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2744_MaximumNumberOfStringPairs {
    public int maximumNumberOfStringPairs(String[] words) {
        boolean[] visit = new boolean[words.length];
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (visit[j]) {
                    continue;
                }
                if (check(words[i], words[j])) {
                    visit[i] = true;
                    visit[j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }

    public boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int n = chars1.length;
        for (int z = 0; z < n; z++) {
            if (chars1[z] != chars2[n - z - 1]) {
                return false;
            }
        }
        return true;
    }
}
