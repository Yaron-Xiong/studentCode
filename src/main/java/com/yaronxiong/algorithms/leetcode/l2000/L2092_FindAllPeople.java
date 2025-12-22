package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.*;

/**
 * 2092. 找出知晓秘密的所有专家
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n ，表示有 n 个专家从 0 到 n - 1 编号。另
 * 外给你一个下标从 0 开始的二维整数数组 meetings ，其中 meetings[i] = [xi, yi, timei] 表示专家 xi 和专家 yi 在时间 timei 要开一场会。
 * 一个专家可以同时参加 多场会议 。最后，给你一个整数 firstPerson 。
 * <p>
 * 专家 0 有一个 秘密 ，最初，他在时间 0 将这个秘密分享给了专家 firstPerson 。
 * 接着，这个秘密会在每次有知晓这个秘密的专家参加会议时进行传播。更正式的表达是，每次会议，如果专家 xi 在时间 timei 时知晓这个秘密，那么他将会与专家 yi 分享这个秘密，反之亦然。
 * <p>
 * 秘密共享是 瞬时发生 的。也就是说，在同一时间，一个专家不光可以接收到秘密，还能在其他会议上与其他专家分享。
 * <p>
 * 在所有会议都结束之后，返回所有知晓这个秘密的专家列表。你可以按 任何顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 6, meetings = [[1,2,5],[2,3,8],[1,5,10]], firstPerson = 1
 * 输出：[0,1,2,3,5]
 * 解释：
 * 时间 0 ，专家 0 将秘密与专家 1 共享。
 * 时间 5 ，专家 1 将秘密与专家 2 共享。
 * 时间 8 ，专家 2 将秘密与专家 3 共享。
 * 时间 10 ，专家 1 将秘密与专家 5 共享。
 * 因此，在所有会议结束后，专家 0、1、2、3 和 5 都将知晓这个秘密。
 * 示例 2：
 * <p>
 * 输入：n = 4, meetings = [[3,1,3],[1,2,2],[0,3,3]], firstPerson = 3
 * 输出：[0,1,3]
 * 解释：
 * 时间 0 ，专家 0 将秘密与专家 3 共享。
 * 时间 2 ，专家 1 与专家 2 都不知晓这个秘密。
 * 时间 3 ，专家 3 将秘密与专家 0 和专家 1 共享。
 * 因此，在所有会议结束后，专家 0、1 和 3 都将知晓这个秘密。
 * 示例 3：
 * <p>
 * 输入：n = 5, meetings = [[3,4,2],[1,2,1],[2,3,1]], firstPerson = 1
 * 输出：[0,1,2,3,4]
 * 解释：
 * 时间 0 ，专家 0 将秘密与专家 1 共享。
 * 时间 1 ，专家 1 将秘密与专家 2 共享，专家 2 将秘密与专家 3 共享。
 * 注意，专家 2 可以在收到秘密的同一时间分享此秘密。
 * 时间 2 ，专家 3 将秘密与专家 4 共享。
 * 因此，在所有会议结束后，专家 0、1、2、3 和 4 都将知晓这个秘密。
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 105
 * 1 <= meetings.length <= 105
 * meetings[i].length == 3
 * 0 <= xi, yi <= n - 1
 * xi != yi
 * 1 <= timei <= 105
 * 1 <= firstPerson <= n - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-all-people-with-secret/description/?envType=daily-question&envId=2025-12-19">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2092_FindAllPeople {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        //知道秘密的人
        Set<Integer> knowPeople = new HashSet<>();
        knowPeople.add(firstPerson);
        knowPeople.add(0);
        //按时间遍历 meetings
        for (int i = 0; i < meetings.length; ) {
            int baseTime = meetings[i][2];
            Map<Integer, List<Integer>> graph = new HashMap<>();
            //获取到相同的时间组
            for (; i < meetings.length && meetings[i][2] == baseTime; i++) {
                graph.computeIfAbsent(meetings[i][0], a -> new ArrayList<>()).add(meetings[i][1]);
                graph.computeIfAbsent(meetings[i][1], a -> new ArrayList<>()).add(meetings[i][0]);
            }
            //看这个图最开始有什么人知道了，然后开始衍生
            boolean[] visit = new boolean[n];
            for (Integer people : graph.keySet()) {
                if (knowPeople.contains(people)) {
                    //从这个点开始衍生
                    dfs2(people, graph, knowPeople, visit);
                }
            }
        }
        return new ArrayList<>(knowPeople);
    }

    private void dfs2(Integer curValue, Map<Integer, List<Integer>> graph, Set<Integer> knowPeople, boolean[] visit) {
        if (visit[curValue]) {
            return;
        }
        visit[curValue] = true;
        knowPeople.add(curValue);
        for (Integer neighbor : graph.get(curValue)) {
            dfs2(neighbor, graph, knowPeople, visit);
        }
    }
}
