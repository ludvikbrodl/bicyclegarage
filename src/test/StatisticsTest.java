package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import persistence.Database;
import persistence.Statistics;

public class StatisticsTest {
	private Statistics stats;
	@Before
	public void setUp() throws Exception {
		Database db = new Database();
		stats = new Statistics(db);
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
	
	@Test  /** hur !?!?!?!?!?!*/
	public void testGetNumberOfEntriesPerMonth(){
		
	}
	
	@Test
	public void testGetNumberOfBicycles(){
		
	}
	
	@Test
	public void testGetNumberOfUsers(){
		
	}
	
	@Test
    public void incrementNumberOfBicyclesThisMonth(){
		
	}
	


}
