import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Stream;

public class ArraysPackage {

    private static final Scanner scKeyboard = new Scanner(System.in);

    public static boolean isArrEmpty(int[] arr) {
        boolean isEmpty = arr.length == 0;
        if (isEmpty) {
            System.out.print("No data to process ");
        }
        return isEmpty;
    }

    public static int[] readArray(int size) {
        int[] arr;
        if (size >= 0) {
            arr = new int[size];
        } else {
            arr = new int[0];
        }
        for (int i = 0; i < size; i++) {
            if (scKeyboard.hasNext()) {
                try {
                    arr[i] = scKeyboard.nextInt();
                } catch (Exception error) {
                    scKeyboard.next();
                    i--;
                }
            } else {
                arr[i] = 0;
            }
        }
        return arr;
    }

    public static int[] appendArrays(int[] a1, int[] a2) {
        int[] arr;
        arr = Stream.concat(Arrays.stream(a1).boxed(), Arrays.stream(a2).boxed()).mapToInt(i -> i).toArray();
        return arr;
    }

    public static int getMinimalElement(int[] inArr) {
        int minValue = Integer.MIN_VALUE;
        OptionalInt minimalValue = Arrays.stream(inArr).min();
        if (minimalValue.isPresent()) {
            minValue = minimalValue.getAsInt();
        } else {
            isArrEmpty(inArr);
        }
        return minValue;

    }

    public static int[] getMinimalElements(int[] inArr) {
        if (isArrEmpty(inArr)) {
            return inArr;
        }
        int[] arr;
        int minValue = getMinimalElement(inArr);
        int counter = 0;
        for (int j : inArr) {
            if (j == minValue) {
                counter++;
            }
        }
        arr = new int[counter];
        Arrays.fill(arr, minValue);
        return arr;
    }

    public static int[] getGreaterThan(int[] inArr, int limit) {
        if (isArrEmpty(inArr)) {
            return inArr;
        }
        int[] arr;
        arr = Arrays.stream(inArr).filter(s -> s >= limit).toArray();
        return arr;

    }

    public static int[] getLessThan(int[] inArr, int limit) {
        if (isArrEmpty(inArr)) {
            return inArr;
        }
        int[] arr;
        arr = Arrays.stream(inArr).filter(s -> s <= limit).toArray();
        return arr;
    }

    public static int[] getRange(int[] inArr, int lowerLimit, int upperLimit) {
        if (isArrEmpty(inArr)) {
            return inArr;
        }
        int[] greaterArr;
        int[] finalArr;
        greaterArr = getGreaterThan(inArr, lowerLimit);
        finalArr = getLessThan(greaterArr, upperLimit);
        return finalArr;
    }

    public static int elementCount(int[] inArr, int what2Look4) {
        if (inArr.length == 0) {
            return 0;
        }
        int counter;
        counter = (int) Arrays.stream(inArr).filter(s -> s == what2Look4).count();
        return counter;
    }

    public static int howManyUniqueElementsInArrays(int[] a1, int[] a2) {
        int uniqueElementsCounter = 0;
        Arrays.sort(a1);
        Arrays.sort(a2);
        if (a1.length != 0 && elementCount(a2, a1[0]) == 0) {
            uniqueElementsCounter++;
        }
        if (a2.length != 0 && elementCount(a1, a2[0]) == 0) {
            uniqueElementsCounter++;
        }
        for (int i = 1; i < a1.length || i < a2.length; i++) {
            if (i < a1.length && a1[i] != a1[i - 1] && elementCount(a2, a1[i]) == 0) {
                uniqueElementsCounter++;
            }
            if (i < a2.length && a2[i] != a2[i - 1] && elementCount(a1, a2[i]) == 0) {
                uniqueElementsCounter++;
            }
        }
        return uniqueElementsCounter;
    }

    public static int[] uniqueElements(int[] a1, int[] a2) {
        int[] arr;
        if (a1.length == 0 && a2.length == 0) {
            arr = new int[0];
            return arr;
        }
        arr = new int[howManyUniqueElementsInArrays(a1, a2)];
        int index = 0;
        if (a1.length > 0 && elementCount(a2, a1[0]) == 0) {
            arr[index] = a1[0];
            index++;
        }
        if (a2.length > 0 && elementCount(a1, a2[0]) == 0) {
            arr[index] = a2[0];
            index++;
        }
        for (int i = 1; i < a1.length || i < a2.length; i++) {
            if (i < a1.length && a1[i] != a1[i - 1] && elementCount(a2, a1[i]) == 0) {
                arr[index] = a1[i];
                index++;
            }
            if (i < a2.length && a2[i] != a2[i - 1] && elementCount(a1, a2[i]) == 0) {
                arr[index] = a2[i];
                index++;
            }
        }
        Arrays.sort(arr);
        return arr;
    }

    public static int howManyCommonElementsInArrays(int[] a1, int[] a2) {
        int commonElementsCounter = 0;
        if (elementCount(a2, a1[0]) != 0) {
            commonElementsCounter++;
        }
        for (int i = 1; i < a1.length; i++) {
            if (a1[i] != a1[i - 1]) {
                if (elementCount(a2, a1[i]) != 0) {
                    commonElementsCounter++;
                }
            }
        }
        return commonElementsCounter;
    }

    public static int[] commonElements(int[] a1, int[] a2) {
        int[] arr;
        if (a1.length == 0 || a2.length == 0) {
            arr = new int[0];
            return arr;
        }
        arr = new int[howManyCommonElementsInArrays(a1, a2)];
        int index = 0;
        if (elementCount(a2, a1[0]) != 0) {
            arr[index] = a1[0];
            index++;
        }
        for (int i = 1; i < a1.length; i++) {
            if (a1[i] != a1[i - 1]) {
                if (elementCount(a2, a1[i]) != 0) {
                    arr[index] = a1[i];
                    index++;
                }
            }
        }
        Arrays.sort(arr);
        return arr;
    }

    public static void reverseMe(int[] inOutArr) {
        for (int i = 0; i < inOutArr.length / 2; i++) {
            int temp = inOutArr[i];
            inOutArr[i] = inOutArr[inOutArr.length - 1 - i];
            inOutArr[inOutArr.length - 1 - i] = temp;
        }
    }

    public static int[] returnReversed(int[] inArr) {
        reverseMe(inArr);
        return inArr;
    }

    public static void showArr(int[] arrIn, int numberOfColumns) {
        if (isArrEmpty(arrIn)) {
            return;
        }
        int numberOfRows = arrIn.length / numberOfColumns;
        if (arrIn.length % numberOfColumns != 0) {
            numberOfRows++;
        }

        int index = 0;
        for (int i = 0; i < numberOfRows; i++) {
            for (int k = 0; k < numberOfColumns; k++) {
                if (index < arrIn.length) {
                    System.out.print(arrIn[index] + " ");
                    index++;
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {234, 3434, 23, 213, 1, -23, 23, 4};
        int[] arr2 = {435, 56, 12, 312, 56, 1, 2, 3, 4, 5, 23, -23};
        System.out.println("readArray");
        System.out.println(Arrays.toString(readArray(0)) + "\n");

        System.out.println("appendArrays");
        System.out.println(Arrays.toString(appendArrays(arr1, arr2)) + "\n");

        System.out.println("getMinimalElement");
        System.out.println(getMinimalElement(arr1) + "\n");

        System.out.println("getMinimalElements");
        System.out.println(Arrays.toString(getMinimalElements(arr1)) + "\n");

        System.out.println("getGreaterThan");
        System.out.println(Arrays.toString(getGreaterThan(arr1, 12)) + "\n");

        System.out.println("getRange");
        System.out.println(Arrays.toString(getRange(arr1, 12, 300)) + "\n");

        System.out.println("elementCount");
        System.out.println(elementCount(arr1, -23) + "\n");

        System.out.println("uniqueElements");
        System.out.println(Arrays.toString(uniqueElements(arr1, arr2)) + "\n");

        System.out.println("commonElements");
        System.out.println(Arrays.toString(commonElements(arr1, arr2)) + "\n");

        System.out.println("returnReversed");
        System.out.println(Arrays.toString(returnReversed(arr1)) + "\n");

        System.out.println("showArr");
        showArr(arr1, 7);

    }
}

