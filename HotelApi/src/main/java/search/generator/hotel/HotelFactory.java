package search.generator.hotel;

import search.generator.Entity;
import search.generator.Factory;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
			 randomDouble(-20, 3),
			 randomDouble(60, 3),
			 getRandom(imageUrl),
			 getRandomMap(amenities)
		);
		return hotel;
	}

	public Ent getOneHotel(Long id) throws IOException {
		List<Ent> listOfOne =  super.getOne(id);
		return listOfOne.get(0);
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
		ent.setImageUrl((String) json.get("imageUrl"));
		Map<Integer, String> amenities = new HashMap<>();
		amenities.put(0, "nothing");
		System.out.println("H get name :) ;);); " + ent.getName());
		return ent;
	}
}