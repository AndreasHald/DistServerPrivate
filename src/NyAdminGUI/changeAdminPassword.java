package NyAdminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class changeAdminPassword extends JFrame {

	private JPanel contentPane;
	private JPasswordField currentPasswordField;
	private JPasswordField newPasswordField;
	private JPasswordField passwordFieldRepeat;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public changeAdminPassword() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		currentPasswordField = new JPasswordField();
		currentPasswordField.setBounds(193, 82, 200, 28);
		contentPane.add(currentPasswordField);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setBounds(193, 122, 200, 28);
		contentPane.add(newPasswordField);
		
		passwordFieldRepeat = new JPasswordField();
		passwordFieldRepeat.setBounds(193, 162, 200, 28);
		contentPane.add(passwordFieldRepeat);
		
		JLabel lblEnterCurrentPassword = new JLabel("Enter current password");
		lblEnterCurrentPassword.setBounds(26, 88, 155, 16);
		contentPane.add(lblEnterCurrentPassword);
		
		JLabel lblNewLabel = new JLabel("Enter new password");
		lblNewLabel.setBounds(26, 128, 155, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblRepeatPassword = new JLabel("Repeat password");
		lblRepeatPassword.setBounds(26, 168, 155, 16);
		contentPane.add(lblRepeatPassword);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(6, 243, 155, 29);
		contentPane.add(btnCancel);
		
		JButton btnChangePassword = new JButton("Change password");
		btnChangePassword.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(Logic.changeAdminPassword(currentPasswordField.getText(),
						newPasswordField.getText(), passwordFieldRepeat.getText())){
					dispose();
				}
				
				
				
			}
		});
		btnChangePassword.setBounds(278, 243, 166, 29);
		contentPane.add(btnChangePassword);
		
		JLabel lblChangeAdministratorPassword = new JLabel("Change administrator password");
		lblChangeAdministratorPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblChangeAdministratorPassword.setBounds(26, 22, 250, 29);
		contentPane.add(lblChangeAdministratorPassword);
	}
}
