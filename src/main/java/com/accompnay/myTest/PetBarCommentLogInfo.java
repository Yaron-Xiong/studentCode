package com.accompnay.myTest;


import com.alibaba.fastjson.annotation.JSONCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PetBarCommentLogInfo {
	public final String title;
	public final String content;
	public final String creatureName;

	public PetBarCommentLogInfo() {
		this("", "", "");
	}

	@JSONCreator
	public PetBarCommentLogInfo(@JsonProperty("title")String title, String content, String creatureName) {
		this.title = title;
		this.content = content;
		this.creatureName = creatureName;
	}

	@Override
	public String toString() {
		return "PetBarCommentLogInfo{" +
				"title='" + title + '\'' +
				", content='" + content + '\'' +
				", creatureName='" + creatureName + '\'' +
				'}';
	}
}
