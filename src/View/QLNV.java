package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import DBConnection.DBConnection;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class QLNV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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

	/**
	 * Create the frame.
	 */
	public QLNV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(11, 11, 485, 189);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Border border = BorderFactory.createEtchedBorder(Color.black, Color.black);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Thong tin");
		panel.setBorder(borderTitle);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(44, 27, 49, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(44, 52, 49, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(44, 77, 49, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(44, 102, 49, 14);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(119, 24, 96, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(119, 49, 96, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(119, 74, 96, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(119, 102, 96, 14);
		panel.add(textArea);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(44, 141, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(172, 141, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(312, 141, 89, 23);
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(499, 11, 233, 189);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Border border1 = BorderFactory.createEtchedBorder(Color.black, Color.black);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Tim kiem");
		panel_1.setBorder(borderTitle1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(24, 35, 49, 14);
		panel_1.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(100, 32, 96, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(100, 81, 96, 23);
		panel_1.add(btnNewButton_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 198, 722, 256);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		Border border2 = BorderFactory.createEtchedBorder(Color.black, Color.black);
		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2, "Danh sách");
		panel_2.setBorder(borderTitle2);
		
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Ten");
		dm.addColumn("Ma");
		dm.addColumn("SDT");
		dm.addColumn("Dia chi");

//		try {
//			Connection c = DBConnection.getConnection();
//			Statement statement = c.createStatement();
//			ResultSet resultSet = statement.executeQuery("SELECT * FROM Quanly");
//
//			while (resultSet.next()) {
//				Object[] row = new Object[6];
//				row[0] = resultSet.getObject(1);
//				row[1] = resultSet.getObject(2);
//				row[2] = resultSet.getObject(3);
//				row[3] = resultSet.getObject(4);
//				row[4] = resultSet.getObject(5);
//				row[5] = resultSet.getObject(6);
//
//				dm.addRow(row);
//			}
//
//			resultSet.close();
//			statement.close();
//			c.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		final JTable tbl = new JTable(dm);
		TableRowSorter<DefaultTableModel> row1 = new TableRowSorter<>(dm);
		tbl.setRowSorter(row1);
		JScrollPane sc = new JScrollPane(tbl);
		panel_2.add(tbl);
	}

}
