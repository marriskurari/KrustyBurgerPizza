
package generator;

import javafx.util.Pair;
import jdk.nashorn.api.scripting.JSObject;
import org.json.*;

import java.io.*;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;


public class Request {

	private static final String dburl = "http://localhost:8080/database/";

	private String requestString;
	private HttpURLConnection con;

	private HttpURLConnection makeRequest() throws IOException {
		URL url = new URL(requestString);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		return con;
	}

	public void addParameters(List<Pair<String, String>> parameters) throws IOException {
	    String s = "?";
	    for(Pair<String, String> keyAndValue : parameters) {
	    	s += keyAndValue.getKey();
	    	s += "=";
	    	s += keyAndValue.getValue();
	    	s += "&";
		}
		//cut off last character
		s = s.substring(0, s.length() - 1);

		requestString += s;
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
	}

	public Request(String string) throws IOException {
		initRequest(string);
		con = makeRequest();
	}

	public Request(String string, List<Pair<String, String>> params) throws IOException {
		initRequest(string);
		addParameters(params);
		con = makeRequest();
	}

	public JSONArray resolve() throws IOException {
		return getParsedJSONbyStringRequest();
	}

}
