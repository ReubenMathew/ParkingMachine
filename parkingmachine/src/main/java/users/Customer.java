package users;

import java.util.Objects;

public class Customer extends User {

	private String firstName;
	private String lastName;

	public Customer(String email, String password) {
		setEmail(email);
		setPassword(password);
	}

	public Customer(String email, String password, String firstName, String lastName) {
		setEmail(email);
		setPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
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

	public String[] toStringArray() {
		String[] res = { getEmail(), getPassword(), getFirstName(), getLastName(), "0" };
		return res;
	}

	public boolean equals(Customer o) {
		if (this == o)
			return true;

		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Customer newCustomer = (Customer) o;

		return Objects.equals(getEmail(), newCustomer.getEmail()) && Objects.equals(getPassword(), newCustomer.getPassword());
	}

}
