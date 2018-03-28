import generator.Entity;
import generator.hotel.Hotel;
import generator.hotel.HotelFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class API {

	private static HotelFactory hotelFactory;

	private static List<Hotel> hotels = new ArrayList<>();

	public API() { hotelFactory = new HotelFactory(); }

	public List<Entity> getAllHotels() throws IOException {
		return hotelFactory.getAll();
	}

	public static void main(String[] args) throws IOException {
		API api = new API();
		Hotel a = HotelFactory.generateHotel();
		System.out.println(a.getEmail());
		for(int i = 0; i < 12; i++) {
			Hotel h = HotelFactory.generateHotel();
			hotels.add(h);
			hotelFactory.save(h);
		}
		List<Entity> hotelsFromDB = api.getAllHotels();
		System.out.println(hotelsFromDB);
		System.out.println("Hello world");
	}
}
