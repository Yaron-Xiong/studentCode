package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3258. 统计满足 K 约束的子字符串数量 I
 * 算术评级: 1
 * 第 411 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1258
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 二进制 字符串 s 和一个整数 k。
 * <p>
 * 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
 * <p>
 * 字符串中 0 的数量最多为 k。
 * 字符串中 1 的数量最多为 k。
 * 返回一个整数，表示 s 的所有满足 k 约束 的子字符串的数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "10101", k = 1
 * <p>
 * 输出：12
 * <p>
 * 解释：
 * <p>
 * s 的所有子字符串中，除了 "1010"、"10101" 和 "0101" 外，其余子字符串都满足 k 约束。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "1010101", k = 2
 * <p>
 * 输出：25
 * <p>
 * 解释：
 * <p>
 * s 的所有子字符串中，除了长度大于 5 的子字符串外，其余子字符串都满足 k 约束。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "11111", k = 1
 * <p>
 * 输出：15
 * <p>
 * 解释：
 * <p>
 * s 的所有子字符串都满足 k 约束。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 50
 * 1 <= k <= s.length
 * s[i] 是 '0' 或 '1'。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-substrings-that-satisfy-k-constraint-i/description/?envType=daily-question&envId=2024-11-12">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3258_CountKConstraintSubstrings {
    public static void main(String[] args) {
        L3258_CountKConstraintSubstrings l3258CountKConstraintSubstrings = new L3258_CountKConstraintSubstrings();
        System.out.println(l3258CountKConstraintSubstrings.countKConstraintSubstrings("1010101", 2));
    }

    public int countKConstraintSubstrings(String s, int k) {
        //滑动窗口
        int left = 0;
        int ans = 0;
        int[] cnt = new int[]{0, 0};
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            cnt[charArray[i] - '0']++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[charArray[left] - '0']--;
                left++;
            }
            //这个时候 [left,right-1] 都是合法的子字符串，求和
            ans += i - left + 1;
        }
        return ans;
    }
}
