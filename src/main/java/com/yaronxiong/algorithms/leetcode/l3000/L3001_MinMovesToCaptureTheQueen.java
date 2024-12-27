package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3001. 捕获黑皇后需要的最少移动次数
 * 算术评级: 4
 * 第 379 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1797
 * 相关标签
 * 相关企业
 * 提示
 * 现有一个下标从 1 开始的 8 x 8 棋盘，上面有 3 枚棋子。
 * <p>
 * 给你 6 个整数 a 、b 、c 、d 、e 和 f ，其中：
 * <p>
 * (a, b) 表示白色车的位置。
 * (c, d) 表示白色象的位置。
 * (e, f) 表示黑皇后的位置。
 * 假定你只能移动白色棋子，返回捕获黑皇后所需的最少移动次数。
 * <p>
 * 请注意：
 * <p>
 * 车可以向垂直或水平方向移动任意数量的格子，但不能跳过其他棋子。
 * 象可以沿对角线方向移动任意数量的格子，但不能跳过其他棋子。
 * 如果车或象能移向皇后所在的格子，则认为它们可以捕获皇后。
 * 皇后不能移动。
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 1, b = 1, c = 8, d = 8, e = 2, f = 3
 * 输出：2
 * 解释：将白色车先移动到 (1, 3) ，然后移动到 (2, 3) 来捕获黑皇后，共需移动 2 次。
 * 由于起始时没有任何棋子正在攻击黑皇后，要想捕获黑皇后，移动次数不可能少于 2 次。
 * 示例 2：
 * <p>
 * <p>
 * 输入：a = 5, b = 3, c = 3, d = 4, e = 5, f = 2
 * 输出：1
 * 解释：可以通过以下任一方式移动 1 次捕获黑皇后：
 * - 将白色车移动到 (5, 2) 。
 * - 将白色象移动到 (5, 2) 。
 * <p>
 * 提示：
 * <p>
 * 1 <= a, b, c, d, e, f <= 8
 * 两枚棋子不会同时出现在同一个格子上。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-moves-to-capture-the-queen/?envType=daily-question&envId=2024-12-05">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3001_MinMovesToCaptureTheQueen {
    public static void main(String[] args) {
        L3001_MinMovesToCaptureTheQueen l3001MinMovesToCaptureTheQueen = new L3001_MinMovesToCaptureTheQueen();
        System.out.println(l3001MinMovesToCaptureTheQueen.minMovesToCaptureTheQueen(5, 8, 8, 8, 1, 8));
    }

    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        // 车跟皇后同一行
        if (a == e) {
            //判断中间是否有大象
            if (a == c && isMid(b, f, d)) {
                return 2;
            }
            return 1;
        }
        // 车跟皇后同一列
        if (b == f) {
            if (b == d && isMid(a, e, c)) {
                return 2;
            }
            return 1;
        }

        //大象跟皇后同一个主对角线
        if (c + d == e + f) {
            //如果车也在主对角线
            if (c + d == a + b && isMid(c, e, a)) {
                return 2;
            }
            return 1;
        }

        //大象跟皇后在同一个副对角线
        if (c - d == e - f) {
            //如果车在这一条对角线
            if (c - d == a - b && isMid(c, e, a)) {
                return 2;
            }
            return 1;
        }
        return 2;
    }

    private boolean isMid(int a, int b, int checkValue) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        return checkValue >= min && checkValue <= max;
    }


}
