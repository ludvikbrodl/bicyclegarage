package model;

import java.util.Date;

import persistence.Database;
import persistence.Statistics;

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
	private Statistics statistics;
	private final int MAX_BICYCLES_IN_GARAGE  = 2000;
	private final int TIMEOUT = 15000;
	private final char CLEAR_ALL = '*';
	private final int OPEN_DOOR_TIME = 10;
    public LundBicycleGarageManager(Database db, Statistics statistics) {
    	this.db = db;
    	this.statistics = statistics;
    	pincode = new StringBuilder();
    	lastCharacterEntryTime = new Date();
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
			if(statistics.getBicycleInGarage() < MAX_BICYCLES_IN_GARAGE) {
				Bicycle bicycle = db.getBicycleByID(bicycleID);
				entryLock.open(OPEN_DOOR_TIME);
				bicycle.setInGarage(true);
				statistics.incrementBicyclesInGarage();
				
			} else {
				terminal.lightLED(PinCodeTerminal.RED_LED, 3);
				terminal.lightLED(PinCodeTerminal.GREEN_LED, 3);
			}
		} else {
			terminal.lightLED(PinCodeTerminal.RED_LED, 3);
		}
	}

	@Override
	public void exitBarcode(String bicycleID) {
		if(db.hasBicycleWithID(bicycleID)) {
			Bicycle bicycle = db.getBicycleByID(bicycleID);
			exitLock.open(OPEN_DOOR_TIME);
			bicycle.setInGarage(false);
			statistics.decrementBicyclesInGarage();
		} else {
			terminal.lightLED(PinCodeTerminal.RED_LED, 3);
		}
	}

	@Override
	public void entryCharacter(char c) {
		Date currentTime = new Date();
		if(c == CLEAR_ALL) {
			pincode = new StringBuilder();
		} else if(currentTime.getTime()-lastCharacterEntryTime.getTime() > TIMEOUT) {
			pincode = new StringBuilder(c);
		} else {
			pincode.append(c);
			if(pincode.length() == PINCODE_SIZE) {
				String pincodeStr = pincode.toString();
				if(db.hasUserWithPin(pincodeStr)) {
					entryLock.open(OPEN_DOOR_TIME);
				} else {
					terminal.lightLED(PinCodeTerminal.RED_LED, 3);
				}
			}
		}
		lastCharacterEntryTime = currentTime;
	}
        
}
