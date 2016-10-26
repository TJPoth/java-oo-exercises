
import java.util.Scanner;
import java.util.ArrayList;

public class Student {
	private Scanner in;
	
	private String firstName;
	private String lastName;
	private int studentID;
	private int credits;
	private double GPA;
	private ArrayList<Double> qualityScores;
	
	
	public Student(String firstName, String lastName, int studentID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
		this.credits = 0;
		this.GPA = 0.00;
		in = new Scanner(System.in);
		qualityScores = new ArrayList<Double>();
	}
	
	public Student(String firstName, String lastName, int studentID, int credits, double GPA) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.studentID = studentID;
			this.credits = credits;
			this.GPA = GPA;
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
		return this.GPA;
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
			System.out.println("Invalid grade, please enter a grade between 0 and 4: ");
			courseGrade = in.nextInt();
		} 
		double qualityScore = courseCredits * courseGrade;
		qualityScores.add(qualityScore);
		this.credits += courseCredits;
		
		//computes new GPA
		double totalQualityScores = 0;
		for(int i = 0; i < this.qualityScores.size(); i++) {
			totalQualityScores += this.qualityScores.get(i);
		}
		
		double rawGPA = totalQualityScores / (double)this.credits;
		double roundedGPA = (int)(rawGPA * 1000) / 1000.0;
		this.GPA = roundedGPA;
	}
	
	public void getQualityScores() {
		for(int i = 0; i < this.qualityScores.size(); i++) {
			System.out.println(this.qualityScores.get(i));
		}
	}
	
	public double computeTuition() {
		int semester = this.credits / 15;
		int leftover = this.credits % 15;
		double tuition = (double)(semester * 20000.00) + (double)(leftover * 1333.33);
		return tuition;
	}
	
	public Student createLegacy(Student a, Student b) {
		String legacyFirstName = a.getName();
		String legacyLastName = b.getName();
		int legacyID = a.studentID + b.studentID;
		double legacyGPA = (a.getGPA() + b.getGPA()) / 2.00;
		int legacyCredits = Math.max(a.getCredits(), b.getCredits());
		return new Student(legacyFirstName, legacyLastName, legacyID, legacyCredits, legacyGPA);
	}
	
	
	public static void main(String[] args) {
		Student bill = new Student("Bob", "Mitchler", 13398);
		bill.submitGrade(4, 4);
		bill.submitGrade(2, 1);
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
