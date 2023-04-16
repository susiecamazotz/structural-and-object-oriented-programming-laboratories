package laboratories12;

public class WeeklyDataProper extends WeeklyData implements Comparable<WeeklyDataProper> {

    public WeeklyDataProper(String line) throws Exception {
        super(line);
    }

    @Override
    public int compareTo(WeeklyDataProper o) {

        if (this.getCountry().equals(o.getCountry())) {
            return this.getWeek().compareTo(o.getWeek());
        }

        return this.getCountry().compareTo(o.getCountry());
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        return obj instanceof WeeklyDataProper && this.getCountry().equals(((WeeklyDataProper) obj).getCountry()) && this.getWeek().equals(((WeeklyDataProper) obj).getWeek());
    }
}
