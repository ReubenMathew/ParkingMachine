package com.reubenninan.parkingmachine;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import services.*;
import users.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
	Database db = Database.getInstance();

	@Before
	public void setup() throws Exception {
		db.addCustomer(new Customer("test@gmail.com", "1234", "First", "Last"));
	}

	@Test
	public void test_add_Customer() {
		Customer newCustomer = new Customer("bobby@gmail.com", "1234", "Bobby", "Boy");
		db.addCustomer(newCustomer);

		Assert.assertTrue(db.getCustomer("bobby@gmail.com", "1234").equals(newCustomer));
	}

	@Test
	public void test_getUserType_Customer() {
		int type = db.getUserType("test@gmail.com", "1234");
		Assert.assertEquals(type, 0);
	}

	@Test
	public void test_getUserType_Officer() {

	}

	@Test
	public void test_getUserType_SysAdmin() {

	}
}
