package componet;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
public class KhachHang implements Serializable {
	private static final long serialVersionUID = 1L;
	private String tenKhachHang;
	private String diaChi;
	private String soDienThoai;
	private int maKhachHang ;
	private List<HoaDon> hoaDonList= new ArrayList<>();
	public KhachHang(String tenKhachHang, String diaChi, String soDienThoai, int maKhachHang) {
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.maKhachHang = maKhachHang;
	}
	public KhachHang() {
		this.tenKhachHang = "";
		this.diaChi = "";
		this.soDienThoai = "";
		this.maKhachHang = 0;
	}
	public int getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public boolean KTMaKhachHang(List <KhachHang> khachhang, int maKhachHang) {
		for (KhachHang kh : khachhang) {
			if (kh.getMaKhachHang() == maKhachHang) {
				return false;
			}
		}
		return true; 

	}
	public void AddHoaDon(HoaDon hoaDon) {
		if (this.hoaDonList == null) {
			this.hoaDonList = new java.util.ArrayList<HoaDon>();
		}
		if (this.hoaDonList != null) {
			this.hoaDonList.add(hoaDon);
		} else {
			System.out.println("Khong co thong tin trong hoa don");
		}
	}
//	public String getHoaDonList() {
//		return this.hoaDonList;
//	}
	public String getHoaDonListAsString() {
	    if (hoaDonList == null || hoaDonList.isEmpty()) {
	        return "Khong co hoa don nao.";
	    }
	    StringBuilder sb = new StringBuilder();
	    for (HoaDon hd : hoaDonList) {
	        sb.append(hd.toString()).append("\n");
	        sb.append("thanh tien: ").append(hd.tinhTien()).append("\n");
	        if (hd.getStThanhToan()) {
	            sb.append("Da thanh toan\n");
	        } else {
	            sb.append("Chua thanh toan\n");
	        }
	    }
	    return sb.toString();
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public List<HoaDon> getHoaDonList() {
		return hoaDonList;
	}

	

}
