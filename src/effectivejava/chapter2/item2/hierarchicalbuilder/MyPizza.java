package effectivejava.chapter2.item2.hierarchicalbuilder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

//定义抽象类
public abstract class MyPizza {
    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE, TOMATO }

    //配料不变且不重复
    final Set<Topping> toppings;

    //Simulated Self-Type 方便链式调用 不会丢失字类型
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping){
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract MyPizza build();

        //每个子类构建器(Builder)必须重写这个方法返回this
        protected abstract T self();
    }

    //构造函数
    MyPizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}