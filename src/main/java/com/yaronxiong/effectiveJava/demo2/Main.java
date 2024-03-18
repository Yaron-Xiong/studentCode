package com.yaronxiong.effectiveJava.demo2;

public class Main {
    public static void main(String[] args) {
        MyPizza pizza = (MyPizza) new MyPizza.Builder(MyPizza.Size.SMALL).addTopping(BasePizza.Topping.SAUSAGE).addTopping(BasePizza.Topping.ONION).build();
        System.out.println(pizza);
    }
}
