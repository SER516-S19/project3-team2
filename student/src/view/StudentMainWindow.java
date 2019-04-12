package src.view;

/**
 Student's quiz selection view
 @author Sakshi/Subhradeep
 @version 1.2
 @date 04/09/2019
 */

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.*;
import src.model.StudentModel;
import src.view.TakeQuizView;
import src.controller.StudentController;

public class StudentMainWindow extends JFrame {
	private String[] choices = new String[100];
    private JComboBox<String> quizList = new JComboBox<String>();
	private JButton okBtn = new JButton("OK");
    int x, y;

    public StudentMainWindow() {
    	JPanel contentPane = new JPanel();
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(490, 50, 900, 950);
        setTitle("Student Window For Quiz Application");
        setResizable(false);
        contentPane.setEnabled(false);
        contentPane.setBackground(new Color(70, 130, 180));
        contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setUndecorated(true);

        quizList.setVisible(true);
        contentPane.add(quizList);
        
        okBtn.setEnabled(false);
        contentPane.add(okBtn);

        quizList.setFont(new Font("Monospaced", Font.BOLD, 30));
        quizList.setBounds(238, 436, 305, 49);
        quizList.setForeground(new Color(255, 255, 255));
        quizList.setBackground(new Color(0, 181, 204));
        quizList.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
        okBtn.setFont(new Font("Monospaced", Font.BOLD, 24));
        okBtn.setForeground(Color.WHITE);
        okBtn.setBackground(new Color(0, 181, 204));
        okBtn.setBounds(238, 550, 305, 49);
        okBtn.setEnabled(true);
        contentPane.add(quizList);

        JLabel welcomeLabel = new JLabel("Hello Student!");
        welcomeLabel.setBounds(150, 239, 672, 80);
        welcomeLabel.setFont(new Font("Courier", Font.BOLD, 70));
        welcomeLabel.setForeground(new Color(240, 248, 255));
        contentPane.add(welcomeLabel);

        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        panel.setBackground(new Color(37, 116, 169));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
        });

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int xx = e.getXOnScreen();
                int yy = e.getYOnScreen();
                setLocation(xx-x, yy-y);
            }
        });

        panel.setBounds(0, 0, 900, 43);
        contentPane.add(panel);
        panel.setLayout(null);

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
        panel.add(closeBtn);

        JLabel header = new JLabel("  Quiz Desktop Application - Student Window");
        header.setFont(new Font("Monospaced", Font.BOLD, 16));
        header.setForeground(Color.WHITE);
        header.setBounds(0, 0, 525, 43);
        panel.add(header);
    }
    
    public void setQuizNames(String[] quizNames){
        this.choices = quizNames;
    }
    
    public String[] getQuizChoices(){
        return this.choices;
    }
    
    public void setQuizField(String[] choices){
        this.quizList.removeAll();
        for (int i = 0; i<choices.length; i++)
        	this.quizList.addItem(choices[i]);
    }
    
    public String getQuizName(){
        return quizList.getSelectedItem().toString();
    }

    public void selectQuizListener(ActionListener listenForOkButton){
    	okBtn.addActionListener(listenForOkButton);
    }
    
    public void displayErrorMessage(String errorMessage){
    	        JOptionPane.showMessageDialog(this, errorMessage);
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run() {
                try {
                    StudentMainWindow frame = new StudentMainWindow();
                    frame.setVisible(true);
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    int screenHeight = screenSize.height;
                    int screenWidth = screenSize.width;
                    frame.setSize((7*screenWidth) / 15, (8*screenHeight) / 9);
                    TakeQuiz theView = new TakeQuiz();
                    frame.getContentPane().setBackground(new Color(255, 255, 204));
                    TakeQuizView theView = new TakeQuizView();
                    StudentModel theModel = new StudentModel();
                    CompletionMessage theMessage = new CompletionMessage();
                    StudentController theController = new StudentController(theModel, frame, theView, theMessage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
