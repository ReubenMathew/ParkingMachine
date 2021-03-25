package users;

public class Customer extends User {
	String email;
	String password;

	public Customer(String email, String password) {
		this.email = email;
		this.password = password;
	}
}
