import java.awt.BorderLayout;
import java.awt.EventQueue;
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
		panel.add(txtHour);
		txtHour.setColumns(10);
		txtHour.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				txtHour.setText("");
			}
		});
		
		JLabel label = new JLabel(":");
		panel.add(label);
		
		txtMinutes = new JTextField();
		txtMinutes.setText("Minutes");
		panel.add(txtMinutes);
		txtMinutes.setColumns(10);
		
		txtMinutes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				txtMinutes.setText("");
			}
		});
		
		Choice choice_2 = new Choice();
		panel.add(choice_2);
		choice_2.add("am");
		choice_2.add("pm");
		
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
		
		Choice choice = new Choice();
		contentPane.add(choice, "4, 16");
		choice.add("Minimal Cost");
		choice.add("Minimal Travel Time");
		choice.add("Maximal frequent flier value");
		
		JLabel lblResultsPerPage = new JLabel("Results per page:");
		contentPane.add(lblResultsPerPage, "2, 18");
		
		Choice choice_1 = new Choice();
		contentPane.add(choice_1, "4, 18");
		
		JButton btnSearch = new JButton("Search");
		contentPane.add(btnSearch, "4, 22");
		choice_1.add("5");
		choice_1.add("10");
		choice_1.add("15");
		choice_1.add("20");
	}

}
