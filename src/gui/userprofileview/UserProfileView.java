package gui.userprofileview;

import gui.bicycleview.BicycleView;

import java.awt.GridLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.BarcodePrinter;
import model.Bicycle;
import model.BicycleGarageManager;
import model.User;

import persistence.Database;
import persistence.Statistics;
import persistence.UserLimitException;

/**
 * @author bas11lbr
 *
 */
@SuppressWarnings("serial")
public class UserProfileView extends JPanel {
	private Random random = new Random();
	private JTabbedPane tabbedPane;
	private JTextField nameTextField;
	private JTextArea adressTextArea;
	private JTextField birthdateTextField;
	private JTextField pincodeTextField;
	private Database db;
	private BarcodePrinter printer;
	private User user;
	private Statistics statistics;
	public UserProfileView(JTabbedPane tabbedPane, String name, Database db,
			BarcodePrinter printer, Statistics statistics) {
		super();
		setLayout(new GridLayout(10, 0));
		this.tabbedPane = tabbedPane;
		this.printer = printer;
		this.db = db;
		this.statistics = statistics;
		user = db.getUserByName(name);
		String address = "";
		String birthdate = "";
		String pincode = "";
		JPanel bicycleButtons = new JPanel();

		if (user != null) {
			address = user.getAddress();
			birthdate = user.getBirthDate();
			pincode = user.getPincode();

			// List of bicycles
			for (String s : user.getBicycleIDs()) {
				bicycleButtons.add(new JButtonBicycle(this, db
						.getBicycleByID(s)));
			}
		} else {
			pincode = getNewRandomPincode();
			while(db.hasUserWithPin(pincode)) {
				pincode = getNewRandomPincode();
			}
			user = new User(pincode,"", "", "");
			try {
				db.addUser(user);
			} catch (UserLimitException e) {
				JOptionPane.showMessageDialog(null, 
						"Maximum user limit reached\n" +
						" please contact the system owners for further instructions");
			}
		}
		// Name Panel
		JPanel namePanel = new JPanel();
		nameTextField = new JTextField(name, 30);
		JLabel nameLabel = new JLabel("Name");
		namePanel.add(nameLabel);
		namePanel.add(nameTextField);

		// Adress Panel
		JPanel adressPanel = new JPanel();
		adressTextArea = new JTextArea(address, 3, 30);
		JLabel adressLabel = new JLabel("Adress");
		adressPanel.add(adressLabel);
		adressPanel.add(adressTextArea);

		// Birthdate Panel
		JPanel birthdatePanel = new JPanel();
		birthdateTextField = new JTextField(birthdate, 30);
		JLabel birthdateLabel = new JLabel("Birthdate");
		birthdatePanel.add(birthdateLabel);
		birthdatePanel.add(birthdateTextField);

		// Pincode Panel
		JPanel pincodePanel = new JPanel();
		pincodeTextField = new JTextField(pincode, 10);
		pincodeTextField.setEditable(false);
		JLabel pincodeLabel = new JLabel("Pin Code");
		pincodePanel.add(pincodeLabel);
		pincodePanel.add(pincodeTextField);

		// Button Panel
		JPanel buttons = new JPanel();
		JButtonAddBicycle addBicycle = new JButtonAddBicycle(this);
		JButtonRemoveUser removeUser = new JButtonRemoveUser(this);
		JButtonSave save = new JButtonSave(this);
		JButtonCancel cancel = new JButtonCancel(this);
		buttons.add(addBicycle);
		buttons.add(removeUser);
		buttons.add(save);
		buttons.add(cancel);

		add(namePanel);
		add(adressPanel);
		add(birthdatePanel);
		add(pincodePanel);
		add(bicycleButtons);
		add(buttons);
	}

	public void removeMe() {
		tabbedPane.remove(this);
	}
	
	public void removeUser() {
		Iterator<String> itr = user.getBicycleIDs().iterator();
		boolean anythingInGarage = false;
		while(itr.hasNext()&&!anythingInGarage) {
			Bicycle bicycle = db.getBicycleByID(itr.next());
			anythingInGarage = bicycle.isInGarage();
		}
		if(anythingInGarage) {
			JOptionPane.showMessageDialog(null, "please remove all bicycles from the garage and try again");
		} else {
		db.removeUser(user);
		itr = user.getBicycleIDs().iterator();
		while(itr.hasNext()) {
			Bicycle bicycle = db.getBicycleByID(itr.next());
			db.removeBicycle(bicycle);
		}	
		removeMe();
		}
	}
	
	private String getNewRandomPincode() {
		int randomInt = random.nextInt((int)Math.pow(10, BicycleGarageManager.PINCODE_SIZE));
		String pincode = codify(randomInt);
		return pincode;
	}
	private String codify(int i) {
		StringBuilder s = new StringBuilder(Integer.toString(i));
		while (s.length() < 6) {
			s.append("0");
		}
		return s.toString();
	}
	
	public void saveUserToDatabase() {
		String adress = adressTextArea.getText();
		String birthDate = birthdateTextField.getText();
		String name = nameTextField.getText();
		if(name.equals("")) {
			JOptionPane.showMessageDialog(null, "please enter a name");
			return;
		}
		if (!adress.equals(user.getAddress())) {
			user.setAddress(adress);
		}
		if (!birthDate.equals(user.getBirthDate())) {
			user.setBirthDate(birthDate);
		}
		if (!name.equals(user.getName())) {
			user.setName(name);
		}
		removeMe();
	}
	
	public void setFocusToNewTab() {
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
	}

	/**
	 * @param bicycleID
	 */
	public void createBicycleView(String bicycleID) {
		tabbedPane.addTab("#"+bicycleID,new BicycleView(user, bicycleID, db, printer, tabbedPane, statistics));
		setFocusToNewTab();
	}

	public void createNewBicycleView() {
		Bicycle bicycle = db.newBicycle(user);
		tabbedPane.addTab("#"+bicycle.getID(), new BicycleView(user, bicycle.getID(), db, printer, tabbedPane, statistics));
		setFocusToNewTab();
	}
}
