package View;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

	public Login() {
		initComponents();
	}

	private String user;
	private String pass;
	

	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		panel1 = new java.awt.Panel();
		jLabel4 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jRadioButton1 = new javax.swing.JRadioButton();
		jRadioButton2 = new javax.swing.JRadioButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(255, 0, 0));

		panel1.setBackground(new java.awt.Color(204, 204, 255));

		jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons8-user-shield-96.png"))); // NOI18N

		jLabel1.setText("Tên đăng nhập");

		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jLabel2.setText("Mật khẩu");

		jButton1.setText("Đăng nhập");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("Đăng kí");
		jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton2MouseClicked(evt);
			}
		});

		jButton3.setText("Quên mật khẩu?");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		buttonGroup1.add(jRadioButton1);
		jRadioButton1.setText("User");
		jRadioButton1.setSelected(true);
		jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton1ActionPerformed(evt);
			}
		});

		buttonGroup1.add(jRadioButton2);
		jRadioButton2.setText("Admin");
		jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
		panel1.setLayout(panel1Layout);
		panel1Layout.setHorizontalGroup(panel1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						panel1Layout
								.createSequentialGroup().addGap(19, 19, 19)
								.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel1).addComponent(jLabel2))
								.addGap(26, 26, 26)
								.addGroup(panel1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jTextField2).addComponent(jTextField1))
								.addGap(67, 67, 67))
				.addGroup(panel1Layout.createSequentialGroup().addGroup(panel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panel1Layout.createSequentialGroup().addGap(137, 137, 137).addComponent(jButton3))
						.addGroup(panel1Layout.createSequentialGroup().addGap(149, 149, 149).addComponent(jLabel4))
						.addGroup(panel1Layout.createSequentialGroup().addGap(91, 91, 91).addGroup(panel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(panel1Layout.createSequentialGroup().addComponent(jRadioButton1)
										.addGap(30, 30, 30).addComponent(jRadioButton2).addGap(48, 48, 48))
								.addGroup(panel1Layout.createSequentialGroup().addComponent(jButton1).addGap(34, 34, 34)
										.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
												javax.swing.GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap(118, Short.MAX_VALUE)));
		panel1Layout.setVerticalGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panel1Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(jLabel4)
						.addGap(18, 18, 18)
						.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton1).addComponent(jButton2))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton3)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jRadioButton2).addComponent(jRadioButton1))
						.addContainerGap(30, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));

		pack();
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

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		user = jTextField1.getText();
		pass = getMd5(jTextField2.getText());

		if (user.isEmpty() || pass.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin vào các trường!", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		} else {
			if (jRadioButton1.isSelected()) {
				if (isValidLogin1(user, pass)) {
					Trangchu n = new Trangchu();
					n.setVisible(true);
					dispose();
				} else {
					String message = "<html><div style='background-color: #ffcccc; padding: 10px;'><font color='#cc0000'>Error:</font><br>Đăng nhập thất bại. Vui lòng kiểm tra lại thông tin đăng nhập!</div></html>";
					JOptionPane.showMessageDialog(null, message, "Error Message", JOptionPane.ERROR_MESSAGE);
				}
			} else if (jRadioButton2.isSelected()) {
				if (isValidLogin2(user, pass)) {
					Register n = new Register();
					n.setVisible(true);
					dispose();
				} else {
					String message = "<html><div style='background-color: #ffcccc; padding: 10px;'><font color='#cc0000'>Error:</font><br>Đăng nhập thất bại. Vui lòng kiểm tra lại thông tin đăng nhập!</div></html>";
					JOptionPane.showMessageDialog(null, message, "Error Message", JOptionPane.ERROR_MESSAGE);
				}
			}

		}
	}

	private boolean isValidLogin1(String user, String pass) {

		String url = "jdbc:sqlserver://DESKTOP-12J6D6C\\SQLEXPRESS;databaseName=DACS1;"
				+ "portNumber=1433;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
		String username = "sa";
		String password = "123";

		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String query = "SELECT * FROM [User] WHERE [user] = ? AND pass = ? ";
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

	private boolean isValidLogin2(String user, String pass) {

		String url = "jdbc:sqlserver://DESKTOP-12J6D6C\\SQLEXPRESS;databaseName=DACS1;"
				+ "portNumber=1433;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
		String username = "sa";
		String password = "123";

		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String query = "SELECT * FROM Admin WHERE [user] = ? AND pass = ? ";
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

	private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
		Register dangki = new Register();
		dispose();
		dangki.setVisible(true);// TODO add your handling code here:
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		 jButton2.setVisible(true);
	}

	private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		 jButton2.setVisible(false);
	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login().setVisible(true);
			}
		});
	}

	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JRadioButton jRadioButton1;
	private javax.swing.JRadioButton jRadioButton2;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private java.awt.Panel panel1;
}
