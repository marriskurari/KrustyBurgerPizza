import java.io.*;
import java.util.Map;

import generator.hotel.Hotel;
import generator.hotel.HotelEntity;
import generator.hotel.HotelFactory;
import org.json.JSONArray;
import org.junit.*;
import generator.*;

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
