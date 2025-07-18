package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2094. 找出 3 位偶数
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 digits ，其中每个元素是一个数字（0 - 9）。数组中可能存在重复元素。
 * <p>
 * 你需要找出 所有 满足下述条件且 互不相同 的整数：
 * <p>
 * 该整数由 digits 中的三个元素按 任意 顺序 依次连接 组成。
 * 该整数不含 前导零
 * 该整数是一个 偶数
 * 例如，给定的 digits 是 [1, 2, 3] ，整数 132 和 312 满足上面列出的全部条件。
 * <p>
 * 将找出的所有互不相同的整数按 递增顺序 排列，并以数组形式返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [2,1,3,0]
 * 输出：[102,120,130,132,210,230,302,310,312,320]
 * 解释：
 * 所有满足题目条件的整数都在输出数组中列出。
 * 注意，答案数组中不含有 奇数 或带 前导零 的整数。
 * 示例 2：
 * <p>
 * 输入：digits = [2,2,8,8,2]
 * 输出：[222,228,282,288,822,828,882]
 * 解释：
 * 同样的数字（0 - 9）在构造整数时可以重复多次，重复次数最多与其在 digits 中出现的次数一样。
 * 在这个例子中，数字 8 在构造 288、828 和 882 时都重复了两次。
 * 示例 3：
 * <p>
 * 输入：digits = [3,7,5]
 * 输出：[]
 * 解释：
 * 使用给定的 digits 无法构造偶数。
 * <p>
 * 提示：
 * <p>
 * 3 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/finding-3-digit-even-numbers/description/?envType=daily-question&envId=2025-05-12">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2094_FindEvenNumbers {
    public static void main(String[] args) {
        L2094_FindEvenNumbers l2094FindEvenNumbers = new L2094_FindEvenNumbers();
        System.out.println(Arrays.toString(l2094FindEvenNumbers.findEvenNumbers(new int[]{2, 2, 8, 8, 2})));
    }

    public int[] findEvenNumbers(int[] digits) {
        int[] arr = new int[10];
        for (int digit : digits) {
            arr[digit]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            if (arr[i] <= 0) {
                continue;
            }
            --arr[i];
            for (int j = 0; j < 10; j++) {
                if (arr[j] <= 0) {
                    continue;
                }
                --arr[j];
                for (int z = 0; z < 10; z++) {
                    if (arr[z] <= 0) {
                        continue;
                    }
                    int v = i * 100 + j * 10 + z;
                    if (v % 2 == 0) {
                        list.add(v);
                    }
                }
                ++arr[j];
            }
            ++arr[i];
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
