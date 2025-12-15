package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.HashMap;
import java.util.Map;

/**
 * 3623. 统计梯形的数目 I
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个二维整数数组 points，其中 points[i] = [xi, yi] 表示第 i 个点在笛卡尔平面上的坐标。
 * <p>
 * 水平梯形 是一种凸四边形，具有 至少一对 水平边（即平行于 x 轴的边）。两条直线平行当且仅当它们的斜率相同。
 * <p>
 * 返回可以从 points 中任意选择四个不同点组成的 水平梯形 数量。
 * <p>
 * 由于答案可能非常大，请返回结果对 109 + 7 取余数后的值。
 * <p>
 * 示例 1：
 * <p>
 * 输入： points = [[1,0],[2,0],[3,0],[2,2],[3,2]]
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 有三种不同方式选择四个点组成一个水平梯形：
 * <p>
 * 使用点 [1,0]、[2,0]、[3,2] 和 [2,2]。
 * 使用点 [2,0]、[3,0]、[3,2] 和 [2,2]。
 * 使用点 [1,0]、[3,0]、[3,2] 和 [2,2]。
 * 示例 2：
 * <p>
 * 输入： points = [[0, 0],[1,0],[0,1],[2,1]]
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 只有一种方式可以组成一个水平梯形。
 * <p>
 * 提示：
 * <p>
 * 4 <= points.length <= 105
 * –108 <= xi, yi <= 108
 * 所有点两两不同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-number-of-trapezoids-i/description/?envType=daily-question&envId=2025-12-02">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3623_CountTrapezoids {

    public static void main(String[] args) {
        L3623_CountTrapezoids l3623CountTrapezoids = new L3623_CountTrapezoids();
        System.out.println(l3623CountTrapezoids.countTrapezoids(new int[][]{{1, 0}, {2, 0}, {3, 0}, {2, 2}, {3, 2}}));
    }

    public int countTrapezoids(int[][] points) {
        int mod = 1000000007;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int[] point : points) {
            cntMap.merge(point[1], 1, Integer::sum);
        }
        long ans = 0;
        long preComboSize = 0;
        for (Integer cnt : cntMap.values()) {
            long comboSize = (long) cnt * (cnt - 1) / 2;
            ans += (comboSize * preComboSize) % mod;
            preComboSize += comboSize;
        }
        return (int) (ans % mod);
    }
}
