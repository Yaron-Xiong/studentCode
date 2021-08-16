package com.accompnay.designPatterns.adapter;

public class Main {
	public static void main(String[] args) {
		IUserInfo userInfo = new OutUserInfoAdapter();
		String homeAddress = userInfo.getHomeAddress();
		System.out.println(homeAddress);
	}
}
