package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.Arrays;

/**
 * 1288. 删除被覆盖区间
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 * <p>
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 * <p>
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 * <p>
 * 示例：
 * <p>
 * 输入：intervals = [[1,4],[3,6],[2,8]]
 * 输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 * <p>
 * 提示：​​​​​​
 * <p>
 * 1 <= intervals.length <= 1000
 * 0 <= intervals[i][0] < intervals[i][1] <= 10^5
 * 对于所有的 i != j：intervals[i] != intervals[j]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/remove-covered-intervals/description/?envType=daily-question&envId=2026-07-06">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1288_RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
                    int compare = a[0] - b[0];
                    if (compare == 0) {
                        return b[1] - a[1];
                    }
                    return compare;
                }
        );
        boolean[] delArr = new boolean[intervals.length];
        int delCnt = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (delArr[i]) {
                continue;
            }
            for (int j = i + 1; j < intervals.length; j++) {
                if (delArr[j]) {
                    continue;
                }
                if (intervals[i][0] <= intervals[j][0] && intervals[i][1] >= intervals[j][1]) {
                    delArr[j] = true;
                    delCnt++;
                }
            }
        }
        return intervals.length - delCnt;
    }
}
