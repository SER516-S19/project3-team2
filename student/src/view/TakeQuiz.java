package src.view;

import src.model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TakeQuiz extends JFrame {	
	
	private JLabel lblQuizName = new JLabel();
    private JLabel questionField = new JLabel();
    private JRadioButton [] optionField = new JRadioButton[4];
    JButton btnNext = new JButton("Next");

    public TakeQuiz() {
    	
    	JPanel contentPane;
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(25, 25, 1025, 500);
        
        setResizable(false);
	        	
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(5, 5, 1, 834);
        contentPane.add(layeredPane);

        lblQuizName.setFont(new Font("Courier", Font.BOLD, 40));
        lblQuizName.setBounds(310, 50, 600, 80);
        lblQuizName.setForeground(Color.BLACK);
        contentPane.add(lblQuizName);

        questionField.setBounds(320, 186, 300, 50);
        questionField.setForeground(Color.BLACK);
        contentPane.add(questionField);
        
        for(int i = 0; i < 4; i++) {
        	optionField[i] = new JRadioButton();
        	optionField[i].setBounds(320, 230 + i*30, 146, 26);
        	contentPane.add(optionField[i]);
        }
        
        JButton btnGiveUp = new JButton("GiveUp");
        btnGiveUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JComponent comp = (JComponent) e.getSource();
            	Window win = SwingUtilities.getWindowAncestor(comp);
            	win.dispose();
            }
        });
        btnGiveUp.setBounds(300, 414, 140, 29);
        contentPane.add(btnGiveUp);

        questionField.setEnabled(false);
        
        btnNext.setBounds(500, 414, 140, 29);
        contentPane.add(btnNext);
		
		JButton btnDashboard = new JButton("DashBoard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentMainWindow DashBoard=new StudentMainWindow();
				setVisible(false);
				DashBoard.setVisible(true);
			}
		});
		btnDashboard.setBounds(700, 414, 140, 29);
		contentPane.add(btnDashboard);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnExit.setBounds(300, 414, 140, 29);
		contentPane.add(btnExit);
    }
    
    public void setQuizLabel(String quizName) {
    	this.lblQuizName.setText(quizName);
    }
    
    public void setQuestionField(String questionText) {
    	this.questionField.setText(questionText);
    }
    
    public void setRadioOption(String ansOptionText, int index) {
    	optionField[index].setText(ansOptionText);
    }

    public String getRadioOption(int index) {
    	return optionField[index].getText();
    }
    public boolean getSelected(int index) {
    	return optionField[index].isSelected();
    }
    public void nextQuestionListener(ActionListener listenForNextButton){
    	btnNext.addActionListener(listenForNextButton);
    }
    
    public void displayCompletionMessage(String completionMsg, String title){
    	JOptionPane.showMessageDialog(null,completionMsg,title, JOptionPane.INFORMATION_MESSAGE);
    }
    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
