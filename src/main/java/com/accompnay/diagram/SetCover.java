package com.accompnay.diagram;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Map;
import java.util.Set;

/**
 * 能覆盖最多的州的集合
 * <p>
 * 贪心算法
 * <p>
 * 每次选取覆盖最多未覆盖的州
 */
public class SetCover {
	public static void main(String[] args) {
		Map<String, Set<String>> map = Maps.newHashMap();
		map.put("kone", Sets.newHashSet("id", "nv", "ut"));
		map.put("ktow", Sets.newHashSet("wa", "id", "mt"));
		map.put("kthree", Sets.newHashSet("or", "nv", "ca"));
		map.put("kfour", Sets.newHashSet("nv", "ut"));
		map.put("kfive", Sets.newHashSet("ca", "az"));
		Set<String> cover = setCover(map);
		System.out.println(cover);
	}

	public static Set<String> setCover(Map<String, Set<String>> map) {
		Set<String> result = Sets.newHashSet();
		Set<String> needCover = Sets.newHashSet("id", "nv", "ut", "wa", "id", "mt", "or", "nv", "ca", "nv", "ut", "ca", "az");
		while (!needCover.isEmpty()) {
			String subResult = null;
			int count = 0;
			for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
				Set<String> set = entry.getValue();
				set.retainAll(needCover);
				if (set.size() > count){
					count = set.size();
					subResult = entry.getKey();
				}
			}
			needCover.removeAll(map.get(subResult));
			result.add(subResult);
		}
		return result;
	}
}
