package src.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.CompoundBorder;
import java.awt.Toolkit;
import javax.swing.JTextField;

public class ProfessorMainWindow extends JFrame {
	private Image image;
	private JPanel contentPane;
	int x, y;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public ProfessorMainWindow() {	
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(490, 50, 900, 950);
		setTitle("Professor Window For Quiz Application");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setEnabled(false);
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));		
		setContentPane(contentPane);		
		setUndecorated(true);
		
		JButton createQuiz = new JButton(" Create Quiz");
		createQuiz.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		createQuiz.setToolTipText("Click Me");
		createQuiz.setIcon(new ImageIcon("image\\teacher.gif"));
		createQuiz.setBounds(236, 510, 434, 216);
		createQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddQuestionView().setVisible(true);
				dispose();			
			}
		});
		contentPane.setLayout(null);
		createQuiz.setFont(new Font("Monospaced", Font.BOLD, 30));
	    createQuiz.setForeground(new Color(255, 255, 255));
	    createQuiz.setBackground(new Color(0, 181, 204));
		contentPane.add(createQuiz);
		
		JLabel welcomeLabel = new JLabel("Hello Professor!");
		welcomeLabel.setBounds(126, 212, 672, 80);
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
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		
		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(846, 0, 54, 43);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("  Quiz Desktop Application - Professor Window");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 525, 43);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("To Create Quiz Enter Quiz Title");
		lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 30));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(165, 355, 563, 36);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Monospaced", Font.PLAIN, 24));
		textField.setBounds(236, 420, 434, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
	}	
}
