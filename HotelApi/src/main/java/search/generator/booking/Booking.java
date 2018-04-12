/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: server
 */

package search.generator.booking;


import search.generator.Entity;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Booking extends Entity {
	private Long hotelId;
	private Long userId;
	private Long roomId;
	private Boolean isPaid;
	private Long dateFrom;
	private Long dateTo;
	private String cc;

	public Booking(
		Long hotelId,
		Long roomId,
		Long userId,
		Long from,
		Long to,
		Boolean isPaid,
		String cc
	) {
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.userId = userId;
		this.dateFrom = from;
		this.dateTo = to;
		this.cc = cc;
	}

	public Booking(
		Long id,
		Long hotelId,
		Long roomId,
		Long userId,
		Long from,
		Long to,
		Boolean isPaid,
		String cc
	) {
		this.id = id;
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.userId = userId;
		this.dateFrom = from;
		this.dateTo = to;
		this.isPaid = isPaid;
		this.cc = cc;
	}

	@Override
	public List<Pair<String, String>> getParameters() {
		List<Pair<String, String>> params = new ArrayList<>();
		params.add(pair("id", this.id));
		params.add(pair("hotelId", this.hotelId));
		params.add(pair("userId", this.userId));
		params.add(pair("roomId", this.roomId));
		params.add(pair("isPaid", this.isPaid));
		params.add(pair("dateFrom", this.dateFrom));
		params.add(pair("dateTo", this.dateTo));
		return params;
	}

	public void setCC(String cc) {
		this.cc = cc;
	}

	public String getCC() {
		return cc;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
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
