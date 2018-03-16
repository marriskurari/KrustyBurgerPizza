
import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {
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

	public HashMap<String,String> getParameters() {
		HashMap<String,String> params = new HashMap<>();
		params.put("id", this.id.toString());
		params.put("latitude", ""  + this.latitude);
		params.put("longtitude", ""  + this.longtitude);
		params.put("name", name);
		params.put("email	", email);
		params.put("numRooms",numRooms.toString());
	}
}
