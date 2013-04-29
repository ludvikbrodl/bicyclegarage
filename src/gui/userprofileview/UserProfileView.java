package gui.userprofileview;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Address;
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
	private BarcodePrinter printer;
	public UserProfileView(JTabbedPane tabbedPane, String name, Database db, BarcodePrinter printer) {
		super();
		setLayout(new GridLayout(10, 0));
		this.tabbedPane = tabbedPane;
		this.printer = printer;
		User user = db.getUserByName(name);
		String adress = "";
		String birthdate = "";
		String pincode = "";
		if (user != null) {
			Address address = user.getAddress();
			adress = address.getStreetName() + address.getStreetNumber() + address.getZipcode() + address.getCityName() ;
		}
		// Name Panel
		JPanel namePanel = new JPanel();
		nameTextField = new JTextField(30);
		JLabel nameLabel = new JLabel("Name");
		namePanel.add(nameLabel);
		namePanel.add(nameTextField);

		// Adress Panel
		JPanel adressPanel = new JPanel();
		adressTextArea = new JTextArea(3, 30);
		JLabel adressLabel = new JLabel("Adress");
		adressPanel.add(adressLabel);
		adressPanel.add(adressTextArea);

		// Birthdate Panel
		JPanel birthdatePanel = new JPanel();
		birthdateTextField = new JTextField(30);
		JLabel birthdateLabel = new JLabel("Birthdate");
		birthdatePanel.add(birthdateLabel);
		birthdatePanel.add(birthdateTextField);

		// Pincode Panel
		JPanel pincodePanel = new JPanel();
		pincodeTextField = new JTextField(10);
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
		add(buttons);
	}
	
	public void removeMe() {
		tabbedPane.remove(this);
	}
	
}
