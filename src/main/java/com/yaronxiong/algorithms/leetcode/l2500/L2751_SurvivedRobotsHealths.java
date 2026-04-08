package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.*;

/**
 * 2751. 机器人碰撞
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 现有 n 个机器人，编号从 1 开始，每个机器人包含在路线上的位置、健康度和移动方向。
 * <p>
 * 给你下标从 0 开始的两个整数数组 positions、healths 和一个字符串 directions（directions[i] 为 'L' 表示 向左 或 'R' 表示 向右）。
 * positions 中的所有整数 互不相同 。
 * <p>
 * 所有机器人以 相同速度 同时 沿给定方向在路线上移动。如果两个机器人移动到相同位置，则会发生 碰撞 。
 * <p>
 * 如果两个机器人发生碰撞，则将 健康度较低 的机器人从路线中 移除 ，并且另一个机器人的健康度 减少 1 。
 * 幸存下来的机器人将会继续沿着与之前 相同 的方向前进。如果两个机器人的健康度相同，则将二者都从路线中移除。
 * <p>
 * 请你确定全部碰撞后幸存下的所有机器人的 健康度 ，并按照原来机器人编号的顺序排列。
 * 即机器人 1 （如果幸存）的最终健康度，机器人 2 （如果幸存）的最终健康度等。 如果不存在幸存的机器人，则返回空数组。
 * <p>
 * 在不再发生任何碰撞后，请你以数组形式，返回所有剩余机器人的健康度（按机器人输入中的编号顺序）。
 * <p>
 * 注意：位置  positions 可能是乱序的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：positions = [5,4,3,2,1], healths = [2,17,9,15,10], directions = "RRRRR"
 * 输出：[2,17,9,15,10]
 * 解释：在本例中不存在碰撞，因为所有机器人向同一方向移动。所以，从第一个机器人开始依序返回健康度，[2, 17, 9, 15, 10] 。
 * 示例 2：
 * <p>
 * 输入：positions = [3,5,2,6], healths = [10,10,15,12], directions = "RLRL"
 * 输出：[14]
 * 解释：本例中发生 2 次碰撞。首先，机器人 1 和机器人 2 将会碰撞，因为二者健康度相同，二者都将被从路线中移除。接下来，机器人 3 和机器人 4 将会发生碰撞，由于机器人 4 的健康度更小，则它会被移除，而机器人 3 的健康度变为 15 - 1 = 14 。仅剩机器人 3 ，所以返回 [14] 。
 * 示例 3：
 * <p>
 * 输入：positions = [1,2,5,6], healths = [10,10,11,11], directions = "RLRL"
 * 输出：[]
 * 解释：机器人 1 和机器人 2 将会碰撞，因为二者健康度相同，二者都将被从路线中移除。机器人 3 和机器人 4 将会碰撞，因为二者健康度相同，二者都将被从路线中移除。所以返回空数组 [] 。
 * <p>
 * 提示：
 * <p>
 * 1 <= positions.length == healths.length == directions.length == n <= 105
 * 1 <= positions[i], healths[i] <= 109
 * directions[i] == 'L' 或 directions[i] == 'R'
 * positions 中的所有值互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/robot-collisions/description/?envType=daily-question&envId=2026-04-01">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2751_SurvivedRobotsHealths {

    public static void main(String[] args) {
        L2751_SurvivedRobotsHealths l2751SurvivedRobotsHealths = new L2751_SurvivedRobotsHealths();
        System.out.println(l2751SurvivedRobotsHealths.survivedRobotsHealths(new int[]{3, 5, 2, 6}, new int[]{10, 10, 15, 12}, "RLRL"));
        System.out.println(l2751SurvivedRobotsHealths.survivedRobotsHealths(new int[]{1, 2, 5, 6}, new int[]{10, 10, 11, 11}, "RLRL"));
        System.out.println(l2751SurvivedRobotsHealths.survivedRobotsHealths(new int[]{5, 4, 3, 2, 1}, new int[]{2, 17, 9, 15, 10}, "RRRRR"));
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Integer[] indexArr = new Integer[positions.length];
        for (int i = 0; i < positions.length; i++) {
            indexArr[i] = i;
        }
        Arrays.sort(indexArr, (a, b) -> positions[a] - positions[b]);
        Deque<Integer> right = new ArrayDeque<>();
        for (Integer index : indexArr) {
            if (directions.charAt(index) == 'R') {
                right.addFirst(index);
            } else {
                //看看能消耗多少个
                while (!right.isEmpty()) {
                    if (healths[right.peekFirst()] > healths[index]) {
                        healths[right.peekFirst()]--;
                        healths[index] = 0;
                        break;
                    } else if (healths[right.peekFirst()] < healths[index]) {
                        healths[right.pollFirst()] = 0;
                        healths[index]--;
                    }else {
                        healths[right.pollFirst()] = 0;
                        healths[index] = 0;
                        break;
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int health : healths) {
            if (health > 0) {
                ans.add(health);
            }
        }
        return ans;
    }
}
