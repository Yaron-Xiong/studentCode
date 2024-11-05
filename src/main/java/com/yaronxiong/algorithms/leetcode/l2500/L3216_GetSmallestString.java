package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 3216. 交换后字典序最小的字符串
 * 算术评级: 2
 * 第 406 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1243
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个仅由数字组成的字符串 s，在最多交换一次 相邻 且具有相同 奇偶性 的数字后，返回可以得到的
 * 字典序最小的字符串
 * 。
 * <p>
 * 如果两个数字都是奇数或都是偶数，则它们具有相同的奇偶性。例如，5 和 9、2 和 4 奇偶性相同，而 6 和 9 奇偶性不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "45320"
 * <p>
 * 输出： "43520"
 * <p>
 * 解释：
 * <p>
 * s[1] == '5' 和 s[2] == '3' 都具有相同的奇偶性，交换它们可以得到字典序最小的字符串。
 * <p>
 * 示例 2：
 * <p>
 * 输入： s = "001"
 * <p>
 * 输出： "001"
 * <p>
 * 解释：
 * <p>
 * 无需进行交换，因为 s 已经是字典序最小的。
 * <p>
 * 提示：
 * <p>
 * 2 <= s.length <= 100
 * s 仅由数字组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/lexicographically-smallest-string-after-a-swap/?envType=daily-question&envId=2024-10-30">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3216_GetSmallestString {

    public static void main(String[] args) {
        L3216_GetSmallestString l3216GetSmallestString = new L3216_GetSmallestString();
        System.out.println(l3216GetSmallestString.getSmallestString("131"));
    }

    public String getSmallestString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            int v1 = chars[i] - '0';
            int v2 = chars[i - 1] - '0';
            if (v1 % 2 != v2 % 2) {
                continue;
            }
            if (v1 < v2) {
                char temp = chars[i];
                chars[i] = chars[i - 1];
                chars[i - 1] = temp;
                return new String(chars);
            }
        }
        return new String(chars);
    }

    public String getSmallestString2(String s) {
        //相同奇偶性执行排序
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j + 1 < chars.length; j++) {
                int v1 = chars[j] - '0';
                int v2 = chars[j + 1] - '0';
                if (v1 % 2 != v2 % 2) {
                    break;
                }
                if (v1 > v2) {
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }
        return new String(chars);
    }
}
