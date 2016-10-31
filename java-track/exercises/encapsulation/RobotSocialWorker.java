package encapsulation;

public class RobotSocialWorker extends Robot {
	// choices of personality: 'cheerful', 'serious', 'southern'
	private String personality;
	
	public RobotSocialWorker(String name, int x, int y, int speed, String orientation, String personality) {
		super(name, x, y, speed, orientation);
		this.personality = personality;
	}
	
	public String greeting(Robot other) {
		if (this.personality == "cheerful") {
			return "Hello! How are you today, " + other.getName() + "?";
		} else if (this.personality == "serious") {
			return "Greetings, " + other.getName();
		} else {
			return "Howdy " + other.getName() + ", how are ya'll doin' today?";
		}
	}
	
	public String advice(Robot other) {
		if (this.personality == "cheerful") {
			return "When life gives you lemons, you can make lemonade. Or you can compost it for extra fuel!";
		} else if (this.personality == "serious") {
			return "It could be worse, at least you booted up this morning";
		} else {
			return "We have a sayin' back home: Milk the cow a hundred times once, or a thousand times a year!";
		}
	}
	
	public String goodbye(Robot other) {
		if (this.personality == "cheerful") {
			return "Have a great day, " + other.getName() + "! See you tomorrow.";
		} else if (this.personality == "serious") {
			return "Goodbye, " + other.getName();
		} else {
			return "See ya'll later";
		}
		
	}

	public static void main(String[] args) {
		RobotSocialWorker bill = new RobotSocialWorker("Bill", 0, 0, 2, "north", "southern");
		Robot fred = new Robot("Fred", 1, 1, 4, "west");
		System.out.println(bill.greeting(fred));

	}

}
