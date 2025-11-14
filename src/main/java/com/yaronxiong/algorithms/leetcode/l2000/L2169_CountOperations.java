package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2169. 得到 0 的操作数
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个 非负 整数 num1 和 num2 。
 * <p>
 * 每一步 操作 中，如果 num1 >= num2 ，你必须用 num1 减 num2 ；否则，你必须用 num2 减 num1 。
 * <p>
 * 例如，num1 = 5 且 num2 = 4 ，应该用 num1 减 num2 ，因此，得到 num1 = 1 和 num2 = 4 。
 * 然而，如果 num1 = 4且 num2 = 5 ，一步操作后，得到 num1 = 4 和 num2 = 1 。
 * 返回使 num1 = 0 或 num2 = 0 的 操作数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = 2, num2 = 3
 * 输出：3
 * 解释：
 * - 操作 1 ：num1 = 2 ，num2 = 3 。由于 num1 < num2 ，num2 减 num1 得到 num1 = 2 ，num2 = 3 - 2 = 1 。
 * - 操作 2 ：num1 = 2 ，num2 = 1 。由于 num1 > num2 ，num1 减 num2 。
 * - 操作 3 ：num1 = 1 ，num2 = 1 。由于 num1 == num2 ，num1 减 num2 。
 * 此时 num1 = 0 ，num2 = 1 。由于 num1 == 0 ，不需要再执行任何操作。
 * 所以总操作数是 3 。
 * 示例 2：
 * <p>
 * 输入：num1 = 10, num2 = 10
 * 输出：1
 * 解释：
 * - 操作 1 ：num1 = 10 ，num2 = 10 。由于 num1 == num2 ，num1 减 num2 得到 num1 = 10 - 10 = 0 。
 * 此时 num1 = 0 ，num2 = 10 。由于 num1 == 0 ，不需要再执行任何操作。
 * 所以总操作数是 1 。
 * <p>
 * 提示：
 * <p>
 * 0 <= num1, num2 ≤ 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-operations-to-obtain-zero/description/?envType=daily-question&envId=2025-11-09">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2169_CountOperations {
    public static void main(String[] args) {
        L2169_CountOperations l2169CountOperations = new L2169_CountOperations();
        int i = l2169CountOperations.countOperations(2, 3);
        System.out.println(i);
    }
    public int countOperations(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            return 0;
        }
        return num1 >= num2 ? countOperations(num1 - num2, num2) + 1: countOperations(num1, num2 - num1) + 1;
    }
}
