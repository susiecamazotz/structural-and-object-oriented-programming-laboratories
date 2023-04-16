package laboratories12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CovidDataStore {
    protected ArrayList<WeeklyDataProper> weeksArrayList = new ArrayList<>();
    protected HashSet<WeeklyDataProper> weeksHashSet = new HashSet<>();
    protected TreeMap<String, TreeData> weeksTreeMap = new TreeMap<>();
    protected ArrayList<String> allCountries = new ArrayList<>();

    public void readFromFile(String fileName) {
        Scanner scanner = null;

        try {
            scanner = new Scanner(new File(fileName));
            int counter = 0;

            while (scanner.hasNextLine()) {
                String oneLine = scanner.nextLine();

                try {
                    WeeklyDataProper week = new WeeklyDataProper(oneLine);

                    weeksArrayList.add(week);
                    weeksHashSet.add(week);
                    weeksTreeMap.put(week.getCountry().toLowerCase() + week.getWeek(), new TreeData(week.getDeaths(), week.getCases(), week.getCountry().toLowerCase()));

                } catch (Exception e) {
                    try {
                        throw new FileFormatException(fileName, counter, oneLine);
                    } catch (FileFormatException exception) {
                        // System.err.println(exception);
                    }
                }

                counter++;
            }

            System.out.println("File read successfully");
            allCountries.addAll(getAllCountries());
        } catch (FileNotFoundException e) {
            System.err.println("Cannot find file: " + fileName);
        }

        if (scanner != null) {
            scanner.close();
        }
    }


    public int getCasesArrayList(String country, int week) {

        for (WeeklyDataProper weeklyDataProper : weeksArrayList) {

            if (weeklyDataProper.getCountry().equalsIgnoreCase(country) && weeklyDataProper.getWeek().equals(week)) {
                return weeklyDataProper.getCases();
            }
        }

        return 0;
    }

    public int getCasesArrayList(String country) {
        int cases = 0;

        for (WeeklyDataProper weeklyDataProper : weeksArrayList) {

            if (weeklyDataProper.getCountry().equalsIgnoreCase(country)) {
                cases += weeklyDataProper.getCases();
            }
        }


        return cases;
    }

    public int getCasesArrayList(int week) {
        int cases = 0;

        for (WeeklyDataProper weeklyDataProper : weeksArrayList) {

            if (weeklyDataProper.getWeek().equals(week)) {
                cases += weeklyDataProper.getCases();
            }
        }


        return cases;
    }


    public int getCasesHashSet(String country, int week) {

        for (WeeklyDataProper weeklyDataProper : weeksHashSet) {

            if (weeklyDataProper.getWeek().equals(week) && weeklyDataProper.getCountry().equalsIgnoreCase(country)) {
                return weeklyDataProper.getCases();
            }
        }

        return 0;
    }

    public int getCasesHashSet(String country) {
        int cases = 0;

        for (WeeklyDataProper weeklyDataProper : weeksHashSet) {

            if (weeklyDataProper.getCountry().equalsIgnoreCase(country)) {
                cases += weeklyDataProper.getCases();
            }
        }

        return cases;
    }

    public int getCasesHashSet(int week) {
        int cases = 0;

        for (WeeklyDataProper weeklyDataProper : weeksHashSet) {
            if (weeklyDataProper.getWeek().equals(week)) {
                cases += weeklyDataProper.getCases();
            }
        }

        return cases;
    }


    public int getCasesTreeMap(String country, int week) {
        if (weeksTreeMap.get(country + week) != null) {
            return weeksTreeMap.get((country + week)).getCases();
        }

        return 0;
    }

    public int getCasesTreeMap(String country) {
        int cases = 0;

        for (int i = 1; i < 54; i++) {
            if (weeksTreeMap.get(country + i) != null) {
                cases += weeksTreeMap.get(country + i).getCases();
            }
        }

        return cases;
    }

    public int getCasesTreeMap(int week) {
        int cases = 0;

        for (String country : allCountries) {
            if (weeksTreeMap.get(country + week) != null) {
                cases += weeksTreeMap.get(country + week).getCases();
            }
        }

        return cases;
    }


    public HashSet<String> getAllCountries() {
        HashSet<String> countries = new HashSet<>();

        for (WeeklyDataProper week : weeksArrayList) {
            String country = week.getCountry().toLowerCase();
            countries.add(country);
        }

        return countries;
    }

}
