package com.accompnay.swordFingerOffer;

/**
 * @author Accompany
 * Date:2019/12/30
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 *
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Demo1{
    public static void main(String[] args) {
        boolean b = Find(-5, new int[][]{{-5}});
        System.out.println(b);
    }
    public static boolean Find(int target, int [][] array) {
        if (array==null||array.length==0||array[0].length==0){
            return false;
        }
        //根据最后一位查询
        int x = array[0].length-1;
        int y = 0;
        while (y<array.length){
            if (array[y][x]==target) {
                return true;
            }else if(array[y][x]<target){
                y++;
            }else if (binarysearch(array[y],target)){
                return true;
            }else {
                y++;
            }
        }
        return false;
    }
    public static boolean binarysearch(int [] arr,int target){
        int l = 0;
        int r = arr.length-1;
        int mid ;
        while (l<=r){
            mid=(l+r)/2;
            if (arr[mid]==target){
                return true;
            }else if(arr[mid]<target){
                l = mid+1;
            }else if (arr[mid]>target){
                r = mid -1;
            }
        }
        return false;
    }
}
