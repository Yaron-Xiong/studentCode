package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3024. 三角形类型
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始长度为 3 的整数数组 nums ，需要用它们来构造三角形。
 * <p>
 * 如果一个三角形的所有边长度相等，那么这个三角形称为 equilateral 。
 * 如果一个三角形恰好有两条边长度相等，那么这个三角形称为 isosceles 。
 * 如果一个三角形三条边的长度互不相同，那么这个三角形称为 scalene 。
 * 如果这个数组无法构成一个三角形，请你返回字符串 "none" ，否则返回一个字符串表示这个三角形的类型。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,3,3]
 * 输出："equilateral"
 * 解释：由于三条边长度相等，所以可以构成一个等边三角形，返回 "equilateral" 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,5]
 * 输出："scalene"
 * 解释：
 * nums[0] + nums[1] = 3 + 4 = 7 ，大于 nums[2] = 5 。
 * nums[0] + nums[2] = 3 + 5 = 8 ，大于 nums[1] = 4 。
 * nums[1] + nums[2] = 4 + 5 = 9 ，大于 nums[0] = 3 。
 * 由于任意两边之和都大于第三边，所以可以构成一个三角形，因为三条边的长度互不相等，所以返回 "scalene"。
 * 提示：
 * <p>
 * nums.length == 3
 * 1 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/type-of-triangle/?envType=daily-question&envId=2025-05-19">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3024_TriangleType {
    public static void main(String[] args) {
        L3024_TriangleType l3024TriangleType = new L3024_TriangleType();
        System.out.println(l3024TriangleType.triangleType(new int[]{8, 4, 2}));
    }

    public String triangleType(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "none";
        }
        if (a == b && b == c) {
            return "equilateral";
        }
        if (a == b || a == c || b == c) {
            return "isosceles";
        }
        return "scalene";
    }
}
