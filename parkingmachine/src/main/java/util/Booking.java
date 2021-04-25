package util;

public class Booking {
	
	private int parkingSpace;
	private int bookingTime;
	private String licensePlate;
	private String userEmail;
	private int BookingNumber;

	/**
	 * @return the bookingTime
	 */
	public int getBookingTime() {
		return bookingTime;
	}
	/**
	 * @param bookingTime the bookingTime to set
	 */
	public void setBookingTime(int bookingTime) {
		this.bookingTime = bookingTime;
	}
	/**
	 * @return the parkingSpace
	 */
	public int getParkingSpace() {
		return parkingSpace;
	}
	/**
	 * @param parkingSpace the parkingSpace to set
	 */
	public void setParkingSpace(int parkingSpace) {
		this.parkingSpace = parkingSpace;
	}
	/**
	 * @return the licensePlate
	 */
	public String getLicensePlate() {
		return licensePlate;
	}
	/**
	 * @param licensePlate the licensePlate to set
	 */
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}
	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	/**
	 * @return the bookingNumber
	 */
	public int getBookingNumber() {
		return BookingNumber;
	}
	/**
	 * @param bookingNumber the bookingNumber to set
	 */
	public void createAndSetBookingNumber() {
		int bookingNumber = (int) (Math.random() * (999999-100000+1)+100000);
		BookingNumber = bookingNumber;
	}
	/**
	 * @param bookingNumber the bookingNumber to set
	 */
	public void setBookingNumber(int bookingNumber) {
		BookingNumber = bookingNumber;
	}
	
	public String toString() {
		return this.BookingNumber + " " + this.bookingTime + " " + this.licensePlate + " " + this.parkingSpace + " " + this.userEmail;
	}

}
