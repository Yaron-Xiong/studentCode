package com.accompnay.TopicAlgorithms.leetcode.l0;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 * 简单
 * 334
 * 相关企业
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 * <p>
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/summary-ranges/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L228_SummaryRanges {
    public static void main(String[] args) {
        L228_SummaryRanges l228SummaryRanges = new L228_SummaryRanges();
        System.out.println(l228SummaryRanges.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && nums[j] - 1 == nums[j - 1]) {
                j++;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(nums[i]));
            if (i != j - 1) {
                sb.append("->");
                sb.append(nums[j - 1]);
            }
            res.add(sb.toString());
            i = j;
        }
        return res;
    }
}
