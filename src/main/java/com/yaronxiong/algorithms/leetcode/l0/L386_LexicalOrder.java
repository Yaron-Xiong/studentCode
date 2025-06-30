package com.yaronxiong.algorithms.leetcode.l0;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 * <p>
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 13
 * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：[1,2]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 5 * 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/lexicographical-numbers/description/?envType=daily-question&envId=2025-06-10">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L386_LexicalOrder {
    public static void main(String[] args) {
        L386_LexicalOrder l386LexicalOrder = new L386_LexicalOrder();
        System.out.println(l386LexicalOrder.lexicalOrder(133));
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs2(i, n, ans);
        }
        return ans;
    }

    private void dfs2(int node, int n, List<Integer> ans) {
        if (node > n) {
            return;
        }
        ans.add(node);
        for (int i = 0; i <= 9; i++) {
            dfs2(node * 10 + i, n, ans);
        }
    }
}
