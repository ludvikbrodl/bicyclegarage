package test;

import static org.junit.Assert.*;

import model.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SystemTest {
	private User axel, kasper, ludvig;
	@Before
	public void setUp() throws Exception {
		axel = new User("123456", "Axel Andersson", "1990-04-27", "Brogatan 1");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
