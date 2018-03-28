import generator.hotel.Hotel;
import generator.hotel.HotelFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class API {

	private static HotelRepo hotelRepo;

	private static List<Hotel> hotels = new ArrayList<>();

	public API() { hotelRepo = new HotelRepo(); }

	public List<Hotel> getAllHotels() throws IOException {
		return hotelRepo.getAll();
	}

	public static void main(String[] args) throws IOException {
		API api = new API();
		Hotel a = HotelFactory.generateHotel();
		System.out.println(a.getEmail());
		for(int i = 0; i < 12; i++) {
			Hotel h = HotelFactory.generateHotel();
			hotels.add(h);
			hotelRepo.uploadHotel(h);
		}
		List<Hotel> hotelsFromDB = api.getAllHotels();
		System.out.println(hotelsFromDB);
		System.out.println("Hello world");
	}
}
