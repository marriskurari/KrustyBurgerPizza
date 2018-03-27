package generator;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	private Long id;
	private Integer numRooms;
	private double  latitude;
	private Double  longitude;
	private String  name;
	private String  email;

	private List<String> amenities;
	//private Date[] closedDates;

	public Long getId()           { return id;     }
	public void    setId(Long id) { this.id = id;  }

	public Integer getNumRooms()                 { return numRooms;          }
	public void    setNumRooms(Integer numRooms) { this.numRooms = numRooms; }

	public double getLatitude()                 { return latitude;          }
	public void   setLatitude(double latitude)  { this.latitude = latitude; }

	public Double getLongitude()                   { return longitude;            }
	public void setLongitude(Double longitude)     { this.longitude = longitude; }

	public String getName()             { return name;     }
	public void   setName(String name)  { this.name = name; }

	public String getEmail()             { return email;       }
	public void   setEmail(String email) { this.email = email; }

	public void setAmenities(List<String> amenities) { this.amenities = amenities; }

	public List<Pair<String, String>> getParameters() {
	    List<Pair<String, String>> params = new ArrayList<>();
		params.add(new Pair<String, String> ("latitude", "" + this.latitude));
		params.add(new Pair<String, String>("longitude", "" + this.longitude));
		params.add(new Pair<String, String>("name", "" + this.name));
		params.add(new Pair<String, String>("email", "" + this.email));
		params.add(new Pair<String, String>("numRooms", "" + this.numRooms));
		for(String am : amenities)
			params.add(new Pair<String, String>("amenities", am));
		System.out.println(params.size());
		return params;
	}
}
