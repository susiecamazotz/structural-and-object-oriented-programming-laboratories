public class MainClass {

    public static void main(String[] args) {

        ProductType[] arr = new ProductType[5];

        arr[0] = new ProductType("FirstProduct", 20, "Red");
        arr[1] = new ProductType("2nd", 2000, "Orange");
        arr[2] = new ProductType("", 2000, "sd");
        arr[3] = new ProductType("", -20, "");
        arr[4] = new ProductType("5th", 0, "");


        System.out.println(arr[0].getName());
        System.out.println(arr[0].getItemPrice());
        System.out.println(arr[0].setItemPrice(32));
        System.out.println(arr[0].setName("1st product"));
        System.out.println(arr[0]);
        System.out.println(arr[0].isValid());
        System.out.println(arr[0].getName());
        System.out.println(arr[0].getItemPrice());
        System.out.println(arr[0].setItemPrice(32));
        System.out.println(arr[0].getItemPrice());
        System.out.println(arr[0].getPriceChangeNo());


        System.out.println();
        System.out.println();
        System.out.println(arr[2].getName());
        System.out.println(arr[2].getItemPrice());
        System.out.println(arr[2].setItemPrice(32));
        System.out.println(arr[2].setName("3rd product"));
        System.out.println(arr[2]);
        System.out.println(arr[2].isValid());
        System.out.println(arr[2].getName());
        System.out.println(arr[2].getItemPrice());
        System.out.println(arr[2].setItemPrice(32));
        System.out.println(arr[2].getItemPrice());
        System.out.println(arr[2].getPriceChangeNo());
        System.out.println(arr[2]);
        System.out.println(arr[2].isValid());
    }
}
