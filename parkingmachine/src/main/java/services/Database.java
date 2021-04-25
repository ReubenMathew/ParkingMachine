package services;

import java.io.*;

import com.csvreader.*;

import util.*;

import java.util.*;

// Singleton Class -> Single Access Point
public class Database {

	private static final Database db = new Database();

	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Officer> officers = new ArrayList<Officer>();
	private ArrayList<Booking> bookings = new ArrayList<Booking>();

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

	public void loadBookings() {
		bookings.clear();
		try {
			CsvReader reader = new CsvReader("bookings.csv");
			reader.readHeaders();

			while (reader.readRecord()) {
				Booking booking = new Booking();
				booking.setBookingNumber(Integer.parseInt(reader.get("bookingNumber")));
				booking.setBookingTime(Integer.parseInt(reader.get("bookingTime")));
				booking.setLicensePlate(reader.get("licensePlate"));
				booking.setParkingSpace(Integer.parseInt(reader.get("parkingSpace")));
				booking.setUserEmail(reader.get("userEmail"));
				bookings.add(booking);
			}
		} catch (Exception e) {

		}
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
			}
		} catch (Exception e) {

		}
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
	public void printBookings() {
		for (Booking booking : bookings) {
			System.out.println(booking.toString());
		}
	}

	public void updateBookings() {
		try {
			CsvWriter writer = new CsvWriter(new FileWriter("bookings.csv", false), ',');

			writer.write("bookingNumber");
			writer.write("bookingTime");
			writer.write("licensePlate");
			writer.write("parkingSpace");
			writer.write("userEmail");
			writer.endRecord();

			for (Booking booking : bookings) {
				writer.write(Integer.toString(booking.getBookingNumber()));
				writer.write(Integer.toString(booking.getBookingTime()));
				writer.write(booking.getLicensePlate());
				writer.write(Integer.toString(booking.getParkingSpace()));
				writer.write(booking.getUserEmail());
				writer.endRecord();
			}
			writer.close();

		} catch (Exception e) {

		}
	}

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
	
	public ArrayList<Booking> userBookings(String email){
		ArrayList<Booking> res = new ArrayList<Booking>();
		for (Booking b : bookings) {
			if (b.getUserEmail().equals(email)) {
				res.add(b);
			}
		}
		return res;
	}

	public boolean bookingLimitReached(String email) {
		int bookingCount = 0;
		for (Booking b : bookings) {
			if (b.getUserEmail().equals(email)) {
				bookingCount++;
			}
		}
		return bookingCount == 3 ? true : false;
	}

	public void addBooking(int bookingTime, String licensePlate, int parkingSpace, String userEmail) {
		if (bookingLimitReached(userEmail)) {
			return;
		}
		Booking booking = new Booking();
		booking.createAndSetBookingNumber();
		booking.setBookingTime(bookingTime);
		booking.setLicensePlate(licensePlate);
		booking.setParkingSpace(parkingSpace);
		booking.setUserEmail(userEmail);

		for (Booking b : bookings) {
			// if parking space is booked then do not add
			if (b.getParkingSpace() == parkingSpace)
				return;
		}

		bookings.add(booking);
		updateBookings();
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

	public void removeBooking(int bookingNumber) {
		for (int i = 0; i < bookings.size(); i++) {
			if (bookings.get(i).getBookingNumber() == bookingNumber) {
				bookings.remove(i);
			}
		}
		updateBookings();
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

	public ArrayList<Booking> getBookings() {
		return this.bookings;
	}

	public ArrayList<Officer> getOfficers() {
		return this.officers;
	}

	public ArrayList<User> getUsers() {
		return this.users;
	}

	public User getUser(String email) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getEmail().equals(email)) {
				return users.get(i);
			}
		}
		return null;
	}

	public static Database getInstance() {
		db.loadOfficers();
		db.loadUsers();
		return db;
	}

	private Database() {

	}

}
