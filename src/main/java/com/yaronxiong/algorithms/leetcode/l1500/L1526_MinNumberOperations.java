package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1526. 形成目标数组的子数组最少增加次数
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 target 和一个数组 initial ，initial 数组与 target  数组有同样的维度，且一开始全部为 0 。
 * <p>
 * 请你返回从 initial 得到  target 的最少操作次数，每次操作需遵循以下规则：
 * <p>
 * 在 initial 中选择 任意 子数组，并将子数组中每个元素增加 1 。
 * 答案保证在 32 位有符号整数以内。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = [1,2,3,2,1]
 * 输出：3
 * 解释：我们需要至少 3 次操作从 intial 数组得到 target 数组。
 * [0,0,0,0,0] 将下标为 0 到 4 的元素（包含二者）加 1 。
 * [1,1,1,1,1] 将下标为 1 到 3 的元素（包含二者）加 1 。
 * [1,2,2,2,1] 将下表为 2 的元素增加 1 。
 * [1,2,3,2,1] 得到了目标数组。
 * 示例 2：
 * <p>
 * 输入：target = [3,1,1,2]
 * 输出：4
 * 解释：(initial)[0,0,0,0] -> [1,1,1,1] -> [1,1,1,2] -> [2,1,1,2] -> [3,1,1,2] (target) 。
 * 示例 3：
 * <p>
 * 输入：target = [3,1,5,4,2]
 * 输出：7
 * 解释：(initial)[0,0,0,0,0] -> [1,1,1,1,1] -> [2,1,1,1,1] -> [3,1,1,1,1]
 * -> [3,1,2,2,2] -> [3,1,3,3,2] -> [3,1,4,4,2] -> [3,1,5,4,2] (target)。
 * 示例 4：
 * <p>
 * 输入：target = [1,1,1,1]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= target.length <= 10^5
 * 1 <= target[i] <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/description/?envType=daily-question&envId=2025-10-30">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1526_MinNumberOperations {
    public static void main(String[] args) {
        L1526_MinNumberOperations l1526MinNumberOperations = new L1526_MinNumberOperations();
        System.out.println(l1526MinNumberOperations.minNumberOperations(new int[]{3, 1, 1, 2}));
        System.out.println(l1526MinNumberOperations.minNumberOperations(new int[]{3, 1, 5, 4, 2}));
        System.out.println(l1526MinNumberOperations.minNumberOperations(new int[]{1, 2, 3, 2, 1}));
    }

    public int minNumberOperations(int[] target) {
        int ans = target[0];
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                ans += target[i] - target[i - 1];
            }
        }
        return ans;
    }


}
