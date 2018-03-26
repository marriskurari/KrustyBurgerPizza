/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: server
 */

package server.booking;


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
	private Integer hotelId;
	private String roomType;
	private Boolean isPaid;
	private Date from;
	private Date to;

	Booking(int hotelId, String roomType) {
		this.hotelId = hotelId;
		this.roomType = roomType;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
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

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		assert to.getTime() / 86400000 == 0;
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		assert to.getTime() / 86400000 == 0;
		this.to = to;
	}
}

