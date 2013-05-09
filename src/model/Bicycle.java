package model;

import java.io.Serializable;

/**
 * Bicycle describes a bicycle that interacts with the system.
*/
public class Bicycle implements Serializable {
	
	private String bicycleID;
	private boolean inGarage;
	
	/**
	 * Creates a new bicycle with the specified id. This id is used to authenticate
	 * the bicycle at the entrance of the garage.
	 * @param bicycleID the id of the bicycle
	 */
    public Bicycle(String bicycleID) {
    	this.bicycleID = bicycleID;
    	inGarage = false;
	}
    
    /**
     * Tests if the bicycle is in the garage. 
     * @return true if the bicycle is in the garage, false otherwise
     */
    public boolean isInGarage() {
		return inGarage;
	}
    
    /**
     * Sets the bicycle's status as inside or outside the garage.
     * @param status true if the bicycle is in the garage, false otherwise
     */
    public void setInGarage(boolean status) {
    	inGarage = status;
	}
    
    /**
     * Fetches the bicycle's id
     * @return the id of the bicycle
     */
    public String getID() {
		return bicycleID;
	}
 
    /**
     * Compares the bicycle with another bicycle. If they have the same id
     * they are considered equal.
     * @param bicycle the bicycled to be compared
     * @return true if they are equal, false otherwise
     */
    public boolean equals(Bicycle bicycle){
    	if(bicycle.getID().equals(bicycleID)){
    		return true;
    	}
    	else{return false;}
    }
}
