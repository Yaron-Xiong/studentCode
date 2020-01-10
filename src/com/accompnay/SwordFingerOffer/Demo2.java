package com.accompnay.SwordFingerOffer;

/**
 * @author Accompany
 * Date:2019/12/31
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Demo2 {
    public static void main(String[] args) {
        String str = "We Are Happy";
        String s = replaceSpace(new StringBuffer(str));
        System.out.println(s);
    }
    /*public static String replaceSpace(StringBuffer str) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = str.toString().toCharArray();
        for (char aChar : chars) {
            if (aChar==' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(aChar);
            }
        }
        return stringBuilder.toString();
    }*/

    public static String replaceSpace(StringBuffer str) {
        int index = str.indexOf(" ");
        while (index>=0){
            str.replace(index,index+1,"%20");
            index = str.indexOf(" ");
        }
        return str.toString();
    }
}
