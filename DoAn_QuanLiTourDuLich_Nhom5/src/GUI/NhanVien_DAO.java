package GUI;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.NhanVien;

public class NhanVien_DAO {
	public ArrayList<NhanVien> getAllNhanVien() {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			String sql = "Select maNhanVien, hoTenNhanVien, gioiTinh, ngaySinh, soDienThoai from NhanVien";
			Statement statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maNhanVien = rs.getString("maNhanVien");
				String hoTenNhanVien = rs.getString("hoTenNhanVien");
				Boolean gioiTinh = rs.getBoolean("gioiTinh");
				Date ngaySinh = rs.getDate("ngaySinh");
				String soDienThoai = rs.getString("soDienThoai");
				NhanVien nv = new NhanVien(maNhanVien, hoTenNhanVien, gioiTinh, ngaySinh, soDienThoai, null);
				dsNhanVien.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsNhanVien;

	}

	public NhanVien searchNhanVienTheoMa(String maNhanVien) {
		PreparedStatement preparedStatement = null;
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			String sql = "Select " + " NV.maNhanVien, tenNhanVien, gioiTinh, ngaySinh, soDienThoai\r\n"
					+ "from NhanVien NV JOIN HoaDon HD ON NV.maNhanVien = HD.maNhanVien\r\n"
					+ "Where NV.maNhanVien = ?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maNhanVien);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				NhanVien nv = new NhanVien();
				nv.setMaNhanvien(rs.getString("maNhanVien"));
				nv.setTenNhanVien(rs.getString("tenNhanVien"));
				nv.setGioiTinh(rs.getBoolean("gioiTinh"));
				nv.setSoDienThoai(rs.getString("soDienThoai"));
				return nv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateNhanVien(NhanVien nhanVienNew) {
		PreparedStatement ps = null;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "update KhachHang set tenKhachHang = ?, email = ?, soDienThoai = ?, diaChi = ?  where maKhachHang = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, nhanVienNew.getTenNhanVien());
			ps.setString(2, nhanVienNew.getSoDienThoai());
			ps.setDate(3, nhanVienNew.getNgaySinh());
			ps.setBoolean(4, nhanVienNew.isGioiTinh());
			ps.setString(5, nhanVienNew.getMaNhanvien());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
