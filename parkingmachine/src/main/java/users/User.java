package users;

import java.util.Objects;

public class User {
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	
	public User() {
		
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String toString() {
		return this.email + " " + this.password + " " + this.firstName + " " + this.lastName;
	}

//	public boolean equals(User o) {
//		if (this == o)
//			return true;
//
//		if (o == null)
//			return false;
//		if (getClass() != o.getClass())
//			return false;
//		User newUser = (User) o;
//
//		return Objects.equals(getEmail(), newUser.getEmail())
//				&& Objects.equals(getPassword(), newUser.getPassword());
//	}

}
