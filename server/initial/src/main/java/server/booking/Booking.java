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
	private Integer id;
	private Long hotelId;
	private Long userId;
	private Long roomId;
	private Boolean isPaid;
	private Long dateFrom;
	private Long dateTo;
	private String cc;

	public Booking(Long hotelId, Long roomId, Long from, Long to, Long aLong, String cc) {
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.dateFrom = from;
		this.dateTo = to;
		this.cc = cc;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Long getRoomType() {
		return roomId;
	}

	public void setRoomType(Long roomId) {
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

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}
}

