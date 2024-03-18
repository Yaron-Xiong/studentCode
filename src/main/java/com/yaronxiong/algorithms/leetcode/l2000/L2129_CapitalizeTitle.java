package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2129. 将标题首字母大写
 * 第 69 场双周赛
 * Q1
 * 1275
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 title ，它由单个空格连接一个或多个单词组成，每个单词都只包含英文字母。请你按以下规则将每个单词的首字母 大写 ：
 * <p>
 * 如果单词的长度为 1 或者 2 ，所有字母变成小写。
 * 否则，将单词首字母大写，剩余字母变成小写。
 * 请你返回 大写后 的 title 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：title = "capiTalIze tHe titLe"
 * 输出："Capitalize The Title"
 * 解释：
 * 由于所有单词的长度都至少为 3 ，将每个单词首字母大写，剩余字母变为小写。
 * 示例 2：
 * <p>
 * 输入：title = "First leTTeR of EACH Word"
 * 输出："First Letter of Each Word"
 * 解释：
 * 单词 "of" 长度为 2 ，所以它保持完全小写。
 * 其他单词长度都至少为 3 ，所以其他单词首字母大写，剩余字母小写。
 * 示例 3：
 * <p>
 * 输入：title = "i lOve leetcode"
 * 输出："i Love Leetcode"
 * 解释：
 * 单词 "i" 长度为 1 ，所以它保留小写。
 * 其他单词长度都至少为 3 ，所以其他单词首字母大写，剩余字母小写。
 * <p>
 * 提示：
 * <p>
 * 1 <= title.length <= 100
 * title 由单个空格隔开的单词组成，且不含有任何前导或后缀空格。
 * 每个单词由大写和小写英文字母组成，且都是 非空 的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/capitalize-the-title/description/?envType=daily-question&envId=2024-03-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2129_CapitalizeTitle {
    public static void main(String[] args) {
        L2129_CapitalizeTitle l2129CapitalizeTitle = new L2129_CapitalizeTitle();
        System.out.println(l2129CapitalizeTitle.capitalizeTitle("capiTalIze of titLe"));
    }

    public String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = title.toCharArray();
        int index = 0;
        while (index < charArray.length) {
            StringBuilder temp = new StringBuilder();
            int jIndex = index;
            boolean containsBlack = false;
            while (jIndex < charArray.length) {
                temp.append(Character.toLowerCase(charArray[jIndex]));
                if (charArray[jIndex++] == ' ') {
                    containsBlack = true;
                    break;
                }
            }
            if (containsBlack ? jIndex - index + 1 > 4 :jIndex - index + 1 > 3) {
                char upCase = Character.toUpperCase(charArray[index]);
                temp.replace(0, 1, String.valueOf(upCase));
            }
            index = jIndex;
            sb.append(temp);
        }
        return sb.toString();
    }


}
