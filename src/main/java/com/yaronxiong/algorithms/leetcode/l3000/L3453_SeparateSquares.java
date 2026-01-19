package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3453. 分割正方形 I
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个二维整数数组 squares ，其中 squares[i] = [xi, yi, li] 表示一个与 x 轴平行的正方形的左下角坐标和正方形的边长。
 * <p>
 * 找到一个最小的 y 坐标，它对应一条水平线，该线需要满足它以上正方形的总面积 等于 该线以下正方形的总面积。
 * <p>
 * 答案如果与实际答案的误差在 10-5 以内，将视为正确答案。
 * <p>
 * 注意：正方形 可能会 重叠。重叠区域应该被 多次计数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入： squares = [[0,0,1],[2,2,1]]
 * <p>
 * 输出： 1.00000
 * <p>
 * 解释：
 * <p>
 * 任何在 y = 1 和 y = 2 之间的水平线都会有 1 平方单位的面积在其上方，1 平方单位的面积在其下方。最小的 y 坐标是 1。
 * <p>
 * 示例 2：
 * <p>
 * 输入： squares = [[0,0,2],[1,1,1]]
 * <p>
 * 输出： 1.16667
 * <p>
 * 解释：
 * <p>
 * 面积如下：
 * <p>
 * 线下的面积：7/6 * 2 (红色) + 1/6 (蓝色) = 15/6 = 2.5。
 * 线上的面积：5/6 * 2 (红色) + 5/6 (蓝色) = 15/6 = 2.5。
 * 由于线以上和线以下的面积相等，输出为 7/6 = 1.16667。
 * <p>
 * 提示：
 * <p>
 * 1 <= squares.length <= 5 * 104
 * squares[i] = [xi, yi, li]
 * squares[i].length == 3
 * 0 <= xi, yi <= 109
 * 1 <= li <= 109
 * 所有正方形的总面积不超过 1012。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/separate-squares-i/description/?envType=daily-question&envId=2026-01-13">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3453_SeparateSquares {
    public static void main(String[] args) {
        L3453_SeparateSquares l3453SeparateSquares = new L3453_SeparateSquares();
        System.out.println(l3453SeparateSquares.separateSquares(new int[][]{{0, 0, 2}, {1, 1, 1}}));
        System.out.println(l3453SeparateSquares.separateSquares(new int[][]{{0, 0, 1}, {2, 2, 1}}));
    }

    public double separateSquares(int[][] squares) {
        long totalArea = 0;
        int maxY = 0;
        for (int[] square : squares) {
            totalArea += (long) square[2] * square[2];
            maxY = Math.max(maxY, square[1] + square[2]);
        }

        //开始二分
        double left = 0;
        double right = maxY;
        while (left + 1e-5 < right) {
            double mid = (left + right) / 2;
            if (check2(mid, squares, totalArea)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    private boolean check2(double target, int[][] squares, long totalArea) {
        //统计下面的面积
        double area = 0;
        for (int[] square : squares) {
            double topY = square[1] + square[2];
            int bottomY = square[1];
            if (bottomY > target) {
                continue;
            }
            //计算面积
            double top = Math.min(target, topY);
            area += (long) square[2] * (top - bottomY);
        }
        //如果下面的面积 >= 了上面的面积 = true
        return area + area >= totalArea;
    }

}
