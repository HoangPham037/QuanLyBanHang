package vn.devpro.qlbh.qlkh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.devpro.qlbh.qlhh.QuanLyHangHoa;

public class QuanLyKhachHang {
	public static ArrayList<KhachHang> list = new ArrayList<>();

		static int autoId = 1;
		static Scanner sc = new Scanner(System.in);

		public static void capNhat() {
			int chon;
			do {
				System.out.println("\n===========CAP NHAT THONG TIN KHACH HANG========");
				System.out.println("lua chon chuc nang cap nhat Khach hang");
				System.out.println("\t1. Them moi Khach hang");
				System.out.println("\t2. Hien thi danh sach khach hang");
				System.out.println("\t3. Sua thong tin khach hang");
				System.out.println("\t4. Xoa thong tin khach hang");
				System.out.println("\t5. Sap xep theo ten khach hang");
				System.out.println("\t6. Quay lai");
				System.out.println("lua chon cua ban: ");
				chon = Integer.parseInt(sc.nextLine());
				switch (chon) {
				case 1:
					themKhachHang();
					break;
				case 2:
					hienThiDanhSachKhachHang();
					break;
				case 3:
					suaKhachHang();
					break;
				case 4:
					xoaKhachHang();
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

		private static void themKhachHang() {
			System.out.println("\n==========THEM KHACH HANG MOI=========");
			System.out.println("nhap thong tin khach hang moi");
			System.out.print("\tNhap ten khach hang:");
			String name = sc.nextLine();
			if (name.trim().length() == 0) {
				System.out.println("\tTen khong duoc de trong");
				return;
			}
			// khoi tao doi tuong loai hang
			KhachHang kh = new KhachHang(autoId, name);
			list.add(kh);
			autoId++;
			System.out.println("\nThem khach hang thanh cong.");

		}

		private static void hienThiDanhSachKhachHang() {
			System.out.println("\n==========DANH SACH KHACH HANG==========");
			System.out.printf("%3s %-10s %-25s %n", "STT", "Ma KH", "Ten khach hang");
			int stt = 1;
			for (KhachHang khachhang : list) {
				System.out.printf("%-3d ", stt++);
				khachhang.display();
			}
			if (stt == 1) {
				System.out.println("\nDanh sach khach hang rong!!!");
			}

		}

		private static void suaKhachHang() {
			System.out.println("\n========SUA THONG TIN KHACH HANG======");
			System.out.print("\tNhap id khach hang can sua");
			int id = Integer.parseInt(sc.nextLine());
			// tim xem loai hang voi id vua nhap co trong danh sach khong?
			int index = indexOf(id);
			if(index == -1) {
				System.out.println("\tKhach hang khong co trong danh sach");
				return;
			}
			System.out.print("\tNhap ten moi cho khach hang");
			String name = sc.nextLine();
			if (name.trim().length() == 0) {
				System.out.println("\tTen khong duoc de trong");
				return;
			}
			list.get(index).setName(name);
			System.out.println("\tSua ten loai hang thanh cong");
		}

		private static void xoaKhachHang() {
			System.out.println("\n=======XOA THONG TIN KHACH HANG======");
			System.out.print("\tNhap id khach hang can sua");
			int id = Integer.parseInt(sc.nextLine());
			// tim xem loai hang voi id vua nhap co trong danh sach khong?
			int index = indexOf(id);
			if(index == -1) {
				System.out.println("\tKhach hang khong co trong danh sach");
				return;
			}
			//co thi kiem tra loai hang da su dung trong danh hang hoa chua?
			int i = 0;
			while(i < QuanLyHangHoa.list.size() && QuanLyHangHoa.list.get(i).getIdlh() != id) {
				i++;
			}
			if(i <  QuanLyHangHoa.list.size()) {
				System.out.println("\tLoai hang da su dung trong danh sach loai hang, khong the xoa");
				return;
			}
			//khong thi xoa
			list.remove(index);
			System.out.println("\tXoa loai hang thanh cong");

		}

		private static void sapXepDs() {
			Collections.sort(list, new Comparator<KhachHang>() {
				public int compare(KhachHang o1, KhachHang o2) {
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
