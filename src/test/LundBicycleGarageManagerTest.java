package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.BarcodePrinter;
import model.BarcodeReader;
import model.LundBicycleGarageManager;
import model.PinCodeTerminal;
import persistence.Database;
import persistence.Statistics;
import driver.*;

public class LundBicycleGarageManagerTest {
	private Database db;
	private LundBicycleGarageManager garageManager;
	

	@Before
	public void setUp() throws Exception {
		db = new Database();
		Statistics statistics = new Statistics(db);
		garageManager = new LundBicycleGarageManager(db, statistics);
		BarcodeReader barcodeEntry = new BarcodeReaderEntryTestDriver();
		BarcodePrinter barcodePrint = new BarcodePrinterTestDriver();
		BarcodeReader barcodeExit = new BarcodeReaderExitTestDriver();
	/**	BarcodeReader barcodeRead = new BarcodeReaderTestDriver();*/
	/**	ElectronicLock electronikLock = new ElectronicLockTestDriver(Entry);*/
		PinCodeTerminal pincodeTerminal = new PinCodeTerminalTestDriver();
		
	}

	@After	
	public void tearDown() throws Exception {
		db = null;
		garageManager = null;
	}

	@Test
	public void testRegisterHardwareDrivers() {
		assertEquals("random text", "svar", "metod");
		assertTrue("random text", true );/**metod elelr variabel som sak var true*/
		/**assertSame(String, expected, actual);*/
		/**assertNull([message], object)*/
	}

	@Test
	public void testEntryBarcode() {
		assertEquals("random text", "svar", "metod");
		
	}

	@Test
	public void testExitBarcode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEntryCharacter() {
		fail("Not yet implemented");
	}

}
