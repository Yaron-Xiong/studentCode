package com.accompnay.effectiveJava.demo2;

public class Calzone extends BasePizza {
    private final boolean sauceInside;
    public static class Builder extends BasePizza.BaseBuilder<Builder>{
        private boolean sauceInside = false;
        public Builder sauceInside(){
            sauceInside = true;
            return this;
        }
        @Override
        BasePizza build() {
            return new Calzone(this);
        }

        @Override
        Builder self() {
            return this;
        }
    }

    private Calzone(Builder builder){
        super(builder);
        this.sauceInside = builder.sauceInside;
    }
}
