package generator.hotel;

import generator.Entity;
import generator.Factory;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: PACKAGE_NAME
 */

public class HotelFactory<H extends HotelEntity> extends Factory {
	public HotelFactory() {
		this.updateURL = "addHotel";
		this.getAllURL = "allHotels";
	}

	public Hotel generate() {
		Hotel hotel = new Hotel(
			 randomInt(72),
			 getRandom(hotelName),
			 getRandom(email),
			 randomDouble(60, 3),
			 randomDouble(-20, 3),
			 getRandomMap(amenities)
		);
		return hotel;
	}

	public H jsonToEntity(JSONObject json) {
		H h = (H) new HotelEntity();
		h.setId(Long.parseLong(json.get("id").toString()));
		h.setNumRooms((int) json.get("numRooms"));
		h.setLongitude((Double) json.get("longitude"));
		h.setLatitude((Double) json.get("latitude"));
		h.setEmail((String) json.get("email"));
		h.setName((String) json.get("name"));
		Map<Integer, String> amenities = new HashMap<>();
		amenities.put(0, "nothing");
		System.out.println("H get name :) ;);); " + h.getName());
		return h;
	}
}