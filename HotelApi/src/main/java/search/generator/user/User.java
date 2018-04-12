/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: server.user
 */

package search.generator.user;

import search.generator.booking.Booking;

import java.util.HashMap;
import java.util.Map;

public class User extends UserEntity {
	private Map<Long, Booking> bookings = new HashMap<>();

	public User(Long id, String name, String email, Map<Integer, Long> bookings) { super(id, name, email, bookings); }
	public User(String name, String email)                                       { super(name, email);               }

	public Map<Long, Booking> getBookings() {
		return bookings;
	}

	public void hasBooking(Booking b) {
		Map<Integer, Long> bookings = getBookings();
		for(int i = 0; i < bookings.size(); i++)
			if(b.getId.equals(bookings.get(i)))
				return true;
		return false;
	}

	public void setBookings(Map<Long, Booking> bookings) {
		this.bookings = bookings;
	}
}
