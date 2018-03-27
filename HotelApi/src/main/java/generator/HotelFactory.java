package generator;

/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: PACKAGE_NAME
 */

public class HotelFactory extends Factory {

	public static Hotel generateHotel() {
		Hotel hotel = new Hotel();
		hotel.setAmenities(getRandomList(amenities));
		hotel.setEmail(getRandom(email));
		hotel.setName(getRandom(hotelNames));
		hotel.setLatitude(randomDouble(60, 3));
		hotel.setLongitude(randomDouble(-20, 3));
		hotel.setNumRooms(randomInt(72));
		return hotel;
	}
}
