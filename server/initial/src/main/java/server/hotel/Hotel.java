/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: server.hotel
 */

package server.hotel;

import server.room.Room;
import server.room.RoomEntity;
import server.room.RoomRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel extends HotelEntity {

	private Map<Integer, Room> rooms = new HashMap<>();
	private Map<Integer, RoomEntity> roomEntities = new HashMap<>();

	public Hotel(Integer numRooms, String name, String email, Double longtitude, double latitude, String imageUrl, Map<Integer, String> amenities, Map<Integer, Long> roomIds) {
		super(numRooms, name, email, longtitude, latitude, imageUrl, amenities, roomIds);
	}

	public Map<Integer, Room> getRooms() {
		return rooms;
	}

	public void setRooms(Map<Integer, Room> rooms) {
		this.rooms = rooms;
	}

	public Map<Integer, RoomEntity> getRoomEntities() {
		return roomEntities;
	}

	public void setRoomEntities(Map<Integer, RoomEntity> roomEntities) {
		this.roomEntities = roomEntities;
	}
}
