package NyAdminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(150, 74, 86, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(150, 114, 61, 16);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(223, 68, 208, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(223, 108, 208, 28);
		contentPane.add(passwordField);
		
		JLabel lblAdministratorBrugerMenu = new JLabel("Administrator bruger menu");
		lblAdministratorBrugerMenu.setBounds(6, 16, 205, 16);
		contentPane.add(lblAdministratorBrugerMenu);
		
		JLabel lblErDuIkke = new JLabel("Er du ikke administrator skal du gå væk");
		lblErDuIkke.setBounds(6, 44, 265, 16);
		contentPane.add(lblErDuIkke);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String username = textField.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				
				if(Logic.authenticateAdmin(username, password) == true){
					mainMenu mainmenu = new mainMenu();
					mainmenu.setVisible(true);
					dispose();
				}else if (Logic.authenticateAdmin(username, password) == false){
					System.out.println("error");
					System.out.println(username + password);
				
				}
				
			}
		});
		btnLogin.setBounds(427, 293, 117, 29);
		contentPane.add(btnLogin);
	}
}
