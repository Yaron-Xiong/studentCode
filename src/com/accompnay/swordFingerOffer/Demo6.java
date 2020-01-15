package com.accompnay.swordFingerOffer;

/**
 * @author Accompany
 * Date:2020/1/14
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 解决方式1：
 * 暴力循环  时间复杂度：n
 * 解决方式2：
 * 排序数组  时间复杂度：n*logn 比暴力慢
 * 解决方式3：
 * 二分法变种 时间复杂度 logn 最优
 */
public class Demo6 {
    /*public int minNumberInRotateArray(int [] array) {
        if (array.length==0){
            return 0;
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i-1]>array[i]){
                return array[i];
            }
        }
        return array[0];
    }*/


    public int minNumberInRotateArray(int [] array) {
        //二分法
        if (array.length==0){
            return 0;
        }
        if (array.length==1){
            return array[0];
        }
        int l = 0;
        int r = array.length-1;
        while (l<=r){
            int mid = ((r-l)>>1) +l;
            if (array[mid]>array[mid+1]){
                return array[mid+1];
            }else if (array[mid]<array[mid-1]){
                return array[mid];
            }else if (array[mid]>=array[0]){
                l = mid+1;
            }else if(array[mid]<array[0]){
                r = mid-1;
            }
        }
        return array[0];
    }

    public static void main(String[] args) {
        Demo6 demo = new Demo6();
        int i =demo.minNumberInRotateArray(new int[]{3, 3, 3, 3, 3, 1, 3});
        System.out.println(i);
    }
}
