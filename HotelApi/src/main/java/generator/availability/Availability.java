/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: server
 */

package generator.availability;


import generator.Entity;
import generator.ToolBox;
import javafx.util.Pair;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Availability extends Entity {
	private Long id;

	//long == date og integer == fjoldi herbergja
	private Map<Long, Integer> days = new HashMap<>();
	private static Map<Long, Integer> zeroAvailabilityMap() {
		Map<Long, Integer> zeroByDays = new HashMap<>();
		Long today = new Date().getTime();
		today = ToolBox.formatToMidnight(today);
		return zeroByDays;
	}

	public void setAvailabilityToZero() {
		setDays(zeroAvailabilityMap());
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public List<Pair<String, String>> getParameters() {
		return null;
	}

	public void setAvailabilityForDate(Long date, int numberOfRooms) {
		long d = ToolBox.formatToMidnight(date);
		days.put(date, numberOfRooms);
	}

	public int getAvailabilityForDate(long date, int numberOfRooms) {
		return days.get(date);
	}
	
	public Map<Long, Integer> getDays() {
		return days;
	}

	public void setDays(Map<Long, Integer> days) {
		this.days = days;
	}
}
