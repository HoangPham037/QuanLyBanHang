package vn.devpro.qlbh.qlbh;

import java.util.ArrayList;
import java.util.Scanner;

import vn.devpro.qlbh.qlhh.QuanLyHangHoa;
import vn.devpro.qlbh.qlkh.QuanLyKhachHang;

public class GioHang {
	private int id;
	private int idkh;
	private ArrayList<HangBan> list = new ArrayList<>();

	public GioHang() {
		super();
	}

	public GioHang(int id, int idkh, ArrayList<HangBan> list) {
		super();
		this.id = id;
		this.idkh = idkh;
		this.list = list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdkh() {
		return idkh;
	}

	public void setIdkh(int idkh) {
		this.idkh = idkh;
	}

	public ArrayList<HangBan> getList() {
		return list;
	}

	public void setList(ArrayList<HangBan> list) {
		this.list = list;
	}

	Scanner sc = new Scanner(System.in);

	public void themHangVaoGio() {
		System.out.println("\n===========THEM HANG VAO GIO==========");
		System.out.println("\tNhap ma hang hoa can them vao gio");
		int idhh = Integer.parseInt(sc.nextLine());
		// kiem tra id hang hoa co trong ds hang hoa hay ko?
		int index1 = QuanLyHangHoa.indexOf(idhh);
		if (index1 == -1) {
			System.out.println("\tHang hoa khong co de ban");
			return;
		}
		System.out.print("\tNhap so luong muuon mua: ");
		double amount = Double.parseDouble(sc.nextLine());

		if (amount <= 0) {
			System.out.println("\tSo luong mua phai lon hon 0");
			return;
		}
		// tim hang trong gio
		int index2 = intdexOf(idhh);
		if (index2 == -1) {// TH hang vua chon chua co trong gio
			// kiem tra so luong mua vuot qua so luong co trong danh sach hang ban
			if (amount > QuanLyHangHoa.list.get(index1).getAmount()) {
				System.out.println("\tSo hang hien tai khong du de ban");
				return;
			}
			list.add(new HangBan(idhh, amount));
			System.out.println("\tThem hang thanh cong");
		} else {// TH hang vua chon da co trong gio
			double newAmount = amount + list.get(index2).getAmount();
			if (newAmount > QuanLyHangHoa.list.get(index1).getAmount()) {
				System.out.println("\tSo hang hien tai khong du de ban");
				return;
			}
			list.get(index2).setAmount(newAmount);
			System.out.println("\tThem hang hoa thanh cong!");
		}

	}

	// Hien thi gio hang
	public void hienThiGioHang() {
		System.out.println("\n==========HOA DON THANH TOAN=========");
//		System.out.println("\tMa hoa don: " + id); //tam su dung la ma gio hang
//		//truy van ten khach hang trong ds khach hang thong qua id khach hang
//		int index = QuanLyKhachHang.indexOf(idkh);
//		if(index == -1) {
//			return;
//		}
//		String name = QuanLyKhachHang.list.get(index).getName();
//		System.out.println("\tTen khach hang: "+ name);
		System.out.println("danh sach hang hoa");
		int stt = 1;
		double sumOfTotal = 0;
		System.out.printf("%3s %-30s %8s %13s %14s%n", "STT", "Ten hang hoa", "so luong", "Don gia", "Thanh tien");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%-3s", stt++);
			list.get(i).display();
			sumOfTotal += list.get(i).total();
		}
		System.out.printf("Cong thanh tien: %,14.2f", sumOfTotal);
	}

	public void suaHangTrongGio() {
		System.out.println("\n=======Sua hang trong gio======");
		System.out.println("\tNhap id hang hoa can sua");
		int idhh = Integer.parseInt(sc.nextLine());
		int index = intdexOf(idhh);
		if (index == -1) {
			System.out.println("\tHang hoa khong co trong gio");
			return;
		}
		System.out.println("\tNhap so luong moi");
		double newAmount = Double.parseDouble(sc.nextLine());
		if (newAmount <= 0) {
			System.out.println("\tso luong hang hoa phai lon hon 0!!!");
			return;
		}
		int index1 = QuanLyHangHoa.indexOf(idhh);
		if (newAmount > QuanLyHangHoa.list.get(index1).getAmount()) {
			System.out.println("\tSo luong hang ko du");
			return;
		}
		list.get(index).setAmount(newAmount);
		System.out.println("\tSua thong tin hang trong gio thanh cong!");
	}

	// xoa hang hoa trong gio
	public void xoaHangHoaTrongGio() {
		System.out.println("\n=======Xoa hang trong gio======");
		System.out.println("\tNhap id hang hoa can sua");
		int idhh = Integer.parseInt(sc.nextLine());
		int index = intdexOf(idhh);
		if (index == -1) {
			System.out.println("\tHang hoa khong co trong gio");
			return;
		}
		list.remove(index);
		System.out.println("\tXoa hang trong gio thanh cong!");
	}

	public void hienThiHoaDon() {
		System.out.println("\n==========HOA DON BAN LE=========");
		System.out.println("\tMa hoa don: " + id); // tam su dung la ma gio hang
		// truy van ten khach hang trong ds khach hang thong qua id khach hang
		int index = QuanLyKhachHang.indexOf(idkh);
		if (index == -1) {
			return;
		}
		String name = QuanLyKhachHang.list.get(index).getName();
		System.out.println("\tTen khach hang: " + name);
		System.out.println("danh sach hang hoa");
		int stt = 1;
		double sumOfTotal = 0;
		System.out.printf("%3s %-30s %8s %13s %14s%n", "STT", "Ten hang hoa", "so luong", "Don gia", "Thanh tien");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%-3s", stt++);
			list.get(i).display();
			sumOfTotal += list.get(i).total();
		}
		System.out.printf("Cong thanh tien: %,14.2f", sumOfTotal);

	}

	// ham kiem tra hang hoa da co trong gio hay chua
	int intdexOf(int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIdhh() == id) {
				return i;
			}
		}
		return -1;
	}
}
