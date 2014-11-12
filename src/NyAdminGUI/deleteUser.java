package NyAdminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class deleteUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


	/**
	 * Create the frame.
	 */
	public deleteUser() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRemoveEvent = new JButton("Remove user");
		btnRemoveEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			//searchresult.getSelecetedIndex();
			//Logic.removeUser();
			dispose();
			}
		});
		btnRemoveEvent.setBounds(372, 643, 146, 29);
		contentPane.add(btnRemoveEvent);
		
		textField = new JTextField();
		textField.setBounds(139, 64, 368, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSearchEvent = new JLabel("Enter username");
		lblSearchEvent.setBounds(19, 70, 129, 16);
		contentPane.add(lblSearchEvent);
		
		JButton btnSearch = new JButton("Search and destroy");
		btnSearch.setBounds(226, 93, 206, 29);
		contentPane.add(btnSearch);
		
		String [] columnNames = {"Username", "Date created", "Class"};
		
		//DB should fill the table with data
		Object data [][] = {
				{"Jonathan Kwok", "12/11/2014", "DØK 13"},
				{null, null, null}
		};
		JTable searchResult = new JTable (data, columnNames);
		searchResult.setBounds(19, 166, 499, 465);
		contentPane.add(searchResult);
		searchResult.setRowHeight(30);
		
		JLabel lblEventName = new JLabel("Userame");
		lblEventName.setBounds(19, 138, 86, 16);
		contentPane.add(lblEventName);
		
		JLabel lblCreatedBy = new JLabel("Date created");
		lblCreatedBy.setBounds(269, 138, 95, 16);
		contentPane.add(lblCreatedBy);
		
		JLabel lblForceRemoveEvent = new JLabel("Force remove user");
		lblForceRemoveEvent.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblForceRemoveEvent.setBounds(19, 18, 256, 34);
		contentPane.add(lblForceRemoveEvent);
		
		JButton btnReturnToMenu = new JButton("Return to menu");
		btnReturnToMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			dispose();
			}
		});
		btnReturnToMenu.setBounds(19, 643, 146, 29);
		contentPane.add(btnReturnToMenu);
	
		
	}
}
