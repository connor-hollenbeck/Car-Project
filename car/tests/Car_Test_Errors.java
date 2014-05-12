package car.tests;

/** Junit Test cases for the Car class that expects errors when run. 
 * Mainly testing preconditions and checking to see if the class handles
 * incorrect input properly
 * @author Connor Hollenbeck
 */

import static org.junit.Assert.*;

import car.Car;

import org.junit.Before;
import org.junit.Test;

public class Car_Test_Errors {
	Car car;

	@Before
	public void setUp() throws Exception {
		car = new Car();
	}

	/**
	 * Tests the go method precondition by checking to see if the car is trying
	 * to go negative miles throws an Illegal Argument Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGo_IllegalArgument() {
		car.setGear(1);
		car.go(-5);
	}

	@Test
	public void testGo_HasSomeGas() {
		assertNotSame(0, car.getRemainingGas());
	}

	@Test
	public void testGo_NotInPark() {
		assertNotSame(0, car.getGear());
	}

	/**
	 * Tests the refuel precondition by checking to see if trying to refuel a
	 * negative amount throws an Illegal Argument Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRefuel_precondition() {
		car.setGear(1);
		car.go(20);
		car.refuel(-1);
	}

	/**
	 * Tests the setGear method by trying to set the gear to a gear that isn't
	 * defined and throws an Illegal Argument Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetGear_IllegalArgument() {
		car.setGear(4);
	}

}
