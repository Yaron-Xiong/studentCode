package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 1847. 最近的房间
 * 算术评级: 8
 * 第 51 场双周赛
 * Q4
 * 同步题目状态
 * <p>
 * 2082
 * 相关标签
 * 相关企业
 * 提示
 * 一个酒店里有 n 个房间，这些房间用二维整数数组 rooms 表示，
 * 其中 rooms[i] = [roomIdi, sizei] 表示有一个房间号为 roomIdi 的房间且它的面积为 sizei 。每一个房间号 roomIdi 保证是 独一无二 的。
 * <p>
 * 同时给你 k 个查询，用二维数组 queries 表示，其中 queries[j] = [preferredj, minSizej] 。第 j 个查询的答案是满足如下条件的房间 id ：
 * <p>
 * 房间的面积 至少 为 minSizej ，且
 * abs(id - preferredj) 的值 最小 ，其中 abs(x) 是 x 的绝对值。
 * 如果差的绝对值有 相等 的，选择 最小 的 id 。如果 没有满足条件的房间 ，答案为 -1 。
 * <p>
 * 请你返回长度为 k 的数组 answer ，其中 answer[j] 为第 j 个查询的结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：rooms = [[2,2],[1,2],[3,2]], queries = [[3,1],[3,3],[5,2]]
 * 输出：[3,-1,3]
 * 解释：查询的答案如下：
 * 查询 [3,1] ：房间 3 的面积为 2 ，大于等于 1 ，且号码是最接近 3 的，为 abs(3 - 3) = 0 ，所以答案为 3 。
 * 查询 [3,3] ：没有房间的面积至少为 3 ，所以答案为 -1 。
 * 查询 [5,2] ：房间 3 的面积为 2 ，大于等于 2 ，且号码是最接近 5 的，为 abs(3 - 5) = 2 ，所以答案为 3 。
 * 示例 2：
 * <p>
 * 输入：rooms = [[1,4],[2,3],[3,5],[4,1],[5,2]], queries = [[2,3],[2,4],[2,5]]
 * 输出：[2,1,3]
 * 解释：查询的答案如下：
 * 查询 [2,3] ：房间 2 的面积为 3 ，大于等于 3 ，且号码是最接近的，为 abs(2 - 2) = 0 ，所以答案为 2 。
 * 查询 [2,4] ：房间 1 和 3 的面积都至少为 4 ，答案为 1 因为它房间编号更小。
 * 查询 [2,5] ：房间 3 是唯一面积大于等于 5 的，所以答案为 3 。
 * <p>
 * 提示：
 * <p>
 * n == rooms.length
 * 1 <= n <= 105
 * k == queries.length
 * 1 <= k <= 104
 * 1 <= roomIdi, preferredj <= 107
 * 1 <= sizei, minSizej <= 107
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/closest-room/description/?envType=daily-question&envId=2024-12-16">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1847_ClosestRoom {
    public static void main(String[] args) {
        L1847_ClosestRoom l1847ClosestRoom = new L1847_ClosestRoom();
        int[] ints = l1847ClosestRoom.closestRoom(new int[][]{{1, 4}, {2, 3}, {3, 5}, {4, 1}, {5, 2}}, new int[][]{{2, 3}, {2, 4}, {2, 5}});
        System.out.println(Arrays.toString(ints));
    }

    public int[] closestRoom(int[][] rooms, int[][] queries) {
        Integer[] queryIds = new Integer[queries.length];
        Arrays.setAll(queryIds, i -> i);
        //从大到小开始处理
        Arrays.sort(queryIds, (a, b) -> -Integer.compare(queries[a][1], queries[b][1]));

        Arrays.sort(rooms, (a, b) -> -Integer.compare(a[1], b[1]));
        int index = 0;
        TreeSet<Integer> matchIds = new TreeSet<>();
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < queryIds.length; i++) {
            int queryIndex = queryIds[i];
            int querySize = queries[queryIndex][1];
            int queryId = queries[queryIndex][0];
            for (; index < rooms.length && rooms[index][1] >= querySize; index++) {
                matchIds.add(rooms[index][0]);
            }
            //找到最符合的id
            int diff = Integer.MAX_VALUE;
            Integer floorId = matchIds.floor(queryId);
            if (floorId != null) {
                diff = queryId - floorId;
                ans[queryIndex] = floorId;
            }

            Integer ceilingId = matchIds.ceiling(queryId);
            if (ceilingId != null && ceilingId - queryId < diff) {
                ans[queryIndex] = ceilingId;
            }
        }
        return ans;
    }
}
