import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import csvStuff.ParkingCSV;
import csvStuff.Spaces;

import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JList;

public class CustomerBooking {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	static Customer c;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerBooking window = new CustomerBooking(c);
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
	public CustomerBooking(Customer c) {
		initialize();
		this.c = c;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		////////////////////
		ParkingCSV pv = new ParkingCSV();	
		///////////////////
		////////////////////
		Spaces sp = new Spaces();	
		///////////////////
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 487, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bookings");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(139, 11, 95, 39);
		panel.add(lblNewLabel);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblStart.setBounds(10, 48, 95, 39);
		panel.add(lblStart);
		
		JLabel lblEnd = new JLabel("Duration");
		lblEnd.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEnd.setBounds(10, 151, 95, 39);
		panel.add(lblEnd);
		

		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		spinner_2.setModel(new SpinnerDateModel(new Date(1617249600000L), new Date(1617249600000L), new Date(1651377600000L), Calendar.HOUR_OF_DAY));
		//spinner_2.setModel(new SpinnerDateModel(new Date(1618013193427L), new Date(1618013193427L), null, Calendar.HOUR_OF_DAY));
		spinner_2.setBounds(10, 98, 224, 53);
		panel.add(spinner_2);
		
		
		
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinner.setBounds(20, 210, 47, 20);
		panel.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 59, 1));
		spinner_1.setBounds(100, 210, 47, 20);
		panel.add(spinner_1);
		
		JLabel lblNewLabel_1 = new JLabel("Hours");
		lblNewLabel_1.setBounds(20, 189, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Minutes");
		lblNewLabel_2.setBounds(100, 189, 58, 14);
		panel.add(lblNewLabel_2);
		
		JLabel warning = new JLabel("");
		warning.setBounds(228, 279, 314, 19);
		panel.add(warning);
		
		
		JButton btnBook = new JButton("BOOK");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().trim().isEmpty() || textField_1.getText().trim().isEmpty()) {
					// System.out.println("no");
					warning.setText("*fields are Empty");
					warning.setForeground(Color.RED);

				} else {
					Date x = (Date) spinner_2.getValue();
					LocalDateTime date1 = LocalDateTime.ofInstant(x.toInstant(), ZoneId.systemDefault());
					LocalDateTime now = LocalDateTime.now();
					// System.out.println(now);
					// System.out.println(date1);
					// System.out.println(date1.isBefore(date1));
					if (date1.isBefore(now)) {
						// System.out.println("nooooooooooooooo");
						warning.setText("*date yout put is before current date please change");
						warning.setForeground(Color.RED);

					} else {

						if (sp.isSpace(textField.getText()) == false) {
							warning.setText("*sorry, space does not exist");
							warning.setForeground(Color.RED);
						} else {
							if (pv.ruleOfThree(c.email) == false) {
								warning.setText("*sorry you already have three bookings");
								warning.setForeground(Color.RED);

							} else {
								warning.setText("*space successfully added");
								warning.setForeground(Color.GREEN);
								// System.out.println(date1);
								boolean x1 = pv.isConflict(date1, (int) spinner.getValue(), (int) spinner_1.getValue(),textField.getText());
								//System.out.println(x1);
								if (x1 == true) {
									warning.setText("*sorry there is a conflict please pick another spot or time");
									warning.setForeground(Color.RED);

								} else {
									pv.booker(date1, (int) spinner.getValue(), (int) spinner_1.getValue(),
									textField.getText(), textField_1.getText(), c.email);
									// System.out.println(x1);
								}
							}
						}
					}
				}
			}
		});
		btnBook.setBounds(10, 275, 89, 23);
		panel.add(btnBook);
		
		textField = new JTextField();
		textField.setBounds(336, 98, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblSpace = new JLabel("Space #");
		lblSpace.setBounds(336, 82, 46, 14);
		panel.add(lblSpace);
		
		textField_1 = new JTextField();
		textField_1.setBounds(336, 170, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLicensePlate = new JLabel("License Plate");
		lblLicensePlate.setBounds(336, 151, 86, 20);
		panel.add(lblLicensePlate);
		

		
	}
}
