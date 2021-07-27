import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import csvStuff.CSVManager;
import java.awt.Color;
public class CustomerRegistration {

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
					CustomerRegistration window = new CustomerRegistration();
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
	public CustomerRegistration() {
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
		frame.setBounds(100, 100, 226, 294);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblFirstname = new JLabel("First Name:");
		lblFirstname.setBounds(10, 66, 64, 14);
		panel.add(lblFirstname);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(10, 91, 64, 14);
		panel.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 116, 46, 14);
		panel.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 141, 64, 14);
		panel.add(lblPassword);
		
		fname = new JTextField();
		fname.setBounds(78, 63, 86, 20);
		panel.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setBounds(78, 88, 86, 20);
		panel.add(lname);
		lname.setColumns(10);
		
		email = new JTextField();
		email.setBounds(78, 113, 86, 20);
		panel.add(email);
		email.setColumns(10);
		
		password = new JTextField();
		password.setBounds(78, 138, 86, 20);
		panel.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User Registration Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(10, 11, 191, 28);
		panel.add(lblNewLabel);
		
		
		
		JLabel warning = new JLabel("");
		warning.setForeground(Color.RED);
		warning.setBounds(10, 166, 191, 14);
		panel.add(warning);
		
		
		
		
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String fname = , lname, email, password;
				
				if(fname.getText().trim().isEmpty()||lname.getText().trim().isEmpty()||email.getText().trim().isEmpty()||password.getText().trim().isEmpty()) {
					//System.out.println("OH NO");
					warning.setText("*you have left fields empty");
					//warning.setForeground(Color.RED);
					
				}else {
					warning.setText("");
					boolean x= cs.customerRegistrar(fname.getText(), lname.getText(), email.getText(), password.getText());
					if(x==false) {
						warning.setForeground(Color.RED);		
						warning.setText("*Customer email is already in use");
					}
					if(x==true) {
						warning.setForeground(Color.GREEN);			
						warning.setText("*CUstomer succesfully addded");
					}
				}
			}
		});
		
		
		btnRegister.setBounds(46, 206, 118, 23);
		panel.add(btnRegister);
		
		JButton btnBackToLogin = new JButton("Back to Login");
		btnBackToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login l = new Login();
				l.main(null);
			}
		});
		btnBackToLogin.setBounds(46, 180, 118, 23);
		panel.add(btnBackToLogin);
		

	}
}
