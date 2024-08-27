package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.HashMap;
import java.util.Map;

/**
 * 3134. 找出唯一性数组的中位数
 * 尝试过
 * 算术评级: 8
 * 第 395 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 2451
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 。数组 nums 的 唯一性数组 是一个按元素从小到大排序的数组，包含了 nums 的所有非空子数组中不同元素的个数。
 * <p>
 * 换句话说，这是由所有 0 <= i <= j < nums.length 的 distinct(nums[i..j]) 组成的递增数组。
 * <p>
 * 其中，distinct(nums[i..j]) 表示从下标 i 到下标 j 的子数组中不同元素的数量。
 * <p>
 * 返回 nums 唯一性数组 的 中位数 。
 * <p>
 * 注意，数组的 中位数 定义为有序数组的中间元素。如果有两个中间元素，则取值较小的那个。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * nums 的唯一性数组为 [distinct(nums[0..0]), distinct(nums[1..1]), distinct(nums[2..2]),
 * distinct(nums[0..1]), distinct(nums[1..2]), distinct(nums[0..2])]，即 [1, 1, 1, 2, 2, 3] 。
 * 唯一性数组的中位数为 1 ，因此答案是 1 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,3,4,5]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * nums 的唯一性数组为 [1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3] 。唯一性数组的中位数为 2 ，因此答案是 2 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [4,3,5,4]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * nums 的唯一性数组为 [1, 1, 1, 1, 2, 2, 2, 3, 3, 3] 。唯一性数组的中位数为 2 ，因此答案是 2 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-median-of-the-uniqueness-array/description/?envType=daily-question&envId=2024-08-27">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3134_MedianOfUniquenessArray {
    public static void main(String[] args) {
        L3134_MedianOfUniquenessArray l3134MedianOfUniquenessArray = new L3134_MedianOfUniquenessArray();
        System.out.println(l3134MedianOfUniquenessArray.medianOfUniquenessArray2(new int[]{4, 3, 5, 4}));
        System.out.println(l3134MedianOfUniquenessArray.medianOfUniquenessArray(new int[]{4, 3, 5, 4}));
    }

    public int medianOfUniquenessArray2(int[] nums) {
        int n = nums.length;
        long k = ((long) n * (n + 1) / 2 + 1) / 2;
        int left = 0;
        int right = n;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (check2(nums, mid, k)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check2(int[] nums, int upper, long k) {
        long cnt = 0;
        int l = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int r = 0; r < nums.length; r++) {
            freq.merge(nums[r], 1, Integer::sum); // 移入右端点
            while (freq.size() > upper) { // 窗口内元素过多
                int out = nums[l++];
                if (freq.merge(out, -1, Integer::sum) == 0) { // 移出左端点
                    freq.remove(out);
                }
            }
            cnt += r - l + 1; // 右端点固定为 r 时，有 r-l+1 个合法左端点
            if (cnt >= k) {
                return true;
            }
        }
        return false;
    }


    public int medianOfUniquenessArray(int[] nums) {
        int n = nums.length;
        long subArraySum = ((long) n * (1 + n)) / 2;
        long target = subArraySum / 2;
        if (subArraySum % 2 != 0) {
            target++;
        }
        int left = 1;
        int right = n;
        //[left,right)
        while (left < right) {
            int mid = (left + right) / 2;
            boolean temp = check(mid, target, nums);
            if (temp) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int uniqueSize, long target, int[] nums) {
        //目标：找到有多少个子数组数组的唯一元素个数小于uniqueSize，在满足条件的情况下子数组数量是否大于target
        Map<Integer, Integer> freq = new HashMap<>();
        long cnt = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            freq.merge(nums[right], 1, Integer::sum);
            //如果一个区间内的唯一元素> uniqueSize，说明这个区间一定不符合条件，踢出左边元素
            while (freq.size() > uniqueSize) {
                //移除
                Integer merge = freq.merge(nums[left], -1, Integer::sum);
                if (merge == 0) {
                    freq.remove(nums[left]);
                }
                left++;
            }
            //此时(left,right]区间能构成多少个子数组
            cnt += right - left + 1;
            if (cnt >= target) {
                return true;
            }
        }
        return false;
    }
}
