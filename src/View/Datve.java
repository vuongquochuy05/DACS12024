package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import DBConnection.DBConnection;

public class Datve extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	Trangchu a = new Trangchu();
	private JTextField textField_2;
	private JDateChooser date;
	private JComboBox<String> comboBox;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Datve frame = new Datve();
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
	public Datve() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 797, 371);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Họ và tên:");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(24, 110, 83, 21);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("SĐT:");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(24, 140, 83, 21);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Ghi chú:");
		lblNewLabel_1_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(24, 200, 83, 21);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Số vé:");
		lblNewLabel_1_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(24, 170, 83, 21);
		panel.add(lblNewLabel_1_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(10, 11, 777, 32);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thông tin liên hệ(nhận vé/phiếu thanh toán):");
		lblNewLabel.setBounds(227, 5, 323, 21);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

		textField = new JTextField();
		textField.setBounds(117, 110, 220, 25);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(117, 140, 220, 25);
		panel.add(textField_1);
		textField_1.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(117, 170, 100, 25);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		
		date = new JDateChooser();
		date.setBounds(480, 140, 220, 25);
		panel.add(date);
		

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(480, 200, 220, 25);
		panel.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(480, 230, 220, 25);
		panel.add(textField_5);
		
		comboBox = new JComboBox<String>();
		comboBox.addItem("8:00");
		comboBox.addItem("14:00");
		comboBox.addItem("18:00");
		comboBox.setBounds(480, 170, 134, 25);
		panel.add(comboBox);
		
		JTextArea textghichu = new JTextArea();
		textghichu.setBounds(117, 200, 220, 40);
		panel.add(textghichu);

		JButton btnNewButton = new JButton("Đặt vé");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ten = textField.getText();
				String sdt = textField_1.getText();
				String sove = textField_3.getText();
				String ghichu = textghichu.getText();
				String machuyen = textField_2.getText();
				String sql = "INSERT INTO DatVe (ten,sdt,sove,ghichu,ma) VALUES (?,?,?,?,?)";
				if (ten.isEmpty() || sdt.isEmpty() || sove.isEmpty() || machuyen.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin vào các trường!", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						Connection c = DBConnection.getConnection();
						PreparedStatement preparedStatement = c.prepareStatement(sql);
						preparedStatement.setString(1, ten);
						preparedStatement.setString(2, sdt);
						preparedStatement.setString(3, sove);
						preparedStatement.setString(4, ghichu);
						preparedStatement.setString(5, machuyen);
						preparedStatement.executeUpdate();
						ThanhToan t = new ThanhToan();
						t.setVisible(true);
						dispose();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}
			}
		});

		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setBounds(320, 300, 126, 28);
		panel.add(btnNewButton);

		JLabel lblNewLabel_1_7 = new JLabel("Ngày đi:");
		lblNewLabel_1_7.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1_7.setBounds(388, 140, 83, 21);
		panel.add(lblNewLabel_1_7);

		JLabel lblNewLabel_1_7_1 = new JLabel("Giờ đi:");
		lblNewLabel_1_7_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1_7_1.setBounds(388, 170, 83, 21);
		panel.add(lblNewLabel_1_7_1);

		JLabel lblNewLabel_1_7_2 = new JLabel("Điểm đi:");
		lblNewLabel_1_7_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1_7_2.setBounds(388, 200, 83, 21);
		panel.add(lblNewLabel_1_7_2);

		JLabel lblNewLabel_1_7_3 = new JLabel("Điểm đến:");
		lblNewLabel_1_7_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1_7_3.setBounds(388, 230, 83, 21);
		panel.add(lblNewLabel_1_7_3);

		JButton btnNewButton_1 = new JButton("Trở về");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Trangchu t = new Trangchu();
				
				t.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.setBounds(10, 47, 89, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mã chuyến:");
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(388, 110, 70, 21);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(480, 110, 220, 25);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Giá vé:");
		lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(388, 260, 55, 14);
		panel.add(lblNewLabel_3);
		
		textField_6 = new JTextField();
		textField_6.setBounds(480, 260, 220, 25);
		panel.add(textField_6);
		textField_6.setColumns(10);
	}
	 public void updateTextField1(String ma) {
	        textField_2.setText(ma);
	    }
	 public void updateTextField2(String noidi) {
		 textField_4.setText(noidi);
	    }
	 public void updateTextField3(String noiden) {
		 textField_5.setText(noiden);
	    }
	 public void updateTextField4(java.sql.Date sqlDate) {
	        date.setDate(sqlDate);
	    }
	 public void updateTextField5(String giodi) {
		 comboBox.setSelectedItem(giodi);
	    }
	 public void updatetextField_6(String gia) {
		 textField_6.setText(gia);
	 }
}
