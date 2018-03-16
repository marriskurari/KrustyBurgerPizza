
import jdk.nashorn.api.scripting.JSObject;
import org.json.*;

import java.io.*;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;


public class Request {

private static final String dburl = "http://localhost:8080/database/";

	private String requestString;
	private HttpURLConnection con;

	private class Parameters extends HashMap<String, String> {
		public Parameters(HashMap<String, String> parameters) {
		 	for(Entry<String,String> entry : parameters.entrySet()) {
				this.put(entry.getKey(), entry.getValue());
			}
		}

		public void addParameter(String param, String value) {
			this.put(param, value);
		}

		@Override
		public String toString() {
			String s = "";
			for(Entry<String,String> entry : this.entrySet()) {
				s += entry.getKey();
				s += "=";
				s += entry.getValue();
				s += "&";
			}
			try {
				s = URLEncoder.encode(s, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return s.length() > 0 ?  s.substring(0,s.length()-2) : s;
		}
	}

	private HttpURLConnection makeRequest() throws IOException {
		URL url = new URL(requestString);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		return con;
	}

	public void addParameters(HashMap<String, String>  parameters) throws IOException {
		Parameters params = new Parameters(parameters);
		con.setDoOutput(true);
		DataOutputStream out = new DataOutputStream(con.getOutputStream());
		out.writeBytes(params.toString());
		out.flush();
		out.close();
	}

	private String extractJSONstringFromRequest() throws IOException {
		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream())
		);
		String inputLine;
		StringBuffer responsetext = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			responsetext.append(inputLine);
		}
		in.close();
		return responsetext.toString();
	}

	private JSONArray getParsedJSONbyStringRequest() throws IOException {
		String json = extractJSONstringFromRequest();
		JSONArray obj;
		try {
			obj = new JSONArray(json);
		} catch (JSONException e) {
			return new JSONArray("[\"" + json + "\"]");
		}
		return obj;
	}

	private void initRequest(String string) throws IOException {
		this.requestString = dburl + string;
		this.con = makeRequest();
	}

	public Request(String string) throws IOException {
	    initRequest(string);
	}

	public Request(String string, HashMap<String, String> params) throws IOException {
		initRequest(string);
		addParameters(params);
	}

	public JSONArray resolve() throws IOException {
		return getParsedJSONbyStringRequest();
	}

}
