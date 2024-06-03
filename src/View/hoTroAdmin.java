package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;

public class hoTroAdmin extends JFrame implements Runnable{
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	ServerSocket srvSocket = null;
	BufferedReader bf = null;
	Thread t;
	private JTabbedPane tabbedPane;
	private JLabel lblNewLabel;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel_1;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hoTroAdmin frame = new hoTroAdmin();
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
	public hoTroAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 5, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Quản lí nhân viên");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 18));
		mnNewMenu.setForeground(new Color(0, 0, 0));
		menuBar.add(mnNewMenu);
		
		mnNewMenu_1 = new JMenu("Quản lí chuyến");
		mnNewMenu_1.setForeground(new Color(0, 0, 0));
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.add(mnNewMenu_1);
		
		mnNewMenu_2 = new JMenu("Hỗ trợ khách hàng");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 18));
		mnNewMenu_2.setForeground(new Color(0, 0, 0));
		menuBar.add(mnNewMenu_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 255, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNewLabel = new JLabel("Chăm sóc khách hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		
		panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		
		lblNewLabel_1 = new JLabel(".");
		lblNewLabel_1.setFont(new Font("Bradley Hand ITC", Font.ITALIC, 35));
		panel_3.add(lblNewLabel_1);
		
		
		
		this.setSize(1200, 600);
		int serverPort = 2024;
		try {
			srvSocket = new ServerSocket(serverPort);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		t = new Thread(this);
		t.start();
		
	}
	
	public void run() {
		while(true) {
			try {
				Socket astaffSocket = srvSocket.accept();
				if(astaffSocket != null) {
					bf = new BufferedReader(new InputStreamReader(astaffSocket.getInputStream()));
					String S = bf.readLine();
					int pos = S.indexOf(":");
					String staffName = S.substring(pos + 1);
					ChatPanel p = new ChatPanel(astaffSocket, "Manager", staffName);
					tabbedPane.add(staffName, p);
					p.updateUI();
					
				}
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private static void qliDatVe(Socket socket) {
		
	}

//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		
//	}

}
