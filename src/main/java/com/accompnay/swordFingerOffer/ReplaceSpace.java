package com.accompnay.swordFingerOffer;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 剑指offer-05：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String str = "We Are     Happy";
        ReplaceSpace replaceSpace = new ReplaceSpace();
        String s = replaceSpace.replaceSpace(str);
        System.out.println(s);
    }

    public String replaceSpace(String s) {
        return s.replace(" ","%20");
    }
}
