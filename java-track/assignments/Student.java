
public class Student {
	
	private String firstName;
	private String lastName;
	private int studentID;
	private int credits = 0;
	private double GPA = 0;
	
	public Student(String firstName, String lastName, int studentID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
	}
	
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	public int getStudentID() {
		return this.studentID;
	}
	
	public int getCredits() {
		return this.credits;
	}

	public double getGPA() {
		return this.GPA;
	}
	
	public static void main(String[] args) {

	}

}
