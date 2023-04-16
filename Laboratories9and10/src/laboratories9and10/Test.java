package laboratories9and10;

public class Test {
    public WeeklyData data;

    public Test(WeeklyData line) {
        data = line;
    }

    public WeeklyData getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Test{" + "data=" + data + '}';
    }

    public void setData(WeeklyData data) {
        this.data = data;


    }
}
