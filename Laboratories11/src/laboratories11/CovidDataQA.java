package laboratories11;

import laboratories9and10.CovidData;
import laboratories9and10.WeeklyData;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CovidDataQA extends CovidData {
    ArrayList<Integer> weekCondition = new ArrayList<>(1);
    ConditionType conditionType = ConditionType.ALL;

    public CovidDataQA(String fileName) {
        this.readFromFile(fileName);
    }

    public Vector<String> getAllCountries() {
        Vector<String> countries = new Vector<>(0, 1);

        for (WeeklyData data : allWeeks) {

            if (!countries.contains(data.getCountry())) {
                countries.add(data.getCountry());
            }
        }

        countries.sort(Comparator.naturalOrder());
        return countries;
    }

    private boolean setInterval(String interval) {
        boolean correct = true;

        String[] temp = interval.split("[ -]");

        for (String str : temp) {
            if (!str.equals("")) {
                weekCondition.add(Integer.parseInt(str));
            }
        }
        if (weekCondition.get(0) <= weekCondition.get(1) && weekCondition.get(0) <= 53) {
            conditionType = ConditionType.INTERVAL;

            if (weekCondition.get(1) > 53) {
                weekCondition.remove(1);
                weekCondition.add(53);
            }

            if (weekCondition.get(0).equals(weekCondition.get(1))) {
                weekCondition.remove(1);
                return true;
            }

            int lastWeek = weekCondition.get(1);
            weekCondition.remove(1);

            for (int i = weekCondition.get(0) + 1; i <= lastWeek; i++) {
                weekCondition.add(i);
            }

        } else {
            correct = false;
        }

        return correct;
    }

    private boolean setOneOrMultiple(String multiple) {
        boolean correct = true;
        String[] temp = multiple.split("[ ,;\t]");
        System.out.println(Arrays.toString(temp));

        for (String str : temp) {
            if (!str.equals("") && !weekCondition.contains(Integer.parseInt(str)) && Integer.parseInt(str) <= 53) {
                weekCondition.add(Integer.parseInt(str));
            }
        }

        if (weekCondition.size() > 1) {
            conditionType = ConditionType.MULTIPLE;
            weekCondition.sort(Comparator.naturalOrder());

        } else if (weekCondition.size() == 1) {
            conditionType = ConditionType.ONE;

        } else if (temp.length > 0) {
            correct = false;

        } else {
            conditionType = ConditionType.ALL;

        }

        return correct;
    }

    public boolean setConditions(String command) {
        boolean correct = true;

        if (command == null || command.trim().equals("")) {
            return false;
        }

        command = command.toLowerCase().trim();
        Pattern pattern = Pattern.compile("set\\s*week\\s*(\\d+\\s*[-]\\s*\\d+|[,;\\s\\d]*)");
        Matcher matcher = pattern.matcher(command);

        if (matcher.find()) {
            weekCondition.clear();
            weekCondition.trimToSize();
            String group0 = matcher.group(0);
            String group1 = matcher.group(1);

            if (group1.equals("")) {
                conditionType = ConditionType.ALL;

            } else if (group0.contains("-")) {
                correct = this.setInterval(group1);

            } else {
                correct = setOneOrMultiple(group1);
            }

        } else {
            correct = false;

        }

        return correct;
    }

    public void showConditions() {

        System.out.print("Set condition is: Show " + conditionType);
        if (conditionType != ConditionType.ALL) {
            System.out.println(", weeks set " + weekCondition + " ");
        }
    }

    private void printWeek(String command, WeeklyData week) {
        switch (command) {
            case "cases" ->
                    System.out.println(week.getCountry() + ", " + week.getWeek() + ", cases: " + week.getCases());
            case "deaths" ->
                    System.out.println(week.getCountry() + ", " + week.getWeek() + ", deaths: " + week.getDeaths());
        }
    }

    private void showData(String command) {
        if (conditionType == ConditionType.ALL) {
            for (WeeklyData week : this.allWeeks) {
                printWeek(command, week);
            }
        }

        for (WeeklyData week : this.allWeeks) {
            for (int weekNumber : weekCondition) {
                if (week.getWeek().equals(weekNumber)) {
                    printWeek(command, week);
                }
            }
        }
    }

    public boolean answerQuestion(String question) {
        boolean correct = true;

        if (question == null || question.trim().equals("")) {
            return false;
        }

        question = question.toLowerCase().trim();
        Pattern pattern = Pattern.compile("show[\\s]*(cases|deaths|conditions)");
        Matcher matcher = pattern.matcher(question);

        if (matcher.find()) {
            switch (matcher.group(1)) {
                case "cases" -> showData("cases");
                case "deaths" -> showData("deaths");
                case "conditions" -> showConditions();
            }
        } else {
            correct = false;
        }

        return correct;
    }

    @Override
    public String toString() {

        return "Total number of: deaths " + calculateCasesOrDeaths("deaths") + ", cases " + calculateCasesOrDeaths("cases");
    }

    private int calculateCasesOrDeaths(String command) {
        int temp = 0;

        for (int i = 0; i < weekCondition.size(); i++) {
            switch (command) {
                case "deaths" -> temp += this.getTotalCases(i);
                case "cases" -> temp += this.getTotalDeaths(i);
            }
        }

        return temp;
    }

}
