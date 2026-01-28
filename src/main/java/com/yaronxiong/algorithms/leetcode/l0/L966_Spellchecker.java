package com.yaronxiong.algorithms.leetcode.l0;

import java.util.*;

/**
 * 966. 元音拼写检查器
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 在给定单词列表 wordlist 的情况下，我们希望实现一个拼写检查器，将查询单词转换为正确的单词。
 * <p>
 * 对于给定的查询单词 query，拼写检查器将会处理两类拼写错误：
 * <p>
 * 大小写：如果查询匹配单词列表中的某个单词（不区分大小写），则返回的正确单词与单词列表中的大小写相同。
 * 例如：wordlist = ["yellow"], query = "YellOw": correct = "yellow"
 * 例如：wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
 * 例如：wordlist = ["yellow"], query = "yellow": correct = "yellow"
 * 元音错误：如果在将查询单词中的元音 ('a', 'e', 'i', 'o', 'u')  分别替换为任何元音后，能与单词列表中的单词匹配（不区分大小写），则返回的正确单词与单词列表中的匹配项大小写相同。
 * 例如：wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
 * 例如：wordlist = ["YellOw"], query = "yeellow": correct = "" （无匹配项）
 * 例如：wordlist = ["YellOw"], query = "yllw": correct = "" （无匹配项）
 * 此外，拼写检查器还按照以下优先级规则操作：
 * <p>
 * 当查询完全匹配单词列表中的某个单词（区分大小写）时，应返回相同的单词。
 * 当查询匹配到大小写问题的单词时，您应该返回单词列表中的第一个这样的匹配项。
 * 当查询匹配到元音错误的单词时，您应该返回单词列表中的第一个这样的匹配项。
 * 如果该查询在单词列表中没有匹配项，则应返回空字符串。
 * 给出一些查询 queries，返回一个单词列表 answer，其中 answer[i] 是由查询 query = queries[i] 得到的正确单词。
 * <p>
 * 示例 1：
 * <p>
 * 输入：wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
 * 输出：["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
 * 示例 2:
 * <p>
 * 输入：wordlist = ["yellow"], queries = ["YellOw"]
 * 输出：["yellow"]
 * <p>
 * 提示：
 * <p>
 * 1 <= wordlist.length, queries.length <= 5000
 * 1 <= wordlist[i].length, queries[i].length <= 7
 * wordlist[i] 和 queries[i] 只包含英文字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/vowel-spellchecker/?envType=daily-question&envId=2025-09-14">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L966_Spellchecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        int n = wordlist.length;
        Set<String> origin = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> lowerToOrigin = new HashMap<>(n); // 预分配空间
        Map<String, String> vowelToOrigin = new HashMap<>(n);

        for (int i = n - 1; i >= 0; i--) {
            String s = wordlist[i];
            String lower = s.toLowerCase();
            lowerToOrigin.put(lower, s); // 例如 kite -> KiTe
            vowelToOrigin.put(replaceVowels(lower), s); // 例如 k?t? -> KiTe
        }

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (origin.contains(q)) { // 完全匹配
                continue;
            }
            String lower = q.toLowerCase();
            if (lowerToOrigin.containsKey(lower)) { // 不区分大小写的匹配
                queries[i] = lowerToOrigin.get(lower);
            } else { // 不区分大小写+元音模糊匹配
                queries[i] = vowelToOrigin.getOrDefault(replaceVowels(lower), "");
            }
        }
        return queries;
    }

    private String replaceVowels(String str) {
        char[] s = str.toCharArray();
        for (int i = 0; i < s.length; ++i) {
            char c = s[i];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                s[i] = '?';
            }
        }
        return new String(s);
    }

}
