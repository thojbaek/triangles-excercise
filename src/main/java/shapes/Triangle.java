package shapes;

/**
 *
 * @author tth
 */
public class Triangle {
	private final String type;
	private final double[] angles;
	private final double[] sides;

	public Triangle(double[] sides) {
		this.sides = sides;
		this.angles = MathHelper.GetAnglesFromSides(sides);
		this.type = MathHelper.GetTriangleTypeFromSides(sides).toString();
	}
	
	public Triangle(double[] angles, double[] sides, String type) {
		this.type = type;
		this.angles = angles;
		this.sides = sides;
	}

	public double[] getAngles() {
		return angles;
	}

	public double[] getSides() {
		return sides;
	}

	public String getType() {
		return type;
	}
}
