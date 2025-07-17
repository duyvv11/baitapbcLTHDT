package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.List;
import componet.KhachHang;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import componet.HoaDon;
import javax.swing.JCheckBox;
public class FNhapHoaDon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel labell;
	private List<KhachHang> khachhang;
	private JTextField txtMaKH;
	private JTextField MaHD;
	private JTextField txtThang;
	private JTextField txtNam;
	private JSpinner spnSoDien;
	private JCheckBox ckbThanhToan;
	LocalDate today = LocalDate.now();
	int thanght=today.getMonthValue();
	int namht=today.getYear();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public FNhapHoaDon(List<KhachHang> khachhang) {
		this.khachhang = khachhang;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 382);
		labell = new JPanel();
		labell.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(labell);
		labell.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ma Khach Hang");
		lblNewLabel.setBounds(108, 34, 176, 14);
		labell.add(lblNewLabel);
		
		JLabel lblMaHoaDon = new JLabel("Ma Hoa Don");
		lblMaHoaDon.setBounds(110, 84, 162, 14);
		labell.add(lblMaHoaDon);
		
		JLabel lblThang = new JLabel("Thang");
		lblThang.setBounds(111, 131, 130, 14);
		labell.add(lblThang);
		
		JLabel lblNam = new JLabel("Nam ");
		lblNam.setBounds(111, 180, 48, 14);
		labell.add(lblNam);
		
		JLabel lblSoDien = new JLabel("So dien");
		lblSoDien.setBounds(108, 230, 48, 14);
		labell.add(lblSoDien);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(105, 53, 96, 20);
		labell.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		MaHD = new JTextField();
		MaHD.setColumns(10);
		MaHD.setBounds(105, 100, 96, 20);
		labell.add(MaHD);
		
		spnSoDien = new JSpinner();
		spnSoDien.setBounds(108, 255, 75, 20);
		labell.add(spnSoDien);
		
		JButton btnLuu = new JButton("luu");
		btnLuu.setBounds(67, 297, 89, 23);
		labell.add(btnLuu);
		
		JButton btnDong = new JButton("dong");
		btnDong.setBounds(238, 297, 89, 23);
		labell.add(btnDong);
		
		txtThang = new JTextField();
		txtThang.setEditable(false);
		txtThang.setBounds(105, 156, 96, 20);
		txtThang.setText(String.valueOf(thanght));
		labell.add(txtThang);
		txtThang.setColumns(10);
		
		txtNam = new JTextField();
		txtNam.setEditable(false);
		txtNam.setBounds(105, 205, 96, 20);
		txtNam.setText(String.valueOf(namht));
		labell.add(txtNam);
		txtNam.setColumns(10);
		
		ckbThanhToan = new JCheckBox("Đã Thanh Toán");
		ckbThanhToan.setBounds(275, 204, 99, 23);
		labell.add(ckbThanhToan);
		
		//event
		btnLuu.addActionListener(e-> SaveHD());
		btnDong.addActionListener(e-> Closef());

	}
	private void SaveHD() {
		int maKH = Integer.parseInt(txtMaKH.getText());
		String maHD = MaHD.getText();
		int thang =Integer.parseInt(txtThang.getText());
		int nam = Integer.parseInt(txtNam.getText());
		int soDien = Integer.parseInt(spnSoDien.getValue().toString());
		boolean stThanhToan = ckbThanhToan.isSelected();
		boolean checkmkh=false;
		
		for (KhachHang kh : khachhang) {
			if (kh.getMaKhachHang()== maKH) {
				List<HoaDon> hoaDonList = kh.getHoaDonList();
				if(hoaDonList !=null) {
					for(HoaDon hd : hoaDonList) {
						if(hd.getMaHoaDon().equals(maHD)||hd.getThang() == thang && hd.getNam() == nam) {
							JOptionPane.showMessageDialog(labell, "Ma hoa don da ton tai hoac da co hoa don trong thang nay");
							return;
						}
					}
				}
				HoaDon hd = new HoaDon(maHD,thang, nam, soDien, kh, stThanhToan);
				kh.AddHoaDon(hd);
				JOptionPane.showMessageDialog(labell, "Da luu hoa don thanh cong");
				Data.KHouputstream(khachhang);
				checkmkh = true;
				break;
			} 
		}
		if(checkmkh == false) {
			JOptionPane.showMessageDialog(labell, "Khach hang khong ton tai");
		}
		else {
			this.dispose();
		}

	}
	private void Closef() {
		this.dispose();
	}

}
