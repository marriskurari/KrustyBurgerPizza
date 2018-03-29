package generator.availability;

import generator.Factory;
import generator.hotel.Hotel;
import generator.hotel.HotelEntity;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: PACKAGE_NAME
 */

public class AvailabilityFactory extends Factory {
	public AvailabilityFactory() {
		this.updateURL = "addAvailability";
		this.getAllURL = "allAvailabilities";
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
	public HotelEntity jsonToEntity(JSONObject json) {
		Long id = Long.parseLong(json.get("id").toString());
		int numRooms = (int) json.get("numRooms");
		Double longitude = (Double) json.get("longitude");
		Double latitude = (Double) json.get("latitude");
		String name = (String) json.get("name");
		String email = (String) json.get("email");
		Map<Integer, String> amenities = new HashMap<>();
		amenities.put(0, "nothing");
		return new HotelEntity(id, numRooms, latitude, longitude, name, email, amenities);
	}
}