package product.exceptions;

public class ProductTypeEx {


    private String name;
    private double itemPrice;
    private final String comment;
    private int priceChangeNo = 0;
    private boolean valid = false;


    public ProductTypeEx(String name, double itemPrice, String comment) throws Exception {

        if (isNameValid(name)) {
            this.name = name;
        } else {
            throw new InvalidNameException();
        }

        if (isPriceValid(itemPrice)) {
            this.itemPrice = itemPrice;
        } else {
            throw new InvalidPriceException();
        }

        if (isCommentValid(comment)) {
            this.comment = comment;
        } else {
            throw new InvalidCommentException();
        }

        if (isNameValid(name) && isPriceValid(itemPrice) && isCommentValid(comment)) {
            valid = true;
        }
    }

    public static ProductTypeEx createDefaultObject(String name, double itemPrice, String comment) {

        try {
            return new ProductTypeEx(name, itemPrice, comment);
        } catch (InvalidNameException e) {
            e.printStackTrace();
            return createDefaultObject("DefaultName", itemPrice, comment);
        } catch (InvalidPriceException e) {
            e.printStackTrace();
            return createDefaultObject(name, 5, comment);
        } catch (InvalidCommentException e) {
            e.printStackTrace();
            return createDefaultObject(name, itemPrice, "NoComment");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    @Override
    public String toString() {
        return "ProductTypeEx{" + "name='" + name + '\'' + ", itemPrice=" + itemPrice + ", comment='" + comment + '\'' + ", priceChangeNo=" + priceChangeNo + ", valid=" + valid + '}';
    }


    public void testMe() {

        try {
            ProductTypeEx x1 = new ProductTypeEx("name1", 200, "comment");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        try {
            ProductTypeEx x2 = new ProductTypeEx("name2", 21, "");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        try {
            ProductTypeEx x3 = new ProductTypeEx("name3", 12312, "test");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        try {
            ProductTypeEx x4 = new ProductTypeEx("", 200, "test");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        try {
            ProductTypeEx x5 = new ProductTypeEx("name5", 200, "df");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    public static ProductTypeEx[] createTestDataEx() {
        ProductTypeEx[] array = new ProductTypeEx[3];

        try {
            array[0] = new ProductTypeEx("name", 123, "comment");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        try {
            array[1] = new ProductTypeEx("name2", 13132, "comment");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        try {
            array[2] = new ProductTypeEx("name", 123, "comment4");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return array;
    }

    public static ProductTypeEx[] createTestData() {
        ProductTypeEx[] array = new ProductTypeEx[5];

        try {
            array[0] = new ProductTypeEx("name", 123, "comment");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        try {
            array[1] = new ProductTypeEx("name2", 321313, "comment");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        try {
            array[2] = new ProductTypeEx("", 123, "comment4");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        try {
            array[3] = new ProductTypeEx("", 1111, "comment");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        try {
            array[4] = new ProductTypeEx("name", 123, "comment4");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return array;
    }


    private boolean isPriceValid(double price) {
        return (price >= 0 && price <= 200);
    }

    private boolean isNameValid(String name) {
        return (name != null && !name.trim().equals(""));
    }

    private boolean isCommentValid(String comment) {

        return (comment != null && !comment.trim().equals(""));
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
