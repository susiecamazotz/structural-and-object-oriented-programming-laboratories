package com.laboratories8;

public class MainClass {
    public static void main(String[] args) {

        try {
            Bag bag = new Bag(5, 10);
            System.out.println(bag);

            Item item1 = new Item("item1", 2);
            Item item2 = new Item("item2", 2);
            Item item3 = new Item("item3", 1);

            bag.putIn(item1);
            bag.putIn(item3);
            bag.putIn(item2);
            System.out.println(bag);
            bag.removeTheHeaviest();
            System.out.println(bag);


            bag.removeAllItems();
            System.out.println(bag);
            System.out.println(bag.isEmpty());
            System.out.println(bag.isFull());

        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("\n");
        try {
            HandHoldBag handBag = new HandHoldBag(1, false);
            System.out.println(handBag);


            Item item1 = new Item("item1", 1.2);
            Item item2 = new Item("item2", 0.2);
            Item item3 = new Item("item3", 0.1);

            System.out.println(handBag.putIn(item1));
            handBag.putIn(item3);
            handBag.putIn(item2);
            System.out.println(handBag);
            handBag.removeTheHeaviest();
            System.out.println(handBag);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("\n");
        try {
            ShoppingBag shoppingBag = new ShoppingBag(20, false);
            System.out.println(shoppingBag);

            Item item1 = new Item("item1", 2);
            Item item2 = new Item("item2", 2);
            Item item3 = new Item("item3", 1);

            shoppingBag.putIn(item1);
            shoppingBag.putIn(item3);
            shoppingBag.putIn(item2);
            System.out.println(shoppingBag);
            shoppingBag.removeTheHeaviest();
            System.out.println(shoppingBag);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
