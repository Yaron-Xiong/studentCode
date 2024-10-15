package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2516. 每种字符至少取 K 个
 * 算术评级: 5
 * 第 325 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1948
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个由字符 'a'、'b'、'c' 组成的字符串 s 和一个非负整数 k 。每分钟，你可以选择取走 s 最左侧 还是 最右侧 的那个字符。
 * <p>
 * 你必须取走每种字符 至少 k 个，返回需要的 最少 分钟数；如果无法取到，则返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aabaaaacaabc", k = 2
 * 输出：8
 * 解释：
 * 从 s 的左侧取三个字符，现在共取到两个字符 'a' 、一个字符 'b' 。
 * 从 s 的右侧取五个字符，现在共取到四个字符 'a' 、两个字符 'b' 和两个字符 'c' 。
 * 共需要 3 + 5 = 8 分钟。
 * 可以证明需要的最少分钟数是 8 。
 * 示例 2：
 * <p>
 * 输入：s = "a", k = 1
 * 输出：-1
 * 解释：无法取到一个字符 'b' 或者 'c'，所以返回 -1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 仅由字母 'a'、'b'、'c' 组成
 * 0 <= k <= s.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/take-k-of-each-character-from-left-and-right/description/?envType=daily-question&envId=2024-09-27">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2516_TakeCharacters {
    public static void main(String[] args) {
        L2516_TakeCharacters l2516TakeCharacters = new L2516_TakeCharacters();
        System.out.println(l2516TakeCharacters.takeCharacters("aabaaaacaabc", 2));
    }

    public int takeCharacters(String s, int k) {
        if (k * 3 > s.length()) {
            return -1;
        }
        if (k == 0) {
            return 0;
        }
        int[] cnt = new int[3];
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            cnt[c - 'a']++;
        }
        int ans;
        if (cnt[0] >= k && cnt[1] >= k && cnt[2] >= k) {
            ans = s.length();
        } else {
            return -1;
        }
        int l = 0;
        for (int r = 0; r < charArray.length; r++) {
            cnt[charArray[r] - 'a']--;
            //判断当前是否满足
            while (l < r && (cnt[0] < k || cnt[1] < k || cnt[2] < k)) {
                cnt[charArray[l] - 'a']++;
                l++;
            }
            if (cnt[0] >= k && cnt[1] >= k && cnt[2] >= k) {
                ans = Math.min(ans, charArray.length - (r - l + 1));
            }
        }
        return ans;
    }

}
