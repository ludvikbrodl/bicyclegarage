package gui.userprofileview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Bicycle;

public class JButtonBicycle extends JButton implements ActionListener{
	private UserProfileView panel;
	private Bicycle bicycle;
	
	public JButtonBicycle(UserProfileView panel, Bicycle bicycle) {
		super("Bicycle #" + bicycle);
		this.bicycle = bicycle;
		addActionListener(this);
		this.panel = panel;
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		panel.createBicycleView(bicycle.getID());
		System.out.println("Bicycle # button");
	}

}
