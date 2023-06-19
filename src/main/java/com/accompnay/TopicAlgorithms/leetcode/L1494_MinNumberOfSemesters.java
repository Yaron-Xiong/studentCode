package com.accompnay.TopicAlgorithms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1494. 并行课程 II
 * 提示
 * 困难
 * 125
 * 相关企业
 * 给你一个整数 n 表示某所大学里课程的数目，编号为 1 到 n ，数组 relations 中，
 * relations[i] = [xi, yi]  表示一个先修课的关系，也就是课程 xi 必须在课程 yi 之前上。同时你还有一个整数 k 。
 * <p>
 * 在一个学期中，你 最多 可以同时上 k 门课，前提是这些课的先修课在之前的学期里已经上过了。
 * <p>
 * 请你返回上完所有课最少需要多少个学期。题目保证一定存在一种上完所有课的方式。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, relations = [[2,1],[3,1],[1,4]], k = 2
 * 输出：3
 * 解释：上图展示了题目输入的图。在第一个学期中，我们可以上课程 2 和课程 3 。然后第二个学期上课程 1 ，第三个学期上课程 4 。
 * 示例 2：
 * <p>
 * 输入：n = 5, relations = [[2,1],[3,1],[4,1],[1,5]], k = 2
 * 输出：4
 * 解释：上图展示了题目输入的图。一个最优方案是：第一学期上课程 2 和 3，第二学期上课程 4 ，第三学期上课程 1 ，第四学期上课程 5 。
 * 示例 3：
 * <p>
 * 输入：n = 11, relations = [], k = 2
 * 输出：6
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 15
 * 1 <= k <= n
 * 0 <= relations.length <= n * (n-1) / 2
 * relations[i].length == 2
 * 1 <= xi, yi <= n
 * xi != yi
 * 所有先修关系都是不同的，也就是说 relations[i] != relations[j] 。
 * 题目输入的图是个有向无环图。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/parallel-courses-ii/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1494_MinNumberOfSemesters {
    public static void main(String[] args) {
        L1494_MinNumberOfSemesters l1494MinNumberOfSemesters = new L1494_MinNumberOfSemesters();
        System.out.println(l1494MinNumberOfSemesters.minNumberOfSemesters(13, new int[][]{{12,8},{2,4},{3,7},{6,8},{11,8},{9,4},{9,7},{12,4},{11,4},{6,4},{1,4},{10,7},{10,4},{1,7},{1,8},{2,7},{8,4},{10,8},{12,7},{5,4},{3,4},{11,7},{7,4},{13,4},{9,8},{13,8}}, 9));
    }

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] entryArr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] relation : relations) {
            int form = relation[0];
            int to = relation[1];
            graph.get(form).add(to);
            entryArr[to]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < entryArr.length; i++) {
            if (entryArr[i] == 0) {
                queue.add(i);
            }
        }

        int res = 0;
        while (!queue.isEmpty()) {
            //每次可以处理 size<= k
            int size = queue.size();
            while (size > 0) {
                int curK = k;
                while (size > 0 && curK > 0) {
                    curK--;
                    size--;
                    Integer poll = queue.poll();
                    for (Integer neighbor : graph.get(poll)) {
                        entryArr[neighbor]--;
                        if (entryArr[neighbor] == 0) {
                            queue.add(neighbor);
                        }
                    }
                }
                res++;
            }
        }

        return res;
    }
}
