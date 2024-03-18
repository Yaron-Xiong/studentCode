package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2048. 下一个更大的数值平衡数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 如果整数  x 满足：对于每个数位 d ，这个数位 恰好 在 x 中出现 d 次。那么整数 x 就是一个 数值平衡数 。
 * <p>
 * 给你一个整数 n ，请你返回 严格大于 n 的 最小数值平衡数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：22
 * 解释：
 * 22 是一个数值平衡数，因为：
 * - 数字 2 出现 2 次
 * 这也是严格大于 1 的最小数值平衡数。
 * 示例 2：
 * <p>
 * 输入：n = 1000
 * 输出：1333
 * 解释：
 * 1333 是一个数值平衡数，因为：
 * - 数字 1 出现 1 次。
 * - 数字 3 出现 3 次。
 * 这也是严格大于 1000 的最小数值平衡数。
 * 注意，1022 不能作为本输入的答案，因为数字 0 的出现次数超过了 0 。
 * 示例 3：
 * <p>
 * 输入：n = 3000
 * 输出：3133
 * 解释：
 * 3133 是一个数值平衡数，因为：
 * - 数字 1 出现 1 次。
 * - 数字 3 出现 3 次。
 * 这也是严格大于 3000 的最小数值平衡数。
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/next-greater-numerically-balanced-number/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2048_NextBeautifulNumber {
    public static void main(String[] args) {
        L2048_NextBeautifulNumber l2048NextBeautifulNumber = new L2048_NextBeautifulNumber();
        System.out.println(l2048NextBeautifulNumber.nextBeautifulNumber(1));
    }

    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; i <= 1224444; i++) {
            boolean a = isBalance(i);
            if (a) {
                return i;
            }
        }
        return -1;
    }

    private boolean isBalance(int i) {
        int[] arr = new int[10];
        while (i > 0) {
            arr[i % 10]++;
            i /= 10;
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0 && arr[j] != j) {
                return false;
            }
        }
        return true;
    }
}
