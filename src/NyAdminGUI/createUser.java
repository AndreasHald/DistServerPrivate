package NyAdminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class createUser extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldRepeat;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createUser frame = new createUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public createUser() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterNewUsername = new JLabel("Enter new username");
		lblEnterNewUsername.setBounds(112, 133, 126, 16);
		contentPane.add(lblEnterNewUsername);
		
		JLabel lblEnterNewPassword = new JLabel("Enter new password");
		lblEnterNewPassword.setBounds(112, 171, 126, 16);
		contentPane.add(lblEnterNewPassword);
		
		JLabel lblRepeatPassword = new JLabel("Repeat password");
		lblRepeatPassword.setBounds(112, 208, 126, 16);
		contentPane.add(lblRepeatPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(269, 202, 156, 28);
		contentPane.add(passwordField);
		
		passwordFieldRepeat = new JPasswordField();
		passwordFieldRepeat.setBounds(269, 165, 156, 28);
		contentPane.add(passwordFieldRepeat);
		
		textField = new JTextField();
		textField.setBounds(269, 127, 156, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCreateNewUser = new JLabel("Create new user");
		lblCreateNewUser.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblCreateNewUser.setBounds(37, 50, 297, 46);
		contentPane.add(lblCreateNewUser);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(37, 249, 117, 29);
		contentPane.add(btnCancel); 
		
		JButton btnCreateUser = new JButton("Create user");
		btnCreateUser.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				String passwordRepeat = passwordFieldRepeat.getText();
				String password = passwordField.getText();
				String username = textField.getText();
					
					if (Logic.createUser(username, password, passwordRepeat)){
						dispose(); //Close window and return to menu
					}else{
						
					}
				}
			
		});
		btnCreateUser.setBounds(308, 249, 117, 29);
		contentPane.add(btnCreateUser);
	}
}
