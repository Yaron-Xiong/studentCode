package com.accompnay.TopicAlgorithms.leetcode;

import java.util.*;

/**
 * 1187. 使数组严格递增
 * 提示
 * 困难
 * 120
 * 相关企业
 * 给你两个整数数组 arr1 和 arr2，返回使 arr1 严格递增所需要的最小「操作」数（可能为 0）。
 * <p>
 * 每一步「操作」中，你可以分别从 arr1 和 arr2 中各选出一个索引，分别为 i 和 j，0 <= i < arr1.length 和 0 <= j < arr2.length，然后进行赋值运算 arr1[i] = arr2[j]。
 * <p>
 * 如果无法让 arr1 严格递增，请返回 -1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr1 = [1,5,3,6,7], arr2 = [1,3,2,4]
 * 输出：1
 * 解释：用 2 来替换 5，之后 arr1 = [1, 2, 3, 6, 7]。
 * 示例 2：
 * <p>
 * 输入：arr1 = [1,5,3,6,7], arr2 = [4,3,1]
 * 输出：2
 * 解释：用 3 来替换 5，然后用 4 来替换 3，得到 arr1 = [1, 3, 4, 6, 7]。
 * 示例 3：
 * <p>
 * 输入：arr1 = [1,5,3,6,7], arr2 = [1,6,3,3]
 * 输出：-1
 * 解释：无法使 arr1 严格递增。
 * <p>
 * 提示：
 * <p>
 * 1 <= arr1.length, arr2.length <= 2000
 * 0 <= arr1[i], arr2[i] <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/make-array-strictly-increasing/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1187_MakeArrayIncreasing {
    public static void main(String[] args) {
        L1187_MakeArrayIncreasing l1187MakeArrayIncreasing = new L1187_MakeArrayIncreasing();
        int x = l1187MakeArrayIncreasing.makeArrayIncreasing(new int[]{5, 16, 19, 2, 1, 12, 7, 14, 5, 16}, new int[]{6, 17, 4, 3, 6, 13, 4, 3, 18, 17, 16, 7, 14, 1, 16});
        System.out.println(x);
    }

    int[] arr1;
    int[] arr2;
    Map<Integer, Integer>[] memo;

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.memo = new HashMap[arr1.length];
        Arrays.sort(this.arr2);
        //arr1的每个位置都可以与arr2进行交换
        //arr1[0~i] 都应该为递增
        int dfs = dfs(0);
        return dfs == Integer.MAX_VALUE ? -1 : dfs;
    }

    private int dfs(int index) {
        if (index >= arr1.length) {
            return 0;
        }
        if (index > 0 && memo[index] != null && memo[index].containsKey(arr1[index - 1])) {
            return memo[index].get(arr1[index - 1]);
        }
        int minValue = Integer.MAX_VALUE;
        //选择替换 替换规则 要比 index-1大
        //贪心：如果要替换，那么肯定是替换第一个大于arr1[index] 值的value
        //二分：找到一个大于 arr1[index] 的value然后进行替换
        Integer value = findValue(index > 0 ? arr1[index - 1] : 0);
        if (value != null) {
            int temp = arr1[index];
            arr1[index] = value;
            int dfs = dfs(index + 1);
            if (dfs != Integer.MAX_VALUE) {
                minValue = Math.min(minValue, dfs + 1);
            }
            arr1[index] = temp;
        }
        //不选择替换 条件 index = 0 或者 index>index-1
        if (index == 0 || arr1[index] > arr1[index - 1]) {
            minValue = Math.min(minValue, dfs(index + 1));
        }
        if (index > 0) {
            memo[index] = memo[index] == null ? new HashMap<>() : memo[index];
            memo[index].put(arr1[index - 1], minValue);
        }
        return minValue;
    }

    private Integer findValue(int target) {
        int left = 0;
        int right = arr2.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr2[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right >= arr2.length ? null : arr2[right];
    }
}
