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
	private Map<String, Bicycle> bicycles;
        public Database() {
        	bicycles = new ConcurrentHashMap<String, Bicycle>();
		}
        public boolean hasBicycleWithID(String bicycleID) {
			return false;
		}
        public Bicycle getBicycleByID(String bicycleID) {
			return bicycles.get(bicycleID);
		}
        public void updateBicycleID(String bicycleID, Bicycle bicycle) {
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
			return 0;
		}
        
}
