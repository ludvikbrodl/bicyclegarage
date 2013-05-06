package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
* Main-method used to start the application.
* @param args
*/
public class User {  
	
	private String pincode;
	private String name;
	private String birthDate;
	private String address;
	private List<Bicycle> bicycleList;
	
        public User(String pincode, String name, String birthDate, String address) {
        	this. pincode = pincode;
        	this.name = name;
        	this.birthDate = birthDate;
        	this.address = address;
        	bicycleList = new ArrayList<Bicycle>();
		}
        
        public void addBicycle(Bicycle bicycle) {
        	bicycleList.add(bicycle);
		}
        public void removeBicycle(Bicycle bicycle) {
        	bicycleList.remove(bicycleList.indexOf(bicycle));
		}
        
        public List<String> getBicycleIDs() {
        	List<String> tempList = new ArrayList<String>();
        	Iterator<Bicycle> itr = bicycleList.iterator();
        	Bicycle temp;
        	
        	while(itr.hasNext()){
        		temp = (Bicycle) itr.next();
        		tempList.add(temp.getID());
        	}
			return tempList;
		}
        
        public String getPincode() {
			return pincode;
		}
        public void setPincode(String pincode) {
        	this.pincode = pincode;
   
		}
        public String getName() {
        	
			return name;
		}
        public void setName(String name) {
        	this.name = name;
        	
		}
        public String getAddress() {
        	
			return address;
		}
        
        public void setAddress(String address) {
        	this.address = address;
		}
        public String getBirthDate() {
        	
			return birthDate;
		}
        public void setBirthDate(String birthDate) {
        	this.birthDate = birthDate;
		}
}
