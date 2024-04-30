package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2739. 总行驶距离
 * 算术评级: 3
 * 第 350 场周赛
 * Q1
 * 1262
 * 相关标签
 * 相关企业
 * 提示
 * 卡车有两个油箱。给你两个整数，mainTank 表示主油箱中的燃料（以升为单位），additionalTank 表示副油箱中的燃料（以升为单位）。
 * <p>
 * 该卡车每耗费 1 升燃料都可以行驶 10 km。每当主油箱使用了 5 升燃料时，如果副油箱至少有 1 升燃料，则会将 1 升燃料从副油箱转移到主油箱。
 * <p>
 * 返回卡车可以行驶的最大距离。
 * <p>
 * 注意：从副油箱向主油箱注入燃料不是连续行为。这一事件会在每消耗 5 升燃料时突然且立即发生。
 * <p>
 * 示例 1：
 * <p>
 * 输入：mainTank = 5, additionalTank = 10
 * 输出：60
 * 解释：
 * 在用掉 5 升燃料后，主油箱中燃料还剩下 (5 - 5 + 1) = 1 升，行驶距离为 50km 。
 * 在用掉剩下的 1 升燃料后，没有新的燃料注入到主油箱中，主油箱变为空。
 * 总行驶距离为 60km 。
 * 示例 2：
 * <p>
 * 输入：mainTank = 1, additionalTank = 2
 * 输出：10
 * 解释：
 * 在用掉 1 升燃料后，主油箱变为空。
 * 总行驶距离为 10km 。
 * <p>
 * 提示：
 * <p>
 * 1 <= mainTank, additionalTank <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/total-distance-traveled/description/?envType=daily-question&envId=2024-04-25">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2739_DistanceTraveled {
    public static void main(String[] args) {
        L2739_DistanceTraveled l2739DistanceTraveled = new L2739_DistanceTraveled();
        System.out.println(l2739DistanceTraveled.distanceTraveled(9, 1));
    }

    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0;
        while (true) {
            int consumeGroup = mainTank / 5;
            if (consumeGroup == 0) {
                break;
            }
            int transform = Math.min(consumeGroup, additionalTank);
            mainTank = (mainTank - consumeGroup * 5) + transform;
            additionalTank -= transform;
            ans += consumeGroup * 50;
        }
        ans += mainTank * 10;
        return ans;
    }
}