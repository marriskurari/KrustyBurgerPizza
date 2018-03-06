package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.User;
import hello.UserRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/database") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called userRepository
		// Which is auto-generated by Spring, we will use it to handle the data
		private UserRepository userRepository;

	@GetMapping(path="/addUser") // Map ONLY GET Requests
		public @ResponseBody String addNewUser (@RequestParam String name
				, @RequestParam String email) {
			// @ResponseBody means the returned String is the response, not a view name
			// @RequestParam means it is a parameter from the GET or POST request

			User n = new User();
			n.setName(name);
			n.setEmail(email);
			userRepository.save(n);
			return "Saved";
				}

	@Autowired
		private HotelRepository hotelRepository;

	@GetMapping(path="/addHotel")
		public @ResponseBody String addNewHotel (
				@RequestParam String hotelName,
				@RequestParam String hotelEmail,
				@RequestParam Double latitude,
				@RequestParam Double longtitude,
				@RequestParam String[] amenities,
				@RequestParam Integer numRooms
				) {
			Hotel n = new Hotel();
			n.setName(hotelName);
			hotelRepository.save(n);
			return "Saved a hotel";
				}



	@GetMapping(path="/allHotels")
	public @ResponseBody Iterable<Hotel> getAllHotels() {
		// This returns a JSON or XML with the users
		return hotelRepository.findAll();
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}