package search.generator.room;

import search.generator.Entity;
import search.generator.Factory;
import search.generator.hotel.Hotel;
import search.generator.hotel.HotelEntity;
import search.generator.user.User;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: PACKAGE_NAME
 */

public class RoomFactory<Ent extends RoomEntity> extends Factory {
	public RoomFactory() {
		this.updateURL = "updateRoom";
		this.getAllURL = "allRooms";
	}

	public Room generate() {
		Room room = new Room(
			 getRandom(roomTypes),
			 randomInt(4),
			 randomBoolean(),
			 0
		);

		return room;
	}

	public RoomEntity jsonToEntity(JSONObject json) {
		String roomType = (String) json.get("roomType");
		Integer numberOfBeds = (Integer) json.get("numberOfBeds");
		Boolean extraBed = (Boolean) json.get("extraBed");
		Long availabilityId = (Long) json.get("availabilityId");
		return new RoomEntity(roomType, numberOfBeds, extraBed, availabilityId);
	}
}