import java.io.IOException;

public class API {

	HotelRepo hotelRepo;

	public API() {
		hotelRepo = new HotelRepo();
	}

	public Hotel[] getAllHotels() throws IOException {
	    return hotelRepo.getAll();
	}



	public static void main(String[] args) throws IOException {
	    API api = new API();
	    Hotel hotel = new Hotel();
	    hotel.setAmenities();
		Hotel[] hotels = api.getAllHotels();
		System.out.println("Hello world");
	}
}
