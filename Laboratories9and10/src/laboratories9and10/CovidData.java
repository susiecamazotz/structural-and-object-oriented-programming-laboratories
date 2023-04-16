package laboratories9and10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CovidData {
    protected ArrayList<WeeklyData> allWeeks = new ArrayList<>();

    public CovidData() {
    }


    public void readFromFile(String fileName) {

        Scanner fileScan = null;
        try {
            int counter = 0;
            fileScan = new Scanner(new File(fileName));

            while (fileScan.hasNextLine()) {
                String oneLine = fileScan.nextLine();

                try {
                    allWeeks.add(new WeeklyData(oneLine));
                } catch (Exception e) {

                    try {
                        throw new FileFormatException(fileName, counter, oneLine);
                    } catch (FileFormatException exception) {
                        System.err.println(exception);
                    }
                }

                counter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (fileScan != null) {
            fileScan.close();
        }
    }

    public int getTotalCases() {
        int counter = 0;

        for (WeeklyData data : allWeeks) {
            counter += data.getCases();
        }

        return counter;
    }

    public int getTotalCases(String continent) {
        int counter = 0;

        for (WeeklyData data : allWeeks) {
            if (data.getContinent().equals(continent)) {
                counter += data.getCases();
            }
        }

        return counter;
    }

    public int getTotalCases(int week) {
        int counter = 0;

        for (WeeklyData data : allWeeks) {
            if (data.getWeek().equals(week)) {
                counter += data.getCases();
            }
        }

        return counter;
    }

    public int getTotalCases(String continent, int week) {
        int counter = 0;

        for (WeeklyData data : allWeeks) {
            if (data.getContinent().equals(continent) && data.getWeek().equals(week)) {
                counter += data.getCases();
            }
        }

        return counter;
    }


    public int getTotalDeaths() {
        int counter = 0;

        for (WeeklyData data : allWeeks) {
            counter += data.getDeaths();
        }

        return counter;
    }

    public int getTotalDeaths(String continent) {
        int counter = 0;

        for (WeeklyData data : allWeeks) {
            if (data.getContinent().equals(continent)) {
                counter += data.getDeaths();
            }
        }

        return counter;
    }

    public int getTotalDeaths(int week) {
        int counter = 0;

        for (WeeklyData data : allWeeks) {
            if (data.getWeek().equals(week)) {
                counter += data.getDeaths();
            }
        }

        return counter;
    }

    public int getTotalDeaths(String continent, int week) {
        int counter = 0;

        for (WeeklyData data : allWeeks) {
            if (data.getContinent().equals(continent) && data.getWeek().equals(week)) {
                counter += data.getDeaths();
            }
        }

        return counter;
    }

}
