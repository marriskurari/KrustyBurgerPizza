
import org.json.*;

import java.io.IOException;


public class HotelRepo {
    private void parseJSON(JSONObject json) {
    	System.out.println("HAHAHAHA");
	}

	public Hotel makeHotel(int id, int numrooms, double latitude, double longtitude, String name, String email) {
		Hotel hotel = new Hotel();
		hotel.setId(id);
		hotel.setNumRooms(numrooms);
		hotel.setLatitude(latitude);
		hotel.setLongtitude(longtitude);
		hotel.setName(name);
		hotel.setEmail(email);
		return hotel;
	}

	public String uploadHotel(Hotel hotel) throws IOException {
    	Request r = new Request("addHotel");
    	r.addParameters(hotel.getParameters());
	}


	public Hotel[] getAll() throws IOException {
		Request r = new Request("allHotels");
		JSONArray json = r.resolve();
		Hotel[] hotels = new Hotel[2];
		return hotels;
	}

}
