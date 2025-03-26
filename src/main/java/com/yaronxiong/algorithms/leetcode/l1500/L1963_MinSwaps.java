package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1963. 使字符串平衡的最小交换次数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s ，下标从 0 开始 ，且长度为偶数 n 。字符串 恰好 由 n / 2 个开括号 '[' 和 n / 2 个闭括号 ']' 组成。
 * <p>
 * 只有能满足下述所有条件的字符串才能称为 平衡字符串 ：
 * <p>
 * 字符串是一个空字符串，或者
 * 字符串可以记作 AB ，其中 A 和 B 都是 平衡字符串 ，或者
 * 字符串可以写成 [C] ，其中 C 是一个 平衡字符串 。
 * 你可以交换 任意 两个下标所对应的括号 任意 次数。
 * <p>
 * 返回使 s 变成 平衡字符串 所需要的 最小 交换次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "][]["
 * 输出：1
 * 解释：交换下标 0 和下标 3 对应的括号，可以使字符串变成平衡字符串。
 * 最终字符串变成 "[[]]" 。
 * 示例 2：
 * <p>
 * 输入：s = "]]][[["
 * 输出：2
 * 解释：执行下述操作可以使字符串变成平衡字符串：
 * - 交换下标 0 和下标 4 对应的括号，s = "[]][][" 。
 * - 交换下标 1 和下标 5 对应的括号，s = "[[][]]" 。
 * 最终字符串变成 "[[][]]" 。
 * 示例 3：
 * <p>
 * 输入：s = "[]"
 * 输出：0
 * 解释：这个字符串已经是平衡字符串。
 * <p>
 * 提示：
 * <p>
 * n == s.length
 * 2 <= n <= 106
 * n 为偶数
 * s[i] 为'[' 或 ']'
 * 开括号 '[' 的数目为 n / 2 ，闭括号 ']' 的数目也是 n / 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/?envType=daily-question&envId=2025-03-17">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1963_MinSwaps {
    public static void main(String[] args) {
        L1963_MinSwaps l1963MinSwaps = new L1963_MinSwaps();
        System.out.println(l1963MinSwaps.minSwaps("][]["));
        System.out.println(l1963MinSwaps.minSwaps("]]][[["));
        System.out.println(l1963MinSwaps.minSwaps("[]"));
        //]]][[[
    }

    public int minSwaps(String s) {
        int left = 0;
        int right = s.length() - 1;
        int leftCnt = 0;
        int ans = 0;
        while (left < right) {
            if (s.charAt(left) == '[') {
                left++;
                leftCnt++;
            }else if (leftCnt > 0) {
                //这时候left=] //剩余多了
                leftCnt--;
                left++;
            }else {
                //没有剩余的[ 需要交换了，交换要从 右边找到最后一个[ 进行交换
                while (left < right && s.charAt(right) == ']') {
                    right--;
                }
                //开始交换
                left++;
                right--;
                leftCnt++;
                ans++;
            }
        }
        return ans;
    }

}
