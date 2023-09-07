package com.accompnay.TopicAlgorithms.swordFingerOffer.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * <p>
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TranslateNum {
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        int fn0 = 1;
        int fn1 = 1;
        for (int i = 1; i < numStr.length(); i++) {
            int temp = fn1;
            char a = numStr.charAt(i - 1);
            char b = numStr.charAt(i);
            if (a > '0' && a < '2' && b <= '9') {
                temp += fn0;
            } else if (a == '2' && b <= '5') {
                temp += fn0;
            }
            fn0 = fn1;
            fn1 = temp;
        }
        return fn1;
    }

    Map<Integer, Integer> memo = new HashMap<>();

    private int dfs(String numStr, int index) {
        if (index >= numStr.length()) {
            return 1;
        }
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        int res = dfs(numStr, index + 1);
        if (index + 1 < numStr.length()) {
            char a = numStr.charAt(index);
            char b = numStr.charAt(index + 1);
            if (a > '0' && a < '2' && b <= '9') {
                res += dfs(numStr, index + 2);
            } else if (a == '2' && b <= '5') {
                res += dfs(numStr, index + 2);
            }
        }
        memo.put(index, res);
        return res;
    }


    public static void main(String[] args) {
        TranslateNum translateNum = new TranslateNum();
        int i = translateNum.translateNum(25);
        System.out.println(i);
    }
}
