package com.yaronxiong.effectiveJava.demo;

 class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Build{
        //必要参数
        private final int servingSize;
        private final int servings;
        //可选参数
        private  int calories =0;
        private  int fat = 0;
        private  int sodium =0;
        private  int carbohydrate=0;

        public Build(int servingSize,int servings){
            this.servingSize =servingSize;
            this.servings = servings;
        }
        public Build calories(int calories){
            this.calories = calories;
            return this;
        }
        public Build fat(int fat){
            this.fat = fat;
            return this;
        }
        public Build sodium(int sodium){
            this.sodium = sodium;
            return this;
        }
        public Build carbohydrate(int carbohydrate){
            this.carbohydrate = carbohydrate;
            return this;
        }
        public NutritionFacts build (){
            return new NutritionFacts(this);
        }
    }


    private NutritionFacts(Build build){
        this.servingSize = build.servingSize;
        this.carbohydrate = build.carbohydrate;
        this.sodium = build.sodium;
        this.fat = build.fat;
        this.calories = build.calories;
        this.servings = build.servings;
    }
    @Override
    public String toString() {
        return "NutritionFacts{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }
}
