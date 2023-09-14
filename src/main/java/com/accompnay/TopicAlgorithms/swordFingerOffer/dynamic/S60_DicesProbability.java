package com.accompnay.TopicAlgorithms.swordFingerOffer.dynamic;

import java.util.Arrays;

/**
 * 剑指 Offer 60. n个骰子的点数
 * 中等
 * 580
 * 相关企业
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * <p>
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 * <p>
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 11
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/?envType=study-plan-v2&envId=coding-interviews">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S60_DicesProbability {
    public static void main(String[] args) {
        S60_DicesProbability s60DicesProbability = new S60_DicesProbability();
        System.out.println(Arrays.toString(s60DicesProbability.dicesProbability(3)));

    }

    public double[] dicesProbability(int n) {
        double basePoint = (double) 1 / 6;
        double[] dp = new double[]{basePoint, basePoint, basePoint, basePoint, basePoint, basePoint};
        for (int i = 2; i <= n; i++) {
            double[] tempDp = new double[i * 6 - i + 1];
            //现在进行的是第i颗骰子 i颗骰子点点数范围在  [i,i*6]
            // i-1颗骰子的点数范围在 [i-1,(i-1) * 6]
            int preMinSize = (i - 1);
            for (int j = i; j <= i * 6; j++) {
                int index = j - i;
                //开始投掷骰子 范围[1~6]
                for (int z = 1; z <= 6; z++) {
                    int prePoint = j - z;
                    if (prePoint - preMinSize < 0 || prePoint - preMinSize >= dp.length) {
                        continue;
                    }
                    tempDp[index] += dp[prePoint - preMinSize] * basePoint;
                }
            }
            dp = tempDp;
        }
        return dp;
    }

}
