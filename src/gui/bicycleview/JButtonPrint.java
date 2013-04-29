package gui.bicycleview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class JButtonPrint extends JButton implements ActionListener{
	public JButtonPrint(String bicycleID){
		super("Print Barcode");
		addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Printing barcode...");
	}
}
