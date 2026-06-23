package effectivejava.chapter2.item2.builder;

public class MyNutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;

        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public MyNutritionFacts.Builder calories(int val) {
            calories = val;
            return this;
        }

        public MyNutritionFacts.Builder fat(int val) {
            fat = val;
            return this;
        }

        public MyNutritionFacts.Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public MyNutritionFacts.Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public MyNutritionFacts build() {
            return new MyNutritionFacts(this);
        }
    }

    private MyNutritionFacts(MyNutritionFacts.Builder builder) {
        servingSize  = builder.servingSize;
        servings     = builder.servings;
        calories     = builder.calories;
        fat          = builder.fat;
        sodium       = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        // new MyNutritionFacts.Builder(240, 8)创建并返回了Builder对象，接下来链式调用即可
        MyNutritionFacts cocaCola = new MyNutritionFacts.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
    }
}
