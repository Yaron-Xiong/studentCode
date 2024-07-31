package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2101. 引爆最多的炸弹
 * 算术评级: 5
 * 第 67 场双周赛
 * Q3
 * 1880
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。
 * <p>
 * 炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，其中 bombs[i] = [xi, yi, ri] 。xi 和 yi 表示第 i 个炸弹的 X 和 Y 坐标，ri 表示爆炸范围的 半径 。
 * <p>
 * 你需要选择引爆 一个 炸弹。当这个炸弹被引爆时，所有 在它爆炸范围内的炸弹都会被引爆，这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。
 * <p>
 * 给你数组 bombs ，请你返回在引爆 一个 炸弹的前提下，最多 能引爆的炸弹数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：bombs = [[2,1,3],[6,1,4]]
 * 输出：2
 * 解释：
 * 上图展示了 2 个炸弹的位置和爆炸范围。
 * 如果我们引爆左边的炸弹，右边的炸弹不会被影响。
 * 但如果我们引爆右边的炸弹，两个炸弹都会爆炸。
 * 所以最多能引爆的炸弹数目是 max(1, 2) = 2 。
 * 示例 2：
 * <p>
 * 输入：bombs = [[1,1,5],[10,10,5]]
 * 输出：1
 * 解释：
 * 引爆任意一个炸弹都不会引爆另一个炸弹。所以最多能引爆的炸弹数目为 1 。
 * 示例 3：
 * <p>
 * 输入：bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
 * 输出：5
 * 解释：
 * 最佳引爆炸弹为炸弹 0 ，因为：
 * - 炸弹 0 引爆炸弹 1 和 2 。红色圆表示炸弹 0 的爆炸范围。
 * - 炸弹 2 引爆炸弹 3 。蓝色圆表示炸弹 2 的爆炸范围。
 * - 炸弹 3 引爆炸弹 4 。绿色圆表示炸弹 3 的爆炸范围。
 * 所以总共有 5 个炸弹被引爆。
 * <p>
 * 提示：
 * <p>
 * 1 <= bombs.length <= 100
 * bombs[i].length == 3
 * 1 <= xi, yi, ri <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/detonate-the-maximum-bombs/description/?envType=daily-question&envId=2024-07-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2101_MaximumDetonation {
    public static void main(String[] args) {
        L2101_MaximumDetonation l2101MaximumDetonation = new L2101_MaximumDetonation();
        System.out.println(l2101MaximumDetonation.maximumDetonation(new int[][]{{2, 1, 3}, {6, 1, 4}}));
    }

    public int maximumDetonation(int[][] bombs) {
        int max = 1;
        for (int i = 0; i < bombs.length; i++) {
            boolean[] visited = new boolean[bombs.length];
            visited[i] = true;
            int cnt = dfs2(bombs, visited, i) + 1;
            max = Math.max(max, cnt);
        }
        return max;
    }

    private int dfs2(int[][] bombs, boolean[] visited, int i) {
        int ans = 0;
        for (int j = 0; j < bombs.length; j++) {
            if (visited[j] || i == j) {
                continue;
            }
            //判断i能不能让j引爆
            int[] arr1 = bombs[i];
            int[] arr2 = bombs[j];
            long x = arr1[0] - arr2[0];
            long y = arr1[1] - arr2[1];
            if (x * x + y * y > (long) arr1[2] * arr1[2]) {
                continue;
            }
            visited[j] = true;
            ans += dfs2(bombs, visited, j) + 1;
        }
        return ans;
    }
}
