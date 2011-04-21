package dynect;

public enum MonitorIntervals {
	minute(1),
	five_minutes(5),
	ten_minutes(10),
	fifteen_minutes(15);
	
	private final int num;
	
	private MonitorIntervals(int i)
	{
		this.num = i;
	}
	
	public static MonitorIntervals StringToMonitorIntervals(String status) {
		if(status == "1")
			return MonitorIntervals.minute;
		if(status == "5")
			return MonitorIntervals.five_minutes;
		if(status == "10")
			return MonitorIntervals.ten_minutes;
		else
			return MonitorIntervals.fifteen_minutes;
	}
	
	public String toString()
	{
		return String.valueOf(this.num);
	}
}
