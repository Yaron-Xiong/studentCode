package com.yaronxiong.algorithms.leetcode.l0;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 * <p>
 * 输入: numRows = 1
 * 输出: [[1]]
 * <p>
 * 提示:
 * <p>
 * 1 <= numRows <= 30
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/pascals-triangle/description/?envType=daily-question&envId=2025-08-01">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L118_Generate {
    public static void main(String[] args) {
        L118_Generate l118Generate = new L118_Generate();
        System.out.println(l118Generate.generate(5));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> preRow = new ArrayList<>();
        preRow.add(1);
        res.add(preRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            for (int j = 0; j < preRow.size() - 1; j++) {
                int v = preRow.get(j) + preRow.get(j + 1);
                curRow.add(v);
            }
            curRow.add(1);
            res.add(curRow);
            preRow = curRow;
        }
        return res;
    }
}
