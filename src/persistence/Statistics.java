package persistence;

import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.L2D;

public class Statistics {
	
	private List<Integer> bicyclesPerMonth;
	private int bicyclesInGarage;
	private int entriesThisMonth;
	private Database db;
	private int month;
	private Calendar calendar;
	public Statistics(Database database) {
		calendar = new GregorianCalendar();
		month = calendar.get(Calendar.MONTH);
		bicyclesPerMonth = new ArrayList<Integer>();
		db = database; 
	}
	public void incrementBicyclesInGarage(){
		bicyclesInGarage++;
		incrementNumberOfBicyclesThisMonth();
	}
	
    private void incrementNumberOfBicyclesThisMonth() {
    	int currentMonth = calendar.get(Calendar.MONTH);
    	if( month != currentMonth){
    		month = currentMonth;
    		bicyclesPerMonth.add(entriesThisMonth);
    		entriesThisMonth = 0;
    	}
    	
    	entriesThisMonth ++;
    	
	}
    public void decrementBicyclesInGarage() {
    	bicyclesInGarage--;
    }
    public List<Integer> getNumberOfEntriesPerMonth() {
		return bicyclesPerMonth;
	}
    public int getNumberOfBicycles() {
    	return db.getNumberOfBicycles();
	}
    public int getNumberOfUsers() {
		return db.getNumberOfUsers();
	}
    public int getBicycleInGarage(){
    	return bicyclesInGarage;
    }
}
