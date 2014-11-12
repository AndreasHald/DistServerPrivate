package NyAdminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class errorMessage extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public errorMessage(String errorMessage) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnYesSir = new JButton("Yes sir!");
		btnYesSir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnYesSir.setBounds(166, 221, 117, 29);
		contentPane.add(btnYesSir);
		
		JLabel errorMessageLabel = new JLabel(errorMessage);
		errorMessageLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		errorMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorMessageLabel.setBounds(6, 102, 438, 61);
		contentPane.add(errorMessageLabel);
		
		JLabel lblSpecialMessageFor = new JLabel("Special message for you!");
		lblSpecialMessageFor.setBounds(6, 26, 182, 16);
		contentPane.add(lblSpecialMessageFor);
	}

}
