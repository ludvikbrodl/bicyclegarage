package gui.userprofileview;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.BarcodePrinter;
import model.User;

import persistence.Database;

@SuppressWarnings("serial")
public class UserProfileView extends JPanel {
	public static final String NAME = "User Profile View";
	private JTabbedPane tabbedPane;
	private JTextField nameTextField;
	private JTextArea adressTextArea;
	private JTextField birthdateTextField;
	private JTextField pincodeTextField;
	private Database db;
	private BarcodePrinter printer;
	private String username;

	public UserProfileView(JTabbedPane tabbedPane, String name, Database db,
			BarcodePrinter printer) {
		super();
		setLayout(new GridLayout(10, 0));
		this.tabbedPane = tabbedPane;
		this.printer = printer;
		this.db = db;
		this.username = name;
		User user = db.getUserByName(name);
		String address = "";
		String birthdate = "";
		String pincode = "";
		if (user != null) {
			 address = user.getAddress();
			birthdate = user.getBirthDate();
			pincode = user.getPincode();
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
		JLabel pincodeLabel = new JLabel("Pin Code");
		pincodePanel.add(pincodeLabel);
		pincodePanel.add(pincodeTextField);

		// List of bicycles
		
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
		add(buttons);
	}

	public void removeMe() {
		tabbedPane.remove(this);
	}
	
	public void saveUserToDatabase() {
		User user = db.getUserByName(username);
		user.setAddress(adressTextArea.toString());
		user.setBirthDate(birthdateTextField.toString());
		user.setName(nameTextField.toString());
		String newPincode = pincodeTextField.toString();
		user.setPincode(newPincode)
		db.updateUserPincode(user.getPincode(), newPincode);
		
		
		//write values of all input fields to corresponding attributes in User
		//if new pincode != old pincode, call updateUserPincode() in db
		
		removeMe();
	}

}
