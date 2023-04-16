package com.laboratories8;

public class Item {

    private String name;
    private final double weight;

    public Item(String name, double weight) throws Exception {

        if (isNameValid(name)) {
            this.name = name;
        } else {
            throw new Exception("Name is not valid " + name);
        }


        if (isWeightValid(weight)) {
            this.weight = weight;
        } else {
            throw new Exception("Weight is not valid " + weight);
        }

    }

    @Override
    public String toString() {
        return "Item{" + "name='" + name + '\'' + ", weight=" + weight + '}';
    }

    private boolean isNameValid(String name) {
        return name != null && !name.trim().equals("");
    }

    private boolean isWeightValid(double weight) {
        return weight >= 0.1 && weight <= 20.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (isNameValid(name)) {
            this.name = name;
        }
    }

    public double getWeight() {

        return weight;
    }

}
