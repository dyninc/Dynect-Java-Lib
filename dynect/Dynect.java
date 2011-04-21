package dynect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

import org.json.JSONObject;

import java.net.URL;

public abstract class Dynect {

	public class DynectMonitor {
		
		public MonitorProtocol protocol;
		public MonitorIntervals interval;
		public int retries;
		public int port;
		public String path;
		public String header;
		public String expected;
	}
	
	protected JSONObject DynectMonitorJSONFactory(DynectMonitor obj) {
		try {
			JSONObject jsoOut = new JSONObject();
			
			jsoOut.put("expected", obj.expected);
			jsoOut.put("header", obj.header);
			jsoOut.put("interval", obj.interval.toString());
			jsoOut.put("path", obj.path);
			jsoOut.put("port", obj.port);
			jsoOut.put("protocol", obj.protocol.toString());
			jsoOut.put("retries", obj.retries);
			
			return jsoOut;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	protected DynectMonitor DynectMonitorFactory(JSONObject jso) {
		try {
			DynectMonitor monObj = new DynectMonitor();
				
			JSONObject mainObj = null;
			if(jso.has("data")) {
				mainObj = jso.getJSONObject("data");
			}
			else
			{
				mainObj = jso;
			}
			
			monObj.expected = mainObj.getString("expected");
			monObj.header = mainObj.getString("header");
			monObj.interval = MonitorIntervals.StringToMonitorIntervals(mainObj.getString("interval"));
			monObj.path = mainObj.getString("path");
			monObj.port = Integer.parseInt(mainObj.getString("port"));
			monObj.protocol = MonitorProtocol.StringToMonitorProtocol(mainObj.getString("protocol"));
			monObj.retries = Integer.parseInt(mainObj.getString("retries"));
			
			return monObj;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	protected static String BASE_URL = "https://api2.dynect.net";
	protected String _token = null;
	
	public Dynect()
	{
		this._token = null;
	}
	
	public Dynect(String user_name, String customer_name, String password)
	{
		SessionConnect(user_name, customer_name, password);
	}
	
	public boolean IsSessionAlive()
	{
		try {
			
			this._token = null;
			
			
			JSONObject jsoOut = MakeRestCall("GET", "Session", null, this._token);
			
			if(jsoOut.getString("status") == "success")
			{
				return true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean KeepSessionAlive()
	{
		try {
			
			this._token = null;
			
			
			JSONObject jsoOut = MakeRestCall("PUT", "Session", null, this._token);
			
			if(jsoOut.getString("status") == "success")
			{
				return true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean SessionConnect(String user_name, String customer_name, String password)
	{
		try {
			
			this._token = null;
			
			JSONObject jso = new JSONObject();
			jso.put("user_name", user_name);
			jso.put("customer_name", customer_name);
			jso.put("password", password);
			
			JSONObject jsoOut = MakeRestCall("POST", "Session", jso, null);
			
			this._token = jsoOut.getJSONObject("data").getString("token");
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean SessionDisconnect()
	{
		try {
			
			MakeRestCall("DELETE", "Session", null, _token);
			
			this._token = null;
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean PublishZone(String zone)
	{
		JSONObject jsoOut;
		try {
			
			JSONObject jso = new JSONObject();
			jso.put("publish", "true");
			
			jsoOut = MakeRestCall("PUT", "Zone/" + zone, jso, this._token);
			
			if(jsoOut.getString("status") == "success")
			{
				return true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	protected JSONObject MakeRestCall(String verb, String function, JSONObject json, String token) throws Exception
	{
		URL url = null;
		if(function.startsWith("/REST/")) {
			url = new URL(BASE_URL + function);
		}
		else if(function.startsWith("REST/")) {
			url = new URL(BASE_URL + "/" + function);
		}
		else {
			url = new URL(BASE_URL + "/REST/" + function);
		}
		
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();        
        connection.setRequestMethod(verb);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setAllowUserInteraction(false);
        connection.setRequestProperty("Content-Type", "application/json");
        if(token != null)
        {
            connection.setRequestProperty("Auth-Token", token);
        }
        
        if(json != null)
        {
	        OutputStreamWriter out = new OutputStreamWriter(
	        		connection.getOutputStream());
	        out.write(json.toString());
	        out.close();
        }
        
        if (connection.getResponseCode() != 200) {
        	throw new IOException(connection.getResponseMessage());
    	}

    	// Buffer the result into a string
    	BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    	StringBuilder sb = new StringBuilder();
    	String line;
    	
    	while ((line = rd.readLine()) != null) {
    		sb.append(line);
    	}
    	rd.close();
    	
    	JSONObject retJson = null;
    	try	{
        	retJson = new JSONObject(sb.toString());
    	}
    	catch(Exception e) {
			e.printStackTrace();
    	}
    	
		return retJson;
	}
}
