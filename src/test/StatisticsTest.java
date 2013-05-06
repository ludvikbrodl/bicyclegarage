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
		assertEquals(0, stats.getBicycleInGarage());
		for (int i = 0; i < 10; i++) {
			stats.incrementBicyclesInGarage();
		}
		assertEquals(10, stats.getBicycleInGarage());
	}

}
