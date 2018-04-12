
import search.API;
import search.generator.Factory;
import search.generator.ToolBox;

import search.generator.hotel.Hotel;
import search.generator.hotel.HotelEntity;
import search.generator.hotel.HotelFactory;

import search.generator.availability.Availability;
import search.generator.availability.AvailabilityFactory;

import search.generator.booking.Booking;
import search.generator.booking.BookingFactory;

import search.generator.room.Room;
import search.generator.room.RoomEntity;
import search.generator.room.RoomFactory;

import search.generator.user.User;
import search.generator.user.UserEntity;
import search.generator.user.UserFactory;

import org.json.JSONArray;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

//code for Hotels

public class Test1 {
	private Hotel myHotel;
	private ObjectOutputStream myOutStream;
	private ObjectInputStream myInStream;

	private HotelFactory hf = new HotelFactory();
	private RoomFactory rf = new RoomFactory();
	private AvailabilityFactory af = new AvailabilityFactory();
	private BookingFactory bf = new BookingFactory();
	private UserFactory uf = new UserFactory();

	private Long hid;
	private Long aid;
	private Long rid;
	private Long bid;
	private Long uid;

	@Before
	public void setUp() throws IOException {
		System.out.println("----------------Setting up");
		//tools to make
		Map<Integer, String> amenMap = Factory.getRandomMap(Factory.amenities);
		Map<Long, Integer> availMap = Factory.getRandomAvailability();

		Availability a = new Availability(availMap);
		aid = af.save(a);
		System.out.println("Av id" + aid);
		Assert.assertNotNull(aid);

		Room r = new Room("dbl", 2, false, aid);
		rid = rf.save(r);
		Assert.assertNotNull(rid);

		Hotel h = new Hotel(47, "nammi", "nomail", 3.15, 4.5, "https://i.imgur.com/TJoqdrp.jpg", amenMap);
		h.addRoomId(rid);
		hid = hf.save(h);
		Assert.assertNotNull(hid);

		User u = new User("olafur_palsson", "olp6@hi.is");
		//swagline, a little server back and forth to get an ID
		uid = uf.save(u);
		UserEntity ue = uf.getOneUser(uid);
		Assert.assertEquals(ue.getId(), uid);
		String cc = Factory.randomCC();
		ToolBox.formatLongDateToString(new Long(25000000));
		Booking b = new Booking(hid, rid, ue.getId(), new Long(25000000), new Long(28000000), true, cc);
		bid = bf.save(b);
		System.out.println("BOOKNIG ID IN TEST " + bid);
		ue.addBookingId(bid);
		Long userTestId = uf.save(ue);
		Assert.assertEquals(uid, userTestId);
	}
	/**


	TODO
	1. Lata Rooms fa HotelID
	2. Users med Bookings i DB
	3. Bookings i DB

	*/

	@Test
	public void test() throws IOException {
		System.out.println("----------------Starting test");
		HotelEntity h = hf.getOneHotel(hid);
		Assert.assertEquals(hid, h.getId());
		Assert.assertEquals("nammi", h.getName());
		Assert.assertEquals("nomail", h.getEmail());
		Assert.assertEquals(3.15, h.getLongitude(), 0.01);
		Assert.assertEquals(4.5, h.getLatitude(), 0.01);
		Assert.assertEquals(rid, new Long(h.getRoomIds().get(0)));

		RoomEntity r = rf.getOneRoom(rid);
		Assert.assertEquals(false, r.isExtraBed());
		Assert.assertEquals(2, r.getNumberOfBeds());
		Assert.assertEquals("dbl", r.getRoomType());
		Assert.assertEquals((Long) aid, (Long) r.getAvailabilityId());

		Booking b = bf.getOneBooking(bid);
		UserEntity ue =  uf.getOneUser(uid);
		Assert.assertTrue(ue.hasBooking(b));
		Assert.assertEquals(b.getHotelId(), hid);
		Assert.assertEquals(b.getRoomId(), rid);
		Assert.assertEquals(b.getUserId(), uid);
	}

	@After
	public void tearDown() throws IOException {
		System.out.println("----------------Taking the thing out");
		hf.remove(hid);
		rf.remove(rid);
		af.remove(aid);
	}
}
