
package server.hotel;

import server.room.Room;

import java.util.ArrayList;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Hotel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer numRooms;
	private double  latitude;
	private Double  longtitude;		
	private String  name;
	private String  email;
	private HashMap<String, Room> rooms;
	private ArrayList<String> amenities;
	//private Date[] closedDates;

	public Hotel(Integer numRooms, String name, String email, Double longtitude, double latitude, ArrayList<String> amenities) {
		this.setNumRooms(numRooms);
		this.setName(name);
		this.setEmail(email);
		this.setLongtitude(longtitude);
		this.setLatitude(latitude);
		this.setAmenities(amenities);
	}

	public Hotel(int id, int numrooms, double latitude, double longtitude, String name, String email, ArrayList<String> amenities) {
		Hotel hotel = new Hotel(numRooms, name, email, longtitude, latitude, amenities);
		hotel.setId(id);
	}

	public Integer getId()           { return id;     } 
	public void    setId(Integer id) { this.id = id;  }
  
	public Integer getNumRooms()                 { return numRooms;          } 
	public void    setNumRooms(Integer numRooms) { this.numRooms = numRooms; }

	public double getLatitude()                 { return latitude;         } 
	public void   setLatitude(double latitude) { this.latitude = latitude; }

	public Double getLongtitude()                   { return longtitude;            } 
	public void   setLongtitude(Double longtitude)  { this.longtitude = longtitude; }

	public String getName()             { return name;     } 
	public void   setName(String name) { this.name = name; }

	public String getEmail()             { return email;       } 
	public void   setEmail(String email) { this.email = email; }

	public void setAmenities(ArrayList<String> amenities) { this.amenities = amenities; }

	public HashMap<String, Room> getRooms() { return rooms; }

	public void setRooms(HashMap<String, Room> rooms) { this.rooms = rooms; }

	public void addRoom(Room room) {
		String idForHashMap = room.getRoomType();
		rooms.put(idForHashMap, room);
	}

	public void setRooms(ArrayList<Room> roomList) {
		HashMap<String, Room> newRooms = new HashMap<>();
		for(Room room : roomList)
			addRoom(room);
		setRooms(newRooms);
	}
}

