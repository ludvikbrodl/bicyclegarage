package gui.userprofileview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JButtonSave extends JButton implements ActionListener{
	private UserProfileView panel;
	
	public JButtonSave(UserProfileView panel) {
		super("Save");
		addActionListener(this);
		this.panel = panel;
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Save");
	}

}

