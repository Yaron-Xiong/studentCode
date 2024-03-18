package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2520. 统计能整除数字的位数
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 num ，返回 num 中能整除 num 的数位的数目。
 * <p>
 * 如果满足 nums % val == 0 ，则认为整数 val 可以整除 nums 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 7
 * 输出：1
 * 解释：7 被自己整除，因此答案是 1 。
 * 示例 2：
 * <p>
 * 输入：num = 121
 * 输出：2
 * 解释：121 可以被 1 整除，但无法被 2 整除。由于 1 出现两次，所以返回 2 。
 * 示例 3：
 * <p>
 * 输入：num = 1248
 * 输出：4
 * 解释：1248 可以被它每一位上的数字整除，因此答案是 4 。
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 109
 * num 的数位中不含 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-the-digits-that-divide-a-number/description/?envType=daily-question&envId=2023-10-26">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2520_CountDigits {
    public static void main(String[] args) {
        L2520_CountDigits l2520CountDigits = new L2520_CountDigits();
        System.out.println(l2520CountDigits.countDigits(1248));
    }

    public int countDigits(int num) {
        int ans = 0;
        int a = num;
        while (a != 0) {
            if (num % (a % 10) == 0) {
                ans++;
            }
            a /= 10;
        }
        return ans;
    }
}
