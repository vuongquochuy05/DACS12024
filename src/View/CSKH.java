package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CSKH extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	private JTextField textField;
	public JMenuBar menuBar;
	public JMenu mnNewMenu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CSKH frame = new CSKH();
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
	public CSKH() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1264, 636);
		setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Trang chủ");
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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1250, 599);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setForeground(new Color(0, 255, 255));
		panel_1.setBounds(0, 0, 1263, 67);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hỗ trợ khách hàng");
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 32));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(151, 0, 458, 67);
		panel_1.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(112, 78, 1046, 409);
		panel.add(textArea);
		
		textField = new JTextField();
		textField.setBounds(112, 498, 932, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Gửi");
		btnNewButton.setBounds(1069, 498, 89, 32);
		panel.add(btnNewButton);
	}
}