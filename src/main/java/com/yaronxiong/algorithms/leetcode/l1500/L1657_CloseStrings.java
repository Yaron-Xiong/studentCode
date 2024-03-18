package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.Arrays;

/**
 * 1657. 确定两个字符串是否接近
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
 * <p>
 * 操作 1：交换任意两个 现有 字符。
 * 例如，abcde -> aecdb
 * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
 * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
 * 你可以根据需要对任意一个字符串多次使用这两种操作。
 * <p>
 * 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "abc", word2 = "bca"
 * 输出：true
 * 解释：2 次操作从 word1 获得 word2 。
 * 执行操作 1："abc" -> "acb"
 * 执行操作 1："acb" -> "bca"
 * 示例 2：
 * <p>
 * 输入：word1 = "a", word2 = "aa"
 * 输出：false
 * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
 * 示例 3：
 * <p>
 * 输入：word1 = "cabbba", word2 = "abbccc"
 * 输出：true
 * 解释：3 次操作从 word1 获得 word2 。
 * 执行操作 1："cabbba" -> "caabbb"
 * 执行操作 2："caabbb" -> "baaccc"
 * 执行操作 2："baaccc" -> "abbccc"
 * 示例 4：
 * <p>
 * 输入：word1 = "cabbba", word2 = "aabbss"
 * 输出：false
 * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
 * <p>
 * 提示：
 * <p>
 * 1 <= word1.length, word2.length <= 105
 * word1 和 word2 仅包含小写英文字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/determine-if-two-strings-are-close/description/?envType=daily-question&envId=2023-11-30">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1657_CloseStrings {
    public static void main(String[] args) {
        L1657_CloseStrings l1657CloseStrings = new L1657_CloseStrings();
        System.out.println(l1657CloseStrings.closeStrings("cabbba", "aabbss"));
    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        int mask1 = 0;
        int mask2 = 0;
        int n = word1.length();
        char[] word1CharArray = word1.toCharArray();
        char[] word2CharArray = word2.toCharArray();
        for (int i = 0; i < n; i++) {
            int index1 = word1CharArray[i] - 'a';
            int index2 = word2CharArray[i] - 'a';
            cnt1[index1]++;
            mask1 |= 1 << index1;
            cnt2[index2]++;
            mask2 |= 1 << index2;
        }
        if (mask1 != mask2) {
            return false;
        }
        Arrays.sort(cnt1);
        Arrays.sort(cnt2);
        return Arrays.equals(cnt1, cnt2);
    }
}
