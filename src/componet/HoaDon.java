package componet;
import java.io.Serializable;
public class HoaDon implements Serializable{
	private static final long serialVersionUID = 1L;
	private String maHoaDon;
	private int Thang;
	private int Nam;
	private KhachHang khachHang;
	public static int dongiadien = 3000;
	private int soDien;
	private boolean stThanhToan=false;
	public HoaDon(String maHoaDon, int thang, int nam, int soDien, KhachHang khachHang,Boolean stThanhToan) {
		this.maHoaDon = maHoaDon;
		this.Thang = thang;
		this.Nam = nam;
		this.soDien = soDien;
		this.khachHang = khachHang;
		this.stThanhToan=stThanhToan;
	}
	@Override
	public String toString() {
	    return "Ma hoa don: " + maHoaDon +
	           ", Thang: " + Thang +
	           ", Nam: " + Nam +
	           ", So dien: " + soDien ;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public int getThang() {
		return Thang;
	}
	public void setThang(int thang) {
		Thang = thang;
	}
	public int getNam() {
		return Nam;
	}
	public void setNam(int nam) {
		Nam = nam;
	}
	public static int getDongiadien() {
		return dongiadien;
	}
	public static void setDongiadien(int dongiadien) {
		HoaDon.dongiadien = dongiadien;
	}
	public int getSoDien() {
		return soDien;
	}
	public void setSoDien(int soDien) {
		this.soDien = soDien;
	}
	public long tinhTien() {
		return soDien * dongiadien;
	}
	public String xuaHoaDon(String tenKhachHang) {
		System.out.println("Hoa Don Cua Khach Hang: " + tenKhachHang);
		String STTT;
		if(stThanhToan==true) {
			STTT="Da Thanh Toan";	
		}
		else
			STTT="Chua Thanh Toan";
		return "HoaDon [maHoaDon=" + maHoaDon + ", Thang=" + Thang + ", Nam=" + Nam + ", soDien=" + soDien
				+ ", tongTien=" + tinhTien() + ",ThanhToan: "+STTT+"]";
	}
	public boolean setStThanhToan(){
		return stThanhToan=true;
		
	}
	public boolean getStThanhToan() {
		return stThanhToan;
	}

}
