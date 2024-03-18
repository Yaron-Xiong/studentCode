package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2591. 将钱分给最多的儿童
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 money ，表示你总共有的钱数（单位为美元）和另一个整数 children ，表示你要将钱分配给多少个儿童。
 * <p>
 * 你需要按照如下规则分配：
 * <p>
 * 所有的钱都必须被分配。
 * 每个儿童至少获得 1 美元。
 * 没有人获得 4 美元。
 * 请你按照上述规则分配金钱，并返回 最多 有多少个儿童获得 恰好 8 美元。如果没有任何分配方案，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：money = 20, children = 3
 * 输出：1
 * 解释：
 * 最多获得 8 美元的儿童数为 1 。一种分配方案为：
 * - 给第一个儿童分配 8 美元。
 * - 给第二个儿童分配 9 美元。
 * - 给第三个儿童分配 3 美元。
 * 没有分配方案能让获得 8 美元的儿童数超过 1 。
 * 示例 2：
 * <p>
 * 输入：money = 16, children = 2
 * 输出：2
 * 解释：每个儿童都可以获得 8 美元。
 * <p>
 * 提示：
 * <p>
 * 1 <= money <= 200
 * 2 <= children <= 30
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/distribute-money-to-maximum-children/description/?envType=daily-question&envId=2023-09-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2591_DistMoney {
    public static void main(String[] args) {
        L2591_DistMoney l2591DistMoney = new L2591_DistMoney();
        System.out.println(l2591DistMoney.distMoney(17, 2));
    }

    public int distMoney(int money, int children) {
        //先给所有小孩分1元
        money -= children;
        //此方案无法分配
        if (money < 0) {
            return -1;
        }
        //剩余金额能够分配多个7 此时能解决 count个小孩
        int finishChildren = Math.min(money / 7, children);
        //分配7元后总的剩余金额
        money -= finishChildren * 7;
        //剩余人数
        children -= finishChildren;
        if ((children == 0 && money > 0) || (children == 1 && money + 1 == 4)) {
            return finishChildren - 1;
        }
        return finishChildren;
    }
}
