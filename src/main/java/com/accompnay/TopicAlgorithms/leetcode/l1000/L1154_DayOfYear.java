package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * 1154. 一年中的第几天
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。返回该日期是当年的第几天。
 * <p>
 * 示例 1：
 * <p>
 * 输入：date = "2019-01-09"
 * 输出：9
 * 解释：给定日期是2019年的第九天。
 * 示例 2：
 * <p>
 * 输入：date = "2019-02-10"
 * 输出：41
 * <p>
 * 提示：
 * <p>
 * date.length == 10
 * date[4] == date[7] == '-'，其他的 date[i] 都是数字
 * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/day-of-the-year/description/?envType=daily-question&envId=2023-12-31">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1154_DayOfYear {
    public static void main(String[] args) {
        L1154_DayOfYear l1154DayOfYear = new L1154_DayOfYear();
        System.out.println(l1154DayOfYear.dayOfYear("2019-01-09"));
    }
    public int dayOfYear(String date) {
        try {
            LocalDateTime localDateTime = LocalDateTime.ofInstant(new SimpleDateFormat("yyyy-MM-dd").parse(date).toInstant(), ZoneId.systemDefault());
            return localDateTime.getDayOfYear();
        } catch (ParseException e) {
            return 0;
        }
    }
}
