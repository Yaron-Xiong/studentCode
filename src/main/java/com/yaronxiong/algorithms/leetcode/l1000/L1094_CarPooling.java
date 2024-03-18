package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1094. 拼车
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 * <p>
 * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，
 * 接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 * <p>
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 1 <= trips.length <= 1000
 * trips[i].length == 3
 * 1 <= numPassengersi <= 100
 * 0 <= fromi < toi <= 1000
 * 1 <= capacity <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/longest-arithmetic-subsequence/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1094_CarPooling {
    public static void main(String[] args) {
        L1094_CarPooling l1094CarPooling = new L1094_CarPooling();
        System.out.println(l1094CarPooling.carPooling(new int[][]{{9, 3, 6}, {8, 1, 7}, {6, 6, 8}, {8, 4, 9}, {4, 2, 9}}, 4));
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int[] d = new int[1001];
        for (int[] trip : trips) {
            d[trip[1]] += trip[0];
            d[trip[2]] -= trip[0];
        }
        int num = 0;
        for (int i : d) {
            num += i;
            if (num > capacity) {
                return false;
            }
        }
        return true;
    }
}
