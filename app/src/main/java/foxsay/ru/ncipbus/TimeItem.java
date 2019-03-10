package foxsay.ru.ncipbus;

public class TimeItem {
    private String time;
    private boolean isArrived;

    public TimeItem() {

    }

    public TimeItem(String time, boolean isArrived) {
        this.time = time;
        this.isArrived = isArrived;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isArrived() {
        return isArrived;
    }

    public void setArrived(boolean arrived) {
        isArrived = arrived;
    }
}
