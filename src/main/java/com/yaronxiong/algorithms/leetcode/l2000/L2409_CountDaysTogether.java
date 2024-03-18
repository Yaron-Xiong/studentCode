package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2409. 统计共同度过的日子数
 * 提示
 * 简单
 * 24
 * 相关企业
 * Alice 和 Bob 计划分别去罗马开会。
 * <p>
 * 给你四个字符串 arriveAlice ，leaveAlice ，arriveBob 和 leaveBob 。Alice 会在日期
 * arriveAlice 到 leaveAlice 之间在城市里（日期为闭区间），而 Bob 在日期 arriveBob 到 leaveBob 之间在城市里（日期为闭区间）。
 * 每个字符串都包含 5 个字符，格式为 "MM-DD" ，对应着一个日期的月和日。
 * <p>
 * 请你返回 Alice和 Bob 同时在罗马的天数。
 * <p>
 * 你可以假设所有日期都在 同一个 自然年，而且 不是 闰年。每个月份的天数分别为：[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31] 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19"
 * 输出：3
 * 解释：Alice 从 8 月 15 号到 8 月 18 号在罗马。Bob 从 8 月 16 号到 8 月 19 号在罗马，他们同时在罗马的日期为 8 月 16、17 和 18 号。所以答案为 3 。
 * 示例 2：
 * <p>
 * 输入：arriveAlice = "10-01", leaveAlice = "10-31", arriveBob = "11-01", leaveBob = "12-31"
 * 输出：0
 * 解释：Alice 和 Bob 没有同时在罗马的日子，所以我们返回 0 。
 * <p>
 * 提示：
 * <p>
 * 所有日期的格式均为 "MM-DD" 。
 * Alice 和 Bob 的到达日期都 早于或等于 他们的离开日期。
 * 题目测试用例所给出的日期均为 非闰年 的有效日期。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-days-spent-together/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2409_CountDaysTogether {
	public static void main(String[] args) {
		L2409_CountDaysTogether l2409CountDaysTogether = new L2409_CountDaysTogether();
		int x = l2409CountDaysTogether.countDaysTogether2("04-20", "06-18", "04-12", "12-19");
		System.out.println(x);
	}

	public int[] monthDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public int countDaysTogether2(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
		//取小的arrive
		String minArrive = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
		String minLeave = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;
		int arrive = getDays(minArrive);
		int leave = getDays(minLeave);
		return leave - arrive >= 0 ? leave - arrive + 1 : 0;
	}

	private int getDays(String dateString) {
		String[] arriveString = dateString.split("-");
		int month = Integer.parseInt(arriveString[0]);
		int days = 0;
		for (int i = 1; i < month; i++) {
			days += monthDays[i - 1];
		}
		return days + Integer.parseInt(arriveString[1]);
	}

	public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
		//取小的arrive
		String minArrive;
		String minLeave;

		if (arriveAlice.compareTo(arriveBob) > 0) {
			minArrive = arriveAlice;
		} else {
			minArrive = arriveBob;
		}

		if (leaveAlice.compareTo(leaveBob) < 0) {
			minLeave = leaveAlice;
		} else {
			minLeave = leaveBob;
		}

		if (minLeave.compareTo(minArrive) < 0) {
			return 0;
		}

		//计算 minArrive->minLeave时间间隔
		String[] split = minArrive.split("-");
		int startMonth = Integer.parseInt(split[0]);
		int startDay = Integer.parseInt(split[1]);

		String[] minLeaveSplit = minLeave.split("-");
		int endMonth = Integer.parseInt(minLeaveSplit[0]);
		int endDay = Integer.parseInt(minLeaveSplit[1]);

		//如果是在同一个月
		if (startMonth == endMonth) {
			return endDay - startDay + 1;
		} else {
			//不在同一个月
			int res = 0;
			res += monthDays[startMonth - 1] - startDay + 1;
			res += endDay;
			//计算相差月份
			for (int i = startMonth + 1; i < endMonth; i++) {
				res += monthDays[i - 1];
			}
			return res;
		}
	}
}
