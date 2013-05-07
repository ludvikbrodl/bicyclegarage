package gui.mainview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
/**
 * Button that exits the program and calls the databse method to save to file.
 * @author bas11lbr
 *
 */
public class JButtonExit extends JButton implements ActionListener{
	private MainView panel;
	
	public JButtonExit(MainView panel) {
		super("Exit");
		addActionListener(this);
		this.panel = panel;
		
	}

	/**
	 * Shutsdown the GUI and saves to database.
	 */
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Close");
		panel.shutdownGUI();
	}

}
