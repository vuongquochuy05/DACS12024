package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import DBConnection.DBConnection;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class QLNV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table_2;
	private DefaultTableModel model;
	private TableRowSorter<DefaultTableModel> roww;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLNV frame = new QLNV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void loadData() {
		model = new DefaultTableModel();
		model.addColumn("Mã nhân viên");
		model.addColumn("Tên nhân viên");
		model.addColumn("SĐT");
		model.addColumn("Chức vụ");
		model.addColumn("Giới tính");
		model.addColumn("Biển số xe");
		model.addColumn("Địa chỉ");
		
		try {
			Connection c = DBConnection.getConnection();
			Statement statement = c.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM QLNV");

			while (resultSet.next()) {
				Object[] row = new Object[7];
				row[0] = resultSet.getObject(1);
				row[1] = resultSet.getObject(2);
				row[2] = resultSet.getObject(3);
				row[3] = resultSet.getObject(4);
				row[4] = resultSet.getObject(5);
				row[5] = resultSet.getObject(6);
				row[6] = resultSet.getObject(7);

				model.addRow(row);
			}

			resultSet.close();
			statement.close();
			c.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		roww = new TableRowSorter<>(model);
		table_2.setModel(model);
		table_2.setRowSorter(roww);
	}
	/**
	 * Create the frame.
	 */
	public QLNV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1260, 630);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Quản Lý");
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 14));
		mnNewMenu.setForeground(new Color(0, 0, 0));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Quản lý nhân viên");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Quản lý chuyến");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Thống Kê");
		mnNewMenu_1.setFont(new Font("Arial", Font.BOLD, 14));
		mnNewMenu_1.setForeground(new Color(0, 0, 0));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Lịch sử đặt vé");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Hỗ trợ");
		mnNewMenu_2.setFont(new Font("Arial", Font.BOLD, 14));
		mnNewMenu_2.setForeground(new Color(0, 0, 0));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("CSKH");
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 255, 255));
		panel.setBounds(0, 0, 300, 650);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã nhân viên:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 70, 85, 20);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(124, 70, 166, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tên nhân viên:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 110, 104, 20);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(124, 110, 166, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("SĐT:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 150, 85, 20);
		panel.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(124, 150, 166, 20);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Biển số xe:");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(10, 270, 85, 20);
		panel.add(lblNewLabel_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(124, 270, 166, 20);
		panel.add(textField_3);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Giới tính:");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(10, 230, 85, 20);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Chức vụ:");
		lblNewLabel_1_1_1_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_1_1_2.setBounds(10, 190, 85, 20);
		panel.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Địa chỉ:");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_1_1_2_1.setBounds(10, 310, 85, 20);
		panel.add(lblNewLabel_1_1_1_2_1);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Nam", "Nữ"}));
		comboBox.setBounds(124, 230, 71, 22);
		panel.add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(124, 310, 166, 45);
		panel.add(textArea);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"Nhân viên", "Tài xế"}));
		comboBox_1.setBounds(124, 190, 166, 22);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Thông tin nhân viên\r\n");
		lblNewLabel_2.setForeground(new Color(0, 0, 204));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBounds(25, 11, 257, 48);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.setBackground(new Color(51, 204, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = textField.getText();
				String ten = textField_1.getText();
				String sdt = textField_2.getText();
				String chucvu = (String) comboBox_1.getSelectedItem();
				String gioitinh = (String) comboBox.getSelectedItem();
				String biensoxe = textField_3.getText();
				String diachi = textArea.getText();



				String sql = "INSERT INTO QLNV ([ma],[ten],[sdt],[chucvu],[gioitinh],[bsx],[diachi]) VALUES (?,?,?,?,?,?,?)";
				try {
					Connection c = DBConnection.getConnection();
					PreparedStatement preparedStatement = c.prepareStatement(sql);
					preparedStatement.setString(1, ma);
					preparedStatement.setString(2, ten);
					preparedStatement.setString(3, sdt);
					preparedStatement.setString(4, chucvu);
					preparedStatement.setString(5, gioitinh);
					preparedStatement.setString(6, biensoxe);
					preparedStatement.setString(7, diachi);
					preparedStatement.executeUpdate();
					model.addRow(new Object[] { ma, ten, sdt, chucvu, gioitinh, biensoxe, diachi});

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(QLNV.this,
							"Thêm thông tin không thành công! Vui lòng kiểm tra lại thông tin.");
					e2.printStackTrace();
				}

				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				comboBox_1.setSelectedItem(comboBox_1);
				comboBox.setSelectedItem(comboBox);
				textField_3.setText("");
				textArea.setText("");

			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_1.setBounds(22, 390, 80, 30);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Sửa");
		btnNewButton_1_1.setBackground(new Color(51, 204, 255));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = textField.getText();
				String ten = textField_1.getText();
				String sdt = textField_2.getText();
				String chucvu = (String) comboBox_1.getSelectedItem();
				String gioitinh = (String) comboBox.getSelectedItem();
				String biensoxe = textField_3.getText();
				String diachi = (String) textArea.getText();



				String sql = "UPDATE QLNV SET [ten] = ?, [sdt] = ?, [chucvu] = ?, [gioitinh] = ?, [bsx] = ?, [diachi] = ?  WHERE [ma] = ?";
				try {
					Connection c = DBConnection.getConnection();
					PreparedStatement preparedStatement = c.prepareStatement(sql);
					preparedStatement.setString(1, ten);
					preparedStatement.setString(2, sdt);
					preparedStatement.setString(3, chucvu);
					preparedStatement.setString(4, gioitinh);
					preparedStatement.setString(5, biensoxe);
					preparedStatement.setString(6, diachi);
					preparedStatement.setString(7, ma);
					preparedStatement.executeUpdate();
					
					int rowupdate1 = table_2.getSelectedRow();
					if (rowupdate1 != -1) {
						model.setValueAt(Integer.parseInt(ma), rowupdate1, 0);
						model.setValueAt(ten, rowupdate1, 1);
						model.setValueAt(sdt, rowupdate1, 2);
						model.setValueAt(chucvu, rowupdate1, 3);
						model.setValueAt(gioitinh, rowupdate1, 4);
						model.setValueAt(biensoxe, rowupdate1, 5);
						model.setValueAt(diachi, rowupdate1, 6);
					}

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(QLNV.this,
							"Thêm thông tin không thành công! Vui lòng kiểm tra lại thông tin.");
					e2.printStackTrace();
				}

			}
		});
		
		
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_1_1.setBounds(112, 390, 80, 30);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Xóa");
		btnNewButton_1_2.setBackground(new Color(51, 204, 255));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = textField.getText();

                String sql = "DELETE FROM QLNV WHERE [ma]=?";
                try {
                    Connection c = DBConnection.getConnection();
                    PreparedStatement preparedStatement = c.prepareStatement(sql);
                    preparedStatement.setString(1, ma);
                    preparedStatement.executeUpdate();
                    textField.setText("");
    				textField_1.setText("");
    				textField_2.setText("");
    				comboBox_1.setSelectedItem(comboBox_1);
    				comboBox.setSelectedItem(comboBox);
    				textField_3.setText("");
    				textArea.setText("");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Xóa không thành công!");
                }
                loadData();
			}
		});
		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_1_2.setBounds(202, 390, 80, 30);
		panel.add(btnNewButton_1_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 255, 255));
		panel_1.setBounds(379, 122, 820, 432);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 800, 412);
		panel_1.add(scrollPane);
		table_2 = new JTable();
		scrollPane.setViewportView(table_2);
		loadData();
		
		table_2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				 if (!e.getValueIsAdjusting()) {
	                    int selectedRow = table_2.getSelectedRow();
	                    if (selectedRow != -1) {
	                        textField.setText(model.getValueAt(selectedRow, 0).toString());
	                        textField_1.setText(model.getValueAt(selectedRow, 1).toString());
	                        textField_2.setText(model.getValueAt(selectedRow, 2).toString());
	                        comboBox_1.setSelectedItem(model.getValueAt(selectedRow, 3).toString());
	                        comboBox.setSelectedItem(model.getValueAt(selectedRow, 4).toString());
	                        textField_3.setText(model.getValueAt(selectedRow, 5).toString());
	                        textArea.setText(model.getValueAt(selectedRow, 6).toString());
	                    }
	                }
			}
		});
		
		
		JLabel lblTmKim = new JLabel("Tìm kiếm");
		lblTmKim.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		lblTmKim.setBounds(503, 37, 85, 25);
		contentPane.add(lblTmKim);
		
		textField_4 = new JTextField();
		textField_4.setBounds(611, 39, 395, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setBackground(new Color(51, 204, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = textField_4.getText();
				if (ma.trim().length() == 0) {
					roww.setRowFilter(null);
				} else {
					roww.setRowFilter(RowFilter.regexFilter(ma,0));
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(1039, 38, 89, 23);
		contentPane.add(btnNewButton);
	}
}