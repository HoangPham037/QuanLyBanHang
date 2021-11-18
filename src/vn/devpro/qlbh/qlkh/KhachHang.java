package vn.devpro.qlbh.qlkh;

public class KhachHang {
	private int id;
	private String name;
	
	public void display() {
		System.out.printf("%-10d %-25s %n", id, name);
	}
	public KhachHang() {
		super();
	}
	public KhachHang(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
