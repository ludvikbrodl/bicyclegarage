package gui.userprofileview;

import gui.bicycleview.BicycleView;

import java.awt.GridLayout;

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
	private User user;

	public UserProfileView(JTabbedPane tabbedPane, String name, Database db,
			BarcodePrinter printer) {
		super();
		setLayout(new GridLayout(10, 0));
		this.tabbedPane = tabbedPane;
		this.printer = printer;
		this.db = db;
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
			user = new User("", "", "", "");
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

	public void saveUserToDatabase() {
		String newPincode = pincodeTextField.getText();
		if (newPincode.length() != BicycleGarageManager.PINCODE_SIZE
				|| !newPincode.matches("[0-9]+")) {
			JOptionPane.showMessageDialog(null,
					"Pincode must be 6 digits long and contain only integers");
		} else {
			String adress = adressTextArea.getText();
			String birthDate = birthdateTextField.getText();
			String name = nameTextField.getText();
			if (adress != user.getAddress()) {
				user.setAddress(adress);
			}
			if (birthDate != user.getBirthDate()) {
				user.setBirthDate(birthDate);
			}
			if (name != user.getName()) {
				user.setName(name);
			}
			if (newPincode != user.getPincode()) {
				user.setPincode(newPincode);
				db.updateUserPincode(user.getPincode(), newPincode);
			}
			db.addUser(user);
			removeMe();
		}

	}

	public void createBicycleView(String bicycleID) {
		tabbedPane.add(new BicycleView(bicycleID, db, printer));
	}

	public void createNewBicycleView() {
		Bicycle bicycle = db.newBicycle(user);
		tabbedPane.add(new BicycleView(bicycle.getID(), db, printer));
	}
}
