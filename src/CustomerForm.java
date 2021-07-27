import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerForm {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	static Customer c;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//changed from CustomerForm() ---> CustomerForm(c)
					CustomerForm window = new CustomerForm(c);
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
	public CustomerForm(Customer c) {
		initialize();
		this.c = c;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 244, 292);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUserForm = new JLabel("Customer Form");
		lblUserForm.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblUserForm.setBounds(41, 25, 171, 23);
		panel.add(lblUserForm);
		
		JButton btnBookSpace = new JButton("Book Space");
		btnBookSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				System.out.println(c.email);
				frame.dispose();
				CustomerBooking uf = new CustomerBooking(c);
				uf.main(null);
			
				
			}
		});
		btnBookSpace.setBounds(41, 100, 148, 23);
		panel.add(btnBookSpace);
		
		JButton btnCancelBooking = new JButton("Cancel Booking");
		btnCancelBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CancelBooking cb = new CancelBooking(c);
				cb.main(null);				
			}
		});
		btnCancelBooking.setBounds(41, 176, 148, 23);
		panel.add(btnCancelBooking);
		
		JButton btnPayForSpace = new JButton("Pay For Space(s)");
		btnPayForSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//System.out.println(c.email);
				frame.dispose();
				PayBooking uf = new PayBooking(c);
				uf.main(null);				

				
			}
		});
		btnPayForSpace.setBounds(41, 210, 148, 23);
		panel.add(btnPayForSpace);
		
		
		
		
		
		
		JButton btnViewBookings = new JButton("View Bookings");
		btnViewBookings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(c.email);
				frame.dispose();
				ViewBookings uf = new ViewBookings(c);
				uf.main(null);				
				
			}
		});
		btnViewBookings.setBounds(41, 142, 148, 23);
		panel.add(btnViewBookings);
	}
}
