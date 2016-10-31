package encapsulation;

public class RobotMover extends Robot {
	
	private int strength;
	
	public RobotMover(String name, int x, int y, int speed, String orientation, int strength) {
		super(name, x, y, speed, orientation);
		this.strength = strength;
	}
	
	public void push(Robot other, String direction) {
		if(this.distanceFrom(other) > 1) {
			System.out.println("Error: Not close enough to push!");
			return;
		}
		if (direction == "north") {
			other.y += strength;
		} else if (direction == "south") {
			other.y -= strength;
		} else if (direction == "east") {
			other.x += strength;
		} else if (direction == "west") {
			other.x -= strength;
		} else {
			System.out.println("Error: Please enter a valid direction (north, south, east, west)");
		}
		System.out.println(other.getName() + " has been pushed " + strength + " units " + direction);
	}

	public static void main(String[] args) {
		RobotMover bulkybob = new RobotMover("bulkybob", 1, 1, 1, "east", 10);
		Robot phil = new Robot("phil", 1, 2, 3, "west");
		bulkybob.push(phil, "east");
	}

}
