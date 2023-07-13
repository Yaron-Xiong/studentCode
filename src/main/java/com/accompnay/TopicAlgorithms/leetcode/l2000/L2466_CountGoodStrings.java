package com.accompnay.TopicAlgorithms.leetcode.l2000;

/**
 * 2466. 统计构造好字符串的方案数
 * 提示
 * 中等
 * 24
 * 相关企业
 * 给你整数 zero ，one ，low 和 high ，我们从空字符串开始构造一个字符串，每一步执行下面操作中的一种：
 * <p>
 * 将 '0' 在字符串末尾添加 zero  次。
 * 将 '1' 在字符串末尾添加 one 次。
 * 以上操作可以执行任意次。
 * <p>
 * 如果通过以上过程得到一个 长度 在 low 和 high 之间（包含上下边界）的字符串，那么这个字符串我们称为 好 字符串。
 * <p>
 * 请你返回满足以上要求的 不同 好字符串数目。由于答案可能很大，请将结果对 109 + 7 取余 后返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：low = 3, high = 3, zero = 1, one = 1
 * 输出：8
 * 解释：
 * 一个可能的好字符串是 "011" 。
 * 可以这样构造得到："" -> "0" -> "01" -> "011" 。
 * 从 "000" 到 "111" 之间所有的二进制字符串都是好字符串。
 * 示例 2：
 * <p>
 * 输入：low = 2, high = 3, zero = 1, one = 2
 * 输出：5
 * 解释：好字符串为 "00" ，"11" ，"000" ，"110" 和 "011" 。
 * <p>
 * 提示：
 * <p>
 * 1 <= low <= high <= 105
 * 1 <= zero, one <= low
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-ways-to-build-good-strings/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2466_CountGoodStrings {
    public static void main(String[] args) {
        L2466_CountGoodStrings l2466CountGoodStrings = new L2466_CountGoodStrings();
        System.out.println(l2466CountGoodStrings.countGoodStrings(2, 3, 1, 2));
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        int pow = (int) (Math.pow(10, 9) + 7);
        dp[0] = 1;
        int res = 0;
        for (int i = 1; i <= high; i++) {
            int v1 = i < zero ? 0 : dp[i - zero];
            int v2 = i < one ? 0 : dp[i - one];
            dp[i] = (v1 + v2) % pow;
            if (i >= low) {
                res += dp[i];
                res %= pow;
            }
        }
        return res;
    }

}
