package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * User describes a user of the bicycle garage.
 * 
 * @author bas12kbr
*/
public class User implements Serializable {  
	
	private String pincode;
	private String name;
	private String birthDate;
	private String address;
	private List<Bicycle> bicycleList;
	private final int MAX_BICYCLES = 5;
		/**
		 * Creates a new user.
		 * @param pincode the user's pincode
		 * @param name the user's name
		 * @param birthDate the user's date of birth
		 * @param address the user's address
		 */
        public User(String pincode, String name, String birthDate, String address) {
        	this. pincode = pincode;
        	this.name = name;
        	this.birthDate = birthDate;
        	this.address = address;
        	bicycleList = new ArrayList<Bicycle>();
		}
        /**
         * Associates the specified Bicycle with the user.
         * @param bicycle the bicycle to be added 
         */
        public void addBicycle(Bicycle bicycle) {
        	if(bicycleList.size()>=5){
        		JOptionPane.showMessageDialog(null, "Max amount of bicycles has been registerd.");
        	}
        	else{
        	bicycleList.add(bicycle);
        	}
		}
        /**
         * Removes the association between the specified bicycle and the user.
         * 
         * @param bicycle the bicycle to be removed
         */
        public void removeBicycle(Bicycle bicycle) {
        	if(bicycleList.indexOf(bicycle)!= -1){
        	bicycleList.remove(bicycleList.indexOf(bicycle));
        	}
		}
        /**
         * Fetches a list of all the bicycles that the user is associated with
         * @return list of bicycles, can be empty
         */
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
        /**
         * Fetches the user's pincode 
         * @return pincode of the user
         */
        public String getPincode() {
			return pincode;
		}
        
        /**
         * Sets the user's pincode to the specified string.
         * Notice that this method should not be called directly,
         * use updateUserPincode in Database instead.
         * 
         * @param pincode the pincode to be set 
         */
        public void setPincode(String pincode) {
        	this.pincode = pincode;
   
		}
        
        /**
         * Fetches the user's name 
         * @return name of the user
         */
        public String getName() {
        	
			return name;
		}
        
        /**
         * Sets the user's name 
         * @param name the name to be set
         */
        public void setName(String name) {
        	this.name = name;
        	
		}
        
        /**
         * Fetches the user's address.
         * @return address of the user
         */
        public String getAddress() {
        	
			return address;
		}
        
        /**
         * Sets the user's address.
         * @param address to be set 
         */
        public void setAddress(String address) {
        	this.address = address;
		}
        
        /**
         * Fetches the user's birth date.
         * @return birth date of the user
         */
        public String getBirthDate() {
			return birthDate;
		}
        
        /**
         * Sets the user's birth date.
         * @param birthdate date to be set
         */
        public void setBirthDate(String birthDate) {
        	this.birthDate = birthDate;
		}
}
