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

public class deleteEvent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteEvent frame = new deleteEvent();
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
	public deleteEvent() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRemoveEvent = new JButton("Remove Event");
		btnRemoveEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			//searchresult.getSelecetedIndex();
			//Logic.removeEvent(removeEventID)	<-- Method missing for removing event
			dispose();
			}
		});
		btnRemoveEvent.setBounds(372, 643, 146, 29);
		contentPane.add(btnRemoveEvent);
		
		textField = new JTextField();
		textField.setBounds(139, 64, 368, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSearchEvent = new JLabel("Enter event name");
		lblSearchEvent.setBounds(19, 70, 129, 16);
		contentPane.add(lblSearchEvent);
		
		JButton btnSearch = new JButton("Search and destroy");
		btnSearch.setBounds(226, 93, 206, 29);
		contentPane.add(btnSearch);
		
		String [] columnNames = {"Event Name", "Created by"};
		
		//DB should fill the table with data
		Object data [][] = {
				{"Distributed Systems eksamen", "Henrik Thorn"},
				{"Cafe Nexus", "Jonathan Kwok"},
				{null, null, null}
		};
		JTable searchResult = new JTable (data, columnNames);
		searchResult.setBounds(19, 166, 499, 465);
		contentPane.add(searchResult);
		searchResult.setRowHeight(30);
		
		JLabel lblEventName = new JLabel("Event Name");
		lblEventName.setBounds(19, 138, 86, 16);
		contentPane.add(lblEventName);
		
		JLabel lblCreatedBy = new JLabel("Created By");
		lblCreatedBy.setBounds(269, 138, 95, 16);
		contentPane.add(lblCreatedBy);
		
		JLabel lblForceRemoveEvent = new JLabel("Force remove event");
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
