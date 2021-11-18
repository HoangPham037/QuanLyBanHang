package vn.devpro.qlbh.timkiem;

import java.util.ArrayList;
import java.util.Scanner;

import vn.devpro.qlbh.qlhh.HangHoa;
import vn.devpro.qlbh.qlhh.QuanLyHangHoa;
import vn.devpro.qlbh.qllh.LoaiHang;
import vn.devpro.qlbh.qllh.QuanLyLoaiHang;

public class QuanLyTimKiem {
	static Scanner sc = new Scanner(System.in);
	public static void quanLyTimKiem() {
		int chon;
		do {
		System.out.println("\n=========TIM KIEM THONG TIN========");
		System.out.println("chon thong tin tim kiem");
		System.out.println("\t1. Tim kiem thong tin loai hang");
		System.out.println("\t2. Tim kiem thing tin hang hoa");
		System.out.println("\t3. Tim kiem thing tin khach hang");
		System.out.println("\t4. Tim kiem thing tin gio hang");
		System.out.println("\t0. Quay lai.");
		System.out.println("lua chon cua ban");
		chon = Integer.parseInt(sc.nextLine());
		switch (chon) {
		case 1: timKiemLoaiHang(); break;
		case 2: timKiemHangHoa(); break;
		case 3: timKiemKhachHang(); break;
		case 4: timKiemGioHang(); break;
		case 0: return;
		default: System.out.println("nhap sai lua chon!!!");
		}
		}while(true);
	}
	private static void timKiemLoaiHang() {
		int chon;
		do {
			System.out.println("\n==========TIM KIEM THONG TIN HANG HOA========");
			System.out.println("\tCac tieu chi tim kiem");
			System.out.println("\t1. Tim kiem theo ma loai hang");
			System.out.println("\t2. Tim kiem theo ten loai hang");
			System.out.println("lua chon cua ban");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon)
			{
			case 1: tkIdLoaiHang(); break;
			case 2: tkTenLoaiHang(); break;
			case 0: return;
			default: System.out.println("lua chon ko phu hop!!!");
			}
		}while(true);
		
	}
	private static void tkIdLoaiHang() {
		System.out.println("\n======TIM KIEM THEO MA LOAI HANG========");
		System.out.println("\tNhap ma loai hang: ");
		int id = Integer.parseInt(sc.nextLine());
		int index1 = QuanLyLoaiHang.indexOf(id);
		if(index1 == -1 )
		{
			System.out.println("\tKhong tim thay ket qua");
		}
		System.out.println("Thong tin loai hang can tim la: ");
		QuanLyLoaiHang.list.get(index1).display();
	}
	private static void tkTenLoaiHang() {
		System.out.println("\n======TIM KIEM THEO TEN LOAI HANG========");
		System.out.println("\tNhap ten loai hang: ");
		String name = sc.nextLine();
		int dem = 0;
		for( LoaiHang lh: QuanLyLoaiHang.list)
		{
			if(lh.getName().trim().indexOf(name.trim()) != -1)
			{
				dem++;
				System.out.printf("%3d", dem);
				lh.display();
			}
		}
		if(dem == 0)
		{
			System.out.println("Khong tim thay ket qua");
		}
		else
		{
			System.out.println("tim thay " + dem + " ket qua");
		}
	}
	private static void timKiemHangHoa() {
		int chon;
		do {
		System.out.println("\n==========TIM KIEM THONG TIN HANG HOA========");
		System.out.println("\tCac tieu chi tim kiem");
		System.out.println("\t1. Tim kiem theo ma hang");
		System.out.println("\t2. Tim kiem theo ten hang");
		System.out.println("\t3. Tim kiem theo ten loai hang");
		System.out.println("\t4. Tim kiem theo khung gia hang");
		System.out.println("\t0. Quay lai");
		System.out.print("lua chon tieu chi: ");
		chon = Integer.parseInt(sc.nextLine());
		switch (chon) {
		case 1: tkTheoMaHang(); break;
		case 2: tkTheoTenHang(); break;
		case 3: tkTheoTenLoaiHang(); break;
		case 4: tkTheoKhungGioHang(); break;
		case 0: return;
		default: System.out.println("lua chon khong hop le!!!");
		}
		
		}while(true);		
		
	}
	private static void tkTheoMaHang() {
		System.out.println("\n=========TIM KIEM THEO MA HANG=======");
		System.out.print("\tNhap ma hang (id): ");
		int id = Integer.parseInt(sc.nextLine());
		int index = QuanLyHangHoa.indexOf(id);
		if(index == -1) {
			System.out.println("\tKhong tim thay ket qua nao");
			return;
		}
		System.out.println("\tThong tin hang hoa can tim: ");
		QuanLyHangHoa.list.get(index).display();
	}
	private static void tkTheoTenHang() {
		System.out.println("\n=========TIM KIEM THEO TEN HANG=======");
		System.out.print("\tNhap ten hang hoa can tim: ");
		String name = sc.nextLine();
		int dem = 0;
		for(HangHoa hh: QuanLyHangHoa.list) {
			if(hh.getName().trim().indexOf(name.trim()) != -1) {
				dem++;
				System.out.printf("%3d", dem);
				hh.display();
			}
		}
		if(dem == 0) {
			System.out.println("\tKhong tim thay ket qua nao");
		}
		else {
			System.out.println("\tTim thay " + dem + "ket qua");
		}
		
	}
	private static void tkTheoTenLoaiHang() {
		ArrayList<Integer> listidlh = new ArrayList<>();
		System.out.println("\n=======TIM KIEM THEO TEN LOAI HANG======");
		System.out.println("\tNhap ten loai hang can tim kiem: ");
		String name = sc.nextLine();
		//duyet ds loai hang
		for(LoaiHang lh: QuanLyLoaiHang.list) 
		{
			if(lh.getName().trim().indexOf(name.trim()) != -1) 
			{
				listidlh.add(lh.getId());
			}
		}
		if(listidlh.size() == 0)
		{
			System.out.println("\tKhong tim thay ket qua nao.");
			return;
		}
		//duyet ds hh
		System.out.println("\tTim thay "+ listidlh.size() + "ket qua.");
		for(HangHoa hh: QuanLyHangHoa.list)
		{
			//kiem  tra id loai hang cua hh co trong listidlh ko?
			if(listidlh.indexOf(hh.getId()) != -1)
			{
				hh.display();
			}
		}
	}
	private static void tkTheoKhungGioHang() {
		System.out.println("\n======TIM KIEM THEO KHUNG GIA=======");
		System.out.println("\tNhap khung gia dau");
		double firstPrice = Double.parseDouble(sc.nextLine());
		System.out.println("\tNhap khung gia cuoi: ");
		double lastPrice = Double.parseDouble(sc.nextLine());
		
		int dem = 0;
		for(HangHoa hh: QuanLyHangHoa.list)
		{
			if(hh.getPrice() >= firstPrice && hh.getPrice() <= lastPrice)
			{
				dem++;
				System.out.printf("%3d", dem);
				hh.display();
			}
		}
		if(dem == 0)
		{
			System.out.println("\tKhong tim thay ket qua nao");
		}
		else
		{
			System.out.println("\tTim thay " + dem + "ket qua");
		}
		
	}
	private static void timKiemKhachHang() {
		// TODO Auto-generated method stub
		
	}
	private static void timKiemGioHang() {
		// TODO Auto-generated method stub
		
	}
}
