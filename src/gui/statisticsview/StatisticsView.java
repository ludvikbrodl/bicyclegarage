package gui.statisticsview;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import persistence.Statistics;


public class StatisticsView extends JPanel {
	private static final String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May",
		"Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	public static final String NAME = "Statistics";
	public StatisticsView(JTabbedPane tabbedPane, Statistics statistics) {
		super();
		
		setLayout(new GridLayout(2, 0));
		int bicyclesInGarage = statistics.getBicyclesInGarage();
		int bicyclesTotal = statistics.getNumberOfBicycles();
		int usersTotal = statistics.getNumberOfUsers();
		List<Integer> entriesPerMonth = statistics.getNumberOfEntriesPerMonth();
		JPanel labelPanel = new JPanel(new GridLayout(entriesPerMonth.size()+3, 0));
		
		Calendar calendar = new GregorianCalendar();
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);
		for(int i=0;i<entriesPerMonth.size();i++) {
			String monthName = monthNames[month]; 
			int entriesThisMonth = entriesPerMonth.get(i);
			labelPanel.add(new JLabel(monthName+" "+year+": " +entriesThisMonth));
			if (month == 0){
				month = 11;
				year--;
			} else {
				month--;
			}
		}
		
		labelPanel.add(new JLabel("Registered bicycles: "+bicyclesTotal));
		labelPanel.add(new JLabel("Registered users: "+usersTotal));
		labelPanel.add(new JLabel("Bicycles in garage now: "+bicyclesInGarage));
		
		JScrollPane scroll = new JScrollPane(labelPanel);
		add(scroll);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(new JButtonClose(tabbedPane));
		add(buttonPanel);
	}
}
