package com.accompnay.designPatterns.adapter;

import java.util.Map;

/**
 * 将OutUser转化为UserInfo
 */
public class OutUserInfoAdapter extends OutUser implements IUserInfo{
	private Map baseInfo = super.getUserBaseInfo();
	private Map userHomeInfo = super.getUserHomeInfo();
	private Map userOfficeInfo = super.getUserOfficeInfo();

	@Override
	public String getUserName() {
		return (String) baseInfo.get("userName");
	}

	@Override
	public String getHomeAddress() {
		return (String) userHomeInfo.get("homeAddress");
	}

	@Override
	public String getMobileNumber() {
		return (String) baseInfo.get("mobileNumber");
	}

	@Override
	public String getOfficeTelNumber() {
		return (String) userOfficeInfo.get("officeTelNumber");
	}

	@Override
	public String getJobPosition() {
		return (String) userOfficeInfo.get("jobPosition");
	}

	@Override
	public String getHomeTelNumber() {
		return (String) userHomeInfo.get("homeTelNumber");
	}
}
