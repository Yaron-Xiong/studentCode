package com.accompnay.work;

import java.util.*;
import java.util.stream.Collectors;

public class Expression {

    private Queue<Method> methodQueue;

    private Map<String, Fun> funMap;


    public Expression(Queue<Method> methodQueue, Map<String, Fun> funMap) {
        this.methodQueue = methodQueue;
        this.funMap = funMap;
    }

    public Object calculate(Map<String, Object> params) {
        Map<String, Object> methodResult = new HashMap<>();
        Method method;
        Object result = null;
        while ((method = methodQueue.poll()) != null) {
            Fun fun = funMap.get(method.getName());
            List<Object> paramsList = method.getParams().stream().map(paramName -> {
                Object param ;
                if (paramName.contains("#")) {
                    param = methodResult.get(paramName);
                }else {
                    param = params.get(paramName);
                }
                return param;
            }).collect(Collectors.toList());
            result = fun.execute(paramsList);
            System.out.println(method.getName()+"的结果为"+result);
            methodResult.put("#" + method.getName(), result);
        }
        return result;
    }
}
