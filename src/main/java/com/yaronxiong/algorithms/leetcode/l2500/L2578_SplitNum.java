package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2578. 最小和分割
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个正整数 num ，请你将它分割成两个非负整数 num1 和 num2 ，满足：
 * <p>
 * num1 和 num2 直接连起来，得到 num 各数位的一个排列。
 * 换句话说，num1 和 num2 中所有数字出现的次数之和等于 num 中所有数字出现的次数。
 * num1 和 num2 可以包含前导 0 。
 * 请你返回 num1 和 num2 可以得到的和的 最小 值。
 * <p>
 * 注意：
 * <p>
 * num 保证没有前导 0 。
 * num1 和 num2 中数位顺序可以与 num 中数位顺序不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 4325
 * 输出：59
 * 解释：我们可以将 4325 分割成 num1 = 24 和 num2 = 35 ，和为 59 ，59 是最小和。
 * 示例 2：
 * <p>
 * 输入：num = 687
 * 输出：75
 * 解释：我们可以将 687 分割成 num1 = 68 和 num2 = 7 ，和为最优值 75 。
 * <p>
 * 提示：
 * <p>
 * 10 <= num <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/split-with-minimum-sum/description/?envType=daily-question&envId=2023-10-09">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2578_SplitNum {
    public static void main(String[] args) {
        L2578_SplitNum l2578SplitNum = new L2578_SplitNum();
        System.out.println(l2578SplitNum.splitNum(687));
    }

    public int splitNum(int num) {
        int[] numArr = new int[10];
        while (num != 0) {
            numArr[num % 10]++;
            num /= 10;
        }
        int index = 0;
        int size = 0;
        int[] ans = new int[2];
        while (index < numArr.length) {
            if (numArr[index] > 0) {
                ans[size % 2] = ans[size % 2] * 10 + index;
                numArr[index]--;
                size++;
            } else {
                index++;
            }
        }
        return ans[0] + ans[1];
    }
}
