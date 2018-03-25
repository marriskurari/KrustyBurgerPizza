/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: server
 */

package server.availability;




	 import javax.persistence.Entity;
	 import javax.persistence.GeneratedValue;
	 import javax.persistence.GenerationType;
	 import javax.persistence.Id;
	 import java.util.Date;
	 import java.util.HashMap;

@Entity // This tells Hibernate to make a table out of this class
public class Availability {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private HashMap<Date, Integer> days;

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

	public void setAvailabilityForDate(long date, int numberOfRooms) {
		long d = formatToMidnight(date);
		days.put(new Date(d), numberOfRooms);
	}

	public int getAvailabilityForDate(long date, int numberOfRooms) {
		long d = formatToMidnight(date);
		return days.get(new Date(d));
	}

}
