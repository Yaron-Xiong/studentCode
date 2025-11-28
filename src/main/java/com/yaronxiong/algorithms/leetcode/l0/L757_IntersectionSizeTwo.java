package com.yaronxiong.algorithms.leetcode.l0;

import java.util.Arrays;

/**
 * 757. 设置交集大小至少为2
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个二维整数数组 intervals ，其中 intervals[i] = [starti, endi] 表示从 starti 到 endi 的所有整数，包括 starti 和 endi 。
 * <p>
 * 包含集合 是一个名为 nums 的数组，并满足 intervals 中的每个区间都 至少 有 两个 整数在 nums 中。
 * <p>
 * 例如，如果 intervals = [[1,3], [3,7], [8,9]] ，那么 [1,2,4,7,8,9] 和 [2,3,4,8,9] 都符合 包含集合 的定义。
 * 返回包含集合可能的最小大小。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[3,7],[8,9]]
 * 输出：5
 * 解释：nums = [2, 3, 4, 8, 9].
 * 可以证明不存在元素数量为 4 的包含集合。
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,3],[1,4],[2,5],[3,5]]
 * 输出：3
 * 解释：nums = [2, 3, 4].
 * 可以证明不存在元素数量为 2 的包含集合。
 * 示例 3：
 * <p>
 * 输入：intervals = [[1,2],[2,3],[2,4],[4,5]]
 * 输出：5
 * 解释：nums = [1, 2, 3, 4, 5].
 * 可以证明不存在元素数量为 4 的包含集合。
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 3000
 * intervals[i].length == 2
 * 0 <= starti < endi <= 108
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/set-intersection-size-at-least-two/description/?envType=daily-question&envId=2025-11-20">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L757_IntersectionSizeTwo {
    public static void main(String[] args) {
        L757_IntersectionSizeTwo l757IntersectionSizeTwo = new L757_IntersectionSizeTwo();
        System.out.println(l757IntersectionSizeTwo.intersectionSizeTwo(new int[][]{{2, 10}, {3, 7}, {3, 15}, {4, 11}, {6, 12}, {6, 16}, {7, 8}, {7, 11}, {7, 15}, {11, 12}}));
        System.out.println(l757IntersectionSizeTwo.intersectionSizeTwo(new int[][]{{1, 3}, {3, 7}, {8, 9}}));
        System.out.println(l757IntersectionSizeTwo.intersectionSizeTwo(new int[][]{{1, 3}, {1, 4}, {2, 5}, {3, 5}}));
        System.out.println(l757IntersectionSizeTwo.intersectionSizeTwo(new int[][]{{1, 2}, {2, 3}, {2, 4}, {4, 5}}));

    }

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int ans = 0;
        //开始算交集
        int s = -1;
        int e = -1;
        //[1,2],[0,2],[2,3],[2,4],[4,5]
        for (int[] interval : intervals) {
            int a = interval[0];
            int b = interval[1];
            //全覆盖既 [1,2] [0,2] 的情况
            if (a <= s) {
                continue;
            }
            //只覆盖了一个点 [0,2] [2,7]的情况
            // s = 1 ,e = 2 => 2,7
            if (a <= e) {
                ans++;
                s = e;
                e = b;
            } else {
                //完全没交集
                ans += 2;
                s = b - 1;
                e = b;
            }
        }
        return ans;
    }
}
