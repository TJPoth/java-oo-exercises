
import java.util.ArrayList;

public class Course {

	private String name;
	private int credits;
	private int remainingSeats;
	private ArrayList<Student> roster;

	public Course(String name, int credits, int remainingSeats) {
		this.name = name;
		this.credits = credits;
		this.remainingSeats = remainingSeats;
		roster = new ArrayList<Student>(remainingSeats);
	}

	public String getName() {
		return this.name;
	}

	public int getCredits() {
		return this.credits;
	}

	public int getRemainingSeats() {
		return this.remainingSeats;
	}

	public boolean addStudent(Student a) {
		if(this.remainingSeats == 0) {
			return false;
		}
		for(int i = 0; i < roster.size(); i++) {
			if (a.getName() == roster.get(i).getName()) {
				return false;
			}
		}
		roster.add(a);
		this.remainingSeats--;
		return true;
	}

	public void generateRoster() {
		for(int i = 0; i <roster.size(); i++) {
			if (!roster.get(i).getName().equals("")) {
				roster.get(i).toString();
			}
		}
	}

	public double averageGPA() {
		double totalGPA = 0;
		double counter = 0;
		for(int i = 0; i <roster.size(); i++) {
			if (!roster.get(i).getName().equals("")) {
				totalGPA += roster.get(i).getGPA();
				counter++;
			}
		}
		return totalGPA / counter;
	}
	
	public String toString() {
		return "Name: " + this.name + " | Credits: " + this.credits;
	}

		public static void main(String[] args) {

		}

	}
