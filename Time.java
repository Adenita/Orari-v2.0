public class Time 
{
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public String toString() {
        return String.format("%1$02d", hour) + ":" + String.format("%1$02d", minute);
    }

    public int toMinutes() {
        return (hour * 60 + minute);
    }
}
 