package gui.bicycleview;
import java.awt.Component;
import java.awt.GridLayout;

import model.BarcodePrinter;
import model.Bicycle;
import model.User;
import persistence.Database;
import persistence.Statistics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class BicycleView extends JPanel {
	
	private JLabel bicycleStatusLabel;
	private Bicycle bicycle;
	private JTabbedPane tabbedPane;
	private Statistics statistics;
	public BicycleView(User user, String bicycleID, Database db, BarcodePrinter printer,
			JTabbedPane tabbedPane, Statistics statistics){
				super();
		setLayout(new GridLayout(3, 0));
		this.tabbedPane = tabbedPane;
		this.statistics = statistics;
		// Bicycle ID Panel
		JPanel bicycleIDPanel = new JPanel();
		JLabel bicycleIDEtiquette = new JLabel("Barcode:");
		JLabel bicycleIDLabel = new JLabel(bicycleID);
		bicycleIDPanel.add(bicycleIDEtiquette);
		bicycleIDPanel.add(bicycleIDLabel);
		
		// Bicycle Status Panel
		JPanel bicycleStatusPanel = new JPanel();
		JLabel bicycleStatusEtiquette = new JLabel("Status:");
		String bicycleStatus = "N/A";
		if(db.hasBicycleWithID(bicycleID)) {
			bicycle = db.getBicycleByID(bicycleID);
			if(bicycle.isInGarage()) {
				bicycleStatus = "In garage";
			} else {
				bicycleStatus = "Out of garage";
			}
		}
		bicycleStatusLabel = new JLabel(bicycleStatus);
		bicycleStatusPanel.add(bicycleStatusEtiquette);
		bicycleStatusPanel.add(bicycleStatusLabel);
		
		// Button Panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(new JButtonPrint(bicycleID, printer));
		buttonPanel.add(new JButtonChangeStatus(this));
		buttonPanel.add(new JButtonRemoveBicycle(user, bicycleID, db, this));
		buttonPanel.add(new JButtonClose(this));
			
		add(bicycleIDPanel);
		add(bicycleStatusPanel);
		add(buttonPanel);
	}
	void changeBicycleStatus() {
		if(bicycle != null) {
			if(bicycle.isInGarage()) {
				bicycle.setInGarage(false);
				bicycleStatusLabel.setText("Out of garage");
				statistics.decrementBicyclesInGarage();
			} else {
				bicycle.setInGarage(true);
				bicycleStatusLabel.setText("In garage");
				statistics.incrementBicyclesInGarage();
			}
		}
	}
	
	void removeMe() {
		tabbedPane.remove(this);
	}
}
