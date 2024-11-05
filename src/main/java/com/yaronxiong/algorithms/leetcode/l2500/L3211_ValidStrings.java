package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.ArrayList;
import java.util.List;

/**
 * 3211. 生成不含相邻零的二进制字符串
 * 算术评级: 4
 * 第 405 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1353
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个正整数 n。
 * <p>
 * 如果一个二进制字符串 x 的所有长度为 2 的
 * 子字符串
 * 中包含 至少 一个 "1"，则称 x 是一个 有效 字符串。
 * <p>
 * 返回所有长度为 n 的 有效 字符串，可以以任意顺序排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 3
 * <p>
 * 输出： ["010","011","101","110","111"]
 * <p>
 * 解释：
 * <p>
 * 长度为 3 的有效字符串有："010"、"011"、"101"、"110" 和 "111"。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 1
 * <p>
 * 输出： ["0","1"]
 * <p>
 * 解释：
 * <p>
 * 长度为 1 的有效字符串有："0" 和 "1"。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 18
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/generate-binary-strings-without-adjacent-zeros/description/?envType=daily-question&envId=2024-10-29">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3211_ValidStrings {
    public static void main(String[] args) {
        L3211_ValidStrings l3211ValidStrings = new L3211_ValidStrings();
        System.out.println(l3211ValidStrings.validStrings(3));
    }

    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        char[] paths = new char[n];
        dfs2(0, paths, ans);
        return ans;
    }

    private void dfs2(int curIndex, char[] paths, List<String> ans) {
        int n = paths.length;
        if (curIndex == n) {
            ans.add(new String(paths));
            return;
        }
        //填0，判断前面是不是0
        if (curIndex == 0 || (curIndex > 0 && paths[curIndex - 1] != '0')) {
            paths[curIndex] = '0';
            dfs2(curIndex + 1, paths, ans);
        }
        //填1
        paths[curIndex] = '1';
        dfs2(curIndex + 1, paths, ans);
    }
}
