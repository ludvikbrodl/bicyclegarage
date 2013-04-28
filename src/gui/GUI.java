package gui;
import gui.userprofileview.UserProfileView;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
/**
 * MAIN CLASS
 * @author bas11lbr
 *
 */
public class GUI {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Bicycle Garage Manager");
		// metod som sparar till databasen bör användas istället för close
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(600, 600));
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Main View", new MainView());
		tabbedPane.addTab("User Profile View", new UserProfileView());
		tabbedPane.addTab("Statistics View", new StatisticsView());
		tabbedPane.addTab("Bicycle View", new BicycleView());
		frame.add(tabbedPane);
		frame.setVisible(true);
	}
}
