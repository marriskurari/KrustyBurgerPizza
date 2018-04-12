package search.generator.booking;

import search.generator.Entity;
import search.generator.Factory;
import search.generator.hotel.Hotel;
import search.generator.hotel.HotelEntity;
import javafx.util.Pair;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.io.IOException;

/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: PACKAGE_NAME
 */

public class BookingFactory<Ent extends Booking> extends Factory {
	public BookingFactory() {
		this.updateURL = "addBooking";
		this.getAllURL = "allBookings";
		this.getOneURL = "oneBooking";
		this.removeURL = "removeBooking";
	}

	//don't reccomend using this one lol,
	//it can give you roomId from a different
	//hotel than the hotelId is, but works for
	//testing n shit, which is pretty much
	//what these are good for anyway
	public Booking generate() {
		Pair<Long, Long> randomDates = randomTimeInterval();
		Booking booking = new Booking(
			 (long) randomInt(100),
			 (long) randomInt(100),
			 (long) randomInt(100),
			 randomDates.getKey(),
			 randomDates.getValue(),
			 randomBoolean(),
			 randomCC()
		);
		return booking;
	}

	public Ent getOneBooking(long id) throws IOException {
		List<Ent> listOfOne = getOne(id);
		return listOfOne.get(0);
	}

	public Booking jsonToEntity(JSONObject json) {
		System.out.println(json.toString());
		Long id = getAsLong("id", json);
		Long hotelId = getAsLong("hotelId", json);
		Long roomId = getAsLong("roomId", json);
		Long userId = getAsLong("userId", json);
		Long dateFrom = getAsLong("dateFrom", json);
		Long dateTo = getAsLong("dateTo", json);
		Boolean isPaid = (Boolean) json.get("isPaid");
		String cc = (String) json.get("cc");
		System.out.println("BOOKING ID");
		System.out.println(id);
		return new Booking(id, hotelId, roomId, userId, dateFrom, dateTo, isPaid, cc);
	}
}
