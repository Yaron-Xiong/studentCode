package com.yaronxiong.algorithms.leetcode.l0;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 42. 接雨水
 * 困难
 * 4.5K
 * 相关企业
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例 1：
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/trapping-rain-water/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L42_Trap {
    public static void main(String[] args) {
        L42_Trap l42Trap = new L42_Trap();
        System.out.println(l42Trap.trap3(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        //按列求每一列最多能存储多少的水 == Math.min(左边最高、右边最高） - 当前列高度
        int[][] dp = new int[height.length][2];
        dp[0][0] = -1;
        dp[height.length - 1][1] = -1;
        for (int i = 1; i < height.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            dp[i][1] = Math.max(dp[i + 1][1], height[i + 1]);
        }
        int res = 0;
        for (int i = 1; i < dp.length - 1; i++) {
            if (dp[i][0] <= 0 || dp[i][0] < height[i] || dp[i][1] <= 0 || dp[i][1] < height[i]) {
                continue;
            }
            res += (Math.min(dp[i][0], dp[i][1]) - height[i]);
        }
        return res;
    }

    public int trap2(int[] height) {
        Deque<Integer> deque = new LinkedList<>();
        int res = 0;
        for (int rightIndex = 0; rightIndex < height.length; rightIndex++) {
            int rightValue = height[rightIndex];
            while (!deque.isEmpty() && height[deque.peekLast()] < rightValue) {
                Integer cueNode = deque.pollLast();
                while (!deque.isEmpty() && height[deque.peekLast()] == height[cueNode]) {
                    deque.pollLast();
                }
                Integer leftIndex = deque.peekLast();
                if (leftIndex == null) {
                    //说明空了
                    break;
                }
                //计算容量
                int heightValue = Math.min(rightValue, height[leftIndex]) - height[cueNode];
                int widthValue = rightIndex - leftIndex - 1;
                res += heightValue * widthValue;
            }
            deque.offer(rightIndex);
        }
        return res;
    }

    public int trap3(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int res = 0;
        while (left <= right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if (leftMax <= rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
