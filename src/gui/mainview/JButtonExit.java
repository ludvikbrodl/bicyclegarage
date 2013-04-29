package gui.mainview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JButtonExit extends JButton implements ActionListener{
	private JTabbedPane pane;
	
	public JButtonExit(JTabbedPane pane) {
		super("Exit");
		addActionListener(this);
		this.pane = pane;
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Close");
		System.exit(0);
	}

}
