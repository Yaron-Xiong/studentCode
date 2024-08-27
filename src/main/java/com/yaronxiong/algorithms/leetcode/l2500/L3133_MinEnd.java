package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 3133. 数组最后一个元素的最小值
 * 已解答
 * 算术评级: 6
 * 第 395 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1935
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个整数 n 和 x 。你需要构造一个长度为 n 的 正整数 数组 nums ，对于所有 0 <= i < n - 1 ，
 * 满足 nums[i + 1] 大于 nums[i] ，并且数组 nums 中所有元素的按位 AND 运算结果为 x 。
 * <p>
 * 返回 nums[n - 1] 可能的 最小 值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, x = 4
 * <p>
 * 输出：6
 * <p>
 * 解释：
 * <p>
 * 数组 nums 可以是 [4,5,6] ，最后一个元素为 6 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 2, x = 7
 * <p>
 * 输出：15
 * <p>
 * 解释：
 * <p>
 * 数组 nums 可以是 [7,15] ，最后一个元素为 15 。
 * <p>
 * 提示：
 * <p>
 * 1 <= n, x <= 108
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-array-end/description/?envType=daily-question&envId=2024-08-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3133_MinEnd {
    public static void main(String[] args) {
        L3133_MinEnd l3133MinEnd = new L3133_MinEnd();
        System.out.println(l3133MinEnd.minEnd(2, 7));
    }

    public void test() {
        int a = 10;

        System.out.println();
    }

    public long minEnd(int n, int x) {
        int cnt = n - 1;
        //把cnt的二进制位中的01关系填进x中就好了
        int ansIndex = 0;
        long ans = x;
        while (cnt > 0) {
            //怎么判断第index位置是0还是1呢？
            if ((ans >> ansIndex & 1) == 0) {
                //说明这个位置是0
                int cntValue = cnt & 1;
                ans |= (long) cntValue << ansIndex;
                cnt >>= 1;
            }
            ansIndex++;
        }
        return ans;
    }
}
