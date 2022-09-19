package dao;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhuongTien;
import entity.Tour;

public class Tour_DAO {
	public ArrayList<Tour> getAllTour() {
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT * from Tour";
			Statement statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String matour = rs.getString("maTour");
				String tenTour = rs.getString("tenTour");
				String diemXP = rs.getString("diemXuatPhat");
				String diemDen = rs.getString("diemDen");
				Date ngayKH = rs.getDate("ngayKhoiHanh");
				String tg = rs.getString("thoiGian");
				int SLK = rs.getInt("soLuongKhachHangQuyDinh");
				Double gia = rs.getDouble("gia");
				Boolean tt = rs.getBoolean("trangThai");
				String moTa = rs.getString("moTa");
				PhuongTien pt = new PhuongTien(rs.getString("maPhuongtien"));
				Tour tour = new Tour(matour, tenTour, diemXP, diemDen, ngayKH, tg, SLK, gia, tt, moTa, pt);
				dsTour.add(tour);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsTour;
	}

	public Tour getTourTheoMa(String maTour) {
		Tour tour = null;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT * FROM Tour " + "WHERE maTour = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, maTour);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String matour = rs.getString("maTour");
				String tenTour = rs.getString("tenTour");
				String diemXP = rs.getString("diemXuatPhat");
				String diemDen = rs.getString("diemDen");
				Date ngayKH = rs.getDate("ngayKhoiHanh");
				String tg = rs.getString("thoiGian");
				int SLK = rs.getInt("soLuongKhachHangQuyDinh");
				Double gia = rs.getDouble("gia");
				Boolean tt = rs.getBoolean("trangThai");
				String moTa = rs.getString("moTa");
				PhuongTien pt = new PhuongTien(rs.getString("maPhuongtien"));
				tour = new Tour(matour, tenTour, diemXP, diemDen, ngayKH, tg, SLK, gia, tt, moTa, pt);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return tour;
	}

	public boolean deleteTour(String maTour) {
		PreparedStatement ps = null;
		int n = 0;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			String sql = "delete from Tour where maTour = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, maTour);
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			try {
				ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
		return n > 0;
	}

	public ArrayList<Tour> getTourTheoDiemDen(String diemDen) {
		ArrayList<Tour> lst = new ArrayList<Tour>();
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT * FROM Tour " + "WHERE diemDen = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, diemDen);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String matour = rs.getString("maTour");
				String tenTour = rs.getString("tenTour");
				String diemXP = rs.getString("diemXuatPhat");
				String den = rs.getString("diemDen");
				Date ngayKH = rs.getDate("ngayKhoiHanh");
				String tg = rs.getString("thoiGian");
				int SLK = rs.getInt("soLuongKhachHangQuyDinh");
				Double gia = rs.getDouble("gia");
				Boolean trangThai = rs.getBoolean("trangThai");
				String moTa = rs.getString("moTa");
				PhuongTien pt = new PhuongTien(rs.getString("maPhuongtien"));
				Tour tour = new Tour(matour, tenTour, diemXP, den, ngayKH, tg, SLK, gia, trangThai, moTa, pt);
				lst.add(tour);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return lst;
	}

	public ArrayList<Tour> getTourTheoNgayDi(Date ngayDi) {
		ArrayList<Tour> lst = new ArrayList<Tour>();
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT * FROM Tour " + "WHERE ngayKhoiHanh = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDate(1, ngayDi);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String matour = rs.getString("maTour");
				String tenTour = rs.getString("tenTour");
				String diemXP = rs.getString("diemXuatPhat");
				String den = rs.getString("diemDen");
				Date ngayKH = rs.getDate("ngayKhoiHanh");
				String tg = rs.getString("thoiGian");
				int SLK = rs.getInt("soLuongKhachHangQuyDinh");
				Double gia = rs.getDouble("gia");
				Boolean trangThai = rs.getBoolean("trangThai");
				String moTa = rs.getString("moTa");
				PhuongTien pt = new PhuongTien(rs.getString("maPhuongtien"));
				Tour tour = new Tour(matour, tenTour, diemXP, den, ngayKH, tg, SLK, gia, trangThai, moTa, pt);
				lst.add(tour);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return lst;
	}

	public ArrayList<Tour> getTourTheoDiemDenVaNgayDi(String diemDen, Date ngayDi) {
		ArrayList<Tour> lst = new ArrayList<Tour>();
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT * FROM Tour " + "WHERE diemDen = ? and ngayKhoiHanh = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, diemDen);
			ps.setDate(2, ngayDi);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String matour = rs.getString("maTour");
				String tenTour = rs.getString("tenTour");
				String diemXP = rs.getString("diemXuatPhat");
				String den = rs.getString("diemDen");
				Date ngayKH = rs.getDate("ngayKhoiHanh");
				String tg = rs.getString("thoiGian");
				int SLK = rs.getInt("soLuongKhachHangQuyDinh");
				Double gia = rs.getDouble("gia");
				Boolean trangThai = rs.getBoolean("trangThai");
				String moTa = rs.getString("moTa");
				PhuongTien pt = new PhuongTien(rs.getString("maPhuongtien"));
				Tour tour = new Tour(matour, tenTour, diemXP, den, ngayKH, tg, SLK, gia, trangThai, moTa, pt);
				lst.add(tour);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return lst;
	}

	public ArrayList<Tour> getTourTheoTrangThai(boolean trangThai) {
		ArrayList<Tour> lst = new ArrayList<Tour>();
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT * FROM Tour " + "WHERE trangThai = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setBoolean(1, trangThai);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String matour = rs.getString("maTour");
				String tenTour = rs.getString("tenTour");
				String diemXP = rs.getString("diemXuatPhat");
				String den = rs.getString("diemDen");
				Date ngayKH = rs.getDate("ngayKhoiHanh");
				String tg = rs.getString("thoiGian");
				int SLK = rs.getInt("soLuongKhachHangQuyDinh");
				Double gia = rs.getDouble("gia");
				Boolean tt = rs.getBoolean("trangThai");
				String moTa = rs.getString("moTa");
				PhuongTien pt = new PhuongTien(rs.getString("maPhuongtien"));
				Tour tour = new Tour(matour, tenTour, diemXP, den, ngayKH, tg, SLK, gia, tt, moTa, pt);
				lst.add(tour);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return lst;
	}

	public ArrayList<Tour> getTourTheoDiemDenVaTrangThai(String diemDen, boolean trangThai) {
		ArrayList<Tour> lst = new ArrayList<Tour>();
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT * FROM Tour " + "WHERE diemDen = ? AND trangThai = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, diemDen);
			ps.setBoolean(2, trangThai);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String matour = rs.getString("maTour");
				String tenTour = rs.getString("tenTour");
				String diemXP = rs.getString("diemXuatPhat");
				String den = rs.getString("diemDen");
				Date ngayKH = rs.getDate("ngayKhoiHanh");
				String tg = rs.getString("thoiGian");
				int SLK = rs.getInt("soLuongKhachHangQuyDinh");
				Double gia = rs.getDouble("gia");
				Boolean tt = rs.getBoolean("trangThai");
				String moTa = rs.getString("moTa");
				PhuongTien pt = new PhuongTien(rs.getString("maPhuongtien"));
				Tour tour = new Tour(matour, tenTour, diemXP, den, ngayKH, tg, SLK, gia, tt, moTa, pt);
				lst.add(tour);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return lst;
	}

	public ArrayList<Tour> getTourTheoNgayDiVaTrangThai(Date ngayDi, boolean trangThai) {
		ArrayList<Tour> lst = new ArrayList<Tour>();
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT * FROM Tour " + "WHERE ngayKhoiHanh = ? AND trangThai = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDate(1, ngayDi);
			ps.setBoolean(2, trangThai);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String matour = rs.getString("maTour");
				String tenTour = rs.getString("tenTour");
				String diemXP = rs.getString("diemXuatPhat");
				String den = rs.getString("diemDen");
				Date ngayKH = rs.getDate("ngayKhoiHanh");
				String tg = rs.getString("thoiGian");
				int SLK = rs.getInt("soLuongKhachHangQuyDinh");
				Double gia = rs.getDouble("gia");
				Boolean tt = rs.getBoolean("trangThai");
				String moTa = rs.getString("moTa");
				PhuongTien pt = new PhuongTien(rs.getString("maPhuongtien"));
				Tour tour = new Tour(matour, tenTour, diemXP, den, ngayKH, tg, SLK, gia, tt, moTa, pt);
				lst.add(tour);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return lst;
	}

	public ArrayList<Tour> getTourTheoDiemDenVaNgayDiVaTrangThai(String diemDen, Date ngayDi, boolean trangThai) {
		ArrayList<Tour> lst = new ArrayList<Tour>();
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT * FROM Tour " + "WHERE diemDen = ? AND ngayKhoiHanh = ? AND trangThai = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, diemDen);
			ps.setDate(2, ngayDi);
			ps.setBoolean(3, trangThai);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String matour = rs.getString("maTour");
				String tenTour = rs.getString("tenTour");
				String diemXP = rs.getString("diemXuatPhat");
				String den = rs.getString("diemDen");
				Date ngayKH = rs.getDate("ngayKhoiHanh");
				String tg = rs.getString("thoiGian");
				int SLK = rs.getInt("soLuongKhachHangQuyDinh");
				Double gia = rs.getDouble("gia");
				Boolean tt = rs.getBoolean("trangThai");
				String moTa = rs.getString("moTa");
				PhuongTien pt = new PhuongTien(rs.getString("maPhuongtien"));
				Tour tour = new Tour(matour, tenTour, diemXP, den, ngayKH, tg, SLK, gia, tt, moTa, pt);
				lst.add(tour);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return lst;
	}

	public boolean updateTour(Tour t) {
		PreparedStatement ps = null;
		int n = 0;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			String sql = "update Tour " 
						+ "set tenTour = ?, " 
						+ "diemXuatPhat = ?, " 
						+ "diemDen = ?, "
						+ "ngayKhoiHanh = ?, " 
						+ "thoiGian = ?, " 
						+ "soLuongKhachHangQuyDinh = ?, " 
						+ "gia = ?, "
						+ "trangThai = ?, " 
						+ "moTa = ?, " 
						+ "maPhuongTien = ? " 
						+ "where maTour = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, t.getTenTour());
			ps.setString(2, t.getDiemXuatPhat());
			ps.setString(3, t.getDiemDen());
			ps.setDate(4, t.getNgayKhoiHanh());
			ps.setString(5, t.getThoiGian());
			ps.setInt(6, t.getSoLuongKhachHangQuyDinh());
			ps.setDouble(7, t.getGia());
			ps.setBoolean(8, t.isTrangThai());
			ps.setString(9, t.getMoTa());
			ps.setObject(10, t.getPhuongTien().getMaPhuongTien());
			ps.setString(11, t.getMaTour());

			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			try {
				ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
		return n > 0;
	}

	public boolean updateTrangThaiTour(String maTour, boolean tt) {
		PreparedStatement ps = null;
		int n = 0;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			String sql = "update Tour " 
						+ "set trangThai = ? " 
						+  "where maTour = ?";
			ps = con.prepareStatement(sql);
			
			ps.setBoolean(1, tt);
			ps.setString(2, maTour);

			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			try {
				ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
		return n > 0;
	}

	
	public boolean addTour(Tour t) {
		PreparedStatement ps = null;
		int n = 0;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into Tour values(?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);

			ps.setString(1, t.getMaTour());
			ps.setString(2, t.getTenTour());
			ps.setString(3, t.getDiemXuatPhat());
			ps.setString(4, t.getDiemDen());
			ps.setDate(5, t.getNgayKhoiHanh());
			ps.setString(6, t.getThoiGian());
			ps.setInt(7, t.getSoLuongKhachHangQuyDinh());
			ps.setDouble(8, t.getGia());
			ps.setBoolean(9, t.isTrangThai());
			ps.setString(10, t.getMoTa());
			ps.setObject(11, t.getPhuongTien().getMaPhuongTien());
			n = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			try {
				ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
		return n > 0;
	}
	
}
