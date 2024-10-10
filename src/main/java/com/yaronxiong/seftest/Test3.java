package com.yaronxiong.seftest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.BlockingQueue;

public class Test3 {
    public static class Student{
        private String name;
        private int age;
        public Student(String name,int age) {
            this.name = name;
            this.age = age;
        }
        public int getAge() {
            return age;
        }
        public Student setAge(int age) {
            this.age = age;
            return this;
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = new Student("张三", 18);
        String string = objectMapper.writeValueAsString(student);
        System.out.println(string);
    }
}
