package services;

import java.io.*;
import java.nio.charset.Charset;

import com.csvreader.*;
import java.util.*;

import users.*;

// Singleton Class -> Single Access Point
public class Database {

	private static final Database db = new Database();

	private ArrayList<User> users = new ArrayList<User>();

	public void loadUsers() {
		users.clear();
		try {
			CsvReader reader = new CsvReader("users.csv");
			reader.readHeaders();

			while (reader.readRecord()) {
				User user = new User();
				user.setEmail(reader.get("email"));
				user.setPassword(reader.get("password"));
				user.setFirstName(reader.get("firstname"));
				user.setLastName(reader.get("lastname"));
				users.add(user);
//				System.out.println(user.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		printUsers();
	}

//	public void printUsers() {
//		for (User user : users) {
//			System.out.println(user.toString());
//		}
//	}

	public void updateUsers() {
		try {
			CsvWriter writer = new CsvWriter(new FileWriter("users.csv", false), ',');

			writer.write("email");
			writer.write("password");
			writer.write("firstname");
			writer.write("lastname");
			writer.endRecord();

			for (User user : users) {
//			System.out.println(user.getEmail());
				writer.write(user.getEmail());
				writer.write(user.getPassword());
				writer.write(user.getFirstName());
				writer.write(user.getLastName());
				writer.endRecord();
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addUser(String email, String password, String firstname, String lastname) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setFirstName(firstname);
		user.setLastName(lastname);

		users.add(user);

		updateUsers();
	}

	public void removeUser(String email) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getEmail().equals(email)) {
				users.remove(i);
			}
		}
		updateUsers();
	}

	public ArrayList<User> getUsers() {
		return this.users;
	}

	public static Database getInstance() {
		return db;
	}

	private Database() {
//		try {
//			loadUsers();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
