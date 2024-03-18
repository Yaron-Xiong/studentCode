package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.ArrayList;
import java.util.List;

/**
 * 1130. 叶值的最小代价生成树
 * 提示
 * 中等
 * 291
 * 相关企业
 * 给你一个正整数数组 arr，考虑所有满足以下条件的二叉树：
 * <p>
 * 每个节点都有 0 个或是 2 个子节点。
 * 数组 arr 中的值与树的中序遍历中每个叶节点的值一一对应。
 * 每个非叶节点的值等于其左子树和右子树中叶节点的最大值的乘积。
 * 在所有这样的二叉树中，返回每个非叶节点的值的最小可能总和。这个和的值是一个 32 位整数。
 * <p>
 * 如果一个节点有 0 个子节点，那么该节点为叶节点。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：arr = [6,2,4]
 * 输出：32
 * 解释：有两种可能的树，第一种的非叶节点的总和为 36 ，第二种非叶节点的总和为 32 。
 * 示例 2：
 * <p>
 * 输入：arr = [4,11]
 * 输出：44
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 40
 * 1 <= arr[i] <= 15
 * 答案保证是一个 32 位带符号整数，即小于 231 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-cost-tree-from-leaf-values/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1130_MctFromLeafValues {
    public static void main(String[] args) {
        L1130_MctFromLeafValues l1130MctFromLeafValues = new L1130_MctFromLeafValues();
        System.out.println(l1130MctFromLeafValues.mctFromLeafValues(new int[]{6, 2, 4,10}));
    }

    public int mctFromLeafValues(int[] arr) {
        List<Integer> cnt = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            cnt.add(arr[i]);
        }
        int res = 0;
        while (cnt.size() > 1) {
            //每次将最小的值进行合并
            int size = cnt.size();
            int minIndex = 0;
            for (int i = 0; i < size; i++) {
                if (cnt.get(i) < cnt.get(minIndex)) {
                    minIndex = i;
                }
            }
            if (minIndex == 0) {
                //跟右边合并
                res += cnt.get(minIndex) * cnt.get(minIndex + 1);
            } else if (minIndex == cnt.size() - 1) {
                //跟左边合并
                res += cnt.get(minIndex) * cnt.get(minIndex - 1);
            } else {
                //跟左边或者右边合并
                res += cnt.get(minIndex) * Math.min(cnt.get(minIndex + 1), cnt.get(minIndex - 1));
            }
            cnt.remove(minIndex);
        }
        return res;
    }
}
