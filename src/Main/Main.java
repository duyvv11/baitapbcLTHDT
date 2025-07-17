package Main;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import componet.KhachHang;
import componet.HoaDon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import Main.FNhapKhachHang;


public class Main extends JFrame {

//	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDonGiaHt;
	private List<KhachHang> khachhang; ;
	private JTextArea textArea;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		khachhang = Data.KHinputstream();
		if (khachhang == null) {
			khachhang = new ArrayList<>();
		}
		
		
		JButton btnNhapHoaDon = new JButton("Nhập Hóa Đơn Tiền Điện");
		btnNhapHoaDon.setBounds(298, 227, 191, 23);
		contentPane.add(btnNhapHoaDon);
		
		JButton btnXemDanhSach = new JButton("Xem Danh Sách Khách Hàng");
		btnXemDanhSach.setBounds(298, 193, 191, 23);
		contentPane.add(btnXemDanhSach);
		
		JButton btnThemKhachHang = new JButton("Thêm Khách Hàng Mới");
		btnThemKhachHang.setBounds(298, 261, 191, 23);
		contentPane.add(btnThemKhachHang);
		
		JButton btnSuaThongTin = new JButton("Sửa Thông Tin Khách Hàng");
		btnSuaThongTin.setBounds(298, 295, 191, 23);
		contentPane.add(btnSuaThongTin);
		
		JButton btnNhapKH = new JButton("Nhập Khách Hàng Mới");
		btnNhapKH.setBounds(298, 159, 191, 23);
		contentPane.add(btnNhapKH);
		
		JButton btnNhapDonGia = new JButton("Nhập Đơn Giá Điện Hiện Tại");
		btnNhapDonGia.setBounds(298, 329, 191, 23);
		contentPane.add(btnNhapDonGia);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true); 
		textArea.setWrapStyleWord(true);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 118, 278, 235); 
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		contentPane.add(scrollPane);


		
		txtDonGiaHt = new JTextField();
		txtDonGiaHt.setBounds(393, 11, 96, 20);
		contentPane.add(txtDonGiaHt);
		txtDonGiaHt.setText(String.valueOf(HoaDon.dongiadien));
		txtDonGiaHt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Đơn Giá ĐIện Hiện Tại vnd/kw");
		lblNewLabel.setBounds(234, 10, 157, 23);
		contentPane.add(lblNewLabel);
		
		// event click
		btnXemDanhSach.addActionListener(e -> xemDanhSachKhachHang());
		btnNhapKH.addActionListener(e -> themKhachHangMoi());
		btnNhapHoaDon.addActionListener(e->NhapHoaDon());
			

	}
	private void xemDanhSachKhachHang() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<khachhang.size();i++) {
		sb.append("Ma Khach Hang: ").append(khachhang.get(i).getMaKhachHang()).append("\n")
		  .append("Ten Khach Hang: ").append(khachhang.get(i).getTenKhachHang()).append("\n")
		  .append("Dia Chi: ").append(khachhang.get(i).getDiaChi()).append("\n")
		  .append("So Dien Thoai: ").append(khachhang.get(i).getSoDienThoai()).append("\n")
		  .append("Hoa Don: ").append(khachhang.get(i).getHoaDonListAsString()).append("\n")
		  .append("-----------------------------\n");
		}
		textArea.setText(sb.toString());
		}
	private void themKhachHangMoi() {
		FNhapKhachHang frame= new FNhapKhachHang(khachhang);
		frame.setVisible(true);
	}
	private void NhapHoaDon() {
		FNhapHoaDon frame = new FNhapHoaDon(khachhang);
		frame.setVisible(true);
	}
}
	
