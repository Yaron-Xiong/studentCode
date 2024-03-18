package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.HashMap;
import java.util.Map;

/**
 * 1410. HTML 实体解析器
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 「HTML 实体解析器」 是一种特殊的解析器，它将 HTML 代码作为输入，并用字符本身替换掉所有这些特殊的字符实体。
 * <p>
 * HTML 里这些特殊字符和它们对应的字符实体包括：
 * <p>
 * 双引号：字符实体为 &quot; ，对应的字符是 " 。
 * 单引号：字符实体为 &apos; ，对应的字符是 ' 。
 * 与符号：字符实体为 &amp; ，对应对的字符是 & 。
 * 大于号：字符实体为 &gt; ，对应的字符是 > 。
 * 小于号：字符实体为 &lt; ，对应的字符是 < 。
 * 斜线号：字符实体为 &frasl; ，对应的字符是 / 。
 * 给你输入字符串 text ，请你实现一个 HTML 实体解析器，返回解析器解析后的结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "&amp; is an HTML entity but &ambassador; is not."
 * 输出："& is an HTML entity but &ambassador; is not."
 * 解释：解析器把字符实体 &amp; 用 & 替换
 * 示例 2：
 * <p>
 * 输入：text = "and I quote: &quot;...&quot;"
 * 输出："and I quote: \"...\""
 * 示例 3：
 * <p>
 * 输入：text = "Stay home! Practice on Leetcode :)"
 * 输出："Stay home! Practice on Leetcode :)"
 * 示例 4：
 * <p>
 * 输入：text = "x &gt; y &amp;&amp; x &lt; y is always false"
 * 输出："x > y && x < y is always false"
 * 示例 5：
 * <p>
 * 输入：text = "leetcode.com&frasl;problemset&frasl;all"
 * 输出："leetcode.com/problemset/all"
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 10^5
 * 字符串可能包含 256 个ASCII 字符中的任意字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/html-entity-parser/description/?envType=daily-question&envId=2023-11-23">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1410_EntityParser {
    public static void main(String[] args) {
        L1410_EntityParser l1410EntityParser = new L1410_EntityParser();
        System.out.println(l1410EntityParser.entityParser("&&gt;"));
    }

    public String entityParser(String text) {
        Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        char[] array = text.toCharArray();
        int n = array.length;
        int index = 0;
        StringBuilder result = new StringBuilder();
        while (index < n) {
            if (array[index] == '&') {
                //开始匹配 到 ; 或者 &结束
                StringBuilder sb = new StringBuilder();
                sb.append(array[index++]);
                while (index < n && array[index] != ';' && array[index] != '&') {
                    sb.append(array[index++]);
                }
                if (index < n && array[index] == ';') {
                    sb.append(array[index++]);
                }
                String key = sb.toString();
                if (map.containsKey(key)) {
                    result.append(map.get(key));
                } else {
                    result.append(sb);
                }
                continue;
            }
            result.append(array[index++]);
        }
        return result.toString();
    }
}
