package com.accompnay.TopicAlgorithms.leetcode.l1000;

/**
 * 605. 种花问题
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。
 * 另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/can-place-flowers/description/?envType=daily-question&envId=2023-09-29">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L605_CanPlaceFlowers {
    public static void main(String[] args) {
        L605_CanPlaceFlowers l605CanPlaceFlowers = new L605_CanPlaceFlowers();
        System.out.println(l605CanPlaceFlowers.canPlaceFlowers(new int[]{1, 0, 1, 0, 1, 0, 1}, 1));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int index = 0;
        while (index < flowerbed.length) {
            if (flowerbed[index] == 1) {
                index += 2;
            } else if (index == flowerbed.length - 1 || flowerbed[index + 1] == 0) {
                n--;
                index += 2;
            }else {
                index += 3;
            }
        }
        return n <= 0;

    }
}
