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
	private ArrayList<Officer> officers = new ArrayList<Officer>();

	public boolean validateOfficer(String email, String password) {
		for (int i = 0; i < officers.size(); i++) {
			Officer officer = officers.get(i);
			if (officer.getEmail().equals(email) && officer.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	public boolean validateUser(String email, String password) {
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	public void loadOfficers() {
		officers.clear();
		try {
			CsvReader reader = new CsvReader("officers.csv");
			reader.readHeaders();

			while (reader.readRecord()) {
				Officer officer = new Officer();
				officer.setEmail(reader.get("email"));
				officer.setPassword(reader.get("password"));
				officer.setUID(Integer.parseInt(reader.get("uid")));
				officers.add(officer);
			}
		} catch (Exception e) {

		}
	}

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
			
		}
//		printUsers();
	}

//	public void printOfficers() {
//		for (Officer officer : officers) {
//			System.out.println(officer.toString());
//		}
//	}
//
//	public void printUsers() {
//		for (User user : users) {
//			System.out.println(user.toString());
//		}
//	}

	public void updateOfficers() {
		try {
			CsvWriter writer = new CsvWriter(new FileWriter("officers.csv", false), ',');

			writer.write("email");
			writer.write("password");
			writer.write("uid");
			writer.endRecord();

			for (Officer officer : officers) {
				writer.write(officer.getEmail());
				writer.write(officer.getPassword());
				writer.write(Integer.toString(officer.getUID()));
				writer.endRecord();
			}
			writer.close();

		} catch (Exception e) {

		}
	}

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

		}
	}

	public void addNewOfficer(String email, String password) {
		this.removeOfficer(email);
		Officer officer = new Officer();
		officer.setEmail(email);
		officer.setPassword(password);
		officer.setUID();

		officers.add(officer);
		updateOfficers();
	}

	public void addUser(String email, String password, String firstname, String lastname) {
		removeUser(email);
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setFirstName(firstname);
		user.setLastName(lastname);

		users.add(user);

		updateUsers();
	}

	public void removeOfficer(String email) {
		for (int i = 0; i < officers.size(); i++) {
			if (officers.get(i).getEmail().equals(email)) {
				officers.remove(i);
			}
		}

		updateOfficers();
	}

	public void removeUser(String email) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getEmail().equals(email)) {
				users.remove(i);
			}
		}

		updateUsers();
	}

	public ArrayList<Officer> getOfficers() {
		return this.officers;
	}

	public ArrayList<User> getUsers() {
		return this.users;
	}

	public static Database getInstance() {
		db.loadOfficers();
		db.loadUsers();
		return db;
	}

	private Database() {
		
	}

}
