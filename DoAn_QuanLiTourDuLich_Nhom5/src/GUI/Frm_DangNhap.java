package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.TaiKhoan_DAO;


public class Frm_DangNhap extends JFrame implements ActionListener{
	private JLabel lblTieuDe;
	private JLabel lblTaiKhoan;
	private JTextField txtTaiKhoan;
	private JLabel lblMatKhau;
	private JTextField txtMatKhau;
	private JLabel lblImg;
	private JButton btnDangNhap;
	private JButton btnThoat;
	private TaiKhoan_DAO dstaikhoan;
	public Frm_DangNhap() {
		// TODO Auto-generated constructor stub
		this.setTitle("Đăng nhập");
		this.setSize(720,380);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		
		add(lblImg = new JLabel(new ImageIcon("img\\dangnhap.png"), SwingConstants.CENTER), BorderLayout.WEST);
		Box b = Box.createVerticalBox();
		Box b1, b2, b3, b4;		
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();
		b4 = Box.createHorizontalBox();
		
		b1.add(lblTieuDe = new JLabel("ĐĂNG NHẬP"), BorderLayout.NORTH);
		lblTieuDe.setForeground(Color.BLACK);
		Font f = new Font("Times New Roman ",Font.BOLD,63);
		lblTieuDe.setFont(f);
		b.add(Box.createRigidArea(new Dimension(50,50)));
		b.add(b1);

		b2.add(lblTaiKhoan = new JLabel( new ImageIcon("img\\icon_username.png"), SwingConstants.CENTER));
		
		b2.add(txtTaiKhoan = new JTextField("Tài khoản"));
		txtTaiKhoan.setFont(new Font("Time New Roman", Font.BOLD, 20));
		b.add(Box.createRigidArea(new Dimension(10,10)));
		b.add(b2);
		
		b3.add(lblMatKhau = new JLabel(new ImageIcon("img\\icon_password.png"), SwingConstants.CENTER));
		b3.add(txtMatKhau = new JPasswordField("Mật khẩu"));
		txtMatKhau.setFont(new Font("Time New Roman", Font.BOLD, 20));
		b.add(Box.createRigidArea(new Dimension(10,10)));
		b.add(b3);
		lblTaiKhoan.setPreferredSize(lblMatKhau.getPreferredSize());
		
		b.add(Box.createRigidArea(new Dimension(10,10)));
		b4.add(btnDangNhap = new JButton("Đăng nhập"));
		b4.add(Box.createRigidArea(new Dimension(10,0)));
		btnDangNhap.setMargin(new Insets(5, 5, 5, 5));
		btnDangNhap.setBackground(Color.DARK_GRAY);
		btnDangNhap.setForeground(Color.WHITE);
		b.add(Box.createRigidArea(new Dimension(10,10)));
		b4.add(btnThoat = new JButton("Thoát"));
		
		btnThoat.setMargin(new Insets(5, 5, 5, 5));
		btnThoat.setBackground(Color.DARK_GRAY);
		btnThoat.setForeground(Color.WHITE);
		b.add(b4);
		p.add(b, BorderLayout.EAST);
		add(p);
		
		btnDangNhap.addActionListener(this);
		btnThoat.addActionListener(this);
	}
	public static void main(String[] args) {
		new Frm_DangNhap().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnThoat)) {
			System.exit(0);
		}else if (obj.equals(btnDangNhap)) {
			try {
				String userName = txtTaiKhoan.getText();
				String passWord = txtMatKhau.getText();
				dstaikhoan = new TaiKhoan_DAO();
				ResultSet dn = dstaikhoan.dangNhap(userName, passWord);
				if(dn.next()) {
						Frm_GiaoDienChinh frm = new Frm_GiaoDienChinh();
						JOptionPane.showMessageDialog(this, "Đăng nhập thành công !");					
						setVisible(false);
						frm.setVisible(true);
						
				}else {
					JOptionPane.showMessageDialog(this, "Bạn nhập sai userName hoặc password .Vui lòng  kiểm tra lại!");
					xoaRong();
					txtMatKhau.requestFocus();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	
	}
	public void xoaRong() {
		txtMatKhau.setText("");
		txtTaiKhoan.setText("");
	}
}
