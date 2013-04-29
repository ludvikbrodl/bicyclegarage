package gui.mainview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JButtonStatistics extends JButton implements ActionListener{
	private MainView panel;
	
	public JButtonStatistics(MainView panel) {
		super("Statistics");
		addActionListener(this);
		this.panel = panel;
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Statistics");
		panel.createStatisticsView();
	}

}