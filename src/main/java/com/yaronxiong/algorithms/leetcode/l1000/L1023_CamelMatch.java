package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.ArrayList;
import java.util.List;

/**
 * 1023. 驼峰式匹配
 * 提示
 * 中等
 * 89
 * 相关企业
 * 如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。
 * （我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
 * <p>
 * 给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。
 * 只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 * 输出：[true,false,true,true,false]
 * 示例：
 * "FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
 * "FootBall" 可以这样生成："F" + "oot" + "B" + "all".
 * "FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
 * 示例 2：
 * <p>
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 * 输出：[true,false,true,false,false]
 * 解释：
 * "FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
 * "FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
 * 示例 3：
 * <p>
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
 * 输出：[false,true,false,false,false]
 * 解释：
 * "FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
 * <p>
 * 提示：
 * <p>
 * 1 <= queries.length <= 100
 * 1 <= queries[i].length <= 100
 * 1 <= pattern.length <= 100
 * 所有字符串都仅由大写和小写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/camelcase-matching/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1023_CamelMatch {
    public static void main(String[] args) {
        L1023_CamelMatch l1023CamelMatch = new L1023_CamelMatch();
        System.out.println(l1023CamelMatch.camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"},
                "FB"));
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String query : queries) {
            boolean check = check(query, pattern);
            res.add(check);
        }
        return res;
    }

    private boolean check(String query, String pattern) {
        int queryIndex = 0;
        int patternIndex = 0;
        while (queryIndex < query.length() && patternIndex < pattern.length()) {
            if (Character.isLowerCase(query.charAt(queryIndex))) {
                if (Character.isUpperCase(pattern.charAt(patternIndex))) {
                    queryIndex++;
                } else if (query.charAt(queryIndex) == pattern.charAt(patternIndex)) {
                    queryIndex++;
                    patternIndex++;
                } else {
                    queryIndex++;
                }
            } else if (query.charAt(queryIndex) == pattern.charAt(patternIndex)) {
                queryIndex++;
                patternIndex++;
            } else {
                return false;
            }
        }
        //这个时候query中字符应该都为小写或者两者匹配完毕
        while (queryIndex < query.length()) {
            if (Character.isLowerCase(query.charAt(queryIndex))) {
                queryIndex++;
            } else {
                break;
            }
        }
        return queryIndex == query.length() && patternIndex == pattern.length();
    }


}
