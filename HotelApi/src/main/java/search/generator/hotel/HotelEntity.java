
package search.generator.hotel;

import search.generator.Entity;
import javafx.util.Pair;

import java.util.*;

public class HotelEntity extends Entity {
	private Integer numRooms;
	private Double  latitude;
	private Double longitude;
	private String  name;
	private String  email;
	private Map<Integer, Long> roomIds;
	private Map<Integer, String> amenities;
	private String imageUrl = "https://via.placeholder.com/350x150";

	public HotelEntity() {
		super();
	}

	public HotelEntity(Integer numRooms, String name, String email, Double longitude, double latitude, String imageUrl, Map<Integer, String> amenities) {
		this.setNumRooms(numRooms);
		this.setName(name);
		this.setEmail(email);
		this.setLongitude(longitude);
		this.setLatitude(latitude);
		this.setAmenities(amenities);
		this.setImageUrl(imageUrl);
	}

	public HotelEntity(long id, int numRooms, double latitude, double longitude, String name, String email, Map<Integer, String> amenities) {
		System.out.println(id + "" + numRooms + latitude + longitude + name + email);
		System.out.println(email);
		HotelEntity hotel = new HotelEntity(numRooms, name, email, longitude, latitude, amenities);
		hotel.setId(id);
	}

	public HotelEntity extractEntity() {
		return new HotelEntity(id, numRooms, latitude, longitude, name, email, amenities, imageUrl);
	}

	@Override
	public List<Pair<String, String>> getParameters() {
		List<Pair<String, String>> params = new ArrayList<>();
		params.add(pair("latitude", this.latitude));
		params.add(pair("longitude", this.longitude));
		params.add(pair("name", this.name));
		params.add(pair("email", this.email));
		params.add(pair("numRooms", this.numRooms));
		params.add(pair("imageUrl", this.imageUrl));

		if(amenities != null)
			params.addAll(mapToListOfPairs("amenities", amenities));
		if(roomIds != null)
			params.addAll(mapToListOfPairs("roomIds", roomIds));
		return params;
	}

	public Integer getNumRooms()                 { return numRooms;          }
	public void    setNumRooms(Integer numRooms) { this.numRooms = numRooms; }

	public double getLatitude()                 { return latitude;         }
	public void   setLatitude(double latitude) { this.latitude = latitude; }

	public Double getLongitude()                   { return longitude;            }
	public void setLongitude(Double longitude)  { this.longitude = longitude; }

	public String getName()             { return name;     }
	public void   setName(String name) { this.name = name; }

	public String getImageUrl()             { return imageUrl;     }
	public void   setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

	public String getEmail()             { return email;       }
	public void   setEmail(String email) { this.email = email; }

	public void setAmenities(Map<Integer, String> amenities) {
		this.amenities = amenities;
	}

	public Map<Integer, Long> getRoomIds() { return roomIds; }

	public void setRoomIds(HashMap<Integer, Long> rooms) { this.roomIds = rooms; }

	public void addRoomId(Long roomEntityId) {
		roomIds.put(roomIds.size(), roomEntityId);
	}

	public void setRoomIds(Map<Integer, Long> roomEntityList) {
		Map<Integer, Long> newRooms = new HashMap<>();
		for(Map.Entry<Integer, Long> e : roomEntityList.entrySet())
			newRooms.put(e.getKey(), e.getValue());
		this.roomIds = newRooms;
	}
}

