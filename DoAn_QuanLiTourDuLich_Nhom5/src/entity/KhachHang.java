package entity;

import java.util.Objects;

public class KhachHang {
	private String maKhachHang;
	private String tenKhachHang;
	private String email;
	private String soDienThoai;
	private String diaChi;
	private HoaDon hoaDon;
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public KhachHang() {
		super();
	}
	public KhachHang(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}
	public KhachHang(String maKhachHang, String tenKhachHang, String email, String soDienThoai, String diaChi,
			HoaDon hoaDon) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.hoaDon = hoaDon;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKhachHang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKhachHang, other.maKhachHang);
	}
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", email=" + email
				+ ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + ", hoaDon=" + hoaDon + "]";
	}
	
}
