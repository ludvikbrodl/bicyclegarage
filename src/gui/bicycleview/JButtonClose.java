package gui.bicycleview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JButtonClose extends JButton implements ActionListener{
	private JTabbedPane pane;
	
	public JButtonClose(JTabbedPane pane) {
		super("Close");
		addActionListener(this);
		this.pane = pane;
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		pane.remove(this.getParent().getParent());
		System.out.println("Close");
	}

}
