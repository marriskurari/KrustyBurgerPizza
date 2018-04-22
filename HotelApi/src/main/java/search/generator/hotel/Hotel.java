package search.generator.hotel;

import search.generator.Entity;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public  class Hotel extends HotelEntity {
	public Hotel(Integer numRooms, String name, String email, Double longitude, Double latitude, String imageUrl, Integer stars, Map<Integer, String> amenities) {
		super(numRooms, name, email, longitude, latitude, imageUrl, stars, amenities);
	}
}
