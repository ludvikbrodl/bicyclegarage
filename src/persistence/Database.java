package persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import model.Bicycle;
import model.User;

/**
 * The database is the place where users and bicycles are stored.
 * 
 * @author dat12kbr
 */

public class Database implements Serializable{

	private static int BicycleID = 10000;
	private final int MAX_USERS = 20000;
	private Map<String, User> users;
	private Map<String, Bicycle> bicycles;

	/**
	 * Creates a new empty database.
	 */
	public Database() {
		bicycles = new HashMap<String, Bicycle>();
		users = new HashMap<String, User>();
	}

	/**
	 * Tests if the database contains a bicycle with the specified id.
	 * 
	 * @param bicycleID the id to search for
	 * @return true if the database contains a bicycle with id bicycleID
	 */
	public boolean hasBicycleWithID(String bicycleID) {
		if (bicycles.containsKey(bicycleID)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Fetches the bicycle corresponding to the specified id
	 * 
	 * @param bicycleID the id of the bicycle to fetch 
	 * @return Bicycle corresponding to bicycleID, or null if no bicycle was found
	 */
	public Bicycle getBicycleByID(String bicycleID) {
		return bicycles.get(bicycleID);
	}

	/**
	 * Creates a new bicycle, adds it to the database and to the specified user.
	 * 
	 * @param usr the user that the new bicycle should be associated with
	 * @return the newly created bicycle
	 */
	public Bicycle newBicycle(User usr) {
		String nbr = Integer.toString(BicycleID);
		Bicycle toAdd = new Bicycle(nbr);
		usr.addBicycle(toAdd);
		bicycles.put(nbr, toAdd);
		BicycleID++;
		return toAdd;
	}
	/**
	 * Removes the specified bicycle from the database.
	 * CAUTION: this method does not dissociate the removed bicycle from its user,
	 * it merely prevents the bicycle's id from being found when querying the database.
	 * 
	 * @param bicycle the bicycle to be removed from the database
	 */
	public void removeBicycle(Bicycle bicycle) {
		bicycles.remove(bicycle.getID());
	}

	public boolean hasUserWithPin(String pincode) {
		if (users.containsKey(pincode)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Fetches the user with the specified name.
	 * 
	 * @param name the name of the user
	 * @return User with the specified name, null if it is not found
	 * 
	 */
	public User getUserByName(String name) {
		Iterator<User> itr = users.values().iterator();
		while (itr.hasNext()) {
			User temp = (User) itr.next();
			if (temp.getName().equals(name)) {
				return temp;
			}
		}
		return null;
	}
	/**
	 * Changes the pincode of the user associated with the old pincode
	 * to the new pincode.
	 * Notice that this method should be used instead of calling
	 * user.setPincode() direcly, as this will corrupt the data in the database.
	 * 
	 * @param newPincode the new pincode
	 * @param oldPincode the old pincode
	 */
	public void updateUserPincode(String newPincode, String oldPincode) {
		if (users.containsKey(oldPincode) && !newPincode.equals(oldPincode)) {
			User user = users.remove(oldPincode);
			user.setPincode(newPincode);
			try {
				addUser(user);
			} catch (UserLimitException e) {
				e.printStackTrace();
			}
		}
		else{
			JOptionPane
			.showMessageDialog(null,
					"No such pincode exists");
		}
	}
	
	/**
	 * Adds the specified user to the database.
	 * 
	 * @param user the user to be added
	 * @throws UserLimitException if the maximum limit of users in the database is reached
	 */
	public void addUser(User user) throws UserLimitException{
		if (getNumberOfUsers() < MAX_USERS) {
			users.put(user.getPincode(), user);
		} else {
			throw new UserLimitException();
		}
	}
	/**
	 * Removes the specified user from the database. 
	 * Notice that it does not
	 * dissociate the bicycles associated with the user from the database.
	 * 
	 * @param user the user to be removed
	 */
	public void removeUser(User user) {
		users.remove(user.getPincode());
	}
	/**
	 * Fetches the number of bicycles stored in the database.
	 * @return the number of bicycles in the database 
	 */
	public int getNumberOfBicycles() {
		return bicycles.size();
	}

	/**
	 * Fetches the number of users stored in the database.
	 * @return the number of bicycles in the database 
	 */
	public int getNumberOfUsers() {
		return users.size();
	}
	/**
	 * Writes the contents of the database to the harddrive.
	 */
	public void saveToFile() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("UserList"));
			out.writeObject(users);
		} catch (Exception E) {
			E.printStackTrace();
		}

		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("BicycleList"));
			out.writeObject(bicycles);
		} catch (Exception E) {
			E.printStackTrace();
		}
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("BicycleID's"));
			out.writeObject(BicycleID);
		} catch (Exception E) {
			E.printStackTrace();
		}
	}

	/**
	 * Retrieves the contents of the database from the harddrive.
	 */
	public void readFromFile() {

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					"UserList"));
			users = (HashMap<String, User>) in.readObject();
		} catch (Exception e) {
			users = new HashMap<String, User>();
		}

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					"BicycleList"));
			bicycles = (HashMap<String, Bicycle>) in.readObject();
		} catch (Exception e) {
			users = new HashMap<String, User>();
		}
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					"BicycleID's"));
			BicycleID = (Integer)in.readObject();
		} catch (Exception e) {
			BicycleID = 10000;
		}

	}

}
