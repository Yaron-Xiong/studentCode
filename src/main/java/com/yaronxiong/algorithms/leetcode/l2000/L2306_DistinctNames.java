package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2306. 公司命名
 * 算术评级: 8
 * 第 297 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 2305
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串数组 ideas 表示在公司命名过程中使用的名字列表。公司命名流程如下：
 * <p>
 * 从 ideas 中选择 2 个 不同 名字，称为 ideaA 和 ideaB 。
 * 交换 ideaA 和 ideaB 的首字母。
 * 如果得到的两个新名字 都 不在 ideas 中，那么 ideaA ideaB（串联 ideaA 和 ideaB ，中间用一个空格分隔）是一个有效的公司名字。
 * 否则，不是一个有效的名字。
 * 返回 不同 且有效的公司名字的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：ideas = ["coffee","donuts","time","toffee"]
 * 输出：6
 * 解释：下面列出一些有效的选择方案：
 * - ("coffee", "donuts")：对应的公司名字是 "doffee conuts" 。
 * - ("donuts", "coffee")：对应的公司名字是 "conuts doffee" 。
 * - ("donuts", "time")：对应的公司名字是 "tonuts dime" 。
 * - ("donuts", "toffee")：对应的公司名字是 "tonuts doffee" 。
 * - ("time", "donuts")：对应的公司名字是 "dime tonuts" 。
 * - ("toffee", "donuts")：对应的公司名字是 "doffee tonuts" 。
 * 因此，总共有 6 个不同的公司名字。
 * <p>
 * 下面列出一些无效的选择方案：
 * - ("coffee", "time")：在原数组中存在交换后形成的名字 "toffee" 。
 * - ("time", "toffee")：在原数组中存在交换后形成的两个名字。
 * - ("coffee", "toffee")：在原数组中存在交换后形成的两个名字。
 * 示例 2：
 * <p>
 * 输入：ideas = ["lack","back"]
 * 输出：0
 * 解释：不存在有效的选择方案。因此，返回 0 。
 * <p>
 * 提示：
 * <p>
 * 2 <= ideas.length <= 5 * 104
 * 1 <= ideas[i].length <= 10
 * ideas[i] 由小写英文字母组成
 * ideas 中的所有字符串 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximize-number-of-subsequences-in-a-string/description/?envType=daily-question&envId=2024-09-24">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2306_DistinctNames {
    public static void main(String[] args) {
        L2306_DistinctNames l2306DistinctNames = new L2306_DistinctNames();
        System.out.println(l2306DistinctNames.distinctNames(new String[]{"aaa", "baa", "caa", "bbb", "cbb", "dbb"}));
    }

    public long distinctNames(String[] ideas) {
        Set<String>[] sets = new Set[26];
        Arrays.setAll(sets, i -> new HashSet<>());
        for (String idea : ideas) {
            char firstChar = idea.charAt(0);
            sets[firstChar - 'a'].add(idea.substring(1));
        }
        long ans = 0;
        for (int i = 1; i < 26; i++) {
            //根据题意首字母一样 后缀一定不一样，要不然就重复了
            //首字母一样的字符是不能交换的
            //求i与j之间的差集
            for (int j = i - 1; j >= 0; j--) {
                int m = 0;
                Set<String> iSet = sets[i];
                Set<String> jSet = sets[j];
                for (String s : iSet) {
                    if (jSet.contains(s)) {
                        m++;
                    }
                }
                ans += (long) (iSet.size() - m) * (jSet.size() - m);
            }
        }
        return ans * 2;
    }


}
