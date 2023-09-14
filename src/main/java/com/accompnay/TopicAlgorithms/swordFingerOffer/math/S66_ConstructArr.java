package com.accompnay.TopicAlgorithms.swordFingerOffer.math;

import java.util.Arrays;

/**
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * <p>
 * 提示：
 * <p>
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof/?envType=study-plan-v2&envId=coding-interviews">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S66_ConstructArr {

    public static void main(String[] args) {
        S66_ConstructArr s66ConstructArr = new S66_ConstructArr();
        int[] ints = s66ConstructArr.constructArr(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(ints));
    }

    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return a;
        }
        //状态递推
        int[] ans = new int[a.length];
        ans[0] = 1;
        for (int i = 1; i < a.length; i++) {
            ans[i] = ans[i - 1] * a[i - 1];
        }
        int temp = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            temp *= a[i + 1];
            ans[i] = ans[i] * temp;
        }
        return ans;
    }

}
