
import generator.Factory;
import generator.availability.Availability;
import generator.availability.AvailabilityFactory;
import generator.booking.Booking;
import generator.booking.BookingFactory;
import generator.hotel.Hotel;
import generator.hotel.HotelEntity;
import generator.hotel.HotelFactory;
import generator.room.RoomEntity;
import generator.room.RoomFactory;
import generator.user.UserEntity;
import generator.user.UserFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class API {

	private static HotelFactory<HotelEntity> hotelFactory;
	private static UserFactory<UserEntity> userFactory;
	private static RoomFactory<RoomEntity> roomFactorym;
	private static BookingFactory<Booking> bookingFactory;
	private static AvailabilityFactory<Availability> availabilityFactory;

	private static List<Hotel> hotels = new ArrayList<>();

	public API() { hotelFactory = new HotelFactory<HotelEntity>(); }

	public List getAllHotels() throws IOException {
		return hotelFactory.getAll();
	}

	public HotelEntity getOneHotel(Long id) throws IOException {
		List<HotelEntity> listWithOnlyOneItem = hotelFactory.getOne(id);
		return listWithOnlyOneItem.get(0);
	}

	public static void main(String[] args) throws IOException {
		API api = new API();
		HotelFactory<HotelEntity> hf = new HotelFactory<>();
		Hotel a = hf.generate();
		System.out.println(a.getEmail());
		Map<Integer, String> am = Factory.getRandomMap(Factory.amenities);
		Hotel hh = new Hotel(5, "nammi", "nomail", 3.15, 4.5, am);
		hotels.add(hh);
		hotelFactory.save(hh);
		for(int i = 0; i < 12; i++) {
			Hotel h = hf.generate();
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