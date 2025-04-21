package com.yaronxiong.algorithms.leetcode.l0;

import java.util.HashMap;
import java.util.Map;

/**
 * 781. 森林中的兔子
 * 中等
 * 相关标签
 * 相关企业
 * 森林中有未知数量的兔子。提问其中若干只兔子 "还有多少只兔子与你（指被提问的兔子）颜色相同?" ，
 * 将答案收集到一个整数数组 answers 中，其中 answers[i] 是第 i 只兔子的回答。
 * <p>
 * 给你数组 answers ，返回森林中兔子的最少数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：answers = [1,1,2]
 * 输出：5
 * 解释：
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5 只：3 只回答的和 2 只没有回答的。
 * 示例 2：
 * <p>
 * 输入：answers = [10,10,10]
 * 输出：11
 * <p>
 * 提示：
 * <p>
 * 1 <= answers.length <= 1000
 * 0 <= answers[i] < 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/rabbits-in-forest/description/?envType=daily-question&envId=2025-04-20">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L781_NumRabbits {
    public static void main(String[] args) {
        L781_NumRabbits l781NumRabbits = new L781_NumRabbits();
        System.out.println(l781NumRabbits.numRabbits(new int[]{1, 1, 2}));
    }

    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.merge(answer, 1, Integer::sum);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int groupSize = entry.getKey() + 1;
            Integer value = entry.getValue();
            int cnt = value % groupSize;
            ans += value;
            if (cnt != 0) {
                ans += groupSize - cnt;
            }
        }
        return ans;
    }
}
