package users;

public class Officer {
	private String email;
	private String password;
	private int uid;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUID() {
		return this.uid;
	}

	public void setUID(int uid) {
		this.uid = uid;
	}

	public void setUID() {
		int uid = 0;
		this.uid = uid;
	}

	public String toString() {
		return this.email + " " + this.password + " " + this.uid;
	}

}
