package com.yaronxiong.algorithms.leetcode.l0;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 864. 获取所有钥匙的最短路径
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个二维网格 grid ，其中：
 * <p>
 * '.' 代表一个空房间
 * '#' 代表一堵墙
 * '@' 是起点
 * 小写字母代表钥匙
 * 大写字母代表锁
 * 我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。我
 * 们不能在网格外面行走，也无法穿过一堵墙。如果途经一个钥匙，我们就把它捡起来。除非我们手里有对应的钥匙，否则无法通过锁。
 * <p>
 * 假设 k 为 钥匙/锁 的个数，且满足 1 <= k <= 6，字母表中的前 k 个字母在网格中都有自己对应的一个小写和一个大写字母。
 * 换言之，每个锁有唯一对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。
 * <p>
 * 返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = ["@.a..","###.#","b.A.B"]
 * 输出：8
 * 解释：目标是获得所有钥匙，而不是打开所有锁。
 * 示例 2：
 * <p>
 * 输入：grid = ["@..aA","..B#.","....b"]
 * 输出：6
 * 示例 3:
 * <p>
 * 输入: grid = ["@Aa"]
 * 输出: -1
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 30
 * grid[i][j] 只含有 '.', '#', '@', 'a'-'f' 以及 'A'-'F'
 * 钥匙的数目范围是 [1, 6]
 * 每个钥匙都对应一个 不同 的字母
 * 每个钥匙正好打开一个对应的锁
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/shortest-path-to-get-all-keys/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L864_ShortestPathAllKeys {
    public static void main(String[] args) {
        L864_ShortestPathAllKeys l864ShortestPathAllKeys = new L864_ShortestPathAllKeys();
        System.out.println(l864ShortestPathAllKeys.shortestPathAllKeys(new String[]{"@.a.#", "###.#", "b.A.B"}));
        System.out.println(l864ShortestPathAllKeys.shortestPathAllKeys(new String[]{"@..aA", "..B#.", "....b"}));
        System.out.println(l864ShortestPathAllKeys.shortestPathAllKeys(new String[]{"@Aa"}));
    }

    public int shortestPathAllKeys(String[] grid) {
        int cntKey = 0;
        int n = grid.length;
        int m = grid[0].length();
        Deque<int[]> dq = new ArrayDeque<>();
        int[][][] disk = new int[n][m][1 << 7];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                Arrays.fill(disk[i][j], Integer.MAX_VALUE);
                if (grid[i].charAt(j) == '@') {
                    dq.offer(new int[]{i, j, 0, 0});
                } else if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') {
                    cntKey++;
                }
            }
        }
        int[][] forwards = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!dq.isEmpty()) {
            int[] node = dq.pop();
            //开始移动
            for (int[] forward : forwards) {
                int newX = node[0] + forward[0];
                int newY = node[1] + forward[1];
                int holdKey = node[2];
                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    continue;
                }
                if (grid[newX].charAt(newY) == '#') {
                    //是墙壁
                    continue;
                }
                if (grid[newX].charAt(newY) >= 'A' && grid[newX].charAt(newY) <= 'F') {
                    //判断是否可以解锁？
                    int lock = 1 << (grid[newX].charAt(newY) - 'A');
                    boolean unLock = (holdKey & lock) == lock;
                    if (!unLock) {
                        continue;
                    }
                } else if (grid[newX].charAt(newY) >= 'a' && grid[newX].charAt(newY) <= 'f') {
                    //持有钥匙++
                    holdKey |= (1 << (grid[newX].charAt(newY) - 'a'));
                }
                if (holdKey == (1 << cntKey) - 1) {
                    return node[3] + 1;
                }
                if (node[3] + 1 < disk[newX][newY][holdKey]) {
                    disk[newX][newY][holdKey] = node[3] + 1;
                    dq.offer(new int[]{newX, newY, holdKey, node[3] + 1});
                }
            }
        }
        return -1;
    }
}
