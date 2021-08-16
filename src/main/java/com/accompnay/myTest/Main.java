package com.accompnay.myTest;

import com.alibaba.fastjson.JSON;

public class Main {
	public static void main(String[] args) {
		String mes = "{\"content\":\"导师注意一下自己的行为\",\"creatureName\":\"圣愿归凰·诺亚\",\"title\":\"不行的话，看下能不能产品设计如此\"}";
		PetBarCommentLogInfo logInfo = (PetBarCommentLogInfo) JSON.parseObject(mes, PetBarCommentLogInfo.class);
		System.out.println(logInfo);
	}
}
