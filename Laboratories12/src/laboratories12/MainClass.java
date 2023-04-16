package laboratories12;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {

    public static void main(String[] args) {

        CovidDataStore dataStore = new CovidDataStore();
        Scanner input = new Scanner(System.in);
        boolean run = true;

        while (run && input.hasNextLine()) {
            String line = input.nextLine();
            EnumCommands command = readCommand(line);

            if (line.trim().equals("")) {
                continue;
            }

            switch (command) {
                case QUIT -> run = false;
                case READ -> readData(line, dataStore);
                case SHOW -> showData(line, dataStore);
                case NOT_PROPER -> System.out.println("Not a proper command");
            }
        }

        input.close();
    }

    private static EnumCommands readCommand(String line) {

        line = line.toLowerCase().trim();
        Pattern pattern = Pattern.compile("show\\s+\\w+|quit|read\\s+\\w+");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {

            if (matcher.group(0).contains("show")) {
                return EnumCommands.SHOW;

            } else if (matcher.group(0).contains("read")) {
                return EnumCommands.READ;

            } else if (matcher.group(0).contains("quit")) {
                return EnumCommands.QUIT;
            }
        }

        return EnumCommands.NOT_PROPER;
    }

    public static void readData(String fileName, CovidDataStore covidDataStore) {

        fileName = fileName.toLowerCase().trim();
        Pattern pattern = Pattern.compile("read\\s+([\\w.]+)");
        Matcher matcher = pattern.matcher(fileName);

        if (matcher.find()) {
            covidDataStore.readFromFile(matcher.group(1));
        }
    }


    private static void showCountry(String country, CovidDataStore covidDataStore) {

        long prevNanoSec = System.nanoTime();
        System.out.println(covidDataStore.getCasesArrayList(country) + " Execution Time: " + (System.nanoTime() - prevNanoSec) + " ArrayList");

        prevNanoSec = System.nanoTime();
        System.out.println(covidDataStore.getCasesHashSet(country) + " Execution Time: " + (System.nanoTime() - prevNanoSec) + " HashSet");

        prevNanoSec = System.nanoTime();
        System.out.println(covidDataStore.getCasesTreeMap(country) + " Execution Time: " + (System.nanoTime() - prevNanoSec) + " TreeMap");

    }

    private static void showWeek(int week, CovidDataStore covidDataStore) {

        long prevNanoSec = System.nanoTime();
        System.out.println(covidDataStore.getCasesArrayList(week) + " Execution Time: " + (System.nanoTime() - prevNanoSec) + " ArrayList");

        prevNanoSec = System.nanoTime();
        System.out.println(covidDataStore.getCasesHashSet(week) + " Execution Time: " + (System.nanoTime() - prevNanoSec) + " HashSet");

        prevNanoSec = System.nanoTime();
        System.out.println(covidDataStore.getCasesTreeMap(week) + " Execution Time: " + (System.nanoTime() - prevNanoSec) + " TreeMap");

    }

    private static void showCountryAndWeek(String country, int week, CovidDataStore covidDataStore) {

        long prevNanoSec = System.nanoTime();
        System.out.println(covidDataStore.getCasesArrayList(country, week) + " Execution Time: " + (System.nanoTime() - prevNanoSec) + " ArrayList");

        prevNanoSec = System.nanoTime();
        System.out.println(covidDataStore.getCasesHashSet(country, week) + " Execution Time: " + (System.nanoTime() - prevNanoSec) + " HashSet");

        prevNanoSec = System.nanoTime();
        System.out.println(covidDataStore.getCasesTreeMap(country, week) + " Execution Time: " + (System.nanoTime() - prevNanoSec) + " TreeMap");

    }

    private static void showData(String line, CovidDataStore covidDataStore) {

        line = line.toLowerCase().trim();
        Pattern pattern = Pattern.compile("show\\s+([a-z]+)?\\s*(\\d+)?");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            String country = matcher.group(1);

            if (matcher.group(1) != null && !covidDataStore.allCountries.contains(matcher.group(1))) {
                System.err.println((matcher.group(1) + " is not a country available in the dataset"));

            } else if (matcher.group(2) == null) {
                showCountry(country, covidDataStore);

            } else if (matcher.group(1) == null) {
                int week = Integer.parseInt(matcher.group(2));
                showWeek(week, covidDataStore);

            } else {
                int week = Integer.parseInt(matcher.group(2));
                showCountryAndWeek(country, week, covidDataStore);
            }
        }
    }


}


