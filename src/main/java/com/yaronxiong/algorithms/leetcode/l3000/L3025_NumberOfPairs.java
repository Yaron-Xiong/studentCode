package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.Arrays;

/**
 * 3025. 人员站位的方案数 I
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个  n x 2 的二维数组 points ，它表示二维平面上的一些点坐标，其中 points[i] = [xi, yi] 。
 * <p>
 * 计算点对 (A, B) 的数量，其中
 * <p>
 * A 在 B 的左上角，并且
 * 它们形成的长方形中（或直线上）没有其它点（包括边界）。
 * 返回数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3]]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 没有办法选择 A 和 B，使得 A 在 B 的左上角。
 * <p>
 * 示例 2：
 * <p>
 * 输入：points = [[6,2],[4,4],[2,6]]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 左边的是点对 (points[1], points[0])，其中 points[1] 在 points[0] 的左上角，并且形成的长方形内部是空的。
 * 中间的是点对 (points[2], points[1])，和左边的一样是合法的点对。
 * 右边的是点对 (points[2], points[0])，其中 points[2] 在 points[0] 的左上角，但 points[1] 在长方形内部，所以不是一个合法的点对。
 * 示例 3：
 * <p>
 * 输入：points = [[3,1],[1,3],[1,1]]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 左边的是点对 (points[2], points[0])，其中 points[2] 在 points[0] 的左上角并且在它们形成的直线上没有其它点。注意两个点形成一条线的情况是合法的。
 * 中间的是点对 (points[1], points[2])，和左边一样也是合法的点对。
 * 右边的是点对 (points[1], points[0])，它不是合法的点对，因为 points[2] 在长方形的边上。
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 50
 * points[i].length == 2
 * 0 <= points[i][0], points[i][1] <= 50
 * points[i] 点对两两不同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-number-of-ways-to-place-people-i/description/?envType=daily-question&envId=2025-09-02">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3025_NumberOfPairs {
    public static void main(String[] args) {
        L3025_NumberOfPairs l3025NumberOfPairs = new L3025_NumberOfPairs();
        System.out.println(l3025NumberOfPairs.numberOfPairs(new int[][]{{3, 1}, {1, 3}, {1, 1}}));
    }

    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            //找到所有符合的节点
            for (int j = i - 1; j >= 0; j--) {
                int x2 = points[i][0];
                int y2 = points[i][1];
                int x1 = points[j][0];
                int y1 = points[j][1];
                if (y1 < y2) {
                    continue;
                }
                //这里是符合的节点，需要检测 point[j] 跟 point[i] 构成的 线或者矩形 中间是否包含其他点
                boolean contains = false;
                for (int k = i - 1; k >= j + 1; k--) {
                    int x = points[k][0];
                    int y = points[k][1];
                    if (x <= x2 && x >= x1 && y <= y1 && y >= y2) {
                        contains = true;
                        break;
                    }
                }
                if (!contains) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
