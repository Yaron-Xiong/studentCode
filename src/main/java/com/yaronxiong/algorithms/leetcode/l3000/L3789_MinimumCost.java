package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3789. 采购的最小花费
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你五个整数 cost1, cost2, costBoth, need1 和 need2。
 * <p>
 * 有三种类型的物品可以购买：
 * <p>
 * 类型 1 的物品花费 cost1，并仅满足类型 1 的需求 1 个单位。
 * 类型 2 的物品花费 cost2，并仅满足类型 2 的需求 1 个单位。
 * 类型 3 的物品花费 costBoth，同时满足类型 1 和类型 2 的需求各 1 个单位。
 * 你需要购买足够的物品，使得：
 * <p>
 * 满足类型 1 的总需求 至少 为 need1。
 * 满足类型 2 的总需求 至少 为 need2。
 * 返回满足这些需求的 最小 可能总花费。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * int cost1 = 3;
 * int cost2 = 2;
 * int costBoth = 1;
 * int need1 = 3;
 * int need2 = 2;
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 购买 3 个类型 3 的物品，总花费为 3 * 1 = 3，此时类型 1 的总需求满足 3（>= need1 = 3），类型 2 的总需求满足 3（>= need2 = 2）。
 * 任何其他有效的购买方案都会花费更多，因此最小总花费为 3。
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * int cost1 = 5;
 * int cost2 = 4;
 * int costBoth = 15;
 * int need1 = 2;
 * int need2 = 3;
 * <p>
 * 输出： 22
 * <p>
 * 解释：
 * <p>
 * 购买 need1 = 2 个类型 1 的物品和 need2 = 3 个类型 2 的物品，总花费为 2 * 5 + 3 * 4 = 10 + 12 = 22。
 * 任何其他有效的购买方案都会花费更多，因此最小总花费为 22。
 * <p>
 * 示例 3：
 * <p>
 * 输入：
 * int cost1 = 5;
 * int cost2 = 4;
 * int costBoth = 15;
 * int need1 = 0;
 * int need2 = 0;
 * <p>
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 由于不需要任何物品（need1 = need2 = 0），因此无需购买，总花费为 0。
 * <p>
 * 提示：
 * <p>
 * 1 <= cost1, cost2, costBoth <= 106
 * 0 <= need1, need2 <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-cost-to-acquire-required-items/description/?envType=daily-question&envId=2026-11-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3789_MinimumCost {
    public static void main(String[] args) {
        L3789_MinimumCost l3789MinimumCost = new L3789_MinimumCost();
        System.out.println(l3789MinimumCost.minimumCost(5, 4, 15, 2, 3));
        System.out.println(l3789MinimumCost.minimumCost(3, 2, 1, 3, 2));
        System.out.println(l3789MinimumCost.minimumCost(5, 4, 15, 0, 0));
    }

    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        //当 type1 和 type2 都少时 选择方案有
        int cur1Cnt = 0;
        int cur2Cnt = 0;
        long cost = 0;
        //两种类型同时加
        if (cur1Cnt < need1 && cur2Cnt < need2) {
            //需要选择的数量
            int cnt = Math.min(need1, need2);
            // 选择 cost1 + cost2
            if (cost1 + cost2 < costBoth) {
                cost += (long) (cost1 + cost2) * cnt;
            } else {
                // 选择costBoth
                cost += (long) costBoth * cnt;
            }
            cur1Cnt += cnt;
            cur2Cnt += cnt;
        }
        //现在只缺一种
        if (cur1Cnt < need1) {
            int cnt = need1 - cur1Cnt;
            if (cost1 < costBoth) {
                cost += (long) cnt * cost1;
                cur1Cnt += cnt;
            } else {
                cost += (long) cnt * costBoth;
                cur1Cnt += cnt;
                cur2Cnt += cnt;
            }
        }

        if (cur2Cnt < need2) {
            int cnt = need2 - cur2Cnt;
            if (cost2 < costBoth) {
                cost += (long) cnt * cost2;
                cur2Cnt += cnt;
            } else {
                cost += (long) cnt * costBoth;
                cur1Cnt += cnt;
                cur2Cnt += cnt;
            }
        }

        return cost;
    }
}
