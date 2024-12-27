package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.PriorityQueue;

/**
 * 1705. 吃苹果的最大数目
 * 算术评级: 6
 * 第 221 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1930
 * 相关标签
 * 相关企业
 * 提示
 * 有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。
 * 在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。
 * 也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
 * <p>
 * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
 * <p>
 * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：apples = [1,2,3,5,2], days = [3,2,1,4,2]
 * 输出：7
 * 解释：你可以吃掉 7 个苹果：
 * - 第一天，你吃掉第一天长出来的苹果。
 * - 第二天，你吃掉一个第二天长出来的苹果。
 * - 第三天，你吃掉一个第二天长出来的苹果。过了这一天，第三天长出来的苹果就已经腐烂了。
 * - 第四天到第七天，你吃的都是第四天长出来的苹果。
 * 示例 2：
 * <p>
 * 输入：apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
 * 输出：5
 * 解释：你可以吃掉 5 个苹果：
 * - 第一天到第三天，你吃的都是第一天长出来的苹果。
 * - 第四天和第五天不吃苹果。
 * - 第六天和第七天，你吃的都是第六天长出来的苹果。
 * <p>
 * 提示：
 * <p>
 * apples.length == n
 * days.length == n
 * 1 <= n <= 2 * 104
 * 0 <= apples[i], days[i] <= 2 * 104
 * 只有在 apples[i] = 0 时，days[i] = 0 才成立
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-number-of-eaten-apples/description/?envType=daily-question&envId=2024-12-24">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1705_EatenApples {
    public static void main(String[] args) {
        L1705_EatenApples l1705EatenApples = new L1705_EatenApples();
        System.out.println(l1705EatenApples.eatenApples(new int[]{2, 1, 10}, new int[]{2, 10, 1}));
    }

    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> deque = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int cnt = 0;
        int day = 0;
        for (; day < apples.length || !deque.isEmpty(); day++) {
            if (day < apples.length) {
                deque.add(new int[]{apples[day], days[day] + day});
            }
            //把不可以吃的苹果踢出去
            while (!deque.isEmpty() && (deque.peek()[0] <= 0 || deque.peek()[1] <= day)) {
                deque.poll();
            }
            if (!deque.isEmpty()) {
                //如果有剩余 说明可以吃了
                deque.peek()[0]--;
                cnt++;
            }
        }
        return cnt;

    }
}
