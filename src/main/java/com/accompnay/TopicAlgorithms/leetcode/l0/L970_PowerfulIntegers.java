package com.accompnay.TopicAlgorithms.leetcode.l0;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 970. 强整数
 * 中等
 * 100
 * 相关企业
 * 给定三个整数 x 、 y 和 bound ，返回 值小于或等于 bound 的所有 强整数 组成的列表 。
 * <p>
 * 如果某一整数可以表示为 xi + yj ，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个 强整数 。
 * <p>
 * 你可以按 任何顺序 返回答案。在你的回答中，每个值 最多 出现一次。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2, y = 3, bound = 10
 * 输出：[2,3,4,5,7,9,10]
 * 解释：
 * 2 = 20 + 30
 * 3 = 21 + 30
 * 4 = 20 + 31
 * 5 = 21 + 31
 * 7 = 22 + 31
 * 9 = 23 + 30
 * 10 = 20 + 32
 * 示例 2：
 * <p>
 * 输入：x = 3, y = 5, bound = 15
 * 输出：[2,4,6,8,10,14]
 * <p>
 * 提示：
 * <p>
 * 1 <= x, y <= 100
 * 0 <= bound <= 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/powerful-integers/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L970_PowerfulIntegers {
    public static void main(String[] args) {
        L970_PowerfulIntegers l970PowerfulIntegers = new L970_PowerfulIntegers();
        System.out.println(l970PowerfulIntegers.powerfulIntegers(2, 3, 10));
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        long curX = 1;
        for (int i = 0; i < 21; i++) {
            long curY = 1;
            for (int j = 0; j < 21; j++) {
                if (curX + curY <= bound) {
                    set.add((int) (curX + curY));
                } else {
                    break;
                }
                curY *= y;
            }
            if (curX > bound) {
                break;
            }
            curX *= x;
        }
        return new ArrayList<>(set);
    }

}
