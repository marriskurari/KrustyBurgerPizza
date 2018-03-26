/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: server
 */

package server.availability;




	 import javax.persistence.*;
	 import java.util.Date;
	 import java.util.HashMap;
	 import java.util.Map;

@Entity // This tells Hibernate to make a table out of this class
public class Availability {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	//long == date og integer == fjoldi herbergja
	@ElementCollection
	private Map<Long, Integer> days = new HashMap<>();

	private static final int dayInMs = 86400000;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	private long formatToMidnight(long date) {
		return (date / dayInMs) * dayInMs;
	}

	public void setAvailabilityForDate(Long date, int numberOfRooms) {
		long d = formatToMidnight(date);
		days.put(date, numberOfRooms);
	}

	public int getAvailabilityForDate(long date, int numberOfRooms) {
		return days.get(date);
	}

}
