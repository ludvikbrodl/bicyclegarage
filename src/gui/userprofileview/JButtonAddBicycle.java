package gui.userprofileview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JButtonAddBicycle extends JButton implements ActionListener{
	private UserProfileView panel;
	
	public JButtonAddBicycle(UserProfileView panel) {
		super("Add Bicycle");
		addActionListener(this);
		this.panel = panel;
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		panel.createNewBicycleView();
		System.out.println("Add Bicycle");
	}

}

