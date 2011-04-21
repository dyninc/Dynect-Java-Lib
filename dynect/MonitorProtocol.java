package dynect;

public enum MonitorProtocol {
	HTTP,
	HTTPS,
	PING,
	SMTP;
	
	public static MonitorProtocol StringToMonitorProtocol(String status) {
		if(status == "HTTP")
			return MonitorProtocol.HTTP;
		if(status == "HTTPS")
			return MonitorProtocol.HTTPS;
		if(status == "PING")
			return MonitorProtocol.PING;
		else
			return MonitorProtocol.SMTP;
	}
}
