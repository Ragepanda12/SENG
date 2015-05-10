import java.awt.BorderLayout;
import java.awt.EventQueue;

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


public class MainPage extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblWebookuTravelAgency = new JLabel("WeBookU Travel Agency");
		lblWebookuTravelAgency.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		contentPane.add(lblWebookuTravelAgency, "2, 2");
		
		JLabel lblTravelDate = new JLabel("Travel date:");
		contentPane.add(lblTravelDate, "2, 6");
		
		JLabel lblEarliestFlightTime = new JLabel("Earliest flight time:");
		contentPane.add(lblEarliestFlightTime, "2, 8");
		
		JLabel lblOrigin = new JLabel("Origin:");
		contentPane.add(lblOrigin, "2, 10");
		
		JLabel lblDestination = new JLabel("Destination:");
		contentPane.add(lblDestination, "2, 12");
		
		JLabel lblSortResults = new JLabel("Sort results:");
		contentPane.add(lblSortResults, "2, 16");
		
		Choice choice = new Choice();
		contentPane.add(choice, "4, 16");
		choice.add("Cheapest");
		choice.add("Quickest");
		
		JLabel lblResultsPerPage = new JLabel("Results per page:");
		contentPane.add(lblResultsPerPage, "2, 18");
		
		Choice choice_1 = new Choice();
		contentPane.add(choice_1, "4, 18");
		choice_1.add("5");
		choice_1.add("10");
		choice_1.add("15");
		choice_1.add("20");
	}

}
