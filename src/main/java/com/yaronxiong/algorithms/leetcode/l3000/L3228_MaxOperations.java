package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3228. 将 1 移动到末尾的最大操作次数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 二进制字符串 s。
 * <p>
 * 你可以对这个字符串执行 任意次 下述操作：
 * <p>
 * 选择字符串中的任一下标 i（ i + 1 < s.length ），该下标满足 s[i] == '1' 且 s[i + 1] == '0'。
 * 将字符 s[i] 向 右移 直到它到达字符串的末端或另一个 '1'。例如，对于 s = "010010"，如果我们选择 i = 1，结果字符串将会是 s = "000110"。
 * 返回你能执行的 最大 操作次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "1001101"
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * 可以执行以下操作：
 * <p>
 * 选择下标 i = 0。结果字符串为 s = "0011101"。
 * 选择下标 i = 4。结果字符串为 s = "0011011"。
 * 选择下标 i = 3。结果字符串为 s = "0010111"。
 * 选择下标 i = 2。结果字符串为 s = "0001111"。
 * 示例 2：
 * <p>
 * 输入： s = "00111"
 * <p>
 * 输出： 0
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 为 '0' 或 '1'。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-number-of-operations-to-move-ones-to-the-end/description/?envType=daily-question&envId=2025-11-13">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3228_MaxOperations {
    public static void main(String[] args) {
        L3228_MaxOperations l3228MaxOperations = new L3228_MaxOperations();
        System.out.println(l3228MaxOperations.maxOperations("1001101"));
    }
    public int maxOperations(String s) {
        int cnt1 = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cnt1++;
            }else if (i > 0 && s.charAt(i - 1) == '1'){
                ans += cnt1;
            }
        }
        return ans;
    }
}
