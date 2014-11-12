package NyAdminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

public class mainMenu extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public mainMenu() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(6, 443, 117, 29);
		contentPane.add(btnExit);
		
		JButton btnUserlist = new JButton("Users list");
		btnUserlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showAllUsers showallusers = new showAllUsers();
				showallusers.setVisible(true);
			}
		});
		btnUserlist.setBounds(315, 111, 117, 29);
		contentPane.add(btnUserlist);
		
		JLabel lblMainMenu = new JLabel("CBS Calendar ");
		lblMainMenu.setFont(new Font("Lucida Grande", Font.ITALIC, 18));
		lblMainMenu.setBounds(6, 6, 167, 29);
		contentPane.add(lblMainMenu);
		
		JButton btnLogout = new JButton("Log out");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login login = new Login();
				login.setVisible(true);
				Logic.adminSignedIn = false;
			}
		});
		btnLogout.setBounds(327, 443, 117, 29);
		contentPane.add(btnLogout);
		
		JButton btnNoteList = new JButton("Notes list");
		btnNoteList.setBounds(315, 152, 117, 29);
		contentPane.add(btnNoteList);
		
		JButton btnViewAllEvents = new JButton("View all events");
		btnViewAllEvents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				viewAllEvents viewAllEvents = new viewAllEvents();
				viewAllEvents.setVisible(true);
			}
		});
		btnViewAllEvents.setBounds(6, 70, 117, 29);
		contentPane.add(btnViewAllEvents);
		
		JButton btnCreateUser = new JButton("Create user");
		btnCreateUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createUser createUser = new createUser();
				createUser.setVisible(true);
				//dispose();
			}
		});
		btnCreateUser.setBounds(315, 70, 117, 29);
		contentPane.add(btnCreateUser);
		
		JButton btnDeleteUser = new JButton("Delete user");
		btnDeleteUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deleteUser deleteuser = new deleteUser();
				deleteuser.setVisible(true);
			}
		});
		btnDeleteUser.setBounds(6, 152, 117, 29);
		contentPane.add(btnDeleteUser);
		
		JButton btnDeleteEvent = new JButton("Delete event");
		btnDeleteEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deleteEvent deleteevent = new deleteEvent();
				deleteevent.setVisible(true);
			}
		});
		btnDeleteEvent.setBounds(6, 111, 117, 29);
		contentPane.add(btnDeleteEvent);
		
		JButton btnChangePassword = new JButton("Change password");
		btnChangePassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeAdminPassword changeadminpassword = new changeAdminPassword();
				changeadminpassword.setVisible(true);
			}
		});
		btnChangePassword.setBounds(181, 443, 155, 29);
		contentPane.add(btnChangePassword);
		
		JLabel lblAdministratorMenu = new JLabel("Administrator Menu");
		lblAdministratorMenu.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblAdministratorMenu.setBounds(6, 35, 167, 16);
		contentPane.add(lblAdministratorMenu);
		

	}
}
