package vn.devpro.qlbh.qlcn;

import java.util.Scanner;

import vn.devpro.qlbh.qlbh.QuanLyGioHang;
import vn.devpro.qlbh.qlhh.QuanLyHangHoa;
import vn.devpro.qlbh.qlkh.QuanLyKhachHang;
import vn.devpro.qlbh.qllh.QuanLyLoaiHang;
import vn.devpro.qlbh.timkiem.QuanLyTimKiem;

public class QuanLyBanHang {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		do {
			System.out.println("\n===========CHUONG TRINH QUAN LY BAN HANG=============");
			System.out.println("Chon mot chuc nang quan ly");
			System.out.println("\t1. Cap nhat thong tin he thóng");
			System.out.println("\t2. Quan ly ban hang");
			System.out.println("\t3. Tim kiem thong tin");
			System.out.println("\t0. Thoat");

			int chon;
			System.out.println("nhap lua chon cua ban");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				capNhatThongTinHeThong();
				break;
			case 2:
				quanLyBanHang();
				break;
			case 3:
				timKiemThongTin();
				break;
			case 0:
				System.out.println("Da thoat khoi chuong trinh");
				System.exit(0);
			default:
				System.out.println("Lua chon sai chuc nang");
			}
		} while (true);
	}

	private static void capNhatThongTinHeThong() {
		int chon;
		do {
			System.out.println("\n=============CHUC NANG CAP NHAT TONG TIN HE THONG===========");
			System.out.println("chon mot chuc nang cap nhat");
			System.out.println("\t1. Cap nhat thong tin loai hang");
			System.out.println("\t2. Cap nhat thong tin hang hoa");
			System.out.println("\t3. Cap nhat thong tin khach hang");
			System.out.println("\t0. Quay lai");
			System.out.println("Lua chon chuc nang cap nhat");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				QuanLyLoaiHang.capNhat();
				break;
			case 2:
				QuanLyHangHoa.capNhat();
				break;
			case 3:
				QuanLyKhachHang.capNhat();
				break;
			case 0:
				return;
			default:
				System.out.println("lua chon chuc nang cap nhat khong hop le!!!");
			}

		} while (true);
	}

	private static void quanLyBanHang() {
		System.out.println("\n======QUAN LY BAN HANG=======");
		System.out.println("Chon chuc nang phu hop");
		System.out.println("\t1. Danh cho khach mua hang");
		System.out.println("\t2. Danh cho nguoi quan ly cua hang");
		System.out.println("\t0. Quay lai");
		System.out.println("lua chon cua ban");
		int chon = Integer.parseInt(sc.nextLine());
		switch (chon) {
		case 1: QuanLyGioHang.khachMuaHang(); break;
		case 2: QuanLyGioHang.thongKeDanhSachGioHang(); break;
		case 0: return;
		default: System.out.println("lua chon khong hop le!!!");
		}

	}

	private static void timKiemThongTin() {
		QuanLyTimKiem.quanLyTimKiem();

	}

}
