/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tth
 */
public class MathHelperTest {
	
	public MathHelperTest() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void testGetSidesFromAngles_EquilateralTriangle() {
		System.out.println("GetSidesFromAngles for EquilateralTriangle");
		double[] angles = {60,60,60};
		double[] expResult = {10,10,10};
		double[] result = MathHelper.GetSidesFromAngles(angles);
		assertArrayEquals(expResult, result, 0.00001);
	}

	@Test
	public void testGetSidesFromAngles_ScaleneTriangle() {
		System.out.println("GetSidesFromAngles for ScaleneTriangle");
		double[] angles = {66.9,75.8,37.3};
		double[] expResult = {10,10.54,6.59};
		double[] result = MathHelper.GetSidesFromAngles(angles);
		assertArrayEquals(expResult, result, 0.00001);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetSidesFromAngles_TooManyAngles() {
		System.out.println("GetSidesFromAngles for 4 angles");
		double[] angles = {60,60,60,60};
		double[] result = MathHelper.GetSidesFromAngles(angles);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetSidesFromAngles_SumWrongWithAngles() {
		System.out.println("GetSidesFromAngles for angleswithsum 90");
		double[] angles = {30,30,30};
		double[] result = MathHelper.GetSidesFromAngles(angles);
	}
	
	@Test
	public void testGetAnglesFromSides_EquilateralTriangle() {
		System.out.println("GetAnglesFromSides for equilateral");
		double[] sides = {10,10,10};
		double[] expResult = {60,60,60};
		double[] result = MathHelper.GetAnglesFromSides(sides);
		assertArrayEquals(expResult, result, 0.005);
	}
	
	@Test
	public void testGetAnglesFromSides_ScaleneTriangle() {
		System.out.println("GetAnglesFromSides for scalene");
		double[] sides = {3,4,5};
		double[] expResult = {36.87,53.13,90};
		double[] result = MathHelper.GetAnglesFromSides(sides);
		assertArrayEquals(expResult, result, 0.005);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetAnglesFromSides_Square() {
		System.out.println("GetAnglesFromSides for square");
		double[] sides = {10,10,10,10};
		double[] result = MathHelper.GetAnglesFromSides(sides);
	}

	@Test
	public void testGetTriangleTypeFromSides_Equilateral() {
		System.out.println("GetTriangleTypeFromSides equilateral");
		double[] sides = {10,10,10};
		TriangleType expResult = TriangleType.EQUILATERAL;
		TriangleType result = MathHelper.GetTriangleTypeFromSides(sides);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testGetTriangleTypeFromSides_Isosceles() {
		System.out.println("GetTriangleTypeFromSides Isosceles");
		double[] sides = {10,10,15};
		TriangleType expResult = TriangleType.ISOSCELES;
		TriangleType result = MathHelper.GetTriangleTypeFromSides(sides);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testGetTriangleTypeFromSides_Scalene() {
		System.out.println("GetTriangleTypeFromSides Scalene");
		double[] sides = {10,12,15};
		TriangleType expResult = TriangleType.SCALENE;
		TriangleType result = MathHelper.GetTriangleTypeFromSides(sides);
		assertEquals(expResult, result);
	}

	@Test
	public void testGetTriangleTypeFromAngels_Equilateral() {
		System.out.println("GetTriangleTypeFromAngels Equilateral");
		double[] angles = {60,60,60};
		TriangleType expResult = TriangleType.EQUILATERAL;
		TriangleType result = MathHelper.GetTriangleTypeFromAngels(angles);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testGetTriangleTypeFromAngels_Isosceles() {
		System.out.println("GetTriangleTypeFromAngels Isosceles");
		double[] angles = {45,90,45};
		TriangleType expResult = TriangleType.ISOSCELES;
		TriangleType result = MathHelper.GetTriangleTypeFromAngels(angles);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testGetTriangleTypeFromAngels_Scalene() {
		System.out.println("GetTriangleTypeFromAngels Scalene");
		double[] angles = {60,30,90};
		TriangleType expResult = TriangleType.SCALENE;
		TriangleType result = MathHelper.GetTriangleTypeFromAngels(angles);
		assertEquals(expResult, result);
	}
}
