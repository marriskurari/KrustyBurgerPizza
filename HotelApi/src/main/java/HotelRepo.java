
import generator.hotel.Hotel;
import org.json.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Vantar i augnablikinu "rooms" en thetta er bara bradabirgda i augnablikinu
 */
public class HotelRepo {
	private void parseJSON(JSONObject json) {
		System.out.println("HAHAHAHA");
	}

	public Hotel makeHotel(Long id, int numrooms, double latitude, double longtitude, String name, String email) {
		Hotel hotel = new Hotel();
		hotel.setId(id);
		hotel.setNumRooms(numrooms);
		hotel.setLatitude(latitude);
		hotel.setLongitude(longtitude);
		hotel.setName(name);
		hotel.setEmail(email);
		return hotel;
	}

	private Hotel jsonToHotel(JSONObject json) {
		Long id = Long.parseLong(json.get("id").toString());
		int numRooms = (int) json.get("numRooms");
		Double longitude = (Double) json.get("longitude");
		Double latitude = (Double) json.get("latitude");
		String name = (String) json.get("name");
		String email = (String) json.get("email");
		return makeHotel(id, numRooms, latitude, longitude, name, email);
	}

	public String uploadHotel(Hotel hotel) throws IOException {
		Request r = new Request("addHotel", hotel.getParameters());
		System.out.println(hotel.getParameters());
		r.resolve();
		return "Success";
	}

	public List<Hotel> getAll() throws IOException {
		Request r = new Request("allHotels");
		JSONArray json = r.resolve();
		String s = json.toString();
		List<Hotel> hotels = new ArrayList<>();
		for(int i = 0; i < json.length(); i++)
			hotels.add(jsonToHotel((JSONObject) json.get(i)));
		return hotels;
	}

}
