package gui.bicycleview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.BarcodePrinter;


public class JButtonPrint extends JButton implements ActionListener{
	BarcodePrinter printer;
	String bicycleID;
	public JButtonPrint(String bicycleID, BarcodePrinter printer){
		super("Print Barcode");
		this.bicycleID = bicycleID;
		this.printer = printer;
		addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Printing barcode...");
		printer.printBarcode(bicycleID);
	}
}
