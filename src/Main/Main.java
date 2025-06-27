package Main;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.time.LocalDate;
import componet.KhachHang;
import componet.HoaDon;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class Main {
	public static void main(String[] args) {
		System.out.println(" Nhom 10");
		List <KhachHang> khachhang= Data.KHinputstream();
		if(Data.KHinputstream()==null) {
			khachhang= new ArrayList<>();
		}
		Scanner scanner= new Scanner(System.in);
//		List <KhachHang> khachhang=new ArrayList<>();
//		khachhang.add(new KhachHang("Nguyen Van A", "123 Nguyen Trai", "0123456789", 101));
//		khachhang.add(new KhachHang("Tran Thi B", "456 Le Loi", "0987654321", 202));
//		khachhang.add(new KhachHang("Le Van C", "789 Tran Hung Dao", "0912345678", 303));
//		khachhang.add(new KhachHang("Pham Thi D", "321 Nguyen Van Cu", "0987654321", 404));
//		Data.KHouputstream(khachhang);
		
		
		while (true) {
		    System.out.println("1. Xem danh sach khach hang");
		    System.out.println("2. Nhap don gia dien");
		    System.out.println("3. Thoat");
		    System.out.println("4. Nhap hoa don tien dien khach hang:");
		    System.out.println("5. Them khach hang moi");
		    System.out.println("6. Sua thong tin khach hang");
		    System.out.print("Nhap lua chon cua ban: ");
		    int mkh;

		    try {
		        int choice = scanner.nextInt();
		        scanner.nextLine(); 

		        if (choice == 1) {
		            for (int i = 1; i < khachhang.size(); i++) {
		                String KH = khachhang.get(i).getTenKhachHang();
		                System.out.println("Khách Hàng " + i + ": " + KH+" "+khachhang.get(i).getMaKhachHang() + " " + khachhang.get(i).getDiaChi() + " " + khachhang.get(i).getSoDienThoai());
		                System.out.println("Danh sach hoa don :"+ khachhang.get(i).getHoaDonListAsString());
		                System.out.println("-----------------------------");
		            }
		            
		            
		        } 
		        
		        
		        else if (choice == 2) {
		        	System.out.println("Don gia:"+HoaDon.getDongiadien());
		            System.out.print("Nhap don gia dien hien tai: ");
		        	int dongiadien = scanner.nextInt();
		        	HoaDon.setDongiadien(dongiadien);
		        } 
		        
		        
		        
		        else if (choice == 3) {
		            System.out.println("Thoat chuong trinh");
		            break;
		            
		        }
			        else if(choice==4) {
			        	System.out.print("Nhap ma khach hang: ");
			        	mkh = scanner.nextInt();
			        	scanner.nextLine();
			        	for(KhachHang kh:khachhang) {
			        		if(kh.getMaKhachHang()==mkh) {
			        			System.out.println("Nhap hoa don cho khach hang:"+kh.getTenKhachHang());
			        			System.out.println("Nhap ma hoa don: ");
			        			String maHoaDon = scanner.nextLine();
			        			System.out.println("Nhap so dien :");
			        			int soDien = scanner.nextInt();
			        			scanner.nextLine();
			        			LocalDate today = LocalDate.now();
			        	        int month = today.getMonthValue();
			        	        int year = today.getYear(); 
			        	        HoaDon hd = new HoaDon(maHoaDon, month, year, soDien, kh);
			        	        kh.AddHoaDon(hd);
			        	        Data.KHouputstream(khachhang);
			        	      	
			        		}
			        	}
			        }
		        else if(choice==5) {
		        	KhachHang kh = new KhachHang();
		        	System.out.print("Nhap ten khach hang: ");
		        	String tenKhachHang = scanner.nextLine();
		        	System.out.print("Nhap dia chi: ");
		        	String diaChi = scanner.nextLine();
		        	System.out.print("Nhap so dien thoai: ");
		        	String soDienThoai = scanner.nextLine();
		        	while(true) {
			        	System.out.print("Nhap ma khach hang: ");
			        	mkh = scanner.nextInt();
			        	if(kh.KTMaKhachHang(khachhang, mkh)!= false) {
			        		break;
			        	}
			        	else {
			        		System.out.println("Ma khach hang da ton tai, vui long nhap lai");
			        	}	
		        	}
		        	kh.setMaKhachHang(mkh);
		        	kh.setTenKhachHang(tenKhachHang);
		        	kh.setDiaChi(diaChi);
		        	kh.setSoDienThoai(soDienThoai);
		        	khachhang.add(kh);
		        	Data.KHouputstream(khachhang);
	
		        }
		        else {
		            System.out.println("Lua chon khong hop le, vui long chon lai");
		        }
		    } catch (InputMismatchException e) {
		        System.out.println("Ban phai nhap mot so!");
		        scanner.nextLine(); 
		    }
		}
	}

}
