package com.accompnay.TopicAlgorithms.swordFingerOffer.math;

/**
 * 剑指 Offer 14- I. 剪绳子
 * <p>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 ×3 ×4 = 36
 * 提示：
 * <p>
 * 2 <= n <= 58
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/jian-sheng-zi-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S14_CuttingRopeI {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        //长度为1 乘积最大值为1
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                //每一个dp位置都可以由前面的位置状态跃迁过来
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, (i - j) * dp[j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        S14_CuttingRopeI s14CuttingRopeI = new S14_CuttingRopeI();
        System.out.println(s14CuttingRopeI.cuttingRope(10));
    }
}
