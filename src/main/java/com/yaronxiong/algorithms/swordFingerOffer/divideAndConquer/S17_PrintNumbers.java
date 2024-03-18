package com.yaronxiong.algorithms.swordFingerOffer.divideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 简单
 * 308
 * 相关企业
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * <p>
 * 说明：
 * <p>
 * 用返回一个整数列表来代替打印
 * n 为正整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/?envType=study-plan-v2&envId=coding-interviews">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S17_PrintNumbers {
    public static void main(String[] args) {
        S17_PrintNumbers s17PrintNumbers = new S17_PrintNumbers();
        System.out.println(Arrays.toString(s17PrintNumbers.printNumbers(2)));

    }

    public int[] printNumbers(int n) {
        //选择n位，每一位可选择的范围有[0~9]
        ArrayList<String> list = new ArrayList<>();
        dfs(n, new StringBuilder(), list);
        int[] res = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            res[j] = Integer.parseInt(list.get(j));
        }
        Arrays.sort(res);
        return res;
    }

    private void dfs(int maxSize, StringBuilder sb, List<String> res) {
        if (sb.length() >= maxSize) {
            return;
        }
        int startValue = sb.length() == 0 ? 1 : 0;
        for (int i = startValue; i < 10; i++) {
            sb.append(i);
            res.add(sb.toString());
            dfs(maxSize, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
