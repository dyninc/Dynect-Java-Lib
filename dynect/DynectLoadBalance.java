package dynect;

import org.json.JSONArray;
import org.json.JSONObject;

public class DynectLoadBalance extends Dynect {
	public enum LoadBalanceStatus {
		unk,
		ok,
		trouble,
		failover;

		public static LoadBalanceStatus StringToLoadBalanceStatus(String status) {
			if(status == "unk")
				return LoadBalanceStatus.unk;
			if(status == "ok")
				return LoadBalanceStatus.ok;
			if(status == "trouble")
				return LoadBalanceStatus.trouble;
			else
				return LoadBalanceStatus.failover;
		}
	}
	
	public enum TTLTimes {
		half_minute(30),
		minute(60),
		one_and_half_minutes(150),
		five_minutes(300),
		six_and_half_minutes(450);
		
		private final int num;
		private TTLTimes(int i)
		{
			num = i;
		}
		
		public static TTLTimes StringToTTLTimes(String status) {
			if(status == "30")
				return TTLTimes.half_minute;
			if(status == "60")
				return TTLTimes.minute;
			if(status == "150")
				return TTLTimes.one_and_half_minutes;
			if(status == "300")
				return TTLTimes.five_minutes;
			else
				return TTLTimes.six_and_half_minutes;
		}
		
		public String toString()
		{
			return String.valueOf(this.num);
		}
	}
	
	public enum NotifyOptions {
		ip,
		svc,
		ip_and_svc;

		public static NotifyOptions StringToNotifyOptions(String status) {
			if(status == "ip")
				return NotifyOptions.ip;
			if(status == "svc")
				return NotifyOptions.svc;
			else
				return NotifyOptions.ip_and_svc;
		}
	}
	
	public enum FailoverMode {
		ip,
		cname,
		global;
		
		public static FailoverMode StringToFailoverMode(String status) {
			if(status == "ip")
				return FailoverMode.ip;
			if(status == "cname")
				return FailoverMode.cname;
			else
				return FailoverMode.global;
		}
	}

	public enum LoadBalancePoolEntryWeight {
		one (1),
		two(2),
		three(3),
		four(4),
		five(5),
		six(6),
		seven(7),
		eight(8),
		nine(9),
		ten(10),
		eleven(11),
		twelve(12),
		thirteen(13),
		fourteen(14),
		fifteen(15);
		
		private final int num;
		LoadBalancePoolEntryWeight(int i) {
			this.num = i;
		}
		
		public int toInt()
		{
			return this.num;
		}
		

		public String toString()
		{
			return String.valueOf(this.num);
		}
		
		public static LoadBalancePoolEntryWeight StringToWeight(String weight) {
			for (LoadBalancePoolEntryWeight w : LoadBalancePoolEntryWeight.values()) {
				if(w.toString() == weight) {
					return w;
				}
			}
			return null;
		}
	}
	
	public enum LoadBalancePoolEntryServeMode {
		always,
		obey,
		remove,
		no;
		
		public static LoadBalancePoolEntryServeMode StringToServeMode(String status) {
			if(status == "always")
				return LoadBalancePoolEntryServeMode.always;
			if(status == "obey")
				return LoadBalancePoolEntryServeMode.obey;
			if(status == "remove")
				return LoadBalancePoolEntryServeMode.remove;
			else
				return LoadBalancePoolEntryServeMode.no;
		}
	}
	
	public enum LoadBalancePoolEntryStatus {
		unk,
		up,
		down;
		
		public static LoadBalancePoolEntryStatus StringToStatus(String status) {
			if(status == "unk")
				return LoadBalancePoolEntryStatus.unk;
			if(status == "up")
				return LoadBalancePoolEntryStatus.up;
			else
				return LoadBalancePoolEntryStatus.down;
		}
	}
	
	public class DynectLoadBalancePoolEntryLog {
		public LoadBalancePoolEntryStatus status;
		public String message;
		public String time;
		public String site_code;
	}
	
	public class DynectLoadBalancePoolEntry {
		
		public String address;
		public String label;
		public LoadBalancePoolEntryWeight weight;
		public LoadBalancePoolEntryServeMode serve_mode;
		public LoadBalancePoolEntryStatus status;
		public DynectLoadBalancePoolEntryLog[] log;
	}
	
	public class DynectLoadBalanceObject {
			public boolean active;
			public LoadBalanceStatus status;
			public boolean auto_recover;
			public TTLTimes ttl;
			public NotifyOptions notify_events;
			public int serve_count;
			public FailoverMode failover_mode; 
			public String failover_data;
			public DynectLoadBalancePoolEntry[] pool;
			public DynectMonitor monitor;
			public String contact_nickname;
			public String fqdn;
			public String zone;
	}

	public DynectLoadBalance(String user_name, String customer_name, String password)
	{
		super(user_name, customer_name, password);
	}
		
	public DynectLoadBalanceObject[] GetDynectLoadBalance(String zone)
	{
		return GetDynectLoadBalancers(zone, null);
	}

	public DynectLoadBalanceObject GetDynectLoadBalance(String zone, String fqdn)
	{
		return GetDynectLoadBalancers(zone, fqdn)[0];
	}
	
	public DynectLoadBalancePoolEntry[] GetDynectLoadBalancePoolEntry(String zone, String fqdn)
	{
		return GetDynectLoadBalancePoolEntrys(zone, fqdn, null);
	}

	public DynectLoadBalancePoolEntry GetDynectLoadBalancePoolEntry(String zone, String fqdn, String address)
	{
		return GetDynectLoadBalancePoolEntrys(zone, fqdn, address)[0];
	}
	
	public boolean DeleteDynectLoadBalance(String zone, String fqdn)
	{
		try {
			
			JSONObject jsoOut = null;
			jsoOut = MakeRestCall("DELETE", "LoadBalance/" +zone + "/" +  fqdn + "/", null, this._token);
				
			if(jsoOut != null && jsoOut.getString("status") == "success")
			{
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean DeleteDynectLoadBalancePoolEntry(String zone, String fqdn, String address)
	{
		try {
			
			JSONObject jsoOut = null;
			jsoOut = MakeRestCall("DELETE", "LoadBalance/" +zone + "/" +  fqdn + "/" + address + "/", null, this._token);
				
			if(jsoOut != null && jsoOut.getString("status") == "success")
			{
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	

	private DynectLoadBalancePoolEntry[] GetDynectLoadBalancePoolEntrys(String zone, String fqdn, String address)
	{
		try {
			
			JSONObject jsoOut = null;
			if(fqdn == null)
				jsoOut = MakeRestCall("GET","LoadBalance/" + zone + "/"+  fqdn + "/", null, this._token);
			else
				jsoOut = MakeRestCall("GET", "LoadBalance/" +zone + "/" +  fqdn + "/" +  address + "/", null, this._token);
				
			if(jsoOut != null && jsoOut.getString("status") == "success")
			{
				DynectLoadBalancePoolEntry lbpeObj[] = null;
				JSONArray lbArrayObj = jsoOut.getJSONArray("data");
				if(lbArrayObj != null)
				{
					lbpeObj = new DynectLoadBalancePoolEntry[lbArrayObj.length()];
					for(int i = 0; i < lbArrayObj.length(); i++)
					{
						lbpeObj[i] = DynectLoadBalancePoolEntryFactory(lbArrayObj.getJSONObject(i));
					}
				}
				else
				{
					lbpeObj = new DynectLoadBalancePoolEntry[1];
					lbpeObj[0] = DynectLoadBalancePoolEntryFactory(jsoOut.getJSONObject("data"));
				}
				
				return lbpeObj;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private DynectLoadBalanceObject[] GetDynectLoadBalancers(String zone, String fqdn)
	{
		try {
		
			JSONObject jsoOut = null;
			if(fqdn == null)
				jsoOut = MakeRestCall("GET","LoadBalance/" + zone + "/", null, this._token);
			else
				jsoOut = MakeRestCall("GET", "LoadBalance/" +zone + "/" +  fqdn + "/", null, this._token);
			
			String check = jsoOut.getString("status");
			
			if(jsoOut != null && check.indexOf("success") == 0)
			{
				DynectLoadBalanceObject lbObj[] = null;
				JSONArray lbArrayObj = jsoOut.getJSONArray("data");
				if(lbArrayObj != null)
				{
					lbObj = new DynectLoadBalanceObject[lbArrayObj.length()];
					for(int i = 0; i < lbArrayObj.length(); i++)
					{
						JSONObject jsoOutIndividual = MakeRestCall("GET",lbArrayObj.getString(i), null, this._token);
						lbObj[i] = DynectLoadBalanceObjectFactory(jsoOutIndividual.getJSONObject("data"));
					}
				}
				else
				{
					lbObj = new DynectLoadBalanceObject[1];
					lbObj[0] = DynectLoadBalanceObjectFactory(jsoOut.getJSONObject("data"));
				}
				
				return lbObj;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean AddDynectLoadBalance(DynectLoadBalanceObject obj)
	{
		return UpdateDynectLoadBalance(obj, obj.zone, obj.fqdn, null, "POST");
	}
	
	public boolean UpdateDynectLoadBalance(DynectLoadBalanceObject obj)
	{
		return UpdateDynectLoadBalance(obj, obj.zone, obj.fqdn, null, "PUT");
	}
	
	public boolean ActivateDynectLoadBalance(String zone, String fqdn)
	{
		return UpdateDynectLoadBalance(null, zone, fqdn, "activate", "PUT");
	}
	
	public boolean DeactivateDynectLoadBalance(String zone, String fqdn)
	{
		return UpdateDynectLoadBalance(null, zone, fqdn, "deactivate", "PUT");
	}
	
	public boolean RecoverDynectLoadBalance(String zone, String fqdn)
	{
		return UpdateDynectLoadBalance(null, zone, fqdn, "recover", "PUT");
	}
	
	public boolean RecoverDynectLoadBalanceIP(String zone, String fqdn, String ipAddress)
	{
		return UpdateDynectLoadBalance(null, zone, fqdn, ipAddress, "PUT");
	}
	
	private boolean UpdateDynectLoadBalance(DynectLoadBalanceObject obj, String zone, String fqdn, String action, String verb)
	{
		try {
			JSONObject jsoIn = new JSONObject();
			
			if(action != null) {
				if(action == "activate" || action == "deactivate" || action == "recover") {
					jsoIn.put(action, "true");
				}
				else {
					jsoIn.put("recoverip", "true");
					jsoIn.put("address", action);
				}
			}
			else
			{
				jsoIn = DynectLoadBalanceJSONFactory(obj);
			}
			
			JSONObject jsoOut = null;
			jsoOut = MakeRestCall(verb, "LoadBalance/" + zone + "/" +  fqdn + "/", jsoIn, this._token);
			
			if(jsoOut.getString("status") == "success")
			{
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean AddDynectLoadBalancePoolEntry(DynectLoadBalancePoolEntry obj, String zone, String fqdn)
	{
		return UpdateDynectLoadBalancePoolEntryWorker(obj, zone, fqdn, null);
	}
	
	public boolean UpdateDynectLoadBalancePoolEntry(DynectLoadBalancePoolEntry obj, String zone, String fqdn, String address)
	{
		return UpdateDynectLoadBalancePoolEntryWorker(obj, zone, fqdn, address);
	}
	
	private boolean UpdateDynectLoadBalancePoolEntryWorker(DynectLoadBalancePoolEntry obj, String zone, String fqdn, String address)
	{
		try {
			JSONObject jsoIn = new JSONObject();
			
			jsoIn = DynectLoadBalancePoolEntryJSONFactory(obj);
			
			
			JSONObject jsoOut = null;
			if(address == null)
				jsoOut = MakeRestCall("POST", "LoadBalancePoolEntry/" + zone + "/" +  fqdn + "/", jsoIn, this._token);
			else
				jsoOut = MakeRestCall("PUT", "LoadBalancePoolEntry/" + zone + "/" +  fqdn + "/" + address + "/", jsoIn, this._token);
			
			if(jsoOut.getString("status") == "success")
			{
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	private DynectLoadBalanceObject DynectLoadBalanceObjectFactory(JSONObject jso) {
		try {
			DynectLoadBalanceObject lbObj = new DynectLoadBalanceObject();
				
			JSONObject mainObj = null;
			if(jso.has("data")) {
				mainObj = jso.getJSONObject("data");
			}
			else
			{
				mainObj = jso;
			}
			
			lbObj.active = mainObj.getString("active").toUpperCase() == "Y" ? true : false;
			lbObj.auto_recover = mainObj.getString("auto_recover").toUpperCase() == "Y" ? true : false;
			lbObj.contact_nickname = mainObj.getString("contact_nickname");
			lbObj.failover_data = mainObj.getString("failover_data");
			lbObj.failover_mode = FailoverMode.StringToFailoverMode(mainObj.getString("failover_mode"));
			lbObj.fqdn = mainObj.getString("fqdn");
			lbObj.notify_events = NotifyOptions.StringToNotifyOptions(mainObj.getString("notify_events"));
			lbObj.serve_count = Integer.parseInt(mainObj.getString("serve_count"));
			lbObj.status = LoadBalanceStatus.StringToLoadBalanceStatus(mainObj.getString("status"));
			lbObj.ttl = TTLTimes.StringToTTLTimes(mainObj.getString("ttl"));
			lbObj.zone = mainObj.getString("zone");
			lbObj.monitor = DynectMonitorFactory(mainObj.getJSONObject("monitor"));
			
			JSONArray poolObj = mainObj.getJSONArray("pool");
			if(poolObj != null)
			{
				lbObj.pool = new DynectLoadBalancePoolEntry[poolObj.length()];
				for(int i = 0; i < poolObj.length(); i++)
				{
					lbObj.pool[i] = DynectLoadBalancePoolEntryFactory(poolObj.getJSONObject(i));
				}
			}
			
			return lbObj;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private DynectLoadBalancePoolEntry DynectLoadBalancePoolEntryFactory(JSONObject jso) {
		try {
			DynectLoadBalancePoolEntry lbpeObj = new DynectLoadBalancePoolEntry();
				
			JSONObject mainObj = null;
			if(jso.has("data")) {
				mainObj = jso.getJSONObject("data");
			}
			else
			{
				mainObj = jso;
			}
			
			lbpeObj.address = mainObj.getString("address");
			lbpeObj.label = mainObj.getString("label");
			lbpeObj.serve_mode = LoadBalancePoolEntryServeMode.StringToServeMode(mainObj.getString("serve_mode"));
			lbpeObj.status = LoadBalancePoolEntryStatus.StringToStatus(mainObj.getString("status"));
			lbpeObj.weight = LoadBalancePoolEntryWeight.StringToWeight(mainObj.getString("weight"));
			
			JSONArray logObj = mainObj.getJSONArray("log");
			if(logObj != null)
			{
				lbpeObj.log = new DynectLoadBalancePoolEntryLog[logObj.length()];
				for(int i = 0; i < logObj.length(); i++)
				{
					lbpeObj.log[i] = DynectLoadBalancePoolEntryLogFactory(logObj.getJSONObject(i));
				}
			}
			
			return lbpeObj;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private DynectLoadBalancePoolEntryLog DynectLoadBalancePoolEntryLogFactory(JSONObject jso) {
		try {
			DynectLoadBalancePoolEntryLog lbpelObj = new DynectLoadBalancePoolEntryLog();
				
			JSONObject mainObj = null;
			if(jso.has("data")) {
				mainObj = jso.getJSONObject("data");
			}
			else
			{
				mainObj = jso;
			}
			
			lbpelObj.message = mainObj.getString("message");
			lbpelObj.site_code = mainObj.getString("site_code");
			lbpelObj.status = LoadBalancePoolEntryStatus.StringToStatus(mainObj.getString("status"));
			lbpelObj.time = mainObj.getString("time");

			return lbpelObj;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	private JSONObject DynectLoadBalanceJSONFactory(DynectLoadBalanceObject obj) {
		try {
			JSONObject jsoOut = new JSONObject();
				
			jsoOut.put("auto_recover", obj.auto_recover ? "Y" : "N");
			jsoOut.put("contact_nickname", obj.contact_nickname);
			jsoOut.put("failover_data", obj.failover_data);
			jsoOut.put("failover_mode", obj.failover_mode.toString());
			jsoOut.put("notify_events", obj.notify_events.toString());
			jsoOut.put("serve_count", obj.serve_count);
			jsoOut.put("ttl", obj.ttl.toString());
			jsoOut.put("monitor", DynectMonitorJSONFactory(obj.monitor));
			
			
			if(obj.pool.length > 0)
			{
				JSONArray poolObj = new JSONArray();
				for(int i = 0; i < obj.pool.length; i++)
				{
					JSONObject o = DynectLoadBalancePoolEntryJSONFactory(obj.pool[i]);	
					poolObj.put(o);
				}
			}
			
			return jsoOut;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private JSONObject DynectLoadBalancePoolEntryJSONFactory(DynectLoadBalancePoolEntry obj) {
		try {
			JSONObject jsoOut = new JSONObject();

			jsoOut.put("address", obj.address);
			jsoOut.put("label", obj.label);
			jsoOut.put("server_mode", obj.serve_mode.toString());
			jsoOut.put("weight", obj.weight.toString());
			
			return jsoOut;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
