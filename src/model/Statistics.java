package model;

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
}
