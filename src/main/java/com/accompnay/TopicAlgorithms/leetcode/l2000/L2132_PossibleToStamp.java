package com.accompnay.TopicAlgorithms.leetcode.l2000;

/**
 * 2132. 用邮票贴满网格图
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 m x n 的二进制矩阵 grid ，每个格子要么为 0 （空）要么为 1 （被占据）。
 * <p>
 * 给你邮票的尺寸为 stampHeight x stampWidth 。我们想将邮票贴进二进制矩阵中，且满足以下 限制 和 要求 ：
 * <p>
 * 覆盖所有 空 格子。
 * 不覆盖任何 被占据 的格子。
 * 我们可以放入任意数目的邮票。
 * 邮票可以相互有 重叠 部分。
 * 邮票不允许 旋转 。
 * 邮票必须完全在矩阵 内 。
 * 如果在满足上述要求的前提下，可以放入邮票，请返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,0,0,0],[1,0,0,0],[1,0,0,0],[1,0,0,0],[1,0,0,0]], stampHeight = 4, stampWidth = 3
 * 输出：true
 * 解释：我们放入两个有重叠部分的邮票（图中标号为 1 和 2），它们能覆盖所有与空格子。
 * 示例 2：
 * <p>
 * 输入：grid = [[1,0,0,0],[0,1,0,0],[0,0,1,0],[0,0,0,1]], stampHeight = 2, stampWidth = 2
 * 输出：false
 * 解释：没办法放入邮票覆盖所有的空格子，且邮票不超出网格图以外。
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[r].length
 * 1 <= m, n <= 105
 * 1 <= m * n <= 2 * 105
 * grid[r][c] 要么是 0 ，要么是 1 。
 * 1 <= stampHeight, stampWidth <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/stamping-the-grid/description/?envType=daily-question&envId=2023-12-14">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2132_PossibleToStamp {
    public static void main(String[] args) {
        L2132_PossibleToStamp l2132PossibleToStamp = new L2132_PossibleToStamp();
        System.out.println(l2132PossibleToStamp.possibleToStamp(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}
        }, 1, 5));
    }

    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int[][] preSum = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 1; i < preSum.length; i++) {
            for (int j = 1; j < preSum[i].length; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        int[][] diff = new int[grid.length + 2][grid[0].length + 2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int i1 = i + stampHeight - 1;
                int j1 = j + stampWidth - 1;
                //检查能否将（i,j）->(i+stampHeight-1,j+stampWidth-1) 进行覆盖
                //条件为检查 这个区域前缀和是否>0
                if (i1 >= grid.length || j1 >= grid[i].length) {
                    continue;
                }
                if (preSum[i1 + 1][j1 + 1] - preSum[i1 + 1][j] - preSum[i][j1 + 1] + preSum[i][j] > 0) {
                    continue;
                }
                diff[i + 1][j + 1]++;
                diff[i1 + 2][j + 1]--;
                diff[i + 1][j1 + 2]--;
                diff[i1 + 2][j1 + 2]++;
            }
        }
        //检查区域是否都填充完毕
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                diff[i + 1][j + 1] += diff[i + 1][j] + diff[i][j + 1] - diff[i][j];
                if (diff[i + 1][j + 1] == 0 && grid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
