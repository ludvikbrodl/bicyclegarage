package gui.mainview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
/** Button that opens a new empty UserProfileView tab.
 * 
 * @author bas11lbr
 *
 */
public class JButtonAddUser extends JButton implements ActionListener{
	private MainView panel;
	
	public JButtonAddUser(MainView panel) {
		super("Add new user");
		addActionListener(this);
		this.panel = panel;
		
	}
	/**
	 * Opens a new empty user profile view.
	 */
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Add new user");
		panel.createEmptyUserProfileView();
	}

}
