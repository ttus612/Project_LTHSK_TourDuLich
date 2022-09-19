package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;


public class KhachHang_DAO {
	public ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			
			String sql = "Select  KH.maKhachHang, tenKhachHang, email, soDienThoai, diaChi, trangThai\r\n"
					+ "from KhachHang KH JOIN HoaDon HD ON KH.maKhachHang = HD.maKhachHang";
			Statement statement = con.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
	
			while (rs.next()) {
				String maKhachHang = rs.getString("maKhachHang");
				String tenKhachHang = rs.getString("tenKhachHang");
				String email = rs.getString("email");
				String soDienThoai = rs.getString("soDienThoai");
				String diaChi = rs.getString("diaChi");
				HoaDon hoaDon = new HoaDon(rs.getBoolean("trangThai"));
				KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, email, soDienThoai, diaChi,hoaDon);		
				dsKhachHang.add(kh);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsKhachHang;
	}
// -----------------------------TÌM----------------------------------------
public KhachHang searchKhachHangTheoMa(String maKhachHang) {
	 	PreparedStatement preparedStatement = null;
	 	ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
	 	try {
        ConnectDB.getInstance().connect();
		Connection con = ConnectDB.getConnection();
	
		String sql = "Select  KH.maKhachHang, tenKhachHang, email, soDienThoai, diaChi, trangThai\r\n"
				+ "from KhachHang KH JOIN HoaDon HD ON KH.maKhachHang = HD.maKhachHang\r\n"
				+ "Where KH.maKhachHang = ?";
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, maKhachHang);
		ResultSet rs = preparedStatement.executeQuery();          
        while(rs.next()) {
           	KhachHang kh = new KhachHang();
           	kh.setMaKhachHang(rs.getString("maKhachHang"));
           	kh.setTenKhachHang(rs.getString("tenKhachHang"));
           	kh.setEmail(rs.getString("email"));
			kh.setSoDienThoai(rs.getString("soDienThoai"));
			kh.setDiaChi(rs.getString("diaChi"));
			kh.setHoaDon(new HoaDon(rs.getBoolean("trangThai")));
			return kh;
           }
	} catch (Exception e) {
        e.printStackTrace();
    }
	return null;
}
		// -----------------------------TÌM----------------------------------------
		public KhachHang searchKhachHangTheoSDT(String soDienThoai) {
			PreparedStatement preparedStatement = null;
			ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
			try {
				ConnectDB.getInstance().connect();
				Connection con = ConnectDB.getConnection();
		
				String sql = "Select  KH.maKhachHang, tenKhachHang, email, soDienThoai, diaChi, trangThai\r\n"
						+ "from KhachHang KH JOIN HoaDon HD ON KH.maKhachHang = HD.maKhachHang\r\n"
						+ "Where soDienThoai = ?";
				preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, soDienThoai);
				ResultSet rs = preparedStatement.executeQuery();          
				while(rs.next()) {
					KhachHang kh = new KhachHang();
					kh.setMaKhachHang(rs.getString("maKhachHang"));
					kh.setTenKhachHang(rs.getString("tenKhachHang"));
					kh.setEmail(rs.getString("email"));
					kh.setSoDienThoai(rs.getString("soDienThoai"));
					kh.setDiaChi(rs.getString("diaChi"));
					kh.setHoaDon(new HoaDon(rs.getBoolean("trangThai")));
				return kh;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}	
		// -----------------------------TÌM----------------------------------------
			public KhachHang searchKhachHangTheoMaKhachHangVaSDT(String maKhachHang, String soDienThoai) {
				PreparedStatement preparedStatement = null;
				ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
				try {
					ConnectDB.getInstance().connect();
					Connection con = ConnectDB.getConnection();
			
					String sql = "Select  KH.maKhachHang, tenKhachHang, email, soDienThoai, diaChi, trangThai\r\n"
							+ "from KhachHang KH JOIN HoaDon HD ON KH.maKhachHang = HD.maKhachHang\r\n"
							+ "Where KH.maKhachHang= ? AND soDienThoai = ?";
					preparedStatement = con.prepareStatement(sql);
					preparedStatement.setString(1, maKhachHang);
					preparedStatement.setString(2, soDienThoai);
					ResultSet rs = preparedStatement.executeQuery();          
					while(rs.next()) {
						KhachHang kh = new KhachHang();
						kh.setMaKhachHang(rs.getString("maKhachHang"));
						kh.setTenKhachHang(rs.getString("tenKhachHang"));
						kh.setEmail(rs.getString("email"));
						kh.setSoDienThoai(rs.getString("soDienThoai"));
						kh.setDiaChi(rs.getString("diaChi"));
						kh.setHoaDon(new HoaDon(rs.getBoolean("trangThai")));
					return kh;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}	
		// -----------------------------TÌM----------------------------------------
			public ResultSet searchKhachHangTheoTrangThai(Boolean trangThai) {
				PreparedStatement preparedStatement = null;
				ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
				try {
					ConnectDB.getInstance().connect();
					Connection con = ConnectDB.getConnection();
			
					String sql = "Select  KH.maKhachHang, tenKhachHang, email, soDienThoai, diaChi, trangThai\r\n"
							+ "from KhachHang KH JOIN HoaDon HD ON KH.maKhachHang = HD.maKhachHang\r\n"
							+ "Where trangThai = ?";
					preparedStatement = con.prepareStatement(sql);
					preparedStatement.setBoolean(1, trangThai);
					ResultSet rs = preparedStatement.executeQuery();          
					return rs;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}	
		//----------------------XÓA-----------------------------------------------
		public void xoaKhachHang(String maKhachHang) {
			PreparedStatement preparedStatement = null;
			try {
				ConnectDB.getInstance().connect();
				Connection con = ConnectDB.getConnection();
					
				String sql = "delete from KhachHang where maKhachHang = ?";
				preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, maKhachHang);
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}

	//------------------------------SỬA----------------------------------------
	public void updateLopHoc(KhachHang khachHangNew ) {
			PreparedStatement ps= null;
			try {
				ConnectDB.getInstance().connect();
				Connection con = ConnectDB.getConnection();	 
				String sql = "update KhachHang set tenKhachHang = ?, email = ?, soDienThoai = ?, diaChi = ?  where maKhachHang = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, khachHangNew.getTenKhachHang());
				ps.setString(2, khachHangNew.getEmail());
				ps.setString(3, khachHangNew.getSoDienThoai());
				ps.setString(4, khachHangNew.getDiaChi());
				ps.setString(5, khachHangNew.getMaKhachHang());
				ps.executeUpdate();	
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}


		//---------------------------------------------
		public int getSoLuongDKyTour(String maTour) {
			int count = 0;
			try {
				ConnectDB.getInstance().connect();
				Connection con = ConnectDB.getConnection();
				
				String sql = "Select * from KhachHang";
				Statement statement = con.createStatement();
				
				ResultSet rs = statement.executeQuery(sql);
				
				while (rs.next()) {
					count +=1;
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			return count;
		}
		public boolean addKhachHang(KhachHang kh) {
			PreparedStatement ps = null;
			int n = 0;
			try {
				ConnectDB.getInstance().connect();
				Connection con = ConnectDB.getConnection();
				
				String sql = "insert into KhachHang values(?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				
				ps.setString(1, kh.getMaKhachHang());
				ps.setString(2, kh.getTenKhachHang());
				ps.setString(3, kh.getEmail());
				ps.setString(4, kh.getSoDienThoai());
				ps.setString(5, kh.getDiaChi());
				n = ps.executeUpdate();
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
		public boolean deleteKhachHangTheoHoaDon(String maHD) {
			PreparedStatement ps = null;
			int n =0;
			try {
				ConnectDB.getInstance().connect();
				Connection con = ConnectDB.getConnection();
				
				String sql = "Delete from KhachHang where maHD = ? ";
				ps = con.prepareStatement(sql);
				ps.setString(1, maHD);
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
		
		
}
