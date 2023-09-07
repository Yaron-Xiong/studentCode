package com.accompnay.TopicAlgorithms.leetcode.l2000;

/**
 * 2240. 买钢笔和铅笔的方案数
 * 提示
 * 中等
 * 34
 * 相关企业
 * 给你一个整数 total ，表示你拥有的总钱数。同时给你两个整数 cost1 和 cost2 ，分别表示一支钢笔和一支铅笔的价格。
 * 你可以花费你部分或者全部的钱，去买任意数目的两种笔。
 * <p>
 * 请你返回购买钢笔和铅笔的 不同方案数目 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：total = 20, cost1 = 10, cost2 = 5
 * 输出：9
 * 解释：一支钢笔的价格为 10 ，一支铅笔的价格为 5 。
 * - 如果你买 0 支钢笔，那么你可以买 0 ，1 ，2 ，3 或者 4 支铅笔。
 * - 如果你买 1 支钢笔，那么你可以买 0 ，1 或者 2 支铅笔。
 * - 如果你买 2 支钢笔，那么你没法买任何铅笔。
 * 所以买钢笔和铅笔的总方案数为 5 + 3 + 1 = 9 种。
 * 示例 2：
 * <p>
 * 输入：total = 5, cost1 = 10, cost2 = 10
 * 输出：1
 * 解释：钢笔和铅笔的价格都为 10 ，都比拥有的钱数多，所以你没法购买任何文具。所以只有 1 种方案：买 0 支钢笔和 0 支铅笔。
 * <p>
 * 提示：
 * <p>
 * 1 <= total, cost1, cost2 <= 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/number-of-ways-to-buy-pens-and-pencils">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2240_WaysToBuyPensPencils {
    public static void main(String[] args) {
        L2240_WaysToBuyPensPencils l2240WaysToBuyPensPencils = new L2240_WaysToBuyPensPencils();
        System.out.println(l2240WaysToBuyPensPencils.waysToBuyPensPencils(20, 10, 5));
    }

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (cost1 > total || cost2 > total) {
            return Math.max(total / cost1, total / cost2) + 1;
        }
        if (cost1 > cost2) {
            return waysToBuyPensPencils(total, cost2, cost1);
        }
        int maxCost1 = total / cost1;
        long res = 0;
        for (int i = 0; i <= maxCost1; i++) {
            //假设选择i个钢笔，那么能选择多少个cost2
            int lastMoney = total - (cost1 * i);
            int maxCost2 = lastMoney / cost2;
            res += maxCost2 + 1;
        }
        return res;
    }

}
