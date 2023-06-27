package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.*;

/**
 * 1054. 距离相等的条形码
 * 提示
 * 中等
 * 171
 * 相关企业
 * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
 * <p>
 * 请你重新排列这些条形码，使其中任意两个相邻的条形码不能相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：barcodes = [1,1,1,2,2,2]
 * 输出：[2,1,2,1,2,1]
 * 示例 2：
 * <p>
 * 输入：barcodes = [1,1,1,1,2,2,3,3]
 * 输出：[1,3,1,3,2,1,2,1]
 * <p>
 * 提示：
 * <p>
 * 1 <= barcodes.length <= 10000
 * 1 <= barcodes[i] <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/distant-barcodes/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1054_RearrangeBarcodes {

    public static void main(String[] args) {
        L1054_RearrangeBarcodes l1054RearrangeBarcodes = new L1054_RearrangeBarcodes();
        int[] x = l1054RearrangeBarcodes.rearrangeBarcodes(new int[]{2, 1, 1});
        System.out.println(Arrays.toString(x));
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> list = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for (int barcode : barcodes) {
            map.compute(barcode, (k, v) -> v == null ? 1 : v + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] res = new int[barcodes.length];
        int index = 0;
        while (!list.isEmpty()) {
            if (list.size() == 1) {
                int[] curNode = list.poll();
                res[index++] = curNode[0];
                continue;
            }
            int[] curNode = list.poll();
            int[] nextNode = list.poll();
            res[index++] = curNode[0];
            res[index++] = nextNode[0];
            if (--curNode[1] != 0) {
                list.add(curNode);
            }
            if (--nextNode[1] != 0) {
                list.add(nextNode);
            }
        }
        return res;
    }
}
