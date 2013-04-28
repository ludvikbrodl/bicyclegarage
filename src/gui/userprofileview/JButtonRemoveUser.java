package gui.userprofileview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JButtonRemoveUser extends JButton implements ActionListener{
	private JPanel panel;
	
	public JButtonRemoveUser(JPanel panel) {
		super("Remove User");
		addActionListener(this);
		this.panel = panel;
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Remove User");
	}

}

