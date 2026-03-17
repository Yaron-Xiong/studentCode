package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1545. 找出第 N 个二进制字符串中的第 K 位
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个正整数 n 和 k，二进制字符串  Sn 的形成规则如下：
 * <p>
 * S1 = "0"
 * 当 i > 1 时，Si = Si-1 + "1" + reverse(invert(Si-1))
 * 其中 + 表示串联操作，reverse(x) 返回反转 x 后得到的字符串，而 invert(x) 则会翻转 x 中的每一位（0 变为 1，而 1 变为 0）。
 * <p>
 * 例如，符合上述描述的序列的前 4 个字符串依次是：
 * <p>
 * S1 = "0"
 * S2 = "011"
 * S3 = "0111001"
 * S4 = "011100110110001"
 * 请你返回  Sn 的 第 k 位字符 ，题目数据保证 k 一定在 Sn 长度范围以内。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, k = 1
 * 输出："0"
 * 解释：S3 为 "0111001"，其第 1 位为 "0" 。
 * 示例 2：
 * <p>
 * 输入：n = 4, k = 11
 * 输出："1"
 * 解释：S4 为 "011100110110001"，其第 11 位为 "1" 。
 * 示例 3：
 * <p>
 * 输入：n = 1, k = 1
 * 输出："0"
 * 示例 4：
 * <p>
 * 输入：n = 2, k = 3
 * 输出："1"
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= 2n - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-kth-bit-in-nth-binary-string/description/?envType=daily-question&envId=2026-03-03">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1545_FindKthBit {
    public static void main(String[] args) {
        L1545_FindKthBit l1545FindKthBit = new L1545_FindKthBit();
        char kthBit = l1545FindKthBit.findKthBit(4, 11);
        System.out.println(kthBit);
    }
    public char findKthBit(int n, int k) {
        StringBuilder s = new StringBuilder("0");
        while (--n > 0) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                temp.append(s.charAt(i) == '0' ? '1' : '0');
            }
            s.append("1").append(temp.reverse());
        }
        return s.charAt(k - 1);
    }
}
