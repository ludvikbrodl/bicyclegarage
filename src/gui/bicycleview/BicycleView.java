package gui.bicycleview;
import java.awt.Component;
import java.awt.GridLayout;

import model.BarcodePrinter;
import model.Bicycle;
import persistence.Database;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BicycleView extends JPanel {
	public BicycleView(String bicycleID, Database db, BarcodePrinter printer){
				super();
		setLayout(new GridLayout(2, 0));
		
		// Bicycle ID Panel
		JPanel bicycleIDPanel = new JPanel();
		JLabel bicycleIDEtiquette = new JLabel("Barcode:");
		JLabel bicycleIDLabel = new JLabel(bicycleID);
		bicycleIDPanel.add(bicycleIDEtiquette);
		bicycleIDPanel.add(bicycleIDLabel);
		
		// Button Panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(new JButtonPrint(bicycleID, printer));
		buttonPanel.add(new JButtonRemoveBicycle(bicycleID, db));
			
		add(bicycleIDPanel);
		add(buttonPanel);
	}
}
