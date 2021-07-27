import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminForm {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminForm window = new AdminForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 265, 258);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(70, 11, 116, 31);
		panel.add(lblNewLabel);
		
		JButton btnAddParkingEnforcement = new JButton("Add Parking Enforcement");
		btnAddParkingEnforcement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				OfficerRegistration or = new OfficerRegistration();
				or.main(null);
				
				
			}
		});
		btnAddParkingEnforcement.setBounds(10, 70, 214, 23);
		panel.add(btnAddParkingEnforcement);
		
		JButton btnAddParkingEnforcement_1 = new JButton("Remove Parking Enforcement");
		btnAddParkingEnforcement_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				OfficerRemover or1 = new OfficerRemover();
				or1.main(null);
				
			}
		});
		btnAddParkingEnforcement_1.setBounds(10, 105, 214, 23);
		panel.add(btnAddParkingEnforcement_1);
		
		JButton btnChangeParkingStatus = new JButton("Change Payment Status");
		btnChangeParkingStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				AdminStatusChanger or1 = new AdminStatusChanger ();
				or1.main(null);				
				
			}
		});
		btnChangeParkingStatus.setBounds(10, 143, 214, 23);
		panel.add(btnChangeParkingStatus);
	}
}
