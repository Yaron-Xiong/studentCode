package com.accompnay.TopicAlgorithms.swordFingerOffer.dynamic;

/**
 * 剑指 Offer 49. 丑数
 * 中等
 * 496
 * 相关企业
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 * 注意：本题与主站 264 题相同：<a href="https://leetcode-cn.com/problems/ugly-number-ii/">...</a>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/chou-shu-lcof/?envType=study-plan-v2&envId=coding-interviews">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S49_NthUglyNumber {
    public static void main(String[] args) {
        S49_NthUglyNumber s49NthUglyNumber = new S49_NthUglyNumber();
        System.out.println(s49NthUglyNumber.nthUglyNumber(11));
    }

    public int nthUglyNumber(int n) {
        //可以将dp[i] 想象成第i个丑数
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int dp1 = 1;
        int dp2 = 1;
        int dp3 = 1;
        for (int i = 2; i <= n; i++) {
            //a ,b,c是下一个丑数值
            int a = dp[dp1] * 2;
            int b = dp[dp2] * 3;
            int c = dp[dp3] * 5;
            dp[i] = Math.min(a, Math.min(b, c));
            if (dp[i] == a) {
                dp1++;
            }
            if (dp[i] == b) {
                dp2++;
            }
            if (dp[i] == c) {
                dp3++;
            }
        }
        return dp[n];
    }
}
