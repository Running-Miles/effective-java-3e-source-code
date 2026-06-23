package effectivejava.chapter2.item3.staticfactory;

public class MyElvis {
    private static final MyElvis INSTANCE = new MyElvis();

    private MyElvis() {
    }

    public static MyElvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa Miles, I'm outta here!");
    }

    public static void main(String[] args) {
        MyElvis myElvis = MyElvis.getInstance();
        myElvis.leaveTheBuilding();
    }
}
