package persistence;

import model.Bicycle;
import model.User;

/**
* Main-method used to start the application.
* @param args
*/

class Database {  
        public Database();
        
        public boolean hasBicycleWithID(String bicycleID);
        public Bicycle getBicycleByID(String bicycleID);
        public void updateBicycleID(String bicycleID, Bicycle bicycle);
        public void addBicycle(Bicycle bicycle);
        public void removeBicycle(Bicycle bicycle);
        public boolean hasUserWithPin(String pincode);
        public User getUserByName(String name);
        public void addUser(User user);
        public void removeUser(User user);
        public int getNumberOfBicycles();
        public int getNumberOfUsers();
        
}
