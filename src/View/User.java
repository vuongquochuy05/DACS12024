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

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Base64;
import java.awt.event.ActionEvent;

public class User extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	public static String user;
	public static String staff;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
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
	public User() {
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

		JLabel lblNewLabel = new JLabel("Đăng nhập");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(250, 38, 176, 42);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(290, 112, 120, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(290, 154, 120, 20);
		contentPane.add(passwordField);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Admin\\eclipse\\DACS1\\src\\icon\\icons8-user-30.png"));
		lblNewLabel_1.setBounds(250, 107, 30, 30);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Admin\\eclipse\\DACS1\\src\\icon\\icons8-key-30.png"));
		lblNewLabel_2.setBounds(250, 149, 30, 30);
		contentPane.add(lblNewLabel_2);

		JButton btnRegister = new JButton("Đăng ký");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register r = new Register();
				r.setVisible(true);
				dispose();
			}
		});
		btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnRegister.setBackground(new Color(102, 204, 255));
		btnRegister.setBounds(282, 225, 110, 23);
		contentPane.add(btnRegister);

		JButton btnngNhp = new JButton("Đăng nhập");
		btnngNhp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
			            keyGen.init(256);
			            SecretKey secretKey = keyGen.generateKey();
			            byte[] keyBytes = secretKey.getEncoded();
			            SecretKey originalKey = getKeyFromBytes(keyBytes);
			            
			            String originalString = passwordField.getText();
			            String encryptedString = encrypt(originalString, originalKey);
			            user = encrypt(textField.getText(), originalKey);
			            String encodedKey = Base64.getEncoder().encodeToString(keyBytes);
			            staff = textField.getText();
			            try (Socket socket = new Socket("localhost", 1122);
			                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

			                out.println(user);
			                out.println(encodedKey);
			                out.println(encryptedString);

			                String response = in.readLine();
			                System.out.println("Response from server: " + response);
			                if ("Login successful".equals(response)) {
			                    System.out.println("Login successful");
			                     Chuyendi c = new Chuyendi();
			                     c.setVisible(true);
			                     dispose();
			                } else {
			                    System.out.println("Login failed: " + response);
			                    JOptionPane.showMessageDialog(null, "Đăng nhập thất bại. Vui lòng kiểm tra lại tên đăng nhập và mật khẩu.", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
			                }
			            }
			        } catch (Exception e1) {
			            e1.printStackTrace();
			        }
			}
		});
		btnngNhp.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnngNhp.setBackground(new Color(102, 204, 255));
		btnngNhp.setBounds(282, 195, 110, 23);
		contentPane.add(btnngNhp);

	}

	public static SecretKey getKeyFromBytes(byte[] keyBytes) {
		return new SecretKeySpec(keyBytes, 0, keyBytes.length, "AES");
	}

	public static String encrypt(String strToEncrypt, SecretKey secretKey) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedBytes = cipher.doFinal(strToEncrypt.getBytes("UTF-8"));
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}

	public String getName() {
		String ten =staff;
		return ten;
	}
}
