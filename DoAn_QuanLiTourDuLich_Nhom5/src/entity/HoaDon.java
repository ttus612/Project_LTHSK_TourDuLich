package entity;

import java.sql.Date;
import java.util.Objects;

public class HoaDon {
	private String maHoaDon;
	private Tour tour;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	private Date ngayDat;
	private int soLuongNguoiLon;
	private int soLuongTreEm;
	private String phuongThucThanhToan;
	private boolean trangThai;
	private double tongTien;
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public Tour getTour() {
		return tour;
	}
	public void setTour(Tour tour) {
		this.tour = tour;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public Date getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}
	public int getSoLuongNguoiLon() {
		return soLuongNguoiLon;
	}
	public void setSoLuongNguoiLon(int soLuongNguoiLon) {
		this.soLuongNguoiLon = soLuongNguoiLon;
	}
	public int getSoLuongTreEm() {
		return soLuongTreEm;
	}
	public void setSoLuongTreEm(int soLuongTreEm) {
		this.soLuongTreEm = soLuongTreEm;
	}
	public String getPhuongThucThanhToan() {
		return phuongThucThanhToan;
	}
	public void setPhuongThucThanhToan(String phuongThucThanhToan) {
		this.phuongThucThanhToan = phuongThucThanhToan;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public String getTrangThai() {
		if(isTrangThai() == true)
			return "Đã thanh toán";
		return "Chưa thanh toán";
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public HoaDon(String maHoaDon, Tour tour, KhachHang khachHang, NhanVien nhanVien, Date ngayDat, int soLuongNguoiLon,
			int soLuongTreEm, String phuongThucThanhToan, boolean trangThai, double tongTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.tour = tour;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.ngayDat = ngayDat;
		this.soLuongNguoiLon = soLuongNguoiLon;
		this.soLuongTreEm = soLuongTreEm;
		this.phuongThucThanhToan = phuongThucThanhToan;
		this.trangThai = trangThai;
		this.tongTien = tongTien;
	}
	public HoaDon(boolean trangThai) {
		super();
		this.trangThai = trangThai;
	}
	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}
	public HoaDon() {
		super();
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "HoaDon [maHoaDon = "+maHoaDon+", tour = "+tour+", khachHang = "+khachHang+", nhanvien = "+nhanVien+","
				+ "ngayDat = "+ngayDat+", soNguoiLon = "+soLuongNguoiLon+", soTreEm = "+soLuongTreEm+","
						+ "phuongThucThanhToan = "+phuongThucThanhToan+", trangThai = "+trangThai+", tongTien = "+tongTien+"]";
	}
}
