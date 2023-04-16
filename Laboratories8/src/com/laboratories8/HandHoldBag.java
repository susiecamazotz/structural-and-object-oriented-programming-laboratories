package com.laboratories8;

public class HandHoldBag extends Bag {
    private final boolean premiumQuality;

    public HandHoldBag(double maxWeight, boolean premiumQuality) throws Exception {
        super(5, maxWeight);


        if (!isMaxWeightValid(maxWeight)) {
            throw new Exception("MaxWeight is invalid " + maxWeight);
        }

        this.premiumQuality = premiumQuality;

    }


    @Override
    public String toString() {
        return "HandHoldBag." + super.toString() + " premiumQuality=" + premiumQuality + '}';
    }

    private boolean isMaxWeightValid(double maxWeight) {

        return maxWeight >= 0.1 && maxWeight <= 2;
    }
}
