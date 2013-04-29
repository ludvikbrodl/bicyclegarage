package gui.userprofileview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JButtonCancel extends JButton implements ActionListener{
	private JPanel panel;
	
	public JButtonCancel(JPanel panel) {
		super("Cancel");
		addActionListener(this);
		this.panel = panel;
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Cancel");
	}

}
