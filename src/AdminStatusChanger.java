import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;

import csvStuff.ParkingCSV;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminStatusChanger {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminStatusChanger window = new AdminStatusChanger();
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
	public AdminStatusChanger() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		////////////////////
		ParkingCSV pv= new ParkingCSV();
		////////////////////
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 362, 283);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(23, 86, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblBookingid = new JLabel("Customer Email:");
		lblBookingid.setBounds(23, 61, 115, 14);
		panel.add(lblBookingid);
		
		JLabel warning = new JLabel("");
		warning.setBounds(23, 163, 227, 20);
		panel.add(warning);
		
		JButton btnChangeStaus = new JButton("Change Status");
		btnChangeStaus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().trim().isEmpty() || textField_1.getText().trim().isEmpty()) {
					// System.out.println("OH NO");
					warning.setText("*you have left fields empty");
					warning.setForeground(Color.RED);
				} else {
					
					boolean x = pv.changeStatus(textField.getText(), textField_1.getText());
					if (x==false) {
						warning.setText("*Sorry booking does not exist");
						warning.setForeground(Color.RED);
					}else {
						warning.setText("*Status' successfully changed");
						warning.setForeground(Color.GREEN);
					}
				}

			}
		});
		btnChangeStaus.setBounds(23, 185, 108, 23);
		panel.add(btnChangeStaus);
		
		JLabel lblStatusChanger = new JLabel("Status Changer");
		lblStatusChanger.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblStatusChanger.setBounds(10, 28, 159, 29);
		panel.add(lblStatusChanger);
		
		textField_1 = new JTextField();
		textField_1.setBounds(23, 132, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblParkingSpace = new JLabel("Parking Space:");
		lblParkingSpace.setBounds(23, 117, 86, 14);
		panel.add(lblParkingSpace);
		
		textField_2 = new JTextField();
		textField_2.setBounds(195, 86, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblFullNameoptional = new JLabel("Full name(Optional)");
		lblFullNameoptional.setBounds(193, 61, 115, 14);
		panel.add(lblFullNameoptional);
		

	}
}
