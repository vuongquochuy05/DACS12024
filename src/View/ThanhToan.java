package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThanhToan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThanhToan frame = new ThanhToan();
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
	public ThanhToan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Số vé:");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel.setBounds(162, 90, 49, 14);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(0, 0, 475, 38);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Thanh toán");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panel.add(lblNewLabel_1);
		
		JLabel lblGiTinngi = new JLabel("Giá tiền/người:");
		lblGiTinngi.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblGiTinngi.setBounds(119, 130, 92, 14);
		contentPane.add(lblGiTinngi);
		
		JLabel lblSTinThanh = new JLabel("Số tiền thanh toán:");
		lblSTinThanh.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblSTinThanh.setBounds(94, 180, 117, 14);
		contentPane.add(lblSTinThanh);
		
		JLabel lblNewLabel_2 = new JLabel("0");
		lblNewLabel_2.setBounds(256, 91, 80, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("0");
		lblNewLabel_2_1.setBounds(256, 131, 80, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("0");
		lblNewLabel_2_2.setBounds(256, 181, 80, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JButton btnNewButton = new JButton("Thanh toán");
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setBounds(180, 231, 100, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Trở về");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Datve d = new Datve();
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.setBounds(10, 49, 73, 23);
		contentPane.add(btnNewButton_1);
	}
}