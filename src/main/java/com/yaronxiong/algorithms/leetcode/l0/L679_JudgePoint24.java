package com.yaronxiong.algorithms.leetcode.l0;

import java.util.ArrayList;
import java.util.List;

/**
 * 679. 24 点游戏
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个长度为4的整数数组 cards 。你有 4 张卡片，每张卡片上都包含一个范围在 [1,9] 的数字。
 * 您应该使用运算符 ['+', '-', '*', '/'] 和括号 '(' 和 ')' 将这些卡片上的数字排列成数学表达式，以获得值24。
 * <p>
 * 你须遵守以下规则:
 * <p>
 * 除法运算符 '/' 表示实数除法，而不是整数除法。
 * 例如， 4 /(1 - 2 / 3)= 4 /(1 / 3)= 12 。
 * 每个运算都在两个数字之间。特别是，不能使用 “-” 作为一元运算符。
 * 例如，如果 cards =[1,1,1,1] ，则表达式 “-1 -1 -1 -1” 是 不允许 的。
 * 你不能把数字串在一起
 * 例如，如果 cards =[1,2,1,2] ，则表达式 “12 + 12” 无效。
 * 如果可以得到这样的表达式，其计算结果为 24 ，则返回 true ，否则返回 false 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: cards = [4, 1, 8, 7]
 * 输出: true
 * 解释: (8-4) * (7-1) = 24
 * 示例 2:
 * <p>
 * 输入: cards = [1, 2, 1, 2]
 * 输出: false
 * <p>
 * 提示:
 * <p>
 * cards.length == 4
 * 1 <= cards[i] <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/24-game/?envType=daily-question&envId=2025-08-18">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L679_JudgePoint24 {
    public static void main(String[] args) {
        L679_JudgePoint24 l679JudgePoint24 = new L679_JudgePoint24();
        System.out.println(l679JudgePoint24.judgePoint24(new int[]{3, 3, 8, 8}));
        System.out.println(l679JudgePoint24.judgePoint24(new int[]{1, 2, 1, 2}));
        System.out.println(l679JudgePoint24.judgePoint24(new int[]{1, 9, 1, 2}));
        System.out.println(l679JudgePoint24.judgePoint24(new int[]{4, 1, 8, 7}));
    }

    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }
        return dfs2(list);
    }

    private boolean dfs2(List<Double> list) {
        if (list.size() == 1) {
            //没法合并了
            return (Math.abs(list.get(0) - 24)) < 1e-9;
        }
        for (int i = 0; i < list.size(); i++) {
            //将list.get(i) 跟 list.get(j) 做合并
            for (int j = i + 1; j < list.size(); j++) {
                List<Double> candidates = new ArrayList<>();
                //两个值做合并有6中可能性
                candidates.add(list.get(i) - list.get(j));
                candidates.add(list.get(j) - list.get(i));
                candidates.add(list.get(i) + list.get(j));
                candidates.add(list.get(i) * list.get(j));
                if (list.get(j) != 0) {
                    candidates.add(list.get(i) / list.get(j));
                }
                if (list.get(i) != 0) {
                    candidates.add(list.get(j) / list.get(i));
                }
                List<Double> newList = new ArrayList<>(list);
                newList.remove(j);
                for (Double candidate : candidates) {
                    newList.set(i, candidate);
                    if (dfs2(newList)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
