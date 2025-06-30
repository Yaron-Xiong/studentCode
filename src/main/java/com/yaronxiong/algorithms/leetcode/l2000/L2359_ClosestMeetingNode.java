package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.Arrays;

/**
 * 2359. 找到离给定两个节点最近的节点
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 n 个节点的 有向图 ，节点编号为 0 到 n - 1 ，每个节点 至多 有一条出边。
 * <p>
 * 有向图用大小为 n 下标从 0 开始的数组 edges 表示，表示节点 i 有一条有向边指向 edges[i] 。如果节点 i 没有出边，那么 edges[i] == -1 。
 * <p>
 * 同时给你两个节点 node1 和 node2 。
 * <p>
 * 请你返回一个从 node1 和 node2 都能到达节点的编号，使节点 node1 和节点 node2 到这个节点的距离 较大值最小化。
 * 如果有多个答案，请返回 最小 的节点编号。如果答案不存在，返回 -1 。
 * <p>
 * 注意 edges 可能包含环。
 * <p>
 * 示例 1：
 * <p>
 * 输入：edges = [2,2,3,-1], node1 = 0, node2 = 1
 * 输出：2
 * 解释：从节点 0 到节点 2 的距离为 1 ，从节点 1 到节点 2 的距离为 1 。
 * 两个距离的较大值为 1 。我们无法得到一个比 1 更小的较大值，所以我们返回节点 2 。
 * 示例 2：
 * <p>
 * 输入：edges = [1,2,-1], node1 = 0, node2 = 2
 * 输出：2
 * 解释：节点 0 到节点 2 的距离为 2 ，节点 2 到它自己的距离为 0 。
 * 两个距离的较大值为 2 。我们无法得到一个比 2 更小的较大值，所以我们返回节点 2 。
 * <p>
 * 提示：
 * <p>
 * n == edges.length
 * 2 <= n <= 105
 * -1 <= edges[i] < n
 * edges[i] != i
 * 0 <= node1, node2 < n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii/description/?envType=daily-question&envId=2025-05-29">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2359_ClosestMeetingNode {
    public static void main(String[] args) {
        L2359_ClosestMeetingNode l2359ClosestMeetingNode = new L2359_ClosestMeetingNode();
        System.out.println(l2359ClosestMeetingNode.closestMeetingNode(new int[]{4, 4, 4, 5, 1, 2, 2}, 1, 1));
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dis1 = cal(edges, node1);
        int[] dis2 = cal(edges, node2);
        int minDis = Integer.MAX_VALUE;
        int minNode = -1;
        for (int i = 0; i < dis1.length; i++) {
            if (dis2[i] < 0 || dis1[i] < 0) {
                continue;
            }
            int v = Math.max(dis1[i], dis2[i]);
            if (v < minDis) {
                minDis = v;
                minNode = i;
            }
        }
        return minNode;
    }

    public int[] cal(int[] edges, int node) {
        int[] dis = new int[edges.length];
        //从node1开始出发
        Arrays.fill(dis, -1);
        int curNode = node;
        int curStep = 0;
        while (curNode != -1) {
            if (dis[curNode] != -1) {
                break;
            }
            dis[curNode] = curStep;
            curNode = edges[curNode];
            curStep++;
        }
        return dis;
    }
}
