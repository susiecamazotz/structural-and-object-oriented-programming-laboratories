package test;

public class Main {
    public static void main(String[] args) {
        BaseClass base = new BaseClass("John", 15);
        DerivedClass derived = new DerivedClass("Mike", "Wazowski", 20);

        base.printNumber(3);
        System.out.println();
        derived.printNumber(10);


        System.out.println(base);

        derived.presentYourself();
        System.out.println(derived);


        System.out.println(base.getClass());
        base = derived;
        System.out.println("change  " + base.getClass());


        base.printNumber(2);
        System.out.println();

        System.out.println(base);
        System.out.println(base.getClass());

        BaseClass x = new DerivedClass("Dwight", "Office", 20);
        System.out.println(x);
        x.printNumber(4);


    }
}
