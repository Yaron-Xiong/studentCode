package com.accompnay.algorithmCombat.stackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Accompany
 * LeetCode 20题
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 *
 * 解法1：可以采用计数法，遍历整个字符串，查看每个符号出现的次数
 * 如果左边出现一次则加一 右边出现一次则减一
 *
 * 解法2：采用栈，遍历整个字符串 将左边进行压栈 右边弹出
 */
public class Demo4 {
    /**
     * map的作用是将字符做对应关系，减少不必要的判断
     * 同时能够很快找到符号的对应关系
     */
    private Map<Character,Character> map ;
    public Demo4(){
        map = new HashMap<>();
        map.put('{','}');
        map.put('(', ')');
        map.put('[',']');
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)){
                stack.add(c);
            }else if (stack.isEmpty()){
                return false;
            } else if (map.containsValue(c)&&!map.get(stack.pop()).equals(c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Demo4 demo4 = new Demo4();
        System.out.println(demo4.isValid("{}"));
    }
}
