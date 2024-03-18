package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.*;

/**
 * 2127. 参加会议的最多员工数
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 一个公司准备组织一场会议，邀请名单上有 n 位员工。公司准备了一张 圆形 的桌子，可以坐下 任意数目 的员工。
 * <p>
 * 员工编号为 0 到 n - 1 。每位员工都有一位 喜欢 的员工，每位员工 当且仅当 他被安排在喜欢员工的旁边，他才会参加会议。每位员工喜欢的员工 不会 是他自己。
 * <p>
 * 给你一个下标从 0 开始的整数数组 favorite ，其中 favorite[i] 表示第 i 位员工喜欢的员工。请你返回参加会议的 最多员工数目 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：favorite = [2,2,1,2]
 * 输出：3
 * 解释：
 * 上图展示了公司邀请员工 0，1 和 2 参加会议以及他们在圆桌上的座位。
 * 没办法邀请所有员工参与会议，因为员工 2 没办法同时坐在 0，1 和 3 员工的旁边。
 * 注意，公司也可以邀请员工 1，2 和 3 参加会议。
 * 所以最多参加会议的员工数目为 3 。
 * 示例 2：
 * <p>
 * 输入：favorite = [1,2,0]
 * 输出：3
 * 解释：
 * 每个员工都至少是另一个员工喜欢的员工。所以公司邀请他们所有人参加会议的前提是所有人都参加了会议。
 * 座位安排同图 1 所示：
 * - 员工 0 坐在员工 2 和 1 之间。
 * - 员工 1 坐在员工 0 和 2 之间。
 * - 员工 2 坐在员工 1 和 0 之间。
 * 参与会议的最多员工数目为 3 。
 * 示例 3：
 * <p>
 * 输入：favorite = [3,0,1,4,1]
 * 输出：4
 * 解释：
 * 上图展示了公司可以邀请员工 0，1，3 和 4 参加会议以及他们在圆桌上的座位。
 * 员工 2 无法参加，因为他喜欢的员工 0 旁边的座位已经被占领了。
 * 所以公司只能不邀请员工 2 。
 * 参加会议的最多员工数目为 4 。
 * <p>
 * 提示：
 * <p>
 * n == favorite.length
 * 2 <= n <= 105
 * 0 <= favorite[i] <= n - 1
 * favorite[i] != i
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-employees-to-be-invited-to-a-meeting/?envType=daily-question&envId=2023-11-01">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2127_MaximumInvitations {
    public int maximumInvitations(int[] favorite) {
        //统计每个节点的入度
        int[] dge = new int[favorite.length];
        for (int j : favorite) {
            dge[j]++;
        }
        //进行拓扑排序，清空所有树枝节点
        List<Integer>[] graph = new List[favorite.length];
        Arrays.setAll(graph, a -> new ArrayList<>());
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < dge.length; i++) {
            if (dge[i] == 0) {
                deque.addLast(i);
            }
        }
        while (!deque.isEmpty()) {
            Integer node = deque.pollFirst();
            graph[favorite[node]].add(node);
            if (--dge[favorite[node]] == 0) {
                deque.addLast(favorite[node]);
            }
        }

        //从环上节点开始遍历
        int maxRingSize = 0;
        int sumChainSize = 0;
        for (int i = 0; i < favorite.length; i++) {
            //入度等于0说明不是环上节点，跳过
            if (dge[i] == 0) {
                continue;
            }

            //遍历环上的点
            dge[i] = 0;
            int ringSize = 1;
            //从i开始走一圈
            for (int nextNode = favorite[i]; i != nextNode; nextNode = favorite[nextNode]) {
                dge[nextNode] = 0;
                ringSize++;
            }

            //如果环的长度为2则
            if (ringSize == 2) {
                //找到自己 或者另外一个人中最长的链表
                sumChainSize = Math.max(sumChainSize, dfs(i, graph) + dfs(favorite[i], graph));
            } else {
                maxRingSize = Math.max(maxRingSize, ringSize);
            }
        }
        return Math.max(sumChainSize, maxRingSize);
    }

    private int dfs(int i, List<Integer>[] graph) {
        int maxDepth = 1;
        for (Integer son : graph[i]) {
            maxDepth = Math.max(maxDepth, dfs(son, graph) + 1);
        }
        return maxDepth;
    }
}
