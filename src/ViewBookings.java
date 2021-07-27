import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import csvStuff.ParkingCSV;

import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JScrollBar;

public class ViewBookings {

	private JFrame frame;
	String q;
	static Customer c;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBookings window = new ViewBookings(c);
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
	public ViewBookings(Customer c) {
		this.c =c;
		initialize();
		
//		q=c.email;
//		System.out.println();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		////////////////////
		ParkingCSV pv = new ParkingCSV();	
		///////////////////
		//System.out.println("THIS IS EMAIL:   "+c.email);
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 316, 266);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ArrayList<String> x =  pv.getBookings(this.c.email);
		ArrayList<String> modified = new ArrayList<String>();
		
		for(String l: x) {
			String[] l1 = l.split(",");
			String q = l1[0]+"  "+l1[7]+ "  "+l1[8];
			modified.add(q);
		}
		
		//System.out.println(x.toString());
		
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		//
		String[] l= {};
		JList list_1 = new JList(modified.toArray());
		list_1.setBounds(10, 93, 253, 85);
		panel.add(list_1);
		
		
		
		
		
		
		
		
		
		
		panel.setLayout(null);
		
		JLabel lblCustomerBookingInformation = new JLabel("Customer Booking Information");
		lblCustomerBookingInformation.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCustomerBookingInformation.setBounds(10, 11, 334, 46);
		panel.add(lblCustomerBookingInformation);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(10, 68, 46, 14);
		panel.add(lblStart);
		
		JLabel lblPaid = new JLabel("Paid");
		lblPaid.setBounds(107, 68, 46, 14);
		panel.add(lblPaid);
		
		JLabel lblConfirmed = new JLabel("Confirmed");
		lblConfirmed.setBounds(170, 68, 93, 14);
		panel.add(lblConfirmed);
		
		JButton button = new JButton("< go back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				frame.dispose();
				CustomerForm uf = new CustomerForm(c);
				uf.main(null);	
			}
		});
		button.setBounds(20, 189, 89, 23);
		panel.add(button);
	}
}
