package com.accompnay.TopicAlgorithms.practiceSet.random_num;

import java.util.*;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 * 中等
 * 619
 * 相关企业
 * 实现RandomizedSet 类：
 * <p>
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * 输出
 * [null, true, false, true, 2, true, false, 2]
 * <p>
 * 解释
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
 * randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
 * randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
 * randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= val <= 231 - 1
 * 最多调用 insert、remove 和 getRandom 函数 2 * 105 次
 * 在调用 getRandom 方法时，数据结构中 至少存在一个 元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/insert-delete-getrandom-o1/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RandomizedSet {
	//val -> index
	private Map<Integer, Integer> indices;
	private List<Integer> nums;

	private Random random;

	public RandomizedSet() {
		indices = new HashMap<>();
		nums = new ArrayList<>();
		random = new Random();
	}

	public boolean insert(int val) {
		if (indices.containsKey(val)) {
			return false;
		}
		int newIndex = nums.size();
		indices.put(val, newIndex);
		nums.add(val);
		return true;
	}

	public boolean remove(int val) {
		if (!indices.containsKey(val)) {
			return false;
		}
		//val 从list中移除（移除的手段为使用最后一个元素覆盖 删除位置的元素）
		int lastIndex = nums.size() - 1;
		Integer lastValue = nums.get(lastIndex);
		Integer index = indices.get(val);

		//修正最后一个元素的下表位置
		nums.set(index, lastValue);
		indices.put(lastValue, index);
		//移除最后一个元素以及val在map中的值
		nums.remove(lastIndex);
		indices.remove(val);
		return true;
	}

	public int getRandom() {
		if (indices.isEmpty()) {
			return -1;
		}
		int i = random.nextInt(indices.size());
		return nums.get(i);
	}

	public static void main(String[] args) {
		RandomizedSet randomizedSet = new RandomizedSet();
		System.out.println(randomizedSet.insert(1));
		System.out.println(randomizedSet.remove(1));
		System.out.println(randomizedSet.insert(3));
		System.out.println(randomizedSet.remove(3));
		System.out.println(randomizedSet.getRandom());
		System.out.println(randomizedSet.remove(1));
		System.out.println(randomizedSet.insert(1));
		System.out.println(randomizedSet.getRandom());
	}
}