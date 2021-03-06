package hello;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private void bla() throws URISyntaxException {
    }


    @RequestMapping("/testing")
    public Error error(@RequestParam(value="name", defaultValue="World") String name) {
        return new Error();
    }

}
