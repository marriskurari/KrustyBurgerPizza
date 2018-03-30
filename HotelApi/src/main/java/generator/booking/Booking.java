/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: server
 */

package generator.booking;


import generator.Entity;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Booking extends Entity {
	private Long hotelId;
	private Long userId;
	private String roomType;
	private Boolean isPaid;
	private Long dateFrom;
	private Long dateTo;

	public Booking(Long hotelId, String roomType, Long from, Long to) {
		this.hotelId = hotelId;
		this.roomType = roomType;
		this.dateFrom = from;
		this.dateTo = to;
	}

	public Booking(Long id, Long hotelId, String roomType, Long from, Long to) {
		this.id = id;
		this.hotelId = hotelId;
		this.roomType = roomType;
		this.dateFrom = from;
		this.dateTo = to;
	}

	@Override
	public List<Pair<String, String>> getParameters() {
		List<Pair<String, String>> params = new ArrayList<>();
		params.add(pair("id", this.id));
		params.add(pair("hotelId", this.userId));
		params.add(pair("userId", this.userId));
		params.add(pair("roomType", this.roomType));
		params.add(pair("isPaid", this.isPaid));
		params.add(pair("dateFrom", this.dateFrom));
		params.add(pair("dateTo", this.dateTo));
		return params;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean paid) {
		isPaid = paid;
	}

	public Long getFrom() {
		return dateFrom;
	}

	public void setFrom(Date from) {
		assert from.getTime() / 86400000 == 0;
		this.dateFrom = from.getTime();
	}

	public Long getTo() {
		return dateTo;
	}

	public void setTo(Date to) {
		assert to.getTime() / 86400000 == 0;
		this.dateTo = to.getTime();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}

