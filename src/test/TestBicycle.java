package test;

import static org.junit.Assert.*;

import model.Bicycle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBicycle {
	Bicycle bicycle;
	
	
	@Before
	public void setUp() throws Exception {
		 bicycle = new Bicycle("12345");
	}

	@After
	public void tearDown() throws Exception {
		 bicycle = null;
	}

	@Test
	public final void testInGarage() {
		assertFalse("Not false", bicycle.isInGarage());
		bicycle.setInGarage(true);
		assertTrue("Not true", bicycle.isInGarage());
		bicycle.setInGarage(false);
		assertFalse("Not false", bicycle.isInGarage());
	}

	@Test
	public final void testID() {
		assertEquals("wrong ID ", "12345", bicycle.getID());
	}
}
