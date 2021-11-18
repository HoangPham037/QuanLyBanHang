package vn.devpro.qlbh.qlhh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.devpro.qlbh.qllh.LoaiHang;
import vn.devpro.qlbh.qllh.QuanLyLoaiHang;

public class QuanLyHangHoa {

	public static ArrayList<HangHoa> list = new ArrayList<>();
	static int autoId = 1;
	static Scanner sc = new Scanner(System.in);

	public static void capNhat() {
		int chon;
		do {
			System.out.println("\n===========CAP NHAT THONG TIN HANG HOA========");
			System.out.println("lua chon chuc nang cap nhat hang hoa");
			System.out.println("\t1. Them moi hang hoa");
			System.out.println("\t2. Hien thi danh sach hang hoa");
			System.out.println("\t3. Sua thong tin hang hoa");
			System.out.println("\t4. Xoa thong tin hang hoa");
			System.out.println("\t5. Sap xep theo ten hang hoa");
			System.out.println("\t6. Quay lai");
			System.out.println("lua chon cua ban: ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				themHangHoa();
				break;
			case 2:
				hienThiDanhSachHangHoa();
				break;
			case 3:
				suaHangHoa();
				break;
			case 4:
				xoaHangHoa();
				break;
			case 5:
				sapXepDs();
				break;
			case 0:
				return;
			default:
				System.out.println("lua chon khong hop le!!!");
			}
		} while (true);
	}
	
	private static void themHangHoa() {
		System.out.println("\n==============THEM HANG HOA MOI VAO DANH SACH============");
		System.out.println("\tChon ma loai hang: ");
		int idlh = Integer.parseInt(sc.nextLine());
		//Kiem tra xem idlh co trong danh sach loai hang khong?
		int index = QuanLyLoaiHang.indexOf(idlh);
		if(index == -1) {
			System.out.println("\tLoai hang khong co trong danh sach");
			return;
		}
		System.out.print("\tNhap ten hang hoa");
		String name = sc.nextLine();
		if(name.trim().length() == 0) {
			System.out.println("\tTen hang hoa khong duoc de trong");
			return;
		}
		System.out.println("\tSo luong");
		double amount = Double.parseDouble(sc.nextLine());
		if(amount < 0) {
			System.out.println("\tSo luong phai khong am");
			return;
		}
		System.out.println("\tDon gia");
		double price = Double.parseDouble(sc.nextLine());
		if(amount < 0) {
			System.out.println("\tdon phai khong am");
			return;
		}
		
		//khoi tao doi tuong hang hoa va them vao list
		HangHoa hh = new HangHoa(autoId, idlh, name, amount, price);
		list.add(hh);
		autoId++;
		System.out.println("\tThem hang hoa thanh cong!");
	}

	private static void hienThiDanhSachHangHoa() {
		System.out.println("\n==========DANH SACH HANG HOA==========");
		System.out.printf("%3s %-10s %-25s %-30s %8s %13s %14s %n", "STT","Ma hang", "Ten loai hang",
				"Ten hang hoa", "so luong", "don gia", "Thanh tien");
		int stt = 1;
		for (HangHoa hh : list) {
			System.out.printf("%-3d ", stt++);
			hh.display();
		}
		if (stt == 1) {
			System.out.println("\nDanh sach hang hoa rong!!!");
		}
		
	}

	private static void suaHangHoa() {
		int chon;
		System.out.println("\n=============SUA THONG TIN HANG HOA===========");
		System.out.println("\tNhap id can sua");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOf(id);
		if(index == -1) {
			System.out.println("Hang hoa co id = " + index + " khong co trong danh sach");
			return;
		}
		do {
			System.out.println("\nChon thong tin can sua");
			System.out.println("\t1. Sua ten hang hoa");
			System.out.println("\t2. Sua so luong");
			System.out.println("\t3. Sua don gia");
			System.out.println("\t4. Sua ma loai hang");
			System.out.println("\t0. Tro ve");
			System.out.println("Lua chon cua ban");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1: 
				suaTenHang(index);
				break;
			case 2: 
				suaSoLuong(index);
				break;
			case 3:
				suaDonGia(index);
				break;
			case 4:
				suaMaloaiHang(index);
				break;
			case 0:
				return;
				default: System.out.println("Lua chon khonh hop le");
			}
			
		}while(true);
		
	}

	private static void suaMaloaiHang(int index) {
		System.out.println("\tNhap ma loai hang moi");
		int idlh = Integer.parseInt(sc.nextLine());
		if(QuanLyLoaiHang.indexOf(idlh) == -1) {
			System.out.println("\tMa loai hang vua nhap khong co trong danh sach loai hang");
			return;
		}
		list.get(index).setIdlh(idlh);
		System.out.println("\tSua thong tin ma loai hang thanh cong");
		
	}

	private static void suaTenHang(int index) {
		System.out.println("nhap ten moi cho hang hoa");
		String name = sc.nextLine();
		if(name.trim().length() == 0) {
			System.out.println("ten khong duoc de trong");
			return;
		}
		list.get(index).setName(name);
		System.out.println("\tSua ten thanh cong");
	}

	private static void suaSoLuong(int index) {
		System.out.println("\tNhap so luong moi cho hang hoa");
		double price = Double.parseDouble(sc.nextLine());
		if(price < 0) {
			System.out.println("\tso luong khong am!");
			return;
		}
		list.get(index).setAmount(price);
		System.out.println("\tSua so luong thanh cong");
	}

	private static void suaDonGia(int index) {
		System.out.println("\tNhap so don gia moi cho hang hoa");
		double amount = Double.parseDouble(sc.nextLine());
		if(amount < 0) {
			System.out.println("\tdon gia khong am!");
			return;
		}
		list.get(index).setPrice(amount);
		System.out.println("\tSua so luong thanh cong");
		
	}

	private static void xoaHangHoa() {
		System.out.println("\n=============XOA THONG TIN HANG HOA===========");
		System.out.println("\tNhap id can xoa");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOf(id);
		if(index == -1) {
			System.out.println("Hang hoa co id = " + index + " khong co trong danh sach");
			return;
		}
		list.remove(index);
		System.out.println("\txoa hang hoa thanh cong");
	}

	private static void sapXepDs() {
		Collections.sort(list, new Comparator<HangHoa>() {
			public int compare(HangHoa o1, HangHoa o2) {
				return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
			};
		});

	}

	// ham nhan vao id, tra ve index neu id co trong ds, nguoc lai tra ve -1
	public static int indexOf(int id) {
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getId() == id) {
				return index;
			}
		}
		return -1;
	}
}
