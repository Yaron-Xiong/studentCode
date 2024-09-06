package com.yaronxiong.algorithms.leetcode.l2500;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2860. 让所有学生保持开心的分组方法数
 * 算术评级: 4
 * 第 363 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1626
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始、长度为 n 的整数数组 nums ，其中 n 是班级中学生的总数。
 * 班主任希望能够在让所有学生保持开心的情况下选出一组学生：
 * <p>
 * 如果能够满足下述两个条件之一，则认为第 i 位学生将会保持开心：
 * <p>
 * 这位学生被选中，并且被选中的学生人数 严格大于 nums[i] 。
 * 这位学生没有被选中，并且被选中的学生人数 严格小于 nums[i] 。
 * 返回能够满足让所有学生保持开心的分组方法的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1]
 * 输出：2
 * 解释：
 * 有两种可行的方法：
 * 班主任没有选中学生。
 * 班主任选中所有学生形成一组。
 * 如果班主任仅选中一个学生来完成分组，那么两个学生都无法保持开心。因此，仅存在两种可行的方法。
 * 示例 2：
 * <p>
 * 输入：nums = [6,0,3,3,6,7,2,7]
 * 输出：3
 * 解释：
 * 存在三种可行的方法：
 * 班主任选中下标为 1 的学生形成一组。
 * 班主任选中下标为 1、2、3、6 的学生形成一组。
 * 班主任选中所有学生形成一组。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] < nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/happy-students/description/?envType=daily-question&envId=2024-09-04">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2860_CountWays {
    public static void main(String[] args) {
        L2860_CountWays l2860CountWays = new L2860_CountWays();
        ArrayList<Integer> list = Lists.newArrayList(1, 1, 0, 1);
        System.out.println(l2860CountWays.countWays(list));
    }

    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            if ((i != 0 && nums.get(i - 1) >= i)
                    || (i != n && nums.get(i) <= i)) {
                continue;
            }
            ans++;
        }
        return ans;
    }
}
