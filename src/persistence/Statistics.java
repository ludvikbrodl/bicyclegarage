package persistence;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.L2D;

public class Statistics {
	
	private Date date;
	private List<Integer> bicyclesPerMonth;
	private int bicyclesInGarage;
	private int entriesThisMonth;
	private Database DB;
	private int lastMonth;
	
	public Statistics() {
		date = new Date();
		bicyclesPerMonth = new ArrayList<Integer>();
		DB = new Database();
	}
	public void incrementBicyclesInGarage(){
		bicyclesInGarage++;
	}
	
    public void incrementNumberOfBicyclesThisMonth() {
    	if(date.getMonth() == 0 && lastMonth ==11){
    		lastMonth = 0;
    		bicyclesPerMonth.add(entriesThisMonth);
    		entriesThisMonth = 0;
    	}else if (date.getMonth() > lastMonth){
    		lastMonth = date.getMonth();
    		bicyclesPerMonth.add(entriesThisMonth);
    		entriesThisMonth = 0;
    	}
 
    	
    	entriesThisMonth ++;
    	
	}
    public List<Integer> getNumberOfEntriesPerMonth() {
		return bicyclesPerMonth;
	}
    public int getNumberOfBicycles() {
    	return DB.getNumberOfBicycles();
	}
    public int getNumberOfUsers() {
		return DB.getNumberOfUsers();
	}
    public int getBicycleInGarage(){
    	return bicyclesInGarage;
    }
}
