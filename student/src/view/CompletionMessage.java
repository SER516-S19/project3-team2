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

/**
 * Create the Message frame.
 * @author Manikanta
 * @return
 */

public class CompletionMessage extends JFrame {
	private JPanel contentPane;

	public CompletionMessage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 150, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void MessageDisplay(JButton completionButton) {
		contentPane.setVisible(true);
		JLabel messageLabel = new JLabel("<html>Congratulations!!<br/> your quiz is completed</html>");
		messageLabel.setBounds(149, 20, 207, 52);
		contentPane.add(messageLabel);
		completionButton.setBounds(150, 100, 83, 23);
		contentPane.add(completionButton);
	}
}