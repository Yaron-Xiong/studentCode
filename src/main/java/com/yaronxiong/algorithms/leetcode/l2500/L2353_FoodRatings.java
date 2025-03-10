package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.*;

/**
 * 2353. 设计食物评分系统
 * 算术评级: 5
 * 第 303 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1782
 * 相关标签
 * 相关企业
 * 提示
 * 设计一个支持下述操作的食物评分系统：
 * <p>
 * 修改 系统中列出的某种食物的评分。
 * 返回系统中某一类烹饪方式下评分最高的食物。
 * 实现 FoodRatings 类：
 * <p>
 * FoodRatings(String[] foods, String[] cuisines, int[] ratings) 初始化系统。食物由 foods、cuisines 和 ratings 描述，长度均为 n 。
 * foods[i] 是第 i 种食物的名字。
 * cuisines[i] 是第 i 种食物的烹饪方式。
 * ratings[i] 是第 i 种食物的最初评分。
 * void changeRating(String food, int newRating) 修改名字为 food 的食物的评分。
 * String highestRated(String cuisine) 返回指定烹饪方式 cuisine 下评分最高的食物的名字。如果存在并列，返回 字典序较小 的名字。
 * 注意，字符串 x 的字典序比字符串 y 更小的前提是：x 在字典中出现的位置在 y 之前，也就是说，要么 x 是 y 的前缀，
 * 或者在满足 x[i] != y[i] 的第一个位置 i 处，x[i] 在字母表中出现的位置在 y[i] 之前。
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"]
 * [[["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]], ["korean"], ["japanese"], ["sushi", 16], ["japanese"], ["ramen", 16], ["japanese"]]
 * 输出
 * [null, "kimchi", "ramen", null, "sushi", null, "ramen"]
 * <p>
 * 解释
 * FoodRatings foodRatings = new FoodRatings(["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]);
 * foodRatings.highestRated("korean"); // 返回 "kimchi"
 * // "kimchi" 是分数最高的韩式料理，评分为 9 。
 * foodRatings.highestRated("japanese"); // 返回 "ramen"
 * // "ramen" 是分数最高的日式料理，评分为 14 。
 * foodRatings.changeRating("sushi", 16); // "sushi" 现在评分变更为 16 。
 * foodRatings.highestRated("japanese"); // 返回 "sushi"
 * // "sushi" 是分数最高的日式料理，评分为 16 。
 * foodRatings.changeRating("ramen", 16); // "ramen" 现在评分变更为 16 。
 * foodRatings.highestRated("japanese"); // 返回 "ramen"
 * // "sushi" 和 "ramen" 的评分都是 16 。
 * // 但是，"ramen" 的字典序比 "sushi" 更小。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2 * 104
 * n == foods.length == cuisines.length == ratings.length
 * 1 <= foods[i].length, cuisines[i].length <= 10
 * foods[i]、cuisines[i] 由小写英文字母组成
 * 1 <= ratings[i] <= 108
 * foods 中的所有字符串 互不相同
 * 在对 changeRating 的所有调用中，food 是系统中食物的名字。
 * 在对 highestRated 的所有调用中，cuisine 是系统中 至少一种 食物的烹饪方式。
 * 最多调用 changeRating 和 highestRated 总计 2 * 104 次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/design-a-food-rating-system/description/?envType=daily-question&envId=2025-02-28">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2353_FoodRatings {
    public static void main(String[] args) {
        String[] foods = {"czopaaeyl", "lxoozsbh", "kbaxapl"};
        String[] cuisines = {"dmnuqeatj", "dmnuqeatj", "dmnuqeatj"};
        int[] ratings = {11, 2, 15};
        FoodRatings foodRatings = new FoodRatings(foods, cuisines, ratings);
        foodRatings.changeRating("czopaaeyl", 12);
        System.out.println(foodRatings.highestRated("dmnuqeatj"));
        foodRatings.changeRating("kbaxapl", 8);
        foodRatings.changeRating("lxoozsbh", 5);
        System.out.println(foodRatings.highestRated("dmnuqeatj"));
    }

    static class FoodRatings {
        class Food {
            String name;
            String cuisine;
            int rating;

            public Food(String name, String cuisine, int rating) {
                this.name = name;
                this.cuisine = cuisine;
                this.rating = rating;
            }

        }

        private Map<String, Food> nameToFood;
        private Map<String, TreeSet<Food>> cuisineToFood;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            nameToFood = new HashMap<>();
            cuisineToFood = new HashMap<>();
            for (int i = 0; i < foods.length; i++) {
                Food food = new Food(foods[i], cuisines[i], ratings[i]);
                nameToFood.put(food.name, food);
                TreeSet<Food> treeSet = cuisineToFood.computeIfAbsent(food.cuisine,
                        k -> new TreeSet<>((a, b) -> {
                            int compare = Integer.compare(b.rating, a.rating);
                            if (compare != 0) {
                                return compare;
                            }
                            return a.name.compareTo(b.name);
                        }));
                treeSet.add(food);
            }
        }

        public void changeRating(String food, int newRating) {
            Food foodEntity = nameToFood.get(food);
            TreeSet<Food> foods = cuisineToFood.get(foodEntity.cuisine);
            foods.remove(foodEntity);
            foodEntity.rating = newRating;
            foods.add(foodEntity);
        }

        public String highestRated(String cuisine) {
            TreeSet<Food> foods = cuisineToFood.get(cuisine);
            Food peek = foods.first();
            return peek.name;
        }
    }
}
