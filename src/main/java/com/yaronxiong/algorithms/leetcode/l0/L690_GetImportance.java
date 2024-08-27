package com.yaronxiong.algorithms.leetcode.l0;

import java.util.*;

/**
 * 690. 员工的重要性
 * 算术评级: 3
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * 相关企业
 * 你有一个保存员工信息的数据结构，它包含了员工唯一的 id ，重要度和直系下属的 id 。
 * <p>
 * 给定一个员工数组 employees，其中：
 * <p>
 * employees[i].id 是第 i 个员工的 ID。
 * employees[i].importance 是第 i 个员工的重要度。
 * employees[i].subordinates 是第 i 名员工的直接下属的 ID 列表。
 * 给定一个整数 id 表示一个员工的 ID，返回这个员工和他所有下属的重要度的 总和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
 * 输出：11
 * 解释：
 * 员工 1 自身的重要度是 5 ，他有两个直系下属 2 和 3 ，而且 2 和 3 的重要度均为 3 。因此员工 1 的总重要度是 5 + 3 + 3 = 11 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：employees = [[1,2,[5]],[5,-3,[]]], id = 5
 * 输出：-3
 * 解释：员工 5 的重要度为 -3 并且没有直接下属。
 * 因此，员工 5 的总重要度为 -3。
 * <p>
 * 提示：
 * <p>
 * 1 <= employees.length <= 2000
 * 1 <= employees[i].id <= 2000
 * 所有的 employees[i].id 互不相同。
 * -100 <= employees[i].importance <= 100
 * 一名员工最多有一名直接领导，并可能有多名下属。
 * employees[i].subordinates 中的 ID 都有效。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/employee-importance/description/?envType=daily-question&envId=2024-08-26">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L690_GetImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Deque<Integer> deque = new LinkedList<>();
        deque.add(id);
        int value = map.get(id).importance;
        while (!deque.isEmpty()) {
            Integer curId = deque.pollFirst();
            Employee employee = map.get(curId);
            for (Integer subordinate : employee.subordinates) {
                value += map.get(subordinate).importance;
                deque.addLast(subordinate);
            }
        }
        return value;
    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}

