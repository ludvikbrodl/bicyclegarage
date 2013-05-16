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
import driver.BarcodeReaderEntryTestDriver;
import driver.BarcodeReaderExitTestDriver;
import driver.ElectronicLockTestDriver;
import driver.PinCodeTerminalTestDriver;

import persistence.Database;
import persistence.Statistics;

import model.BarcodePrinter;
import model.BarcodeReader;
import model.Bicycle;
import model.BicycleGarageManager;
import model.ElectronicLock;
import model.LundBicycleGarageManager;
import model.PinCodeTerminal;

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
		db.readFromFile();
		Statistics stats = new Statistics(db);
		BicycleGarageManager manager = new LundBicycleGarageManager(db, stats);
        ElectronicLock entryLock = new ElectronicLockTestDriver("Entry lock");
        ElectronicLock exitLock = new ElectronicLockTestDriver("Exit lock");
        PinCodeTerminal terminal = new PinCodeTerminalTestDriver();
        manager.registerHardwareDrivers(printer, entryLock, exitLock, terminal);
        terminal.register(manager);
        BarcodeReader readerEntry = new BarcodeReaderEntryTestDriver();
        BarcodeReader readerExit = new BarcodeReaderExitTestDriver();
        readerEntry.register(manager);
        readerExit.register(manager);
        
		JTabbedPane tabbedPane = new JTabbedPane();
		MainView mainview = new MainView(tabbedPane, db, stats, printer);
		tabbedPane.addTab(MainView.NAME, mainview);
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.add(tabbedPane);
		frame.setVisible(true);
		
		
	}

}
