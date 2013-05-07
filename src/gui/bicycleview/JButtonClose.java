package gui.bicycleview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JButtonClose extends JButton implements ActionListener{
	private BicycleView parent;
	
	public JButtonClose(BicycleView parent) {
		super("Close");
		addActionListener(this);
		this.parent = parent;
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		parent.removeMe();
	}

}
