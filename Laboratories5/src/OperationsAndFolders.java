import java.io.File;
import java.util.Objects;

public class OperationsAndFolders {
    public static int factorial(int x) {
        int factor = 1;
        if (x < 0) {
            System.out.print("Number too little ");
            return -1;
        }

        for (int i = 1; i <= x; i++) {
            factor *= i;
        }

        return factor;
    }

    public static int factorialR(int x) {
        if (x < 0) {
            System.out.print("Number too little ");
            return -1;
        }

        if (x == 0) {
            return 1;
        }

        return x * factorialR(x - 1);
    }

    public static int sumXY(int x, int y) {
        int sum = 0;

        for (int i = 0; i <= y - x; i++) {
            sum += x + i;
        }

        return sum;
    }

    public static int sumXYR(int x, int y) {
        if (x == y) {
            return x;
        }

        return x + sumXYR(x + 1, y);
    }

    public static int numberDigit(int x, int digit) {
        int counter = 0;

        if (x < 0) {
            x *= -1;
        }

        if (x == 0 && digit == 0) {
            counter++;
        }

        while (x > 0) {
            if (x % 10 == digit) {
                counter++;
            }
            x /= 10;
        }

        return counter;
    }

    public static int numberDigitR(int x, int digit) {
        int isDigitPresent = 0;

        if (x < 0) {
            return -1;
        }

        if (x == 0 && digit == 0) {
            return 1;
        }

        if (x == 0) {
            return 0;
        }

        if (x % 10 == digit) {
            isDigitPresent++;
        }

        return isDigitPresent + numberDigitR(x / 10, digit);
    }

    public static int numberLength(int x) {
        int sum = 0;

        if (x < 0) {
            x *= -1;
        }

        if (x == 0) {
            sum++;
        }

        while (x > 0) {
            sum++;
            x /= 10;
        }

        return sum;
    }

    public static int numberLengthR(int x) {
        if (x < 0) {
            return numberLengthR(x * -1);
        }

        if (x == 0) {
            return 0;
        }

        return 1 + numberLengthR(x / 10);
    }

    public static long lengthOfTxtFilesInFolder(File directory) {
        long lengthSum = 0;

        try {
            for (File file : Objects.requireNonNull(directory.listFiles())) {
                if (file.getName().endsWith(".txt")) {
                    lengthSum += file.length();
                }
            }
        } catch (Exception err) {
            System.out.print("Directory not found ");
        }

        return lengthSum;
    }

    public static long lengthOfTxtFilesInFolderAndSubFolders(File directory) {
        long lengthSum = 0;

        try {
            for (File file : Objects.requireNonNull(directory.listFiles())) {
                if (file.isDirectory()) {
                    lengthSum += lengthOfTxtFilesInFolderAndSubFolders(file);
                } else if (file.getName().endsWith(".txt")) {
                    lengthSum += file.length();
                }
            }
        } catch (Exception err) {
            System.out.print("Directory not found ");
        }

        return lengthSum;
    }


    public static void main(String[] args) {
        int x = 0;
        int y = 5;

        System.out.println("Factorial:");
        System.out.println(factorial(x) + "\n");

        System.out.println("Factorial recursive:");
        System.out.println(factorialR(x) + "\n");

        System.out.println("SumXY: ");
        System.out.println(sumXY(x, y) + "\n");

        System.out.println("SumXYR recursive: ");
        System.out.println(sumXYR(x, y) + "\n");
        System.out.println(sumXYR(x, y) + "\n");

        int z = 0;
        int w = 0;
        System.out.println("NumberDigit: ");
        System.out.println(numberDigit(z, w) + "\n");

        System.out.println("NumberDigit recursive: ");
        System.out.println(numberDigitR(z, w) + "\n");

        int q = 123456;
        System.out.println("numberLength: ");
        System.out.println(numberLength(q) + "\n");

        System.out.println("numberLength recursive: ");
        System.out.println(numberLengthR(q) + "\n");

        File folder = new File("D:\\Files From Google");
        System.out.println("lengthOfTxtFilesInFolder: ");
        System.out.println(lengthOfTxtFilesInFolder(folder) + "\n");

        System.out.println("lengthOfTxtFilesInFolderAndSubFolders: ");
        System.out.println(lengthOfTxtFilesInFolderAndSubFolders(folder) + "\n");
    }
}
