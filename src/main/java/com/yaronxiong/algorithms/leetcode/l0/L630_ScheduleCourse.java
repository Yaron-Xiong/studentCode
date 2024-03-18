package com.yaronxiong.algorithms.leetcode.l0;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 630. 课程表 III
 * 提示
 * 困难
 * 464
 * 相关企业
 * 这里有 n 门不同的在线课程，按从 1 到 n 编号。给你一个数组 courses ，
 * 其中 courses[i] = [durationi, lastDayi] 表示第 i 门课将会 持续 上 durationi 天课，并且必须在不晚于 lastDayi 的时候完成。
 * <p>
 * 你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。
 * <p>
 * 返回你最多可以修读的课程数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：courses = [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
 * 输出：3
 * 解释：
 * 这里一共有 4 门课程，但是你最多可以修 3 门：
 * 首先，修第 1 门课，耗费 100 天，在第 100 天完成，在第 101 天开始下门课。
 * 第二，修第 3 门课，耗费 1000 天，在第 1100 天完成，在第 1101 天开始下门课程。
 * 第三，修第 2 门课，耗时 200 天，在第 1300 天完成。
 * 第 4 门课现在不能修，因为将会在第 3300 天完成它，这已经超出了关闭日期。
 * 示例 2：
 * <p>
 * 输入：courses = [[1,2]]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：courses = [[3,2],[4,3]]
 * 输出：0
 * <p>
 * 提示:
 * <p>
 * 1 <= courses.length <= 104
 * 1 <= durationi, lastDayi <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/course-schedule-iii/description/?envType=daily-question&envId=2023-09-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L630_ScheduleCourse {
    public static void main(String[] args) {
        L630_ScheduleCourse l630ScheduleCourse = new L630_ScheduleCourse();
        System.out.println(l630ScheduleCourse.scheduleCourse(new int[][]{{5, 5}, {4, 6}, {2, 6}}));
    }

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int curUseTime = 0;
        for (int i = 0; i < courses.length; i++) {
            if (curUseTime + courses[i][0] <= courses[i][1]) {
                queue.add(courses[i]);
                curUseTime += courses[i][0];
            } else {
                if (!queue.isEmpty() && queue.peek()[0] > courses[i][0]) {
                    int[] node = queue.poll();
                    curUseTime = curUseTime - node[0] + courses[i][0];
                    queue.add(courses[i]);
                }
            }
        }
        return queue.size();
    }
}
