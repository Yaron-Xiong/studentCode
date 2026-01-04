package com.yaronxiong.algorithms.leetcode.l0;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 756. 金字塔转换矩阵
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 你正在把积木堆成金字塔。每个块都有一个颜色，用一个字母表示。每一行的块比它下面的行 少一个块 ，并且居中。
 * <p>
 * 为了使金字塔美观，只有特定的 三角形图案 是允许的。一个三角形的图案由 两个块 和叠在上面的 单个块 组成。模式是以三个字母字符串的列表形式 allowed 给出的，其中模式的前两个字符分别表示左右底部块，第三个字符表示顶部块。
 * <p>
 * 例如，"ABC" 表示一个三角形图案，其中一个 “C” 块堆叠在一个 'A' 块(左)和一个 'B' 块(右)之上。请注意，这与 "BAC" 不同，"B" 在左下角，"A" 在右下角。
 * 你从作为单个字符串给出的底部的一排积木 bottom 开始，必须 将其作为金字塔的底部。
 * <p>
 * 在给定 bottom 和 allowed 的情况下，如果你能一直构建到金字塔顶部，使金字塔中的 每个三角形图案 都是在 allowed 中的，则返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：bottom = "BCD", allowed = ["BCC","CDE","CEA","FFF"]
 * 输出：true
 * 解释：允许的三角形图案显示在右边。
 * 从最底层(第 3 层)开始，我们可以在第 2 层构建“CE”，然后在第 1 层构建“E”。
 * 金字塔中有三种三角形图案，分别是 “BCC”、“CDE” 和 “CEA”。都是允许的。
 * 示例 2：
 * <p>
 * 输入：bottom = "AAAA", allowed = ["AAB","AAC","BCD","BBE","DEF"]
 * 输出：false
 * 解释：允许的三角形图案显示在右边。
 * 从最底层(即第 4 层)开始，创造第 3 层有多种方法，但如果尝试所有可能性，你便会在创造第 1 层前陷入困境。
 * <p>
 * 提示：
 * <p>
 * 2 <= bottom.length <= 6
 * 0 <= allowed.length <= 216
 * allowed[i].length == 3
 * 所有输入字符串中的字母来自集合 {'A', 'B', 'C', 'D', 'E', 'F'}。
 * allowed 中所有值都是 唯一的
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/pyramid-transition-matrix/description/?envType=daily-question&envId=2025-12-29">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L756_PyramidTransition {
    public static void main(String[] args) {
        L756_PyramidTransition l756PyramidTransition = new L756_PyramidTransition();
        System.out.println(l756PyramidTransition.pyramidTransition("AAAA", Lists.newArrayList("AAB", "AAC", "BCD", "BBE", "DEF")));
        System.out.println(l756PyramidTransition.pyramidTransition("ABCD", Lists.newArrayList("ABC", "BCA", "CDA", "ABD", "BCE", "CDF", "DEA", "EFF", "AFF")));
        System.out.println(l756PyramidTransition.pyramidTransition("AFFFFA", Lists.newArrayList("ADA", "ADC", "ADB", "AEA", "AEC", "AEB", "AFA", "AFC", "AFB", "CDA", "CDC", "CDB", "CEA", "CEC", "CEB", "CFA", "CFC", "CFB", "BDA", "BDC", "BDB", "BEA", "BEC", "BEB", "BFA", "BFC", "BFB", "DAA", "DAC", "DAB", "DCA", "DCC", "DCB", "DBA", "DBC", "DBB", "EAA", "EAC", "EAB", "ECA", "ECC", "ECB", "EBA", "EBC", "EBB", "FAA", "FAC", "FAB", "FCA", "FCC", "FCB", "FBA", "FBC", "FBB", "DDA", "DDC", "DDB", "DEA", "DEC", "DEB", "DFA", "DFC", "DFB", "EDA", "EDC", "EDB", "EEA", "EEC", "EEB", "EFA", "EFC", "EFB", "FDA", "FDC", "FDB", "FEA", "FEC", "FEB", "FFA", "FFC", "FFB", "DDD", "DDE", "DDF", "DED", "DEE", "DEF", "DFD", "DFE", "DFF", "EDD", "EDE", "EDF", "EED", "EEE", "EEF", "EFD", "EFE", "EFF", "FDD", "FDE", "FDF", "FED", "FEE", "FEF", "FFD", "FFE", "FFF")));
        System.out.println(l756PyramidTransition.pyramidTransition("BCD", Lists.newArrayList("BCC", "CDE", "CEA", "FFF")));

    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            map.computeIfAbsent(s.substring(0, 2), a -> new ArrayList<>()).add(s.charAt(2));
        }
        return dsf2(bottom, map);
    }

    private boolean dsf2(String pattern, Map<String, List<Character>> map) {
        if (pattern.length() == 1) {
            return true;
        }
        //判断是否能够通过 map 前两个字符串 构建出pattern
        // 当前层 是由 pattern.length - 1 个组件构建的
        List<String> list = new ArrayList<>();
        list.add("");
        for (int i = 0; i < pattern.length() - 1; i++) {
            //这时候会有很多个命中的
            List<String> newList = new ArrayList<>();
            String ns = pattern.charAt(i) + "" + pattern.charAt(i + 1);
            if (!map.containsKey(ns)) {
                return false;
            }
            for (Character c : map.get(ns)) {
                for (String s : list) {
                    newList.add(s + c);
                }
            }
            list = newList;
        }
        for (String nextPattern : list) {
            if (dsf2(nextPattern, map)) {
                return true;
            }
        }
        return false;
    }
}
