package model;
/**
* Main-method used to start the application.
* @param args
*/
public class Bicycle {  
	
	private String bicycleID;
	private boolean inGarage;
	
    public Bicycle(String bicycleID) {
    	this.bicycleID = bicycleID;
    	inGarage = false;
	}
    
    public boolean isInGarage() {
		return inGarage;
	}
    
    public void setInGarage(boolean status) {
    	inGarage = status;
	}
    
    public String getID() {
		return bicycleID;
	}
    
 
    
    public boolean equals(Bicycle bicycle){
    	if(bicycle.getID().equals(bicycleID)){
    		return true;
    	}
    	else{return false;}
    }
}
