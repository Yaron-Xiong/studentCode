package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2749. 得到整数零需要执行的最少操作数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个整数：num1 和 num2 。
 * <p>
 * 在一步操作中，你需要从范围 [0, 60] 中选出一个整数 i ，并从 num1 减去 2i + num2 。
 * <p>
 * 请你计算，要想使 num1 等于 0 需要执行的最少操作数，并以整数形式返回。
 * <p>
 * 如果无法使 num1 等于 0 ，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = 3, num2 = -2
 * 输出：3
 * 解释：可以执行下述步骤使 3 等于 0 ：
 * - 选择 i = 2 ，并从 3 减去 22 + (-2) ，num1 = 3 - (4 + (-2)) = 1 。
 * - 选择 i = 2 ，并从 1 减去 22 + (-2) ，num1 = 1 - (4 + (-2)) = -1 。
 * - 选择 i = 0 ，并从 -1 减去 20 + (-2) ，num1 = (-1) - (1 + (-2)) = 0 。
 * 可以证明 3 是需要执行的最少操作数。
 * 示例 2：
 * <p>
 * 输入：num1 = 5, num2 = 7
 * 输出：-1
 * 解释：可以证明，执行操作无法使 5 等于 0 。
 * <p>
 * 提示：
 * <p>
 * 1 <= num1 <= 109
 * -109 <= num2 <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-operations-to-make-the-integer-zero/description/?envType=daily-question&envId=2025-09-05">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2749_MakeTheIntegerZero {
    public static void main(String[] args) {
        L2749_MakeTheIntegerZero l2749MakeTheIntegerZero = new L2749_MakeTheIntegerZero();
        System.out.println(l2749MakeTheIntegerZero.makeTheIntegerZero(3, -2));
    }

    public int makeTheIntegerZero(int num1, int num2) {
        if (num1 == 0) {
            return 0;
        }
        //枚举答案
        int k = 1;
        while (true) {
            long a = num1 - ((long) k * num2);
            if (a <= 0) {
                //因为 k个 n^i 相加的和一定是>0的
                return -1;
            }
            //判断这个a 是否可以由 k个  n^i 构成？
            int bitCount = Long.bitCount(a);
            if (bitCount <= k && k <= a) {
                return k;
            }
            k++;
        }
    }
}
