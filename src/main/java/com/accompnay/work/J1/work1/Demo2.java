package com.accompnay.work.J1.work1;

import java.util.HashMap;
import java.util.Map;

public class Demo2 {
    public static void main(String[] args) {
        ExpressionBuilder builder = new ExpressionBuilder();

        // 绑定函数
        builder.addFunc("f1",  new MultipleFun());
        builder.addFunc("f2",  new AddFun());
        builder.addFunc("f3",  new AddFun());
        builder.addFunc("f4",  new AddFun());
        builder.addFunc("f5",  new AddFun());

        // 指定要计算的表达式
        //"f1(x,f2(x,f5(p,o,u),z),f3(q,w,e,f4(r,t,y)))"
        Expression expression = builder.buildExpression("f1(x,f2(x,f5(p,o,u),z),f3(q,w,e,f4(r,t,y)))");

        // 绑定参数
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("x", 4);
        params.put("y", 5);
        params.put("z", 7);
        params.put("p", 7);
        params.put("o", 7);
        params.put("u", 7);
        params.put("q", 7);
        params.put("w", 7);
        params.put("e", 7);
        params.put("r", 7);
        params.put("t", 7);

        Object value = expression.calculate(params);
        System.out.println(value);//64
    }
}
