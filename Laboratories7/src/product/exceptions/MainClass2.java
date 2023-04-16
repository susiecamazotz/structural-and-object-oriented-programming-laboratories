package product.exceptions;


import java.util.Optional;

public class MainClass2 {

    public static void main(String[] args) {

        ProductType[] arr1 = ProductType.createTestData3();
        ProductType[] arr2 = ProductType.createTestData5();

        ProductTypeEx[] arr3 = new ProductTypeEx[0];
        ProductTypeEx[] arr4 = new ProductTypeEx[0];

        String name = "", comment = "";
        int price = 12;


        try {
            ProductTypeEx y = new ProductTypeEx(name, price, comment);
            System.out.println(y);
        } catch (Exception e) {
            ProductTypeEx x = ProductTypeEx.createDefaultObject(name, price, comment);
            System.out.println(x);
        }
    }

    private static Optional<ProductTypeEx> getProduct(String name, int price, String comment) {
        try {
            ProductTypeEx productTypeEx = new ProductTypeEx(name, price, comment);
            return Optional.of(productTypeEx);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

}
