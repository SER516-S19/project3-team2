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
	 * Create the Message frame.
	 * @return 
	 */
	public CompletionMessage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(25, 25, 1025, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public void MessageDisplay(JButton completionButton) {
		System.out.println("yo2");
		contentPane.setVisible(true);
		JLabel messageLabel = new JLabel("Congratulations your Quiz is completed");
		messageLabel.setBounds(149, 86, 207, 52);
		contentPane.add(messageLabel);
		
		completionButton.setBounds(165, 176, 121, 23);
		contentPane.add(completionButton);
	}

}