package encapsulation;

import java.util.ArrayList;
import java.util.Scanner;

public class RobotMenu {
	
	
	
	public int displayMenu() {
		System.out.println("Welcome to the computer menu!");
		System.out.println("1. Create a robot");
		System.out.println("2. Display the list of available robots");
		System.out.println("3. Move a robot");
		System.out.println("4. Rotate a robot");
		System.out.println("5 Compute the distance between two robots");
		System.out.println("6. Exit");
		System.out.println("Please select an option:");
		Scanner in = new Scanner(System.in);
		int selection = in.nextInt();
		while(selection < 1 | selection > 6) {
			System.out.println("Please choose from the valid options:");
			selection = in.nextInt();
		}
		return selection;
	}
	
	public void processInput() {
		int selection = displayMenu();
		if(selection != 6) {
			System.out.println("You have selected: " + selection);
			processInput();
		} else {
			System.out.println("Goodbye!");
			return;
		}
		
	}
	
	

	public static void main(String[] args) {
		RobotMenu rm = new RobotMenu();
		rm.processInput();
	}

}
