package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3129. 找出所有稳定的二进制数组 I
 * 算术评级: 8
 * 第 129 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 2200
 * 相关标签
 * 相关企业
 * 提示
 * 给你 3 个正整数 zero ，one 和 limit 。
 * <p>
 * 一个
 * 二进制数组
 * arr 如果满足以下条件，那么我们称它是 稳定的 ：
 * <p>
 * 0 在 arr 中出现次数 恰好 为 zero 。
 * 1 在 arr 中出现次数 恰好 为 one 。
 * arr 中每个长度超过 limit 的
 * 子数组
 * 都 同时 包含 0 和 1 。
 * 请你返回 稳定 二进制数组的 总 数目。
 * <p>
 * 由于答案可能很大，将它对 109 + 7 取余 后返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：zero = 1, one = 1, limit = 2
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 两个稳定的二进制数组为 [1,0] 和 [0,1] ，两个数组都有一个 0 和一个 1 ，且没有子数组长度大于 2 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：zero = 1, one = 2, limit = 1
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 唯一稳定的二进制数组是 [1,0,1] 。
 * <p>
 * 二进制数组 [1,1,0] 和 [0,1,1] 都有长度为 2 且元素全都相同的子数组，所以它们不稳定。
 * <p>
 * 示例 3：
 * <p>
 * 输入：zero = 3, one = 3, limit = 2
 * <p>
 * 输出：14
 * <p>
 * 解释：
 * <p>
 * 所有稳定的二进制数组包括
 * [0,0,1,0,1,1] ，[0,0,1,1,0,1] ，[0,1,0,0,1,1] ，
 * [0,1,0,1,0,1] ，[0,1,0,1,1,0] ，[0,1,1,0,0,1] ，
 * [0,1,1,0,1,0] ，[1,0,0,1,0,1] ，[1,0,0,1,1,0] ，
 * [1,0,1,0,0,1] ，[1,0,1,0,1,0] ，[1,0,1,1,0,0] ，
 * [1,1,0,0,1,0] 和 [1,1,0,1,0,0] 。
 * <p>
 * 提示：
 * <p>
 * 1 <= zero, one, limit <= 200
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-all-possible-stable-binary-arrays-i/description/?envType=daily-question&envId=2024-08-06">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3129_NumberOfStableArrays {
    public int numberOfStableArrays(int zero, int one, int limit) {
        //要填入zero个零
        //要填入one个一
        //每个长度大于limit的子数组都要包含0跟1
        return dfs2(zero, one, 1, limit) + dfs2(zero, one, 0, limit);
    }

    private int dfs2(int zero, int one, int k, int limit) {
        //假设这一位填k(1或者0) 能不能填？
        //说明不能超过limit个连续的1 或者 0
        if (zero == 0) {
            return k == 1 && one <= limit ? 1 : 0;
        }
        if (one == 0) {
            return k == 0 && zero <= limit ? 1 : 0;
        }
        return 0;
    }


}
