import java.util.*;

public class Lab3 {
    static boolean isEmpty(int[] arr) {
        boolean isEmpty = arr.length == 0;
        if (isEmpty) {
            System.out.print("No data to process");
        }
        return isEmpty;
    }

    public static int calcOccurrenceNumber(int[] arr, int value) {
        if (isEmpty(arr)) {
            return -1;
        }
        int result;
        result = (int) Arrays.stream(arr).filter(s -> s == value).count();

        return result;
    }

    public static int findMax(int[] arr) {
        if (isEmpty(arr)) {
            return -1;
        }
        int result = 0;
        OptionalInt maxValue = Arrays.stream(arr).max();
        if (maxValue.isPresent()) {
            result = maxValue.getAsInt();
        }
        return result;
    }

    public static int calcMaxOccurrenceNumber(int[] arr) {
        if (isEmpty(arr)) {
            return -1;
        }
        int result;
        result = (int) Arrays.stream(arr).filter(s -> s == findMax(arr)).count();

        return result;
    }

    public static double calculatePiAccWallies(int iterationNo) {
        double result = 1.0;
        for (int i = 1; i <= iterationNo; i++) {
            result *= 4 * Math.pow(i, 2) / (4 * Math.pow(i, 2) - 1);
        }
        return 2 * result;
    }

    public static double calculatePiAccGregory(int iterationNo) {
        double result = 0.0;
        for (int i = 0; i <= iterationNo; i++) {
            result += Math.pow(-1, i) / (2 * i + 1);
        }
        return 4 * result;
    }


    public static void main(String[] args) {
        int[] testArray = {12, 12, -234, 2, 777, 12, 777};
        System.out.println("calculated maximal value is: " + findMax(testArray) + " should be 777");
        System.out.println("calculated number of occurrences is: " + calcOccurrenceNumber(testArray, 12) + " should be 3");
        System.out.println("calculated max number of occurrences is: " + calcMaxOccurrenceNumber(testArray) + " should be 2");

        double value;
        int iterationNo = 4;
        value = calculatePiAccWallies(iterationNo);
        System.out.println("Wallies for: " + iterationNo + "\t" + value);
        value = calculatePiAccGregory(iterationNo);
        System.out.println("Gregory for: " + iterationNo + "\t" + value);
        iterationNo = 20;
        value = calculatePiAccWallies(iterationNo);
        System.out.println("Wallies for: " + iterationNo + "\t" + value);
        value = calculatePiAccGregory(iterationNo);
        System.out.println("Gregory for: " + iterationNo + "\t" + value);
    }
}

