package com.laboratories8;

public class ShoppingBag extends Bag {
    private final boolean extremelyRobust;

    public ShoppingBag(double maxWeight, boolean extremelyRobust) throws Exception {
        super(30, maxWeight);

        this.extremelyRobust = extremelyRobust;
    }

    @Override
    public String toString() {
        return "ShoppingBag." + super.toString() + " extremelyRobust=" + extremelyRobust + '}';
    }
}
