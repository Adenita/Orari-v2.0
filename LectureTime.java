public class LectureTime 
{
	private String day;
	private Time startTime; 
    private Time endTime;

    public LectureTime(String day, Time startTime, Time endTime) {	
		this.startTime = startTime;
		this.endTime = endTime;
		this.day = day;
	}
	
    public String getTime() {
        return startTime.toString() + "-" + endTime.toString();
    }

	public Time getStartTime() {
		return startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public int getDuration() {
		return endTime.toMinutes() - startTime.toMinutes();
	}

	public boolean collision(LectureTime time) {
		if(day.equals(time.getDay()) && startTime.toMinutes() + getDuration() > time.startTime.toMinutes()) {
			return true;
		}
		return false;
	}

    public String getDay(){	
		return day;
	}

	public int getDayVal(String day) {
		int val = 0;
		if(day == "Mon")
			val = 1;
		else if (day == "Tue")
			val = 2;
		else if (day == "Wen")
			val = 3;
		else if (day == "Thu")
			val = 4;
		else if (day == "Fri")
			val = 5;

		return val;
		
	}
}
