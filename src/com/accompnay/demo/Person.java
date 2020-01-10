package com.accompnay.demo;

import java.util.Date;

public class Person {
    private final int age;
    private final String name;
    private final Date birthday;
    Person(Build build) {
        this.age = build.age;
        this.name = build.name;
        this.birthday = build.birthday;
    }


     static class Build {
        //必要参数不可变
        private final String name;
        //可选参数是可变的
        private int age;
        private Date birthday;

        Build(String name) {
            this.name = name;
        }

        public Build setAge(int age) {
            this.age = age;
            return this;
        }

        public Build setBirthday(Date birthday) {
            this.birthday = birthday;
            return this;
        }
    }


    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public static void f (){

    }
}
