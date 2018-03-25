import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HotelGenerator {
	private static String[] amenities = {
			"wifi",
			"shower",
			"breakfast",
			"private_bathroom",
			"tea",
			"coffee",
			"linen"
	};

	private static List<String> getRandomAmenities() {
		List<String> list = Arrays.asList(amenities);
		Collections.shuffle(list);
		int a = list.size() - 1;
		int randomAmount = (int) (a*Math.random());
		List<String> l = list.subList(0, randomAmount + 1);
		System.out.println(l.toString());
		return l;
	}

	private static String getRandom(String[] array) {
		int a = (int) (Math.random() * array.length);
		return array[a];
	}

	private static double randomDouble(double seed) {
		return seed + Math.random() * 3;
	}

	private static int randomInt() {
		return (int) (Math.random() * 70);
	}

	public static Hotel generateHotel() {
		Hotel hotel = new Hotel();
		hotel.setAmenities(getRandomAmenities());
		hotel.setEmail(getRandom(email));
		hotel.setName(getRandom(name));
		hotel.setLatitude(randomDouble(60));
		hotel.setLongtitude(randomDouble(-20));
		hotel.setNumRooms(randomInt());
		return hotel;

	}

	private static String[] name = {
			"Wet_Spring",
			"Bree_Wonder",
			"Hotel_Hotel",
			"Hotel_Fighters",
			"Hotel_Red_Day",
			"Bree_Eats_the_Hotel",
			"Between_the_Hotels_and_Me",
			"Megahotel",
			"Hotel_Dream_and_a_Pinch_of_Hotel",
			"My_Wet_Romance",
			"Brees_Wet_Hotel",
			"No_Hotel",
			"Of_Men_and_Humming_Birds",
			"Saving_Bree",
			"School_of_the_One_Zillion_Humming_Birds",
			"They_Might_Be_Wet_Humming_Birds",
			"One_Zillion_Humming_Birds",
			"Hotel_Hotel_Cult",
			"The_Reykjavik_Strippers",
			"Hotel_Kid_Bree",
			"Reykjavik_Thunder_Shoulders",
			"Hotel_One_Zillion",
			"One_Zillion_Snuggling_Iced_Humming_Birds",
			"Snuggling_at_the_Disco",
			"One_Zillion_Odd_Humming_Birds",
			"Hotel_Failure",
			"Wet_Humming_Birds_Dream",
			"This_Hotel",
			"Its_My_Hotel",
			"Flight_of_the_Hotels",
			"Snuggling_in_Reykjavik",
			"Hotelplay",
			"The_Hotel_Can_For_the_Street_Artists",
			"The_Wet_Street_Artistss_Club",
			"Hotel_Hotel",
			"Hotel_Fighters",
			"Hotel_Red_Day",
			"Hotels_and_a_Hotel",
			"Bree_Eats_the_Hotel",
			"Hotel_Dream_and_a_Pinch_of_Hotel",
			"My_Wet_Romance",
			"Brees_Wet_Hotel",
			"No_Hotel",
			"Reykjavik_Panic",
			"Hotels_for_the_Street_Artists",
			"Saving_Bree",
			"One_Zillion_Humming_Birds",
			"The_Snuggling_Hotel_Street_Artists",
			"Hotel_Attack",
			"Hotel_for_the_Street_Artists",
			"Hotelback",
			"The_Hotel_Bree_Project",
			"Snuggling_Hotels",
			"Puddle_of_Hotel",
			"Disciples_Of_Reykjavik",
			"The_Hotel_B_Experience",
			"Snuggling_at_the_Disco",
			"Hotel_Army",
			"Hotel_Tribute",
			"This_Hotel",
			"Its_My_Hotel",
			"Allo_Hotels"
	};

	private static String[] email = {
			"amcnysche9k@webmd.com",
			"sskilbeck9l@last.fm",
			"zilchenko9m@ebay.com",
			"jblanche9n@webmd.com",
			"bliebrecht9o@newsvine.com",
			"clejeune9p@smh.com.au",
			"rsilverthorn9q@sciencedirect.com",
			"kburgess9r@tinypic.com",
			"rmcconnal9s@cmu.edu",
			"vbellinger9t@webnode.com",
			"amcgrale9u@xinhuanet.com",
			"cbladder9v@gravatar.com",
			"aearland9w@tamu.edu",
			"jkier9x@imageshack.us",
			"rchittey9y@bigcartel.com",
			"mgreatbach9z@storify.com",
			"mbenfielda0@accuweather.com",
			"avuitteta1@va.gov",
			"ldadea2@networkadvertising.org",
			"lkelsalla3@is.gd",
			"twoodyearea4@microsoft.com",
			"cdominguesa5@hp.com",
			"wraimenta6@sbwire.com",
			"lconichiea7@latimes.com",
			"kstiegera8@apple.com",
			"moharea9@storify.com",
			"mkidsleyaa@shareasale.com",
			"ldarkerab@wordpress.com",
			"tkimberleyac@bing.com",
			"aebentallad@last.fm",
			"gellitae@telegraph.co.uk",
			"kburleyaf@51.la",
			"nhotsonag@theglobeandmail.com",
			"dgoldringah@phoca.cz",
			"adienesai@bloglines.com",
			"jreynaaj@feedburner.com",
			"cmanthaak@intel.com",
			"pbridgemanal@whitehouse.gov",
			"wpackingtonam@about.me",
			"nbainsan@bandcamp.com",
			"rklimkowskiao@1und1.de",
			"nrozierap@oracle.com",
			"ebullockeaq@springer.com",
			"ehoviear@nifty.com",
			"ssalleryas@youtube.com",
			"inickollat@hhs.gov",
			"hpattersau@yellowpages.com",
			"ghawyesav@usatoday.com",
			"mdemcakaw@moonfruit.com",
			"mdemschkeax@yandex.ru",
			"cmolyneuxay@hao123.com",
			"pgrethamaz@t.co",
			"echaudronb0@umn.edu",
			"dtabardb1@liveinternet.ru",
			"earentsb2@dagondesign.com",
			"lcockerellb3@wufoo.com",
			"kdavanab4@vimeo.com",
			"rphilcoxb5@admin.ch",
			"hstoppardb6@cbslocal.com",
			"vdragoeb7@bloglines.com",
			"whullettb8@ustream.tv",
			"mebbingsb9@seesaa.net",
			"fhebblewhiteba@bravesites.com",
			"dmiebesbb@squidoo.com",
			"pboheybc@bloomberg.com",
			"gmillwardbd@theatlantic.com",
			"csheermanbe@wikispaces.com",
			"dtrebilcockbf@gravatar.com",
			"rjearumbg@e-recht24.de",
			"olorekbh@tumblr.com",
			"cmeneghibi@amazon.de",
			"binesonbj@oracle.com",
			"akobierzyckibk@opensource.org"
	};
}