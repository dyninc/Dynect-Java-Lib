package dynect;

import org.json.JSONObject;

public class DynectRecords extends Dynect {

	public DynectRecords(String user_name, String customer_name, String password)
	{
		super(user_name, customer_name, password);
	}

	public boolean AddAAAARecord(String zone, String fqdn, String address, int ttl)
	{
		return AddRecord(DynectRecordType.AAAARecord, Integer.toString(ttl), zone, fqdn, address);
	}
	
	public boolean AddARecord(String zone, String fqdn, String address, int ttl)
	{
		return AddRecord(DynectRecordType.ARecord, Integer.toString(ttl), zone, fqdn, address);
	}
	
	public boolean AddCNAMERecord(String zone, String fqdn, String cname, int ttl)
	{
		return AddRecord(DynectRecordType.CNAMERecord, Integer.toString(ttl), zone, fqdn, cname);
	}
	
	public boolean AddDHCIDRecord(String zone, String fqdn, String digest, int ttl)
	{
		return AddRecord(DynectRecordType.DHCIDRecord, Integer.toString(ttl), zone, fqdn, digest);
	}
	
	public boolean AddDNAMERecord(String zone, String fqdn, String dname, int ttl)
	{
		return AddRecord(DynectRecordType.DNAMERecord, Integer.toString(ttl), zone, fqdn, dname);
	}
	
	public boolean AddDNSKEYRecord(String zone, String fqdn, String algorithm, String flags, String protocol, String public_key, int ttl)
	{
		return AddRecord(DynectRecordType.DNSKEYRecord, Integer.toString(ttl), zone, fqdn, algorithm, flags, protocol, public_key);
	}
	
	public boolean AddDSRecord(String zone, String fqdn, String algorithm, String flags, String protocol, String public_key, int ttl)
	{
		return AddRecord(DynectRecordType.DSRecord, Integer.toString(ttl), zone, fqdn, algorithm, flags, protocol, public_key);
	}

	public boolean AddKEYRecord(String zone, String fqdn, String algorithm, String flags, String protocol, String public_key, int ttl)
	{
		return AddRecord(DynectRecordType.KEYRecord, Integer.toString(ttl), zone, fqdn, algorithm, flags, protocol, public_key);
	}

	public boolean AddLOCRecord(String zone, String fqdn, String altitude, String horiz_pre, String latitude, String longitude, String size, String version, String vert_pre, int ttl)
	{
		return AddRecord(DynectRecordType.LOCRecord, Integer.toString(ttl), zone, fqdn, altitude, horiz_pre, latitude, longitude, size, version, vert_pre);
	}
	
	public boolean AddMXRecord(String zone, String fqdn, String exchange, String preference, int ttl)
	{
		return AddRecord(DynectRecordType.MXRecord, Integer.toString(ttl), zone, fqdn, exchange, preference);
	}

	public boolean AddNSAPRecord(String zone, String fqdn, String nsap, int ttl)
	{
		return AddRecord(DynectRecordType.NSAPRecord, Integer.toString(ttl), zone, fqdn, nsap);
	}
	
	public boolean AddNSRecord(String zone, String fqdn, String nsdname, int ttl)
	{
		return AddRecord(DynectRecordType.NSRecord, Integer.toString(ttl), zone, fqdn, nsdname);
	}
	
	public boolean AddPTRRecord(String zone, String fqdn, String ptrdname, int ttl)
	{
		return AddRecord(DynectRecordType.PTRRecord, Integer.toString(ttl), zone, fqdn, ptrdname);
	}

	public boolean AddPXRecord(String zone, String fqdn, String preference, String map822, String mapx400, int ttl)
	{
		return AddRecord(DynectRecordType.PXRecord, Integer.toString(ttl), zone, fqdn, preference, map822, mapx400);
	}

	public boolean AddRPRecord(String zone, String fqdn, String mbox, String txtdname, int ttl)
	{
		return AddRecord(DynectRecordType.RPRecord, Integer.toString(ttl), zone, fqdn, mbox, txtdname);
	}

	public boolean AddSOARecord(String zone, String fqdn, String rname, int ttl)
	{
		return AddRecord(DynectRecordType.SOARecord, Integer.toString(ttl), zone, fqdn, rname);
	}
	
	public boolean AddSPFRecord(String zone, String fqdn, String txtdata, int ttl)
	{
		return AddRecord(DynectRecordType.SPFRecord, Integer.toString(ttl), zone, fqdn, txtdata);
	}

	public boolean AddSRVRecord(String zone, String fqdn, String port, String priority, String target, String weight, int ttl)
	{
		return AddRecord(DynectRecordType.SRVRecord, Integer.toString(ttl), zone, fqdn, port, priority, target, weight);
	}

	public boolean AddSSHFPRecord(String zone, String fqdn, String algorithm, String fptype, String fingerprint, int ttl)
	{
		return AddRecord(DynectRecordType.SSHFPRecord, Integer.toString(ttl), zone, fqdn, algorithm, fptype, fingerprint);
	}
	
	public boolean AddTXTRecord(String zone, String fqdn, String txtdata, int ttl)
	{
		return AddRecord(DynectRecordType.TXTRecord, Integer.toString(ttl), zone, fqdn, txtdata);
	}
	
	public boolean UpdateAAAARecord(String zone, String fqdn, String id, String address, int ttl)
	{
		return UpdateRecord(DynectRecordType.AAAARecord, Integer.toString(ttl), id, zone, fqdn, address);
	}
	
	public boolean UpdateARecord(String zone, String fqdn, String id, String address, int ttl)
	{
		return UpdateRecord(DynectRecordType.ARecord, Integer.toString(ttl), id, zone, fqdn, address);
	}
	
	public boolean UpdateCNAMERecord(String zone, String fqdn, String id, String cname, int ttl)
	{
		return UpdateRecord(DynectRecordType.CNAMERecord, Integer.toString(ttl), id, zone, fqdn, cname);
	}
	
	public boolean UpdateDHCIDRecord(String zone, String fqdn, String id, String digest, int ttl)
	{
		return UpdateRecord(DynectRecordType.DHCIDRecord, Integer.toString(ttl), id, zone, fqdn, digest);
	}
	
	public boolean UpdateDNAMERecord(String zone, String fqdn, String id, String dname, int ttl)
	{
		return UpdateRecord(DynectRecordType.DNAMERecord, Integer.toString(ttl), id, zone, fqdn, dname);
	}
	
	public boolean UpdateDNSKEYRecord(String zone, String fqdn, String id, String algorithm, String flags, String protocol, String public_key, int ttl)
	{
		return UpdateRecord(DynectRecordType.DNSKEYRecord, Integer.toString(ttl), id, zone, fqdn, algorithm, flags, protocol, public_key);
	}
	
	public boolean UpdateDSRecord(String zone, String fqdn, String id, String algorithm, String flags, String protocol, String public_key, int ttl)
	{
		return UpdateRecord(DynectRecordType.DSRecord, Integer.toString(ttl), id, zone, fqdn, algorithm, flags, protocol, public_key);
	}

	public boolean UpdateKEYRecord(String zone, String fqdn, String id, String algorithm, String flags, String protocol, String public_key, int ttl)
	{
		return UpdateRecord(DynectRecordType.KEYRecord, Integer.toString(ttl), id, zone, fqdn, algorithm, flags, protocol, public_key);
	}

	public boolean UpdateLOCRecord(String zone, String fqdn, String id, String altitude, String horiz_pre, String latitude, String longitude, String size, String version, String vert_pre, int ttl)
	{
		return UpdateRecord(DynectRecordType.LOCRecord, Integer.toString(ttl), id, zone, fqdn, altitude, horiz_pre, latitude, longitude, size, version, vert_pre);
	}
	
	public boolean UpdateMXRecord(String zone, String fqdn, String id, String exchange, String preference, int ttl)
	{
		return UpdateRecord(DynectRecordType.MXRecord, Integer.toString(ttl), id, zone, fqdn, exchange, preference);
	}

	public boolean UpdateNSAPRecord(String zone, String fqdn, String id, String nsap, int ttl)
	{
		return UpdateRecord(DynectRecordType.NSAPRecord, Integer.toString(ttl), id, zone, fqdn, nsap);
	}
	
	public boolean UpdateNSRecord(String zone, String fqdn, String id, String nsdname, int ttl)
	{
		return UpdateRecord(DynectRecordType.NSRecord, Integer.toString(ttl), id, zone, fqdn, nsdname);
	}
	
	public boolean UpdatePTRRecord(String zone, String fqdn, String id, String ptrdname, int ttl)
	{
		return UpdateRecord(DynectRecordType.PTRRecord, Integer.toString(ttl), id, zone, fqdn, ptrdname);
	}

	public boolean UpdatePXRecord(String zone, String fqdn, String id, String preference, String map822, String mapx400, int ttl)
	{
		return UpdateRecord(DynectRecordType.PXRecord, Integer.toString(ttl), id, zone, fqdn, preference, map822, mapx400);
	}

	public boolean UpdateRPRecord(String zone, String fqdn, String id, String mbox, String txtdname, int ttl)
	{
		return UpdateRecord(DynectRecordType.RPRecord, Integer.toString(ttl), id, zone, fqdn, mbox, txtdname);
	}

	public boolean UpdateSOARecord(String zone, String fqdn, String id, String rname, int ttl)
	{
		return UpdateRecord(DynectRecordType.SOARecord, Integer.toString(ttl), id, zone, fqdn, rname);
	}
	
	public boolean UpdateSPFRecord(String zone, String fqdn, String id, String txtdata, int ttl)
	{
		return UpdateRecord(DynectRecordType.SPFRecord, Integer.toString(ttl), id, zone, fqdn, txtdata);
	}

	public boolean UpdateSRVRecord(String zone, String fqdn, String id, String port, String priority, String target, String weight, int ttl)
	{
		return UpdateRecord(DynectRecordType.SRVRecord, Integer.toString(ttl), id, zone, fqdn, port, priority, target, weight);
	}

	public boolean UpdateSSHFPRecord(String zone, String fqdn, String id, String algorithm, String fptype, String fingerprint, int ttl)
	{
		return UpdateRecord(DynectRecordType.SSHFPRecord, Integer.toString(ttl), id, zone, fqdn, algorithm, fptype, fingerprint);
	}
	
	public boolean UpdateTXTRecord(String zone, String fqdn, String id, String txtdata, int ttl)
	{
		return UpdateRecord(DynectRecordType.TXTRecord, Integer.toString(ttl), id, zone, fqdn, txtdata);
	}
	
	public boolean RemoveAAAARecord(String zone, String fqdn, String id)
	{
		return RemoveRecord(DynectRecordType.AAAARecord, zone, fqdn, id);
	}
	
	public boolean RemoveARecord(String zone, String fqdn, String id)
	{
		return RemoveRecord(DynectRecordType.ARecord, zone, fqdn, id);
	}
	
	public boolean RemoveCNAMERecord(String zone, String fqdn, String id)
	{
		return RemoveRecord(DynectRecordType.CNAMERecord, zone, fqdn, id);
	}
	
	public boolean RemoveDHCIDRecord(String zone, String fqdn, String id)
	{
		return RemoveRecord(DynectRecordType.DHCIDRecord, zone, fqdn, id);
	}
	
	public boolean RemoveDNAMERecord(String zone, String fqdn, String id)
	{
		return RemoveRecord(DynectRecordType.DNAMERecord, zone, fqdn, id);
	}
	
	public boolean RemoveDNSKEYRecord(String zone, String fqdn, String id)
	{
		return RemoveRecord(DynectRecordType.DNSKEYRecord, zone, fqdn, id);
	}
	
	public boolean RemoveDSRecord(String zone, String fqdn, String id)
	{
		return RemoveRecord(DynectRecordType.DSRecord, zone, fqdn, id);
	}

	public boolean RemoveKEYRecord(String zone, String fqdn, String id)
	{
		return RemoveRecord(DynectRecordType.KEYRecord, zone, fqdn, id);
	}

	public boolean RemoveLOCRecord(String zone, String fqdn, String id)
	{
		return RemoveRecord(DynectRecordType.LOCRecord, zone, fqdn, id);
	}
	
	public boolean RemoveMXRecord(String zone, String fqdn, String id)
	{
		return RemoveRecord(DynectRecordType.MXRecord, zone, fqdn, id);
	}

	public boolean RemoveNSAPRecord(String zone, String fqdn, String id)
	{
		return RemoveRecord(DynectRecordType.NSAPRecord, zone, fqdn, id);
	}
	
	public boolean RemoveNSRecord(String zone, String fqdn, String id)
	{
		return RemoveRecord(DynectRecordType.NSRecord, zone, fqdn, id);
	}
	
	public boolean RemovePTRRecord(String zone, String fqdn, String id)
	{
		return RemoveRecord(DynectRecordType.PTRRecord, zone, fqdn, id);
	}

	public boolean RemovePXRecord(String zone, String fqdn, String id)
	{
		return RemoveRecord(DynectRecordType.PXRecord, zone, fqdn, id);
	}

	public boolean RemoveRPRecord(String zone, String fqdn, String id)
	{
		return RemoveRecord(DynectRecordType.RPRecord, zone, fqdn, id);
	}

	public boolean RemoveSOARecord(String zone, String fqdn, String id)
	{
		return RemoveRecord(DynectRecordType.SOARecord, zone, fqdn, id);
	}
	
	public boolean RemoveSPFRecord(String zone, String fqdn, String id)
	{
		return RemoveRecord(DynectRecordType.SPFRecord, zone, fqdn, id);
	}

	public boolean RemoveSRVRecord(String zone, String fqdn, String id)
	{
		return RemoveRecord(DynectRecordType.SRVRecord, zone, fqdn, id);
	}

	public boolean RemoveSSHFPRecord(String zone, String fqdn, String id)
	{
		return RemoveRecord(DynectRecordType.SSHFPRecord, zone, fqdn, id);
	}
	
	public boolean RemoveTXTRecord(String zone, String fqdn, String id)
	{
		return RemoveRecord(DynectRecordType.TXTRecord, zone, fqdn, id);
	}
	public String GetAAAARecord(String zone, String fqdn, String id)
	{
		return GetRecord(DynectRecordType.AAAARecord, zone, fqdn, id);
	}
	
	public String GetARecord(String zone, String fqdn, String id)
	{
		return GetRecord(DynectRecordType.ARecord, zone, fqdn, id);
	}
	
	public String GetCNAMERecord(String zone, String fqdn, String id)
	{
		return GetRecord(DynectRecordType.CNAMERecord, zone, fqdn, id);
	}
	
	public String GetDHCIDRecord(String zone, String fqdn, String id)
	{
		return GetRecord(DynectRecordType.DHCIDRecord, zone, fqdn, id);
	}
	
	public String GetDNAMERecord(String zone, String fqdn, String id)
	{
		return GetRecord(DynectRecordType.DNAMERecord, zone, fqdn, id);
	}
	
	public String GetDNSKEYRecord(String zone, String fqdn, String id)
	{
		return GetRecord(DynectRecordType.DNSKEYRecord, zone, fqdn, id);
	}
	
	public String GetDSRecord(String zone, String fqdn, String id)
	{
		return GetRecord(DynectRecordType.DSRecord, zone, fqdn, id);
	}

	public String GetKEYRecord(String zone, String fqdn, String id)
	{
		return GetRecord(DynectRecordType.KEYRecord, zone, fqdn, id);
	}

	public String GetLOCRecord(String zone, String fqdn, String id)
	{
		return GetRecord(DynectRecordType.LOCRecord, zone, fqdn, id);
	}
	
	public String GetMXRecord(String zone, String fqdn, String id)
	{
		return GetRecord(DynectRecordType.MXRecord, zone, fqdn, id);
	}

	public String GetNSAPRecord(String zone, String fqdn, String id)
	{
		return GetRecord(DynectRecordType.NSAPRecord, zone, fqdn, id);
	}
	
	public String GetNSRecord(String zone, String fqdn, String id)
	{
		return GetRecord(DynectRecordType.NSRecord, zone, fqdn, id);
	}
	
	public String GetPTRRecord(String zone, String fqdn, String id)
	{
		return GetRecord(DynectRecordType.PTRRecord, zone, fqdn, id);
	}

	public String GetPXRecord(String zone, String fqdn, String id)
	{
		return GetRecord(DynectRecordType.PXRecord, zone, fqdn, id);
	}

	public String GetRPRecord(String zone, String fqdn, String id)
	{
		return GetRecord(DynectRecordType.RPRecord, zone, fqdn, id);
	}

	public String GetSOARecord(String zone, String fqdn, String id)
	{
		return GetRecord(DynectRecordType.SOARecord, zone, fqdn, id);
	}
	
	public String GetSPFRecord(String zone, String fqdn, String id)
	{
		return GetRecord(DynectRecordType.SPFRecord, zone, fqdn, id);
	}

	public String GetSRVRecord(String zone, String fqdn, String id)
	{
		return GetRecord(DynectRecordType.SRVRecord, zone, fqdn, id);
	}

	public String GetSSHFPRecord(String zone, String fqdn, String id)
	{
		return GetRecord(DynectRecordType.SSHFPRecord, zone, fqdn, id);
	}
	
	public String GetTXTRecord(String zone, String fqdn, String id)
	{
		return GetRecord(DynectRecordType.TXTRecord, zone, fqdn, id);
	}
	
	private String GetRecord(DynectRecordType dr, String zone, String fqdn, String id)
	{
		JSONObject jsoOut;
		try {
			jsoOut = MakeRestCall("GET", dr.toString() + "/" + zone + "/" +  fqdn + "/" + id, null, this._token);
			
			if(jsoOut.getString("status") == "success")
			{
				return jsoOut.toString();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	private boolean RemoveRecord(DynectRecordType dr, String zone, String fqdn, String id)
	{
		JSONObject jsoOut;
		try {
			jsoOut = MakeRestCall("DELETE", dr.toString() + "/" + zone + "/" +  fqdn + "/" + id, null, this._token);
			
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

	private boolean AddRecord(DynectRecordType dr, String ttl, String ... args)
	{
		return UpdateRecord(dr, ttl, null, args);
	}
	
	private boolean UpdateRecord(DynectRecordType dr, String ttl, String id, String ... args)
	{
		try {
			JSONObject jso = new JSONObject();

			jso.put("fqdn", args[0]);
			jso.put("zone", args[1]);
			
			if(ttl != null) {
				jso.put("ttl", ttl);
			}
			
			JSONObject rdata = new JSONObject();
			switch (dr)
			{
				case AAAARecord:
					rdata.put("address", args[2]);
					jso.put("rdata", rdata);
				break;
				
				case ARecord:
					rdata.put("address", args[2]);
					jso.put("rdata", rdata);
				break;
				
				case CNAMERecord:
					rdata.put("cname", args[2]);
					jso.put("rdata", rdata);
				break;
				
				case DHCIDRecord:
					rdata.put("digest", args[2]);
					jso.put("rdata", rdata);
				break;
				
				case DNAMERecord:
					rdata.put("dname", args[2]);
					jso.put("rdata", rdata);
				break;
				
				case DNSKEYRecord:
					rdata.put("algorithm", args[2]);
					rdata.put("flags", args[3]);
					rdata.put("protocol", args[4]);
					rdata.put("public_key", args[5]);
					jso.put("rdata", rdata);
				break;
				
				case DSRecord:
					rdata.put("algorithm", args[2]);
					rdata.put("flags", args[3]);
					rdata.put("protocol", args[4]);
					rdata.put("public_key", args[5]);
					jso.put("rdata", rdata);
				break;
				
				case KEYRecord:
					rdata.put("algorithm", args[2]);
					rdata.put("flags", args[3]);
					rdata.put("protocol", args[4]);
					rdata.put("public_key", args[5]);
					jso.put("rdata", rdata);
				break;
				
				case LOCRecord:
					rdata.put("altitude", args[2]);
					rdata.put("horiz_pre", args[3]);
					rdata.put("latitude", args[4]);
					rdata.put("longitude", args[5]);
					rdata.put("size", args[6]);
					rdata.put("version", args[7]);
					rdata.put("vert_pre", args[8]);
					jso.put("rdata", rdata);
				break;
				
				case MXRecord:
					rdata.put("exchange", args[2]);
					rdata.put("preference", args[3]);
					jso.put("rdata", rdata);
				break;
				
				case NSAPRecord:
					rdata.put("nsap", args[2]);
					jso.put("rdata", rdata);
				break;
				
				case NSRecord:
					rdata.put("nsdname", args[2]);
					jso.put("rdata", rdata);
				break;
				
				case PTRRecord:
					rdata.put("ptrdname", args[2]);
					jso.put("rdata", rdata);
				break;
				
				case PXRecord:
					rdata.put("preference", args[2]);
					rdata.put("map822", args[3]);
					rdata.put("mapx400", args[5]);
					jso.put("rdata", rdata);
				break;
				
				case RPRecord:
					rdata.put("mbox", args[2]);
					rdata.put("txtdname", args[3]);
					jso.put("rdata", rdata);
				break;
				
				case SOARecord:
					rdata.put("rname", args[2]);
					jso.put("rdata", rdata);
				break;
				
				case SPFRecord:
					rdata.put("txtdata", args[2]);
					jso.put("rdata", rdata);
				break;
				
				case SRVRecord:
					rdata.put("port", args[2]);
					rdata.put("priority", args[3]);
					rdata.put("target", args[4]);
					rdata.put("weight", args[5]);
					jso.put("rdata", rdata);
				break;
				
				case SSHFPRecord:
					rdata.put("algorithm", args[2]);
					rdata.put("fptype", args[3]);
					rdata.put("fingerprint", args[4]);
					jso.put("rdata", rdata);
				break;
				
				case TXTRecord:
					rdata.put("txtdata", args[2]);
					jso.put("rdata", rdata);
				break;
				
			}
			JSONObject jsoOut = null;
			if(id == null)
				jsoOut = MakeRestCall("POST", dr.toString() + "/" + args[1] + "/" +  args[0] + "/", jso, this._token);
			else
				jsoOut = MakeRestCall("PUT", dr.toString() + "/" + args[1] + "/" +  args[0] + "/" + id + "/", jso, this._token);
				
			if(jsoOut != null && jsoOut.getString("status") == "success")
			{
				return true;
			}
		}
		catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
