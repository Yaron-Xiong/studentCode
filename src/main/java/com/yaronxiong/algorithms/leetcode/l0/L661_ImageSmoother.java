package com.yaronxiong.algorithms.leetcode.l0;

import java.util.Arrays;

/**
 * 661. 图片平滑器
 * 算术评级: 3
 * 同步题目状态
 * <p>
 * 简单
 * 相关标签
 * 相关企业
 * 图像平滑器 是大小为 3 x 3 的过滤器，用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。
 * <p>
 * 每个单元格的  平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。（即，需要计算蓝色平滑器中 9 个单元格的平均值）。
 * <p>
 * 如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格（即，需要计算红色平滑器中 4 个单元格的平均值）。
 * <p>
 * 给你一个表示图像灰度的 m x n 整数矩阵 img ，返回对图像的每个单元格平滑处理后的图像 。
 * <p>
 * 示例 1:
 * <p>
 * 输入:img = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出:[[0, 0, 0],[0, 0, 0], [0, 0, 0]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 * 示例 2:
 * <p>
 * <p>
 * 输入: img = [[100,200,100],[200,50,200],[100,200,100]]
 * 输出: [[137,141,137],[141,138,141],[137,141,137]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
 * 对于点 (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
 * 对于点 (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
 * <p>
 * 提示:
 * <p>
 * m == img.length
 * n == img[i].length
 * 1 <= m, n <= 200
 * 0 <= img[i][j] <= 255
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/image-smoother/description/?envType=daily-question&envId=2024-11-18">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L661_ImageSmoother {
    public static void main(String[] args) {
        L661_ImageSmoother l661ImageSmoother = new L661_ImageSmoother();
        int[][] a = l661ImageSmoother.imageSmoother(new int[][]{{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}});
        System.out.println(Arrays.deepToString(a));
    }

    public int[][] imageSmoother(int[][] img) {
        int[][] preSum = new int[img.length + 1][img[0].length + 1];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                preSum[i + 1][j + 1] = preSum[i][j + 1] + preSum[i + 1][j] + img[i][j] - preSum[i][j];
            }
        }

        int[][] ans = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                //统计以{i，j} 作为左上角的的3*3 面积平均值
                //左上角的点,考虑越界
                int x1 = Math.max(i - 1, 0);
                int y1 = Math.max(j - 1, 0);
                //右下角的点，考虑越界
                int x2 = Math.min(i + 1, img.length - 1);
                int y2 = Math.min(j + 1, img[i].length - 1);
                //总节点数
                int cnt = (y2 - y1 + 1) * (x2 - x1 + 1);
                int sum = preSum[x2 + 1][y2 + 1] - preSum[x2 + 1][y1] - preSum[x1][y2 + 1] + preSum[x1][y1];
                ans[i][j] = sum / cnt;
            }
        }
        return ans;
    }
}
