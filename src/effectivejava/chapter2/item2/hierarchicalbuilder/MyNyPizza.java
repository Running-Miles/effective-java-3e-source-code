package effectivejava.chapter2.item2.hierarchicalbuilder;

import java.util.Objects;

public class MyNyPizza extends MyPizza{
    public enum Size { SMALL, MEDIUM, LARGE }
    private final Size size;

    public static class Builder extends MyPizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override public MyNyPizza build() {
            return new MyNyPizza(this);
        }

        @Override protected Builder self() { return this; }
    }

    private MyNyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override public String toString() {
        return "My New York Pizza with " + toppings;
    }
}
