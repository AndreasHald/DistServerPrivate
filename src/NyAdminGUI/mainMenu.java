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

public class mainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainMenu frame = new mainMenu();
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
	public mainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		btnExit.setBounds(6, 243, 117, 29);
		contentPane.add(btnExit);
		
		JButton btnUserlist = new JButton("User list");
		btnUserlist.setBounds(6, 55, 117, 29);
		contentPane.add(btnUserlist);
		
		JLabel lblMainMenu = new JLabel("Main menu");
		lblMainMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblMainMenu.setBounds(181, 6, 117, 29);
		contentPane.add(lblMainMenu);
		
		JButton btnLogout = new JButton("Log out");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btnLogout.setBounds(327, 243, 117, 29);
		contentPane.add(btnLogout);
		
		JButton btnNoteList = new JButton("Note list");
		btnNoteList.setBounds(6, 84, 117, 29);
		contentPane.add(btnNoteList);
		
		JButton btnViewAllEvents = new JButton("View all events");
		btnViewAllEvents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				viewAllEvents vAE = new viewAllEvents();
				vAE.setVisible(true);
			}
		});
		btnViewAllEvents.setBounds(6, 113, 117, 29);
		contentPane.add(btnViewAllEvents);
		
		JButton btnCreateUser = new JButton("Create user");
		btnCreateUser.setBounds(6, 195, 117, 29);
		contentPane.add(btnCreateUser);
		
		JButton btnDeleteUser = new JButton("Delete user");
		btnDeleteUser.setBounds(6, 168, 117, 29);
		contentPane.add(btnDeleteUser);
		
		JButton btnDeleteEvent = new JButton("Delete event");
		btnDeleteEvent.setBounds(6, 140, 117, 29);
		contentPane.add(btnDeleteEvent);
		
		JButton btnGoToImgur = new JButton("Go to imgur");
		btnGoToImgur.setBounds(327, 55, 117, 29);
		contentPane.add(btnGoToImgur);
		
		JButton btnChangePassword = new JButton("Change password");
		btnChangePassword.setBounds(327, 195, 117, 29);
		contentPane.add(btnChangePassword);
	}

}
