package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3304. 找出第 K 个字符 I
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * Alice 和 Bob 正在玩一个游戏。最初，Alice 有一个字符串 word = "a"。
 * <p>
 * 给定一个正整数 k。
 * <p>
 * 现在 Bob 会要求 Alice 执行以下操作 无限次 :
 * <p>
 * 将 word 中的每个字符 更改 为英文字母表中的 下一个 字符来生成一个新字符串，并将其 追加 到原始的 word。
 * 例如，对 "c" 进行操作生成 "cd"，对 "zb" 进行操作生成 "zbac"。
 * <p>
 * 在执行足够多的操作后， word 中 至少 存在 k 个字符，此时返回 word 中第 k 个字符的值。
 * <p>
 * 注意，在操作中字符 'z' 可以变成 'a'。
 * <p>
 * 示例 1:
 * <p>
 * 输入：k = 5
 * <p>
 * 输出："b"
 * <p>
 * 解释：
 * <p>
 * 最初，word = "a"。需要进行三次操作:
 * <p>
 * 生成的字符串是 "b"，word 变为 "ab"。
 * 生成的字符串是 "bc"，word 变为 "abbc"。
 * 生成的字符串是 "bccd"，word 变为 "abbcbccd"。
 * 示例 2:
 * <p>
 * 输入：k = 10
 * <p>
 * 输出："c"
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 500
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/check-if-two-chessboard-squares-have-the-same-color/description/?envType=daily-question&envId=2024-12-03">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3304_KthCharacter {
    public static void main(String[] args) {
        L3304_KthCharacter l3304KthCharacter = new L3304_KthCharacter();
        System.out.println(l3304KthCharacter.kthCharacter(5));
        System.out.println(l3304KthCharacter.kthCharacter(10));
    }
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");
        char[] nextGroup = new char[]{'b'};
        while (k > sb.length()) {
            sb.append(nextGroup);
            char[] newNextGroup = new char[nextGroup.length * 2];
            for (int i = 0; i < nextGroup.length; i++) {
                newNextGroup[i] = nextGroup[i];
            }
            for (int i = nextGroup.length; i < newNextGroup.length; i++) {
                char oldChar = nextGroup[i % nextGroup.length];
                char newChar;
                if (oldChar == 'z') {
                    newChar = 'a';
                } else {
                    newChar = (char) (oldChar + 1);
                }
                newNextGroup[i] = newChar;
            }
            nextGroup = newNextGroup;
        }
        return sb.charAt(k - 1);
    }
}
