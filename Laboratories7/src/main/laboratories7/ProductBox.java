package main.laboratories7;

public class ProductBox {
    private ProductType[] regularStore;
    private ProductTypeEx[] exStore;

    public ProductBox() {
    }

    public boolean setRegular(ProductType[] data) {

        if (data != null) {
            regularStore = data;
            return true;
        }
        return false;
    }

    public boolean setEx(ProductTypeEx[] data) {

        if (data != null) {
            exStore = data;
            return true;
        }
        return false;
    }

    public Double calcAveragePrice() {
        double sum = 0;

        for (ProductType productType : regularStore) {
            sum += productType.getItemPrice();
        }

        if (regularStore.length != 0) {
            return sum / regularStore.length;
        }

        return Double.NaN;
    }

    public Double calcAveragePriceEx() {
        double sum = 0;
        int validItems = 0;

        for (ProductTypeEx productTypeEx : exStore) {
            if (productTypeEx != null) {
                sum += productTypeEx.getItemPrice();
                validItems++;
            }
        }

        if (validItems != 0) {
            return sum / validItems;
        }

        return Double.NaN;
    }
}
