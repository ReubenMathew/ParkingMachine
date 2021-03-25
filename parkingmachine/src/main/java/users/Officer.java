package users;

public class Officer extends User {
	String email;
	String password;

	public Officer(String email, String password) {
		this.email = email;
		this.password = password;
	}
}
