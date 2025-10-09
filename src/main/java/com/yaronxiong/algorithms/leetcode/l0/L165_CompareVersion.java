package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 165. 比较版本号
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个 版本号字符串 version1 和 version2 ，请你比较它们。版本号由被点 '.' 分开的修订号组成。修订号的值 是它 转换为整数 并忽略前导零。
 * <p>
 * 比较版本号时，请按 从左到右的顺序 依次比较它们的修订号。如果其中一个版本字符串的修订号较少，则将缺失的修订号视为 0。
 * <p>
 * 返回规则如下：
 * <p>
 * 如果 version1 < version2 返回 -1，
 * 如果 version1 > version2 返回 1，
 * 除此之外返回 0。
 * <p>
 * 示例 1：
 * <p>
 * 输入：version1 = "1.2", version2 = "1.10"
 * <p>
 * 输出：-1
 * <p>
 * 解释：
 * <p>
 * version1 的第二个修订号为 "2"，version2 的第二个修订号为 "10"：2 < 10，所以 version1 < version2。
 * <p>
 * 示例 2：
 * <p>
 * 输入：version1 = "1.01", version2 = "1.001"
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 忽略前导零，"01" 和 "001" 都代表相同的整数 "1"。
 * <p>
 * 示例 3：
 * <p>
 * 输入：version1 = "1.0", version2 = "1.0.0.0"
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * version1 有更少的修订号，每个缺失的修订号按 "0" 处理。
 * <p>
 * 提示：
 * <p>
 * 1 <= version1.length, version2.length <= 500
 * version1 和 version2 仅包含数字和 '.'
 * version1 和 version2 都是 有效版本号
 * version1 和 version2 的所有修订号都可以存储在 32 位整数 中
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/compare-version-numbers/description/?envType=daily-question&envId=2025-09-23">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L165_CompareVersion {

    public static void main(String[] args) {
        L165_CompareVersion l165CompareVersion = new L165_CompareVersion();
        System.out.println(l165CompareVersion.compareVersion("1.2", "1.10"));
    }

    public int compareVersion(String version1, String version2) {
        String[] version1Split = version1.split("\\.");
        String[] version2Split = version2.split("\\.");
        int maxLength = Math.max(version1Split.length, version2Split.length);
        for (int i = 0; i < maxLength; i++) {
            int v1Num = i >= version1Split.length ? 0 : Integer.parseInt(version1Split[i]);
            int v2Num = i >= version2Split.length ? 0 : Integer.parseInt(version2Split[i]);
            if (v1Num > v2Num) {
                return 1;
            }else if (v1Num < v2Num) {
                return -1;
            }
        }
        return 0;
    }
}
