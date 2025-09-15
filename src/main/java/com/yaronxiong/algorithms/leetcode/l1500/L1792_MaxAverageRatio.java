package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.PriorityQueue;

/**
 * 1792. 最大平均通过率
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。
 * 给你一个二维数组 classes ，其中 classes[i] = [passi, totali] ，表示你提前知道了第 i 个班级总共有 totali 个学生，其中只有 passi 个学生可以通过考试。
 * <p>
 * 给你一个整数 extraStudents ，表示额外有 extraStudents 个聪明的学生，他们 一定 能通过任何班级的期末考。
 * 你需要给这 extraStudents 个学生每人都安排一个班级，使得 所有 班级的 平均 通过率 最大 。
 * <p>
 * 一个班级的 通过率 等于这个班级通过考试的学生人数除以这个班级的总人数。
 * 平均通过率 是所有班级的通过率之和除以班级数目。
 * <p>
 * 请你返回在安排这 extraStudents 个学生去对应班级后的 最大 平均通过率。与标准答案误差范围在 10-5 以内的结果都会视为正确结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：classes = [[1,2],[3,5],[2,2]], extraStudents = 2
 * 输出：0.78333
 * 解释：你可以将额外的两个学生都安排到第一个班级，平均通过率为 (3/4 + 3/5 + 2/2) / 3 = 0.78333 。
 * 示例 2：
 * <p>
 * 输入：classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
 * 输出：0.53485
 * <p>
 * 提示：
 * <p>
 * 1 <= classes.length <= 105
 * classes[i].length == 2
 * 1 <= passi <= totali <= 105
 * 1 <= extraStudents <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-average-pass-ratio/description/?envType=daily-question&envId=2025-09-01">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1792_MaxAverageRatio {
    public static void main(String[] args) {
        L1792_MaxAverageRatio l1792MaxAverageRatio = new L1792_MaxAverageRatio();
        System.out.println(l1792MaxAverageRatio.maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {2, 2}}, 2));
    }

    public static class ClassMate {
        int total;
        int pass;
        double promote;

        public void update(int total, int pass) {
            this.total = total;
            this.pass = pass;
            this.promote = ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassMate> pq = new PriorityQueue<>((a, b) -> Double.compare(b.promote, a.promote));
        for (int[] ints : classes) {
            ClassMate classMate = new ClassMate();
            classMate.total = ints[1];
            classMate.pass = ints[0];
            classMate.promote = ((double) (classMate.pass + 1) / (classMate.total + 1)) - ((double) classMate.pass / classMate.total);
            pq.add(classMate);
        }
        for (int i = 0; i < extraStudents; i++) {
            ClassMate poll = pq.poll();
            poll.update(poll.total + 1, poll.pass + 1);
            pq.add(poll);
        }
        double ans = 0;
        int size = 0;
        while (!pq.isEmpty()) {
            ClassMate poll = pq.poll();
            ans += poll.pass / (double) poll.total;
            size++;
        }
        ans /= size;
        return ans;
    }
}
