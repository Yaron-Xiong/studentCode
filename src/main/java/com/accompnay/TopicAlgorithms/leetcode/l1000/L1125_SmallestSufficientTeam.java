package com.accompnay.TopicAlgorithms.leetcode.l1000;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * 1125. 最小的必要团队
 * 提示
 * 困难
 * 138
 * 相关企业
 * 作为项目经理，你规划了一份需求的技能清单 req_skills，并打算从备选人员名单 people 中选出些人组成一个「必要团队」
 * （ 编号为 i 的备选人员 people[i] 含有一份该备选人员掌握的技能列表）。
 * <p>
 * 所谓「必要团队」，就是在这个团队中，对于所需求的技能列表 req_skills 中列出的每项技能，团队中至少有一名成员已经掌握。可以用每个人的编号来表示团队中的成员：
 * <p>
 * 例如，团队 team = [0, 1, 3] 表示掌握技能分别为 people[0]，people[1]，和 people[3] 的备选人员。
 * 请你返回 任一 规模最小的必要团队，团队成员用人员编号表示。你可以按 任意顺序 返回答案，题目数据保证答案存在。
 * <p>
 * 示例 1：
 * <p>
 * 输入：req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
 * 输出：[0,2]
 * 示例 2：
 * <p>
 * 输入：req_skills = ["algorithms","math","java","reactjs","csharp","aws"],
 * people = [["algorithms","math","java"],["algorithms","math","reactjs"]
 * ,["java","csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
 * 输出：[1,2]
 * <p>
 * 提示：
 * <p>
 * 1 <= req_skills.length <= 16
 * 1 <= req_skills[i].length <= 16
 * req_skills[i] 由小写英文字母组成
 * req_skills 中的所有字符串 互不相同
 * 1 <= people.length <= 60
 * 0 <= people[i].length <= 16
 * 1 <= people[i][j].length <= 16
 * people[i][j] 由小写英文字母组成
 * people[i] 中的所有字符串 互不相同
 * people[i] 中的每个技能是 req_skills 中的技能
 * 题目数据保证「必要团队」一定存在
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/smallest-sufficient-team/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1125_SmallestSufficientTeam {
	public static void main(String[] args) {
		L1125_SmallestSufficientTeam l1125SmallestSufficientTeam = new L1125_SmallestSufficientTeam();
		List<List<String>> people = new ArrayList<>();
		people.add(Lists.newArrayList());
		people.add(Lists.newArrayList());
		people.add(Lists.newArrayList());
		people.add(Lists.newArrayList());
		people.add(Lists.newArrayList("jgpzzicdvgxlfix"));
		people.add(Lists.newArrayList("jgpzzicdvgxlfix", "k"));
		people.add(Lists.newArrayList("jgpzzicdvgxlfix", "kqcrfwerywbwi"));
		people.add(Lists.newArrayList("gvp"));
		people.add(Lists.newArrayList("jzukdzrfgvdbrunw"));
		people.add(Lists.newArrayList("gvp", "kqcrfwerywbwi"));
		String[] reqSkills = {"gvp", "jgpzzicdvgxlfix", "kqcrfwerywbwi", "jzukdzrfgvdbrunw", "k"};
		int[] team = l1125SmallestSufficientTeam.smallestSufficientTeam(reqSkills, people);
		System.out.println(Arrays.toString(team));
	}


	List<List<String>> peoples;

	LinkedList<Integer> res = null;

	Map<String, Integer> skills2Count;
	int count;

	public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
		peoples = people;
		skills2Count = new HashMap<>();
		for (String reqSkill : req_skills) {
			skills2Count.put(reqSkill, 0);
		}
		count = req_skills.length;
		dfs(0, new LinkedList<>());
		int[] resArr = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			resArr[i] = res.get(i);
		}
		return resArr;
	}

	private void dfs(int index, LinkedList<Integer> path) {
		if (count == 0) {
			if (res == null || path.size() < res.size()) {
				res = new LinkedList<>(path);
			}
		}
		if (index >= peoples.size()) {
			return;
		}
		//选择当前节点
		path.addLast(index);
		addSkillCount(index);
		dfs(index + 1, path);
		removeSkillCount(index);
		path.removeLast();

		//不选择当前节点
		dfs(index + 1, path);
	}

	private void addSkillCount(int index) {
		List<String> peopleSkills = peoples.get(index);
		for (String peopleSkill : peopleSkills) {
			if (!skills2Count.containsKey(peopleSkill)) {
				continue;
			}
			if (skills2Count.get(peopleSkill) == 0){
				count--;
			}
			skills2Count.put(peopleSkill, skills2Count.get(peopleSkill) + 1);
		}
	}

	private void removeSkillCount(int index) {
		List<String> peopleSkills = peoples.get(index);
		for (String peopleSkill : peopleSkills) {
			if (!skills2Count.containsKey(peopleSkill)) {
				continue;
			}
			if (skills2Count.get(peopleSkill) == 1) {
				count++;
			}
			skills2Count.put(peopleSkill, skills2Count.get(peopleSkill) - 1);
		}
	}
}
