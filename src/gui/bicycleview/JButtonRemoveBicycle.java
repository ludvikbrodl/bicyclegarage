package gui.bicycleview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DatabaseMetaData;

import javax.swing.JButton;

import model.Bicycle;
import persistence.Database;
public class JButtonRemoveBicycle extends JButton implements ActionListener {
	private String bicycleID;
	private Database db;
	private BicycleView parent;
	public JButtonRemoveBicycle(String bicycleID, Database db, BicycleView parent){
		super("Remove Bicycle");
		addActionListener(this);
		this.db = db;
		this.bicycleID = bicycleID;
		this.parent = parent;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Removing bicycle...");
		if(db.hasBicycleWithID(bicycleID)) {
			Bicycle bicycle = db.getBicycleByID(bicycleID);
			db.removeBicycle(bicycle);
		}
		parent.removeMe();
	}
}
