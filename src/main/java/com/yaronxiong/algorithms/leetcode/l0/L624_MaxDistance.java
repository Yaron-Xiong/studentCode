package com.yaronxiong.algorithms.leetcode.l0;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 624. 数组列表中的最大距离
 * 算术评级: 3
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * 相关企业
 * 给定 m 个数组，每个数组都已经按照升序排好序了。
 * <p>
 * 现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。两个整数 a 和 b 之间的距离定义为它们差的绝对值 |a-b| 。
 * <p>
 * 返回最大距离。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[1,2,3],[4,5],[1,2,3]]
 * 输出：4
 * 解释：
 * 一种得到答案 4 的方法是从第一个数组或者第三个数组中选择 1，同时从第二个数组中选择 5 。
 * 示例 2：
 * <p>
 * 输入：arrays = [[1],[1]]
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * m == arrays.length
 * 2 <= m <= 105
 * 1 <= arrays[i].length <= 500
 * -104 <= arrays[i][j] <= 104
 * arrays[i] 以 升序 排序。
 * 所有数组中最多有 105 个整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-distance-in-arrays/description/?envType=daily-question&envId=2025-02-19">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L624_MaxDistance {
    public static void main(String[] args) {
        L624_MaxDistance l = new L624_MaxDistance();
        ArrayList<Integer> a = Lists.newArrayList(-1, 1);
        ArrayList<Integer> b = Lists.newArrayList(-3, 1, 4);
        ArrayList<Integer> c = Lists.newArrayList(-2, -1, 0, 2);
        int i = l.maxDistance(Lists.newArrayList(a, b, c));
        System.out.println(i);
    }

    public int maxDistance(List<List<Integer>> arrays) {
        //线性遍历
        int ans = 0;
        int preMin = arrays.get(0).get(0);
        int preMax = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
            //当前最大值 与当前最小值 跟前面碰一下
            Integer curMin = arrays.get(i).get(0);
            Integer curMax = arrays.get(i).get(arrays.get(i).size() - 1);
            ans = Math.max(ans, Math.abs(preMin - curMax));
            ans = Math.max(ans, Math.abs(preMax - curMin));
            preMin = Math.min(preMin, curMin);
            preMax = Math.max(preMax, curMax);
        }
        return ans;
    }
}
