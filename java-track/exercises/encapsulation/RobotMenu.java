package encapsulation;

import java.util.ArrayList;
import java.util.Scanner;

public class RobotMenu {

	private Scanner in;
	private ArrayList<Robot> robots;
	
	public RobotMenu() {
		in = new Scanner(System.in);
		robots = new ArrayList<Robot>();
	}


	public int displayMenu() {
		System.out.println("Welcome to the computer menu!");
		System.out.println("1. Create a robot");
		System.out.println("2. Display the list of available robots");
		System.out.println("3. Move a robot");
		System.out.println("4. Rotate a robot");
		System.out.println("5 Compute the distance between two robots");
		System.out.println("6. Exit");
		System.out.println();
		System.out.println("Please select one of the above options:");
		int selection = in.nextInt();
		while(selection < 1 || selection > 6) {
			System.out.println("Please choose from the valid options:");
			selection = in.nextInt();
		}
		return selection;
	}

	public void processInput() {
		int selection = displayMenu();
		if(selection != 6) {
			if(selection == 1) {
				createRobot();
			}
			if(selection == 2) {
				displayRobots();
			}
			if(selection == 3) {
				moveRobot();
			}
			if(selection == 4) {
				rotateRobot();
			}
			if(selection == 5) {
				distanceBetween();
			}
			processInput();
		} else {
			System.out.println("RobotMenu has now been terminated");
			return;
		}

	}
	
	public void createRobot() {
		System.out.println("Welcome to the Robot Creation Menu!");
		System.out.println();
		System.out.println("Please enter the name of your Robot:");
		String name = in.next();
		System.out.println("Please enter the x position (integer) of your robot:");
		int x = in.nextInt();
		System.out.println("Please enter the y position (integer) of your robot:");
		int y = in.nextInt();
		System.out.println("Please enter the speed (integer) of your robot:");
		int speed = in.nextInt();
		System.out.println("Please enter the orientation your Robot is facing (north, south, east, west):");
		String orientation = in.next();
		while(!orientation.equals("north") & !orientation.equals("south") & !orientation.equals("east") & !orientation.equals("west")) {
			System.out.println("Sorry, that is not a valid orientation, please try again:");
			orientation = in.next();
		}
		System.out.println("Thank you, your new robot is now being created...");
		robots.add(new Robot(name, x, y, speed, orientation));
		System.out.println("Success!");
		
	}
	
	public void displayRobots() {
		for(int i = 0; i < robots.size(); i++) {
			System.out.println((i+1) + ".)" + robots.get(i));
		}
	}
	
	public void moveRobot() {
		System.out.println("You chose to move a robot!");
		
	}
	
	public void rotateRobot() {
		System.out.println("You chose to rotate a robot!");
	}
	
	public void distanceBetween() {
		System.out.println("You chose to find the distance between two robots!");
	}


	public static void main(String[] args) {
		RobotMenu rm = new RobotMenu();
		rm.processInput();
	}

}
