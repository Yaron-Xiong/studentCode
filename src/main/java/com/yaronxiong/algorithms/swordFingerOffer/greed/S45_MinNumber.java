package com.yaronxiong.algorithms.swordFingerOffer.greed;

import java.util.Arrays;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * <p>
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * 示例2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/?envType=study-plan-v2&envId=coding-interviews">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S45_MinNumber {

    public static void main(String[] args) {
        S45_MinNumber s45MinNumber = new S45_MinNumber();
        String s = s45MinNumber.minNumber2(new int[]{3, 30, 34, 5, 9});
        System.out.println(s);
    }

    public String minNumber2(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    private void quickSort(String[] items, int left, int right) {
        if (left >= right) {
            return;
        }
        //三路快排
        //l ：区分 小于standValue于等于standValue的界限
        //index: 标记着当前遍历的位置 其中（index-l +1 代表基准值个数）
        int l = left;
        int r = right;
        int index = left + 1;
        String standValue = items[left];
        while (index <= r) {
            int compareTo = (items[index] + standValue).compareTo(standValue + items[index]);
            if (compareTo < 0) {
                //交换index / l
                swap(items, index, l);
                index++;
                l++;
            } else if (compareTo > 0) {
                swap(items, index, r);
                r--;
            } else {
                index++;
            }
        }
        quickSort(items, left, l - 1);
        quickSort(items, r + 1, right);
    }

    private void swap(String[] items, int a, int b) {
        String temp = items[a];
        items[a] = items[b];
        items[b] = temp;
    }

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (a, b) -> (a + b).compareTo(b + a));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

}
