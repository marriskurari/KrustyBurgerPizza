
package hello;

import java.util.ArrayList;

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

	private ArrayList<String> amenities;
	//private Date[] closedDates; 

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
}
