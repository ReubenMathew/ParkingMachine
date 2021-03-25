package users;

public class SysAdmin extends User {
	String email;
	String password;

	public SysAdmin(String email, String password) {
		this.email = email;
		this.password = password;
	}
}
