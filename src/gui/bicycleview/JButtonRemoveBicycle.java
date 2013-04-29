package gui.bicycleview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DatabaseMetaData;

import javax.swing.JButton;
import persistence.Database;
public class JButtonRemoveBicycle extends JButton implements ActionListener {
	private String bicycleID;
	private Database db;
	public JButtonRemoveBicycle(String bicycleID, Database db){
		super("Remove Bicycle");
		addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Removing bicycle...");
		db.
	}
}
