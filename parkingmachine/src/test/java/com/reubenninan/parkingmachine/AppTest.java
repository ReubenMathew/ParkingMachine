package com.reubenninan.parkingmachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import services.*;

public class AppTest {
	Database db = Database.getInstance();

	@Before
	public void setup() throws Exception {
		db.getUsers().clear();
		db.updateUsers();
		db.getOfficers().clear();
		db.updateOfficers();
		db.getBookings().clear();
		db.updateBookings();
	}

	@After
	public void teardown() throws Exception {
		db.getUsers().clear();
		db.updateUsers();
		db.getOfficers().clear();
		db.updateOfficers();
		db.getBookings().clear();
		db.updateBookings();
	}

	@Test
	public void test_user_add() {
		db.addUser("test1", "pass1", "first1", "last1");
		db.addUser("test2", "pass2", "first2", "last2");

		db.loadUsers();
		assertEquals(2, db.getUsers().size());
	}

	@Test
	public void test_user_remove() {
		db.addUser("test1", "pass1", "first1", "last1");
		db.addUser("test2", "pass2", "first2", "last2");
		db.removeUser("test2");
//		db.printUsers();
		db.loadUsers();
		assertEquals(1, db.getUsers().size());
	}

	@Test
	public void test_user_validation() {
		db.loadUsers();
		db.addUser("test1", "pass1", "first1", "last1");
		db.addUser("test2", "pass2", "first2", "last2");
		assertTrue(db.validateUser("test1", "pass1"));
		assertFalse(db.validateUser("test2", "wrongpassword"));
	}

	@Test
	public void test_officer_add() {
		db.addNewOfficer("officer1", "pass1");
		db.addNewOfficer("officer2", "pass2");

		db.loadOfficers();
		assertEquals(2, db.getOfficers().size());
	}

	@Test
	public void test_officer_remove() {
		db.addNewOfficer("officer1", "pass1");
		db.addNewOfficer("officer2", "pass2");
		db.removeOfficer("officer2");
//		db.printOfficers();
		db.loadOfficers();
		assertEquals(1, db.getOfficers().size());
	}

	@Test
	public void test_officer_validation() {
		db.loadOfficers();
		db.addNewOfficer("officer1", "pass1");
		db.addNewOfficer("officer2", "pass2");
		assertTrue(db.validateOfficer("officer1", "pass1"));
		assertFalse(db.validateOfficer("officer2", "wrongpassword"));
	}

	@Test
	public void test_booking_add() {
		db.addBooking(0, "LDS", 1, "test1");
		db.addBooking(0, "LXA", 2, "test1");
		db.loadBookings();
		assertEquals(2, db.getBookings().size());

		// Test already booked parking spot
		db.addBooking(0, "LDA", 2, "test1");
		db.loadBookings();
		assertEquals(2, db.getBookings().size());
	}

	@Test
	public void test_booking_remove() {
		db.addBooking(0, "LDS", 1, "test1");
		db.addBooking(0, "LXA", 2, "test1");
		db.removeBooking(db.getBookings().get(1).getBookingNumber());
		assertEquals(1, db.getBookings().size());
	}

}
