package gui.bicycleview;
import java.awt.Component;
import model.Bicycle;

import javax.swing.JPanel;


public class BicycleView extends JPanel {
	public BicycleView(Bicycle bicycle){
				super();
		setLayout(new GridLayout(2, 0));
		
		// Name Panel
		JPanel bicycleIDPanel = new JPanel();
		JLabel bicycleIDEtiquette = new JLabel("Barcode:");
		JLabel bicycleIDLabel = new JLabel(bicycle.);
		namePanel.add(bicycleIDEtiquette);
		namePanel.add(bicycleIDLabel);
		namePanel.add(nameTextField);
		
		// Button Panel
		JPanel buttonPanel = new JPanel();
		
		
		add(namePanel);
		add(buttonPanel);
	}
}
