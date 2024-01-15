package com.accompnay.TopicAlgorithms.leetcode.l0;

/**
 * 849. 到最近的人的最大距离
 * 中等
 * 223
 * 相关企业
 * 给你一个数组 seats 表示一排座位，其中 seats[i] = 1 代表有人坐在第 i 个座位上，seats[i] = 0 代表座位 i 上是空的（下标从 0 开始）。
 * <p>
 * 至少有一个空座位，且至少有一人已经坐在座位上。
 * <p>
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 * <p>
 * 返回他到离他最近的人的最大距离。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：seats = [1,0,0,0,1,0,1]
 * 输出：2
 * 解释：
 * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
 * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
 * 因此，他到离他最近的人的最大距离是 2 。
 * 示例 2：
 * <p>
 * 输入：seats = [1,0,0,0]
 * 输出：3
 * 解释：
 * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
 * 这是可能的最大距离，所以答案是 3 。
 * 示例 3：
 * <p>
 * 输入：seats = [0,1]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 2 <= seats.length <= 2 * 104
 * seats[i] 为 0 或 1
 * 至少有一个 空座位
 * 至少有一个 座位上有人
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximize-distance-to-closest-person/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L849_MaxDistToClosest {
    public static void main(String[] args) {
        L849_MaxDistToClosest l849MaxDistToClosest = new L849_MaxDistToClosest();
        System.out.println(l849MaxDistToClosest.maxDistToClosest(new int[]{1, 0, 0, 0}));
    }

    public int maxDistToClosest(int[] seats) {
        //先确定左边
        int l = 0;
        while (l < seats.length && seats[l] != 1) {
            l++;
        }
        int res = 0;
        //解决开头全是0的情况
        res = Math.max(res, l);
        int r = l + 1;
        while (r < seats.length) {
            if (seats[r] == 1) {
                //此次最优解为l+r 的 中间位置
                int a = (r - l) >> 1;
                res = Math.max(a, res);
                l = r;
            }
            r++;
        }

        //解决结尾全是0的情况
        if (seats[seats.length - 1] == 0) {
            res = Math.max(res, seats.length - 1 - l);
        }
        return res;
    }
}
