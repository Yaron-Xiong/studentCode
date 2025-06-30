package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3403. 从盒子中找出字典序最大的字符串 I
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 word 和一个整数 numFriends。
 * <p>
 * Alice 正在为她的 numFriends 位朋友组织一个游戏。游戏分为多个回合，在每一回合中：
 * <p>
 * word 被分割成 numFriends 个 非空 字符串，且该分割方式与之前的任意回合所采用的都 不完全相同 。
 * 所有分割出的字符串都会被放入一个盒子中。
 * 在所有回合结束后，找出盒子中 字典序最大的 字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入: word = "dbca", numFriends = 2
 * <p>
 * 输出: "dbc"
 * <p>
 * 解释:
 * <p>
 * 所有可能的分割方式为：
 * <p>
 * "d" 和 "bca"。
 * "db" 和 "ca"。
 * "dbc" 和 "a"。
 * 示例 2：
 * <p>
 * 输入: word = "gggg", numFriends = 4
 * <p>
 * 输出: "g"
 * <p>
 * 解释:
 * <p>
 * 唯一可能的分割方式为："g", "g", "g", 和 "g"。
 * <p>
 * 提示:
 * <p>
 * 1 <= word.length <= 5 * 103
 * word 仅由小写英文字母组成。
 * 1 <= numFriends <= word.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-lexicographically-largest-string-from-the-box-i/description/?envType=daily-question&envId=2025-06-04">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3404_AnswerString {
    public static void main(String[] args) {
        L3404_AnswerString l3404AnswerString = new L3404_AnswerString();
        System.out.println(l3404AnswerString.answerString("aann", 1));
    }

    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        String ansStr = "";
        String tempStr = "";
        for (int i = 0; i < word.length(); i++) {

        }
        int maxGroupLen = word.length() - numFriends + 1;
        int maxCharIndex = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) > word.charAt(maxCharIndex)) {
                maxCharIndex = i;
            }
        }
        int maxIndex = Math.min(maxCharIndex + maxGroupLen, word.length());
        return word.substring(maxCharIndex, maxIndex);
    }
}
