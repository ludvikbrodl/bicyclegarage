package persistence;

import model.Bicycle;
import model.User;

/**
* Main-method used to start the application.
* @param args
*/

public class Database {  
        public Database() {
		}
        
        public boolean hasBicycleWithID(String bicycleID) {
			return false;
		}
        public Bicycle getBicycleByID(String bicycleID) {
			return null;
		}
        public void updateBicycleID(String bicycleID, Bicycle bicycle) {
		}
        public void addBicycle(Bicycle bicycle) {
		}
        public void removeBicycle(Bicycle bicycle) {
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
			return 0;
		}
        public int getNumberOfUsers() {
			return 0;
		}
        
}
