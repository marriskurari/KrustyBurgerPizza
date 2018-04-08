package generator.availability;

import generator.Entity;
import generator.Factory;
import generator.hotel.Hotel;
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

public class AvailabilityFactory<Ent extends Entity> extends Factory {
	public AvailabilityFactory() {
		this.updateURL = "addAvailability";
		this.getAllURL = "allAvailabilities";
	}

	public Availability generate() {
		Availability availability = new Availability();
		availability.setDays(getRandomAvailability());
		return availability;
	}

	@Deprecated
	public Availability jsonToEntity(JSONObject json) {
		return new Availability();
	}
}