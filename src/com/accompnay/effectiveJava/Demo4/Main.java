package com.accompnay.effectiveJava.Demo4;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int sum = main.subtractProductAndSum(234);
        System.out.println(sum);
    }

    public int subtractProductAndSum(int n) {
        int add = 0, mul = 1;
        while (n>0){
            int i = n%10;
            n = n/10;
            add+=i;
            mul*=i;
        }
        return mul-add;
    }

}
