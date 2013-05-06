package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.BarcodeReader;
import model.LundBicycleGarageManager;
import model.PinCodeTerminal;
import persistence.Database;
import driver.*;

public class LundBicycleGarageManagerTest {
	private Database Db;
	private LundBicycleGarageManager LBGM;
	

	@Before
	public void setUp() throws Exception {
		Db = new Database();
		LBGM = new LundBicycleGarageManager(Db);
		BarcodeReader barcodeEntry = new BarcodeReaderEntryTestDriver();
		BarcodePrinterTestDriver barcodePrint = new BarcodePrinterTestDriver();
		BarcodeReader barcodeExit = new BarcodeReaderExitTestDriver();
	/**	BarcodeReader barcodeRead = new BarcodeReaderTestDriver();*/
	/**	ElectronicLock electronikLock = new ElectronicLockTestDriver(Entry);*/
		PinCodeTerminal pincode = new PinCodeTerminalTestDriver();
		
	}

	@After	
	public void tearDown() throws Exception {
		Db = null;
		LBGM = null;
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
