package encapsulation;

public interface RobotBehavior {
	
	public String move(int turns);
	public String turnLeft();
	public String turnRight();
	public double distanceFrom(Robot other);
	
}
