package src.view;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentMainWindow extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run() {
                try {
                    StudentMainWindow frame = new StudentMainWindow();
                    frame.setVisible(true);
                    frame.getContentPane().setBackground(new Color(255, 255, 204));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public StudentMainWindow() {
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 1820, 900);
        setTitle("Student Window For Quiz Application");
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        String[] choices = { "Select Quiz","Quiz 1","Quiz 2", "Quiz 3","Quiz 4","Quiz 5","Quiz 6"};

        final JComboBox<String> cb = new JComboBox<String>(choices);
        cb.setVisible(true);
        contentPane.add(cb);
        JButton btn = new JButton("OK");
        btn.setEnabled(false);
        contentPane.add(btn);
        cb.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent event ) {
                // Your logic to determine when to enable/disable:
                final boolean enabled = cb.getSelectedIndex() == 0;
                btn.setEnabled( !enabled );
            }
        } );
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TakeQuiz(choices[cb.getSelectedIndex()]).setVisible(true);
            }
        });
        cb.setFont(new Font("Courier", Font.BOLD, 25));
        cb.setBounds(570, 400, 420, 50);
        cb.setForeground(Color.BLACK);
        cb.setBackground(new Color(51, 204, 204));
        cb.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        btn.setFont(new Font("Courier", Font.BOLD, 25));
        btn.setBounds(570, 500, 420, 50);
        btn.setForeground(Color.BLACK);
        btn.setBackground(new Color(51, 204, 204));
        btn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        contentPane.add(cb);

        JLabel welcomeLabel = new JLabel("Hello Student!");
        welcomeLabel.setFont(new Font("Courier", Font.BOLD, 70));
        welcomeLabel.setBounds(570, 200, 900, 80);
        welcomeLabel.setForeground(Color.BLACK);
        contentPane.add(welcomeLabel);
    }

}
