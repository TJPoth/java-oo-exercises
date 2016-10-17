package encapsulation;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTest {

	@Test
	public void testMove() {
		Robot Alpha = new Robot("Alpha", 0, 0, 1, "North");
		Alpha.move(1);
		assertTrue(Alpha.getX() == 0 & Alpha.getY() == 1);	
	}
	
	@Test
	public void testTurnRight() {
		Robot Alpha = new Robot("Alpha", 0, 0, 1, "North");
		Alpha.turnRight();
		assertTrue(Alpha.getOrientation() == "East");
	}
	
	@Test
	public void testTurnLeft() {
		Robot Alpha = new Robot("Alpha", 0, 0, 1, "South");
		Alpha.turnLeft();
		assertTrue(Alpha.getOrientation() == "East");
	}
	
	@Test
	public void testDistanceFrom() {
		Robot Alpha = new Robot("Alpha", 1, 1, 2, "North");
		Robot Beta = new Robot("Beta", 5, 5, 1, "East");
		assertTrue(Alpha.distanceFrom(Beta) == 5.65);
	}


}
