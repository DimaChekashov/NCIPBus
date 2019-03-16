package foxsay.ru.ncipbus;

public class TimeItem {
    private int hourse, minute;

    public TimeItem() {

    }

    public TimeItem(int hourse, int minute) {
        this.hourse = hourse;
        this.minute = minute;
    }

    public int getHourse() {
        return hourse;
    }

    public void setHourse(int hourse) {
        this.hourse = hourse;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
