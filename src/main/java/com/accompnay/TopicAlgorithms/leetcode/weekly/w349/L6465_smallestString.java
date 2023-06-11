package com.accompnay.TopicAlgorithms.leetcode.weekly.w349;

/**
 *
 */
public class L6465_smallestString {
    public static void main(String[] args) {
        L6465_smallestString l6465SmallestString = new L6465_smallestString();
        System.out.println(l6465SmallestString.smallestString("cbabc"));
    }

    public String smallestString(String s) {
        int startIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'a') {
                startIndex = i;
                break;
            }
        }
        if (startIndex == -1) {
            //将最后一个a变小
            startIndex = s.length() - 1;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                endIndex = i - 1;
                if (endIndex < startIndex) {
                    endIndex = startIndex;
                }
                break;
            }
        }
        endIndex = endIndex == -1 ? s.length() - 1 : endIndex;


        //将startIndex ~ endIndex 往前变一个
        char[] chars = s.toCharArray();
        for (int i = startIndex; i <= endIndex; i++) {
            if (s.charAt(i) == 'a') {
                chars[i] = 'z';
                continue;
            }
            chars[i] = (char) (s.charAt(i) - 1);
        }
        return new String(chars);
    }
}
