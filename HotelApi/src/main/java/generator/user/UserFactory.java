package generator.user;

import generator.Entity;
import generator.Factory;
import generator.hotel.HotelEntity;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: PACKAGE_NAME
 */

public class UserFactory extends Factory {
	public UserFactory() {
		this.updateURL = "addUser";
		this.getAllURL = "allUsers";
	}

	public User generate() {
		User user = new User(
			 getRandom(humanName),
			 getRandom(email)
		);
		return user;
	}

	//muna ad checka a hvad gerist ef draslid er null
	public UserEntity jsonToEntity(JSONObject json) {
		Long id = Long.parseLong(json.get("id").toString());
		String name = (String) json.get("name");
		String email = (String) json.get("email");
		Map<Integer, Long> map = new HashMap<>();
		map.put(0, (long) 0);
		return new UserEntity(id, name, email, map);
	}

}