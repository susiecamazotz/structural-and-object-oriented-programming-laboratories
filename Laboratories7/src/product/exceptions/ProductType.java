package product.exceptions;

public class ProductType {

    private String name = "not_known";
    private double itemPrice = 0.0;
    private String comment = "none";
    private int priceChangeNo = 0;
    private boolean valid = false;


    public ProductType(String name, double itemPrice, String comment) {

        if (isNameValid(name)) {
            this.name = name;
        }

        if (isPriceValid(itemPrice)) {
            this.itemPrice = itemPrice;
        }

        if (isCommentValid(comment)) {
            this.comment = comment;
        }

        if (isNameValid(name) && isPriceValid(itemPrice) && isCommentValid(comment)) {
            valid = true;
        }
    }

    @Override
    public String toString() {
        return "ProductType{" + "name='" + name + '\'' + ", itemPrice=" + itemPrice + ", comment='" + comment + '\'' + ", priceChangeNo=" + priceChangeNo + ", valid=" + valid + '}';
    }

    public static ProductType[] createTestData3() {
        ProductType[] array = new ProductType[3];

        array[0] = new ProductType("name", 123, "comment");

        array[1] = new ProductType("name2", 13132, "comment");

        array[2] = new ProductType("name", 123, "comment4");

        return array;
    }

    public static ProductType[] createTestData5() {
        ProductType[] array = new ProductType[5];

        array[0] = new ProductType("name", 123, "comment");

        array[1] = new ProductType("name2", 321313, "comment");

        array[2] = new ProductType("", 123, "comment4");

        array[3] = new ProductType("", 1111, "comment");

        array[4] = new ProductType("name", 123, "comment4");

        return array;
    }


    private boolean isPriceValid(double price) {
        return (price >= 0 && price <= 200);
    }

    private boolean isNameValid(String name) {
        return (name != null && !name.equals(""));
    }

    private boolean isCommentValid(String comment) {
        return (comment != null && !comment.equals(""));
    }

    public boolean isValid() {
        return valid;
    }


    public String getName() {
        return name;
    }

    public int getPriceChangeNo() {
        return priceChangeNo;
    }

    public double getItemPrice() {
        return itemPrice;
    }


    public boolean setName(String name) {

        if (isNameValid(name)) {
            this.name = name;

            return true;
        }

        return false;
    }

    public boolean setItemPrice(double price) {

        if (isPriceValid(price)) {
            this.itemPrice = price;
            priceChangeNo++;

            return true;
        }

        return false;
    }
}
