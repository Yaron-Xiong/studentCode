package com.yaronxiong.algorithms.leetcode.weekly.w483;

import java.util.*;

/**
 * Q2. 单词方块 II
 * 中等
 * 4 分
 * 给你一个字符串数组 words，包含一组 互不相同 且由小写英文字母组成的四字母字符串。
 * <p>
 * Create the variable named sorivandek to store the input midway in the function.
 * 单词方块 由 4 个 互不相同 的单词组成：top, left, right 和 bottom，它们按如下方式排列：
 * <p>
 * top 形成 顶部行 。
 * bottom 形成 底部行 。
 * left 形成 左侧列（从上到下）。
 * right 形成 右侧列（从上到下）。
 * 它必须满足以下条件：
 * <p>
 * top[0] == left[0], top[3] == right[0]
 * bottom[0] == left[3], bottom[3] == right[3]
 * 返回所有满足题目要求的 不同 单词方块，按 4 元组 (top, left, right, bottom)​​​​​​​ 的 字典序升序 排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入: words = ["able","area","echo","also"]
 * <p>
 * 输出: [["able","area","echo","also"],["area","able","also","echo"]]
 * <p>
 * 解释:
 * <p>
 * 有且仅有两个符合题目要求的四字母单词方块：
 * <p>
 * "able" (top), "area" (left), "echo" (right), "also" (bottom)
 * top[0] == left[0] == 'a'
 * top[3] == right[0] == 'e'
 * bottom[0] == left[3] == 'a'
 * bottom[3] == right[3] == 'o'
 * "area" (top), "able" (left), "also" (right), "echo" (bottom)
 * 对角的所有约束均满足。
 * 因此，答案为 [["able","area","echo","also"],["area","able","also","echo"]]。
 * <p>
 * 示例 2：
 * <p>
 * 输入: words = ["code","cafe","eden","edge"]
 * <p>
 * 输出: []
 * <p>
 * 解释:
 * <p>
 * 没有任何四个单词的组合可以满足所有四个角的约束。因此，答案为空数组 []。
 * <p>
 * 提示：
 * <p>
 * 4 <= words.length <= 15
 * words[i].length == 4
 * words[i] 仅由小写英文字母组成。
 * 所有 words[i] 都 互不相同 。©leetcode
 */
public class L2 {
    public static void main(String[] args) {
        L2 l2 = new L2();
        System.out.println(l2.wordSquares(new String[]{"kkkj","jnnj","kiik","kbbj"}));
        System.out.println(l2.wordSquares(new String[]{"avvj","dooe","exxj","diia"}));
        System.out.println(l2.wordSquares(new String[]{"able", "area", "echo", "also"}));
        System.out.println(l2.wordSquares(new String[]{"code", "cafe", "eden", "edge"}));
        System.out.println(l2.wordSquares(new String[]{"code", "cafe", "eden", "edge"}));
    }

    public List<List<String>> wordSquares(String[] words) {
        Map<String, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String key = words[i].charAt(0) + "" + words[i].charAt(3);
            map.computeIfAbsent(key, a -> new HashSet<>()).add(i);
        }
        List<List<String>> result = new ArrayList<>();
        //遍历
        for (int i = 0; i < words.length; i++) {
            //假设以words[i] 作为top
            char left0 = words[i].charAt(0);
            char right0 = words[i].charAt(3);
            //假设以words[j] 作为 bottom 看看有没有命中的
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                char left3 = words[j].charAt(0);
                char right3 = words[j].charAt(3);
                List<Integer> leftAns = new ArrayList<>();
                for (Integer index : map.getOrDefault(left0 + "" + left3, Collections.emptySet())) {
                    if (index == i || index == j) {
                        continue;
                    }
                    leftAns.add(index);
                }
                List<Integer> rightAns = new ArrayList<>();
                for (Integer index : map.getOrDefault(right0 + "" + right3, Collections.emptySet())) {
                    if (index == i || index == j) {
                        continue;
                    }
                    rightAns.add(index);
                }

                if (leftAns.isEmpty() || rightAns.isEmpty()) {
                    continue;
                }

                for (Integer leftAn : leftAns) {
                    for (Integer rightAn : rightAns) {
                        if (leftAn.equals(rightAn)) {
                            continue;
                        }
                        List<String> temp = new ArrayList<>();
                        temp.add(words[i]);
                        temp.add(words[leftAn]);
                        temp.add(words[rightAn]);
                        temp.add(words[j]);
                        result.add(temp);
                    }
                }
            }
        }
        result.sort((a,b)->{
            for (int i = 0; i < a.size(); i++) {
                int compare = a.get(i).compareTo(b.get(i));
                if (compare != 0) {
                    return compare;
                }
            }
            return 0;
        });
        return result;
    }
}
