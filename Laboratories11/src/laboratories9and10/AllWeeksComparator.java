package laboratories9and10;

import java.util.Comparator;

public class AllWeeksComparator implements Comparator<WeeklyData> {

    @Override
    public int compare(WeeklyData o1, WeeklyData o2) {
        int nameCompare = o1.getCountry().compareTo(o2.getCountry());

        if (nameCompare != 0) {
            return nameCompare;
        }

        return o1.getWeek() - o2.getWeek();
    }
}
