package com.yaronxiong.algorithms.swordFingerOffer.bitOperation;

/**
 * 剑指 Offer 65. 不用加减乘除做加法：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * 示例:
 * <p>
 * 输入: a = 1, b = 1
 * 输出: 2
 * <p>
 * 提示：
 * <p>
 * a,b均可能是负数或 0
 * 结果不会溢出 32 位整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/?envType=study-plan-v2&envId=coding-interviews">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S65_Add {
    public static void main(String[] args) {
        S65_Add s65Add = new S65_Add();
        int add1 = s65Add.add(5, 7);
        System.out.println(add1);
    }

    public int add(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}
