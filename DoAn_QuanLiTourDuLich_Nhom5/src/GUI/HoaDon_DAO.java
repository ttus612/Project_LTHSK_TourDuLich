package GUI;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhuongTien;
import entity.Tour;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;


public class HoaDon_DAO {
		public ArrayList<HoaDon> getAllHoaDon() {
			ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
			try {
				ConnectDB.getInstance().connect();
				Connection con = ConnectDB.getConnection();
				
				String sql = "SELECT * FROM HoaDon";
		
				Statement statement = con.createStatement();
				
				ResultSet rs = statement.executeQuery(sql);
				
				while (rs.next()) {
					String maHoaDon = rs.getString("maHoaDon");
					Tour tour = new Tour(rs.getString("maTour"));
					KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
					NhanVien nhanVien = new NhanVien( rs.getString("maNhanVien"));
					Date  ngayDat = rs.getDate("ngayDat");
					Integer soLuongNguoiLon = rs.getInt("soLuongNguoiLon");
					Integer soLuongTreEm = rs.getInt("soLuongTreEm");
					String phuongThucThanhToan = rs.getString("phuongThucThanhToan");
					Boolean trangThai = rs.getBoolean("trangThai");
					Double tongTien = rs.getDouble("tongTien");
					HoaDon hd = new HoaDon(maHoaDon, tour, khachHang, nhanVien, ngayDat, soLuongNguoiLon, soLuongTreEm, phuongThucThanhToan, trangThai, tongTien);	
					dsHoaDon.add(hd);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			return dsHoaDon;

 	}
		public int getSoLuongDKy(String matour) {
			int count = 0;
			PreparedStatement ps = null;
			try {
				ConnectDB.getInstance().connect();
				Connection con = ConnectDB.getConnection();
				
				String sql = "Select soLuongNguoiLon, soLuongTreEm from HoaDon where maTour = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, matour);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					int nglon = rs.getInt("soLuongNguoiLon");
					int treEm = rs.getInt("soLuongTreEm");
					count = count + nglon + treEm;
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			return count;
		}
		public boolean addHoaDon(HoaDon hd) {
			PreparedStatement ps = null;
			int n = 0;
			try {
				ConnectDB.getInstance().connect();
				Connection con = ConnectDB.getConnection();
				
				String sql = "insert into HoaDon values(?,?,?,?,?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				
				ps.setString(1, hd.getMaHoaDon());
				ps.setString(2, hd.getTour().getMaTour());
				ps.setString(3, hd.getKhachHang().getMaKhachHang());
				ps.setString(4, hd.getNhanVien().getMaNhanvien());
				ps.setDate(5, hd.getNgayDat());
				ps.setInt(6, hd.getSoLuongNguoiLon());
				ps.setInt(7, hd.getSoLuongTreEm());
				ps.setString(8, hd.getPhuongThucThanhToan());
				ps.setBoolean(9, hd.isTrangThai());
				ps.setDouble(10, hd.getTongTien());
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			finally {
				try {
					ps.close();
				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}
			}
			return n > 0;
		}
		public boolean deleteHoaDonTheoTour(String maTour) {
			PreparedStatement ps = null;
			int n =0;
			try {
				ConnectDB.getInstance().connect();
				Connection con = ConnectDB.getConnection();
				
				String sql = "Delete from HoaDon where maTour = ? ";
				ps = con.prepareStatement(sql);
				ps.setString(1, maTour);
				n = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return n > 0;
		}
		public HoaDon searchHoaDonTheoMa(String maDon) {
			PreparedStatement preparedStatement = null;
			ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
			try {
				ConnectDB.getInstance().connect();
				Connection con = ConnectDB.getConnection();

				String sql = "Select " + " maHoaDon, maTour, HD.maKhachHang, ngayDat, soLuongNguoiLon, soLuongTreCon, phuongThucThanhToan, trangThai, tongTien\r\n"
						+ "from HoaDon HD JOIN KhachHang KH ON HD.maKhachHang = KH.maKhachHang\r\n"
						+ "Where HD.maKhachHang = ?";
				preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, maDon);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					String maHoaDon = rs.getString("maHoaDon");
					Tour tour = new Tour(rs.getString("maTour"));
					KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
					NhanVien nhanVien = new NhanVien( rs.getString("maNhanVien"));
					Date  ngayDat = rs.getDate("ngayDat");
					Integer soLuongNguoiLon = rs.getInt("soLuongNguoiLon");
					Integer soLuongTreEm = rs.getInt("soLuongTreEm");
					String phuongThucThanhToan = rs.getString("phuongThucThanhToan");
					Boolean trangThai = rs.getBoolean("trangThai");
					Double tongTien = rs.getDouble("tongTien");
					HoaDon hd = new HoaDon(maHoaDon, tour, khachHang, nhanVien, ngayDat, soLuongNguoiLon, soLuongTreEm, phuongThucThanhToan, trangThai, tongTien);	
					return hd;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
			return null;
		}

		public void updateNhanVien(HoaDon hoaDonNew) {
			PreparedStatement ps = null;
			try {
				ConnectDB.getInstance().connect();
				Connection con = ConnectDB.getConnection();
				String sql = "update HoaDon set MaHoaDon = ?, MaTour = ?, MaKhachHang = ?, MaNhanVien = ? NgayDat = ? SoLuongNguoiLon = ? SoLuongTreCon = ? PhuongThucThanhToan = ? TrangThai = ? TongTien = ? where maHoaDon = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, hoaDonNew.getMaHoaDon());
				ps.setString(2, hoaDonNew.getTour().getMaTour());
				ps.setString(3, hoaDonNew.getKhachHang().getMaKhachHang());
				ps.setString(5, hoaDonNew.getNhanVien().getMaNhanvien());
				ps.setDate(6, hoaDonNew.getNgayDat());
				ps.setInt(7, hoaDonNew.getSoLuongNguoiLon());
				ps.setInt(8, hoaDonNew.getSoLuongTreEm());
				ps.setString(9, hoaDonNew.getPhuongThucThanhToan());
				ps.setBoolean(10, hoaDonNew.isTrangThai());
				ps.setDouble(11, hoaDonNew.getTongTien());
				ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
}
