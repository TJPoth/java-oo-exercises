package encapsulation;

public class Robot implements RobotBehavior {

	private String name;
	protected int x;
	protected int y;
	private int speed;
	private String orientation;

	//getters
	public String getName() {
		return this.name;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getSpeed() {
		return this.speed;
	}

	public String getOrientation() {
		return this.orientation;
	}

	public Robot(String name, int x, int y, int speed, String orientation) {
		if(x < 0 || y < 0) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.orientation = orientation;
	}
	@Override
	public String move(int turns) {
		while(turns > 0) {
			if (this.orientation.equals("north")) {
				this.y += this.speed;
			} else if (this.orientation.equals("south")) {
				this.y -= this.speed;
			} else if (this.orientation.equals("east")) {
				this.x += this.speed;
			} else if (this.orientation.equals("west")) {
				this.x -= this.speed;
			}
			turns--;
		}
		return "Position is now: (" + this.x + ", " + this.y + ")";

	}

	public String turnLeft() {
		if (this.orientation.equals("north")) {
			this.orientation = "west";
		} else if (this.orientation.equals("south")) {
			this.orientation = "east";
		} else if (this.orientation.equals("east")) {
			this.orientation = "north";
		} else if (this.orientation.equals("west")) {
			this.orientation = "south";
		}
		return"Your robot is now facing " + this.orientation;
	}

	public String turnRight() {
		if (this.orientation.equals("north")) {
			this.orientation = "east";
		} else if (this.orientation.equals("south")) {
			this.orientation = "west";
		} else if (this.orientation.equals("east")) {
			this.orientation = "south";
		} else if (this.orientation.equals("west")) {
			this.orientation = "north";
		}
		return"Your robot is now facing " + this.orientation;
	}
	@Override
	public double distanceFrom(Robot otherBot) {
		double distance = Math.sqrt(Math.pow(otherBot.x - this.x, 2) + (Math.pow(otherBot.y - this.y, 2)));
		double roundedDistance = (int)(distance*100)/100.0;
		return roundedDistance;		
	}

	public String toString() {
		return "Robot name: " + this.name + " | Position: (" + this.x + ", " + this.y + ")" +
				" | Orientation: " + this.orientation + " | Speed: " + this.speed;
	}

	public static void main(String[] args) {
		try {
			Robot Alpha = new Robot("Alpha", -1, 1, 3, "north");
			System.out.println(Alpha.move(3));
		}
		catch (IllegalArgumentException e) {
			System.out.println("Cannot create Robot");
			e.printStackTrace();
		}


	}
}
