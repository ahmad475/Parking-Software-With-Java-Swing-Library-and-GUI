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

public class CancelBooking {

	private JFrame frame;
	private JTextField textField;
	static Customer c;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelBooking window = new CancelBooking(c);
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
	public CancelBooking(Customer c) {
		this.c= c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		////////////////////
		ParkingCSV pv = new ParkingCSV();	
		///////////////////
		
		frame = new JFrame();
		frame.setBounds(100, 100, 192, 189);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 59, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblBookingId = new JLabel("Booking ID");
		lblBookingId.setBounds(10, 42, 73, 14);
		panel.add(lblBookingId);

		JLabel warning = new JLabel("");
		warning.setBounds(10, 90, 141, 14);
		panel.add(warning);
		
		JButton btnRemoveBooking = new JButton("Remove Booking");
		btnRemoveBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookingid  = textField.getText();
				boolean x = pv.bookingRemover(bookingid, c.email);
				if(x==false) {
					warning.setText("*sorry could not remove booking");
					warning.setForeground(Color.RED);
				}else {
					warning.setText("*booking has been succesfully removed");
					warning.setForeground(Color.GREEN);
				}
				
				//System.out.println(x);
			
			
			}
		});
		btnRemoveBooking.setBounds(10, 115, 141, 23);
		panel.add(btnRemoveBooking);
		
		JLabel lblCancelBooking = new JLabel("Cancel Booking");
		lblCancelBooking.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCancelBooking.setBounds(10, 11, 156, 29);
		panel.add(lblCancelBooking);
		

	}

}
