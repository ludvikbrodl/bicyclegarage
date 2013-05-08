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
import persistence.UserLimitException;

/**
 * @author bas11lbr
 *
 */
@SuppressWarnings("serial")
public class UserProfileView extends JPanel {
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
			if (!adress.equals(user.getAddress())) {
				user.setAddress(adress);
			}
			if (!birthDate.equals(user.getBirthDate())) {
				user.setBirthDate(birthDate);
			}
			if (!name.equals(user.getName())) {
				user.setName(name);
			}
			if (!newPincode.equals(user.getPincode())) {
				if(user.getPincode().equals("")) {
					user.setPincode(newPincode);
					try {
						db.addUser(user);
					} catch (UserLimitException e) {
						JOptionPane.showMessageDialog(null, 
								"Maximum user limit reached\n" +
								" please contact the system owners for further instructions");
					}
				} else {
					db.updateUserPincode(newPincode, user.getPincode());
				}
			}
			removeMe();
		}

	}
	
	public void setFocusToNewTab() {
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
	}

	/**
	 * @param bicycleID
	 */
	public void createBicycleView(String bicycleID) {
		tabbedPane.addTab("#"+bicycleID,new BicycleView(user, bicycleID, db, printer, tabbedPane));
		setFocusToNewTab();
	}

	public void createNewBicycleView() {
		Bicycle bicycle = db.newBicycle(user);
		tabbedPane.addTab("#"+bicycle.getID(), new BicycleView(user, bicycle.getID(), db, printer, tabbedPane));
		setFocusToNewTab();
	}
}
