package persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import model.Bicycle;
import model.User;

/**
 * Main-method used to start the application.
 * 
 * @param args
 */

public class Database {

	private static int BicycleID = 10000;
	private final int MAX_USERS = 20000;
	private Map<String, User> users;
	private Map<String, Bicycle> bicycles;

	public Database() {
		bicycles = new HashMap<String, Bicycle>();
		users = new HashMap<String, User>();
	}

	public boolean hasBicycleWithID(String bicycleID) {
		if (users.containsKey(bicycleID)) {
			return true;
		}
		return false;
	}

	public Bicycle getBicycleByID(String bicycleID) {
		return bicycles.get(bicycleID);
	}

	public Bicycle newBicycle(User usr) {
		String nbr = Integer.toString(BicycleID);
		Bicycle toAdd = new Bicycle(nbr);
		usr.addBicycle(toAdd);
		bicycles.put(nbr, toAdd);
		BicycleID++;
		return toAdd;
	}

	public void removeBicycle(Bicycle bicycle) {
		bicycles.remove(bicycle.getID());
	}

	public boolean hasUserWithPin(String pincode) {
		if (users.containsKey(pincode)) {
			return true;
		}
		return false;
	}

	public User getUserByName(String name) {
		Iterator itr = users.entrySet().iterator();
		while (itr.hasNext()) {
			User temp = (User) itr.next();
			if (temp.getName().equals(name)) {
				return temp;
			}
		}
		return null;
	}

	public void updateUserPincode(String newPincode, String oldPincode) {
		User temp = users.get(oldPincode);
		if (temp != null) {
			temp.setPincode(newPincode);
		}
	}

	public void addUser(User user) {
		if (getNumberOfUsers() >= MAX_USERS) {
			JOptionPane
					.showMessageDialog(null,
							"Max amount of users has been registerd. Contact administration.");
		} else {
			users.put(user.getName(), user);
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
	}

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

	}

}
