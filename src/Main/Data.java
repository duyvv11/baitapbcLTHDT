package Main;
import componet.KhachHang;
import java.util.List;
public class Data {
	// luu du lieu khach hang
	public static void KHouputstream(List<KhachHang> khachHang) {
		try (java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(new java.io.FileOutputStream("khachhang.txt"))) {
			oos.writeObject(khachHang);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		
	}
	// doc du lieu khach hang
	public static List<KhachHang> KHinputstream() {
		List<KhachHang> khachHang = null;
		try (java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream("khachhang.txt"))) {
			khachHang =(List<KhachHang>) ois.readObject();
		} catch (java.io.IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return khachHang;
	}

	

}
