package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2211. 统计道路上的碰撞次数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 在一条无限长的公路上有 n 辆汽车正在行驶。汽车按从左到右的顺序按从 0 到 n - 1 编号，每辆车都在一个 独特的 位置
 * <p>
 * 给你一个下标从 0 开始的字符串 directions ，长度为 n 。directions[i] 可以是 'L'、'R' 或 'S'
 * 分别表示第 i 辆车是向 左 、向 右 或者 停留 在当前位置。每辆车移动时 速度相同
 * <p>
 * 碰撞次数可以按下述方式计算：
 * <p>
 * 当两辆移动方向 相反 的车相撞时，碰撞次数加 2 。
 * 当一辆移动的车和一辆静止的车相撞时，碰撞次数加 1 。
 * 碰撞发生后，涉及的车辆将无法继续移动并停留在碰撞位置。除此之外，汽车不能改变它们的状态或移动方向。
 * <p>
 * 返回在这条道路上发生的 碰撞总次数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：directions = "RLRSLL"
 * 输出：5
 * 解释：
 * 将会在道路上发生的碰撞列出如下：
 * - 车 0 和车 1 会互相碰撞。由于它们按相反方向移动，碰撞数量变为 0 + 2 = 2 。
 * - 车 2 和车 3 会互相碰撞。由于 3 是静止的，碰撞数量变为 2 + 1 = 3 。
 * - 车 3 和车 4 会互相碰撞。由于 3 是静止的，碰撞数量变为 3 + 1 = 4 。
 * - 车 4 和车 5 会互相碰撞。在车 4 和车 3 碰撞之后，车 4 会待在碰撞位置，接着和车 5 碰撞。碰撞数量变为 4 + 1 = 5 。
 * 因此，将会在道路上发生的碰撞总次数是 5 。
 * 示例 2：
 * <p>
 * 输入：directions = "LLRR"
 * 输出：0
 * 解释：
 * 不存在会发生碰撞的车辆。因此，将会在道路上发生的碰撞总次数是 0 。
 * <p>
 * 提示：
 * <p>
 * 1 <= directions.length <= 105
 * directions[i] 的值为 'L'、'R' 或 'S'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-collisions-on-a-road/description/?envType=daily-question&envId=2025-12-04">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2211_CountCollisions {
    public static void main(String[] args) {
        L2211_CountCollisions l2211CountCollisions = new L2211_CountCollisions();
        System.out.println(l2211CountCollisions.countCollisions("RLRSLL"));
        System.out.println(l2211CountCollisions.countCollisions("SRS"));
        System.out.println(l2211CountCollisions.countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));
        System.out.println(l2211CountCollisions.countCollisions("LLRR"));
    }

    public int countCollisions(String directions) {
        int l = 0;
        while (l < directions.length() && directions.charAt(l) == 'L') {
            l++;
        }
        int r = directions.length() - 1;
        while (r >= 0 && directions.charAt(r) == 'R') {
            r--;
        }
        int ans = 0;
        for (int i = l; i <= r; i++) {
            if (directions.charAt(i) != 'S') {
                ans++;
            }
        }
        return ans;
    }
}
