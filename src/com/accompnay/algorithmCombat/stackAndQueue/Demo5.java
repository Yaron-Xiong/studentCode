package com.accompnay.algorithmCombat.stackAndQueue;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Accompany
 *
 * LeetCode 703题
 *
 * 设计一个找到数据流中第K大元素的类（class）。
 * 注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，
 * 它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *  示例:
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 *
 * 解决方案1：
 * 维护一个前K大的数组，在获取第K大的数组的时候
 * 将数组进行排序然后返回最后一位即可
 * 时间复杂度：O（N*LogN）
 *
 * 解决方案2：
 * 使用最小堆
 * 最小堆的长度为K 存储前K大的元素 第K大的元素会在堆顶
 * 时间复杂度：0（N*logk）
 */
public class Demo5 {
    /*解法1:使用数组
    private List<Integer> arr ;
    private int k ;

    public Demo5(int k, int[] nums) {
        arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }
        this.k = k;
    }

    //每次添加的时候返回第K个最大值
    public int add(int val) {
        arr.add(val);
        Collections.sort(arr);
        return arr.get(arr.size()-k);
    }*/

    private Queue<Integer> queue ;
    private int k ;
    public Demo5(int k, int[] nums) {
        queue = new PriorityQueue<>(k);
        Arrays.sort(nums);
        int length = nums.length-k>=0?nums.length-k:0;
        for (int i = length ; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        this.k = k;
    }

    //每次添加的时候返回第K个最大值
    public int add(int val) {
        if (queue.size()<k){
            queue.add(val);
        }else if (queue.peek()<val){
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        Demo5 demo5 = new Demo5(3,new int []{4,5,8,2});
        System.out.println(demo5.add(3));
        System.out.println(demo5.add(5));
        System.out.println(demo5.add(10));
        System.out.println(demo5.add(9));
        System.out.println(demo5.add(4));
    }
}
