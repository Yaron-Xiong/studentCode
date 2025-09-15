package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1780. 判断一个数字是否可以表示成三的幂的和
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
 * <p>
 * 对于一个整数 y ，如果存在整数 x 满足 y == 3x ，我们称这个整数 y 是三的幂。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：true
 * 解释：12 = 31 + 32
 * 示例 2：
 * <p>
 * 输入：n = 91
 * 输出：true
 * 解释：91 = 30 + 32 + 34
 * 示例 3：
 * <p>
 * 输入：n = 21
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 107
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/power-of-three/description/?envType=daily-question&envId=2025-08-13">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1780_CheckPowersOfThree {
    public static void main(String[] args) {
        L1780_CheckPowersOfThree l1780CheckPowersOfThree = new L1780_CheckPowersOfThree();
        System.out.println(l1780CheckPowersOfThree.checkPowersOfThree(11));
        System.out.println(l1780CheckPowersOfThree.checkPowersOfThree(12));
        System.out.println(l1780CheckPowersOfThree.checkPowersOfThree(91));
    }

    public boolean checkPowersOfThree(int n) {
        //三进制处理
        while (n > 0) {
            //说明有一位重复了
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

}
