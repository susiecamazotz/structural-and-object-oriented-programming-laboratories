package laboratories9and10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MainClass {

    public static void main(String[] args) {

        Scanner fileScan = null;
        int counter = 0;
        try {
            fileScan = new Scanner(new File("ecdc_covid19_cases.csv"));

            while (fileScan.hasNextLine()) {
                String oneLine = fileScan.nextLine();
                try {
                    new WeeklyData(oneLine);
                } catch (Exception e) {
                    counter++;
                    //e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (fileScan != null) {
            fileScan.close();
        }
        System.out.println(counter);


        CovidData covid = new CovidData();

        try {

            covid.readFromFile("ecdc_covid19_cases.csv");
            System.out.println(covid.getTotalCases());
            System.out.println(covid.getTotalCases("Africa"));
            System.out.println(covid.getTotalCases(44));
            System.out.println(covid.getTotalCases("Africa", 44));

            System.out.println(covid.getTotalDeaths());
            System.out.println(covid.getTotalDeaths("Africa"));
            System.out.println(covid.getTotalDeaths(44));
            System.out.println(covid.getTotalDeaths("Africa", 44));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
