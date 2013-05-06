package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.LundBicycleGarageManager;
import persistence.Database;
import driver.*;

public class LundBicycleGarageManagerTest {
	private Database Db;
	private LundBicycleGarageManager LBGM;
	

	@Before
	public void setUp() throws Exception {
		Db = new Database();
		LBGM = new LundBicycleGarageManager(Db);
		BarcodeReaderEntryTestDriver barcodeEntry = new BarcodeReaderEntryTestDriver();
		BarcodePrinterTestDriver barcodePrint = new BarcodePrinterTestDriver();
		BarcodeReaderExitTestDriver barcodeExit = new BarcodeReaderExitTestDriver();
	/**	BarcodeReaderTestDriver BarcodeRead = new BarcodeReaderTestDriver();*/
	/**	ElectronicLockTestDriver Electroniklock = new ElectronicLockTestDriver(Entry);*/
		PinCodeTerminalTestDriver Pincode = new PinCodeTerminalTestDriver();
		
	}

	@After	
	public void tearDown() throws Exception {
		Db = null;
		LBGM = null;
	}

	@Test
	public void testRegisterHardwareDrivers() {
		fail("Not yet implemented");
	}

	@Test
	public void testEntryBarcode() {
		fail("Not yet implemented");
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
