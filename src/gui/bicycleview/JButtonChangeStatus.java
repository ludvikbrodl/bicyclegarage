package gui.bicycleview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DatabaseMetaData;

import javax.swing.JButton;

import model.Bicycle;
import persistence.Database;
public class JButtonChangeStatus extends JButton implements ActionListener {
	private BicycleView parent;
	public JButtonChangeStatus(BicycleView parent){
		super("Change status");
		addActionListener(this);
		this.parent = parent;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		parent.changeBicycleStatus();
	}
}
