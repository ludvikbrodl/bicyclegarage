/**
 * 
 */
package test;

import static org.junit.Assert.*;

import model.Bicycle;
import model.User;

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
	 * Test method for {@link persistence.Database#hasBicycleWithID(java.lang.String)}.
	 */
	@Test
	public void testHasBicycleWithID() {
		User testUsr = new User("123456", "Pelle", "Norrborg", "110213");
		db.addUser(testUsr);
		db.newBicycle(testUsr);
		assertTrue("Should have been true", db.hasBicycleWithID("10000"));
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
	
}
