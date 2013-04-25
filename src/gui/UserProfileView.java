package gui;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class UserProfileView extends JPanel {
	
	public UserProfileView() {
		super();
		JPanel namePanel = new JPanel();
		JPanel adressPanel = new JPanel();
		JPanel birthdatePanel = new JPanel();
		JPanel pincodePanel = new JPanel();
		
		//Name Panel
		JTextField nameTextField = new JTextField(30);
		JTextArea nameTextArea = new JTextArea("Name");
		nameTextArea.setEditable(false);
		namePanel.add(nameTextArea);
		namePanel.add(nameTextField);
		
		//Adress Panel
		JTextArea adressTextArea = new JTextArea(3,30);
		JTextArea adressTextArea2 = new JTextArea("Adress");
		adressTextArea2.setEditable(false);
		adressPanel.add(adressTextArea2);
		adressPanel.add(adressTextArea);
		
		//Birthdate Panel
		JTextField birthdateTextField = new JTextField(30);
		JLabel birthdateTextArea = new JLabel("Birthdate");
//		birthdateTextArea.setEditable(false);
		birthdatePanel.add(birthdateTextArea);
		birthdatePanel.add(birthdateTextField);
		
		//Pincode Panel
		JTextField pincodeTextField = new JTextField(10);
		JTextArea pincodeTextArea = new JTextArea("Pin Code");
		pincodeTextArea.setEditable(false);
		pincodePanel.add(pincodeTextArea);
		pincodePanel.add(pincodeTextField);
		
		JButton addBicycle = new JButton("Add Bicycle");
		JButton removeUser = new JButton("Remove User");
		JButton save = new JButton("Save");
		JButton cancel = new JButton("Cancel");
		add(namePanel);
		add(adressPanel);
		add(birthdatePanel);
		add(pincodePanel);
		add(addBicycle);
		add(removeUser);
		add(save);
		add(cancel);
	}
}
