import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;

import csvStuff.Spaces;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SpacesForm {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpacesForm window = new SpacesForm();
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
	public SpacesForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//////////////////////
		Spaces s = new Spaces();
		//////////////////////
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 336, 239);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		
		
		
		textField = new JTextField();
		textField.setBounds(24, 75, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(185, 75, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblManageSpaces = new JLabel("Manage Spaces");
		lblManageSpaces.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblManageSpaces.setBounds(24, 11, 174, 39);
		panel.add(lblManageSpaces);
		
		JLabel lblAddSpace = new JLabel("Add Space ");
		lblAddSpace.setBounds(24, 61, 66, 14);
		panel.add(lblAddSpace);
		
		JLabel lblRemoveSpaces = new JLabel("Remove Space");
		lblRemoveSpaces.setBounds(185, 61, 102, 14);
		panel.add(lblRemoveSpaces);
		
		JLabel warning = new JLabel("");
		warning.setBounds(21, 157, 190, 14);
		panel.add(warning);
		
		
		
		JButton btnNewButton_1 = new JButton("Remove Space");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(s.isOccupied(textField_1.getText())) {
					//s.removespace(textField_1.getText());
					warning.setText("sorry that space is reserved");
					warning.setForeground(Color.RED);
					
				}else {
					s.removespace(textField_1.getText());
				}
				
			}
		});
		btnNewButton_1.setBounds(185, 106, 117, 23);
		panel.add(btnNewButton_1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JButton btnNewButton = new JButton("Add Space");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				s.addSpace(textField.getText());
				
				
			}
		});
		btnNewButton.setBounds(24, 106, 117, 23);
		panel.add(btnNewButton);
		

		
		
		
		
		
		
		
		
		
	}

}
