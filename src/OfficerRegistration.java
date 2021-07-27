import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import csvStuff.CSVManager;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OfficerRegistration {

	private JFrame frame;
	private JTextField fname;
	private JTextField lname;
	private JTextField email;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OfficerRegistration window = new OfficerRegistration();
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
	public OfficerRegistration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		////////////////////
		CSVManager cs = new CSVManager(); 
		///////////////////

		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 447, 231);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblOfficerRegistration = new JLabel("Officer Registration Form");
		lblOfficerRegistration.setBounds(27, 11, 210, 33);
		lblOfficerRegistration.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel.add(lblOfficerRegistration);
		
		fname = new JTextField();
		fname.setBounds(143, 55, 86, 20);
		panel.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setBounds(143, 86, 86, 20);
		panel.add(lname);
		lname.setColumns(10);
		
		email = new JTextField();
		email.setBounds(143, 117, 86, 20);
		panel.add(email);
		email.setColumns(10);
		
		password = new JTextField();
		password.setBounds(143, 148, 86, 20);
		panel.add(password);
		password.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(27, 58, 86, 14);
		panel.add(lblFirstName);
		
		JLabel lblLasrName = new JLabel("Last Name:");
		lblLasrName.setBounds(27, 89, 86, 14);
		panel.add(lblLasrName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(27, 120, 46, 14);
		panel.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Default Password:");
		lblPassword.setBounds(27, 151, 105, 14);
		panel.add(lblPassword);
		
		JLabel warning = new JLabel("");
		warning.setBounds(239, 137, 188, 14);
		panel.add(warning);
		
		JButton btnRegisterOfficer = new JButton("Register Officer");
		btnRegisterOfficer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fname.getText().trim().isEmpty()||lname.getText().trim().isEmpty()||email.getText().trim().isEmpty()||password.getText().trim().isEmpty()) {
					//System.out.println("OH NO");
					warning.setText("*you have left fields empty");
					warning.setForeground(Color.RED);
					
				}else {
					boolean x = cs.officerRegistrar(fname.getText(), lname.getText(), email.getText(), password.getText());
					if( x== false) {
						warning.setText("*officer already exists");
						warning.setForeground(Color.RED);
						
					}
					if( x== true) {
						warning.setText("*officer successfully added");
						warning.setForeground(Color.GREEN);
						
					}
				}
				
			}
		});
		btnRegisterOfficer.setBounds(239, 54, 188, 23);
		panel.add(btnRegisterOfficer);
		
		JButton btnBackToAdmin = new JButton("<  Back to Admin Form");
		btnBackToAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				AdminForm af = new AdminForm();
				af.main(null);
				
				
				
			}
		});
		btnBackToAdmin.setBounds(239, 85, 188, 23);
		panel.add(btnBackToAdmin);

	}
}
