package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.*;

/**
 * 1766. 互质树
 * 第 46 场双周赛
 * Q4
 * 2232
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 n 个节点的树（也就是一个无环连通无向图），节点编号从 0 到 n - 1 ，且恰好有 n - 1 条边，每个节点有一个值。树的 根节点 为 0 号点。
 * <p>
 * 给你一个整数数组 nums 和一个二维数组 edges 来表示这棵树。nums[i] 表示第 i 个点的值，edges[j] = [uj, vj] 表示节点 uj 和节点 vj 在树中有一条边。
 * <p>
 * 当 gcd(x, y) == 1 ，我们称两个数 x 和 y 是 互质的 ，其中 gcd(x, y) 是 x 和 y 的 最大公约数 。
 * <p>
 * 从节点 i 到 根 最短路径上的点都是节点 i 的祖先节点。一个节点 不是 它自己的祖先节点。
 * <p>
 * 请你返回一个大小为 n 的数组 ans ，其中 ans[i]是离节点 i 最近的祖先节点且满足 nums[i] 和 nums[ans[i]] 是 互质的 ，如果不存在这样的祖先节点，ans[i] 为 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,3,2], edges = [[0,1],[1,2],[1,3]]
 * 输出：[-1,0,0,1]
 * 解释：上图中，每个节点的值在括号中表示。
 * - 节点 0 没有互质祖先。
 * - 节点 1 只有一个祖先节点 0 。它们的值是互质的（gcd(2,3) == 1）。
 * - 节点 2 有两个祖先节点，分别是节点 1 和节点 0 。节点 1 的值与它的值不是互质的（gcd(3,3) == 3）但节点 0 的值是互质的(gcd(2,3) == 1)，所以节点 0 是最近的符合要求的祖先节点。
 * - 节点 3 有两个祖先节点，分别是节点 1 和节点 0 。它与节点 1 互质（gcd(3,2) == 1），所以节点 1 是离它最近的符合要求的祖先节点。
 * 示例 2：
 * <p>
 * 输入：nums = [5,6,10,2,3,6,15], edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]
 * 输出：[-1,0,-1,0,0,0,-1]
 * <p>
 * 提示：
 * <p>
 * nums.length == n
 * 1 <= nums[i] <= 50
 * 1 <= n <= 105
 * edges.length == n - 1
 * edges[j].length == 2
 * 0 <= uj, vj < n
 * uj != vj
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/tree-of-coprimes/description/?envType=daily-question&envId=2024-04-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1766_GetCoprimes {
    public static void main(String[] args) {
        L1766_GetCoprimes l1766GetCoprimes = new L1766_GetCoprimes();
        System.out.println(Arrays.toString(l1766GetCoprimes.getCoprimes(new int[]{5, 6, 10, 2, 3, 6, 15}, new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}})));
    }

    public int[] getCoprimes(int[] nums, int[][] edges) {
        List<Integer>[] graph = new List[nums.length];
        Arrays.setAll(graph, a -> new ArrayList<Integer>());
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        this.ans = new int[nums.length];
        this.nums = nums;
        this.graph = graph;
        this.paths = new LinkedList[51];
        this.gcdCache = new List[51];
        for (int i = 1; i < gcdCache.length; i++) {
            this.gcdCache[i] = new ArrayList<>();
            for (int j = 1; j <= 50; j++) {
                if (gcd(i, j) == 1) {
                    this.gcdCache[i].add(j);
                }
            }
        }
        Arrays.setAll(paths, a -> new LinkedList<>());
        dfs(0, 0, 0);
        return ans;
    }

    int[] nums;
    List<Integer>[] graph;
    int[] ans;
    LinkedList<int[]>[] paths;
    List<Integer>[] gcdCache;

    private void dfs(int curNode, int parent, int level) {
        //检查是否互为质数
        ans[curNode] = -1;
        int curLevel = 0;
        for (Integer gcd : gcdCache[nums[curNode]]) {
            if (!paths[gcd].isEmpty() && paths[gcd].peekFirst()[1] >= curLevel) {
                curLevel = paths[gcd].peekFirst()[1];
                ans[curNode] = paths[gcd].peekFirst()[0];
            }
        }
        paths[nums[curNode]].addFirst(new int[]{curNode, level});
        for (Integer neighbor : graph[curNode]) {
            if (neighbor == parent) {
                continue;
            }
            dfs(neighbor, curNode, level + 1);
        }
        paths[nums[curNode]].removeFirst();
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
