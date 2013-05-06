package persistence;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
	private int nbrUsers;
	
	
        public Database() {
        	bicycles = new ConcurrentHashMap<String, Bicycle>();
        	users = new ConcurrentHashMap<String, User>();
        	nbrUsers = 0;
		}
        
        public boolean hasBicycleWithID(String bicycleID) {
			return false;
		}
        
        public Bicycle getBicycleByID(String bicycleID) {
			return bicycles.get(bicycleID);
		}
        
        public void updateBicycleID(String newBicycleID, String oldBicycleID) {
		}
        
        public void addBicycle(Bicycle bicycle) {
        	bicycles.put(bicycle.getID(), bicycle);
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
        
        public void updateUserPincode() {
        }
        
        public void addUser(User user) {
		}
        
        public void removeUser(User user) {
		}
        
        public int getNumberOfBicycles() {
			return bicycles.size();
		}
        
        public int getNumberOfUsers() {
			return nbrUsers;
		}
        
        
}
