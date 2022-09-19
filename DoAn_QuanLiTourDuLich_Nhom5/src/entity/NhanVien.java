package entity;

import java.sql.Date;
import java.util.Objects;

public class NhanVien {
	private String maNhanvien;
	private String tenNhanVien;
	private boolean gioiTinh;
	private Date ngaySinh;
	private String soDienThoai;
	private TaiKhoan taiKhoan;
	public String getMaNhanvien() {
		return maNhanvien;
	}
	public void setMaNhanvien(String maNhanvien) {
		this.maNhanvien = maNhanvien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public NhanVien(String maNhanvien, String tenNhanVien, boolean gioiTinh, Date ngaySinh, String soDienThoai,
			TaiKhoan taiKhoan) {
		super();
		this.maNhanvien = maNhanvien;
		this.tenNhanVien = tenNhanVien;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.taiKhoan = taiKhoan;
	}
	public NhanVien(String maNhanvien) {
		super();
		this.maNhanvien = maNhanvien;
	}
	public NhanVien() {
		super();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maNhanvien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNhanvien, other.maNhanvien);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "NhanVien [maNhanVien = "+maNhanvien+", tenNhanVien = "+tenNhanVien+", gioiTinh = "+gioiTinh+","
				+ "ngaySinh = "+ngaySinh+", soDienThoai = "+soDienThoai+", taiKhoan = "+taiKhoan+"]";
	}
	
}
