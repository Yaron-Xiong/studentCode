package com.accompnay.hacking;

import com.google.common.collect.Sets;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {
	Set<String> ips = Sets.newHashSet("117.14.201.64");
	Set<String> duoduoSet = Sets.newHashSet("123456789","288427776","509393498","546299510","764603331","90001","900206236","900206697","99990","99993","99995");

	public static void main(String[] args) throws Exception {
		Test test = new Test();
		Map map = test.readResetPwd();
		//test.ips = map.keySet();
		//Map map2 = test.readChangeLog();
		//Map map1 = test.readBind();
		System.out.println();
	}

	public Map readChangeLog() throws Exception {
		Map<String, List<ChangeLog>> map = readAll2Oject("changeLog", ChangeLog.getResolveFunction()).stream()
				//.filter(item -> ips.contains(item.getIp()))
				.filter(filterDuoduoId())
				.collect(Collectors.groupingBy(changeLog -> changeLog.getIp()));
		return map;
	}

	public Map readBind() throws Exception {
		Map<String, List<BindLog>> map = readAll2Oject("bind", BindLog.getResolveFunction()).stream()
				//.filter(item -> ips.contains(item.getIp()))
				.filter(filterDuoduoId())
				.collect(Collectors.groupingBy(bindLog -> bindLog.getIp()));
		return map;
	}

	public Map readResetPwd() throws Exception {
		Map<String, List<ResetPwd>> ip2ResetPwd = readAll2Oject("reset", ResetPwd.getResolveFunction()).stream()
				//.filter(resetPwd -> resetPwd.getType().equals("7"))
				//.filter(resetPwd -> ips.contains(resetPwd.getIp()))
				.filter(filterDuoduoId())
				//.filter(entry->entry.getValue().size()>1)
				.collect(Collectors.groupingBy(resetPwd -> resetPwd.getDuoduoId()));

		return ip2ResetPwd;
	}

	private <T extends BaseBean> List<T> readAll2Oject(String filePath, Function<String, T> resolveFunction) throws Exception {
		URL resource = this.getClass().getClassLoader().getResource(filePath);
		Path path = Paths.get(resource.toURI());
		List<T> result = Collections.synchronizedList(new ArrayList<>(1000000));
		for (File subFile : path.toFile().listFiles()) {
			System.out.println("正在进行" + subFile.getName() + "的解析工作");
			List<T> subResult = Files.readAllLines(Paths.get(subFile.toURI()))
					.stream().map(resolveFunction)
					.collect(Collectors.toList());
			result.addAll(subResult);
		}
		return result;
	}


	private Predicate<BaseBean> filterDuoduoId() {
		return item -> duoduoSet.contains(item.getDuoduoId());
	}
}
