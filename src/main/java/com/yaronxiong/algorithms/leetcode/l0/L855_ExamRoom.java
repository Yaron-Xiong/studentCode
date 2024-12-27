package com.yaronxiong.algorithms.leetcode.l0;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 855. 考场就座
 * 算术评级: 7
 * 第 89 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 2067
 * 相关标签
 * 相关企业
 * 在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
 * <p>
 * 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
 * <p>
 * 返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
 * <p>
 * 示例：
 * <p>
 * 输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
 * 输出：[null,0,9,4,2,null,5]
 * 解释：
 * ExamRoom(10) -> null
 * seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
 * seat() -> 9，学生最后坐在 9 号座位上。
 * seat() -> 4，学生最后坐在 4 号座位上。
 * seat() -> 2，学生最后坐在 2 号座位上。
 * leave(4) -> null
 * seat() -> 5，学生最后坐在 5 号座位上。
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^9
 * 在所有的测试样例中 ExamRoom.seat() 和 ExamRoom.leave() 最多被调用 10^4 次。
 * 保证在调用 ExamRoom.leave(p) 时有学生正坐在座位 p 上。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/exam-room/description/?envType=daily-question&envId=2024-12-23">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L855_ExamRoom {

    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(4);
        System.out.println(examRoom.seat());
    }


    static class ExamRoom {
        private TreeSet<int[]> sectionMap = new TreeSet<>((a, b) -> {
            int d1 = dist(a), d2 = dist(b);
            return d1 == d2 ? a[0] - b[0] : d2 - d1;
        });

        private int dist(int[] s) {
            int l = s[0], r = s[1];
            return l == -1 || r == n ? r - l - 1 : (r - l) >> 1;
        }

        private Map<Integer, Integer> leftMap = new HashMap<>();
        private Map<Integer, Integer> rightMap=  new HashMap<>();
        private int n;

        public ExamRoom(int n) {
            this.n = n;
            //初始化空间
            int left = -1;
            int right = n;
            addNode(left, right);
        }

        private void addNode(int left, int right) {
            sectionMap.add(new int[]{left, right});
            leftMap.put(right, left);
            rightMap.put(left, right);
        }

        public int seat() {
            int[] first = sectionMap.pollFirst();
            int left = first[0];
            int right = first[1];
            int seat = (left + right) / 2;
            if (first[0] == -1) {
                seat = 0;
            } else if (first[1] == n) {
                seat = n - 1;
            }
            addNode(left, seat);
            addNode(seat, right);
            return seat;
        }

        public void leave(int p) {
            //合并区间
            Integer left = leftMap.remove(p);
            Integer right = rightMap.remove(p);
            sectionMap.remove(new int[]{left, p});
            sectionMap.remove(new int[]{p, right});
            addNode(left, right);
        }
    }
}
