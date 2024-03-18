package com.yaronxiong.algorithms.leetcode.l0;


/**
 * 670. 最大交换
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 * <p>
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 注意:
 * <p>
 * 给定数字的范围是 [0, 108]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-swap/description/?envType=daily-question&envId=2024-01-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L680_MaximumSwap {
    public static void main(String[] args) {
        L680_MaximumSwap l680MaximumSwap = new L680_MaximumSwap();
        System.out.println(l680MaximumSwap.maximumSwap(2736));
    }

    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int maxIndex = chars.length - 1;
        int p = -1;
        int q = 0;
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i] > chars[maxIndex]) {
                maxIndex = i;
            } else if (chars[i] < chars[maxIndex]) {
                p = maxIndex;
                q = i;
            }
        }
        if (p == -1) {
            return num;
        }
        char temp = chars[p];
        chars[p] = chars[q];
        chars[q] = temp;
        return Integer.parseInt(new String(chars));
    }
}
