package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	private String user;
	private String pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 255));
		panel.setBounds(0, 0, 218, 275);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Admin\\eclipse\\DACS1\\src\\icon\\icons8-bus-100.png"));
		lblNewLabel_4.setBounds(44, 80, 100, 100);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Admin\\eclipse\\DACS1\\src\\icon\\icons8-ticket-100.png"));
		lblNewLabel_3.setBounds(84, 31, 100, 100);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel = new JLabel("Admin");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(290, 45, 111, 42);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(290, 112, 120, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(290, 154, 120, 20);
		contentPane.add(passwordField);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = textField.getText();
				pass = getMd5(passwordField.getText());

				if (user.isEmpty() || pass.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin vào các trường!", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
				} else {
					if (isValidLogin(user, pass)) {
//						a1 123
						QLNV n = new QLNV();
						n.setVisible(true);
						dispose();
					} else {
						String message = "<html><div style='background-color: #ffcccc; padding: 10px;'><font color='#cc0000'>Error:</font><br>Đăng nhập thất bại. Vui lòng kiểm tra lại thông tin đăng nhập!</div></html>";
						JOptionPane.showMessageDialog(null, message, "Error Message", JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(102, 204, 255));
		btnNewButton.setBounds(290, 202, 96, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Admin\\eclipse\\DACS1\\src\\icon\\icons8-user-30.png"));
		lblNewLabel_1.setBounds(250, 107, 30, 30);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Admin\\eclipse\\DACS1\\src\\icon\\icons8-key-30.png"));
		lblNewLabel_2.setBounds(250, 149, 30, 30);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Log l = new Log();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(255, 51, 51));
		btnNewButton_1.setBounds(366, 0, 70, 23);
		contentPane.add(btnNewButton_1);
	}

	public static String getMd5(String input) {
		try {

			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}

		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	private boolean isValidLogin(String user, String pass) {

		String url = "jdbc:sqlserver://DESKTOP-12J6D6C\\SQLEXPRESS;databaseName=DACS1;"
				+ "portNumber=1433;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
		String username = "sa";
		String password = "123";

		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String query = "SELECT * FROM [Admin] WHERE [user] = ? AND pass = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);

			ResultSet resultSet = preparedStatement.executeQuery();

			return resultSet.next();
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
