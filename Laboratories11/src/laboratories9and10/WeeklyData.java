package laboratories9and10;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeeklyData {
    private final Integer year;
    private final Integer week;
    private final Integer cases;
    private final Integer deaths;
    private final String country;
    private final String continent;
    private final Double rate;

    public WeeklyData(String line) throws Exception {

        Pattern pattern = Pattern.compile("\\d{2}[/]\\d{2}[/]\\d{4}[,](\\d{4})[-](\\d{2})[,](\\d+)[,](\\d+)[,](\\w+)[,]\\w{2}[,]\\w{3}[,]\\d+[,](\\w+)[,](\\d+[.]?\\d*|[.]\\d+)");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            year = Integer.parseInt(matcher.group(1));
            week = Integer.parseInt(matcher.group(2));
            cases = Integer.parseInt(matcher.group(3));
            deaths = Integer.parseInt(matcher.group(4));
            country = matcher.group(5);
            continent = matcher.group(6);
            rate = Double.parseDouble(matcher.group(7));
        } else {
            throw new Exception("Line doesn't match the pattern " + line);
        }
    }

    @Override
    public String toString() {
        return "WeeklyData{" + "year=" + year + ", week=" + week + ", cases=" + cases + ", deaths=" + deaths + ", country='" + country + '\'' + ", continent='" + continent + '\'' + ", rate=" + rate + '}';
    }


    @Override
    public boolean equals(Object obj) {

        boolean temp = true;

        if (obj instanceof WeeklyData) {

            if (!Objects.equals(((WeeklyData) obj).year, this.year)) {
                temp = false;
            }

            if (!Objects.equals(((WeeklyData) obj).week, this.week)) {
                temp = false;
            }

            if (!Objects.equals(((WeeklyData) obj).cases, this.cases)) {
                temp = false;
            }

            if (!Objects.equals(((WeeklyData) obj).deaths, this.deaths)) {
                temp = false;
            }

            if (!Objects.equals(((WeeklyData) obj).country, this.country)) {
                temp = false;
            }

            if (!Objects.equals(((WeeklyData) obj).continent, this.continent)) {
                temp = false;
            }

            if (!Objects.equals(((WeeklyData) obj).rate, this.rate)) {
                temp = false;
            }
        } else {
            temp = false;
        }

        return temp;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getWeek() {
        return week;
    }

    public Integer getCases() {
        return cases;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public String getCountry() {
        return country;
    }

    public String getContinent() {
        return continent;
    }

    public Double getRate() {
        return rate;
    }
}
