package blogz;

public class User {
	
	private String username;
	private String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = hashPassword(password);
	}
	
	
	private static String hashPassword(String password) {
		return password;
	}
	
	private boolean isValidPassword(String password) {
		if(hashPassword(password) != this.password) {
			return false;
		}
		return true;
	}
	
	private static boolean isValidUsername(String username) {
		
	}

	public static void main(String[] args) {

	}

}
