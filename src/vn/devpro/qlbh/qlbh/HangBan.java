package vn.devpro.qlbh.qlbh;

import vn.devpro.qlbh.qlhh.QuanLyHangHoa;

public class HangBan {
	private int idhh;
	private double amount;
	
	public void display() {
		int index = QuanLyHangHoa.indexOf(idhh);
		if(index == -1) {
			return;
		}
		String name = QuanLyHangHoa.list.get(index).getName();
		double price = QuanLyHangHoa.list.get(index).getPrice();
		double total = amount * price;
		System.out.printf("%-30s %8.2f %13.2f %14.2f %n",
				name, amount, price, total);
	}
	
	public double total() {
		int index = QuanLyHangHoa.indexOf(idhh);
		if(index == -1) {
			return 0;
		}
		return amount * QuanLyHangHoa.list.get(index).getPrice();
	}
	public HangBan() {
		super();
	}
	public HangBan(int idhh, double amount) {
		super();
		this.idhh = idhh;
		this.amount = amount;
	}
	public int getIdhh() {
		return idhh;
	}
	public void setIdhh(int idhh) {
		this.idhh = idhh;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}
