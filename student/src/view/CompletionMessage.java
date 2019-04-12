package src.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompletionMessage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompletionMessage frame = new CompletionMessage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the Message frame.
	 */
	public CompletionMessage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(25, 25, 1025, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel messageLabel = new JLabel("Congratulations your Quiz is completed");
		messageLabel.setBounds(149, 86, 207, 52);
		contentPane.add(lblNewLabel);
		
		JButton btnDashboard = new JButton("Ok");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentMainWindow DashBoard=new StudentMainWindow();
				setVisible(false);
				DashBoard.setVisible(true);
			}
		});
		btnDashboard.setBounds(165, 176, 121, 23);
		contentPane.add(btnDashboard);
	}

}