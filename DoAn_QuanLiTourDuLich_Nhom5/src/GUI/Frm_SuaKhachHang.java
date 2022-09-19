package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.KhachHang_DAO;
import entity.KhachHang;

public class Frm_SuaKhachHang extends JDialog implements ActionListener {
	private JLabel lblTitle;
	private JLabel lbl1;
	private JTextField txtMaKH;
	private JLabel lbl2;
	private JTextField txtHoTen;
	private JTextField txtEmail;
	private JLabel lbl4;
	private JLabel lbl3;
	private JTextField txtSDT;
	private JLabel lbl5;
	private JTextField txtDiaChi;
	private JButton btnLuu;
	private JButton btnDong;
	private Frm_KhachHang home_KH;
	private KhachHang_DAO dsKhachHang;
	private Frm_KhachHang frm_KH;
	public Frm_SuaKhachHang(JPanel panel, boolean modal) {
		setTitle("Sửa thông tin khách hàng");
		setSize(700, 500);
		setLocationRelativeTo(null);
		
		frm_KH = new Frm_KhachHang();
		frm_KH =(Frm_KhachHang) panel;
		add(lblTitle = new JLabel("Sửa thông tin khách hàng", SwingConstants.CENTER), BorderLayout.NORTH);
		lblTitle.setFont(new Font("Time New Roman", Font.BOLD, 40));
		lblTitle.setForeground(Color.RED);
		
		JPanel pThongTin = new JPanel();
		pThongTin.setLayout(new BoxLayout(pThongTin, BoxLayout.Y_AXIS));
		
		pThongTin.add(Box.createRigidArea(new Dimension(20, 20)));
		Box b1 = Box.createHorizontalBox();
		b1.add(Box.createRigidArea(new Dimension(50, 50)));
		b1.add(lbl1 = new JLabel("Mã khách hàng: "));
		lbl1.setFont(new Font("Time New Roman", Font.BOLD, 20));
		b1.add(txtMaKH = new JTextField());
		txtMaKH.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		txtMaKH.setEditable(false);
		b1.add(Box.createRigidArea(new Dimension(50, 50)));
		pThongTin.add(b1);
		pThongTin.add(Box.createRigidArea(new Dimension(20, 20)));
		
		Box b2 = Box.createHorizontalBox();
		b2.add(Box.createRigidArea(new Dimension(50, 50)));
		b2.add(lbl2 = new JLabel("Họ tên: "));
		lbl2.setFont(new Font("Time New Roman", Font.BOLD, 20));
		b2.add(txtHoTen = new JTextField());
		txtHoTen.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		b2.add(Box.createRigidArea(new Dimension(50, 50)));
		pThongTin.add(b2);
		pThongTin.add(Box.createRigidArea(new Dimension(20, 20)));
		
		Box b3 = Box.createHorizontalBox();
		b3.add(Box.createRigidArea(new Dimension(50, 50)));
		b3.add(lbl3 = new JLabel("Email: "));
		lbl3.setFont(new Font("Time New Roman", Font.BOLD, 20));
		b3.add(txtEmail = new JTextField());
		txtEmail.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		b3.add(Box.createRigidArea(new Dimension(50, 50)));
		pThongTin.add(b3);
		pThongTin.add(Box.createRigidArea(new Dimension(20, 20)));
		
		Box b4 = Box.createHorizontalBox();
		b4.add(Box.createRigidArea(new Dimension(50, 50)));
		b4.add(lbl4 = new JLabel("Số điện thoại: "));
		lbl4.setFont(new Font("Time New Roman", Font.BOLD, 20));
		b4.add(txtSDT = new JTextField());
		txtSDT.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		b4.add(Box.createRigidArea(new Dimension(50, 50)));
		pThongTin.add(b4);
		pThongTin.add(Box.createRigidArea(new Dimension(20, 20)));
		
		Box b5 = Box.createHorizontalBox();
		b5.add(Box.createRigidArea(new Dimension(50, 50)));
		b5.add(lbl5 = new JLabel("Địa chỉ: "));
		lbl5.setFont(new Font("Time New Roman", Font.BOLD, 20));
		b5.add(txtDiaChi = new JTextField());
		txtDiaChi.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		b5.add(Box.createRigidArea(new Dimension(50, 50)));
		pThongTin.add(b5);
		pThongTin.add(Box.createRigidArea(new Dimension(20, 20)));
		
		lbl2.setPreferredSize(lbl1.getPreferredSize());
		lbl3.setPreferredSize(lbl1.getPreferredSize());
		lbl4.setPreferredSize(lbl1.getPreferredSize());
		lbl5.setPreferredSize(lbl1.getPreferredSize());
		
		add(pThongTin, BorderLayout.CENTER);
		
		JPanel pBtn = new JPanel();
		pBtn.add(btnLuu = new JButton("Lưu", new ImageIcon("img\\save.png")));
		btnLuu.setToolTipText("Lưu thông tin khách hàng");
		btnLuu.setFont(new Font("Time New Roamn", Font.BOLD, 20));
		btnLuu.setBackground(new Color(42, 175, 45));
		btnLuu.setForeground(Color.WHITE);
		
		pBtn.add(btnDong = new JButton("Đóng", new ImageIcon("img\\close.png")));
		btnDong.setToolTipText("Đóng");
		btnDong.setBackground(Color.RED);
		btnDong.setFont(new Font("Time New Roman", Font.BOLD, 20));
		btnDong.setForeground(Color.WHITE);
		btnLuu.setPreferredSize(btnDong.getPreferredSize());
		add(pBtn, BorderLayout.SOUTH);
		
		btnDong.addActionListener(this);
		btnLuu.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		if(obj.equals(btnDong)) {
			this.dispose();
		}else if (obj.equals(btnLuu)) {
			String maKhachHang = txtMaKH.getText().trim();
			String hoTen = txtHoTen.getText().trim();
			String email = txtEmail.getText().trim();
			String sdt = txtSDT.getText().trim();
			String diaChi = txtDiaChi.getText().trim();
			KhachHang khachHangNew = new KhachHang(maKhachHang, hoTen, email, sdt, diaChi,null);
			home_KH  = new Frm_KhachHang();
			home_KH.suaThongTinKhachHang(khachHangNew);
//			JOptionPane.showMessageDialog(this, "Lưu thành công !");
			this.dispose();
		}
		
	}
	public void setEditData(KhachHang khachHang) {
		// TODO Auto-generated method stub
		txtMaKH.setText(khachHang.getMaKhachHang());
		txtHoTen.setText(khachHang.getTenKhachHang());
		txtEmail.setText(khachHang.getEmail());
		txtSDT.setText(khachHang.getSoDienThoai());
		txtDiaChi.setText(khachHang.getDiaChi());
	}

}
