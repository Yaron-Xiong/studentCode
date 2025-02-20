package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1184. 公交站间的距离
 * 已解答
 * 算术评级: 3
 * 第 153 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1234
 * 相关标签
 * 相关企业
 * 提示
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。
 * 我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 * <p>
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 * <p>
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 * <p>
 * 示例 1：
 * <p>
 * 输入：distance = [1,2,3,4], start = 0, destination = 1
 * 输出：1
 * 解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：distance = [1,2,3,4], start = 0, destination = 2
 * 输出：3
 * 解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：distance = [1,2,3,4], start = 0, destination = 3
 * 输出：4
 * 解释：公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^4
 * distance.length == n
 * 0 <= start, destination < n
 * 0 <= distance[i] <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/distance-between-bus-stops/description/?envType=daily-question&envId=2024-09-16">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1184_DistanceBetweenBusStops {
    public static void main(String[] args) {
        L1184_DistanceBetweenBusStops l1184DistanceBetweenBusStops = new L1184_DistanceBetweenBusStops();
        System.out.println(l1184DistanceBetweenBusStops.distanceBetweenBusStops(new int[]{7, 10, 1, 12, 11, 14, 5, 0}, 7, 2));
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int s1 = 0;
        int s2 = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {
                s1 += distance[i];
            }else {
                s2 += distance[i];
            }
        }
        return Math.min(s2, s1);
    }
}
