
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
	
	
	public Student(String firstName, String lastName, int studentID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
		this.credits = 0;
		this.GPA = 0.0;
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
		if(this.qualityScores.size() < 1) {
			return 0.0;
		}
		double rawGPA = totalQualityScores/this.qualityScores.size();
		double roundedGPA = (rawGPA * 1000) / 1000;
		return roundedGPA;
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
	
	public void submitGrade(double courseGrade, double courseCredits) {
		while(courseGrade < 0 || courseGrade > 4) {
			System.out.println("Invalid grade, please a grade between 0 and 4: ");
			courseGrade = in.nextInt();
		} 
		double qualityScore = courseCredits * courseGrade;
		qualityScores.add(qualityScore);
		this.credits += courseCredits;
	}
	
	public void getQualityScores() {
		for(int i = 0; i < this.qualityScores.size(); i++) {
			System.out.println(this.qualityScores.get(i));
		}
	}
	
	public double computeTuition() {
		int semester = this.credits / 15;
		int leftover = this.credits % 15;
		double tuition = (semester * 20000.0) + (leftover * (20000 / 15.0));
		return (int)(tuition*100) / 100.0;
	}
	
	
	public static void main(String[] args) {
		Student bill = new Student("Bob", "Mitchler", 13398);
		bill.submitGrade(1, 4);
		bill.submitGrade(2, 4);
		bill.submitGrade(4, 4);
		bill.submitGrade(3, 3);
		bill.getQualityScores();
		System.out.println();
		System.out.print("GPA: ");
		System.out.println(bill.getGPA());
		System.out.print("Credits: ");
		System.out.println(bill.getCredits());
		System.out.print("Tuition Cost: ");
		System.out.println(bill.computeTuition());
	}

}
