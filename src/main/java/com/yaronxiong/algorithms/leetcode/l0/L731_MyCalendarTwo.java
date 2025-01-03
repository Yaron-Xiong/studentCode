package com.yaronxiong.algorithms.leetcode.l0;

import java.util.ArrayList;
import java.util.List;

/**
 * 731. 我的日程安排表 II
 * 算术评级: 6
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 实现一个程序来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。
 * <p>
 * 当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生 三重预订。
 * <p>
 * 事件能够用一对整数 startTime 和 endTime 表示，在一个半开区间的时间 [startTime, endTime) 上预定。实数 x 的范围为  startTime <= x < endTime。
 * <p>
 * 实现 MyCalendarTwo 类：
 * <p>
 * MyCalendarTwo() 初始化日历对象。
 * boolean book(int startTime, int endTime) 如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。
 * 否则，返回 false 并且不要将该日程安排添加到日历中。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["MyCalendarTwo", "book", "book", "book", "book", "book", "book"]
 * [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
 * 输出：
 * [null, true, true, true, false, true, true]
 * <p>
 * 解释：
 * MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
 * myCalendarTwo.book(10, 20); // 返回 True，能够预定该日程。
 * myCalendarTwo.book(50, 60); // 返回 True，能够预定该日程。
 * myCalendarTwo.book(10, 40); // 返回 True，该日程能够被重复预定。
 * myCalendarTwo.book(5, 15);  // 返回 False，该日程导致了三重预定，所以不能预定。
 * myCalendarTwo.book(5, 10); // 返回 True，能够预定该日程，因为它不使用已经双重预订的时间 10。
 * myCalendarTwo.book(25, 55); // 返回 True，能够预定该日程，因为时间段 [25, 40) 将被第三个日程重复预定，时间段 [40, 50) 将被单独预定，而时间段 [50, 55) 将被第二个日程重复预定。
 * <p>
 * 提示：
 * <p>
 * 0 <= start < end <= 109
 * 最多调用 book 1000 次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/my-calendar-ii/description/?envType=daily-question&envId=2025-01-03">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L731_MyCalendarTwo {

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10, 20));
        System.out.println(myCalendarTwo.book(50, 60));
        System.out.println(myCalendarTwo.book(10, 40));
        System.out.println(myCalendarTwo.book(5, 15));
        System.out.println(myCalendarTwo.book(5, 10));
        System.out.println(myCalendarTwo.book(25, 55));
    }

    static class MyCalendarTwo {
        List<int[]> gaps;
        List<int[]> overflows;

        public MyCalendarTwo() {
            gaps = new ArrayList<>();
            overflows = new ArrayList<>();
        }

        public boolean book(int startTime, int endTime) {
            for (int[] ints : overflows) {
                int s = ints[0];
                int e = ints[1];
                //说明相撞了,会出现一个重叠区间
                if (endTime > s && startTime < e) {
                    return false;
                }
            }
            //查询构建出了多少个二级区间
            for (int[] gap : gaps) {
                int s = gap[0];
                int e = gap[1];
                //说明相撞了,会出现一个重叠区间
                if (endTime > s && startTime < e) {
                    overflows.add(calGap(startTime, endTime, s, e));
                }
            }
            gaps.add(new int[]{startTime, endTime});
            return true;
        }

        private int[] calGap(int s1, int e1, int s2, int e2) {
            if (s1 > s2) {
                return calGap(s2, e2, s1, e1);
            }
            return new int[]{s2, Math.min(e1, e2)};
        }
    }
}
