package test;

import static org.junit.Assert.*;

import model.Bicycle;
import model.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import persistence.Database;
import persistence.Statistics;
import persistence.UserLimitException;

public class StatisticsTest {
	private Statistics stats;
	private Database database;
	@Before
	public void setUp() throws Exception {
		database = new Database();
		stats = new Statistics(database);
		
	}

	@After
	public void tearDown() throws Exception {
		stats = null;
	}

	@Test
	public void testIncrementBicyclesInGarage() {
		assertEquals(0, stats.getBicyclesInGarage());
		for (int i = 0; i < 10; i++) {
			stats.incrementBicyclesInGarage();
		}
		assertEquals(10, stats.getBicyclesInGarage());
		int i = stats.getNumberOfEntriesPerMonth().get(0);
		assertEquals(10,i);
	}
	
	
	@Test /** Testar getBicycleInGarage också */
	public void testDecrementBicyclesInGarage() {
		assertEquals(0, stats.getBicyclesInGarage());
		for (int i = 0; i < 10; i++) {
			stats.incrementBicyclesInGarage();
		}
		
		assertEquals(10, stats.getBicyclesInGarage());
		stats.decrementBicyclesInGarage();
		assertEquals(9,stats.getBicyclesInGarage());
		
		for(int i= 0 ; i< 9; i++){
			stats.decrementBicyclesInGarage();
		}
		assertEquals(0, stats.getBicyclesInGarage());
		
	}
	@Test
	public void testDecrementBicyclesInGarageWhenEmpty() {
		stats.decrementBicyclesInGarage();
		assertEquals(0,stats.getBicyclesInGarage());
	}
	
	
	@Test
	public void testGetNumberOfBicycles(){
		User user = new User("pincode", "name", "birthDate", "address");
		
		try {
			database.addUser(user);
		} catch (UserLimitException e) {
			
		}
		Bicycle bicycle = database.newBicycle(user);
		assertEquals(1,stats.getNumberOfBicycles());
		database.removeBicycle(bicycle);
		assertEquals(0,stats.getNumberOfBicycles());
		
	}
	
	@Test
	public void testGetNumberOfUsers(){
		
		User user = new User("pincode", "name", "birthDate", "address");
		
		try {
			database.addUser(user);
		} catch (UserLimitException e) {
			
		}
		assertEquals(1,stats.getNumberOfUsers());
		database.removeUser(user);
		assertEquals(0,stats.getNumberOfUsers());
	}

}
