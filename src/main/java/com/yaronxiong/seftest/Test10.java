package com.yaronxiong.seftest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Test10 {
    public interface Student {
        String test(String name);
    }

    public static class Invoker implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(method.getDeclaringClass());
            System.out.println(Arrays.stream(method.getParameters()).map(Parameter::getName).collect(Collectors.toList()));
            method.invoke(this);
            return "代理的目标方法";
        }
    }

    public static void main(String[] args) {
        System.out.println(java.security.Security.getProperty("networkaddress.cache.ttl"));
        System.out.println(System.getSecurityManager());
        Student s = (Student) Proxy.newProxyInstance(Test10.class.getClassLoader(), new Class[]{Student.class}, new Invoker());
        String test = s.test("asd");
        System.out.println(test);
    }
}
