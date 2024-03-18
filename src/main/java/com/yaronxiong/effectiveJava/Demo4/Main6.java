package com.yaronxiong.effectiveJava.Demo4;

/**
 * @author Accompany
 * Date:2019/12/26
 */
public class Main6 {

    public static void main(String[] args) {
        int i = test();
        System.out.println(i);
    }
    public static int test(){

        int temp = 1;
        try {
            System.out.println(temp);
            return ++temp;
        }catch (Exception e){
            System.out.println(temp);
        }finally {
            ++temp;
            System.out.println(temp);
            return temp;
        }
    }
}
