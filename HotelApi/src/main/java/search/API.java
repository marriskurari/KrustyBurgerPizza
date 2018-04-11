
package search;

import search.generator.Factory;
import search.generator.availability.Availability;
import search.generator.availability.AvailabilityFactory;
import search.generator.booking.Booking;
import search.generator.booking.BookingFactory;
import search.generator.hotel.Hotel;
import search.generator.hotel.HotelEntity;
import search.generator.hotel.HotelFactory;
import search.generator.room.Room;
import search.generator.room.RoomEntity;
import search.generator.room.RoomFactory;
import search.generator.user.UserEntity;
import search.generator.user.UserFactory;
import search.generator.ToolBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class API {

	private static HotelFactory<HotelEntity> hotelFactory;
	private static UserFactory<UserEntity> userFactory;
	private static RoomFactory<RoomEntity> roomFactory;
	private static BookingFactory<Booking> bookingFactory;
	private static AvailabilityFactory<Availability> availabilityFactory;

	private static List<Hotel> hotels = new ArrayList<>();
	private List<Hotel> allHotels = new ArrayList<>();
	private static boolean hotelListNeedsToBeUpdated = false;

	public static void setHotelListNeedsToBeUpdated(boolean b) {
		hotelListNeedsToBeUpdated = b;
	}

	public API() { hotelFactory = new HotelFactory<HotelEntity>(); }

	public List getAllHotels() throws IOException {
		if(!hotelListNeedsToBeUpdated) return allHotels;
		allHotels = hotelFactory.getAll();
		hotelListNeedsToBeUpdated = false;
		return allHotels;
	}

	public HotelEntity getOneHotel(Long id) throws IOException {
		List<HotelEntity> listWithOnlyOneItem = hotelFactory.getOne(id);
		return listWithOnlyOneItem.get(0);
	}

	public Long makeBooking(Long hotelId, String roomType, String dateFrom, String dateTo, String cc)
	throws IOException {
		long from = ToolBox.formatStringDateToLong(dateFrom);
		long to   = ToolBox.formatStringDateToLong(dateTo);
		Booking booking = new Booking(hotelId, roomType, from, to, cc);
		Long id = bookingFactory.save(booking);
		return id;
	}

	public static void testDatabase() throws IOException {
		API api = new API();
		hotelFactory = new HotelFactory<>();
		Hotel a = hotelFactory.generate();
		System.out.println(a.getEmail());
		Map<Integer, String> am = Factory.getRandomMap(Factory.amenities);
		Hotel hh = new Hotel(5, "nammi", "nomail", 3.15, 4.5, "https://i.imgur.com/TJoqdrp.jpg", am);
		hotels.add(hh);
		hotelFactory.save(hh);
		for(int i = 0; i < 2000; i++) {
			Hotel h = hotelFactory.generate();
			Room r = roomFactory.generate();
			roomFactory.save(r);
			h.addRoomId(new Long(0));
			hotels.add(h);
			hotelFactory.save(h);
		}

		List<HotelEntity> hotelsFromDB = new ArrayList<>(api.getAllHotels());
		System.out.println(hotelsFromDB);
		int i = 0;
		for(HotelEntity e : hotelsFromDB) {
			System.out.print(i++);
			System.out.println(e.getName());
		}
		System.out.println("Hello world");

		HotelEntity hotel = api.getOneHotel((long) 2);
		String email = hotel.getEmail();
		System.out.println(email);
	}
}
