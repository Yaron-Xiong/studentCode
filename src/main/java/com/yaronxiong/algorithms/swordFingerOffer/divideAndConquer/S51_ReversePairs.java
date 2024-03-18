package com.yaronxiong.algorithms.swordFingerOffer.divideAndConquer;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * 困难
 * 1.1K
 * 相关企业
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/?envType=study-plan-v2&envId=coding-interviews">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S51_ReversePairs {
    public static void main(String[] args) {
        S51_ReversePairs s51ReversePairs = new S51_ReversePairs();
        System.out.println(s51ReversePairs.reversePairs(new int[]{7, 5, 6, 4}));
    }

    public int reversePairs(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }

    private int merge(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) >> 1;
        int res = 0;
        res += merge(nums, left, mid);
        res += merge(nums, mid + 1, right);
        int[] sortArr = new int[right - left + 1];
        //合并 (left,mid),(mid+1，right)
        int leftStart = left;
        int rightStart = mid + 1;
        int index = 0;
        while (leftStart <= mid && rightStart <= right) {
            //如果右边比左边小，则说明存在逆序对
            if (nums[leftStart] > nums[rightStart]) {
                res += mid - leftStart + 1;
                sortArr[index++] = nums[rightStart++];
            } else {
                sortArr[index++] = nums[leftStart++];
            }
        }
        while (leftStart <= mid){
            sortArr[index++] = nums[leftStart++];
        }
        while (rightStart <= right){
            sortArr[index++] = nums[rightStart++];
        }
        System.arraycopy(sortArr, 0, nums, left, sortArr.length);
        return res;
    }

}
