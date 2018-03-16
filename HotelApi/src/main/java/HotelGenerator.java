import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HotelGenerator {
    private static String[] amenities = {
            "wifi",
            "shower",
            "breakfast",
            "private bathroom",
            "tea",
            "coffee",
            "linen"
    };

    private static ArrayList<String> getRandomAmenities() {
        List<String> list = Arrays.asList(amenities);
        Collections.shuffle(list);
        int a = list.size();
        int randomAmount = (int) (a*Math.random());
        return (ArrayList<String>) list.subList(0, randomAmount);
    }

    private static getRandomEmail() {
        int a = (int) (Math.random() * email.length);
				return email[a];
    }

    public static Hotel generateHotel() {
        Hotel hotel = new Hotel();
        hotel.setAmenities(getRandomAmenities());
        hotel.setEmail();
    }


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
