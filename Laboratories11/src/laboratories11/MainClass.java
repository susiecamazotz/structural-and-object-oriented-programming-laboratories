package laboratories11;

import java.util.Scanner;


public class MainClass {

    public static void main(String[] args) {

        CovidDataQA data = new CovidDataQA("ecdc_covid19_cases.csv");

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String temp = scanner.nextLine().toLowerCase();

            if (temp.trim().equals("")) {
                continue;
            }

            if (temp.contains("quit")) {
                break;
            }

            if (!data.answerQuestion(temp)) {
                System.out.println(data.setConditions(temp));
            }
            System.out.println();
        }
        scanner.close();

    }
}
