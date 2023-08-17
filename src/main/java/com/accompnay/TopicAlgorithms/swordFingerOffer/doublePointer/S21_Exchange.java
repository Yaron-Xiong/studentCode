package com.accompnay.TopicAlgorithms.swordFingerOffer.doublePointer;

import java.util.Arrays;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 示例：
 * <p>
 * 输入：nums =[1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S21_Exchange {
    public int[] exchange(int[] nums) {
        int oddIndex = -1;
        int index = 0;
        while (index < nums.length) {
            if (nums[index] % 2 != 0) {
                //与oddIndex进行交换
                swap(nums, ++oddIndex, index);
            }
            index++;
        }
        return nums;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        S21_Exchange s21Exchange = new S21_Exchange();
        int[] exchange1 = s21Exchange.exchange(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(exchange1));
    }
}
