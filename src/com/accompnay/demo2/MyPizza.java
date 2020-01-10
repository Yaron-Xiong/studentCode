package com.accompnay.demo2;

import java.util.Objects;

public class MyPizza extends BasePizza {
    public enum Size {SMALL,MEDIUM,LARGE}
    private final Size size;

    public static class Builder extends BaseBuilder<Builder>{
        private final Size size;

        public Builder(Size size){
            this.size = Objects.requireNonNull(size);
        }

        @Override
        BasePizza build() {
            return new MyPizza(this);
        }

        @Override
        Builder self() {
            return this;
        }
    }
    private MyPizza(Builder builder) {
        super(builder);
        this.size = builder.size;
    }

    @Override
    public String toString() {
        return "MyPizza{" +
                "size=" + size +
                ", toppings=" + toppings +
                '}';
    }
}


