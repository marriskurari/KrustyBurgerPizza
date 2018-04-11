import java.io.*;
import java.net.Socket;
import org.junit.*;
import generator.*;

//Test code for Hotels

public class testController{
	private Hotel myHotel;
	private ObjectOutputStream myOutStream;
	private ObjectInputStream myInStream;
	private long myId = 1005;
	private HotelFactory hotelFac = new HotelFactory();
	private Hotel hotel;

	@Before
	public void setUp() throws IOException {

		Map<Integer, String> am = Factory.getRandomMap(Factory.amenities);
		Hotel myHotel = new Hotel(myId, "nammi", "nomail", 3.15, 4.5, am);
		HotelFac.save(myHotel);
	}

	@Test
	public void testNormalEmail() throws IOException {
		hotel = hotelFac.getOne(myId);
		assertEquals(myId, tester.hotel.getId());
		assertEquals("nammi", tester.hotel.getName());
		assertEquals("nomail", tester.hotel.getEmail());
		assertEquals(3.15, tester.hotel.getLongitude());
		assertEquals(4.5, tester.hotel.getLatitude());
	}

	@After
	public void tearDown() throws IOException {
		hotel.HotelFactory.remove(myId);
	}
}
