package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.ArrayList;
import java.util.List;

/**
 * 1349. 参加考试的最大学生数
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 m * n 的矩阵 seats 表示教室中的座位分布。如果座位是坏的（不可用），就用 '#' 表示；否则，用 '.' 表示。
 * <p>
 * 学生可以看到左侧、右侧、左上、右上这四个方向上紧邻他的学生的答卷，但是看不到直接坐在他前面或者后面的学生的答卷。
 * 请你计算并返回该考场可以容纳的同时参加考试且无法作弊的 最大 学生人数。
 * <p>
 * 学生必须坐在状况良好的座位上。
 * <p>
 * 示例 1：
 * <p>
 * 输入：seats = [["#",".","#","#",".","#"],
 * [".","#","#","#","#","."],
 * ["#",".","#","#",".","#"]]
 * 输出：4
 * 解释：教师可以让 4 个学生坐在可用的座位上，这样他们就无法在考试中作弊。
 * 示例 2：
 * <p>
 * 输入：seats = [[".","#"],
 * ["#","#"],
 * ["#","."],
 * ["#","#"],
 * [".","#"]]
 * 输出：3
 * 解释：让所有学生坐在可用的座位上。
 * 示例 3：
 * <p>
 * 输入：seats = [["#",".",".",".","#"],
 * [".","#",".","#","."],
 * [".",".","#",".","."],
 * [".","#",".","#","."],
 * ["#",".",".",".","#"]]
 * 输出：10
 * 解释：让学生坐在第 1、3 和 5 列的可用座位上。
 * <p>
 * 提示：
 * <p>
 * seats 只包含字符 '.' 和'#'
 * m == seats.length
 * n == seats[i].length
 * 1 <= m <= 8
 * 1 <= n <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-students-taking-exam/description/?envType=daily-question&envId=2023-12-26">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1349_MaxStudents {
    public static void main(String[] args) {
        L1349_MaxStudents l1349MaxStudents = new L1349_MaxStudents();
        System.out.println(l1349MaxStudents.maxStudents(new char[][]{{'#', '.', '#', '#', '.', '#'}, {'.', '#', '#', '#', '#', '.'}, {'#', '.', '#', '#', '.', '#'}}));
    }

    public int maxStudents(char[][] seats) {
        //状态从最后一排往第一行开始迁移
        List<int[]> pre = null;
        int max = 0;
        for (int i = seats.length - 1; i >= 0; i--) {
            List<int[]> cur = new ArrayList<>();
            generator(0, seats[i], 0, 0, cur);
            for (int[] ints : cur) {
                System.out.print(Integer.toBinaryString(ints[0]) + ":" + ints[1] + "  ");
            }
            System.out.println();
            //比较 cur & pre 的关联性
            if (pre != null) {
                for (int[] arr : cur) {
                    int oldValue = arr[1];
                    for (int[] arr2 : pre) {
                        //说明可取
                        if (((arr[0] >>> 1) & arr2[0]) == 0 && ((arr[0] << 1) & arr2[0]) == 0) {
                            arr[1] = Math.max(arr[1], oldValue + arr2[1]);
                            max = Math.max(max, arr[1]);
                        }
                    }
                }
            }
            pre = cur;
        }
        return max;
    }

    public void generator(int index, char[] lines, int path, int size, List<int[]> ans) {
        if (index >= lines.length) {
            ans.add(new int[]{path, size});
            return;
        }
        //当前位置坐人
        if (((index > 0 && lines[index - 1] != 'r') || index == 0) && lines[index] == '.') {
            lines[index] = 'r';
            generator(index + 1, lines, (1 << index) | path, size + 1, ans);
            lines[index] = '.';
        }
        //不选择当前点
        generator(index + 1, lines, path, size, ans);
    }

}
