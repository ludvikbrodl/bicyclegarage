package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.BarcodePrinter;
import model.BarcodeReader;
import model.Bicycle;
import model.ElectronicLock;
import model.LundBicycleGarageManager;
import model.PinCodeTerminal;
import model.User;
import persistence.Database;
import persistence.Statistics;
import driver.*;

public class LundBicycleGarageManagerTest {
	private Database db;
	private LundBicycleGarageManager garageManager;
	private String pincode;
	private String bicycleID;
	private BarcodeReaderExitTestDriver barcodeExit;	
	private ElectronicLockTestDriver entryLock; 
	private ElectronicLockTestDriver exitLock; 
	private PinCodeTerminalTestDriver terminal;
	@Before
	public void setUp() throws Exception {
		db = new Database();
		pincode = "123456";
		User user = new User(pincode, "kalle", "930110", "magistratsv. 44");
		db.addUser(user);
		Bicycle bicycle = db.newBicycle(user);
		bicycleID = bicycle.getID();
		Statistics statistics = new Statistics(db);
		BarcodeReaderEntryTestDriver barcodeEntry = new BarcodeReaderEntryTestDriver();
		barcodeEntry.register(garageManager);
		BarcodeReaderExitTestDriver barcodeExit = new BarcodeReaderExitTestDriver();
		barcodeExit.register(garageManager);
		BarcodePrinter printer = new BarcodePrinterTestDriver();
		entryLock = new ElectronicLockTestDriver("Entry");
		exitLock = new ElectronicLockTestDriver("Exit");
		terminal = new PinCodeTerminalTestDriver();
		garageManager = new LundBicycleGarageManager(db, statistics);
		garageManager.registerHardwareDrivers(printer, entryLock, exitLock, terminal);
		
	}

	@After	
	public void tearDown() throws Exception {
		db = null;
		garageManager = null;
	}

	@Test
	public void testEntryBarcode() {
		garageManager.entryBarcode(bicycleID);
		assertTrue(db.getBicycleByID(bicycleID).isInGarage());
		assertTrue(entryLock.isOpen());
	}
	
	@Test
	public void testEntryBarcode2() {
		garageManager.entryBarcode("654321");
		assertFalse(entryLock.isOpen());
	}
	
	@Test
	public void testEntryBarcodeFullGarage() {
		for (int i = 0; i < 2000; i++) {
			garageManager.entryBarcode(bicycleID);
		}
		try {
			Thread.sleep(16000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertFalse(entryLock.isOpen());
		garageManager.entryBarcode(bicycleID);
		assertFalse(entryLock.isOpen());
		assertTrue(terminal.greenIsOn());
		assertTrue(terminal.redIsOn());
	}
	@Test
	public void testExitBarcode() {
		garageManager.exitBarcode(bicycleID);
		assertFalse(db.getBicycleByID(bicycleID).isInGarage());
		assertTrue(exitLock.isOpen());
	}
	
	@Test
	public void testExitBarcode2() {
		garageManager.exitBarcode("654321");
		assertFalse(exitLock.isOpen());
	}

	@Test
	public void testEntryCharacter() {
		for(char c: pincode.toCharArray()) {
			garageManager.entryCharacter(c);
		}
		assertTrue(entryLock.isOpen());
	}		
	
	@Test
	public void testEntryCharacter2() {
		for(char c: "654321".toCharArray()) {
			garageManager.entryCharacter(c);
		}
		assertFalse(entryLock.isOpen());
	}
	
	@Test
	public void testEntryCharacterStar() {
		for(char c: "12345*6".toCharArray()) {
			garageManager.entryCharacter(c);
		}
		assertFalse(entryLock.isOpen());
	}
	
	@Test
	public void testPincodeTerminalTimeout() {
		for(char c : "12345".toCharArray()) {
			garageManager.entryCharacter(c);
		}
		try {
			Thread.sleep(14000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		garageManager.entryCharacter('6');
		assertTrue(entryLock.isOpen());
	}	
	
	@Test
	public void testPincodeTerminalTimeout2() {
		for(char c : "12345".toCharArray()) {
			garageManager.entryCharacter(c);
		}
		try {
			Thread.sleep(16000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		garageManager.entryCharacter('6');
		assertFalse(entryLock.isOpen());
	}

}
