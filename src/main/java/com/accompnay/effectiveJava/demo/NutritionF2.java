package com.accompnay.effectiveJava.demo;

import java.util.Date;

public class NutritionF2 {

    private String str = "你才";

    public NutritionF2(){
        System.out.println("xxx");
    }

    public void test(){
        Person.Build build = new Person.Build("张三").setBirthday(new Date()).setAge(15);
        Person person = new Person(build);
        System.out.println(person);
    }

    class F{
        private int a = 1;
        F(){
            System.out.println("F 你好"+str);
        }
    }

    public static void main(String[] args) {
        NutritionF2 f2 = new NutritionF2();
    }
}
