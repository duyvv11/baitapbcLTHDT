package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import componet.KhachHang;
import javax.swing.JOptionPane;
import java.util.List;
public class FNhapKhachHang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtDiaChi;
	private JTextField txtSoDienThoai;
	private List<KhachHang> khachhang;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FNhapKhachHang frame = new FNhapKhachHang();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FNhapKhachHang(List<KhachHang> khachhang) {
		this.khachhang = khachhang;
		setTitle("F Them Khach Hang");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ma Khach Hang");
		lblNewLabel.setBounds(124, 11, 127, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTenKhachHang = new JLabel("Ten Khach Hang");
		lblTenKhachHang.setBounds(124, 69, 94, 14);
		contentPane.add(lblTenKhachHang);
		
		JLabel lblDiaChi = new JLabel("Dia Chi");
		lblDiaChi.setBounds(124, 136, 48, 14);
		contentPane.add(lblDiaChi);
		
		JLabel lblSoDienThoai = new JLabel("So Dien Thoai");
		lblSoDienThoai.setBounds(124, 197, 94, 14);
		contentPane.add(lblSoDienThoai);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(124, 36, 215, 20);
		contentPane.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(124, 101, 215, 20);
		contentPane.add(txtTenKH);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(124, 166, 215, 20);
		contentPane.add(txtDiaChi);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(122, 222, 217, 20);
		contentPane.add(txtSoDienThoai);
		
		JButton btnLuu = new JButton("Luu");
		btnLuu.setBounds(41, 278, 89, 23);
		contentPane.add(btnLuu);
		
		JButton btnDong = new JButton("Dong");
		btnDong.setBounds(232, 278, 89, 23);
		contentPane.add(btnDong);
		
		//event 
		btnLuu.addActionListener(e -> SaveKH());
		btnDong.addActionListener(e -> Closef());

	}
	private void SaveKH() {
		String maKH = txtMaKH.getText();
		String tenKH = txtTenKH.getText();
		String diaChi = txtDiaChi.getText();
		String soDienThoai = txtSoDienThoai.getText();
		
		if (maKH.isEmpty() || tenKH.isEmpty() || diaChi.isEmpty() || soDienThoai.isEmpty()) {
			System.out.println("Vui long nhap day du thong tin khach hang.");
			return;
		}
		for(int i=0 ;i<khachhang.size();i++) {
			if(khachhang.get(i).getMaKhachHang() == Integer.parseInt(maKH)) {
				JOptionPane.showMessageDialog(this, "Ma khach hang da ton tai, vui long nhap ma khac.");
				return;
			}
		}
		
		KhachHang kh = new KhachHang();
		kh.setMaKhachHang(Integer.parseInt(maKH));
		kh.setTenKhachHang(tenKH);
		kh.setDiaChi(diaChi);
		kh.setSoDienThoai(soDienThoai);
		khachhang.add(kh);
		Data.KHouputstream(khachhang);
		JOptionPane.showMessageDialog(this, "Da luu thong tin khach hang: " + kh.getTenKhachHang());
		this.dispose(); 
		
	}
	private void Closef() {
		this.dispose();
	}

}
