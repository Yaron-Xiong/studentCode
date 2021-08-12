package com.carlotta;

/**
 * @author qiuping.zeng
 *
 * Java字符串的特性： 引用类型和字符串不可变
 *
 */
public class Guide {
	public static void main(String[] args) {
		String s = "big";
		System.out.println(s);
		s = "samll";
		/*字符串不可变指的是内容不可变*/
		System.out.println(s);

	}
}
