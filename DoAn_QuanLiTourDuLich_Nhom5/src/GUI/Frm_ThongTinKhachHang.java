package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import entity.KhachHang;

public class Frm_ThongTinKhachHang extends JFrame implements ActionListener {
	private JLabel lblTitle;
	private JLabel lblMaKH;
	private JLabel lblTenKH;
	private JLabel lblEmail;
	private JLabel lblDiaChi;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lblSDT;
	private JButton btnDong;
	public Frm_ThongTinKhachHang() {
		setTitle("Thông tin khách hàng");
		setSize(600, 300);
		setLocationRelativeTo(null);
		
		add(lblTitle = new JLabel("Thông tin khách hàng", SwingConstants.CENTER),BorderLayout.NORTH);
		lblTitle.setFont(new Font("Time New Roman", Font.BOLD, 35));
		lblTitle.setForeground(Color.RED);
		
		JPanel pThongTin = new JPanel();
		pThongTin.setBorder(BorderFactory.createTitledBorder("Thông tin"));
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(5, 2));

		p.add(lbl1 = new JLabel("Mã khách hàng: "));
		p.add(lblMaKH = new JLabel("..."));
		
		p.add(lbl2 = new JLabel("Họ tên: "));
		p.add(lblTenKH = new JLabel("..."));
		
		p.add(lbl3 = new JLabel("Email:"));
		p.add(lblEmail = new JLabel("..."));
		
		p.add(lbl4 = new JLabel("Số điện thoại:"));
		p.add(lblSDT = new JLabel("..."));
		
		p.add(lbl5 = new JLabel("Địa Chỉ:"));
		p.add(lblDiaChi = new JLabel("..."));
		pThongTin.add(p);
		setLable();
		
		add(pThongTin, BorderLayout.CENTER);
		
		JPanel pBtn = new JPanel();
		pBtn.add(btnDong = new JButton("Đóng", new ImageIcon("img\\close.png")), BorderLayout.CENTER);
		btnDong.setFont(new Font("Time New Roman", Font.BOLD, 20));
		btnDong.setBackground(Color.red);
		btnDong.setForeground(Color.WHITE);
		btnDong.setToolTipText("Đóng");
		add(pBtn, BorderLayout.SOUTH);
		
		btnDong.addActionListener(this);
	}
	private void setLable() {
		lbl1.setFont(new Font("Time New Roman", Font.BOLD, 18));
		lbl2.setFont(new Font("Time New Roman", Font.BOLD, 18));
		lbl3.setFont(new Font("Time New Roman", Font.BOLD, 18));
		lbl4.setFont(new Font("Time New Roman", Font.BOLD, 18));
		lbl5.setFont(new Font("Time New Roman", Font.BOLD, 18));
		
		
		lblMaKH.setFont(new Font("Time New Roman", Font.PLAIN, 18));
		lblTenKH.setFont(new Font("Time New Roman", Font.PLAIN, 18));
		lblEmail.setFont(new Font("Time New Roman", Font.PLAIN, 18));
		lblSDT.setFont(new Font("Time New Roman", Font.PLAIN, 18));
		lblDiaChi.setFont(new Font("Time New Roman", Font.PLAIN, 18));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnDong)) {
			this.dispose();
		}
		
	}
	public void setEditData(KhachHang khachHang) {
		// TODO Auto-generated method stub
		lblMaKH.setText(khachHang.getMaKhachHang());
		lblTenKH.setText(khachHang.getTenKhachHang());
		lblEmail.setText(khachHang.getEmail());
		lblSDT.setText(khachHang.getSoDienThoai());
		lblDiaChi.setText(khachHang.getDiaChi());
	}
	
}
