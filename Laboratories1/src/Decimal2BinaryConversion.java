public class Decimal2BinaryConversion {
    public static void main(String[] args) {
        int[] testData = {7, 10, 15, 12345};
        int number2Convert;
        for (int testDatum : testData) {
            StringBuilder result = new StringBuilder();
            number2Convert = testDatum;
            while (number2Convert > 0) {
                int remainder = number2Convert % 2;
                result.insert(0, remainder);
                number2Convert = number2Convert / 2;
            }
            System.out.println(testDatum + " ==> " + result);
        }
    }
}