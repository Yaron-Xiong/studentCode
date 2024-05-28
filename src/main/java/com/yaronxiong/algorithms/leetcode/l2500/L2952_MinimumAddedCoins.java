package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;

/**
 * 2952. 需要添加的硬币的最小数量
 * 第 374 场周赛
 * Q2
 * 1784
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 coins，表示可用的硬币的面值，以及一个整数 target 。
 * <p>
 * 如果存在某个 coins 的子序列总和为 x，那么整数 x 就是一个 可取得的金额 。
 * <p>
 * 返回需要添加到数组中的 任意面值 硬币的 最小数量 ，使范围 [1, target] 内的每个整数都属于 可取得的金额 。
 * <p>
 * 数组的 子序列 是通过删除原始数组的一些（可能不删除）元素而形成的新的 非空 数组，删除过程不会改变剩余元素的相对位置。
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1,4,10], target = 19
 * 输出：2
 * 解释：需要添加面值为 2 和 8 的硬币各一枚，得到硬币数组 [1,2,4,8,10] 。
 * 可以证明从 1 到 19 的所有整数都可由数组中的硬币组合得到，且需要添加到数组中的硬币数目最小为 2 。
 * 示例 2：
 * <p>
 * 输入：coins = [1,4,10,5,7,19], target = 19
 * 输出：1
 * 解释：只需要添加一枚面值为 2 的硬币，得到硬币数组 [1,2,4,5,7,10,19] 。
 * 可以证明从 1 到 19 的所有整数都可由数组中的硬币组合得到，且需要添加到数组中的硬币数目最小为 1 。
 * 示例 3：
 * <p>
 * 输入：coins = [1,1,1], target = 20
 * 输出：3
 * 解释：
 * 需要添加面值为 4 、8 和 16 的硬币各一枚，得到硬币数组 [1,1,1,4,8,16] 。
 * 可以证明从 1 到 20 的所有整数都可由数组中的硬币组合得到，且需要添加到数组中的硬币数目最小为 3 。
 * <p>
 * 提示：
 * <p>
 * 1 <= target <= 105
 * 1 <= coins.length <= 105
 * 1 <= coins[i] <= target
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-number-of-coins-to-be-added/description/?envType=daily-question&envId=2024-03-30">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2952_MinimumAddedCoins {
    public static void main(String[] args) {
        L2952_MinimumAddedCoins l2952MinimumAddedCoins = new L2952_MinimumAddedCoins();
        System.out.println(l2952MinimumAddedCoins.minimumAddedCoins(new int[]{1, 4, 10}, 19));
    }

    public int minimumAddedCoins(int[] coins, int target) {
        //假设我们最开始能够得到的硬币范围为 [0,0]
        //如果我们给区间加上一个硬币后 区间变化会发生什么？我们会得到两个 可以得到的硬币范围(其中x>0)
        //硬币范围1：[0,0]  ==> 为了后面解释方便，描述为 A区间范围 [a,b]
        //硬币范围2：[0+x,0+x] ==> 为了后面解释方便，描述为 B区间范围 [c,d]

        //已知题目是要求我们构建[0,target],那我们就需要保证这两个范围是连续的
        //那么连续的条件为：硬币范围1的右边界+1 == 硬币范围2的左边界。也就是 b+1 == c

        //如果两个区间不连续的话，就新增一个硬币，这个硬币取值为 硬币范围1的右边界值+1 也就是 b+1
        //这时候 又重复上面的过程
        //已知硬币范围[a,b] 新增一个硬币值b+1，那么新的区间为 [a+b+1,2b+1]
        //由于 [a,b] 与[a+b+1,2b+1] 是相连接的，所有会合并成一个区间为[a,2b+1]
        Arrays.sort(coins);
        int ans = 0;
        int coinsIndex = 0;
        //假设我们已经构建出了 [0,s] 区间的所有数字
        int s = 0;
        while (s < target) {
            //尝试使用coins扩张 s
            if (coinsIndex < coins.length && coins[coinsIndex] <= s + 1) {
                s += coins[coinsIndex];
                coinsIndex++;
            } else {
                s += s + 1;
                ans++;
            }
        }
        return ans;
    }
}
