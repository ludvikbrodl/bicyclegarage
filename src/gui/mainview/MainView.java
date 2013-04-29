package gui.mainview;

import gui.bicycleview.BicycleView;
import gui.statisticsview.StatisticsView;
import gui.userprofileview.JButtonAddBicycle;
import gui.userprofileview.JButtonCancel;
import gui.userprofileview.JButtonRemoveUser;
import gui.userprofileview.JButtonSave;
import gui.userprofileview.UserProfileView;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import persistence.Database;

import model.Bicycle;

public class MainView extends JPanel {

	public static final String NAME = "Main View";
	private JTabbedPane tabbedPane;
	private Database db;
	private JTextField nameTextField;

	public MainView(JTabbedPane tabbedPane, Database db) {
		super();
		this.tabbedPane = tabbedPane;
		this.db = db;

		setLayout(new GridLayout(10, 0));

		// NameSearch Panel
		JPanel nameSearchPanel = new JPanel();
		nameTextField = new JTextField(30);
		JLabel nameLabel = new JLabel("Name to search for: ");
		nameSearchPanel.add(nameLabel);
		nameSearchPanel.add(nameTextField);

		// Button Panel
		JPanel buttons = new JPanel();
		JButtonSearch userSearch = new JButtonSearch(this);
		JButtonAddUser addUser = new JButtonAddUser(this);
		JButtonStatistics statistics = new JButtonStatistics(this);
		buttons.add(userSearch);
		buttons.add(addUser);
		buttons.add(statistics);

		add(nameSearchPanel);
		add(buttons);
	}

	public void createUserProfileView() {
		String name = nameTextField.getText();
		if (name != "") {
			if (db.getUserByName(name) != null) {
				tabbedPane.addTab(UserProfileView.NAME, new UserProfileView(
						tabbedPane, name, db));
			} else {
				JOptionPane.showMessageDialog(null, "the user "+name+" could not be found");
			}
		}
	}
	public void createEmptyUserProfileView() {
		tabbedPane.addTab(UserProfileView.NAME, new UserProfileView(tabbedPane, "", db));
	}

}
