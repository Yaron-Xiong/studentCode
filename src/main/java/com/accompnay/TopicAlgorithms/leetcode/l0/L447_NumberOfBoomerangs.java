package com.accompnay.TopicAlgorithms.leetcode.l0;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. 回旋镖的数量
 * 中等
 * 相关标签
 * 相关企业
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。
 * 回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的欧式距离相等（需要考虑元组的顺序）。
 * <p>
 * 返回平面上所有回旋镖的数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * 示例 2：
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：points = [[1,1]]
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * 所有点都 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/number-of-boomerangs/description/?envType=daily-question&envId=2024-01-08">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L447_NumberOfBoomerangs {
    public static void main(String[] args) {
        L447_NumberOfBoomerangs l447NumberOfBoomerangs = new L447_NumberOfBoomerangs();
        System.out.println(l447NumberOfBoomerangs.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}}));
    }

    public int numberOfBoomerangs(int[][] points) {
        if (points.length <= 1) {
            return 0;
        }
        //求任意两点的距离值
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Long, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                long distance = getDistance(points[i], points[j]);
                map.merge(distance, 1, Integer::sum);
            }
            for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                if (entry.getValue() <= 1) {
                    continue;
                }
                ans += (entry.getValue() * (entry.getValue() - 1));
            }
        }
        return ans;
    }

    public long getDistance(int[] a, int[] b) {
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return ((long) x * x) + ((long) y * y);
    }
}
