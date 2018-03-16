
import service.*;

public class Test {
	public static void main(String[] args) {
		ApiController hotelAPI = new ApiController();
		hotelAPI.addNewHotel("BLABLABL","emailgoishere", 0.0, 0.0, null, 47);
		Hotel[] hotels = hotelAPI.getAllHotels();
		System.out.println(hotels[0].getName());
		System.out.println("NOthing");
	}
}

