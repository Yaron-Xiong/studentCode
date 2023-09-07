package com.accompnay.TopicAlgorithms.swordFingerOffer.string;


import java.util.*;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * 限制：
 * <p>
 * 1 <= s 的长度 <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S38_Permutation {
    public static void main(String[] args) {
        S38_Permutation s38Permutation = new S38_Permutation();
        System.out.println(Arrays.toString(s38Permutation.permutation("abc")));
    }

    public String[] permutation(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        HashSet<String> res = new HashSet<>();
        dfs(charArray, res, new char[charArray.length]);
        return res.toArray(new String[0]);
    }

    int index = -1;

    private void dfs(char[] charArray, Set<String> res, char[] path) {
        if (index + 1 == charArray.length) {
            res.add(new String(path));
            return;
        }
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '#') {
                continue;
            }
            //说明重复计算了
            if (i > 0 && charArray[i] == charArray[i - 1]) {
                continue;
            }
            path[++index] = charArray[i];
            charArray[i] = '#';
            dfs(charArray, res, path);
            charArray[i] = path[index--];
        }
    }

}
