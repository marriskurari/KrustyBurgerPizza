package server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import server.user.User;
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

	private Iterable<HotelEntity> cachedHotels = new ArrayList<>();
	private boolean hotelsHaveBeenUpdated = true;

	/*********************************
	 *   USER METHODS
	 ********************************/
	@CrossOrigin
	@GetMapping(path = "/addUser") // Map ONLY GET Requests
	public @ResponseBody
	String addNewUser(
		 @RequestParam(required = false) Long id,
		 @RequestParam String name,
		 @RequestParam String email,
		 @RequestParam(required = false) ArrayList<Long> bookingIds
	) {
		UserEntity u = new UserEntity(name, email);
		if(id != null) u.setId(id);
		if(bookingIds != null)
			for(Long bid : bookingIds)
				u.addBookingId(bid);
		u = userRepository.save(u);
		return u.getId().toString();
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
		user.addBookingId(bookingId);
		return "Done";
	}

	/*********************************
	 *   HOTEL METHODS
	 ********************************/
	@CrossOrigin
	@GetMapping(path = "/addHotel")
	public @ResponseBody
	Long addNewHotel(
		 @RequestParam(required = false) Long id,
		 @RequestParam String name,
		 @RequestParam String email,
		 @RequestParam double latitude,
		 @RequestParam Double longitude,
		 @RequestParam ArrayList<String> amenities,
		 @RequestParam ArrayList<Long> roomIds,
		 @RequestParam Integer numRooms,
		 @RequestParam String imageUrl
	) {
		Map<Integer, String> amenityMap = (Map<Integer, String>) Converter.arrayListToMap(amenities);
		Map<Integer, Long> roomIdMap = (Map<Integer, Long>) Converter.arrayListToMap(roomIds);

		HotelEntity h = new HotelEntity(numRooms, name, email, longitude, latitude, imageUrl, amenityMap, roomIdMap);
		if(id != null) h.setId(id);
		h = hotelRepository.save(h);
		hotelsHaveBeenUpdated = true;
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
	@GetMapping(path = "/getHotelsByLocation")
	public @ResponseBody
	Iterable<HotelEntity> getHotelsByLocation(
		 @RequestParam Double latitude,
		 @RequestParam Double longitude
	) {
		Iterable<HotelEntity> list = getAllHotels();
		List<HotelEntity> closeHotels = new ArrayList<>();
		for(HotelEntity he : list) {
			if(ToolBox.isClose(latitude, he.getLatitude(), longitude, he.getLongitude()))
				closeHotels.add(he);
		}
		return closeHotels;
	}

	@CrossOrigin
	@GetMapping(path = "/allHotels")
	public @ResponseBody
	Iterable<HotelEntity> getAllHotels() {
		if(hotelsHaveBeenUpdated) {
			cachedHotels = hotelRepository.findAll();
			hotelsHaveBeenUpdated = false;
		}
		return cachedHotels;
	}

	@CrossOrigin
	@GetMapping(path = "/removeHotel")
	public @ResponseBody String removeHotel(
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
		 @RequestParam(required = false) Long id,
		 @RequestParam String roomType,
		 @RequestParam Integer numberOfBeds,
		 @RequestParam Boolean extraBed,
		 @RequestParam Long availabilityId
	) {
		RoomEntity re = new RoomEntity(roomType, numberOfBeds, extraBed);
		if(id != null) re.setId(id);
		re.setAvailabilityId(availabilityId);
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

	@CrossOrigin
	@GetMapping(path = "/removeRoom")
	public @ResponseBody String removeRoom(
		 @RequestParam Long id
	) {
		roomRepository.delete(id);
		return "Deleted";
	}

	/*********************************
	 *   BOOKING METHODS
	 ********************************/
	//all dateString: yyyy-mm-dd
	private Booking makeBasicBooking(Long hotelId, Long roomId, Long userId, String dateFrom, String dateTo, Boolean isPaid, String cc) {
		Long from = Converter.yyyymmdd_toLong(dateFrom);
		Long to = Converter.yyyymmdd_toLong(dateTo);
		return new Booking(hotelId, roomId, userId, from, to, isPaid, cc);
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
	public @ResponseBody String addBooking(
		 @RequestParam(required = false) Long id,
		 @RequestParam Long hotelId,
		 @RequestParam Long roomId,
		 @RequestParam Long userId,
		 @RequestParam String dateFrom, //yyyy-mm-dd
		 @RequestParam String dateTo,    //yyyy-mm-dd
		 @RequestParam Boolean isPaid,
		 @RequestParam String cc
	) {
		Booking booking = makeBasicBooking(hotelId, roomId, userId, dateFrom, dateTo, isPaid, cc);
		if(id != null) booking.setId(id);
		booking = bookingRepository.save(booking);
		return booking.getId().toString();
	}

	@CrossOrigin
	@GetMapping(path = "/removeBooking")
	public @ResponseBody String removeBooking(
		 @RequestParam Long id
	) {
		bookingRepository.delete(id);
		return "Deleted";
	}

	/*********************************
	 *   AVAILABILITY METHODS
	 ********************************/

	@CrossOrigin
	@GetMapping(path = "/addAvailability")
	public @ResponseBody
	Long addAvailability(
		 @RequestParam Map<String, String> allParams
	) {
		Availability availability = new Availability();
		Map<Long, Integer> days = new HashMap<>();
		for(Map.Entry<String, String> e : allParams.entrySet()) {
			if(e.getKey().equals("id")) {
				availability.setId(Long.parseLong(e.getValue()));
				continue;
			}
			days.put(Long.parseLong(e.getKey()), Integer.parseInt(e.getValue()));
		}
		availability.setDays(days);
		Availability a =  availabilityRepository.save(availability);
		System.out.println(a.getId());
		return a.getId();
	}

	@CrossOrigin
	@GetMapping(path = "/removeAvailability")
	public @ResponseBody String removeAvailability(
		 @RequestParam Long id
	) {
		availabilityRepository.delete(id);
		return "Deleted";
	}

	@CrossOrigin
	@GetMapping(path = "/oneAvailability")
	public @ResponseBody
	Availability getOneAvailability(
		 @RequestParam Long id
	) {
		return availabilityRepository.findOne(id);
	}
}
