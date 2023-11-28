package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 907. 子数组的最小值之和
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 * <p>
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 * 示例 2：
 * <p>
 * 输入：arr = [11,81,94,43,3]
 * 输出：444
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 3 * 104
 * 1 <= arr[i] <= 3 * 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/sum-of-subarray-minimums/?envType=daily-question&envId=2023-11-27">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L907_SumSubarrayMins {
    public static void main(String[] args) {
        L907_SumSubarrayMins l907SumSubarrayMins = new L907_SumSubarrayMins();
        System.out.println(l907SumSubarrayMins.sumSubarrayMins(new int[]{71,55,82,55}));
    }

    public int sumSubarrayMins(int[] arr) {
        //1.统计左边界
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(-1);
        int[] left = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (deque.size() > 1 && arr[deque.peekFirst()] >= arr[i]) {
                deque.pollFirst();
            }
            left[i] = deque.peekFirst();
            deque.addFirst(i);
        }
        //统计右边界
        deque.clear();
        deque.addFirst(arr.length);
        int[] right = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (deque.size() > 1 && arr[deque.peekFirst()] > arr[i]) {
                deque.pollFirst();
            }
            right[i] = deque.peekFirst();
            deque.addFirst(i);
        }

        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int leftCnt = i - left[i] ;
            int rightCnt = right[i] - i;
            ans += arr[i] * ((long) leftCnt * rightCnt);
            ans %= 1000000007;
        }
        return (int) ans;
    }
}
