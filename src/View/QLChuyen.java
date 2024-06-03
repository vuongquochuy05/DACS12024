package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.CardLayout;
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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.io.IOException;

public class QLChuyen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_noiDi;
	private JTextField text_noiDen;
	private JTextField text_maChuyen;
	private JTextField text_timKiem;
	private JTable table;
	private DefaultTableModel model;
	private TableRowSorter<DefaultTableModel> roww1;
	private JTextField textGiave;
	static Thread t;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				QLChuyen frame = new QLChuyen();
				frame.setVisible(true);
				new Thread(() -> {
		            try (ServerSocket serverSocket = new ServerSocket(1122)) {
		                while (true) {
		                    Socket clientSocket = serverSocket.accept();
		                    System.out.println("Client đã kết nối: " + clientSocket.getInetAddress().getHostAddress());
		                    new Thread(new Login(clientSocket)).start();
		                }
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }).start();
				new Thread(() -> {
		            try (ServerSocket serverSocket = new ServerSocket(1123)) {
		                while (true) {
		                    Socket clientSocket = serverSocket.accept();
		                    System.out.println("Client đã kết nối: " + clientSocket.getInetAddress().getHostAddress());
		                    new Thread(new ClientHandler1(clientSocket)).start();
		                }
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }).start();
				new Thread(() -> {
		            try (ServerSocket serverSocket = new ServerSocket(1124)) {
		                while (true) {
		                    Socket clientSocket = serverSocket.accept();
		                    System.out.println("Client đã kết nối: " + clientSocket.getInetAddress().getHostAddress());
		                    new Thread(new Dangky(clientSocket)).start();
		                }
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }).start();
				new Thread(() -> {
		            try (ServerSocket serverSocket = new ServerSocket(1125)) {
		                while (true) {
		                    Socket clientSocket = serverSocket.accept();
		                    System.out.println("Client đã kết nối: " + clientSocket.getInetAddress().getHostAddress());
		                    new Thread(new Book(clientSocket)).start();
		                }
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }).start();
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

		roww1 = new TableRowSorter<>(model);
		table.setModel(model);
		table.setRowSorter(roww1);
	}

	/**
	 * Create the frame.
	 */
	public QLChuyen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 5, 1300, 680);
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
		contentPane.setBounds(0, 0, 1300, 680);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		CardLayout c = new CardLayout();
		JPanel panel_card = new JPanel();
		panel_card.setLayout(c);
		panel_card.setBounds(0, 0, 1300, 680);
		contentPane.add(panel_card);

		JPanel panel_QliChuyen = new JPanel();
		panel_QliChuyen.setLayout(null);
		panel_QliChuyen.setBounds(5, 5, 1300, 680);
		panel_card.add(panel_QliChuyen, "qlc");

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(255, 0, 0)),
				"C\u00E1c chuy\u1EBFn \u0111i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(194, 233, 932, 371);
		panel_QliChuyen.add(panel);
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
		panel_QliChuyen.add(panel_1);
		panel_1.setLayout(null);

		JLabel label_noiDi = new JLabel("Nơi đi");
		label_noiDi.setBounds(23, 24, 49, 14);
		panel_1.add(label_noiDi);
		label_noiDi.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));

		text_noiDi = new JTextField();
		text_noiDi.setBounds(120, 21, 170, 20);
		panel_1.add(text_noiDi);
		text_noiDi.setColumns(10);

		JLabel label_ngayDi = new JLabel("Ngày đi");
		label_ngayDi.setBounds(432, 21, 69, 20);
		panel_1.add(label_ngayDi);
		label_ngayDi.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));

		JDateChooser text_ngayDi = new JDateChooser();
		text_ngayDi.setBounds(552, 21, 170, 20);
		panel_1.add(text_ngayDi);

		JLabel label_gioDi = new JLabel("Giờ đi");
		label_gioDi.setBounds(432, 60, 59, 17);
		panel_1.add(label_gioDi);
		label_gioDi.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));

		JLabel lblNin = new JLabel("Nơi đến");
		lblNin.setBounds(23, 57, 79, 20);
		panel_1.add(lblNin);
		lblNin.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));

		text_noiDen = new JTextField();
		text_noiDen.setBounds(120, 57, 170, 20);
		panel_1.add(text_noiDen);
		text_noiDen.setColumns(10);

		text_timKiem = new JTextField();
		text_timKiem.setBounds(922, 21, 193, 20);
		panel_1.add(text_timKiem);
		text_timKiem.setColumns(10);

		JLabel label_maChuyen = new JLabel("Mã chuyến\r\n");
		label_maChuyen.setBounds(23, 95, 99, 20);
		panel_1.add(label_maChuyen);
		label_maChuyen.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));

		text_maChuyen = new JTextField();
		text_maChuyen.setBounds(120, 95, 170, 20);
		panel_1.add(text_maChuyen);
		text_maChuyen.setColumns(10);

		textGiave = new JTextField();
		textGiave.setBounds(552, 97, 170, 20);
		panel_1.add(textGiave);
		textGiave.setColumns(10);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "8:00", "14:00", "18:00" }));
		comboBox.setBounds(552, 57, 170, 20);
		panel_1.add(comboBox);

		JButton btnNewButton_1_1 = new JButton("Thêm");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = text_maChuyen.getText();
				String noidi = text_noiDi.getText();
				String noiden = text_noiDen.getText();
				Date dateUtil = text_ngayDi.getDate();
				if (dateUtil == null) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày đi!", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				java.sql.Date sqlDate = new java.sql.Date(dateUtil.getTime());
				String giodi = (String) comboBox.getSelectedItem();
				String gia = textGiave.getText();

				String sql = "INSERT INTO Chuyen ([ma],[noidi],[noiden],[ngaydi],[giodi],[gia]) VALUES (?,?,?,?,?,?)";
				try {
					Connection c = DBConnection.getConnection();
					PreparedStatement preparedStatement = c.prepareStatement(sql);
					preparedStatement.setString(1, ma);
					preparedStatement.setString(2, noidi);
					preparedStatement.setString(3, noiden);
					preparedStatement.setDate(4, sqlDate);
					preparedStatement.setString(5, giodi);
					preparedStatement.setString(6, gia);
					preparedStatement.executeUpdate();
					model.addRow(new Object[] { ma, noidi, noiden, sqlDate, giodi, gia });

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(QLChuyen.this,
							"Thêm thông tin không thành công! Vui lòng kiểm tra lại thông tin.");
					e2.printStackTrace();
				}

				text_maChuyen.setText("");
				text_noiDi.setText("");
				text_noiDen.setText("");
				text_ngayDi.setDate(null);
				comboBox.setSelectedItem(comboBox);
				textGiave.setText("");
			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_1_1.setBackground(new Color(51, 204, 255));
		btnNewButton_1_1.setBounds(205, 139, 80, 30);
		panel_1.add(btnNewButton_1_1);

		JButton btnNewButton_1_1_1 = new JButton("Sửa");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = text_maChuyen.getText();
				String noidi = text_noiDi.getText();
				String noiden = text_noiDen.getText();
				Date dateUtil = text_ngayDi.getDate();
				if (dateUtil == null) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày đi!", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				java.sql.Date sqlDate = new java.sql.Date(dateUtil.getTime());
				String giodi = (String) comboBox.getSelectedItem();
				String gia = textGiave.getText();

				String sql = "UPDATE Chuyen SET [noidi] = ?, [noiden] = ?, [ngaydi] = ?, [giodi] = ?, [gia] = ?  WHERE [ma] = ?";
				try {
					Connection c = DBConnection.getConnection();
					PreparedStatement preparedStatement = c.prepareStatement(sql);
					preparedStatement.setString(1, noidi);
					preparedStatement.setString(2, noiden);
					preparedStatement.setDate(3, sqlDate);
					preparedStatement.setString(4, giodi);
					preparedStatement.setString(5, gia);
					preparedStatement.setString(6, ma);
					preparedStatement.executeUpdate();

					int rowupdate1 = table.getSelectedRow();
					if (rowupdate1 != -1) {
						model.setValueAt(Integer.parseInt(ma), rowupdate1, 0);
						model.setValueAt(noidi, rowupdate1, 1);
						model.setValueAt(noiden, rowupdate1, 2);
						model.setValueAt(sqlDate, rowupdate1, 3);
						model.setValueAt(giodi, rowupdate1, 4);
						model.setValueAt(gia, rowupdate1, 5);
					}

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(QLChuyen.this,
							"Thêm thông tin không thành công! Vui lòng kiểm tra lại thông tin.");
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_1_1_1.setBackground(new Color(51, 204, 255));
		btnNewButton_1_1_1.setBounds(350, 139, 80, 30);
		panel_1.add(btnNewButton_1_1_1);

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
						textGiave.setText(model.getValueAt(selectedRow, 5).toString());
					}
				}
			}
		});

		JButton btnNewButton_1_2 = new JButton("Xóa");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = text_maChuyen.getText();

				String sql = "DELETE FROM Chuyen WHERE [ma]=?";
				try {
					Connection c = DBConnection.getConnection();
					PreparedStatement preparedStatement = c.prepareStatement(sql);
					preparedStatement.setString(1, ma);
					preparedStatement.executeUpdate();
					text_maChuyen.setText("");
					text_noiDi.setText("");
					text_noiDen.setText("");
					text_ngayDi.setDate(null);
					comboBox.setSelectedItem(comboBox);
					textGiave.setText("");

				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Xóa không thành công!");
				}
				loadData();
			}
		});
		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_1_2.setBackground(new Color(51, 204, 255));
		btnNewButton_1_2.setBounds(495, 139, 80, 30);
		panel_1.add(btnNewButton_1_2);

		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = text_timKiem.getText();
				if (ma.trim().length() == 0) {
					roww1.setRowFilter(null);
				} else {
					roww1.setRowFilter(RowFilter.regexFilter(ma, 0));
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBackground(new Color(51, 204, 255));
		btnNewButton.setBounds(976, 56, 100, 30);
		panel_1.add(btnNewButton);

		JLabel lblTmKim = new JLabel("Tìm kiếm");
		lblTmKim.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		lblTmKim.setBounds(825, 20, 85, 25);
		panel_1.add(lblTmKim);

		JLabel lblNewLabel = new JLabel("Giá vé");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(432, 100, 55, 18);
		panel_1.add(lblNewLabel);

		QLNV qlnv = new QLNV();
		panel_card.add(qlnv.getContentPane(), "qlnv");

		mntmNewMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout cl = (CardLayout) panel_card.getLayout();
				cl.show(panel_card, "qlc");

			}
		});

		mntmNewMenuItem_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout cl = (CardLayout) panel_card.getLayout();
				cl.show(panel_card, "qlnv");

			}
		});

		hoTroAdmin cskh = new hoTroAdmin();
		panel_card.add(cskh.getContentPane(), "cskh");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout cl = (CardLayout) panel_card.getLayout();
				cl.show(panel_card, "cskh");

			}
		});
		
		History h = new History();
		panel_card.add(h.getContentPane(), "history");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout cl = (CardLayout) panel_card.getLayout();
				cl.show(panel_card, "history");

			}
		});

	}
}

class Login implements Runnable {
    private Socket clientSocket;

    public Login(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String usernameInput = in.readLine();
            String passwordInput = in.readLine();

            String url = "jdbc:sqlserver://DESKTOP-12J6D6C\\SQLEXPRESS;databaseName=DACS1;"
                    + "portNumber=1433;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
            String username = "sa";
            String password = "123";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement statement = connection
                        .prepareStatement("SELECT * FROM [User] WHERE ten = ? AND pass = ?");
                statement.setString(1, usernameInput);
                statement.setString(2, passwordInput);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    out.println("Login successful");
                } else {
                    out.println("Đăng nhập thất bại. Vui lòng kiểm tra lại tên đăng nhập và mật khẩu.");
                }

                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
//            } finally {
//                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Dangky extends Thread {
    private Socket socket;

    public Dangky(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String action = in.readLine();
            if ("REGISTER".equals(action)) {
                String username = in.readLine();
                String password = in.readLine();
                String passconfirm = in.readLine();

                if (registerUser(username, password, passconfirm)) {
                    out.println("Register successful");
                } else {
                    out.println("Register failed");
                }
            }

            in.close();
            out.close();
            socket.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private boolean registerUser(String username, String password, String passconfirm) {
    	String url = "jdbc:sqlserver://DESKTOP-12J6D6C\\SQLEXPRESS;databaseName=DACS1;"
                + "portNumber=1433;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
        String username1 = "sa";
        String password1 = "123";


        String sql = "INSERT INTO [User] (ten,pass,passconfirm) VALUES (?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, username1, password1);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, passconfirm);

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

class ClientHandler1 implements Runnable {
	private Socket clientSocket;

	public ClientHandler1(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

			// Đọc yêu cầu từ client
			String request = in.readLine();
			if ("getChuyenData".equals(request)) {

				try (Connection c1 = DBConnection.getConnection();
						Statement statement = c1.createStatement();
						ResultSet resultSet = statement.executeQuery("SELECT * FROM Chuyen")) {

					// Gửi dữ liệu về client
					StringBuilder responseBuilder = new StringBuilder();
					while (resultSet.next()) {
						responseBuilder.append(resultSet.getObject(1)).append(",").append(resultSet.getObject(2))
								.append(",").append(resultSet.getObject(3)).append(",").append(resultSet.getObject(4))
								.append(",").append(resultSet.getObject(5)).append(",").append(resultSet.getObject(6))
								.append("\n");
					}
					out.println(responseBuilder.toString());
				} catch (SQLException e) {
					e.printStackTrace();
					out.println("ERROR");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				clientSocket.close(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
class Book extends Thread {
    private Socket socket;

    public Book(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String action = in.readLine();
            if ("DATVE".equals(action)) {
                String ten = in.readLine();
                String sdt = in.readLine();
                String sove = in.readLine();
                String ghichu = in.readLine();
                String machuyen = in.readLine();
                String tongTien = in.readLine();

                if (datve(ten, sdt, sove, ghichu, machuyen, tongTien)) {
                    out.println("Dat ve thanh cong");
                } else {
                    out.println("Dat ve that bai");
                }
            }

            in.close();
            out.close();
            socket.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private boolean datve(String ten, String sdt, String sove, String ghichu, String machuyen, String tongTien) {
        String url = "jdbc:sqlserver://DESKTOP-12J6D6C\\SQLEXPRESS;databaseName=DACS1;"
                + "portNumber=1433;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
        String dbUsername = "sa";
        String dbPassword = "123";

        String sql = "INSERT INTO DatVe (ten, sdt, sove, ghichu, ma, tongtien) VALUES (?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, ten);
            statement.setString(2, sdt);
            statement.setString(3, sove);
            statement.setString(4, ghichu);
            statement.setString(5, machuyen);
            statement.setString(6, tongTien);

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
