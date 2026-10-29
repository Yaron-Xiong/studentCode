package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2267. 检查是否有合法括号字符串路径
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 一个括号字符串是一个 非空 且只包含 '(' 和 ')' 的字符串。如果下面 任意 条件为 真 ，那么这个括号字符串就是 合法的 。
 * <p>
 * 字符串是 () 。
 * 字符串可以表示为 AB（A 连接 B），A 和 B 都是合法括号序列。
 * 字符串可以表示为 (A) ，其中 A 是合法括号序列。
 * 给你一个 m x n 的括号网格图矩阵 grid 。网格图中一个 合法括号路径 是满足以下所有条件的一条路径：
 * <p>
 * 路径开始于左上角格子 (0, 0) 。
 * 路径结束于右下角格子 (m - 1, n - 1) 。
 * 路径每次只会向 下 或者向 右 移动。
 * 路径经过的格子组成的括号字符串是 合法 的。
 * 如果网格图中存在一条 合法括号路径 ，请返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [["(","(","("],[")","(",")"],["(","(",")"],["(","(",")"]]
 * 输出：true
 * 解释：上图展示了两条路径，它们都是合法括号字符串路径。
 * 第一条路径得到的合法字符串是 "()(())" 。
 * 第二条路径得到的合法字符串是 "((()))" 。
 * 注意可能有其他的合法括号字符串路径。
 * 示例 2：
 * <p>
 * 输入：grid = [[")",")"],["(","("]]
 * 输出：false
 * 解释：两条可行路径分别得到 "))(" 和 ")((" 。由于它们都不是合法括号字符串，我们返回 false 。
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * grid[i][j] 要么是 '(' ，要么是 ')' 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/check-if-there-is-a-valid-parentheses-string-path/description/?envType=daily-question&envId=2026-09-29">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2267_HasValidPath {
    public boolean hasValidPath(char[][] grid) {
        //首位和末尾一定要符合 ( )
        if (grid[grid.length - 1][grid[0].length - 1] != ')' || grid[0][0] != '(') {
            return false;
        }
        //总长度一定要是偶数
        if ((grid.length + grid[0].length) % 2 != 1) {
            return false;
        }
        //理论上val 最后计算最长只能是 总长度的一半
        Boolean[][][] memo = new Boolean[grid.length][grid[0].length][(grid.length + grid[0].length - 1) / 2];
        return dfs2(0, 0, 0, memo, grid);
    }

    private boolean dfs2(int x, int y, int val, Boolean[][][] memo, char[][] grid) {
        if (x >= grid.length || y >= grid[0].length) {
            return false;
        }
        if (grid[x][y] == '(') {
            val++;
        } else {
            val--;
        }
        if (val < 0 || val > memo[x][y].length) {
            return false;
        }
        if (memo[x][y][val] != null) {
            return memo[x][y][val];
        }
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return val == 0;
        }
        return memo[x][y][val] = dfs2(x + 1, y, val, memo, grid) ||
                dfs2(x, y + 1, val, memo, grid);
    }
}
