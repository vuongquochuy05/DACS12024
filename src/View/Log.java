package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Log extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log frame = new Log();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Log() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 255));
		panel.setBounds(0, 0, 218, 275);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Admin\\eclipse\\DACS1\\src\\icon\\icons8-bus-100.png"));
		lblNewLabel_2.setBounds(44, 80, 100, 100);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Admin\\eclipse\\DACS1\\src\\icon\\icons8-ticket-100.png"));
		lblNewLabel_1.setBounds(84, 31, 100, 100);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Đăng Nhập");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(246, 105, 208, 47);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User u = new User();
				u.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBackground(new Color(102, 204, 255));
		btnNewButton.setBounds(228, 179, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Admin");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin a = new Admin();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1.setBackground(new Color(102, 204, 255));
		btnNewButton_1.setBounds(337, 179, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Admin\\eclipse\\DACS1\\src\\icon\\icons8-users-100.png"));
		lblNewLabel_4.setBounds(283, 11, 100, 100);
		contentPane.add(lblNewLabel_4);
	}
}
