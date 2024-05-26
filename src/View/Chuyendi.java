package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.TextField;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import DBConnection.DBConnection;

import javax.swing.border.EtchedBorder;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class Chuyendi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_noiDi;
	private JTextField text_noiDen;
	private JTextField text_maChuyen;
	private JTable table;
	private DefaultTableModel model;
	private TableRowSorter<DefaultTableModel> roww;
	private Datve d;
	private JTextField giave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chuyendi frame = new Chuyendi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void loadData() {
		model = new DefaultTableModel();
		model.addColumn("Mã chuyến");
		model.addColumn("Nơi đi");
		model.addColumn("Nơi đến");
		model.addColumn("Ngày đi");
		model.addColumn("Giờ đi");
		model.addColumn("Giá vé");
		
		try {
			Connection c = DBConnection.getConnection();
			Statement statement = c.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Chuyen");

			while (resultSet.next()) {
				Object[] row = new Object[6];
				row[0] = resultSet.getObject(1);
				row[1] = resultSet.getObject(2);
				row[2] = resultSet.getObject(3);
				row[3] = resultSet.getObject(4);
				row[4] = resultSet.getObject(5);
				row[5] = resultSet.getObject(6);

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
	/**
	 * Create the frame.
	 */
	public Chuyendi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 680);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setBackground(Color.LIGHT_GRAY);
		
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
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Liên hệ");
		mnNewMenu_2.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(255, 0, 0)), "C\u00E1c chuy\u1EBFn \u0111i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(194, 233, 932, 371);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 20, 915, 340);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		loadData();
		
		Panel panel_1 = new Panel();
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(68, 10, 1143, 193);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_noiDi = new JLabel("Nơi đi");
		label_noiDi.setBounds(452, 24, 49, 14);
		panel_1.add(label_noiDi);
		label_noiDi.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		
		text_noiDi = new JTextField();
		text_noiDi.setBounds(540, 24, 170, 20);
		panel_1.add(text_noiDi);
		text_noiDi.setColumns(10);
		
		JLabel label_ngayDi = new JLabel("Ngày đi");
		label_ngayDi.setBounds(43, 57, 69, 20);
		panel_1.add(label_ngayDi);
		label_ngayDi.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		
		JDateChooser text_ngayDi = new JDateChooser();
		text_ngayDi.setBounds(150, 57, 170, 20);
		panel_1.add(text_ngayDi);
		
		JLabel label_gioDi = new JLabel("Giờ đi");
		label_gioDi.setBounds(452, 60, 59, 17);
		panel_1.add(label_gioDi);
		label_gioDi.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblNin = new JLabel("Nơi đến");
		lblNin.setBounds(820, 23, 79, 20);
		panel_1.add(lblNin);
		lblNin.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		
		text_noiDen = new JTextField();
		text_noiDen.setBounds(920, 24, 170, 20);
		panel_1.add(text_noiDen);
		text_noiDen.setColumns(10);
		
		JLabel label_maChuyen = new JLabel("Mã chuyến\r\n");
		label_maChuyen.setBounds(43, 24, 99, 20);
		panel_1.add(label_maChuyen);
		label_maChuyen.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		
		text_maChuyen = new JTextField();
		text_maChuyen.setBounds(150, 24, 170, 20);
		panel_1.add(text_maChuyen);
		text_maChuyen.setColumns(10);
		
		giave = new JTextField();
		giave.setBounds(920, 57, 170, 20);
		panel_1.add(giave);
		giave.setColumns(10);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"8:00", "14:00", "18:00"}));
		comboBox.setBounds(540, 57, 170, 20);
		panel_1.add(comboBox);
		
		JButton btnNewButton_1_1 = new JButton("Đặt vé");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = text_maChuyen.getText();
				String noidi = text_noiDi.getText();
				String noiden = text_noiDen.getText();
				Date dateUtil = text_ngayDi.getDate(); 
				if (dateUtil == null) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày đi!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }
				java.sql.Date sqlDate = new java.sql.Date(dateUtil.getTime());
				String giodi = (String) comboBox.getSelectedItem();
				String gia = giave.getText();
				d = new Datve();
				d.setVisible(true);
				dispose();
				
				d.updateTextField1(ma);
				d.updateTextField2(noidi);
				d.updateTextField3(noiden);
				d.updateTextField4(sqlDate);
				d.updateTextField5(giodi);
				d.updatetextField_6(gia);
			}
		});
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				 if (!e.getValueIsAdjusting()) {
	                    int selectedRow = table.getSelectedRow();
	                    if (selectedRow != -1) {
	                        text_maChuyen.setText(model.getValueAt(selectedRow, 0).toString());
	                        text_noiDi.setText(model.getValueAt(selectedRow, 1).toString());
	                        text_noiDen.setText(model.getValueAt(selectedRow, 2).toString());
	                        String dateString = model.getValueAt(selectedRow, 3).toString();
	                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	                        try {
	                            Date date = dateFormat.parse(dateString);
	                            text_ngayDi.setDate(date);
	                        } catch (ParseException e2) {
	                            e2.printStackTrace();
	                        }
	                        comboBox.setSelectedItem(model.getValueAt(selectedRow, 4).toString());
	                        giave.setText(model.getValueAt(selectedRow, 5).toString());
	                    }
	                }
			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnNewButton_1_1.setBackground(new Color(51, 204, 255));
		btnNewButton_1_1.setBounds(650, 120, 120, 35);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = text_maChuyen.getText().toLowerCase();
				if (ma.trim().length() == 0) {
					roww.setRowFilter(null);
				} else {
					roww.setRowFilter(RowFilter.regexFilter("(?i)" + ma));
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnNewButton.setBackground(new Color(51, 204, 255));
		btnNewButton.setBounds(400, 120, 120, 35);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Giá vé");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(820, 60, 79, 20);
		panel_1.add(lblNewLabel);
		
		
		

		
		
	}
}