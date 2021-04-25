package util;

import java.util.ArrayList;

public class Officer {
	private String email;
	private String password;
	private int uid;
	private static ArrayList<Integer> parkingSpaces;

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
		int uid = (int) (Math.random() * (999999-100000+1)+100000);
		this.uid = uid;
	}

	public String toString() {
		return this.email + " " + this.password + " " + this.uid;
	}
	
	public ArrayList<Integer> getParkingSpaces() {
		return Officer.parkingSpaces;
	}
	
	public boolean isParkingSpace(int parkingSpace) {
		for (int p : parkingSpaces)
			if (p == parkingSpace)
				return true;
		return false;
	}
	
	public void addParkingSpace(int parkingSpace) {
		parkingSpaces.add(parkingSpace);
	}
	
	public void removeParkingSpace(int parkingSpace) {
		if (isParkingSpace(parkingSpace)) {
			for (int i = 0; i < parkingSpaces.size(); i++) {
				if (parkingSpaces.get(i) == parkingSpace)
					parkingSpaces.remove(i);
			}
		}
	}
}
