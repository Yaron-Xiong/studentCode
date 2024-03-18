package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.Arrays;

/**
 * 2251. 花期内花的数目
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的二维整数数组 flowers ，其中 flowers[i] = [starti, endi]
 * 表示第 i 朵花的 花期 从 starti 到 endi （都 包含）。同时给你一个下标从 0 开始大小为 n 的整数数组 people ，people[i] 是第 i 个人来看花的时间。
 * <p>
 * 请你返回一个大小为 n 的整数数组 answer ，其中 answer[i]是第 i 个人到达时在花期内花的 数目 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]
 * 输出：[1,2,2,2]
 * 解释：上图展示了每朵花的花期时间，和每个人的到达时间。
 * 对每个人，我们返回他们到达时在花期内花的数目。
 * 示例 2：
 * <p>
 * 输入：flowers = [[1,10],[3,3]], people = [3,3,2]
 * 输出：[2,2,1]
 * 解释：上图展示了每朵花的花期时间，和每个人的到达时间。
 * 对每个人，我们返回他们到达时在花期内花的数目。
 * <p>
 * 提示：
 * <p>
 * 1 <= flowers.length <= 5 * 104
 * flowers[i].length == 2
 * 1 <= starti <= endi <= 109
 * 1 <= people.length <= 5 * 104
 * 1 <= people[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/number-of-flowers-in-full-bloom/description/?envType=daily-question&envId=2023-09-28">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2251_FullBloomFlowers {
    public static void main(String[] args) {
        L2251_FullBloomFlowers l2251FullBloomFlowers = new L2251_FullBloomFlowers();
        int[] ints = l2251FullBloomFlowers.fullBloomFlowers(new int[][]{{1, 6}, {3, 7}, {9, 12}, {4, 13}}, new int[]{2, 3, 7, 11});
        System.out.println(Arrays.toString(ints));

    }

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] starts = new int[flowers.length];
        int[] ends = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            int[] flower = flowers[i];
            starts[i] = flower[0];
            ends[i] = flower[1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int[] ans = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            //找到所有比当前时间小的开花时间
            int lowStartFlowerFind = lowFlowerFind(starts, people[i]);
            //找到所有比当前时间小的谢花时间
            int lowEndFlowerFind = lowFlowerFind(ends, people[i] - 1);
            ans[i] = lowStartFlowerFind - lowEndFlowerFind;
        }
        return ans;
    }

    private int lowFlowerFind(int[] arr, int value) {
        //找到最右边的边界
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (value >= arr[mid]) {
                left = mid + 1;
            } else if (value < arr[mid]) {
                right = mid;
            }
        }
        return right;
    }
}
