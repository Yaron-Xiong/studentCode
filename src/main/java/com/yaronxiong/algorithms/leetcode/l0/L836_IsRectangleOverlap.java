package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 836. 矩形重叠
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。矩形的上下边平行于 x 轴，左右边平行于 y 轴。
 * <p>
 * 如果相交的面积为 正 ，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * <p>
 * 给出两个矩形 rec1 和 rec2 。如果它们重叠，返回 true；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：rec1 = [0,0,1,1], rec2 = [2,2,3,3]
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * rect1.length == 4
 * rect2.length == 4
 * -109 <= rec1[i], rec2[i] <= 109
 * rec1 和 rec2 表示一个面积不为零的有效矩形
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/rectangle-overlap/description/?envType=daily-question&envId=2026-09-14">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L836_IsRectangleOverlap {
    public static void main(String[] args) {
        L836_IsRectangleOverlap l836IsRectangleOverlap = new L836_IsRectangleOverlap();
        System.out.println(l836IsRectangleOverlap.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1}));
        System.out.println(l836IsRectangleOverlap.isRectangleOverlap(new int[]{5, 15, 8, 18}, new int[]{0, 3, 7, 9}));
        System.out.println(l836IsRectangleOverlap.isRectangleOverlap(new int[]{7, 8, 13, 15}, new int[]{10, 8, 12, 20}));
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //将x轴和y轴投影到 x=0 和 y=0 的坐标中
        //对比两条横线的是否存在
        return isOverlap(rec1[0], rec1[2], rec2[0], rec2[2]) &&
                isOverlap(rec1[1], rec1[3], rec2[1], rec2[3]);
    }

    private boolean isOverlap(int a1, int a2, int b1, int b2) {
        return !(a2 <= b1 || b2 <= a1);
    }
}
