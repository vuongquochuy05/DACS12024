package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Datve extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		lblNewLabel_1.setBounds(24, 90, 83, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("SĐT:");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(24, 120, 83, 21);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ghi chú:");
		lblNewLabel_1_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(24, 180, 83, 21);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Số vé:");
		lblNewLabel_1_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(24, 150, 83, 21);
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
		textField.setBounds(117, 90, 220, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(117, 120, 220, 25);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(117, 150, 100, 25);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Đặt vé");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThanhToan t = new ThanhToan();
				t.setVisible(true);
				dispose();
			}
		});
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String ten = jtMave.getText();
//				String sdt = jtTenKH.getText();
//				String sove = jtBSX.getText();
//				String ngaydi = jtSdt.getText();
//				String giodi = (String) cbloaixe1.getSelectedItem();
//				String diemdon = jtMauxeThang.getText();
//				String diemdung = (String) cbgia2.getSelectedItem();
//				String ghichu = jtMauxeThang.getText();
//				String sql = "INSERT INTO Dangki ([Mã thẻ],[Tên khách hàng],[Biển số xe],[Số điện thoại],[Loại xe],[Màu xe],[Giá vé],[Ngày đăng kí]) VALUES (?,?,?,?,?,?,?,?)";
//				if (ten.isEmpty() || ten.isEmpty() || sove.isEmpty() || ngaydi.isEmpty() || giodi.isEmpty() || diemdon.isEmpty() || diemdung.isEmpty()) {
//					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin vào các trường!", "Thông báo",
//							JOptionPane.WARNING_MESSAGE);
//				}
//				try {
//					Connection c = DBConnection.getConnection();
//					PreparedStatement preparedStatement = c.prepareStatement(sql);
//					preparedStatement.setString(1, ten);
//					preparedStatement.setString(2, sdt);
//					preparedStatement.setString(3, sove);
//					preparedStatement.setString(4, ngaydi);
//					preparedStatement.setString(5, giodi);
//					preparedStatement.setString(6, diemdon);
//					preparedStatement.setString(7, diemdung);
//					preparedStatement.setString(8, ghichu);
//					preparedStatement.executeUpdate();
//
//				} catch (SQLException e2) {
//					e2.printStackTrace();
//				}
//			}
//		});
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setBounds(320, 285, 126, 28);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1_7 = new JLabel("Ngày đi:");
		lblNewLabel_1_7.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1_7.setBounds(388, 90, 83, 21);
		panel.add(lblNewLabel_1_7);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(117, 180, 220, 40);
		panel.add(textArea);
		
		JDateChooser textField_2 = new JDateChooser();
		textField_2.setBounds(480, 90, 220, 25);
		panel.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(480, 150, 220, 25);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(480, 180, 220, 25);
		panel.add(textField_5);
		
		JLabel lblNewLabel_1_7_1 = new JLabel("Giờ đi:");
		lblNewLabel_1_7_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1_7_1.setBounds(388, 120, 83, 21);
		panel.add(lblNewLabel_1_7_1);
		
		JLabel lblNewLabel_1_7_2 = new JLabel("Điểm đón:");
		lblNewLabel_1_7_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1_7_2.setBounds(388, 150, 83, 21);
		panel.add(lblNewLabel_1_7_2);
		
		JLabel lblNewLabel_1_7_3 = new JLabel("Điểm dừng:");
		lblNewLabel_1_7_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1_7_3.setBounds(388, 180, 83, 21);
		panel.add(lblNewLabel_1_7_3);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("8:00");
		comboBox.addItem("14:00");
		comboBox.addItem("18:00");
		comboBox.setBounds(480, 120, 134, 25);
		panel.add(comboBox);
		
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
	}
}