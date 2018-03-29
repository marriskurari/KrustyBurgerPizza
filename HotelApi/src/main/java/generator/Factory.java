package generator;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;

/**

                                d8888888888888888888888"
                                888888888888888888PYP"'
Bitchin factory                d88888888888888888D
   Homie                       8888888888888888P'     Thessi er med mikid af random methods
                                Y8888888888888b       hann er btw abstract vegna thess ad madur
                               C8888888Y888888P       tharf ad extenda svo hann er useful
                                Y88888'd88888"
                                8888P d8888P
                               d8888D 88888
                              d888P'  Y88dP
                             nY88Pn    Y88            8"""-----....._____
                             N   +N    88'            8                  NNNNNN8
                             N   +N  nd88n            P                  NNNNNNP
                             N   +N  N  +N           d  dNN   ...       dNNNNNN
     __...---"Nn.            N   +N  N  +N           8  NNP  dNNP  dNN  NNNNNNN
  8""         NNNNn          N   +N  N  +N           8       ""'   NNP  NNNNNNN
  8       oo  NNNNN          N   +N  N  +N           8                  NNNNNNP
  Y  dN   NN  NNNNN          N   +N  N  +N           P       ooo       dNNNNNN
   b NY   ""  YNNNN          N   +N  N  +N          d       dNN'  dNN  NNNNNNN
   8        _  bNNNb         N   +N  N  +N          8       """   NNP  NNNNNNN
   8  o8   88  NNNNN         N   +N  N  +N          8                  NNNNNNN
   Y  BP   ""  NNNNN         N   +N  N  +N          8            nnn   NNNNNNP
    b          NNNNN         N   +N  N  +N          P            NNP  dNNNNNN
    8          YNNNN         N   +N  M  +N         d             ""   NNNNNNN
    8           NNNNb        N   +N  N  +N         8                  NNNNNNN
    Y           NNNNN      __N___+N__N  +N         8                  NNNNNNP
     b          NNNNNooooodP""""""""YNNNNNNbcgmmnnn8                 dNNNNNN
     8          """'                         `"""""8                 NNNNNNN
     8                                             P                 NNNNNNN
     Y                          NNNNNNNNN         d                  NNNNNNN
      b                         NNNNNNNNN         8                  NNNNNNP
      8                         NNNNNNNNP         8                 dNNNNNN
      8        Lol              NNNNNNNN;         8                 NNNNNNN
      Y     o                   NNNNNNNN:         P                 NNNNNNN
       b   -|-                  NNNNNNNN;        d                  NNNNNNP
       8   ¯Λ                    NNNNNNNN         8                 dNNNNNN
 ______8__........----------""""""""""""------...8..______         NNNNNNN
_________........----------""""""""""""------......_____  """""----NNNNNNN
                                                         """""----....___ """--
                                                                         """--- *
 */


public abstract class Factory<Ent extends Entity> {
	//need to initialize these before using the "getAll" and "save" methods
	protected String getAllURL = "getAllURL-not-initialized-properly-somehow";
	protected String updateURL = "updateAllURL-not-Initialized";

	/*******************************************
	 *       REPO STYLE METHODS
	 *******************************************/

	protected abstract Ent jsonToEntity(JSONObject json);
	public abstract Ent generate();

	public void save(Ent ent) throws IOException {
		Request r = new Request(updateURL, ent.getParameters());
		r.resolve();
	}

	public List getAll() throws IOException {
		Request r = new Request(getAllURL);
		JSONArray json = r.resolve();
		String s = json.toString();
		System.out.println(s);
		List<Ent> entities = new ArrayList<>();

		for(int i = 0; i < json.length(); i++)
			entities.add(jsonToEntity((JSONObject) json.get(i)));
		return entities;
	}

	/*******************************************
	 *       TOOLKIT STYLE METHODS
	 *******************************************/

	private static Map<Integer, String> arrayListToMap(ArrayList<String> arrayList) {
		Map<Integer, String> map = new HashMap<>();
		for(int i = 0; i < arrayList.size(); i++)
			map.put(i, arrayList.get(i));
		return map;
	}

	private static List<String> getRandomList(String[] array) {
		List<String> list = new ArrayList<>(Arrays.asList(array));
		Collections.shuffle(list);
		int a = list.size() - 1;
		int randomAmount = (int) (a*Math.random());
		List<String> l = list.subList(0, randomAmount + 1);
		System.out.println(l.toString());
		return l;
	}

	public static Map<Integer, String> getRandomMap(String[] array) {
		ArrayList<String> list = new ArrayList<>(getRandomList(array));
		return arrayListToMap(list);
	}

	protected static String getRandom(String[] array) {
		int a = (int) (Math.random() * array.length);
		return array[a];
	}

	static boolean randomBoolean()                      { return Math.random() > 0.5; }
	static double  randomDouble(double seed)            { return Math.random() * seed; }
	protected static double  randomDouble(double seed, int width) { return seed + Math.random() * width; }
	protected static int     randomInt(int seed)                  { return (int) (Math.random() * seed); }

	/*******************************************
	 *       DATA FOR RANDOMIZATION
	 *******************************************/

	public static String[] amenities = {
		 "wifi",
		 "shower",
		 "breakfast",
		 "private_bathroom",
		 "tea",
		 "coffee",
		 "linen"
	};

	protected static String[] humanName = {
		 "Bernard_Hunt",
		 "Jaime_Holloway",
		 "Alfonso_Carpenter",
		 "Clinton_Bowman",
		 "Darryl_Cobb",
		 "Tammy_Holland",
		 "Erica_Zimmerman",
		 "Jeannie_Conner",
		 "Ethel_Hanson",
		 "Antoinette_Joseph",
		 "Elsie_Hubbard",
		 "Terry_Pena",
		 "Sonja_Carter",
		 "Charles_Hughes",
		 "James_Marshall",
		 "Ernest_Jimenez",
		 "Rebecca_Barber",
		 "Alice_Perez",
		 "Jenny_Owens",
		 "Mercedes_Bradley",
		 "Misty_Kelley",
		 "Russell_Copeland",
		 "Kendra_Waters",
		 "Rene_Alvarado",
		 "Geraldine_West",
		 "Van_Perry",
		 "Ricky_Perkins",
		 "Loren_Moss",
		 "Lorenzo_Massey",
		 "Johnathan_Lewis",
		 "Rafael_Washington",
		 "Josephine_Carroll",
		 "Alberta_Swanson",
		 "Ruth_Dunn",
		 "Clay_Warren",
		 "Joyce_Hudson",
		 "Nichole_Howell",
		 "Rhonda_Gibson",
		 "Annie_Clayton",
		 "Courtney_Moore",
		 "Elena_Jones",
		 "Floyd_Page",
		 "Jackie_Lloyd",
		 "Homer_Fletcher",
		 "Rachel_Rivera",
		 "Lloyd_Cortez",
		 "Jeannette_Matthews",
		 "Leo_Payne",
		 "Barbara_Phelps",
		 "Marc_Hall"
	};

	protected static String[] hotelName = {
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

	protected static String[] email = {
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
