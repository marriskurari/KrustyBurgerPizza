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

public class HotelFactory<Ent extends HotelEntity> extends Factory {
	public HotelFactory() {
		this.updateURL = "addHotel";
		this.getAllURL = "allHotels";
		this.removeURL = "removeHotel";
		this.getOneURL = "oneHotel";
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

	@Deprecated
	public Ent jsonToEntity(JSONObject json) {
		Ent ent = (Ent) new HotelEntity();
		ent.setId(Long.parseLong(json.get("id").toString()));
		ent.setNumRooms((int) json.get("numRooms"));
		ent.setLongitude((Double) json.get("longitude"));
		ent.setLatitude((Double) json.get("latitude"));
		ent.setEmail((String) json.get("email"));
		ent.setName((String) json.get("name"));
		Map<Integer, String> amenities = new HashMap<>();
		amenities.put(0, "nothing");
		System.out.println("H get name :) ;);); " + ent.getName());
		return ent;
	}
}