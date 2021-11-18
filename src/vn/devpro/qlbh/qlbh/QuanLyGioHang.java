package vn.devpro.qlbh.qlbh;

import java.util.ArrayList;
import java.util.Scanner;

import vn.devpro.qlbh.qlkh.KhachHang;
import vn.devpro.qlbh.qlkh.QuanLyKhachHang;

public class QuanLyGioHang {
	public static ArrayList<GioHang> list = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	static int autoId = 1;
	public static void khachMuaHang() {
		// khoi tao mot gio hang
		GioHang gioHang = new GioHang();
		int chon;
		System.out.println("\n--------Chao mung ban, moi ban mua hang");
		do {
			System.out.println("chon chuc nang mua hang");
			System.out.println("\t1. Them hang vao gio");
			System.out.println("\t2. Xem thong tin gio");
			System.out.println("\t3. Sua thong tin gio");
			System.out.println("\t4. Xoa thong tin gio");
			System.out.println("\t5. Thanh toan gio hang");
			System.out.println("\t6. Huy gio hang");
			System.out.println("\t0. Tro ve");

			System.out.println("chon mot chuc nang");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				gioHang.themHangVaoGio();
				break;
			case 2:
				gioHang.hienThiGioHang();
				break;
			case 3:
				gioHang.suaHangTrongGio();
				break;
			case 4:
				gioHang.xoaHangHoaTrongGio();
				break;
			case 5:
				thanhToanGioHang(gioHang);
				break;
			case 6:
				gioHang = null;
				break;
			case 0:
				return;
			default:
				System.out.println("lua chon khong hop le!!!");
			}
		} while (true);
	}
	//Thanh toan gio hang
		public static void thanhToanGioHang(GioHang gioHang) {
			System.out.println("\n=====Thanh toan gio hang====");
			gioHang.setId(autoId++);
			System.out.println("\tLua chon loai khach hang:");
			System.out.println("\t1. khach da mua hang(co thong tin khach hang trong ds KH");
			System.out.println("\t2. khach mua hang hang lan dau");
			System.out.println("\t0. Tro lai");
			int chon;
			do {
				System.out.println("Moi ban chon 1 hoac 2: ");
				chon = Integer.parseInt(sc.nextLine());
			}while(chon != 1 && chon != 2);
			
			if(chon == 2) {
				gioHang.setIdkh(autoId);
				String name;
				do {
					System.out.println("nhap ten khach hang");
					name = sc.nextLine();
					if(name.trim().length() == 0) {
						System.out.println("\tTen khach hang ko duoc de trong");
					}
					
				}while(name.trim().length() == 0);
				////them khach hang moi vao danh sach kh
				QuanLyKhachHang.list.add(new KhachHang(autoId++, name));
			}
			if(chon == 1) {
				System.out.println("\tNhap id khach hang");
				int idkh = Integer.parseInt(sc.nextLine());
				int index1 = QuanLyKhachHang.indexOf(idkh);
				if(index1 == -1) {
					System.out.println("\tKhach hang chua co trong danh sach khach hang");
					gioHang.setIdkh(autoId);
					String name;
					do {
						System.out.println("nhap ten khach hang");
						name = sc.nextLine();
						if(name.trim().length() == 0) {
							System.out.println("\tTen khach hang ko duoc de trong");
						}
						
					}while(name.trim().length() == 0);
					////them khach hang moi vao danh sach kh
					QuanLyKhachHang.list.add(new KhachHang(autoId++, name));
				}
				else {
					gioHang.setId(idkh);
				}
			}
			gioHang.hienThiHoaDon();
			//them gio hang vao danh sach quan li
			list.add(gioHang);
			System.out.println("\tCam on ban da den voi cua hang, chao than ai!");
			return;
		}
		//chuc nang danh cho nguoi quan li
		//-thong ke cac gio hang
		//-tinh tong doanh thu
		public static void thongKeDanhSachGioHang() {
			int chon;
			do {
				System.out.println("\n=========THONG KE========");
				System.out.println("chon 1 chuc nang");
				System.out.println("\t1. Thong ke danh sach gio hang");
				System.out.println("\t2. Tinh tong doanh thu");
				System.out.println("\t0. Quay lai");
				System.out.println("lua chon cua ban:");
				chon = Integer.parseInt(sc.nextLine());
				switch (chon) {
				case 1:thongKeGioHang(); break;
				case 2:tongDoanhThu(); break;
				case 0: return;
				default: System.out.println("lua chon sai!!!");
				}
			}while(true);
			
		}
		private static void thongKeGioHang() {
			System.out.println("\n-------Danh sach cac gio hang-------");
			for(GioHang giohang: list) {
				giohang.hienThiHoaDon();
				System.out.println("=======================================");
			}
			
		}
		private static void tongDoanhThu() {
			double totalRevenue = 0;
			for(GioHang giohang: list) {
				//tinh tong tien cua moi gio hang
				double sumTotal = 0;
				for(HangBan h : giohang.getList()) {
					sumTotal += h.total();
				}
				totalRevenue += sumTotal;
			}
			System.out.println("\tTong cong co " + list.size() + "gio hang");
			System.out.printf("\tTong doanh thu la: %.2fvnd%n", totalRevenue);
			
		}
}
