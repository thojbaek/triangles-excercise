package shapes;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tth
 */
@RestController
public class TriangleController {
    private static final String template = "Hellp, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping("/triangle")
    public Triangle triangle(@RequestParam(value="name", defaultValue="World") String name) {
        return new Triangle(counter.incrementAndGet(), String.format(template, name));
    }
}
