package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2953. 统计完全子字符串
 * 尝试过
 * 中等
 * 相关企业
 * 提示
 * 给你一个字符串 word 和一个整数 k 。
 * <p>
 * 如果 word 的一个子字符串 s 满足以下条件，我们称它是 完全字符串：
 * <p>
 * s 中每个字符 恰好 出现 k 次。
 * 相邻字符在字母表中的顺序 至多 相差 2 。也就是说，s 中两个相邻字符 c1 和 c2 ，它们在字母表中的位置相差 至多 为 2 。
 * 请你返回 word 中 完全 子字符串的数目。
 * <p>
 * 子字符串 指的是一个字符串中一段连续 非空 的字符序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "igigee", k = 2
 * 输出：3
 * 解释：完全子字符串需要满足每个字符恰好出现 2 次，且相邻字符相差至多为 2 ：igigee, igigee, igigee 。
 * 示例 2：
 * <p>
 * 输入：word = "aaabbbccc", k = 3
 * 输出：6
 * 解释：完全子字符串需要满足每个字符恰好出现 3 次，且相邻字符相差至多为 2 ：aaabbbccc, aaabbbccc, aaabbbccc, aaabbbccc, aaabbbccc, aaabbbccc 。
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 105
 * word 只包含小写英文字母。
 * 1 <= k <= word.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-complete-substrings/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2953_CountCompleteSubstrings {
    public static void main(String[] args) {
        L2953_CountCompleteSubstrings l2953CountCompleteSubstrings = new L2953_CountCompleteSubstrings();
        System.out.println(l2953CountCompleteSubstrings.countCompleteSubstrings("igigee", 2));
    }

    public int countCompleteSubstrings(String word, int k) {
        int ans = 0;
        int left = 0;
        while (left < word.length()) {
            int right = left + 1;
            while (right < word.length() && Math.abs(word.charAt(right) - word.charAt(right - 1)) <= 2) {
                right++;
            }
            ans += f(word.substring(left, right), k);
            left = right;
        }
        return ans;
    }

    private int f(String S, int k) {
        //找到s字符中，符合要求的字符串
        char[] s = S.toCharArray();
        int ans = 0;
        //m指的假定 只有m个字符 例如：当m =1 则 m =[a|b|c...] 当m =2 则有 [[a,b]|[b,c]]
        for (int m = 1; m <= 26 && k * m <= s.length; m++) {
            int[] cnt = new int[26];
            for (int right = 0; right < s.length; right++) {
                cnt[s[right] - 'a']++;
                //此时符合的左边界为 left
                int left = right + 1 - k * m;
                if (left >= 0) {
                    boolean ok = true;
                    for (int j : cnt) {
                        if (j > 0 && j != k) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) {
                        ans++;
                    }
                    cnt[s[left] - 'a']--;
                }
            }
        }
        return ans;
    }
}
