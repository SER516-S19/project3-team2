package src.view;

import src.model.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;


public class TakeQuizView extends JFrame {
    int x1,y1;
	private JLabel lblQuizName = new JLabel();
    private JLabel questionField = new JLabel();
    private JRadioButton [] optionField = new JRadioButton[4];
    JButton btnNext = new JButton("Next");
    public ButtonGroup buttonGroup = new ButtonGroup();
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TakeQuizView frame = new TakeQuizView();
                    frame.setVisible(true);
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    int screenHeight = screenSize.height;
                    int screenWidth = screenSize.width;
                    frame.setSize((7*screenWidth) / 15, (8*screenHeight) / 9);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public TakeQuizView() {
    	
    	JPanel contentPane;
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(490, 50, 900, 950);
        setUndecorated(true);
        setResizable(false);
        setTitle("Student Window For Quiz Application");
        setVisible(true);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(70, 130, 180));
        contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(5, 5, 1, 834);
        contentPane.add(layeredPane);

        lblQuizName.setFont(new Font("Courier", Font.BOLD, 50));
        lblQuizName.setBounds(325, 150, 600, 80);
        lblQuizName.setForeground(Color.WHITE);
        contentPane.add(lblQuizName);

        questionField.setFont(new Font("Courier", Font.BOLD, 30));
        questionField.setBounds(250, 315, 300, 50);
        questionField.setForeground(new Color(255, 255, 255));
        contentPane.add(questionField);
        
        for(int i = 0; i < 4; i++) {
        	optionField[i] = new JRadioButton();
            optionField[i].setBounds(275, 380 + i*30, 146, 26);
        	buttonGroup.add(optionField[i]);
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
        btnGiveUp.setBounds(225, 600, 200, 49);
        btnGiveUp.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        btnGiveUp.setFont(new Font("Monospaced", Font.BOLD, 24));
        btnGiveUp.setForeground(new Color(255, 255, 255));
        btnGiveUp.setBackground(new Color(0, 181, 204));
        contentPane.add(btnGiveUp);

        questionField.setEnabled(false);

        btnNext.setBounds(500, 600, 200, 49);
        btnNext.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        btnNext.setFont(new Font("Monospaced", Font.BOLD, 24));
        btnNext.setForeground(new Color(255, 255, 255));
        btnNext.setBackground(new Color(0, 181, 204));
        contentPane.add(btnNext);

        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 0, 900, 43);
        panel2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        panel2.setBackground(new Color(37, 116, 169));
        panel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
            }
        });

        panel2.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int xx1 = e.getXOnScreen();
                int yy1 = e.getYOnScreen();
                setLocation(xx1-x1, yy1-y1);
            }
        });
        contentPane.add(panel2);
        panel2.setLayout(null);

        JLabel closeBtn = new JLabel("X");
        closeBtn.setForeground(Color.WHITE);
        closeBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                dispose();
            }
        });

        closeBtn.setFont(new Font("Tahoma", Font.BOLD, 30));
        closeBtn.setHorizontalAlignment(SwingConstants.CENTER);
        closeBtn.setBounds(846, 0, 54, 43);
        panel2.add(closeBtn);

        JLabel header = new JLabel("  Quiz Desktop Application - Student Window");
        header.setFont(new Font("Monospaced", Font.BOLD, 16));
        header.setForeground(Color.WHITE);
        header.setBounds(0, 0, 525, 43);
        panel2.add(header);
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
