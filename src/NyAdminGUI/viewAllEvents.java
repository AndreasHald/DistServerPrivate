package NyAdminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class viewAllEvents extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public viewAllEvents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		String [] columnNames = {"Event name", "Location", "Created by"};
		Object[][] data = {
				{"Event name", "Location", "Created by"},
				{null, null,null},
				{null, null,null},
				{null, null,null},
				{null, null,null},
				{null, null,null},
		};
		contentPane.setLayout(null);
		
		JTable eventTable = new JTable(data, columnNames);
		eventTable.setBounds(6, 85, 538, 443);
		contentPane.add(eventTable);
		eventTable.setRowHeight(16);
		eventTable.setShowGrid(true);
		
		JButton btnReturnToMenu = new JButton("Return to menu");
		btnReturnToMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				mainMenu mM = new mainMenu();
				mM.setVisible(true);
				dispose();
			}
		});
		btnReturnToMenu.setBounds(403, 593, 141, 29);
		contentPane.add(btnReturnToMenu);
		
		JButton btnRemoveEvent = new JButton("Remove event");
		btnRemoveEvent.setBounds(6, 593, 124, 29);
		contentPane.add(btnRemoveEvent);
		
		JLabel lblShowAllUser = new JLabel("Displaying all user created events");
		lblShowAllUser.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblShowAllUser.setBounds(6, 21, 464, 52);
		contentPane.add(lblShowAllUser);
	
		
	}
}
