package shapes;

/**
 *
 * @author tth
 */
public class Triangle {
	private final String type;
	private final long[] angles;
	private final long[] sides;

	public Triangle(long[] angles, long[] sides, String type) {
		this.type = type;
		this.angles = angles;
		this.sides = sides;
	}

	public long[] getAngles() {
		return angles;
	}

	public long[] getSides() {
		return sides;
	}

	public String getType() {
		return type;
	}
}
