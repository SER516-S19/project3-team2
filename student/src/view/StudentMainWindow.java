package src.view;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class StudentMainWindow extends JFrame {
    private JPanel contentPane;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run() {
                try {
                    StudentMainWindow frame = new StudentMainWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public StudentMainWindow() {
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(490, 50, 900, 950);
        setTitle("Student Window For Quiz Application");
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setEnabled(false);
        contentPane.setBackground(new Color(70, 130, 180));
        contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        setContentPane(contentPane);
        setUndecorated(true);
        String[] choices = { "Select Quiz","Quiz 1","Quiz 2", "Quiz 3","Quiz 4","Quiz 5","Quiz 6"};
        final JComboBox<String> cb = new JComboBox<String>(choices);
        cb.setVisible(true);
        JButton btn = new JButton("OK");
        btn.setEnabled(false);
        btn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        btn.setFont(new Font("Monospaced", Font.BOLD, 24));
        btn.setForeground(new Color(255, 255, 255));
        btn.setBackground(new Color(129, 207, 224));
        btn.setBounds(238, 550, 305, 49);
        contentPane.add(btn);
        cb.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent event ) {
                final boolean enabled = cb.getSelectedIndex() == 0;
                btn.setEnabled( !enabled );
            }
        } );
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TakeQuiz().setVisible(true);
            }
        });
        contentPane.setLayout(null);
        cb.setFont(new Font("Courier", Font.BOLD, 25));
        cb.setBounds(238, 436, 305, 49);
        cb.setForeground(new Color(255, 255, 255));
        cb.setBackground(new Color(129, 207, 224));
        cb.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        btn.setFont(new Font("Monospaced", Font.BOLD, 30));
        contentPane.add(cb);
        JLabel welcomeLabel = new JLabel("Hello Student!");
        welcomeLabel.setBounds(150, 239, 672, 80);
        welcomeLabel.setFont(new Font("Courier", Font.BOLD, 70));
        welcomeLabel.setForeground(new Color(240, 248, 255));
        contentPane.add(welcomeLabel);
        JButton btnNewButton = new JButton("  Quiz Desktop Application - Student Window");
        btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
        btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 20));
        btnNewButton.setBackground(new Color(89, 171, 227));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setBounds(0, 0, 823, 41);
        contentPane.add(btnNewButton);
        JButton btnNewButton_1 = new JButton("X");
        btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setBackground(new Color(255, 102, 102));
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        btnNewButton_1.setBounds(822, 0, 78, 41);
        contentPane.add(btnNewButton_1);
    }
}