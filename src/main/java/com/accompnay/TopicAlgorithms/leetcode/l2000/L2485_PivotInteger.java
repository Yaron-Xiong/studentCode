package com.accompnay.TopicAlgorithms.leetcode.l2000;

/**
 * 2485. 找出中枢整数
 * 提示
 * 简单
 * 20
 * 相关企业
 * 给你一个正整数 n ，找出满足下述条件的 中枢整数 x ：
 * <p>
 * 1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和。
 * 返回中枢整数 x 。如果不存在中枢整数，则返回 -1 。题目保证对于给定的输入，至多存在一个中枢整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 8
 * 输出：6
 * 解释：6 是中枢整数，因为 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21 。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * 解释：1 是中枢整数，因为 1 = 1 。
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：-1
 * 解释：可以证明不存在满足题目要求的整数。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-pivot-integer/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2485_PivotInteger {
    public static void main(String[] args) {
        L2485_PivotInteger l2485PivotInteger = new L2485_PivotInteger();
        System.out.println(l2485PivotInteger.pivotInteger(8));
    }

    public int pivotInteger(int n) {
        if (n == 1) {
            return 1;
        }
        int sum = n + (((n * (n - 1))) / 2);
        int temp = 0;
        for (int i = 1; i < n; i++) {
            temp += i;
            if (temp * 2 == (sum + i)) {
                return i;
            }
        }
        return -1;
    }
}
