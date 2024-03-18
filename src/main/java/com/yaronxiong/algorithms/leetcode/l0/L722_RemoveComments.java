package com.yaronxiong.algorithms.leetcode.l0;

import java.util.ArrayList;
import java.util.List;

/**
 * 722. 删除注释
 * 提示
 * 中等
 * 95
 * 相关企业
 * 给一个 C++ 程序，删除程序中的注释。这个程序source是一个数组，其中source[i]表示第 i 行源码。 这表示每行源码由 '\n' 分隔。
 * <p>
 * 在 C++ 中有两种注释风格，行内注释和块注释。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/remove-comments/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L722_RemoveComments {
    public static void main(String[] args) {
        L722_RemoveComments l722RemoveComments = new L722_RemoveComments();
        List<String> x = l722RemoveComments.removeComments(new String[]{"a//*b/*/c", "blank", "d/*/e/*/f"});
        System.out.println(x);
    }

    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        boolean blockFlag = false;
        //什么时候是newLine，当// 或者注释结束后
        StringBuilder newLine = new StringBuilder();
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (blockFlag) {
                    if (i + 1 < s.length() && s.charAt(i) == '*' && s.charAt(i + 1) == '/') {
                        blockFlag = false;
                        i++;
                    }
                } else {
                    if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
                        //行注释 后面全部跳过
                        i++;
                        break;
                    } else if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '*') {
                        //块状开始
                        i++;
                        blockFlag = true;
                    } else {
                        newLine.append(s.charAt(i));
                    }
                }
            }
            if (!blockFlag && newLine.length() != 0) {
                res.add(newLine.toString());
                newLine = new StringBuilder();
            }
        }
        return res;
    }
}
