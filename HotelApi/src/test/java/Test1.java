
import search.API;
import search.generator.Factory;
import search.generator.hotel.Hotel;
import search.generator.hotel.HotelEntity;
import search.generator.hotel.HotelFactory;
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
	private int numRooms = 47;
	private HotelFactory hotelFac = new HotelFactory();
	private HotelEntity hotel;
	private Long myId;

	@Before
	public void setUp() throws IOException {
		System.out.println("----------------Setting up");
		Map<Integer, String> am = Factory.getRandomMap(Factory.amenities);
		Hotel myHotel = new Hotel(numRooms, "nammi", "nomail", 3.15, 4.5, am);
		JSONArray a = hotelFac.save(myHotel);
		myId = Long.parseLong(a.get(0).toString());
	}

	@Test
	public void testNormalEmail() throws IOException {
		System.out.println("----------------Starting test");
		hotel = hotelFac.getOneHotel(myId);
		Assert.assertEquals(myId, hotel.getId());
		Assert.assertEquals("nammi", hotel.getName());
		Assert.assertEquals("nomail", hotel.getEmail());
		Assert.assertEquals(3.15, hotel.getLongitude(), 0.01);
		Assert.assertEquals(4.5, hotel.getLatitude(), 0.01);
	}

	@After
	public void tearDown() throws IOException {
		System.out.println("----------------Taking the thing out");
		hotelFac.remove(myId);
	}
}
