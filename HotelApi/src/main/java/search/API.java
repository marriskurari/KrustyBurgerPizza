
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
import search.generator.user.User;
import search.generator.user.UserEntity;
import search.generator.user.UserFactory;
import search.generator.ToolBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class API {

	private static HotelFactory<HotelEntity> hf = new HotelFactory<>();
	private static UserFactory<UserEntity> uf = new UserFactory<>();
	private static RoomFactory<RoomEntity> rf = new RoomFactory<>();
	private static BookingFactory<Booking> bf = new BookingFactory<>();
	private static AvailabilityFactory<Availability> af = new AvailabilityFactory<>();

	private static List<Hotel> allHotels = new ArrayList<>();
	private static boolean hotelListNeedsToBeUpdated = false;

	public static void setHotelListNeedsToBeUpdated(boolean b) {
		hotelListNeedsToBeUpdated = b;
	}

	public List getAllHotels() throws IOException {
		if(!hotelListNeedsToBeUpdated) return allHotels;
		allHotels = hf.getAll();
		hotelListNeedsToBeUpdated = false;
		return allHotels;
	}

	public HotelEntity getOneHotel(Long id) throws IOException {
		List<HotelEntity> listWithOnlyOneItem = hf.getOne(id);
		return listWithOnlyOneItem.get(0);
	}

	public Long makeBooking(
		Long   hotelId,
		Long roomId,
		Long userId,
		String dateFrom,
		String dateTo,
		Boolean isPaid,
		String cc
	) throws IOException {
		long from = ToolBox.formatStringDateToLong(dateFrom);
		long to   = ToolBox.formatStringDateToLong(dateTo);
		Booking booking = new Booking(hotelId, roomId, userId, from, to, isPaid, cc);
		Long id = bf.save(booking);
		return id;
	}

	public Room generateRoomWithAvailability() throws IOException {
		//availability is in DB but not room
		Availability a = new Availability(Factory.getRandomAvailability());
		Long aId = af.save(a);
		Room r = new Room(
			Factory.getRandom( Factory.roomType),
			1 + Factory.randomInt(3),
			Factory.randomBoolean(),
			aId
		);
		return r;
	}

	public void giveHotelRandomRooms(Hotel hotel) throws IOException {
		int n = Factory.randomInt(6) + 1;
		for(int i = 0; i < n; i++)
			hotel.addRoomId(rf.save(generateRoomWithAvailability()));
	}

	public void generateHotels(int numberOfHotels) throws IOException {
		int numberOfHotelsEachCountry = numberOfHotels / 3;
		List<Hotel> hotels = new ArrayList<>();
		for(int i = 0; i < numberOfHotelsEachCountry; i++)
			hotels.add(hf.generateIcelandic());
		for(int i = 0; i < numberOfHotelsEachCountry; i++)
			hotels.add(hf.generateUK());
		for(int i = 0; i < numberOfHotelsEachCountry; i++)
			hotels.add(hf.generateFrench());
		for(Hotel hotel : hotels) {
			int n = Factory.randomInt(6) + 1;
			giveHotelRandomRooms(hotel);
			hf.save(hotel);
		}
	}

	public void giveUserRandomBookings(User user) throws IOException {
		int n = Factory.randomInt(8) + 1;
		for(int i = 0; i < n; i++)
			user.addBookingId(bf.save(bf.generate()));
	}

	public void generateUsers(int numberOfUsers) throws IOException {
		for(int i = 0; i < numberOfUsers; i++) {
			User user = uf.generate();
			giveUserRandomBookings(user);
			uf.save(user);
		}
	}

	public static void main(String [] args) throws IOException {
		API api = new API();
		api.generateHotels(50);
		api.generateUsers(50);
	}
}
