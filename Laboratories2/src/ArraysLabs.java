import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysLabs {
    static boolean isArrEmpty(int[] arr) {
        boolean isEmpty = arr.length == 0;
        if (isEmpty) {
            System.out.print("No data to process");
        }
        return isEmpty;
    }

    static boolean isArrEmpty(int[][] arr) {
        boolean isEmpty = arr.length == 0;
        if (isEmpty) {
            System.out.print("No data to process");
        }
        return isEmpty;
    }

    static void printMaxValue(int[] arr) {
        if (isArrEmpty(arr)) {
            return;
        }
        IntStream intsStream = Arrays.stream(arr);
        OptionalInt maxValue = intsStream.max();
        if (maxValue.isPresent()) {
            System.out.println("Max value 1D array: " + maxValue.getAsInt());
        }

    }

    static void printMaxValue(int[][] arr) {
        if (isArrEmpty(arr)) {
            return;
        }
        IntStream intsStream = Arrays.stream(arr).flatMapToInt(Arrays::stream);
        OptionalInt maxValue = intsStream.max();
        if (maxValue.isPresent()) {
            System.out.println("Max value 2D array: " + maxValue.getAsInt());
        }
    }

    static int getOccurrenceNumber(int[] arr) {
        if (arr.length == 0) {
            System.out.print("No data to process ");
            return -1;
        }
        IntStream intsStream = Arrays.stream(arr);
        return (int) (intsStream.filter(p -> p == 23).count());
    }

    static void printMostCommonDigit(int[] arr) {
        if (isArrEmpty(arr)) return;
        List<Integer> listOfInts = Arrays.stream(arr).boxed().toList();
        int[] digits = new int[10];
        for (int number : listOfInts) {
            while (number > 0) {
                digits[number % 10]++;
                number /= 10;
            }
        }
        int maxNumberOfDigits = 0, mostCommonDigit = -1;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > maxNumberOfDigits) {
                maxNumberOfDigits = digits[i];
                mostCommonDigit = i;
            }
        }
        System.out.println("Most common digit in 1D array: " + mostCommonDigit);

    }

    static void printMostCommonDigit(int[][] arr) {
        if (isArrEmpty(arr)) return;
        List<Integer> listOfInts = Arrays.stream(arr).flatMapToInt(Arrays::stream).boxed().toList();

        int[] digits = new int[10];
        for (int number : listOfInts) {
            while (number > 0) {
                digits[number % 10]++;
                number /= 10;
            }
        }
        int maxNumberOfDigits = 0, mostCommonDigit = 0;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > maxNumberOfDigits) {
                maxNumberOfDigits = digits[i];
                mostCommonDigit = i;
            }
        }
        System.out.println("Most common digit in 2D array: " + mostCommonDigit);

    }

    static void printMostCommonNumber(int[][] arr) {
        if (isArrEmpty(arr)) return;
        List<Integer> listOfInts = Arrays.stream(arr).flatMapToInt(Arrays::stream).boxed().sorted().toList();

        int mostCommonNumber = listOfInts.get(0), mostCommonNumberCounter = 1, currentNumberCounter = 1;
        for (int i = 1; i < listOfInts.size(); i++) {
            if (listOfInts.get(i).equals(listOfInts.get(i - 1))) {
                currentNumberCounter++;
            } else {
                if (currentNumberCounter > mostCommonNumberCounter) {
                    mostCommonNumberCounter = currentNumberCounter;
                    mostCommonNumber = listOfInts.get(i - 1);
                }
                currentNumberCounter = 1;
            }
        }
        System.out.println("Most common number in array: " + mostCommonNumber);
    }

    static void printSorted(int[] arr) {
        IntStream integerStream = Arrays.stream(arr);
        integerStream.sorted().forEach(s -> System.out.print(s + " "));
    }

    public static void main(String[] args) {

        int[] oneDim = {1, 10, 23, 87, 14, 1, 6, 177, 71};
        int[][] twoDim = {{1, 2, 12, 2}, {87}, {7, 12, 14}, {1, 8, 9, 8, 8}};
        printMaxValue(oneDim);
        printMaxValue(twoDim);
        System.out.println("Index of array of number occurrence: " + getOccurrenceNumber(oneDim));
        printMostCommonDigit(oneDim);
        printMostCommonDigit(twoDim);
        printMostCommonNumber(twoDim);
        printSorted(oneDim);
    }
}