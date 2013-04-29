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
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Bicycle;

public class MainView extends JPanel {

	public static final String NAME = "Main View";
	private JTabbedPane tabbedPane;

	public MainView(JTabbedPane tabbedPane) {
		super();
		this.tabbedPane = tabbedPane;

		setLayout(new GridLayout(10, 0));
		
		// NameSearch Panel
		JPanel nameSearchPanel = new JPanel();
		JTextField nameTextField = new JTextField(30);
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

}
