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
		axel = new User("100000", "Axel Andersson", "1990-04-27", "Brogatan 1");
		kasper = new User("100001", "Kasper Karlsson", "1990-08-12", "Magistratsv�gen 55");
		ludvig = new User("100002", " Ludvig Larsson", " 1992-03-04", "K�mn�rsv�gen 78");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
