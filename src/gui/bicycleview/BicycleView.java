package gui.bicycleview;
import java.awt.Component;
import java.awt.GridLayout;

import model.Bicycle;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class BicycleView extends JPanel {
	public BicycleView(Bicycle bicycle){
				super();
		setLayout(new GridLayout(2, 0));
		
		// Bicycle ID Panel
		JPanel bicycleIDPanel = new JPanel();
		JLabel bicycleIDEtiquette = new JLabel("Barcode:");
		JLabel bicycleIDLabel = new JLabel(bicycle.getID());
		bicycleIDPanel.add(bicycleIDEtiquette);
		bicycleIDPanel.add(bicycleIDLabel);
		
		// Button Panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(new JButtonPrint(bicycle.getID()));
		buttonPanel.add(new JButtonRemoveBicycle(bicycle.getID()));
		
		
		add(bicycleIDPanel);
		add(buttonPanel);
	}
}
