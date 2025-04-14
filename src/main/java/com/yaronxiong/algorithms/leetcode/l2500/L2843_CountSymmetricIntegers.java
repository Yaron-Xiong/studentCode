package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2843. 统计对称整数的数目
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个正整数 low 和 high 。
 * <p>
 * 对于一个由 2 * n 位数字组成的整数 x ，如果其前 n 位数字之和与后 n 位数字之和相等，则认为这个数字是一个对称整数。
 * <p>
 * 返回在 [low, high] 范围内的 对称整数的数目 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：low = 1, high = 100
 * 输出：9
 * 解释：在 1 到 100 范围内共有 9 个对称整数：11、22、33、44、55、66、77、88 和 99 。
 * 示例 2：
 * <p>
 * 输入：low = 1200, high = 1230
 * 输出：4
 * 解释：在 1200 到 1230 范围内共有 4 个对称整数：1203、1212、1221 和 1230 。
 * <p>
 * 提示：
 * <p>
 * 1 <= low <= high <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-symmetric-integers/?envType=daily-question&envId=2025-04-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2843_CountSymmetricIntegers {
    public int countSymmetricIntegers(int low, int high) {
        //位数 2、4、6、8、10
        int ans = 0;
        for (int i = low; i <= high; i++) {
            String s = Integer.toString(i);
            char[] charArray = s.toCharArray();
            if (charArray.length % 2 != 0) {
                continue;
            }
            int preSum = 0;
            for (int j = 0; j < charArray.length / 2; j++) {
                preSum += charArray[j] - '0';
            }
            int suffixSum = 0;
            for (int j = charArray.length/2; j < charArray.length; j++) {
                suffixSum += charArray[j] - '0';
            }
            if (preSum == suffixSum) {
                ans++;
            }
        }
        return ans;
    }
}
