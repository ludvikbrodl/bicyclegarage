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
	private BarcodeReaderEntryTestDriver barcodeEntry;
	private BarcodeReaderExitTestDriver barcodeExit;	

	@Before
	public void setUp() throws Exception {
		db = new Database();
		pincode = "123456";
		User user = new User(pincode, "kalle", "930110", "magistratsv. 44");
		Bicycle bicycle = db.newBicycle(user);
		bicycleID = bicycle.getID();
		Statistics statistics = new Statistics(db);
		barcodeEntry = new BarcodeReaderEntryTestDriver();
		barcodeEntry.register(garageManager);
		barcodeExit = new BarcodeReaderExitTestDriver();
		barcodeExit.register(garageManager);
		BarcodePrinter printer = new BarcodePrinterTestDriver();
		ElectronicLock entryLock = new ElectronicLockTestDriver("Entry");
		ElectronicLock exitLock = new ElectronicLockTestDriver("Exit");
		PinCodeTerminal terminal = new PinCodeTerminalTestDriver();
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
		barcodeEntry.informManager(bicycleID);
	}

	@Test
	public void testExitBarcode() {
		barcodeExit.informManager(bicycleID);
	}

	@Test
	public void testEntryCharacter() {
		fail("Not yet implemented");
	}

}
