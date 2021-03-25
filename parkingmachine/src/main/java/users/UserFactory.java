package users;

import services.Database;

public class UserFactory {
	public User getUser(String email, String password) {

		Database db = Database.getInstance();
		int type = db.getUserType(email, password);

		if (type == UserTypes.Customer.ordinal())
			return new Customer(email, password);
		if (type == UserTypes.Officer.ordinal())
			return new Officer(email, password);
		if (type == UserTypes.SysAdmin.ordinal())
			return new SysAdmin(email, password);

		return null;
	}
}
