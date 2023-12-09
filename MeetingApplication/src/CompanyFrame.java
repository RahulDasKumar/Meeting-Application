import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//@SuppressWarnings({ "unchecked", "rawtypes" })
public class CompanyFrame extends JFrame{
	JLabel label = new JLabel("Selected Times:");
	ArrayList<String> list = new ArrayList<>();
	public CompanyFrame(Company company) {
		setTitle("Select Times");
        setSize(1150, 1150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents(company);
	}

	private void initComponents(Company company) {
		add(new JLabel("Company Name :" + company.getName()));
		add(new JLabel("IMPORTANT: Hold CTRL while selecting times if you are available for more than one hour"));
		Container ControlHost = getContentPane();
		ControlHost.setLayout(new GridLayout(3,3));
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(int i = 0; i<company.getHoursAvailable().length; i++) {
			listModel.addElement(company.getHoursAvailable()[i]);
		}
		JButton button = new JButton("Submit Times");
		JList<String> Times = new JList<String>(listModel);
		Times.setVisibleRowCount(8);
		JScrollPane jcp = new JScrollPane(Times);
		ControlHost.add(jcp);
		ControlHost.add(label);
		ControlHost.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				ChartFrame chart = new ChartFrame(company.getHoursAvailable());
				chart.setVisible(true);
			
			}
		});
		
		Times.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				Times.addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						String strTimes = "";
						List<String> SelectedTimes = Times.getSelectedValuesList();
						for(String Time: SelectedTimes)
							strTimes =  Time;
						list.add(strTimes);
						label.setText(SelectedTimes.toString());	
					}
				});
				ControlHost.add(jcp);
				ControlHost.add(label);
				ControlHost.add(button);
	}
}
