package entity;

import java.sql.Clob;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Tour {
	private String maTour;
	private String tenTour;
	private String diemXuatPhat;
	private String diemDen;
	private Date ngayKhoiHanh;
	private String thoiGian;
	private int soLuongKhachHangQuyDinh;
	private double gia;
	private boolean trangThai;
	private String moTa;
	private PhuongTien phuongTien;
	public String getMaTour() {
		return maTour;
	}
	public void setMaTour(String maTour) {
		this.maTour = maTour;
	}
	public String getTenTour() {
		return tenTour;
	}
	public void setTenTour(String tenTour) {
		this.tenTour = tenTour;
	}
	public String getDiemXuatPhat() {
		return diemXuatPhat;
	}
	public void setDiemXuatPhat(String diemXuatPhat) {
		this.diemXuatPhat = diemXuatPhat;
	}
	public String getDiemDen() {
		return diemDen;
	}
	public void setDiemDen(String diemDen) {
		this.diemDen = diemDen;
	}
	public Date getNgayKhoiHanh() {
		return ngayKhoiHanh;
	}
	public void setNgayKhoiHanh(Date ngayKhoiHanh) {
		this.ngayKhoiHanh = ngayKhoiHanh;
	}
	public String getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}
	public int getSoLuongKhachHangQuyDinh() {
		return soLuongKhachHangQuyDinh;
	}
	public void setSoLuongKhachHangQuyDinh(int soLuongKhachHangQuyDinh) {
		this.soLuongKhachHangQuyDinh = soLuongKhachHangQuyDinh;
	}
	
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	
	//True: Hết chỗ
	//False: Còn chỗ
	public String getTrangThai() {
		if(isTrangThai() == true)
			return "Hết chỗ";
		return "Còn chỗ";
	}
	public void setTrangThai(String trangThai) {
		if(trangThai.equals("Còn chỗ"))
			this.trangThai = false;
		else if(trangThai.equals("Hết chỗ"))
			this.trangThai = true;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public PhuongTien getPhuongTien() {
		return phuongTien;
	}
	public void setPhuongTien(PhuongTien phuongTien) {
		this.phuongTien = phuongTien;
	}
	public Tour(String maTour, String tenTour, String diemXuatPhat, String diemDen, Date ngayKhoiHanh, String thoiGian,
			int soLuongKhachHangQuyDinh, double gia, boolean trangThai, String moTa,
			PhuongTien phuongTien) {
		super();
		this.maTour = maTour;
		this.tenTour = tenTour;
		this.diemXuatPhat = diemXuatPhat;
		this.diemDen = diemDen;
		this.ngayKhoiHanh = ngayKhoiHanh;
		this.thoiGian = thoiGian;
		this.soLuongKhachHangQuyDinh = soLuongKhachHangQuyDinh;
		this.gia = gia;
		this.trangThai = trangThai;
		this.moTa = moTa;
		this.phuongTien = phuongTien;
	}
	public Tour(String maTour) {
		super();
		this.maTour = maTour;
	}
	public Tour() {
		super();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maTour);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tour other = (Tour) obj;
		return Objects.equals(maTour, other.maTour);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Tour [maTour = "+maTour+", tenTour = "+tenTour+", diemXuatPhat = "+diemXuatPhat+", diemDen ="+diemDen+","
				+ "ngayKhoiHang = "+ngayKhoiHanh+", thoiGian = "+thoiGian+", soLuongQuyDinh = "+soLuongKhachHangQuyDinh+","
				+ "gia = "+gia+", trangThai = "+trangThai+", moTa = "+moTa+", phuongTien = "+phuongTien+"]";
		
	}
}
