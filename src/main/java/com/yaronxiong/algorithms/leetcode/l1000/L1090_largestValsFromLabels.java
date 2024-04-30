package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.*;

/**
 * 1090. 受标签影响的最大值
 * 提示
 * 中等
 * 46
 * 相关企业
 * 我们有一个 n 项的集合。给出两个整数数组 values 和 labels ，第 i 个元素的值和标签分别是 values[i] 和 labels[i]。还会给出两个整数 numWanted 和 useLimit 。
 * <p>
 * 从 n 个元素中选择一个子集 s :
 * <p>
 * 子集 s 的大小 小于或等于 numWanted 。
 * s 中 最多 有相同标签的 useLimit 项。
 * 一个子集的 分数 是该子集的值之和。
 * <p>
 * 返回子集 s 的最大 分数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1
 * 输出：9
 * 解释：选出的子集是第一项，第三项和第五项。
 * 示例 2：
 * <p>
 * 输入：values = [5,4,3,2,1], labels = [1,3,3,3,2], numWanted = 3, useLimit = 2
 * 输出：12
 * 解释：选出的子集是第一项，第二项和第三项。
 * 示例 3：
 * <p>
 * 输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], numWanted = 3, useLimit = 1
 * 输出：16
 * 解释：选出的子集是第一项和第四项。
 * <p>
 * 提示：
 * <p>
 * n == values.length == labels.length
 * 1 <= n <= 2 * 104
 * 0 <= values[i], labels[i] <= 2 * 104
 * 1 <= numWanted, useLimit <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/largest-values-from-labels/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1090_largestValsFromLabels {
    public static void main(String[] args) {
        L1090_largestValsFromLabels l1090LargestValsFromLabels = new L1090_largestValsFromLabels();
        int x = l1090LargestValsFromLabels.largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 1, 2, 2, 3}, 3, 1);
        System.out.println(x);
    }

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        //按标签分组 每个分组都有可能取 [0~numWanted] 总共要取useLimit个
        Integer[] ids = new Integer[labels.length];
        for (int i = 0; i < labels.length; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (a, b) -> -Integer.compare(values[a], values[b]));
        Map<Integer, Integer> choseMap = new HashMap<>();
        int size = 0;
        int res = 0;
        if (size == numWanted) {
            return res;
        }
        for (Integer id : ids) {
            if (choseMap.getOrDefault(labels[id], 0) >= useLimit) {
                continue;
            }
            size++;
            choseMap.compute(labels[id], (k, v) -> v == null ? 1 : v + 1);
            res += values[id];
            if (size == numWanted) {
                break;
            }
        }
        return res;
    }

}
