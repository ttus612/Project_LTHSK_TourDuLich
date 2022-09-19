package entity;

import java.util.Objects;

public class TaiKhoan {
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public TaiKhoan(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public TaiKhoan(String userName) {
		super();
		this.userName = userName;
	}
	public TaiKhoan() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(userName, other.userName);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "TaiKhoan [userName = "+ userName+", password = "+password+"]";
	}
}	
