package shapes;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author tth
 */
@RestController
public class TriangleController {
	private static final String greetingTemplate = "Hellp, %s!";
	private final AtomicLong greetingCounter = new AtomicLong();

	@RequestMapping("/hello")
	public Greeting hello(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting(greetingCounter.incrementAndGet(), String.format(greetingTemplate, name));
	}

	@RequestMapping(value="/triangle/sides", method = RequestMethod.GET)
	public Triangle triangle(@RequestParam("sides") String[] sides) {
		return null;
	}


}
