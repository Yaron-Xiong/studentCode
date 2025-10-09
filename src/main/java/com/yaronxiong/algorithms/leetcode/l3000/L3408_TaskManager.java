package com.yaronxiong.algorithms.leetcode.l3000;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * 3408. 设计任务管理器
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 一个任务管理器系统可以让用户管理他们的任务，每个任务有一个优先级。这个系统需要高效地处理添加、修改、执行和删除任务的操作。
 * <p>
 * 请你设计一个 TaskManager 类：
 * <p>
 * TaskManager(vector<vector<int>>& tasks) 初始化任务管理器，初始化的数组格式为 [userId, taskId, priority] ，
 * 表示给 userId 添加一个优先级为 priority 的任务 taskId 。
 * <p>
 * void add(int userId, int taskId, int priority) 表示给用户 userId 添加一个优先级为 priority 的任务 taskId ，输入 保证 taskId 不在系统中。
 * <p>
 * void edit(int taskId, int newPriority) 更新已经存在的任务 taskId 的优先级为 newPriority 。输入 保证 taskId 存在于系统中。
 * <p>
 * void rmv(int taskId) 从系统中删除任务 taskId 。输入 保证 taskId 存在于系统中。
 * <p>
 * int execTop() 执行所有用户的任务中优先级 最高 的任务，如果有多个任务优先级相同且都为 最高 ，
 * 执行 taskId 最大的一个任务。执行完任务后，taskId 从系统中 删除 。同时请你返回这个任务所属的用户 userId 。如果不存在任何任务，返回 -1 。
 * <p>
 * 注意 ，一个用户可能被安排多个任务。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["TaskManager", "add", "edit", "execTop", "rmv", "add", "execTop"]
 * [[[[1, 101, 10], [2, 102, 20], [3, 103, 15]]], [4, 104, 5], [102, 8], [], [101], [5, 105, 15], []]
 * <p>
 * 输出：
 * [null, null, null, 3, null, null, 5]
 * <p>
 * 解释：
 * <p>
 * TaskManager taskManager = new TaskManager([[1, 101, 10], [2, 102, 20], [3, 103, 15]]); // 分别给用户 1 ，2 和 3 初始化一个任务。
 * taskManager.add(4, 104, 5); // 给用户 4 添加优先级为 5 的任务 104 。
 * taskManager.edit(102, 8); // 更新任务 102 的优先级为 8 。
 * taskManager.execTop(); // 返回 3 。执行用户 3 的任务 103 。
 * taskManager.rmv(101); // 将系统中的任务 101 删除。
 * taskManager.add(5, 105, 15); // 给用户 5 添加优先级为 15 的任务 105 。
 * taskManager.execTop(); // 返回 5 。执行用户 5 的任务 105 。
 * <p>
 * 提示：
 * <p>
 * 1 <= tasks.length <= 105
 * 0 <= userId <= 105
 * 0 <= taskId <= 105
 * 0 <= priority <= 109
 * 0 <= newPriority <= 109
 * add ，edit ，rmv 和 execTop 的总操作次数 加起来 不超过 2 * 105 次。
 * 输入保证 taskId 是合法的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/design-task-manager/description/?envType=daily-question&envId=2025-09-18">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3408_TaskManager {
    public static void main(String[] args) {
        ArrayList<List<Integer>> tasks = Lists.newArrayList();
        tasks.add(Arrays.asList(1, 101, 10));
        tasks.add(Arrays.asList(2, 102, 20));
        tasks.add(Arrays.asList(3, 103, 15));
        TaskManager taskManager = new TaskManager(tasks);
        taskManager.add(4, 104, 5);
        taskManager.edit(102, 8);
        System.out.println(taskManager.execTop());
        taskManager.rmv(101);
        taskManager.add(5, 105, 15);
        System.out.println(taskManager.execTop());
    }

    public static class TaskManager {
        class Task implements Comparable<Task> {
            int userId;
            int taskId;
            int priority;

            public Task(int userId, int taskId, int priority) {
                this.userId = userId;
                this.taskId = taskId;
                this.priority = priority;
            }

            @Override
            public int compareTo(Task o) {
                int compare = Integer.compare(o.priority, this.priority);
                if (compare == 0) {
                    return Integer.compare(o.taskId, this.taskId);
                }
                return compare;
            }
        }

        PriorityQueue<Task> pq;
        Map<Integer, Task> taskMap;

        public TaskManager(List<List<Integer>> tasks) {
            //userId | taskId | priority
            pq = new PriorityQueue<>();
            taskMap = new HashMap<>();
            for (List<Integer> task : tasks) {
                add(task.get(0), task.get(1), task.get(2));
            }
        }

        public void add(int userId, int taskId, int priority) {
            Task task = new Task(userId, taskId, priority);
            pq.offer(task);
            taskMap.put(taskId, task);
        }

        public void edit(int taskId, int newPriority) {
            Task task = taskMap.get(taskId);
            add(task.userId, taskId, newPriority);
        }

        public void rmv(int taskId) {
            taskMap.remove(taskId);
        }

        public int execTop() {
            while (!pq.isEmpty()) {
                Task task = pq.poll();
                Task nowTask = taskMap.get(task.taskId);
                if (nowTask == null) {
                    //说明删除了
                    continue;
                }
                if (nowTask.priority != task.priority || nowTask.userId != task.userId) {
                    //说明修改了
                    continue;
                }
                rmv(task.taskId);
                return task.userId;
            }
            return -1;
        }
    }

}
