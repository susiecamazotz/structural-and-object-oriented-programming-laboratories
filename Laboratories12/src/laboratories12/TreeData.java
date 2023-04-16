package laboratories12;

public class TreeData {
    private final int deaths;
    private final int cases;
    private final String country;


    public TreeData(int deaths, int cases, String country) {
        this.deaths = deaths;
        this.cases = cases;
        this.country = country;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getCases() {
        return cases;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "TreeData{" + "deaths=" + deaths + ", cases=" + cases + ", continent='" + country + '\'' + '}';
    }
}
