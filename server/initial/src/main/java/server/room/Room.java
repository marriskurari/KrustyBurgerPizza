/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: server.room
 */

package server.room;

import server.availability.Availability;
import server.availability.AvailabilityRepository;

import java.util.ArrayList;
import java.util.List;

public class Room extends RoomEntity {
	private Availability availability;

	public Room(Long id, String roomType, int numberOfBeds, boolean extraBed, long availabilityId) {
		super(id, roomType, numberOfBeds, extraBed, availabilityId);
	}

	public Availability getAvailability() {
		return availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability;
	}
}
