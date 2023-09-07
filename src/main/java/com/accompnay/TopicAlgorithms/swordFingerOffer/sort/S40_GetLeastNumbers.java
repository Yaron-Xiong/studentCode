package com.accompnay.TopicAlgorithms.swordFingerOffer.sort;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 剑指 Offer 40. 最小的k个数
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i]<= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S40_GetLeastNumbers {

    public static void main(String[] args) {
        S40_GetLeastNumbers numbers = new S40_GetLeastNumbers();
        int[] arr = {0, 0, 0, 2, 0, 5};
        int[] leastNumbers = numbers.getLeastNumbers(arr, 0);
        System.out.println(Arrays.toString(leastNumbers));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length < k) {
            return new int[]{};
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        for (int i : arr) {
            //小于k个元素时，无脑放
            if (cnt < k) {
                map.merge(i, 1, Integer::sum);
                cnt++;
                continue;
            }
            //大于k个元素，比较i 与最大的元素大小关系
            Map.Entry<Integer, Integer> lastEntry = map.lastEntry();
            if (i < lastEntry.getKey()) {
                if (lastEntry.getValue() == 1) {
                    map.remove(lastEntry.getKey());
                } else {
                    map.merge(lastEntry.getKey(), -1, Integer::sum);
                }
                map.merge(i, 1, Integer::sum);
            }
        }
        int[] res = new int[k];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (Integer i = 0; i < entry.getValue(); i++) {
                res[index++] = entry.getKey();
            }
        }
        return res;
    }


}