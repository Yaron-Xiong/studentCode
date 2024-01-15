package com.accompnay.TopicAlgorithms.leetcode.l0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. 插入区间
 * 中等
 * 753
 * 相关企业
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 示例 3：
 * <p>
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 示例 4：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 示例 5：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 * <p>
 * 提示：
 * <p>
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/insert-interval/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L57_Insert {
    public static void main(String[] args) {
        L57_Insert l57Insert = new L57_Insert();
        System.out.println(Arrays.deepToString(l57Insert.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        //过滤左边区间
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i++]);
        }
        //此时从i开始的所有interval都可能是重叠区间
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
            left = Math.min(left, intervals[i][0]);
            right = Math.max(right, intervals[i][1]);
            i++;
        }
        list.add(new int[]{Math.min(left, newInterval[0]), Math.max(right, newInterval[1])});
        while (i < intervals.length) {
            list.add(intervals[i++]);
        }
        int[][] res = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            res[j] = list.get(j);
        }
        return res;
    }
}
