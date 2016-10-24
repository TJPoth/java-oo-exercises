
import java.util.Scanner;
import java.util.ArrayList;

public class Student {
	private Scanner in;
	
	private String firstName;
	private String lastName;
	private int studentID;
	private int credits = 0;
	private double GPA = 0;
	private ArrayList<Double> qualityScores;
	private int totalCredits;
	
	public Student(String firstName, String lastName, int studentID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
		in = new Scanner(System.in);
		qualityScores = new ArrayList<Double>();
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
		double totalQualityScores = 0;
		for(int i = 0; i < this.qualityScores.size(); i++) {
			totalQualityScores += this.qualityScores.get(i);
		}
		return totalQualityScores;
	}
	
	public String getClassStanding() {
		if (this.credits < 30) {
			return "Freshman";
		} else if (this.credits >= 30 & this.credits < 60) {
			return "Sophomore";
		} else if (this.credits >= 60 & this.credits < 90) {
			return "Junior";
		} else {
			return "Senior";
		}
	}
	
	public void submitGrade(int courseGrade, int courseCredits) {
		while(courseGrade < 0 || courseGrade > 4) {
			System.out.println("Invalid grade, please enter a new one below:");
			courseGrade = in.nextInt();
		} 
		double qualityScore = courseCredits * courseGrade;
		qualityScores.add(qualityScore);
		this.totalCredits += courseCredits;
	}
	
	public void getQualityScores() {
		for(int i = 0; i < this.qualityScores.size(); i++) {
			System.out.println(this.qualityScores.get(i));
		}
	}
	
	public static void main(String[] args) {
		Student bill = new Student("Bob", "Mitchler", 13398);
		bill.submitGrade(1, 4);
		bill.submitGrade(2, 4);
		bill.submitGrade(3, 4);
		bill.submitGrade(4, 4);
		bill.getQualityScores();
		System.out.println(bill.getGPA());

	}

}
