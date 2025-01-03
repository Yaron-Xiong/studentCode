package com.yaronxiong.algorithms.leetcode.l0;

import java.util.ArrayList;
import java.util.List;

/**
 * 729. 我的日程安排表 I
 * 算术评级: 4
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。
 * <p>
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。
 * <p>
 * 日程可以用一对整数 startTime 和 endTime 表示，这里的时间是半开区间，即 [startTime, endTime), 实数 x 的范围为，  startTime <= x < endTime 。
 * <p>
 * 实现 MyCalendar 类：
 * <p>
 * MyCalendar() 初始化日历对象。
 * boolean book(int startTime, int endTime) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 false 并且不要将该日程安排添加到日历中。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["MyCalendar", "book", "book", "book"]
 * [[], [10, 20], [15, 25], [20, 30]]
 * 输出：
 * [null, true, false, true]
 * <p>
 * 解释：
 * MyCalendar myCalendar = new MyCalendar();
 * myCalendar.book(10, 20); // return True
 * myCalendar.book(15, 25); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了。
 * myCalendar.book(20, 30); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20 ，且不包含时间 20 。
 * <p>
 * 提示：
 * <p>
 * 0 <= start < end <= 109
 * 每个测试用例，调用 book 方法的次数最多不超过 1000 次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/my-calendar-i/description/?envType=daily-question&envId=2025-01-02">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L729_MyCalendar {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(15, 25));
        System.out.println(myCalendar.book(20, 30));
    }

    static class MyCalendar {
        private List<int[]> books;

        public MyCalendar() {
            books = new ArrayList<>();
        }

        public boolean book(int startTime, int endTime) {
            //可以尝试合并区间
            boolean contains = false;
            for (int[] book : books) {
                int l = book[0];
                int r = book[1];
                if (startTime < r && endTime > l) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                books.add(new int[]{startTime, endTime});
            }
            return !contains;
        }
    }
}
