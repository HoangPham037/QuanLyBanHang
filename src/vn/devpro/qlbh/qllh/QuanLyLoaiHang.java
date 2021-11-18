package vn.devpro.qlbh.qllh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.devpro.qlbh.qlhh.QuanLyHangHoa;

public class QuanLyLoaiHang {
	public static ArrayList<LoaiHang> list = new ArrayList<>();

	static int autoId = 1;
	static Scanner sc = new Scanner(System.in);

	public static void capNhat() {
		int chon;
		do {
			System.out.println("\n===========CAP NHAT THONG TIN LOAI HANG========");
			System.out.println("lua chon chuc nang cap nhat loai hang");
			System.out.println("\t1. Them moi loai hang");
			System.out.println("\t2. Hien thi danh sach loai hang");
			System.out.println("\t3. Sua thong tin loai hang");
			System.out.println("\t4. Xoa thong tin loai hang");
			System.out.println("\t5. Sap xep theo ten loai hang");
			System.out.println("\t6. Quay lai");
			System.out.println("lua chon cua ban: ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				themLoaiHang();
				break;
			case 2:
				hienThiDanhSachLoaiHang();
				break;
			case 3:
				suaLoaiHang();
				break;
			case 4:
				xoaLoaiHang();
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

	private static void themLoaiHang() {
		System.out.println("\n==========THEM LOAI HANG MOI=========");
		System.out.println("nhap thong tin loai hang moi");
		System.out.print("\tNhap ten loai hang:");
		String name = sc.nextLine();
		if (name.trim().length() == 0) {
			System.out.println("\tTen khong duoc de trong");
			return;
		}
		// kiem tra xem ten da ton tai trong danh sach
		int i = 0;
		while (i < list.size() && name.trim().compareToIgnoreCase(list.get(i).getName().trim()) != 0) {
			i++;
		}
		if (i < list.size()) {
			System.out.println("\tTen hang da ton tai trong danh sach");
			return;
		}
		// khoi tao doi tuong loai hang
		LoaiHang lh = new LoaiHang(autoId, name);
		list.add(lh);
		autoId++;
		System.out.println("\nThem loai hang thanh cong.");

	}

	private static void hienThiDanhSachLoaiHang() {
		System.out.println("\n==========DANH SACH LOAI HANG==========");
		System.out.printf("%3s %-10s %-25s %n", "STT", "Ma LH", "Ten loai hang");
		int stt = 1;
		for (LoaiHang loaiHang : list) {
			System.out.printf("%-3d ", stt++);
			loaiHang.display();
		}
		if (stt == 1) {
			System.out.println("\nDanh sach loai hang rong!!!");
		}

	}

	private static void suaLoaiHang() {
		System.out.println("\n========SUA THONG TIN LOAI HANG======");
		System.out.print("\tNhap id loai hang can sua");
		int id = Integer.parseInt(sc.nextLine());
		// tim xem loai hang voi id vua nhap co trong danh sach khong?
		int index = indexOf(id);
		if(index == -1) {
			System.out.println("\tloai hang khong co trong danh sach");
			return;
		}
		System.out.print("\tNhap ten moi cho loai hang");
		String name = sc.nextLine();
		if (name.trim().length() == 0) {
			System.out.println("\tTen khong duoc de trong");
			return;
		}
		// kiem tra xem ten da ton tai trong danh sach
		int i = 0;
		while (i < list.size() && name.trim().compareToIgnoreCase(list.get(i).getName().trim()) != 0) {
			i++;
		}
		if (i < list.size()) {
			System.out.println("\tTen hang da ton tai trong danh sach");
			return;
		}
		//sua theo ten moi
		list.get(index).setName(name);
		System.out.println("\tSua ten loai hang thanh cong");
	}

	private static void xoaLoaiHang() {
		System.out.println("\n=======XOA THONG TIN LOAI HANG======");
		System.out.print("\tNhap id loai hang can sua");
		int id = Integer.parseInt(sc.nextLine());
		// tim xem loai hang voi id vua nhap co trong danh sach khong?
		int index = indexOf(id);
		if(index == -1) {
			System.out.println("\tloai hang khong co trong danh sach");
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
		Collections.sort(list, new Comparator<LoaiHang>() {
			public int compare(LoaiHang o1, LoaiHang o2) {
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
