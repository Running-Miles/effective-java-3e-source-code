package effectivejava.chapter2.item2.hierarchicalbuilder;

import static effectivejava.chapter2.item2.hierarchicalbuilder.Pizza.Topping.*;
import static effectivejava.chapter2.item2.hierarchicalbuilder.NyPizza.Size.*;

import static effectivejava.chapter2.item2.hierarchicalbuilder.MyNyPizza.Size.LARGE;
import static effectivejava.chapter2.item2.hierarchicalbuilder.MyPizza.Topping.TOMATO;

// Using the hierarchical builder (Page 16)
public class PizzaTest {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();
        
        System.out.println(pizza);
        System.out.println(calzone);

        MyNyPizza myNyPizza = new MyNyPizza.Builder(LARGE)
                .addTopping(TOMATO).addTopping(MyPizza.Topping.ONION).build();

        System.out.println(myNyPizza);
    }
}
