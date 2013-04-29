package persistence;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.L2D;

public class Statistics {
	
	private Date currentMonth;
	private List<Integer> bicyclesPerMonth;
	private int bicyclesInGarage;
	private int entriesThisMonth;
	
	public Statistics() {
		currentMonth = new Date();
		bicyclesPerMonth = new ArrayList<Integer>();
	}
    public void incrementNumberOfBicyclesInGarage();
    public List<Integer> getNumberOfEntriesPerMonth();
    public int getNumberOfBicycles();
    public int getNumberOfUsers();
}
