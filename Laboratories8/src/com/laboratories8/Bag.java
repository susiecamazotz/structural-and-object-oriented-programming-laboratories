package com.laboratories8;

import java.util.Arrays;

public class Bag {

    private int bagCapacity;
    private final double maxWeight;
    private Item[] items;

    Bag(int bagCapacity, double maxWeight) throws Exception {

        if (isBagCapacityValid(bagCapacity)) {
            setBagCapacity(bagCapacity);
        } else {
            throw new Exception("BagCapacity is invalid " + bagCapacity);
        }

        if (isMaxWeightValid(maxWeight)) {
            this.maxWeight = maxWeight;
        } else {
            throw new Exception("MaxWeight is invalid " + maxWeight);
        }

    }

    public void removeAllItems() {

        for (int i = 0; i < getBagCapacity(); i++) {
            items[i] = null;
        }
    }

    public boolean putIn(Item item) {

        if (!isFull() && isItemNotNull(item) && getTotalWeight() + item.getWeight() <= maxWeight) {

            items[getItemNo()] = item;
            return true;
        }

        return false;
    }

    public int getItemNo() {
        int itemCounter = 0;

        for (Item item : items) {

            if (item != null) {
                itemCounter++;
            }
        }

        return itemCounter;
    }

    public double getTotalWeight() {
        double totalWeight = 0;

        for (Item item : items) {

            if (isItemNotNull(item)) {
                totalWeight += item.getWeight();
            }
        }

        return totalWeight;
    }

    public boolean isFull() {
        return getItemNo() == bagCapacity;
    }

    public boolean isEmpty() {

        return getItemNo() != bagCapacity;
    }

    public void reorderBag() {
        int nullCounter = 0;

        for (int i = 0; i < bagCapacity; i++) {

            if (items[i] == null) {
                nullCounter++;
            } else if (nullCounter > 0) {
                items[i - nullCounter] = items[i];
                items[i] = null;
            }
        }
    }

    public void removeTheHeaviest() {
        double heaviestWeight = Double.MIN_VALUE;

        for (Item item : items) {

            if (isItemNotNull(item) && item.getWeight() > heaviestWeight) {
                heaviestWeight = item.getWeight();
            }
        }

        for (int i = 0; i < getBagCapacity(); i++) {

            if (isItemNotNull(items[i]) && items[i].getWeight() == heaviestWeight) {
                items[i] = null;
            }
        }

        reorderBag();

    }


    @Override
    public String toString() {
        return "Bag{" + "bagCapacity=" + bagCapacity + ", maxWeight=" + maxWeight + ", items=" + Arrays.toString(items) + '}';
    }

    private boolean isBagCapacityValid(int bagCapacity) {

        return bagCapacity >= 1 && bagCapacity <= 50;
    }

    private boolean isMaxWeightValid(double maxWeight) {

        return maxWeight >= 0.1 && maxWeight <= 20;
    }

    public int getBagCapacity() {
        return bagCapacity;
    }

    public void setBagCapacity(int bagCapacity) {

        if (isBagCapacityValid(bagCapacity)) {
            this.bagCapacity = bagCapacity;
            items = new Item[bagCapacity];
        }

    }

    public double getMaxWeight() {
        return maxWeight;
    }

    private boolean isItemNotNull(Item item) {
        return item != null;
    }


}
