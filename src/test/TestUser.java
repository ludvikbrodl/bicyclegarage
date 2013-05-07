package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Bicycle;
import model.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUser {
	private User usr;
	@Before
	public void setUp() throws Exception {
		usr = new User("123456", "Per Persson", "921102", "randomAddress"); 
	}

	@After
	public void tearDown() throws Exception {
		usr=null;
	}

	@Test
	public void testGetSet() {
		assertEquals("Didn't match", usr.getPincode(), "123456");
		usr.setPincode("234567");
		assertEquals("Didn't match", usr.getPincode(), "234567");
		
		assertEquals("Didn't match", usr.getBirthDate(), "921102");
		usr.setBirthDate("911102");
		assertEquals("Didn't match", usr.getBirthDate(), "911102");
		
		assertEquals("Didn't match", usr.getAddress(), "randomAddress");
		usr.setAddress("randomAddress234");
		assertEquals("Didn't match", usr.getAddress(), "randomAddress234");
		
		assertEquals("Didn't match", usr.getName(), "Per Persson");
		usr.setName("Olof Olofsson");
		assertEquals("Didn't match", usr.getName(), "Olof Olofsson");
	}
	
	@Test
	public void testAddBicycle(){
		usr.addBicycle(new Bicycle("1234"));
		assertEquals("Was supposed to be 1" , usr.getBicycleIDs().size(), 1);
	}
	
	@Test
	public void testToManyBicycles(){
		for(int i = 0; i<6; i++){
			usr.addBicycle(new Bicycle(Integer.toString(i)));
		}
		assertEquals("Was supposed to be 5" , usr.getBicycleIDs().size(), 5);
	}
	
	@Test
	public void testRemoveBicycle(){
		Bicycle b = new Bicycle("1234");
		Bicycle c = new Bicycle("19278");
		usr.addBicycle(b);
		usr.removeBicycle(c);
		assertEquals("Was supposed to be 1" , usr.getBicycleIDs().size(), 1);
		usr.removeBicycle(b);
		assertEquals("Was supposed to be 0" , usr.getBicycleIDs().size(), 0);
	}
	
	@Test
	public void testGetBicycleIDs(){
		for(int i = 0; i<5; i++){
			usr.addBicycle(new Bicycle(Integer.toString(i)));
		}
		Iterator<String> itr = usr.getBicycleIDs().iterator();
		
		for(int i = 0; i<5; i++){
			assertEquals("Was supposed to be " + i , itr.next(), Integer.toString(i));
		}
	}
	

}
