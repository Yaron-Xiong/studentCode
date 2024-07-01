package com.yaronxiong.algorithms.leetcode.l2500;

import java.text.DecimalFormat;

/**
 * 2288. 价格减免
 * 算术评级: 4
 * 第 295 场周赛
 * Q2
 * 1577
 * 相关标签
 * 相关企业
 * 提示
 * 句子 是由若干个单词组成的字符串，单词之间用单个空格分隔，其中每个单词可以包含数字、小写字母、和美元符号 '$' 。
 * 如果单词的形式为美元符号后跟着一个非负实数，那么这个单词就表示一个 价格 。
 * <p>
 * 例如 "$100"、"$23" 和 "$6" 表示价格，而 "100"、"$" 和 "$1e5 不是。
 * 给你一个字符串 sentence 表示一个句子和一个整数 discount 。
 * 对于每个表示价格的单词，都在价格的基础上减免 discount% ，并 更新 该单词到句子中。所有更新后的价格应该表示为一个 恰好保留小数点后两位 的数字。
 * <p>
 * 返回表示修改后句子的字符串。
 * <p>
 * 注意：所有价格 最多 为  10 位数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：sentence = "there are $1 $2 and 5$ candies in the shop", discount = 50
 * 输出："there are $0.50 $1.00 and 5$ candies in the shop"
 * 解释：
 * 表示价格的单词是 "$1" 和 "$2" 。
 * - "$1" 减免 50% 为 "$0.50" ，所以 "$1" 替换为 "$0.50" 。
 * - "$2" 减免 50% 为 "$1" ，所以 "$1" 替换为 "$1.00" 。
 * 示例 2：
 * <p>
 * 输入：sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$", discount = 100
 * 输出："1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$"
 * 解释：
 * 任何价格减免 100% 都会得到 0 。
 * 表示价格的单词分别是 "$3"、"$5"、"$6" 和 "$9"。
 * 每个单词都替换为 "$0.00"。
 * <p>
 * 提示：
 * <p>
 * 1 <= sentence.length <= 105
 * sentence 由小写英文字母、数字、' ' 和 '$' 组成
 * sentence 不含前导和尾随空格
 * sentence 的所有单词都用单个空格分隔
 * 所有价格都是 正 整数且不含前导零
 * 所有价格 最多 为  10 位数字
 * 0 <= discount <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/apply-discount-to-prices/description/?envType=daily-question&envId=2024-06-18">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2288_DiscountPrices {
    public static void main(String[] args) {
        L2288_DiscountPrices l2288DiscountPrices = new L2288_DiscountPrices();
        System.out.println(l2288DiscountPrices.discountPrices("706hzu76jjh7yufr5x9ot60v149k5 $7651913186 pw2o $6", 18));
    }

    public String discountPrices(String sentence, int discount) {
        //1.识别sentence中的金额，然后打折discount
        DecimalFormat df = new DecimalFormat("0.00");
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        char[] array = sentence.toCharArray();
        long digital = 0;
        boolean isDigital = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != ' ' && ((array[i] == '$' && temp.length() > 0) || (temp.length() > 0 && !Character.isDigit(array[i])))) {
                isDigital = false;
            } else if (Character.isDigit(array[i])) {
                digital = (digital * 10) + Character.digit(array[i], 10);
            }
            temp.append(array[i]);
            if (array[i] == ' ' || i == array.length - 1) {
                if (isDigital && temp.length() > 1 && temp.charAt(0) == '$' && digital > 0) {
                    sb.append('$')
                            .append(df.format((double) digital * ((100 - discount) * 0.01)));
                    if (array[i] == ' ') {
                        sb.append(' ');
                    }
                } else {
                    sb.append(temp);
                }
                digital = 0;
                isDigital = true;
                temp = new StringBuilder();
            }
        }
        return sb.toString();
    }
}
