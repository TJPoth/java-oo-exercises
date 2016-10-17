package encapsulation;

public class Robot {

	private String name;
	private int x;
	private int y;
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
		this.name = name;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.orientation = orientation;
	}

	public String move(int turns) {
		while(turns > 0) {
		if (this.orientation == "North") {
			this.y += this.speed;
		} else if (this.orientation == "South") {
			this.y -= this.speed;
		} else if (this.orientation == "East") {
			this.x += this.speed;
		} else if (this.orientation == "West") {
			this.x -= this.speed;
		}
		turns--;
		}
		return "Your position is now: (" + this.x + ", " + this.y + ")";

	}

	public String turnLeft() {
		if (this.orientation == "North") {
			this.orientation = "West";
		} else if (this.orientation == "South") {
			this.orientation = "East";
		} else if (this.orientation == "East") {
			this.orientation = "North";
		} else if (this.orientation == "West") {
			this.orientation = "South";
		}
		return "Your robot is now facing " + this.orientation;
	}

	public void turnRight() {
		if (this.orientation == "North") {
			this.orientation = "East";
		} else if (this.orientation == "South") {
			this.orientation = "West";
		} else if (this.orientation == "East") {
			this.orientation = "South";
		} else if (this.orientation == "West") {
			this.orientation = "North";
		}
		System.out.println("Your robot is now facing " + this.orientation);
		return;
	}

	public double distanceFrom(Robot otherBot) {
		double distance = Math.sqrt(Math.pow(otherBot.x - this.x, 2) + (Math.pow(otherBot.y - this.y, 2)));
		double roundedDistance = (int)(distance*100)/100.0;
		return roundedDistance;		
	}

	public String toString() {
		return "Robot name: " + this.name + "\n" +
				"Position: (" + this.x + ", " + this.y + ") \n" +
				"Orientation: " + this.orientation + "\n" + 
				"Speed: " + this.speed;
	}

	public static void main(String[] args) {
		Robot Alpha = new Robot("Alpha", 1, 1, 2, "North");
		Robot Beta = new Robot("Beta", 5, 5, 1, "East");
		System.out.println(Alpha.distanceFrom(Beta));


	}
}
