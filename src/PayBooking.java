import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

import csvStuff.ParkingCSV;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class PayBooking {

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
					PayBooking window = new PayBooking(c);
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
	public PayBooking(Customer c) {
		this.c = c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		////////////////////
		ParkingCSV pv = new ParkingCSV();	
		///////////////////
		String l;
		
		l=pv.price(c.email);
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 347, 285);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblMoneyOwed = new JLabel("Money Owed:");
		lblMoneyOwed.setBounds(228, 55, 93, 14);
		panel.add(lblMoneyOwed);
		
		textField = new JTextField();
		textField.setBounds(29, 93, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		

		
		JLabel lblCreditCardNumber = new JLabel("Card Number");
		lblCreditCardNumber.setBounds(29, 68, 101, 14);
		panel.add(lblCreditCardNumber);
		
		JLabel Money = new JLabel("New label");
		Money.setFont(new Font("Tahoma", Font.PLAIN, 19));
		Money.setBounds(228, 68, 110, 100);
		panel.add(Money);
		
		Money.setText(l);
	
		
		
		JRadioButton rdbtnCredit = new JRadioButton("Credit");
		rdbtnCredit.setBounds(29, 7, 109, 23);
		panel.add(rdbtnCredit);
		
		JRadioButton rdbtnDebit = new JRadioButton("Debit");
		rdbtnDebit.setBounds(29, 39, 109, 23);
		panel.add(rdbtnDebit);
	
	
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnCredit);
		group.add(rdbtnDebit);
		
		JLabel warning = new JLabel("");
		warning.setBounds(10, 158, 257, 18);
		panel.add(warning);

		
	
		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnCredit.isSelected()||rdbtnDebit.isSelected()) {
				//System.out.println("print x");
					if(!textField.getText().trim().isEmpty()) 
					{	
						pv.payOff(c.email);
						String ll=pv.price(c.email);
						//System.out.println(ll);
						Money.setText(ll);
						warning.setText("BILL SUCCESSFULLY SENT");
						warning.setForeground(Color.GREEN);
						LocalDateTime now = LocalDateTime.now();
						pv.paystamp(now,l);
						
						
					}
					else 
					{
						warning.setText("Fields are empty");
						warning.setForeground(Color.RED);
					}
				}
				else 
				{
					warning.setText("Please Pick Radio Button");
					warning.setForeground(Color.RED);
				}
				
				
				
				
			}
		});
		btnPay.setBounds(29, 124, 89, 23);
		panel.add(btnPay);
		
		JButton btnNewButton = new JButton("< go back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CustomerForm uf = new CustomerForm(c);
				uf.main(null);
			}
		});
		btnNewButton.setBounds(26, 187, 89, 23);
		panel.add(btnNewButton);
		
	
	
	
	}
}
