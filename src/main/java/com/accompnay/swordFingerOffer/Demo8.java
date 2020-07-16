package com.accompnay.swordFingerOffer;

/**
 * @author Accompany
 * Date:2020/1/14
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 与Demo7(斐波那契数列)相似，可以缓存结果
 *
 * 解决方案1：
 * 暴力递归  时间复杂度 n^2
 * 解决方案2：
 * 记忆化递归
 */
public class Demo8 {
    /*
    暴力递归
    int count = 0;
    public int JumpFloor(int target) {
        if (target<=2){
            return target;
        }
        return count+JumpFloor(target-1)+JumpFloor(target-2);
    }*/
    
    public int JumpFloor(int target) {
        int[] cache = new int[target + 1];
        return num(0,target,cache);
    }
    public int num(int cur ,int target,int [] cache){
        if (cur>target){
            return 0;
        }
        if (cur==target){
            return 1;
        }
        if (cache[cur]>0){
            //说明缓存有数据
            return cache[cur];
        }
        cache[cur] = num(cur + 1, target, cache) + num(cur + 2, target, cache);
        return cache[cur] ;
    }
    public static void main(String[] args) {
        Demo8 demo8 = new Demo8();
        int i = demo8.JumpFloor(46);
        System.out.println(i);
    }

}
