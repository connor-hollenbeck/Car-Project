package car.tests;

/** Test cases for the Car class that should pass when running
 *  Covers all methods in the class, including postconditions for 
 *  certain methods 
 *  @author Connor Hollenbeck
 */

import static org.junit.Assert.*;
import car.Car;

import org.junit.Before;
import org.junit.Test;

public class Car_Test_Pass {

	Car car1;
	Car car2;

	@Before
	public void setUp() throws Exception {
		car1 = new Car();
		car2 = new Car();
	}

	/**
	 * Tests the getGear and setGear methods in the Car class. It first tests
	 * that the car initially starts in park and then sets the gear to forward
	 * and tests if the getGear method returns the correct gear and then does
	 * the same with reverse.
	 */
	@Test
	public void testGears_Initial() {
		assertEquals(0, car1.getGear());
	}

	@Test
	public void testGears_Forward() {
		car1.setGear(1);
		assertEquals(1, car1.getGear());
	}

	@Test
	public void testGears_Reverse() {
		car1.setGear(2);
		assertEquals(2, car1.getGear());
	}

	/**
	 * Tests the postconditions of the go method, which is sending the car
	 * further than the tank of gas can handle. First we test going forward and
	 * see if the car stops after it runs out of gas. Then we fill the tank and
	 * do the same test in reverse.
	 */
	@Test
	public void testGo_postcondition_Forward() {
		car1.setGear(1);
		car1.go(400);
		assertEquals(200, car1.getLocation(), .1);
	}

	@Test
	public void testGo_postcondition_Reverse() {
		car1.setGear(1);
		car1.go(400);
		car1.fillTank();
		car1.setGear(2);
		car1.go(400);
		assertEquals(0, car1.getLocation(), .1);
	}

	/**
	 * Tests the postconditions for refuel in the car class, that if the refuel
	 * amount exceeds the capacity of the tank, then it only fills up to the
	 * capacity of the tank.
	 */
	@Test
	public void testRefuel_postcondition() {
		car1.setGear(1);
		car1.go(20);
		car1.refuel(3);
		assertEquals(10, car1.getRemainingGas(), .1);
	}

	/**
	 * Tests the getCapacity method in the Car class by checking to see if the
	 * initial capacity is 10
	 */
	@Test
	public void testGetCapacity() {
		assertEquals(10, car1.getCapacity(), .1);
	}

	/**
	 * Tests the getMPG method in the Car class to make sure it equals 20, which
	 * is defined for a defualt car.
	 */
	@Test
	public void testGetMPG() {
		assertEquals(20, car1.getMPG(), .1);
	}

	/**
	 * Tests the fuel usage, refueling, and fillTank from the Car class. First
	 * it goes 100 miles forward and checks to see if the remaining gas equals
	 * 5, then refuels. It then goes 200 miles to empty and fills the tank and
	 * checks to see if the tank was filled. Then it goes 220 miles but runs out
	 * of fuel before it gets there so we check to see if the remaining gas is 0
	 * and not negative.
	 */
	@Test
	public void testFuel_usage() {
		car1.setGear(1);
		car1.go(100);
		assertEquals(5, car1.getRemainingGas(), .1);
	}

	@Test
	public void testFuel_refuel() {
		car1.setGear(1);
		car1.go(100);
		car1.refuel(5);
		assertEquals(10, car1.getRemainingGas(), .1);
	}

	@Test
	public void testFuel_fillTank() {
		car1.setGear(1);
		car1.go(200);
		car1.fillTank();
		assertEquals(10, car1.getRemainingGas(), .1);

	}

	/**
	 * Tests the location of the car when going forward, reverse, and running
	 * out of gas. First the car goes 20 miles and tests if the getLocation
	 * method returns 20, then it goes in reverse and goes 10 miles and sees if
	 * 10 is returned. It then goes 190 miles, but runs out of gas before it can
	 * reach that distance, so it stops at 180 miles.
	 */
	@Test
	public void testLocation_forward() {
		car1.setGear(1);
		car1.go(20);
		assertEquals(20, car1.getLocation(), .1);

	}

	@Test
	public void testLocation_reverse() {
		car1.setGear(1);
		car1.go(20);
		car1.setGear(2);
		car1.go(10);
		assertEquals(10, car1.getLocation(), .1);

	}

	@Test
	public void testLocation_runoutOfGas() {
		car1.setGear(1);
		car1.go(20);
		car1.setGear(2);
		car1.go(10);
		car1.go(190);
		assertEquals(180, car1.getLocation(), .1);
	}

	/**
	 * Tests the toString method in the Car class by creating an expected string
	 * of how the output should look like for our created car. Then the expected
	 * string is compared to the toString result
	 */
	@Test
	public void testToString() {
		car1.setGear(1);
		car1.go(20);
		String expected = "Tank Capacity: 10\n MPG: 20\n Gas left: 9\n "
				+ "Gear: 'Forward'\n Location: 20 ";
		assertEquals(expected, car1.toString());

	}

	/**
	 * Tests the compareTo function in the Car class first by having the first
	 * car drive farther, then having them at equal locations, then having the
	 * second car ahead of the first
	 */
	@Test
	public void testCompareTo_firstCar() {
		car1.setGear(1);
		car2.setGear(1);
		car1.go(30);
		car2.go(20);
		assertEquals(1, car1.compareTo(car2));

	}

	@Test
	public void testCompareTo_equalCar() {
		car1.setGear(1);
		car2.setGear(1);
		car1.go(30);
		car2.go(20);
		car1.setGear(2);
		car1.go(10);
		assertEquals(0, car1.compareTo(car2));
	}

	@Test
	public void testCompareTo_secondCar() {
		car1.setGear(1);
		car2.setGear(1);
		car1.go(30);
		car2.go(20);
		car1.setGear(2);
		car1.go(10);
		car2.go(20);
		assertEquals(-1, car1.compareTo(car2));

	}

}
