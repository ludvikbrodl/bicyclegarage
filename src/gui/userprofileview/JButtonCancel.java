package gui.userprofileview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JButtonCancel extends JButton implements ActionListener{
	private UserProfileView panel;
	
	public JButtonCancel(UserProfileView panel) {
		super("Cancel");
		addActionListener(this);
		this.panel = panel;
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		panel.removeMe();
		System.out.println("Cancel");
	}

}
