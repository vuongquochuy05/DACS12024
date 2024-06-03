package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ThanhToan extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblTongTien;
    private JLabel lblSoVe;
    private JLabel lblGiaVe;

    public ThanhToan(double tongTien) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Tổng tiền:");
        lblNewLabel.setBounds(10, 11, 100, 14);
        contentPane.add(lblNewLabel);

        lblTongTien = new JLabel(String.valueOf(tongTien));
        lblTongTien.setBounds(120, 11, 200, 14);
        contentPane.add(lblTongTien);
        
        JLabel lblNewLabel2 = new JLabel("Số vé:");
        lblNewLabel2.setBounds(10, 36, 100, 14);
        contentPane.add(lblNewLabel2);

        lblSoVe = new JLabel();
        lblSoVe.setBounds(120, 36, 200, 14);
        contentPane.add(lblSoVe);
        
        JLabel lblNewLabel3 = new JLabel("Giá vé:");
        lblNewLabel3.setBounds(10, 61, 100, 14);
        contentPane.add(lblNewLabel3);

        lblGiaVe = new JLabel();
        lblGiaVe.setBounds(120, 61, 200, 14);
        contentPane.add(lblGiaVe);
    }

    public void updateSoVe(int soVe) {
        lblSoVe.setText(String.valueOf(soVe));
    }

    public void updateGiaTien(double giaVe) {
        lblGiaVe.setText(String.valueOf(giaVe));
    }
}
