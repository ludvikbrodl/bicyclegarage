package persistence;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JOptionPane;

import model.Bicycle;
import model.User;

/**
* Main-method used to start the application.
* @param args
*/

public class Database {  
	
	private final int MAX_USERS = 20000;
	private Map<String, User> users;
	private Map<String, Bicycle> bicycles;
	private static int BicycleID = 10000;
	
	
        public Database() {
        	bicycles = new HashMap<String, Bicycle>();
        	users = new HashMap<String, User>();
		}
        
        public boolean hasBicycleWithID(String bicycleID) {
        	if(users.containsKey(bicycleID)){
        		return true;
        	}
			return false;
		}
        
        public Bicycle getBicycleByID(String bicycleID) {
			return bicycles.get(bicycleID);
		}
        
        
        public Bicycle addBicycle(User usr) {
        	String nbr = Integer.toString(BicycleID);
        	Bicycle toAdd = new Bicycle(nbr);
        	usr.addBicycle(toAdd);
        	bicycles.put(nbr, toAdd);
        	BicycleID++;
        	
        	//bind user till cyckel, adda cyckel till map.
        	return toAdd;
		}
        public void removeBicycle(Bicycle bicycle) {
        	bicycles.remove(bicycle.getID());
		}
        
        public boolean hasUserWithPin(String pincode) {
			return false;
		}
        
        public User getUserByName(String name) {
        	return null;
		}
        
        public void updateUserPincode(String newPincode, String oldPincode) {
        	User temp = users.get(oldPincode);
        	temp.setPincode(newPincode);
        }
        
        public void addUser(User user) {
        	if(getNumberOfUsers() >= MAX_USERS){
        		JOptionPane.showMessageDialog(null, "Max amount of users has been registerd. Contact administration.");
        	}
        	else{
        		users.put(user.getName(),user);
        	}
		}
        
        public void removeUser(User user) {
        	users.remove(user.getName());
		}
        
        public int getNumberOfBicycles() {
			return bicycles.size();
		}
        
        public int getNumberOfUsers() {
			return users.size();
		}
        
      
        
        
}
