/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: server
 */

package server.booking;


import server.Converter;
import server.ToolBox;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
public class Booking {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private Long hotelId;
	private Long userId;
	private Long roomId;
	private Boolean isPaid;
	private Long dateFrom;
	private Long dateTo;
	private String cc;

	public Booking() {}

	public Booking(Long hotelId, Long roomId, Long userId, Long from, Long to, Boolean isPaid, String cc) {
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.userId = userId;
		this.dateFrom = from;
		this.dateTo = to;
		this.isPaid = isPaid;
		this.cc = cc;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public boolean getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(boolean paid) {
		isPaid = paid;
	}

	public Long getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date from) {
		assert from.getTime() / 86400000 == 0;
		this.dateFrom = from.getTime();
	}

	public Long getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date to) {
		assert to.getTime() / 86400000 == 0;
		this.dateTo = to.getTime();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}
}

