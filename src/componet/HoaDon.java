package componet;

public class HoaDon {
	private String maHoaDon;
	private int Thang;
	private int Nam;
	private KhachHang khachHang;
	private static int dongiadien = 3000;
	private int soDien;
	public HoaDon(String maHoaDon, int thang, int nam, int soDien, KhachHang khachHang) {
		this.maHoaDon = maHoaDon;
		this.Thang = thang;
		this.Nam = nam;
		this.soDien = soDien;
		this.khachHang = khachHang;
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
	public static int getDongiadien(int dongiadien) {
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
		return "HoaDon [maHoaDon=" + maHoaDon + ", Thang=" + Thang + ", Nam=" + Nam + ", soDien=" + soDien
				+ ", tongTien=" + tinhTien() + "]";
	}

}
