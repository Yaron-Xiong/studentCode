package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1266. 访问所有点的最小时间
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi] 。请你计算访问所有这些点需要的 最小时间（以秒为单位）。
 * <p>
 * 你需要按照下面的规则在平面上移动：
 * <p>
 * 每一秒内，你可以：
 * 沿水平方向移动一个单位长度，或者
 * 沿竖直方向移动一个单位长度，或者
 * 跨过对角线移动 sqrt(2) 个单位长度（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
 * 必须按照数组中出现的顺序来访问这些点。
 * 在访问某个点时，可以经过该点后面出现的点，但经过的那些点不算作有效访问。
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[1,1],[3,4],[-1,0]]
 * 输出：7
 * 解释：一条最佳的访问路径是： [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
 * 从 [1,1] 到 [3,4] 需要 3 秒
 * 从 [3,4] 到 [-1,0] 需要 4 秒
 * 一共需要 7 秒
 * 示例 2：
 * <p>
 * 输入：points = [[3,2],[-2,2]]
 * 输出：5
 * <p>
 * 提示：
 * <p>
 * points.length == n
 * 1 <= n <= 100
 * points[i].length == 2
 * -1000 <= points[i][0], points[i][1] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/swap-for-longest-repeated-character-substring/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1266_MinTimeToVisitAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            int[] pre = points[i - 1];
            int[] cur = points[i];
            ans += Math.max(Math.abs(pre[0] - cur[0]), Math.abs(pre[1] - cur[1]));
        }
        return ans;
    }
}
