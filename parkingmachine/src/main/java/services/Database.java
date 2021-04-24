package services;

import java.io.*;
import com.csvreader.*;
import java.util.*;

import users.*;

// Singleton Class -> Single Access Point
public class Database {

	private final int USER_COLUMN_LENGTH = 5;
	private final int BOOKING_COLUMN_LENGTH = 4;

	private ArrayList<String[]> UserData;
	private ArrayList<String[]> BookingData;
	private static final Database db = new Database();

	public static Database getInstance() {
		return db;
	}

	private void updateData(ArrayList<String[]> data, String filename, int columns) {

		for (String[] s : data) {
			if (s.length > 0) {
				String line = Arrays.toString(s).substring(1, Arrays.toString(s).length() - 1);
				System.out.println(line);
			}
		}
		System.out.println("----------------");
	}

	private ArrayList<String[]> readData(String filename) throws IOException {
		ArrayList<String[]> content = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(getClass().getClassLoader().getResourceAsStream(filename)))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				content.add(line.split(","));
			}
		} catch (FileNotFoundException e) {
			System.out.println("File: " + filename + " not found");
		}

		return content;
	}

	private Database() {
		try {
			setUserData(readData("users.csv"));
			setBookingData(readData("bookings.csv"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// returns userType as integer, returns -1 if user not found
	public int getUserType(String email, String password) {

		int type = -1;
		for (String[] row : UserData) {
			String rowEmail = row[0];
			String rowPassword = row[1];
			if (rowEmail.equals(email) && rowPassword.equals(password)) {
				// 4th index == UserType
				type = Integer.parseInt(row[4]);
			}
		}

		return type;
	}

	public Customer getUser(String email, String password) {
		Customer customer = null;
		for (String[] row : UserData) {
			String rowEmail = row[0];
			String rowPassword = row[1];
			if (rowEmail.equals(email) && rowPassword.equals(password)) {
				String firstName = row[2];
				String lastName = row[3];
				customer = new Customer(email, password, firstName, lastName);
			}
		}
		return customer;
	}

	public void addUser(Customer customer) {
		String[] newCustomer = customer.toStringArray();
		UserData.add(newCustomer);

		updateData(UserData, "users.data", USER_COLUMN_LENGTH);
	}

	public ArrayList<String[]> getBookingData() {
		return BookingData;
	}

	public void setBookingData(ArrayList<String[]> bookingData) {
		BookingData = bookingData;
	}

	public ArrayList<String[]> getUserData() {
		return UserData;
	}

	public void setUserData(ArrayList<String[]> userData) {
		UserData = userData;
	}

}
