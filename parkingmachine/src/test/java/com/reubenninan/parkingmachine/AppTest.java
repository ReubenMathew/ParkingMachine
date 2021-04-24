package com.reubenninan.parkingmachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import services.*;

public class AppTest {
	Database db = Database.getInstance();

	@Before
	public void setup() throws Exception {
		db.getUsers().clear();
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
		db.loadUsers();
		assertEquals(1, db.getUsers().size());
	}
	
	@Test
	public void test_user_validation() {
		db.loadUsers();
		assertTrue(db.validateUser("test1", "pass1"));
		assertFalse(db.validateUser("test2", "wrongpassword"));
	}

}
