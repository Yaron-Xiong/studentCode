package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.HashMap;
import java.util.Map;

/**
 * 3305. 元音辅音字符串计数 I
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 word 和一个 非负 整数 k。
 * <p>
 * 返回 word 的 子字符串 中，每个元音字母（'a'、'e'、'i'、'o'、'u'）至少 出现一次，并且 恰好 包含 k 个辅音字母的子字符串的总数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "aeioqq", k = 1
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 不存在包含所有元音字母的子字符串。
 * <p>
 * 示例 2：
 * <p>
 * 输入：word = "aeiou", k = 0
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 唯一一个包含所有元音字母且不含辅音字母的子字符串是 word[0..4]，即 "aeiou"。
 * <p>
 * 示例 3：
 * <p>
 * 输入：word = "ieaouqqieaouqq", k = 1
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 包含所有元音字母并且恰好含有一个辅音字母的子字符串有：
 * <p>
 * word[0..5]，即 "ieaouq"。
 * word[6..11]，即 "qieaou"。
 * word[7..12]，即 "ieaouq"。
 * <p>
 * 提示：
 * <p>
 * 5 <= word.length <= 250
 * word 仅由小写英文字母组成。
 * 0 <= k <= word.length - 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-of-substrings-containing-every-vowel-and-k-consonants-i/description/?envType=daily-question&envId=2025-03-12">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3305_CountOfSubstrings {
    public static void main(String[] args) {
        L3305_CountOfSubstrings l3305CountOfSubstrings = new L3305_CountOfSubstrings();
        System.out.println(l3305CountOfSubstrings.countOfSubstrings("ieiaoud", 0));
    }

    public int countOfSubstrings(String word, int k) {
        //滑动窗口
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);
        //计算每个辅音前面有多少个元音
        char[] charArray = word.toCharArray();
        int[] preVowelCnt = new int[charArray.length];
        int left = 0;
        int ans = 0;
        int vowelCnt = 0;
        for (int right = 0; right < charArray.length; right++) {
            if (map.containsKey(charArray[right])) {
                vowelCnt++;
                map.merge(charArray[right], 1, Integer::sum);
            }
            if (right > 0 && map.containsKey(charArray[right - 1])) {
                preVowelCnt[right] += preVowelCnt[right - 1] + 1;
            }
            //检查辅音是否多了 || 元音是否多了
            while (right - left + 1 - vowelCnt > k || (left < right && map.getOrDefault(charArray[left], 0) > 1)) {
                //缩小左边界
                if (map.containsKey(charArray[left])) {
                    vowelCnt--;
                    map.merge(charArray[left], -1, Integer::sum);
                }
                left++;
            }
            if (right - left + 1 - vowelCnt == k) {
                //满足条件，此时判断left是否为元音，尝
                if (map.values().stream().allMatch(a -> a >= 1)) {
                    ans += preVowelCnt[left] + 1;
                    //System.out.println(left + "==" + right);
                }
            }
        }
        return ans;
    }
}
