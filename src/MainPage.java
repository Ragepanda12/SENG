import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;

import java.awt.Choice;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;


public class MainPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtHour;
	private JTextField txtMinutes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		//Main Panel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("121dlu"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(93dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(5dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(40dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("40dlu:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(2dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(4dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				RowSpec.decode("top:3dlu"),
				FormFactory.PREF_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(24dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblWebookuTravelAgency = new JLabel("WeBookU Travel Agency");
		lblWebookuTravelAgency.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		contentPane.add(lblWebookuTravelAgency, "2, 2");
		
		JLabel lblTravelDate = new JLabel("Travel date:");
		contentPane.add(lblTravelDate, "2, 6");
		
		final JButton btnChooseDate = new JButton("Choose Date");
		btnChooseDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame newWindow = new JFrame();
				final JDateChooser dateChooser = new JDateChooser();
				dateChooser.setBounds(100, 20, 200, 30); // Modify depending on your preference
				newWindow.getContentPane().add(dateChooser);
				newWindow.pack();
				newWindow.setVisible(true);
				
				dateChooser.getDateEditor().addPropertyChangeListener(
				    new PropertyChangeListener() {
				        @Override
				        public void propertyChange(PropertyChangeEvent e) {
				            if ("date".equals(e.getPropertyName())) {
				            	Date date =  dateChooser.getDate();
				            	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				            	btnChooseDate.setText(dateFormat.format(date));
				            }
				        }
				    });
			}
		});
		contentPane.add(btnChooseDate, "4, 6");
		
		JLabel lblEarliestFlightTime = new JLabel("Earliest flight time:");
		contentPane.add(lblEarliestFlightTime, "2, 8, left, default");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "4, 8, fill, fill");
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		txtHour = new JTextField();
		txtHour.setText("Hour");
		//panel.add(txtHour);
		txtHour.setColumns(10);
		txtHour.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				txtHour.setText("");
			}
		});
		
		Choice hours = new Choice();
		panel.add(hours);
		hours.add("01");
		hours.add("02");
		hours.add("03");
		hours.add("04");
		hours.add("05");
		hours.add("06");
		hours.add("07");
		hours.add("08");
		hours.add("09");
		hours.add("10");
		hours.add("11");
		hours.add("12");
		
		JLabel label = new JLabel(":");
		panel.add(label);
		
		Choice minutes = new Choice();
		panel.add(minutes);
		minutes.add("00");
		minutes.add("15");
		minutes.add("30");
		minutes.add("45");
		
		txtMinutes = new JTextField();
		txtMinutes.setText("Minutes");
		//panel.add(txtMinutes);
		txtMinutes.setColumns(10);
		
		txtMinutes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				txtMinutes.setText("");
			}
		});
		
		
		Choice choice_2 = new Choice();
		panel.add(choice_2);
		choice_2.add("AM");
		choice_2.add("PM");
		
		JLabel lblOrigin = new JLabel("Origin:");
		contentPane.add(lblOrigin, "2, 10");
		
		JButton btnChooseOrigin = new JButton("Choose Origin");
		contentPane.add(btnChooseOrigin, "4, 10");
		
		JLabel lblDestination = new JLabel("Destination:");
		contentPane.add(lblDestination, "2, 12");
		
		JButton btnChooseDestination = new JButton("Choose Destination");
		contentPane.add(btnChooseDestination, "4, 12");
		
		JLabel lblSortResults = new JLabel("Sort results:");
		contentPane.add(lblSortResults, "2, 16");
		
		Choice SortResultsBy = new Choice();
		contentPane.add(SortResultsBy, "4, 16");
		SortResultsBy.add("Minimal Cost");
		SortResultsBy.add("Minimal Travel Time");
		SortResultsBy.add("Maximal frequent flier value");
		
		JLabel lblResultsPerPage = new JLabel("Results per page:");
		contentPane.add(lblResultsPerPage, "2, 18");
		
		final Choice NumResults = new Choice();
		contentPane.add(NumResults, "4, 18");
		
		JButton btnSearch = new JButton("Search");
		contentPane.add(btnSearch, "4, 22");
		NumResults.add("5");
		NumResults.add("10");
		NumResults.add("15");
		NumResults.add("20");
		
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);

				//Results Page
				final JPanel ResultsPage = new JPanel();
				
				ResultsPage.setLayout(new GridLayout(20,1));
				ResultsPage.setBorder(new EmptyBorder(5, 5, 5, 5));

				
				JLabel lblWebookuTravelAgency = new JLabel("WeBookU Travel Agency");
				lblWebookuTravelAgency.setFont(new Font("Lucida Grande", Font.BOLD, 18));
				ResultsPage.add(lblWebookuTravelAgency);
				
				int[] NumResultsSelect = {5,10,15,20};
				
				String[] sampleString = {"AirNZ","3RD JUNE 3:55AM","3RD JUNE 2:00PM"," $799 1 ADULT 2 CHILD"};
				for (int i=0; i<NumResultsSelect[NumResults.getSelectedIndex()]; i++) { //currently accepts ResultsPerPage, but not Sort By
					JPanel singleResult = new JPanel();
					singleResult.setLayout(new GridLayout(1,5));
					JLabel Airliner = new JLabel("Airliner");
					JLabel Departs = new JLabel("Departs");
					JLabel Arrives = new JLabel("Arrives");
					JLabel Details = new JLabel("Details");
					JLabel Choice = new JLabel("Choice");
					JButton Select = new JButton("Select");
					if (i>0) {
						Airliner.setText(sampleString[0]);
						Departs.setText(sampleString[1]);
						Arrives.setText(sampleString[2]);
						Details.setText(sampleString[3]);	
					}
					singleResult.add(Airliner);
					singleResult.add(Departs);
					singleResult.add(Arrives);
					singleResult.add(Details);
					if (i>0) {
						singleResult.add(Select);
					} else { singleResult.add(Choice); };
					ResultsPage.add(singleResult);
					
				};		
				
				JButton returnToMainPage = new JButton("Back");
				ResultsPage.add(returnToMainPage);
				returnToMainPage.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ResultsPage.setVisible(false);
						setContentPane(contentPane);
						contentPane.setVisible(true);
						
					}
				});
			
				ResultsPage.setVisible(true);
				setContentPane(ResultsPage);
				
			}
		});

		
	}
	
	public JPanel Result(String Airliner, String Departs, String Arrives, String Details) {
		JPanel r = new JPanel();
		return r;
	}
}
