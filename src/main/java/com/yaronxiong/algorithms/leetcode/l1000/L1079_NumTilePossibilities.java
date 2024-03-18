package com.yaronxiong.algorithms.leetcode.l1000;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 1079. 活字印刷
 * 提示
 * 中等
 * 181
 * 相关企业
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 * <p>
 * 注意：本题中，每个活字字模只能使用一次。
 * <p>
 * 示例 1：
 * <p>
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 * 示例 2：
 * <p>
 * 输入："AAABBC"
 * 输出：188
 * 示例 3：
 * <p>
 * 输入："V"
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= tiles.length <= 7
 * tiles 由大写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/letter-tile-possibilities/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1079_NumTilePossibilities {
    private static final Logger logger = LoggerFactory.getLogger(L1079_NumTilePossibilities.class);
    public static void main(String[] args) {
        L1079_NumTilePossibilities l1079NumTilePossibilities = new L1079_NumTilePossibilities();
        System.out.println(l1079NumTilePossibilities.numTilePossibilities("AAABBC"));
    }

    Set<String> set;
    Map<Character, Integer> charMap;

    public int numTilePossibilities(String tiles) {
        charMap = new HashMap<>();
        for (char c : tiles.toCharArray()) {
            charMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        set = new HashSet<>();
        dfs(new LinkedList<>());
        return set.size();
    }

    private void dfs(Deque<Character> path) {
        for (Character c : charMap.keySet()) {
            if (charMap.get(c) == 0) {
                continue;
            }
            path.addLast(c);
            charMap.compute(c, (k, v) -> v - 1);
            set.add(path.toString());
            dfs(path);
            charMap.compute(c, (k, v) -> v + 1);
            path.removeLast();
        }
    }
}
