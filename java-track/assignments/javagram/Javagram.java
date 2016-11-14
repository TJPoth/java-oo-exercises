package javagram;

import javagram.filters.*;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Javagram {

	public static void main(String[] args) {

		// Create the base path for images		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String dir = String.join(File.separator, baseParts);
		String relPath;
		Picture picture = null;
		Scanner in = new Scanner(System.in);
		
		// prompt user for image to filter and validate input
		do {
			
			String imagePath = "path not set";
			
			// try to open the file
			try {
				
				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();
				
				imagePath = dir + File.separator + relPath;
				
				picture = new Picture(imagePath);
				
			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}
			
		} while(picture == null);
		
		// TODO - prompt user for filter and validate input
		// TODO - pass filter ID int to getFilter, and get an instance of Filter back 
		Filter filter = displayFilterMenu(in);			

		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();
		
		System.out.println("Image successfully filtered");
		
		// save image, if desired
		
		System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
		String fileName = in.next();
		
		// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original
		
		if (fileName.equals("exit")) {
			System.out.println("Image not saved");
		} else {
			String absFileName = dir + File.separator + fileName;
			processed.save(absFileName);
			System.out.println("Image saved to " + absFileName);
		}	
		
		// close input scanner
		in.close();
	}
	
	private static Filter displayFilterMenu(Scanner in) {
		System.out.println("Welcome to the filter selection menu!");
		System.out.println("Type number next to desired filter:");
		System.out.println("1. Blue Filter");
		System.out.println("2. Green Filter");
		System.out.println("3. Red Filter");
		int selection = in.nextInt();
		while (selection <= 0 || selection > 3) {
			System.out.println("Please choose a valid option:");
			selection = in.nextInt();
		}
		return getFilter(selection);
	}
	// TODO - refactor this method to accept an int parameter, and return an instance of the Filter interface
	// TODO - refactor this method to thrown an exception if the int doesn't correspond to a filter
	private static Filter getFilter(int selection) {
		if(selection == 1) {
			System.out.println("You successfully chose BlueFilter!");
			return new BlueFilter();
		} else if (selection == 2) {
			System.out.println("You successfully chose Green Filter!");
			return new GreenFilter();
		} else if (selection == 3) {
			System.out.println("You successfully chose Red Filter!");
			return new RedFilter();
		}
		else {
			return null;
		}
		 
		// TODO - create some more filters, and add logic to return the appropriate one
		
	}

}