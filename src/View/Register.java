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
import java.awt.Font;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 255));
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
		
		JLabel lblNewLabel = new JLabel("Đăng ký");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(265, 11, 123, 43);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(305, 75, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(305, 115, 96, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(305, 155, 96, 20);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Admin\\eclipse\\DACS1\\src\\icon\\icons8-user-30.png"));
		lblNewLabel_1.setBounds(265, 70, 30, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Admin\\eclipse\\DACS1\\src\\icon\\icons8-key-30.png"));
		lblNewLabel_2.setBounds(265, 110, 30, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("New label");
		lblNewLabel_2_1_1.setIcon(new ImageIcon("D:\\Admin\\eclipse\\DACS1\\src\\icon\\icons8-tick-24.png"));
		lblNewLabel_2_1_1.setBounds(265, 150, 30, 30);
		contentPane.add(lblNewLabel_2_1_1);
		
		JButton btnRegister = new JButton("Đăng ký");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				KeyGenerator keyGen = KeyGenerator.getInstance("AES");
	            keyGen.init(256);
	            SecretKey secretKey = keyGen.generateKey();
	            byte[] keyBytes = secretKey.getEncoded();
	            SecretKey originalKey = getKeyFromBytes(keyBytes);
	            
	            String originalString = passwordField.getText();
	            String encryptedString = encrypt(originalString, originalKey);
	            String originalString1 = passwordField_1.getText();
	            String encryptedString1 = encrypt(originalString1, originalKey);

	            String ten = encrypt(textField.getText(), originalKey);
	            String encodedKey = Base64.getEncoder().encodeToString(keyBytes);
				if (ten.isEmpty() || originalString.isEmpty() || originalString1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin vào các trường!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else if (!originalString.equals(originalString1)) {
                    JOptionPane.showMessageDialog(null, "Xác nhận mật khẩu không khớp!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                } else {
                	 try {
                         Socket socket = new Socket("localhost", 1124);
                         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                         BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                         out.println("REGISTER");
                         out.println(ten);
                         out.println(encodedKey);
                         out.println(encryptedString);
                         out.println(encryptedString1);

                         String response = in.readLine();
                         if (response != null && response.equals("Register successful")) {
                             JOptionPane.showMessageDialog(null, "Đăng ký thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                         } else {
                             JOptionPane.showMessageDialog(null, "Đăng ký không thành công! Thông tin sai hoặc tên người dùng bị trùng lặp.", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
                         }

                         in.close();
                         out.close();
                         socket.close();
                     } catch (IOException ex) {
                         ex.printStackTrace();
                         JOptionPane.showMessageDialog(null, "Lỗi kết nối đến server!", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
                     }
                }
                } catch (Exception e1) {
		            e1.printStackTrace();
		        }
				
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
		});
		btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnRegister.setBackground(new Color(102, 204, 255));
		btnRegister.setBounds(278, 195, 110, 23);
		contentPane.add(btnRegister);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User u = new User();
				u.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(102, 204, 255));
		btnNewButton.setBounds(278, 229, 110, 23);
		contentPane.add(btnNewButton);
	}


}
