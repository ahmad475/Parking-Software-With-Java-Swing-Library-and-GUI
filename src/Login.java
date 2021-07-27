import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Window;

import csvStuff.CSVManager;
import java.awt.Color;
public class Login {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	public  Customer c;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
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
		frame.setBounds(100, 100, 325, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(21, 64, 46, 14);
		panel.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(158, 64, 65, 14);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(21, 91, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(158, 91, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		
		
		
		JLabel lblLoginForm = new JLabel("Login Form");
		lblLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblLoginForm.setBounds(21, 11, 143, 30);
		panel.add(lblLoginForm);
		
		JLabel warning = new JLabel("");
		warning.setForeground(Color.RED);
		warning.setBounds(31, 122, 192, 14);
		panel.add(warning);
		
		
		
		
		
		
		
		
		JButton btnNewButton = new JButton("SIGN-IN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean customer;
				boolean admin;
				boolean officer;
				if(textField.getText().trim().isEmpty()||textField_1.getText().trim().isEmpty()) {
					//System.out.println("OH NO");
					warning.setText("*you have left fields empty");
					
				}else {
				String email = textField.getText();
				String password = textField_1.getText();
				customer= cs.isCustomer(email, password);
				admin = cs.isAdmin(email, password);
				officer = cs.isOfficer(email, password);
				//System.out.println("user: "+customer+"    admin:"+admin+"   officer:"+officer);
				if(admin == true) {
					//System.out.println("WHAT IS THIS admin");
					frame.dispose();
					AdminForm af = new AdminForm();
					af.main(null);
				}
				else if(customer== true) {
					//System.out.println("WHAT IS THIS customer");
					frame.dispose();
					Customer c = Customer.getInstance();//= new Customer(email, password);
					c.setemail(email);
					c.setpassword(password);
					CustomerForm uf = new CustomerForm(c);
					uf.main(null);
				}
				else if(officer == true) {
					//System.out.println("WHAT IS THIS officer");
					frame.dispose();
					OfficerForm of = new OfficerForm();
					of.main(null);
				}else {
					warning.setText("*email or password is incorrect");
				}
				
				
				
				}
				
			}
		});
		btnNewButton.setBounds(21, 147, 102, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CustomerRegistration cr = new CustomerRegistration ();
				cr.main(null);
				
			}
		});
		btnNewButton_1.setBounds(178, 147, 89, 23);
		panel.add(btnNewButton_1);
		

	}
}
