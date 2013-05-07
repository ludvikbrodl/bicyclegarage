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
 * Main class to start the program.
 *
 */
public class GUI {

	/** Initialization
	 * @param args not used
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Bicycle Garage Manager");
		frame.setSize(new Dimension(600, 600));
		
		BarcodePrinter printer = new BarcodePrinterTestDriver();
		Database db = new Database();
		Statistics stats = new Statistics(db);
		JTabbedPane tabbedPane = new JTabbedPane();
		MainView mainview = new MainView(tabbedPane, db, stats, printer);
		tabbedPane.addTab(MainView.NAME, mainview);
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.add(tabbedPane);
		frame.setVisible(true);
	}

}
