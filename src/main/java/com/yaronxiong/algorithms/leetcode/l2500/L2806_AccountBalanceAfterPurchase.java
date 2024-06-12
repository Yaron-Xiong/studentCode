package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2806. 取整购买后的账户余额
 * 算术评级: 2
 * 第 110 场双周赛
 * Q1
 * 1215
 * 相关标签
 * 相关企业
 * 提示
 * 一开始，你的银行账户里有 100 块钱。
 * <p>
 * 给你一个整数purchaseAmount ，它表示你在一次购买中愿意支出的金额。
 * <p>
 * 在一个商店里，你进行一次购买，实际支出的金额会向 最近 的 10 的 倍数 取整。
 * 换句话说，你实际会支付一个 非负 金额 roundedAmount ，满足 roundedAmount 是 10 的倍数且 abs(roundedAmount - purchaseAmount) 的值 最小 。
 * <p>
 * 如果存在多于一个最接近的 10 的倍数，较大的倍数 是你的实际支出金额。
 * <p>
 * 请你返回一个整数，表示你在愿意支出金额为 purchaseAmount 块钱的前提下，购买之后剩下的余额。
 * <p>
 * 注意： 0 也是 10 的倍数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：purchaseAmount = 9
 * 输出：90
 * 解释：这个例子中，最接近 9 的 10 的倍数是 10 。所以你的账户余额为 100 - 10 = 90 。
 * 示例 2：
 * <p>
 * 输入：purchaseAmount = 15
 * 输出：80
 * 解释：这个例子中，有 2 个最接近 15 的 10 的倍数：10 和 20，较大的数 20 是你的实际开销。
 * 所以你的账户余额为 100 - 20 = 80 。
 * <p>
 * 提示：
 * <p>
 * 0 <= purchaseAmount <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/battleships-in-a-board/description/?envType=daily-question&envId=2024-06-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2806_AccountBalanceAfterPurchase {
    public static void main(String[] args) {
        int i = new L2806_AccountBalanceAfterPurchase().accountBalanceAfterPurchase(1);
        System.out.println(i);
    }

    public int accountBalanceAfterPurchase(int purchaseAmount) {
        //获取个位数
        int a = purchaseAmount / 10;
        int b = purchaseAmount % 10;
        if (b >= 5) {
            return 100 - (a + 1) * 10;
        } else {
            return 100 - (a * 10);
        }
    }

}
