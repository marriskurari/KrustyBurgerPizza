package generator.hotel;

import generator.Factory;
import org.json.JSONObject;

/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: PACKAGE_NAME
 */

public class HotelFactory extends Factory {

	public static Hotel generateHotel() {
		Hotel hotel = new Hotel(
			 randomInt(72),
			 getRandom(hotelNames),
			 getRandom(email),
			 randomDouble(60, 3),
			 randomDouble(-20, 3),
			 getRandomMap(amenities)
		);
		return hotel;
	}

	@Override
	protected HotelEntity jsonToEntity(JSONObject json) {
		return null;
	}
}