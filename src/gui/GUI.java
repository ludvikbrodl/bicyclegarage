package gui;
import gui.bicycleview.BicycleView;
import gui.mainview.MainView;
import gui.statisticsview.StatisticsView;
import gui.userprofileview.UserProfileView;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import driver.BarcodePrinterTestDriver;

import persistence.Database;
import persistence.Statistics;

import model.BarcodePrinter;
import model.Bicycle;
/**
 * MAIN CLASS
 * @author bas11lbr
 *
 */
public class GUI {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Bicycle Garage Manager");
		// metod som sparar till databasen b�r anv�ndas ist�llet f�r close
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(600, 600));
		
		Database db = new Database();
		Statistics stats = new Statistics();
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab(MainView.NAME, new MainView(tabbedPane, db, stats));
//		tabbedPane.addTab(UserProfileView.NAME, new UserProfileView());
//		tabbedPane.addTab("Bicycle View", new BicycleView("dummy ID", new Database(), new BarcodePrinterTestDriver()));
//		tabbedPane.addTab("Statistics View", new StatisticsView());
//		
//		tabbedPane.setEnabledAt(1, false);
//		tabbedPane.setEnabledAt(2, false);
//		tabbedPane.setEnabledAt(3, false);
		
		frame.add(tabbedPane);
		frame.setVisible(true);
	}

}
