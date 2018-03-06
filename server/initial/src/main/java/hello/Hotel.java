
package hello;

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

	private Double latitude;

	private Double longtitude;		

	private String hotelName;

	private String hotelEmail;

  //private Date[] closedDates; 

	private String[] amenities;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBLABL() {
		return id;
	}

	public void setblabla(Integer id) {
		this.id = id;
	}
	
	public Integer getNumRooms() {
		return numRooms;
	}

	public void setNumRooms(Integer numRooms) {
		this.numRooms = numRooms;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double numRooms) {
		this.latitude = latitude;
	}
	
	public String getName() {
		return hotelName;
	}

	public void setName(String name) {
		this.hotelName = hotelName;
	}

	public String getEmail() {
		return hotelEmail;
	}

	public void setAmenities(String[] amenityList) {
		this.amenities = amenityList;
	}

	public void setEmail(String email) {
		this.hotelEmail = hotelEmail;
	}
}
