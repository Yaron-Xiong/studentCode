package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3136. 有效单词
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 有效单词 需要满足以下几个条件：
 * <p>
 * 至少 包含 3 个字符。
 * 由数字 0-9 和英文大小写字母组成。（不必包含所有这类字符。）
 * 至少 包含一个 元音字母 。
 * 至少 包含一个 辅音字母 。
 * 给你一个字符串 word 。如果 word 是一个有效单词，则返回 true ，否则返回 false 。
 * <p>
 * 注意：
 * <p>
 * 'a'、'e'、'i'、'o'、'u' 及其大写形式都属于 元音字母 。
 * 英文中的 辅音字母 是指那些除元音字母之外的字母。
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "234Adas"
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 这个单词满足所有条件。
 * <p>
 * 示例 2：
 * <p>
 * 输入：word = "b3"
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * <p>
 * 这个单词的长度少于 3 且没有包含元音字母。
 * <p>
 * 示例 3：
 * <p>
 * 输入：word = "a3$e"
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * <p>
 * 这个单词包含了 '$' 字符且没有包含辅音字母。
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 20
 * word 由英文大写和小写字母、数字、'@'、'#' 和 '$' 组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/valid-word/description/?envType=daily-question&envId=2025-07-15">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3136_IsValid {
    public static void main(String[] args) {
        L3136_IsValid l3136IsValid = new L3136_IsValid();
        boolean valid = l3136IsValid.isValid("AhI");
        System.out.println(valid);
    }

    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        int numCnt = 0;
        int vowelCnt = 0;
        for (int i = 0; i < word.length(); i++) {
            char charAt = word.charAt(i);
            if (Character.isDigit(charAt)) {
                numCnt++;
            } else if (charAt == 'a' || charAt == 'A' || charAt == 'e' || charAt == 'E' || charAt == 'i' || charAt == 'I' || charAt == 'o' || charAt == 'O' || charAt == 'u' || charAt == 'U') {
                vowelCnt++;
            } else if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return false;
            }
        }
        return vowelCnt != 0 && numCnt + vowelCnt != word.length();
    }
}
