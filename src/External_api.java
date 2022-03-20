import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author bijay
 *class for rest api
 */
public class External_api {
	
	/**
	 * @param args array of string
	 * @throws Exception if connection is not established
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub		
		
		
		
		  String url = "https://freegeoip.app/json/"; HttpClient client =
		  HttpClient.newHttpClient(); 
		  HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build(); 
		  HttpResponse<String> response=client.send(request, BodyHandlers.ofString());
		  System.out.println(response.body());
		  
		  
	}
	/**
	 * @param response string to fetch json data
	 * @return returns null
	 * @throws JSONException if json data is not available
	 */
	public static String parse(String response) throws JSONException{
	      JSONArray albums = new JSONArray(response);
	      for(int i=0;i<albums.length(); i++){
	          JSONObject album = albums.getJSONObject(i);
	          String country_code = album.getString("country_code");
	          System.out.println("For the Country"+" "+ country_code);
	           
	      }
	     
	       return null;
	  }	

}
