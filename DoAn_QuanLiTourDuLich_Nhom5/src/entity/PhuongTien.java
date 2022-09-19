package entity;

import java.util.Objects;

public class PhuongTien {
	private String maPhuongTien;
	private String loaiPhuongTien;
	private String bienSoXe;
	private String ghiChu;
	
	public String getMaPhuongTien() {
		return maPhuongTien;
	}
	public void setMaPhuongTien(String maPhuongTien) {
		this.maPhuongTien = maPhuongTien;
	}
	public String getLoaiPhuongTien() {
		return loaiPhuongTien;
	}
	public void setLoaiPhuongTien(String loaiPhuongTien) {
		this.loaiPhuongTien = loaiPhuongTien;
	}
	public String getBienSoXe() {
		return bienSoXe;
	}
	public void setBienSoXe(String bienSoXe) {
		this.bienSoXe = bienSoXe;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public PhuongTien(String maPhuongTien, String loaiPhuongTien, String bienSoXe, String ghiChu) {
		super();
		this.maPhuongTien = maPhuongTien;
		this.loaiPhuongTien = loaiPhuongTien;
		this.bienSoXe = bienSoXe;
		this.ghiChu = ghiChu;
	}
	public PhuongTien(String maPhuongTien) {
		super();
		this.maPhuongTien = maPhuongTien;
	}
	public PhuongTien() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhuongTien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhuongTien other = (PhuongTien) obj;
		return Objects.equals(maPhuongTien, other.maPhuongTien);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "PhuongTien [maPhuongTien=" + maPhuongTien + ", loaiPhuongTien=" + loaiPhuongTien + ", bienSoXe=" + bienSoXe
				+ ", ghiChu=" + ghiChu + "]";
	}
}
