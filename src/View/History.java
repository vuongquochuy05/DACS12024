package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import DBConnection.DBConnection;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class History extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_noiDi;
	private JTextField text_noiDen;
	private JTextField text_maChuyen;
	private JTextField text_timKiem;
	private JTable table;
	private DefaultTableModel model;
	private TableRowSorter<DefaultTableModel> roww;
	private JTextField textGiave;
	private JTextField textField_ten;
	private JTextField textField_sdt;
	private JTextField textField_soVe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					History frame = new History();
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
	
	private void loadData() {
		model = new DefaultTableModel();
		model.addColumn("Tên");
		model.addColumn("SĐT");
		model.addColumn("Số vé");
		model.addColumn("Tổng tiền");
		model.addColumn("Mã chuyến");
		model.addColumn("Nơi đi");
		model.addColumn("Nơi đến");
		model.addColumn("Ngày đi");
		model.addColumn("Giờ đi");
		model.addColumn("Giá vé");
		model.addColumn("Ghi chú");

		try {
			Connection c = DBConnection.getConnection();
			Statement statement = c.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT ten,sdt,sove,tongtien,DatVe.ma,noidi,noiden,ngaydi,giodi,gia,ghichu FROM datve INNER JOIN Chuyen ON Chuyen.ma=Datve.ma;");

			while (resultSet.next()) {
				Object[] row = new Object[11];
				row[0] = resultSet.getObject(1);
				row[1] = resultSet.getObject(2);
				row[2] = resultSet.getObject(3);
				row[3] = resultSet.getObject(4);
				row[4] = resultSet.getObject(5);
				row[5] = resultSet.getObject(6);
				row[6] = resultSet.getObject(7);
				row[7] = resultSet.getObject(8);
				row[8] = resultSet.getObject(9);
				row[9] = resultSet.getObject(10);
				row[10] = resultSet.getObject(11);

				model.addRow(row);
			}
			

			resultSet.close();
			statement.close();
			c.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		roww = new TableRowSorter<>(model);
		table.setModel(model);
		table.setRowSorter(roww);
	}
	
	public History() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 680);
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
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(255, 0, 0)), "C\u00E1c chuy\u1EBFn \u0111i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(50, 233, 1180, 371);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 20, 1150, 340);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		loadData();
		
		Panel panel_1 = new Panel();
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(68, 10, 1143, 217);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_noiDi = new JLabel("Nơi đi");
		label_noiDi.setBounds(84, 60, 49, 14);
		panel_1.add(label_noiDi);
		label_noiDi.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		
		text_noiDi = new JTextField();
		text_noiDi.setBounds(150, 60, 170, 20);
		panel_1.add(text_noiDi);
		text_noiDi.setColumns(10);
		
		JLabel label_ngayDi = new JLabel("Ngày đi");
		label_ngayDi.setBounds(64, 140, 69, 20);
		panel_1.add(label_ngayDi);
		label_ngayDi.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		
		JDateChooser text_ngayDi = new JDateChooser();
		text_ngayDi.setBounds(150, 140, 170, 20);
		panel_1.add(text_ngayDi);
		
		JLabel label_gioDi = new JLabel("Giờ đi");
		label_gioDi.setBounds(414, 60, 59, 17);
		panel_1.add(label_gioDi);
		label_gioDi.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblNin = new JLabel("Nơi đến");
		lblNin.setBounds(71, 100, 69, 20);
		panel_1.add(lblNin);
		lblNin.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		
		text_noiDen = new JTextField();
		text_noiDen.setBounds(150, 100, 170, 20);
		panel_1.add(text_noiDen);
		text_noiDen.setColumns(10);
		
		text_timKiem = new JTextField();
		text_timKiem.setBounds(873, 140, 193, 20);
		panel_1.add(text_timKiem);
		text_timKiem.setColumns(10);
		
		JLabel label_maChuyen = new JLabel("Mã chuyến\r\n");
		label_maChuyen.setBounds(392, 140, 99, 20);
		panel_1.add(label_maChuyen);
		label_maChuyen.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		
		text_maChuyen = new JTextField();
		text_maChuyen.setBounds(516, 140, 170, 20);
		panel_1.add(text_maChuyen);
		text_maChuyen.setColumns(10);
		
		textGiave = new JTextField();
		textGiave.setBounds(516, 100, 170, 20);
		panel_1.add(textGiave);
		textGiave.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"8:00", "14:00", "18:00"}));
		comboBox.setBounds(516, 60, 170, 20);
		panel_1.add(comboBox);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = text_timKiem.getText();
                if (ma.trim().length() == 0) {
                    roww.setRowFilter(null);
                    loadData();
                } else {
                    roww.setRowFilter(RowFilter.regexFilter(ma,0));
                }
			}
		});
		
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBackground(new Color(51, 204, 255));
		btnNewButton.setBounds(917, 180, 100, 30);
		panel_1.add(btnNewButton);
		
		JLabel lblTmKim = new JLabel("Tìm kiếm");
		lblTmKim.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		lblTmKim.setBounds(771, 140, 85, 25);
		panel_1.add(lblTmKim);
		
		JLabel lblNewLabel = new JLabel("Giá vé");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(414, 100, 55, 18);
		panel_1.add(lblNewLabel);
		
		JLabel label_tenKhachHang = new JLabel("Tên khách hàng");
		label_tenKhachHang.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		label_tenKhachHang.setBounds(10, 20, 130, 20);
		panel_1.add(label_tenKhachHang);
		
		textField_ten = new JTextField();
		textField_ten.setColumns(10);
		textField_ten.setBounds(150, 20, 170, 20);
		panel_1.add(textField_ten);
		
		JLabel label_sdt = new JLabel("SĐT");
		label_sdt.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		label_sdt.setBounds(432, 20, 59, 17);
		panel_1.add(label_sdt);
		
		textField_sdt = new JTextField();
		textField_sdt.setColumns(10);
		textField_sdt.setBounds(516, 20, 170, 20);
		panel_1.add(textField_sdt);
		
		JLabel label_soVe = new JLabel("Số vé");
		label_soVe.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		label_soVe.setBounds(790, 20, 59, 17);
		panel_1.add(label_soVe);
		
		textField_soVe = new JTextField();
		textField_soVe.setColumns(10);
		textField_soVe.setBounds(873, 20, 170, 20);
		panel_1.add(textField_soVe);
		
		JLabel label_soVe_1 = new JLabel("Ghi chú");
		label_soVe_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		label_soVe_1.setBounds(771, 60, 78, 17);
		panel_1.add(label_soVe_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(873, 60, 170, 40);
		panel_1.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("*Nhập tên khách hàng");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(898, 160, 134, 14);
		panel_1.add(lblNewLabel_1);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = table.getSelectedRow();
					if (selectedRow != -1) {
						textField_ten.setText(model.getValueAt(selectedRow, 0).toString());
						textField_sdt.setText(model.getValueAt(selectedRow, 1).toString());
						textField_soVe.setText(model.getValueAt(selectedRow, 2).toString());
						textArea.setText(model.getValueAt(selectedRow, 3).toString());
						text_maChuyen.setText(model.getValueAt(selectedRow, 4).toString());
						text_noiDi.setText(model.getValueAt(selectedRow, 5).toString());
						text_noiDen.setText(model.getValueAt(selectedRow, 6).toString());
						String dateString = model.getValueAt(selectedRow, 7).toString();
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						try {
							Date date = dateFormat.parse(dateString);
							text_ngayDi.setDate(date);
						} catch (ParseException e2) {
							e2.printStackTrace();
						}
						comboBox.setSelectedItem(model.getValueAt(selectedRow, 8).toString());
						textGiave.setText(model.getValueAt(selectedRow, 9).toString());
					}
				}
			}
		});
	}
}