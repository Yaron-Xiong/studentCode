package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.Arrays;

/**
 * 1033. 移动石子直到连续
 * 提示
 * 中等
 * 77
 * 相关企业
 * 三枚石子放置在数轴上，位置分别为 a，b，c。
 * <p>
 * 每一回合，你可以从两端之一拿起一枚石子（位置最大或最小），并将其放入两端之间的任一空闲位置。
 * 形式上，假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。那么就可以从位置 x 或者是位置 z 拿起一枚石子，并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。
 * <p>
 * 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
 * <p>
 * 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？
 * 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves]
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 1, b = 2, c = 5
 * 输出：[1, 2]
 * 解释：将石子从 5 移动到 4 再移动到 3，或者我们可以直接将石子移动到 3。
 * 示例 2：
 * <p>
 * 输入：a = 4, b = 3, c = 2
 * 输出：[0, 0]
 * 解释：我们无法进行任何移动。
 * <p>
 * 提示：
 * <p>
 * 1 <= a <= 100
 * 1 <= b <= 100
 * 1 <= c <= 100
 * a != b, b != c, c != a
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/moving-stones-until-consecutive/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1033_NumMovesStones {
    public static void main(String[] args) {
        L1033_NumMovesStones l1033NumMovesStones = new L1033_NumMovesStones();
        int[] ints = l1033NumMovesStones.numMovesStones(3, 5, 1);
        System.out.println(Arrays.toString(ints));
    }

    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        int min = getMin(arr[0], arr[1], arr[2]);
        return new int[]{min, arr[2] - arr[0] - 2};
    }

    private int getMin(int a, int b, int c) {
        if (c - a == 2) {
            return 0;
        }
        if (c - b <= 2 || b - a <= 2) {
            return 1;
        }
        return 2;
    }
}
