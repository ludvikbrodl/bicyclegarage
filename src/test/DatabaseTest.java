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
import persistence.UserLimitException;

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
		try {
			db.addUser(testUsr);
		} catch (UserLimitException e) {
			e.printStackTrace();
		}
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
		assertTrue("Should have been true", db.hasBicycleWithID("00000"));
	}

	/**
	 * Test method for {@link persistence.Database#getBicycleByID(String)}.
	 */
	@Test
	public void testGetBicycleByID() {
	
		Bicycle b = db.newBicycle(testUsr);
		assertEquals("Bicycles did not match",db.getBicycleByID("00001"), b);
	}

	

	/**
	 * Test method for {@link persistence.Database#addBicycle(Bicycle)}.
	 */
	@Test
	public void testNewBicycle() {
		Bicycle b = db.newBicycle(testUsr);
		assertTrue(db.hasBicycleWithID(b.getID()));
		assertTrue(testUsr.getBicycleIDs().contains(b.getID()));
	}

	/**
	 * Test method for {@link persistence.Database#removeBicycle(Bicycle)}.
	 */
	@Test
	public void testRemoveBicycle() {
	
		db.newBicycle(testUsr);
		assertTrue("Bicycle was not added", db.hasBicycleWithID("00003"));
		db.removeBicycle(db.getBicycleByID("00003"));
		assertFalse("Bicycle was not removed", db.hasBicycleWithID("00003"));
	}
	
	@Test
	public void testUpdateUserPincode() {
		db.updateUserPincode("654321", testUsr.getPincode());
		assertEquals("654321", testUsr.getPincode());
		assertTrue(db.hasUserWithPin("654321"));
		
		db.updateUserPincode("234567", "785479");
		assertFalse(db.hasUserWithPin("23456"));	
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
		int bsPin=100000;
		for(int i=0;i<19999;i++) { //one user is already added at setup
			try {
				db.addUser(new User(Integer.toString(bsPin), "", "", ""));
			} catch (UserLimitException e) {
				System.out.println(bsPin);
				e.printStackTrace();
			}
			bsPin++;
		}
		
		boolean exceptionIsThrown = false;
		try {
			bsPin++;
			db.addUser(new User(Integer.toString(bsPin), "", "", ""));
		} catch(UserLimitException e) {
			exceptionIsThrown = true;
		} 
		
		if(exceptionIsThrown) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
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
		try {
			db.addUser(new User("test", "test", "test", "test"));
		} catch (UserLimitException e) {
			e.printStackTrace();
		}
		assertEquals("Was not 2", 2, db.getNumberOfUsers());
	}
	
	@Test
	public void testReadWrite(){
		Bicycle b = db.newBicycle(testUsr);
		db.saveToFile();
		db = new Database();
		db.readFromFile();
		assertTrue("Should have been true", db.hasBicycleWithID(b.getID()));
		assertTrue("List did not contain requested pin", db.hasUserWithPin("123456"));
		
	}
	
}
