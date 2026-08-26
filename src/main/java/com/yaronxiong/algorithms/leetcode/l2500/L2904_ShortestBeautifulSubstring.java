package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2904. 最短且字典序最小的美丽子字符串
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个二进制字符串 s 和一个正整数 k 。
 * <p>
 * 如果 s 的某个子字符串中 1 的个数恰好等于 k ，则称这个子字符串是一个 美丽子字符串 。
 * <p>
 * 令 len 等于 最短 美丽子字符串的长度。
 * <p>
 * 返回长度等于 len 且字典序 最小 的美丽子字符串。如果 s 中不含美丽子字符串，则返回一个 空 字符串。
 * <p>
 * 对于相同长度的两个字符串 a 和 b ，如果在 a 和 b 出现不同的第一个位置上，a 中该位置上的字符严格大于 b 中的对应字符，则认为字符串 a 字典序 大于 字符串 b 。
 * <p>
 * 例如，"abcd" 的字典序大于 "abcc" ，因为两个字符串出现不同的第一个位置对应第四个字符，而 d 大于 c 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "100011001", k = 3
 * 输出："11001"
 * 解释：示例中共有 7 个美丽子字符串：
 * 1. 子字符串 "100011001" 。
 * 2. 子字符串 "100011001" 。
 * 3. 子字符串 "100011001" 。
 * 4. 子字符串 "100011001" 。
 * 5. 子字符串 "100011001" 。
 * 6. 子字符串 "100011001" 。
 * 7. 子字符串 "100011001" 。
 * 最短美丽子字符串的长度是 5 。
 * 长度为 5 且字典序最小的美丽子字符串是子字符串 "11001" 。
 * 示例 2：
 * <p>
 * 输入：s = "1011", k = 2
 * 输出："11"
 * 解释：示例中共有 3 个美丽子字符串：
 * 1. 子字符串 "1011" 。
 * 2. 子字符串 "1011" 。
 * 3. 子字符串 "1011" 。
 * 最短美丽子字符串的长度是 2 。
 * 长度为 2 且字典序最小的美丽子字符串是子字符串 "11" 。
 * 示例 3：
 * <p>
 * 输入：s = "000", k = 1
 * 输出：""
 * 解释：示例中不存在美丽子字符串。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * 1 <= k <= s.length
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/shortest-and-lexicographically-smallest-beautiful-string/description/?envType=daily-question&envId=2026-08-26">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2904_ShortestBeautifulSubstring {
    public static void main(String[] args) {
        L2904_ShortestBeautifulSubstring l2904ShortestBeautifulSubstring = new L2904_ShortestBeautifulSubstring();
        System.out.println(l2904ShortestBeautifulSubstring.shortestBeautifulSubstring("100011001", 3));
    }

    public String shortestBeautifulSubstring(String s, int k) {
        int left = -1;
        int cntK = 0;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cntK++;
            }
            while (left + 1 < s.length() && (cntK > k || s.charAt(left + 1) == '0')) {
                left++;
                if (s.charAt(left) == '1') {
                    cntK--;
                }
            }
            if (cntK == k) {
                String temp = s.substring(left + 1, i + 1);
                if (ans.isEmpty() || i - left < ans.length()) {
                    ans = temp;
                } else if (i - left == ans.length() && temp.compareTo(ans) < 0) {
                    ans = temp;
                }
            }
        }
        return ans;
    }
}
