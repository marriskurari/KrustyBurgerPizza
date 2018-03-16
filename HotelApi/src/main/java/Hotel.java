
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hotel {
	private Integer id;
	private Integer numRooms;
	private double  latitude;
	private Double  longtitude;
	private String  name;
	private String  email;

	private List<String> amenities;
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

	public void setAmenities(List<String> amenities) { this.amenities = amenities; }

	public String[][] getParameters() {
	    List<String[]> params = new ArrayList<>();
		params.add(new String[]{"latitude", "" + this.latitude});
		params.add(new String[]{"longtitude", "" + this.longtitude});
		params.add(new String[]{"name", "" + this.name});
		params.add(new String[]{"email", "" + this.email});
		params.add(new String[]{"numRooms", "" + this.numRooms});
		for(String am : amenities)
			params.add(new String[]{"amenities", am});
		System.out.println(params.size());
		return params.toArray(new String[params.size()][2]);
	}
}
