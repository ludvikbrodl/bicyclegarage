package gui.mainview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JButtonSearch extends JButton implements ActionListener{
	private JPanel panel;
	
	public JButtonSearch(JPanel panel) {
		super("Search for user");
		addActionListener(this);
		this.panel = panel;
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Search for user");
	}

}