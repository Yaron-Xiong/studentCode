package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.Arrays;

/**
 * 3111. 覆盖所有点的最少矩形数目
 * 1401
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个二维整数数组 point ，其中 points[i] = [xi, yi] 表示二维平面内的一个点。同时给你一个整数 w 。你需要用矩形 覆盖所有 点。
 * <p>
 * 每个矩形的左下角在某个点 (x1, 0) 处，且右上角在某个点 (x2, y2) 处，其中 x1 <= x2 且 y2 >= 0 ，同时对于每个矩形都 必须 满足 x2 - x1 <= w 。
 * <p>
 * 如果一个点在矩形内或者在边上，我们说这个点被矩形覆盖了。
 * <p>
 * 请你在确保每个点都 至少 被一个矩形覆盖的前提下，最少 需要多少个矩形。
 * <p>
 * 注意：一个点可以被多个矩形覆盖。
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[2,1],[1,0],[1,4],[1,8],[3,5],[4,6]], w = 1
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 上图展示了一种可行的矩形放置方案：
 * <p>
 * 一个矩形的左下角在 (1, 0) ，右上角在 (2, 8) 。
 * 一个矩形的左下角在 (3, 0) ，右上角在 (4, 8) 。
 * 示例 2：
 * <p>
 * 输入：points = [[0,0],[1,1],[2,2],[3,3],[4,4],[5,5],[6,6]], w = 2
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 上图展示了一种可行的矩形放置方案：
 * <p>
 * 一个矩形的左下角在 (0, 0) ，右上角在 (2, 2) 。
 * 一个矩形的左下角在 (3, 0) ，右上角在 (5, 5) 。
 * 一个矩形的左下角在 (6, 0) ，右上角在 (6, 6) 。
 * 示例 3：
 * <p>
 * 输入：points = [[2,3],[1,2]], w = 0
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 上图展示了一种可行的矩形放置方案：
 * <p>
 * 一个矩形的左下角在 (1, 0) ，右上角在 (1, 2) 。
 * 一个矩形的左下角在 (2, 0) ，右上角在 (2, 3) 。
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 105
 * points[i].length == 2
 * 0 <= xi == points[i][0] <= 109
 * 0 <= yi == points[i][1] <= 109
 * 0 <= w <= 109
 * 所有点坐标 (xi, yi) 互不相同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-rectangles-to-cover-points/description/?envType=daily-question&envId=2024-07-31">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3111_MinRectanglesToCoverPoints {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        //排序
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int index = 0;
        int ans = 0;
        while (index < points.length) {
            int left = points[index][0];
            while (index < points.length && points[index][0] - left <= w) {
                index++;
            }
            ans++;
        }
        return ans;
    }
}
