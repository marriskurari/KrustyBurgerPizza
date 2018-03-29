import generator.Factory;
import generator.hotel.Hotel;
import generator.hotel.HotelEntity;
import generator.hotel.HotelFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class API {

	private static HotelFactory<HotelEntity> hotelFactory;

	private static List<Hotel> hotels = new ArrayList<>();

	public API() { hotelFactory = new HotelFactory<HotelEntity>(); }

	public List getAllHotels() throws IOException {
		return hotelFactory.getAll();
	}

	public static void main(String[] args) throws IOException {
		API api = new API();
		HotelFactory<HotelEntity> hf = new HotelFactory<>();
		Hotel a = hf.generate();
		System.out.println(a.getEmail());
		Map<Integer, String> am = Factory.getRandomMap(Factory.amenities);
		Hotel hh = new Hotel(5, "nammi", "nomail", 3.15, 4.5, am);
		hotels.add(hh);
		hotelFactory.save(hh);
		for(int i = 0; i < 12; i++) {
			Hotel h = hf.generate();
			hotels.add(h);
			hotelFactory.save(h);
		}

		List<HotelEntity> hotelsFromDB = new ArrayList<>(api.getAllHotels());
		System.out.println(hotelsFromDB);
		int i = 0;
		for(HotelEntity e : hotelsFromDB) {
			System.out.print(i++);
			System.out.println(e.getName());
		}
		System.out.println("Hello world");
	}
}