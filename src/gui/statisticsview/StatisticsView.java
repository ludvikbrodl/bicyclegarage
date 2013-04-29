package gui.statisticsview;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import persistence.Statistics;


public class StatisticsView extends JPanel {
	
	public StatisticsView(Statistics statistics) {
		super();
		
		setLayout(new GridLayout(2, 0));
		int bicyclesInGarage = statistics.getBicycleInGarage();
		int bicyclesTotal = statistics.getNumberOfBicycles();
		int usersTotal = statistics.getNumberOfUsers();
		List<Integer> entriesPerMonth = statistics.getNumberOfEntriesPerMonth();
		int months = entriesPerMonth.size();
		
		JScrollPane labelPanel = new JScrollPane();
		for(int entriesThisMonth : entriesPerMonth) {
			labelPanel.add(new JLabel(Integer.toString(entriesThisMonth)));
		}
		add(labelPanel);
		
	}
}
