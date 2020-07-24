package com.accompnay.myTest;
import com.baitian.oa.remote.mobileoa.proxy.entity.candidate.RemoteCandidateVo;
import com.baitian.oa.util.SummaryUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

public class Test4 {
	public static void main(String[] args) throws Exception {
		Map<String, Object> map1 = Maps.newHashMap();
		map1.put("name", "吃梨花");
		map1.put("fileSize", 435480L);
		map1.put("phone", "123456");
		map1.put("suitableJob", Lists.newArrayList("魔导师"));
		map1.put("filePath", "http://localhost:9001/C:/Users/yaoyuanxiong/Desktop/2.png");
		String summary = SummaryUtils.getSummary(map1);

		long fileSize = 435480;
		String name = new String("吃梨花");
		String phone = new String("123456");

		RemoteCandidateVo remoteCandidateVo = new RemoteCandidateVo();
		remoteCandidateVo.setName(name);
		remoteCandidateVo.setFileSize(fileSize);
		remoteCandidateVo.setPhone(phone);
		remoteCandidateVo.setSuitableJob(Lists.newArrayList("魔导师"));
		remoteCandidateVo.setFilePath("http://localhost:9001/C:/Users/yaoyuanxiong/Desktop/2.png");
		String summary2 = SummaryUtils.getSummary(remoteCandidateVo);
		System.out.println(summary);
		System.out.println(summary2);
		System.out.println(summary.equals(summary2));
	}
}
