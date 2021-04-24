package com.reubenninan.parkingmachine;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import services.*;

public class AppTest {
	Database db = Database.getInstance();

	@Before
	public void setup() throws Exception {
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
		db.removeUser("test2");
		assertEquals(1, db.getUsers().size());
	}

}
