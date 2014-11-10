package NyAdminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import GUI.MainMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	
	public Login() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPassword = new JLabel("Enter administrator password in order to enter...");
		lblPassword.setBounds(91, 90, 340, 16);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(91, 113, 357, 28);
		contentPane.add(passwordField);
		
		JLabel lblCBSlogo = new JLabel("");
		lblCBSlogo.setIcon(new ImageIcon(MainMenu.class.getResource("/Images/CBSLogo3.png")));
		lblCBSlogo.setBounds(17, 201, 279, 59);
		getContentPane().add(lblCBSlogo);
		
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
				
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				
				if(Logic.authenticateAdmin(password)){
					dispose();
					mainMenu mainmenu = new mainMenu();
					mainmenu.setVisible(true);
					Logic.adminSignedIn = true;
					dispose();
				}else if (!Logic.authenticateAdmin(password)){
					errorMessage passworddoesnotmatch = new errorMessage("The password does not match");
					passworddoesnotmatch.setVisible(true);
				}
				
			}
		});
		btnLogin.setBounds(427, 293, 117, 29);
		contentPane.add(btnLogin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(6, 293, 117, 29);
		contentPane.add(btnExit);
	}
	
	
}
