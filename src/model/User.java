package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

/**
* Main-method used to start the application.
* @param args
*/
public class User implements Serializable {  
	
	private String pincode;
	private String name;
	private String birthDate;
	private String address;
	private List<Bicycle> bicycleList;
	private final int MAX_BICYCLES = 5;
	
        public User(String pincode, String name, String birthDate, String address) {
        	this. pincode = pincode;
        	this.name = name;
        	this.birthDate = birthDate;
        	this.address = address;
        	bicycleList = new ArrayList<Bicycle>();
		}
        
        public void addBicycle(Bicycle bicycle) {
        	if(bicycleList.size()>=5){
        		JOptionPane.showMessageDialog(null, "Max amount of bicycles has been registerd.");
        	}
        	else{
        	bicycleList.add(bicycle);
        	}
		}
        public void removeBicycle(Bicycle bicycle) {
        	if(bicycleList.indexOf(bicycle)!= -1){
        	bicycleList.remove(bicycleList.indexOf(bicycle));
        	}
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
