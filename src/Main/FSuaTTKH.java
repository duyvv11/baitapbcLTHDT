package Main;

import java.awt.EventQueue;
import java.util.List;
import componet.KhachHang;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class FSuaTTKH extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private KhachHang khachhangcanSua;
	private List<KhachHang> khachhang;
	private JTextField txtMKH;
	private JTextField txtTenKH;
	private JTextField txtDiaChi;
	private JTextField txtsdt;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public FSuaTTKH(List<KhachHang> khachhang, KhachHang khachhangcanSua) {
		this.khachhang = khachhang;
		this.khachhangcanSua = khachhangcanSua;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MKH");
		lblNewLabel.setBounds(26, 11, 48, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ten Khach Hang");
		lblNewLabel_1.setBounds(26, 62, 48, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dia Chi");
		lblNewLabel_2.setBounds(26, 113, 48, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblsdt = new JLabel("So Dien Thoai");
		lblsdt.setBounds(26, 163, 94, 14);
		contentPane.add(lblsdt);
		
		JLabel lblNewLabel_3_1 = new JLabel("Hoa don cua khach hang nay");
		lblNewLabel_3_1.setBounds(248, 11, 197, 14);
		contentPane.add(lblNewLabel_3_1);
		
		txtMKH = new JTextField();
		txtMKH.setEditable(false);
		txtMKH.setBounds(24, 35, 96, 20);
		txtMKH.setText(String.valueOf(khachhangcanSua.getMaKhachHang()));
		contentPane.add(txtMKH);
		txtMKH.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(26, 82, 96, 20);
		txtTenKH.setText(khachhangcanSua.getTenKhachHang());
		contentPane.add(txtTenKH);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(24, 138, 96, 20);
		txtDiaChi.setText(khachhangcanSua.getDiaChi());
		contentPane.add(txtDiaChi);
		
		txtsdt = new JTextField();
		txtsdt.setColumns(10);
		txtsdt.setBounds(24, 188, 96, 20);
		txtsdt.setText(String.valueOf(khachhangcanSua.getSoDienThoai()));
		contentPane.add(txtsdt);
		
		JButton btnLuu = new JButton("Luu");
		btnLuu.setBounds(10, 246, 89, 23);
		contentPane.add(btnLuu);
		
		JButton btnDong = new JButton("Dong");
		btnDong.setBounds(129, 246, 89, 23);
		contentPane.add(btnDong);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(230, 49, 240, 271);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);
		textArea.setText(khachhangcanSua.getHoaDonListAsString());
		
		// event
		btnLuu.addActionListener(e-> SuaTTKH());
		btnDong.addActionListener(e -> {
			this.dispose();
		});	

	}
	private void SuaTTKH() {
		String diachi= txtDiaChi.getText();
		String sdt = txtsdt.getText();
		if(diachi.isEmpty()||sdt.isEmpty()) {
			JOptionPane.showMessageDialog(this, " vui long nhap thong tin khach hang");	
		}
		else {
			khachhangcanSua.setDiaChi(diachi);
			khachhangcanSua.setSoDienThoai(sdt);
			Data.KHouputstream(khachhang);
			JOptionPane.showMessageDialog(this, "Da luu thong tin khach hang: " );
			this.dispose();
		}
	}
	
}
