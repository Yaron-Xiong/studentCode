package com.accompnay.TopicAlgorithms.leetcode.l2000;

import java.util.Arrays;

/**
 * 2451. 差值数组不同的字符串
 * 提示
 * 简单
 * 26
 * 相关企业
 * 给你一个字符串数组 words ，每一个字符串长度都相同，令所有字符串的长度都为 n 。
 * <p>
 * 每个字符串 words[i] 可以被转化为一个长度为 n - 1 的 差值整数数组 difference[i] ，
 * 其中对于 0 <= j <= n - 2 有 difference[i][j] = words[i][j+1] - words[i][j] 。注意两个字母的差值定义为它们在字母表中 位置 之差，也就是说 'a' 的位置是 0 ，'b' 的位置是 1 ，'z' 的位置是 25 。
 * <p>
 * 比方说，字符串 "acb" 的差值整数数组是 [2 - 0, 1 - 2] = [2, -1] 。
 * words 中所有字符串 除了一个字符串以外 ，其他字符串的差值整数数组都相同。你需要找到那个不同的字符串。
 * <p>
 * 请你返回 words中 差值整数数组 不同的字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["adc","wzy","abc"]
 * 输出："abc"
 * 解释：
 * - "adc" 的差值整数数组是 [3 - 0, 2 - 3] = [3, -1] 。
 * - "wzy" 的差值整数数组是 [25 - 22, 24 - 25]= [3, -1] 。
 * - "abc" 的差值整数数组是 [1 - 0, 2 - 1] = [1, 1] 。
 * 不同的数组是 [1, 1]，所以返回对应的字符串，"abc"。
 * 示例 2：
 * <p>
 * 输入：words = ["aaa","bob","ccc","ddd"]
 * 输出："bob"
 * 解释：除了 "bob" 的差值整数数组是 [13, -13] 以外，其他字符串的差值整数数组都是 [0, 0] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= words.length <= 100
 * n == words[i].length
 * 2 <= n <= 20
 * words[i] 只含有小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/odd-string-difference/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2451_OddString {
    public static void main(String[] args) {
        L2451_OddString l2451OddString = new L2451_OddString();
        System.out.println(l2451OddString.oddString(new String[]{"aaa", "bob", "ccc", "ddd"}));
    }

    public String oddString(String[] words) {
        int[] arr0 = getArr(words[0]);
        int[] arr1 = getArr(words[1]);
        if (Arrays.equals(arr0, arr1)) {
            //遍历 n>=2 的元素只要不等于 arr1则退出
            for (int i = 2; i < words.length; i++) {
                int[] arr = getArr(words[i]);
                if (!Arrays.equals(arr, arr0)) {
                    return words[i];
                }
            }
        }
        //看第三个元素,如果是arr1 则返回arr2 ,如果是arr2则返回arr1
        int[] arr2 = getArr(words[2]);
        return Arrays.equals(arr0, arr2) ? words[1] : words[0];
    }

    public int[] getArr(String str) {
        int[] ints = new int[str.length() - 1];
        for (int i = 1; i < str.length(); i++) {
            ints[i - 1] = str.charAt(i) - str.charAt(i - 1);
        }
        return ints;
    }
}
