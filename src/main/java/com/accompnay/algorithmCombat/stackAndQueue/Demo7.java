package com.accompnay.algorithmCombat.stackAndQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Accompany
 * <p>
 * LeetCode 239题
 * <p>
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 解法1：暴力破解
 * 每次将窗口元素都进行排序然后得出最大值
 * <p>
 * 解法2：使用优先队列存储
 * 注意的问题，可能会存储非当前窗口的数据，
 * 当top为非当前窗口的数据则将数据弹出继续取
 * <p>
 * 解决3：使用双向队列
 * 1.队列记录数组的下标，用来判断是否超出窗口
 * 2.队列的对头一定是最大值
 * 3.新加入的值，需要从队尾开始判断 如果超过则删除
 */
public class Demo7 {
    /*
    //解法1：使用优先级队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0){
            return new int[]{};
        }
        //逆序
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int[] rs = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            //添加元素
            queue.add(nums[i]);
            if (queue.size() == k) {
                rs[index++] = queue.peek();
                //表示队列满了，需要弹出最开始进入的元素，但是效率很低
                // remove方法时间复杂度为O(K)
                queue.remove(nums[i - k+1]);
            }
        }
        return rs;
    }*/


    public static void main(String[] args) {
        Demo7 demo7 = new Demo7();
        int[] ints = demo7.maxSlidingWindow(new int[]{7,2,4}, 2);
        System.out.println(Arrays.toString(ints));
    }

    //解法2：使用双向队列
    private int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length*k==0){
            return new int[]{};
        }
        if (k==1){
            return nums;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int [] rs = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty()&&nums[queue.getLast()]<nums[i]){
                queue.removeLast();
            }
            queue.add(i);
            if (i>=k-1){
                if (queue.getFirst()<i-k+1){
                    queue.removeFirst();
                }
                rs[i-k+1] = nums[queue.getFirst()];
            }
        }
        return rs;
    }

}
