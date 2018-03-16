import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class API {

	HotelRepo hotelRepo;

	private static List<Hotel> hotels = new ArrayList<>();

	public API() {
		hotelRepo = new HotelRepo();
	}

	public Hotel[] getAllHotels() throws IOException {
		return hotelRepo.getAll();
	}

	public static void main(String[] args) throws IOException {
		API api = new API();
		Hotel a = HotelGenerator.generateHotel();
		System.out.println(a.getEmail());
		for(int i = 0; i < 12; i++) {
			Hotel h = HotelGenerator.generateHotel();
			hotels.add(h);
			api.hotelRepo.uploadHotel(h);
		}
		Hotel[] hotelsFromDB = api.getAllHotels();
		for(Hotel h : hotelsFromDB)
			System.out.println(h.getEmail());
		System.out.println("Hello world");
	}
}
