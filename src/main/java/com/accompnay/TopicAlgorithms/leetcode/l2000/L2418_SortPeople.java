package com.accompnay.TopicAlgorithms.leetcode.l2000;

import java.util.Arrays;

/**
 * 2418. 按身高排序
 * 提示
 * 简单
 * 37
 * 相关企业
 * 给你一个字符串数组 names ，和一个由 互不相同 的正整数组成的数组 heights 。两个数组的长度均为 n 。
 * <p>
 * 对于每个下标 i，names[i] 和 heights[i] 表示第 i 个人的名字和身高。
 * <p>
 * 请按身高 降序 顺序返回对应的名字数组 names 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：names = ["Mary","John","Emma"], heights = [180,165,170]
 * 输出：["Mary","Emma","John"]
 * 解释：Mary 最高，接着是 Emma 和 John 。
 * 示例 2：
 * <p>
 * 输入：names = ["Alice","Bob","Bob"], heights = [155,185,150]
 * 输出：["Bob","Alice","Bob"]
 * 解释：第一个 Bob 最高，然后是 Alice 和第二个 Bob 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == names.length == heights.length
 * 1 <= n <= 103
 * 1 <= names[i].length <= 20
 * 1 <= heights[i] <= 105
 * names[i] 由大小写英文字母组成
 * heights 中的所有值互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/sort-the-people/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2418_SortPeople {
    public static void main(String[] args) {
        L2418_SortPeople l2418SortPeople = new L2418_SortPeople();
        String[] x = l2418SortPeople.sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170});
        System.out.println(Arrays.toString(x));
    }

    public String[] sortPeople(String[] names, int[] heights) {
        Integer[] sortArr = new Integer[names.length];
        for (int i = 0; i < sortArr.length; i++) {
            sortArr[i] = i;
        }
        Arrays.sort(sortArr, (a, b) -> Integer.compare(heights[b], heights[a]));
        String[] res = new String[names.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = names[sortArr[i]];
        }
        return res;
    }
}
