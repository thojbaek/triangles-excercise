package shapes;

import java.util.stream.DoubleStream;

/**
 *
 * @author tth
 */
public class MathHelper {

	/**
	 * Takes an array of angles in a triangle, and calculates the length of the sides
	 * One of the sides will be decided to be 10 as a base-length
	 * If the sum of the angles in the array is not exactly 180, throws IlligalargumentException
	 * since it is not a triangle
	 * @param angles	an array of length exactly 3
	 * @return			an array of length three with the sides of the triangle. Index 0 will always be 10 
	 */
	public static double[] GetSidesFromAngles(double[] angles) {
		if(angles.length != 3) {
			throw new IllegalArgumentException("A triangle can only have three angles");
		}
		double sum = DoubleStream.of(angles).sum();
		if(Math.round(sum) != 180) { // Since comparing with doubles can give some weird results, we round to long first
			throw new IllegalArgumentException("The sum of angles must be 180 for it to be a triangle");
		}
		double[] sides = new double[3];
		// Since we only know the angles, we don't know the "size" of the triangle,
		// so we'll just decide that one of the sides has length 10
		sides[0] = 10;
		sides[1] = round((sides[0] * Math.sin(Math.toRadians(angles[1])))/Math.sin(Math.toRadians(angles[0])),2);
		sides[2] = round((sides[0] * Math.sin(Math.toRadians(angles[2])))/Math.sin(Math.toRadians(angles[0])),2);
		
		return sides;
	}
	
	/**
	 * Takes an array of sides in a triangle, and calculates the angles
	 * @param sides		an array of length exactly 3
	 * @return			an array of length three with the angles of the triangle
	 */
	public static double[] GetAnglesFromSides(double[] sides) {
		if(sides.length != 3) {
			throw new IllegalArgumentException("A triangle can only have three sides");
		}
		double[] angles = new double[3];
		// using the law of cosines
		angles[0] = round(Math.toDegrees(Math.acos((Math.pow(sides[0], 2) - Math.pow(sides[1], 2) - Math.pow(sides[2], 2)) / (-2 * sides[1] * sides[2]))),2);
		angles[1] = round(Math.toDegrees(Math.acos((Math.pow(sides[1], 2) - Math.pow(sides[0], 2) - Math.pow(sides[2], 2)) / (-2 * sides[0] * sides[2]))),2);
		angles[2] = round(Math.toDegrees(Math.acos((Math.pow(sides[2], 2) - Math.pow(sides[0], 2) - Math.pow(sides[1], 2)) / (-2 * sides[0] * sides[1]))),2);
		return angles;
	}
	
	public static TriangleType GetTriangleTypeFromSides(double[] sides) {
		if(sides.length != 3) {
			throw new IllegalArgumentException("A triangle can only have three angles");
		}
		if(sides[0] == sides[1] && sides[0] == sides[2]) {
			return TriangleType.EQUILATERAL;
		}
		else if(sides[0] == sides[1] || sides[1] == sides[2] || sides[0] == sides[2]) {
			return TriangleType.ISOSCELES;
		}
		else {
			return TriangleType.SCALENE;
		}
	}
	
	public static TriangleType GetTriangleTypeFromAngels(double[] angles) {
		double[] sides = MathHelper.GetSidesFromAngles(angles);
		return MathHelper.GetTriangleTypeFromSides(sides);
	}
	
	private static double round(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}
}
