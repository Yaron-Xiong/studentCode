package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2833. 距离原点最远的点
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的字符串 moves ，该字符串仅由字符 'L'、'R' 和 '_' 组成。字符串表示你在一条原点为 0 的数轴上的若干次移动。
 * <p>
 * 你的初始位置就在原点（0），第 i 次移动过程中，你可以根据对应字符选择移动方向：
 * <p>
 * 如果 moves[i] = 'L' 或 moves[i] = '_' ，可以选择向左移动一个单位距离
 * 如果 moves[i] = 'R' 或 moves[i] = '_' ，可以选择向右移动一个单位距离
 * 移动 n 次之后，请你找出可以到达的距离原点 最远 的点，并返回 从原点到这一点的距离 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：moves = "L_RL__R"
 * 输出：3
 * 解释：可以到达的距离原点 0 最远的点是 -3 ，移动的序列为 "LLRLLLR" 。
 * 示例 2：
 * <p>
 * 输入：moves = "_R__LL_"
 * 输出：5
 * 解释：可以到达的距离原点 0 最远的点是 -5 ，移动的序列为 "LRLLLLL" 。
 * 示例 3：
 * <p>
 * 输入：moves = "_______"
 * 输出：7
 * 解释：可以到达的距离原点 0 最远的点是 7 ，移动的序列为 "RRRRRRR" 。
 * <p>
 * 提示：
 * <p>
 * 1 <= moves.length == n <= 50
 * moves 仅由字符 'L'、'R' 和 '_' 组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/furthest-point-from-origin/description/?envType=daily-question&envId=2026-04-24">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2833_FurthestDistanceFromOrigin {
    public static void main(String[] args) {
        L2833_FurthestDistanceFromOrigin l2833FurthestDistanceFromOrigin = new L2833_FurthestDistanceFromOrigin();
        System.out.println(l2833FurthestDistanceFromOrigin.furthestDistanceFromOrigin("L_RL__R"));
        System.out.println(l2833FurthestDistanceFromOrigin.furthestDistanceFromOrigin("_R__LL_"));
        System.out.println(l2833FurthestDistanceFromOrigin.furthestDistanceFromOrigin("_______"));
    }

    public int furthestDistanceFromOrigin(String moves) {
        int left = 0;
        int right = 0;
        int any = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'L') {
                left++;
            } else if (moves.charAt(i) == 'R') {
                right++;
            } else {
                any++;
            }
        }
        return Math.abs(left - right) + any;
    }
}
