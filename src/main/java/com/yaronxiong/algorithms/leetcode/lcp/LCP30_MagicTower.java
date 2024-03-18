package com.yaronxiong.algorithms.leetcode.lcp;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * LCP 30. 魔塔游戏
 * 中等
 * 相关标签
 * 相关企业
 * 小扣当前位于魔塔游戏第一层，共有 N 个房间，编号为 0 ~ N-1。每个房间的补血道具/怪物对于血量影响记于数组 nums，
 * 其中正数表示道具补血数值，即血量增加对应数值；负数表示怪物造成伤害值，即血量减少对应数值；0 表示房间对血量无影响。
 * <p>
 * 小扣初始血量为 1，且无上限。假定小扣原计划按房间编号升序访问所有房间补血/打怪，为保证血量始终为正值，
 * 小扣需对房间访问顺序进行调整，每次仅能将一个怪物房间（负数的房间）调整至访问顺序末尾。请返回小扣最少需要调整几次，才能顺利访问所有房间。
 * 若调整顺序也无法访问完全部房间，请返回 -1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,100,100,-250,-60,-140,-50,-50,100,150]
 * <p>
 * 输出：1
 * <p>
 * 解释：初始血量为 1。至少需要将 nums[3] 调整至访问顺序末尾以满足要求。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [-200,-300,400,0]
 * <p>
 * 输出：-1
 * <p>
 * 解释：调整访问顺序也无法完成全部房间的访问。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^5 <= nums[i] <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/p0NxJO/description/?envType=daily-question&envId=2024-02-06">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LCP30_MagicTower {
    public static void main(String[] args) {
        LCP30_MagicTower lcp30MagicTower = new LCP30_MagicTower();
        System.out.println(lcp30MagicTower.magicTower(new int[]{100, 100, 100, -250, -60, -140, -50, -50, 100, 150}));
    }

    public int magicTower2(int[] nums) {
        //这里保证了一定有解 减少了一些奇怪的判定
        long sum = Arrays.stream(nums).sum();
        if (sum < 0) {
            return -1;
        }
        //贪心
        long curHp = 1;
        int cnt = 0;
        //当生命值为负数的时候，将当前的遍历过的最大负数与最后一位交换
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(nums[a], nums[b]));
        Deque<Integer> visitQueue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            visitQueue.addLast(i);
        }
        while (!visitQueue.isEmpty()) {
            Integer index = visitQueue.pollFirst();
            queue.add(index);
            curHp += nums[index];
            if (curHp > 0) {
                continue;
            }
            Integer minValueIndex = queue.poll();
            visitQueue.addLast(minValueIndex);
            curHp -= nums[minValueIndex];
            cnt++;
        }
        return cnt;
    }


    public int magicTower(int[] nums) {
        //这里保证了一定有解 减少了一些奇怪的判定
        long sum = Arrays.stream(nums).sum();
        if (sum < 0) {
            return -1;
        }
        int ans = 0;
        long hp = 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        for (int num : nums) {
            if (num < 0) {
                queue.add(num);
            }
            hp += num;
            if (hp < 1) {
                hp -= queue.poll();
                ans++;
            }
        }
        return ans;
    }
}
