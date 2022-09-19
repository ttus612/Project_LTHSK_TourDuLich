package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import GUI.Frm_DangNhap;
import GUI.Frm_GiaoDienChinh;
import connectDB.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.TaiKhoan;

public class TaiKhoan_DAO {
	public ResultSet dangNhap(String userName, String passWord) {
		PreparedStatement preparedStatement = null;
	
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
	
			String sql = "SELECT * FROM TaiKhoan\r\n"
					+ "WHERE userName = ? AND passWord = ?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, passWord);
			ResultSet rs = preparedStatement.executeQuery();   
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void xoaTaiKhoan(String user) {
		PreparedStatement preparedStatement = null;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
				
			String sql = "delete from KhachHang where userName = ?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, user);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
