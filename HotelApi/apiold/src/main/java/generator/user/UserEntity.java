package generator.user;

import generator.Entity;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserEntity extends Entity {

	private Long id;
	private String name;
	private String email;
	//bookingNumber and bookingId
	private Map<Integer, Long> bookings = new HashMap<>();

	public UserEntity(Long id, String name, String email, Map<Integer, Long> bookings) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.bookings = bookings;
	}

	public UserEntity(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public UserEntity extractEntity() {
		return new UserEntity(id, name, email, bookings);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public List<Pair<String, String>> getParameters() {
		List<Pair<String, String>> params = new ArrayList<>();
		params.add(new Pair<>("id", "" + this.id));
		params.add(new Pair<>("name", "" + this.name));
		params.add(new Pair<>("email", "" + this.email));
		if(bookings != null)
			params.addAll(mapToListOfPairs("bookings", bookings));
		return params;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public void addBooking(Long bookingId) {
		int bookingNumber = bookings.size();
		this.bookings.put(bookingNumber, bookingId);
	}
}
