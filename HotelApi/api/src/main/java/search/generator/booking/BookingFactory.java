package search.generator.booking;

import search.generator.Entity;
import search.generator.Factory;
import search.generator.hotel.Hotel;
import search.generator.hotel.HotelEntity;
import javafx.util.Pair;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: PACKAGE_NAME
 */

public class BookingFactory<Ent extends Entity> extends Factory {
	public BookingFactory() {
		this.updateURL = "addBooking";
		this.getAllURL = "allBookings";
	}

	public Booking generate() {
		Pair<Long, Long> randomDates = randomTimeInterval();
		Booking booking = new Booking(
			 (long) randomInt(100),
			 getRandom(roomTypes),
			 randomDates.getKey(),
			 randomDates.getValue()
		);
		return booking;
	}

	public Booking jsonToEntity(JSONObject json) {
		Long id = (Long) json.get("id");
		Long hotelId = (Long) json.get("hotelId");
		String roomType = (String) json.get("roomType");
		Long dateFrom = (Long) json.get("dateFrom");
		Long dateTo = (Long) json.get("dateTo");
		return new Booking(id, hotelId, roomType, dateFrom, dateTo);
	}
}