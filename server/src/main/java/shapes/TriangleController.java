package shapes;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
	public Triangle triangleSides(@RequestParam("values") String[] sides) throws IllegalArgumentException {
		double[] doubleSides = new double[3];
		for(int i=0;i<3;i++) { // Only take the first three values
			doubleSides[i] = Double.parseDouble(sides[i]);
		}
		Triangle triangle = new Triangle(doubleSides);
		return triangle;
	}
	
	@RequestMapping(value="/triangle/angles", method = RequestMethod.GET)
	public Triangle triangleAngles(@RequestParam("values") String[] angles) throws IllegalArgumentException {
		double[] doubleAngles = new double[3];
		for(int i=0;i<3;i++) { // Only take the first three values
			doubleAngles[i] = Double.parseDouble(angles[i]);
		}
		double[] sides = MathHelper.GetSidesFromAngles(doubleAngles);
		Triangle triangle = new Triangle(sides);
		return triangle;
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleException(IllegalArgumentException ex) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
