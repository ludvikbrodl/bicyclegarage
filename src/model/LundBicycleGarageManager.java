package model;

import java.util.Date;

import persistence.Database;

/**
 *
 */
public class LundBicycleGarageManager implements BicycleGarageManager {  
	BarcodePrinter printer;
	ElectronicLock entryLock; 
	ElectronicLock exitLock;
	PinCodeTerminal terminal;
	private Database db;
	private Date lastCharacterEntryTime;
	private StringBuilder pincode;
	private final int TIMEOUT = 15;
	private final char CLEAR_ALL = '*';
	private final int OPEN_DOOR_TIME = 10;
    public LundBicycleGarageManager(Database db) {
    	this.db = db;
    	pincode = new StringBuilder();
	}

	@Override
	public void registerHardwareDrivers(BarcodePrinter printer,
			ElectronicLock entryLock, ElectronicLock exitLock,
			PinCodeTerminal terminal) {
		
		this.printer = printer;
		this.entryLock = entryLock;
		this.exitLock = exitLock;
		this.terminal = terminal;
		
	}

	@Override
	public void entryBarcode(String bicycleID) {
		if(db.hasBicycleWithID(bicycleID)) {
			db.getBicycleByID(bicycleID);
		}
	}

	@Override
	public void exitBarcode(String bicycleID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entryCharacter(char c) {
		// TODO Auto-generated method stub
		
	}
        
}
