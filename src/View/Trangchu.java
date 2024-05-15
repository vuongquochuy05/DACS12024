package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Trangchu extends JFrame{

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Trangchu frame = new Trangchu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void datVe() {
		Datve d = new Datve();
		d.setVisible(true);
		dispose();
	}
	
	/**
	 * Create the frame.
	 */
	public Trangchu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1344, 630);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Trang chủ");
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 18));
		mnNewMenu.setForeground(new Color(0, 0, 0));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Hỗ trợ khách hàng");
		mnNewMenu_1.setForeground(new Color(0, 0, 0));
		mnNewMenu_1.setFont(new Font("Arial", Font.BOLD, 18));
		menuBar.add(mnNewMenu_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1344, 570);
		panel_1.setBackground(new Color(153, 255, 255));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 255, 204));
		panel_2.setBounds(38, 150, 379, 384);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("                    Tuyến Hồ Chí Minh");
		lblNewLabel_1.setBounds(10, 11, 352, 25);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Admin\\eclipse\\DACS1\\src\\Img\\HCM.jpg"));
		lblNewLabel_2.setBounds(10, 47, 362, 140);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 198, 362, 175);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Huế ");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(4, 10, 100, 23);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Đà Nẵng");
		lblNewLabel_3_1.setForeground(Color.BLACK);
		lblNewLabel_3_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(4, 50, 100, 23);
		panel_3.add(lblNewLabel_3_1);
		
		JButton btnNewButton = new JButton("Đặt vé");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datVe();
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnNewButton.setBounds(274, 10, 82, 23);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Đặt vé");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datVe();
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnNewButton_1.setBounds(274, 50, 82, 23);
		panel_3.add(btnNewButton_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Hà Nội");
		lblNewLabel_3_1_1.setForeground(Color.BLACK);
		lblNewLabel_3_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_3_1_1.setBounds(4, 90, 100, 23);
		panel_3.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Đà Lạt");
		lblNewLabel_3_1_2.setForeground(Color.BLACK);
		lblNewLabel_3_1_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_3_1_2.setBounds(4, 130, 100, 23);
		panel_3.add(lblNewLabel_3_1_2);
		
		JButton btnNewButton_1_1 = new JButton("Đặt vé");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datVe();
			}
		});
		btnNewButton_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(274, 90, 82, 23);
		panel_3.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Đặt vé");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datVe();
			}
		});
		btnNewButton_1_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnNewButton_1_2.setBounds(274, 130, 82, 23);
		panel_3.add(btnNewButton_1_2);
		
		JLabel lblNewLabel_4 = new JLabel("600k/người");
		lblNewLabel_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(140, 10, 102, 23);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("550k/người");
		lblNewLabel_4_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(140, 50, 102, 23);
		panel_3.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("950k/người");
		lblNewLabel_4_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_4_2.setBounds(140, 90, 102, 23);
		panel_3.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("350k/người");
		lblNewLabel_4_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_4_3.setBounds(140, 130, 102, 23);
		panel_3.add(lblNewLabel_4_3);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(0, 255, 204));
		panel_2_1.setBounds(460, 150, 379, 384);
		panel_2_1.setLayout(null);
		panel_1.add(panel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("                      Tuyến Đà Nẵng");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(10, 11, 352, 25);
		panel_2_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("D:\\Admin\\eclipse\\DACS1\\src\\Img\\DN.jpg"));
		lblNewLabel_2_1.setBounds(10, 42, 362, 140);
		panel_2_1.add(lblNewLabel_2_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 198, 362, 175);
		panel_2_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3_2 = new JLabel("Huế");
		lblNewLabel_3_2.setForeground(Color.BLACK);
		lblNewLabel_3_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_3_2.setBounds(4, 10, 100, 23);
		panel_4.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Hồ Chí Minh");
		lblNewLabel_3_3.setForeground(Color.BLACK);
		lblNewLabel_3_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_3_3.setBounds(4, 50, 100, 23);
		panel_4.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Hà Nội");
		lblNewLabel_3_4.setForeground(Color.BLACK);
		lblNewLabel_3_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_3_4.setBounds(4, 90, 100, 23);
		panel_4.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Đà Lạt");
		lblNewLabel_3_5.setForeground(Color.BLACK);
		lblNewLabel_3_5.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_3_5.setBounds(4, 130, 100, 23);
		panel_4.add(lblNewLabel_3_5);
		
		JButton btnNewButton_2 = new JButton("Đặt vé");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datVe();
			}
		});
		btnNewButton_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnNewButton_2.setBounds(274, 10, 82, 23);
		panel_4.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Đặt vé");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datVe();
			}
		});
		btnNewButton_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnNewButton_3.setBounds(274, 50, 82, 23);
		panel_4.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Đặt vé");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datVe();
			}
		});
		btnNewButton_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnNewButton_4.setBounds(274, 90, 82, 23);
		panel_4.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Đặt vé");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datVe();
			}
		});
		btnNewButton_5.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnNewButton_5.setBounds(274, 130, 82, 23);
		panel_4.add(btnNewButton_5);
		
		JLabel lblNewLabel_4_4 = new JLabel("  80k/người");
		lblNewLabel_4_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_4_4.setBounds(140, 10, 102, 23);
		panel_4.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_5 = new JLabel("550k/người");
		lblNewLabel_4_5.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_4_5.setBounds(140, 50, 102, 23);
		panel_4.add(lblNewLabel_4_5);
		
		JLabel lblNewLabel_4_6 = new JLabel("500k/người");
		lblNewLabel_4_6.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_4_6.setBounds(140, 90, 102, 23);
		panel_4.add(lblNewLabel_4_6);
		
		JLabel lblNewLabel_4_7 = new JLabel("600k/người");
		lblNewLabel_4_7.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_4_7.setBounds(140, 130, 102, 23);
		panel_4.add(lblNewLabel_4_7);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBackground(new Color(0, 255, 204));
		panel_2_1_1.setBounds(890, 150, 379, 384);
		panel_1.add(panel_2_1_1);
		panel_2_1_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("                      Tuyến Hà Nội");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(10, 11, 352, 25);
		panel_2_1_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon("D:\\Admin\\eclipse\\DACS1\\src\\Img\\HN.jpg"));
		lblNewLabel_2_1_1.setBounds(10, 37, 362, 140);
		panel_2_1_1.add(lblNewLabel_2_1_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 198, 362, 175);
		panel_2_1_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Huế");
		lblNewLabel_3_2_1.setForeground(Color.BLACK);
		lblNewLabel_3_2_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_3_2_1.setBounds(4, 10, 100, 23);
		panel_5.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("Đà Nẵng");
		lblNewLabel_3_2_2.setForeground(Color.BLACK);
		lblNewLabel_3_2_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_3_2_2.setBounds(4, 50, 100, 23);
		panel_5.add(lblNewLabel_3_2_2);
		
		JLabel lblNewLabel_3_2_3 = new JLabel("Hồ Chí Minh");
		lblNewLabel_3_2_3.setForeground(Color.BLACK);
		lblNewLabel_3_2_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_3_2_3.setBounds(4, 90, 100, 23);
		panel_5.add(lblNewLabel_3_2_3);
		
		JLabel lblNewLabel_3_2_4 = new JLabel("Đà Lạt");
		lblNewLabel_3_2_4.setForeground(Color.BLACK);
		lblNewLabel_3_2_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_3_2_4.setBounds(4, 130, 100, 23);
		panel_5.add(lblNewLabel_3_2_4);
		
		JButton btnNewButton_2_1 = new JButton("Đặt vé");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datVe();
			}
		});
		btnNewButton_2_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnNewButton_2_1.setBounds(274, 10, 82, 23);
		panel_5.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Đặt vé");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datVe();
			}
		});
		btnNewButton_2_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnNewButton_2_2.setBounds(274, 50, 82, 23);
		panel_5.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("Đặt vé");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datVe();
			}
		});
		btnNewButton_2_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnNewButton_2_3.setBounds(274, 90, 82, 23);
		panel_5.add(btnNewButton_2_3);
		
		JButton btnNewButton_2_4 = new JButton("Đặt vé");
		btnNewButton_2_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datVe();
			}
		});
		btnNewButton_2_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnNewButton_2_4.setBounds(274, 130, 82, 23);
		panel_5.add(btnNewButton_2_4);
		
		JLabel lblNewLabel_4_8 = new JLabel("450k/người");
		lblNewLabel_4_8.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_4_8.setBounds(140, 10, 102, 23);
		panel_5.add(lblNewLabel_4_8);
		
		JLabel lblNewLabel_4_9 = new JLabel("500k/người");
		lblNewLabel_4_9.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_4_9.setBounds(140, 50, 102, 23);
		panel_5.add(lblNewLabel_4_9);
		
		JLabel lblNewLabel_4_10 = new JLabel("950k/người");
		lblNewLabel_4_10.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_4_10.setBounds(140, 90, 102, 23);
		panel_5.add(lblNewLabel_4_10);
		
		JLabel lblNewLabel_4_11 = new JLabel("850k/người");
		lblNewLabel_4_11.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_4_11.setBounds(140, 130, 102, 23);
		panel_5.add(lblNewLabel_4_11);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Admin\\eclipse\\DACS1\\src\\Img\\head.jpg"));
		lblNewLabel.setBounds(0, 0, 1344, 70);
		panel_1.add(lblNewLabel);
		

	}
}