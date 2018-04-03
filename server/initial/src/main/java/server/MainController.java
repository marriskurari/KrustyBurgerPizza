package server;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import server.availability.Availability;
import server.availability.AvailabilityRepository;
import server.booking.Booking;
import server.booking.BookingRepository;
import server.hotel.HotelEntity;
import server.hotel.HotelRepository;
import server.room.RoomEntity;
import server.room.RoomRepository;
import server.user.UserEntity;
import server.user.UserRepository;

@RestController    // This means that this class is a Controller
@RequestMapping(path="/database") // This means URL's start with /demo (after Application path)
public class MainController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private AvailabilityRepository availabilityRepository;
	@Autowired
	private BookingRepository bookingRepository;

	/*********************************
	 *   USER METHODS
	 ********************************/
	@CrossOrigin
	@GetMapping(path = "/addUser") // Map ONLY GET Requests
	public @ResponseBody
	String addNewUser(
		 @RequestParam String name,
		 @RequestParam String email
	) {
		UserEntity n = new UserEntity(name, email);
		userRepository.save(n);
		return "Saved";
	}

	@CrossOrigin
	@GetMapping(path = "/oneUser")
	public @ResponseBody
	UserEntity getOneUser(
		 @RequestParam Long id
	) {
		return userRepository.findOne(id);
	}

	@CrossOrigin
	@GetMapping(path = "/allUsers")
	public @ResponseBody
	Iterable<UserEntity> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}

	@CrossOrigin
	@GetMapping(path = "/addBookingToUser")
	public @ResponseBody
	String addBookingToUser(
		 @RequestParam Long userId,
		 @RequestParam Long bookingId
	) {
		UserEntity user = userRepository.findOne(userId);
		user.addBooking(bookingId);
		return "Done";
	}

	/*********************************
	 *   HOTEL METHODS
	 ********************************/
	@CrossOrigin
	@GetMapping(path = "/addHotel")
	public @ResponseBody
	Long addNewHotel(
		 @RequestParam String name,
		 @RequestParam String email,
		 @RequestParam double latitude,
		 @RequestParam Double longitude,
		 @RequestParam ArrayList<String> amenities,
		 @RequestParam Integer numRooms
	) {
		Map<Integer, String> amenityMap = (Map<Integer, String>) Converter.arrayListToMap(amenities);
		HotelEntity h = new HotelEntity(numRooms, name, email, longitude, latitude, amenityMap);
		h = hotelRepository.save(h);
		return h.getId();
	}

	@CrossOrigin
	@GetMapping(path = "/oneHotel")
	public @ResponseBody
	HotelEntity getOneHotel(
		 @RequestParam Long id
	)
	 {
		return hotelRepository.findOne(id);
	}

	@CrossOrigin
	@GetMapping(path = "/allHotels")
	public @ResponseBody
	Iterable<HotelEntity> getAllHotels() {
		// This returns a JSON or XML with the users
		return hotelRepository.findAll();
	}

	@CrossOrigin
	@GetMapping(path = "/removeHotel")
	public @ResponseBody String remove(
		 @RequestParam Long id
	) {
		hotelRepository.delete(id);
		return "Deleted";
	}

	/*********************************
	 *   ROOM METHODS
	 ********************************/
	@CrossOrigin
	@GetMapping(path = "/addRoom")
	public @ResponseBody
	String addNewRoom(
		 @RequestParam String roomType,
		 @RequestParam Integer numberOfBeds,
		 @RequestParam Boolean extraBed
	) {
		RoomEntity re = new RoomEntity(roomType, numberOfBeds, extraBed);
		Availability av = new Availability();
		av.setAvailabilityToZero();
		av = availabilityRepository.save(av);
		re.setAvailabilityId(av.getId());
		re = roomRepository.save(re);
		return "" + re.getId();
	}

	@CrossOrigin
	@GetMapping(path = "/oneRoom")
	public @ResponseBody
	RoomEntity getOneRoom(
		 @RequestParam Long id
	) {
		return roomRepository.findOne(id);
	}

	/*********************************
	 *   BOOKING METHODS
	 ********************************/
	//all dateString: yyyy-mm-dd
	private Booking makeBasicBooking(Long hotelId, String roomType, String dateFrom, String dateTo) {
		Long from = Converter.yyyymmdd_toLong(dateFrom);
		Long to = Converter.yyyymmdd_toLong(dateTo);
		return new Booking(hotelId, roomType, from, to);
	}

	@CrossOrigin
	@GetMapping(path = "/oneBooking")
	public @ResponseBody
	Booking getOneBooking(
		 @RequestParam Long id
	) {
		return bookingRepository.findOne(id);
	}

	//return bookingID
	@CrossOrigin
	@GetMapping(path = "/addBooking")
	public @ResponseBody String addNewBooking(
		 @RequestParam Long hotelId,
		 @RequestParam String roomType,
		 @RequestParam String dateFrom, //yyyy-mm-dd
		 @RequestParam String dateTo    //yyyy-mm-dd
	) {
		Booking booking = makeBasicBooking(hotelId, roomType, dateFrom, dateTo);
		booking = bookingRepository.save(booking);
		return booking.getId().toString();
	}

	@CrossOrigin
	@GetMapping(path = "/addBookingWithUser")
	public @ResponseBody
	String addNewBooking(
		 @RequestParam Long hotelId,
		 @RequestParam Long userId,
		 @RequestParam String roomType,
		 @RequestParam String dateFrom, //yyyy-mm-dd
		 @RequestParam String dateTo    //yyyy-mm-dd
	) {
		Booking booking = makeBasicBooking(hotelId, roomType, dateFrom, dateTo);
		booking.setUserId(userId);
		booking = bookingRepository.save(booking);
		return booking.getId().toString();
	}
	/*********************************
	 *   BOOKING METHODS
	 ********************************/

	@CrossOrigin
	@GetMapping(path = "/oneAvailability")
	public @ResponseBody
	Availability getOneAvailability(
		 @RequestParam Long id
	) {
		return availabilityRepository.findOne(id);
	}
}
