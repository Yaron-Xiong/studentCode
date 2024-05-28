package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;

/**
 * 2864. 最大二进制奇数
 * 第 364 场周赛
 * Q1
 * 1238
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 二进制 字符串 s ，其中至少包含一个 '1' 。
 * <p>
 * 你必须按某种方式 重新排列 字符串中的位，使得到的二进制数字是可以由该组合生成的 最大二进制奇数 。
 * <p>
 * 以字符串形式，表示并返回可以由给定组合生成的最大二进制奇数。
 * <p>
 * 注意 返回的结果字符串 可以 含前导零。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "010"
 * 输出："001"
 * 解释：因为字符串 s 中仅有一个 '1' ，其必须出现在最后一位上。所以答案是 "001" 。
 * 示例 2：
 * <p>
 * 输入：s = "0101"
 * 输出："1001"
 * 解释：其中一个 '1' 必须出现在最后一位上。而由剩下的数字可以生产的最大数字是 "100" 。所以答案是 "1001" 。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 仅由 '0' 和 '1' 组成
 * s 中至少包含一个 '1'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-odd-binary-number/description/?envType=daily-question&envId=2024-03-13">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2864_MaximumOddBinaryNumber {
    public static void main(String[] args) {
        L2864_MaximumOddBinaryNumber l2864MaximumOddBinaryNumber = new L2864_MaximumOddBinaryNumber();
        System.out.println(l2864MaximumOddBinaryNumber.maximumOddBinaryNumber("010"));
    }

    public String maximumOddBinaryNumber(String s) {
        //记录有多少个1
        int oneBitCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                oneBitCnt++;
            }
        }
        //必须设置右边第一位为1
        char[] ans = new char[s.length()];
        Arrays.fill(ans, '0');
        ans[ans.length - 1] = '1';
        oneBitCnt--;
        for (int i = 0; i < oneBitCnt; i++) {
            ans[i] = '1';
        }
        return new String(ans);
    }
}
