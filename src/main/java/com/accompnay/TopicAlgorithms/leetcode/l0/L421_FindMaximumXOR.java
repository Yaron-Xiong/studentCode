package com.accompnay.TopicAlgorithms.leetcode.l0;

import java.util.HashSet;
import java.util.Set;

/**
 * 421. 数组中两个数的最大异或值
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 * 示例 2：
 * <p>
 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * 输出：127
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 105
 * 0 <= nums[i] <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/description/?envType=daily-question&envId=2023-11-04">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L421_FindMaximumXOR {
    public static void main(String[] args) {
        L421_FindMaximumXOR l421FindMaximumXOR = new L421_FindMaximumXOR();
        System.out.println(l421FindMaximumXOR.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }

    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int highBitIndex = 31 - Integer.numberOfLeadingZeros(max);
        //选择选取最高位
        int mask = 0;
        int ans = 0;
        Set<Integer> seen = new HashSet<>();
        for (int i = highBitIndex; i >= 0; i--) {
            //mask的作用为 保留高位
            mask = mask | (1 << i);
            seen.clear();
            for (int num : nums) {
                //保留高位
                seen.add(mask & num);
            }
//            System.out.println(Integer.toBinaryString(mask));

            //假设目前的ans 的第i位是1
            int tempAns = ans | (1 << i);
            for (Integer prefix : seen) {
                if (seen.contains(tempAns ^ prefix)) {
                    ans = tempAns;
                    break;
                }
            }
        }
        return ans;
    }
}
