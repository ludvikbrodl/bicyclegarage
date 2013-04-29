package gui.bicycleview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class JButtonRemoveBicycle extends JButton implements ActionListener {
	public JButtonRemoveBicycle(String bicycleID){
		super("Remove Bicycle");
		addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Removing bicycle...");
	}
}
