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
 * Main-method used to start the application.
 * 
 * @param args
 */

public class Database implements Serializable{

	private static int BicycleID = 10000;
	private final int MAX_USERS = 20000;
	private Map<String, User> users;
	private Map<String, Bicycle> bicycles;

	public Database() {
		bicycles = new HashMap<String, Bicycle>();
		users = new HashMap<String, User>();
	}

	public boolean hasBicycleWithID(String bicycleID) {
		if (bicycles.containsKey(bicycleID)) {
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
		Iterator<User> itr = users.values().iterator();
		while (itr.hasNext()) {
			User temp = (User) itr.next();
			if (temp.getName().equals(name)) {
				return temp;
			}
		}
		return null;
	}

	public void updateUserPincode(String newPincode, String oldPincode) {
		if (users.containsKey(oldPincode) && !newPincode.equals(oldPincode)) {
			User user = users.remove(oldPincode);
			user.setPincode(newPincode);
			addUser(user);
		}
		else{
			JOptionPane
			.showMessageDialog(null,
					"No such pincode exists");
		}
	}

	public void addUser(User user) {
		if (getNumberOfUsers() >= MAX_USERS) {
			JOptionPane
					.showMessageDialog(null,
							"Max amount of users has been registerd. Contact administration.");
		} else {
			users.put(user.getPincode(), user);
		}
	}

	public void removeUser(User user) {
		users.remove(user.getPincode());
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
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("BicycleID's"));
			out.writeObject(BicycleID);
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
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					"BicycleID's"));
			BicycleID = (Integer)in.readObject();
		} catch (Exception e) {
			BicycleID = 10000;
		}

	}

}
