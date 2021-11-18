package vn.devpro.qlbh.qllh;

public class LoaiHang {
	private int id;
	private String name;
	
	public void display() {
		System.out.printf("%-10d %-25s %n", id, name);
	}
	public LoaiHang() {
		super();
	}
	public LoaiHang(int id, String name) {
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
