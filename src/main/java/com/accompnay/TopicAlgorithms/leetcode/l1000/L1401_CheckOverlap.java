package com.accompnay.TopicAlgorithms.leetcode.l1000;

/**
 * 1401. 圆和矩形是否有重叠
 * 提示
 * 中等
 * 64
 * 相关企业
 * 给你一个以 (radius, xCenter, yCenter) 表示的圆和一个与坐标轴平行的矩形 (x1, y1, x2, y2) ，其中 (x1, y1) 是矩形左下角的坐标，而 (x2, y2) 是右上角的坐标。
 * <p>
 * 如果圆和矩形有重叠的部分，请你返回 true ，否则返回 false 。
 * <p>
 * 换句话说，请你检测是否 存在 点 (xi, yi) ，它既在圆上也在矩形上（两者都包括点落在边界上的情况）。
 * <p>
 * 示例 1 ：
 * <p>
 * <p>
 * 输入：radius = 1, xCenter = 0, yCenter = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1
 * 输出：true
 * 解释：圆和矩形存在公共点 (1,0) 。
 * 示例 2 ：
 * <p>
 * 输入：radius = 1, xCenter = 1, yCenter = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1
 * 输出：false
 * 示例 3 ：
 * <p>
 * <p>
 * 输入：radius = 1, xCenter = 0, yCenter = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= radius <= 2000
 * -104 <= xCenter, yCenter <= 104
 * -104 <= x1 < x2 <= 104
 * -104 <= y1 < y2 <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/circle-and-rectangle-overlapping/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1401_CheckOverlap {
    public static void main(String[] args) {
        L1401_CheckOverlap l1401CheckOverlap = new L1401_CheckOverlap();
        System.out.println(l1401CheckOverlap.checkOverlap(1, 1, 1, -3, -3, 3, 3));
    }

    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        double distance = 0;
        if (xCenter < x1 || xCenter > x2) {
            distance += Math.pow(Math.min(Math.abs((xCenter - x1)), Math.abs(xCenter - x2)),2);
        }
        if (yCenter < y1 || yCenter > y2) {
            distance += Math.pow(Math.min(Math.abs((yCenter - y1)), Math.abs(yCenter - y2)), 2);
        }
        return distance <= radius * radius;
    }

}
