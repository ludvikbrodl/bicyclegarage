package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.L2D;
/**
 * Statistics is responsible for keeping track of various statistics regarding the
 * usage of the garage.
 * 
 * @author dat12ppe
 *
 */
public class Statistics {
	
	private List<Integer> bicyclesPerMonth;
	private int bicyclesInGarage;
	private int entriesThisMonth;
	private Database db;
	private int month;
	private Calendar calendar;
	/**
	 * Creates a new statistics instance.
	 * @param database the database that gets queried for information about users and
	 * bicycles
	 */
	public Statistics(Database database) {
		calendar = new GregorianCalendar();
		month = calendar.get(Calendar.MONTH);
		bicyclesPerMonth = new ArrayList<Integer>();
		db = database; 
		bicyclesInGarage = 0;
	}
	/**
	 * Increments the number of bicycles that are currently inside the garage.
	 */
	public void incrementBicyclesInGarage(){
		bicyclesInGarage++;
		incrementNumberOfBicyclesThisMonth();
	}
	
    private void incrementNumberOfBicyclesThisMonth() {
    	int currentMonth = new GregorianCalendar().get(Calendar.MONTH);
    	if( month != currentMonth){
    		month = currentMonth;
    		bicyclesPerMonth.add(entriesThisMonth);
    		entriesThisMonth = 0;
    	}
    	
    	entriesThisMonth ++;
    	
	}
    
	/**
	 * Decrements the number of bicycles that are currently inside the garage.
	 */
    public void decrementBicyclesInGarage() {
    	if(bicyclesInGarage != 0){
    	bicyclesInGarage--;
    	}
    }
    
    /**
     * Fetches a list of the number of entries in the garage, grouped by month
     * @return a list of the number of entries
     */
    public List<Integer> getNumberOfEntriesPerMonth() {
		return bicyclesPerMonth;
	}
    
    /**
     * Fetches the number of bicycles currently registered in the system.
     * @return the number of bicycles currently registered in the system
     */
    public int getNumberOfBicycles() {
    	return db.getNumberOfBicycles();
	}
    
    /**
     * Fetches the number of users currently registered in the system.
     * @return the number of users currently registered in the system
     */
    public int getNumberOfUsers() {
		return db.getNumberOfUsers();
	}
    
    /**
     * Fetches the number of bicycles currently in the garage.
     * @return the number of bicycles currently in the garage 
     */
    public int getBicyclesInGarage(){
    	return bicyclesInGarage;
    }
    
}
