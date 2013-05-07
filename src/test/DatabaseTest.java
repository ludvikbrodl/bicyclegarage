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
 * @author Kasper
 *
 */
public class DatabaseTest {

	private Database db;
	private User testUsr;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		db = new Database();
		testUsr = new User("123456", "Pelle", "Norrborg", "110213");
		db.addUser(testUsr);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		db = null;
		testUsr = null;
	}

	

	/**
	 * Test method for {@link persistence.Database#hasBicycleWithID(java.lang.String)}.
	 */
	@Test
	public void testHasBicycleWithID() {
	
		db.newBicycle(testUsr);
		assertTrue("Should have been true", db.hasBicycleWithID("10000"));
	}

	/**
	 * Test method for {@link persistence.Database#getBicycleByID(String)}.
	 */
	@Test
	public void testGetBicycleByID() {
	
		Bicycle b = db.newBicycle(testUsr);
		assertEquals("Bicycles did not match",db.getBicycleByID("10001"), b);
	}

	

	/**
	 * Test method for {@link persistence.Database#addBicycle(Bicycle)}.
	 */
	@Test
	public void testNewBicycle() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link persistence.Database#removeBicycle(Bicycle)}.
	 */
	@Test
	public void testRemoveBicycle() {
	
		db.newBicycle(testUsr);
		assertTrue("Bicycle was not added", db.hasBicycleWithID("10002"));
		db.removeBicycle(db.getBicycleByID("10002"));
		assertFalse("Bicycle was not removed", db.hasBicycleWithID("10002"));
	}

	/**
	 * Test method for {@link persistence.Database#hasUserWithPin(java.lang.String)}.
	 */
	@Test
	public void testHasUserWithPin() {
		
		assertTrue("List did not contain requested pin", db.hasUserWithPin("123456"));
	}

	/**
	 * Test method for {@link persistence.Database#getUserByName(String)}.
	 */
	@Test
	public void testGetUserByName() {
	
		assertEquals("Users didn't match", testUsr, db.getUserByName("Pelle"));
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
		
		assertTrue("Was not true",db.hasUserWithPin("123456"));
		db.removeUser(testUsr);
		assertFalse("Was not false",db.hasUserWithPin("123456"));
	}

	/**
	 * Test method for {@link persistence.Database#getNumberOfBicycles()}.
	 */
	@Test
	public void testGetNumberOfBicycles() {
	
		db.newBicycle(testUsr);
		assertEquals("Was not 1", 1, db.getNumberOfBicycles());
		db.newBicycle(testUsr);
		assertEquals("Was not 2", 2, db.getNumberOfBicycles());
	}

	/**
	 * Test method for {@link persistence.Database#getNumberOfUsers()}.
	 */
	@Test
	public void testGetNumberOfUsers() {
		
		assertEquals("Was not 1", 1, db.getNumberOfUsers());
		db.addUser(new User("test", "test", "test", "test"));
		assertEquals("Was not 2", 2, db.getNumberOfUsers());
	}
	
	@Test
	public void testReadWrite(){
		db.newBicycle(testUsr);
		db.saveToFile();
		db = new Database();
		db.readFromFile();
		assertTrue("Should have been true", db.hasBicycleWithID("10003"));
		assertTrue("List did not contain requested pin", db.hasUserWithPin("123456"));
		
	}
	
}
