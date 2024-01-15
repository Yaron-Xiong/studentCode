package com.accompnay.TopicAlgorithms.leetcode.l2000;

/**
 * 2182. 构造限制重复的字符串
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s 和一个整数 repeatLimit ，用 s 中的字符构造一个新字符串 repeatLimitedString ，
 * 使任何字母 连续 出现的次数都不超过 repeatLimit 次。你不必使用 s 中的全部字符。
 * <p>
 * 返回 字典序最大的 repeatLimitedString 。
 * <p>
 * 如果在字符串 a 和 b 不同的第一个位置，字符串 a 中的字母在字母表中出现时间比字符串 b 对应的字母晚，
 * 则认为字符串 a 比字符串 b 字典序更大 。如果字符串中前 min(a.length, b.length) 个字符都相同，那么较长的字符串字典序更大。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "cczazcc", repeatLimit = 3
 * 输出："zzcccac"
 * 解释：使用 s 中的所有字符来构造 repeatLimitedString "zzcccac"。
 * 字母 'a' 连续出现至多 1 次。
 * 字母 'c' 连续出现至多 3 次。
 * 字母 'z' 连续出现至多 2 次。
 * 因此，没有字母连续出现超过 repeatLimit 次，字符串是一个有效的 repeatLimitedString 。
 * 该字符串是字典序最大的 repeatLimitedString ，所以返回 "zzcccac" 。
 * 注意，尽管 "zzcccca" 字典序更大，但字母 'c' 连续出现超过 3 次，所以它不是一个有效的 repeatLimitedString 。
 * 示例 2：
 * <p>
 * 输入：s = "aababab", repeatLimit = 2
 * 输出："bbabaa"
 * 解释：
 * 使用 s 中的一些字符来构造 repeatLimitedString "bbabaa"。
 * 字母 'a' 连续出现至多 2 次。
 * 字母 'b' 连续出现至多 2 次。
 * 因此，没有字母连续出现超过 repeatLimit 次，字符串是一个有效的 repeatLimitedString 。
 * 该字符串是字典序最大的 repeatLimitedString ，所以返回 "bbabaa" 。
 * 注意，尽管 "bbabaaa" 字典序更大，但字母 'a' 连续出现超过 2 次，所以它不是一个有效的 repeatLimitedString 。
 * <p>
 * 提示：
 * <p>
 * 1 <= repeatLimit <= s.length <= 105
 * s 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/construct-string-with-repeat-limit/description/?envType=daily-question&envId=2024-01-13">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2182_RepeatLimitedString {
    public static void main(String[] args) {
        L2182_RepeatLimitedString l2182RepeatLimitedString = new L2182_RepeatLimitedString();
        System.out.println(l2182RepeatLimitedString.repeatLimitedString("cczazcc", 3));
    }
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int index = arr.length - 1;
        while (index >= 0) {
            if (arr[index] == 0) {
                index--;
                continue;
            }
            int size = Math.min(arr[index], repeatLimit);
            arr[index] -= size;
            while (size > 0) {
                size--;
                sb.append((char) ('a' + index));
            }
            if (arr[index] > 0) {
                boolean canMove = false;
                //向前借一个,借不到则无法继续构建了
                for (int j = index - 1; j >= 0; j--) {
                    if (arr[j] == 0) {
                        continue;
                    }
                    sb.append((char) ('a' + j));
                    arr[j]--;
                    canMove = true;
                    break;
                }
                if (!canMove) {
                    break;
                }
            } else {
                index--;
            }
        }
        return sb.toString();
    }
}
