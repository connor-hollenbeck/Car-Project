package car;

/**
 * <p>
 * Class invariants:
 * <ul>
 * <li>The gas tank does not contain a negative amount of gas.
 * <li>The gas tank does not have more gas than the tank capacity.
 * <li>For every mile travelled, 1/MPG gallons of gas are used.
 * <li>The car is in PARK, FORWARD, or REVERSE gear.
 * </ul>
 */
public class Car implements Comparable<Car> {

	public static final int PARK = 0;
	public static final int FORWARD = 1;
	public static final int REVERSE = 2;

	/**
	 * Create a car that gets 20 mpg and has a tank capacity of 10 gallons
	 */
	public Car() {
	}

	/**
	 * Create a car
	 * 
	 * @param MPG
	 *            is the mileage (in miles per gallon) that the car gets
	 * @param capacity
	 *            is the fuel tank capacity (in gallons)
	 */
	Car(double MPG, double capacity) {
	}

	/**
	 * Go for a specified distance (or as far as the current gas allows) in the
	 * current gear
	 * 
	 * <p>
	 * precondition: car is in gear and has fuel, miles is non-negative
	 * <p>
	 * postcondition:
	 * <ul>
	 * <li>for gear = FORWARD:
	 * <ul>
	 * <li>location = min(location' + miles, location' + (remainingFuel' *
	 * milesPerGallon))
	 * </ul>
	 * <li>for gear = REVERSE:
	 * <ul>
	 * <li>location = max(location' - miles, location' - (remainingFuel' *
	 * milesPerGallon))
	 * </ul>
	 * </ul>
	 * 
	 * @param miles
	 *            is the number of miles to go
	 */
	public void go(double miles) {
	}

	/**
	 * Fills the tank to the full capacity.
	 */
	public void fillTank() {
	}

	/**
	 * Fills the gas tank with the given amount of gas, or enough to fill the
	 * tank, whichever is less.
	 * 
	 * <p>
	 * precondition: fuelAmount is non-negative
	 * <p>
	 * postcondition: remainingFuel = max(tankCapacity, remainingFuel' +
	 * fuelAmount)
	 * 
	 * @param fuelAmount
	 *            is the amount of fuel to add
	 */
	public void refuel(double fuelAmount) {
	}

	/**
	 * @return the current amount of gas car has
	 */
	public double getRemainingGas() {
		return 0.0;
	}

	/**
	 * @return the fuel tank capacity
	 */
	public double getCapacity() {
		return 0.0;
	}

	/**
	 * @return current location of car
	 */
	public double getLocation() {
		return 0.0;
	}

	/**
	 * @return miles per gallon rating on car
	 */
	public double getMPG() {
		return 0.0;
	}

	/**
	 * @return current gear
	 */
	public int getGear() {
		return PARK;
	}

	/**
	 * Sets the gear that the car will be in.
	 * 
	 * @param newGear
	 *            is the gear to set to.
	 */
	public void setGear(int newGear) {
	}

	/**
	 * Used in printing the car's status. The format is:<br/>
	 * 
	 * Tank Capacity: &lt;tankCapacity&gt; <br/>
	 * MPG: &lt;mpg&gt; <br/>
	 * Gas left: &lt;gasLeft&gt; <br/>
	 * Gear: &lt;gear&gt; <br/>
	 * Location: &lt;location&gt;
	 * 
	 * <br/>
	 * where &lt;tankCapacity&gt;, &lt;mpg&gt;, &lt;gasLeft&gt;, and
	 * &lt;location&gt; are numbers, but &lt;gear&gt; is a string with one of
	 * the following values: {"Park", "Reverse", "Forward"}
	 **/
	public String toString() {
		return "";
	}

	/**
	 * compare this car with otherCar to see which one is ahead (i.e. which one
	 * has gone a further distance.)
	 * 
	 * @param otherCar
	 *            is the car to which to compare
	 * @return -1 if this otherCar is ahead, 0 if equal, 1 if this car is ahead
	 */
	@Override
	public int compareTo(Car otherCar) {
		return 0;
	}
}
