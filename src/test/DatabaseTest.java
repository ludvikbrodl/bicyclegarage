/**
 * 
 */
package test;

import static org.junit.Assert.*;

import model.Bicycle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import persistence.Database;

/**
 * @author axel
 *
 */
public class DatabaseTest {

	private Database db;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		db = new Database();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		db = null;
	}

	/**
	 * Test method for {@link persistence.Database#Database()}.
	 */
	@Test
	public void testDatabase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link persistence.Database#hasBicycleWithID(java.lang.String)}.
	 */
	@Test
	public void testHasBicycleWithID() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link persistence.Database#getBicycleByID(String)}.
	 */
	@Test
	public void testGetBicycleByID() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link persistence.Database#updateBicycleID(String, Bicycle)}.
	 */
	@Test
	public void testUpdateBicycleID() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link persistence.Database#addBicycle(Bicycle)}.
	 */
	@Test
	public void testAddBicycle() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link persistence.Database#removeBicycle(Bicycle)}.
	 */
	@Test
	public void testRemoveBicycle() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link persistence.Database#hasUserWithPin(java.lang.String)}.
	 */
	@Test
	public void testHasUserWithPin() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link persistence.Database#getUserByName(String)}.
	 */
	@Test
	public void testGetUserByName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link persistence.Database#addUser(User)}.
	 */
	@Test
	public void testAddUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link persistence.Database#removeUser(User)}.
	 */
	@Test
	public void testRemoveUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link persistence.Database#getNumberOfBicycles()}.
	 */
	@Test
	public void testGetNumberOfBicycles() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link persistence.Database#getNumberOfUsers()}.
	 */
	@Test
	public void testGetNumberOfUsers() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testConcurrentAccess() {
		for (int i = 0; i < 20; i++) {
			(new DBWriter()).start();
		}
		assertEquals(0,db.getNumberOfBicycles());
	}
	
	private class DBWriter extends Thread {
		public void run() {
			db.addBicycle(new Bicycle("id"));
			db.removeBicycle(db.getBicycleByID("id"));
		}
	}
}
