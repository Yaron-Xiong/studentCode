package com.accompnay.TopicAlgorithms.leetcode.l2000;

import java.util.*;

/**
 * 2581. 统计可能的树根数目
 * 第 99 场双周赛
 * Q4
 * 2228
 * 相关标签
 * 相关企业
 * 提示
 * Alice 有一棵 n 个节点的树，节点编号为 0 到 n - 1 。树用一个长度为 n - 1 的二维整数数组 edges 表示，
 * 其中 edges[i] = [ai, bi] ，表示树中节点 ai 和 bi 之间有一条边。
 * <p>
 * Alice 想要 Bob 找到这棵树的根。她允许 Bob 对这棵树进行若干次 猜测 。每一次猜测，Bob 做如下事情：
 * <p>
 * 选择两个 不相等 的整数 u 和 v ，且树中必须存在边 [u, v] 。
 * Bob 猜测树中 u 是 v 的 父节点 。
 * Bob 的猜测用二维整数数组 guesses 表示，其中 guesses[j] = [uj, vj] 表示 Bob 猜 uj 是 vj 的父节点。
 * <p>
 * Alice 非常懒，她不想逐个回答 Bob 的猜测，只告诉 Bob 这些猜测里面 至少 有 k 个猜测的结果为 true 。
 * <p>
 * 给你二维整数数组 edges ，Bob 的所有猜测和整数 k ，请你返回可能成为树根的 节点数目 。如果没有这样的树，则返回 0。
 * <p>
 * 示例 1：
 * <p>
 * 输入：edges = [[0,1],[1,2],[1,3],[4,2]], guesses = [[1,3],[0,1],[1,0],[2,4]], k = 3
 * 输出：3
 * 解释：
 * 根为节点 0 ，正确的猜测为 [1,3], [0,1], [2,4]
 * 根为节点 1 ，正确的猜测为 [1,3], [1,0], [2,4]
 * 根为节点 2 ，正确的猜测为 [1,3], [1,0], [2,4]
 * 根为节点 3 ，正确的猜测为 [1,0], [2,4]
 * 根为节点 4 ，正确的猜测为 [1,3], [1,0]
 * 节点 0 ，1 或 2 为根时，可以得到 3 个正确的猜测。
 * 示例 2：
 * <p>
 * 输入：edges = [[0,1],[1,2],[2,3],[3,4]], guesses = [[1,0],[3,4],[2,1],[3,2]], k = 1
 * 输出：5
 * 解释：
 * 根为节点 0 ，正确的猜测为 [3,4]
 * 根为节点 1 ，正确的猜测为 [1,0], [3,4]
 * 根为节点 2 ，正确的猜测为 [1,0], [2,1], [3,4]
 * 根为节点 3 ，正确的猜测为 [1,0], [2,1], [3,2], [3,4]
 * 根为节点 4 ，正确的猜测为 [1,0], [2,1], [3,2]
 * 任何节点为根，都至少有 1 个正确的猜测。
 * <p>
 * 提示：
 * <p>
 * edges.length == n - 1
 * 2 <= n <= 105
 * 1 <= guesses.length <= 105
 * 0 <= ai, bi, uj, vj <= n - 1
 * ai != bi
 * uj != vj
 * edges 表示一棵有效的树。
 * guesses[j] 是树中的一条边。
 * guesses 是唯一的。
 * 0 <= k <= guesses.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-number-of-possible-root-nodes/description/?envType=daily-question&envId=2024-02-29">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2581_RootCount {


    public static void main(String[] args) {
        L2581_RootCount l2581RootCount = new L2581_RootCount();
        System.out.println(l2581RootCount.rootCount(new int[][]{{0, 1}, {1, 2}, {1, 3}, {4, 2}}, new int[][]{{1, 3}, {0, 1}, {1, 0}, {2, 4}}, 3));
    }

    private List<Integer>[] graph;
    private Set<Long> guessesSet;
    private int cnt0;
    private int k;
    private int ans;

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        int n = edges.length + 1;
        this.k = k;
        graph = new List[n];
        Arrays.setAll(graph, a -> new ArrayList<>());
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        //假设以每个节点为根，能满足多少个 猜测（guesses）
        guessesSet = new HashSet<>();
        for (int[] guess : guesses) {
            guessesSet.add((long) guess[0] << 32 | guess[1]);
        }
        //先计算 以0为根时的cnt，每次交换根，也就只有交换的部分会发生变化
        //如 (x,y) -> (y,x) 那么以x为根cnt数量 和 以y为根的cnt数量 只有x-y 会发生变化
        dfs(0, 0);
        reRoot(0, 0, cnt0);
        return ans;
    }

    private void reRoot(int node, int parent, int cnt) {
        if (cnt >= k) {
            ans++;
        }
        for (Integer neighbor : graph[node]) {
            if (neighbor == parent) {
                continue;
            }
            int c = cnt;
            //原来已经有了 (node,neighbor)的关系，现在变成了 (neighbor,node)的关系
            if (this.guessesSet.contains((long) node << 32 | neighbor)) {
                c--;
            }
            //扭转关系后 存在猜测进行+1
            if (this.guessesSet.contains((long) neighbor << 32 | node)) {
                c++;
            }
            reRoot(neighbor, node, c);
        }
    }

    private void dfs(int node, int parent) {
        for (Integer neighbor : graph[node]) {
            if (neighbor == parent) {
                continue;
            }
            if (guessesSet.contains((long) node << 32 | neighbor)) {
                cnt0++;
            }
            dfs(neighbor, node);
        }
    }

}
