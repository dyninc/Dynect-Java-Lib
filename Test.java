import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import dynect.DynectLoadBalance;
import dynect.DynectLoadBalance.DynectLoadBalanceObject;
import dynect.DynectLoadBalance.DynectLoadBalancePoolEntry;
import dynect.DynectRecords;

class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynectRecords dyn = new DynectRecords("user_name", "customer_name", "password");
		dyn.AddARecord("mynewzone.net", "mynewzone.net", "22.33.44.5", 30);
		dyn.PublishZone("mynewzone.net");
		
		DynectLoadBalance dynLoadBalance = new DynectLoadBalance("user_name", "customer_name", "pasword");
		DynectLoadBalanceObject[] loadBalance = dynLoadBalance.GetDynectLoadBalance("zone1.net");
		
		DynectLoadBalancePoolEntry pe = dynLoadBalance.new DynectLoadBalancePoolEntry();
		pe.address = "22.33.44.65";
		pe.label = "test_API";
		pe.serve_mode = DynectLoadBalance.LoadBalancePoolEntryServeMode.always;
		pe.weight = DynectLoadBalance.LoadBalancePoolEntryWeight.one;
		dynLoadBalance.AddDynectLoadBalancePoolEntry(pe, "zone1.net", "zone1.net");
		dynLoadBalance.PublishZone("zone1.net");
	}

}
