package com.accompnay.TopicAlgorithms.swordFingerOffer.string;

/**
 * 剑指 Offer 05. 替换空格
 * <p>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/problems/ti-huan-kong-ge-lcof/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S05_ReplaceSpace {
    public static void main(String[] args) {
        String str = "We Are     Happy";
        S05_ReplaceSpace s05ReplaceSpace = new S05_ReplaceSpace();
        String s = s05ReplaceSpace.replaceSpace(str);
        System.out.println(s);
    }

    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }
}
