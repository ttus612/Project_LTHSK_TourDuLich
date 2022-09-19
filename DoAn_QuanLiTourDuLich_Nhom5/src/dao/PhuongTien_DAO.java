package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.PhuongTien;


public class PhuongTien_DAO {
		public ArrayList<PhuongTien> getAllPhuongTien() {
			ArrayList<PhuongTien> dsPhuongTien = new ArrayList<PhuongTien>();
			try {
				ConnectDB.getInstance().connect();
				Connection con = ConnectDB.getConnection();
				
				String sql = "Select * from PhuongTien";
				Statement statement = con.createStatement();
				
				ResultSet rs = statement.executeQuery(sql);
				
				while (rs.next()) {
					String maPhuongTien = rs.getString("maPhuongTien");
					String loaiPhuongTien = rs.getString("loaiPhuongTien");
					String bienSoXe = rs.getString("bienSoXe");
					String ghiChu = rs.getString("ghiChu");
					PhuongTien pt = new PhuongTien(maPhuongTien, loaiPhuongTien, bienSoXe, ghiChu);	
					dsPhuongTien.add(pt);

				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			return dsPhuongTien;

 	}
		public PhuongTien getPhuongTienTheoMa(String maPT) {
			PhuongTien pt = null;
			try {
				ConnectDB.getInstance().connect();
				Connection con = ConnectDB.getConnection();
				
				String sql = "SELECT * from PhuongTien where maPhuongTien = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, maPT);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String ma = rs.getString("maPhuongTien");
					String loaiPT = rs.getString("loaiPhuongTien");
					String bienSo = rs.getString("bienSoXe");
					String ghiChu = rs.getString("ghiChu");
					pt = new PhuongTien(maPT, loaiPT, bienSo, ghiChu);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			return pt;
		}
		public boolean create(PhuongTien p) throws SQLException {
			Connection con = ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("insert into PhuongTien values(?, ?, ?, ?)");
				stmt.setString(1,p.getMaPhuongTien());
				stmt.setString(2,p.getLoaiPhuongTien());
				stmt.setString(3,p.getBienSoXe());
				stmt.setString(4,p.getGhiChu());
				n = stmt.executeUpdate();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n > 0; 
		}
		
		
		//------------------------------SỬA----------------------------------------
		public void updatePhuongTien(PhuongTien p ) {
				PreparedStatement stmt = null;
				try {
					ConnectDB.getInstance().connect();
					Connection con = ConnectDB.getConnection();	 
					String sql = "update PhuongTien set loaiPhuongTien = ?, bienSoXe = ?, ghiChu = ? where maPhuongTien = ?";
					stmt = con.prepareStatement(sql);
					stmt.setString(1, p.getLoaiPhuongTien()  );
					stmt.setString(2, p.getBienSoXe());
					stmt.setString(3, p.getGhiChu());
					stmt.setString(4, p.getMaPhuongTien());
					stmt.executeUpdate();	
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		
		public void xoaPhuongTien(String maPhuongTien) {
			PreparedStatement preparedStatement = null;
			try {
				ConnectDB.getInstance().connect();
				Connection con = ConnectDB.getConnection();
					
				String sql = "DELETE FROM PhuongTien WHERE maPhuongTien = ?";
				preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, maPhuongTien);
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		
}
