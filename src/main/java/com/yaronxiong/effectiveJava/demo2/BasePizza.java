package com.yaronxiong.effectiveJava.demo2;

import java.util.EnumSet;
import java.util.Set;

public abstract class BasePizza {
    public enum Topping {HAM,MUSHROOM,ONION,PEPPER,SAUSAGE}
    final Set<Topping> toppings;

    abstract static class BaseBuilder<T extends BaseBuilder<T>>{
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping){
            toppings.add(topping);
            return self();
        }
        abstract BasePizza build();
        abstract T self();
    }
    BasePizza(BaseBuilder<?> builder){
        toppings = builder.toppings.clone();
    }
}
