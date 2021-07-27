import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import csvStuff.CSVManager;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class OfficerRemover {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OfficerRemover window = new OfficerRemover();
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
	public OfficerRemover() {
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
		frame.setBounds(100, 100, 279, 257);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(81, 49, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(25, 51, 46, 17);
		panel.add(lblNewLabel);
		
		JLabel warning = new JLabel("");
		warning.setForeground(Color.RED);
		warning.setBounds(10, 80, 243, 14);
		panel.add(warning);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().trim().isEmpty()) {
					if(cs.isOfficerEmail(textField.getText()))
					{
							cs.officerRemover(textField.getText());
							warning.setForeground(Color.GREEN);
							warning.setText("Officer Succesfully Removed");
					}else {
						warning.setForeground(Color.RED);
						warning.setText("*sorry officer does not exist");
					}
						
				}else {
					warning.setForeground(Color.RED);
					warning.setText("*email field is empty");
				}
				
			}
		});
		btnNewButton.setBounds(45, 123, 157, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Officer Removal Form");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(25, 11, 192, 27);
		panel.add(lblNewLabel_1);
		
		JButton btnBackToAdmin = new JButton("< Back to Admin Form");
		btnBackToAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				AdminForm af = new AdminForm();
				af.main(null);
			}
		});
		btnBackToAdmin.setBounds(45, 157, 157, 23);
		panel.add(btnBackToAdmin);
		

	}

}
