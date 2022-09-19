package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.System.Logger;
import java.util.logging.Level;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entity.NhanVien;

public class Frm_ThongTinNhanVien extends JFrame implements ActionListener, MouseListener {
	private JLabel lblThongTinNhanVien;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl5;
	private JLabel lbl4;

	private JPanel pN;
	private JButton btnDong;
	private JLabel LblMaNhanVien;
	private JLabel lblHoTen;
	private JLabel lblGioiTinh;
	private JLabel lblNgaySinh;
	private JLabel lblSoDienThoai;

	public Frm_ThongTinNhanVien() throws IOException {
		setTitle("Thông tin nhân viên");
		setBounds(150, 150, 700, 400);
		pN = new JPanel();
		pN.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pN);
		pN.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);

		lblThongTinNhanVien = new JLabel("Thông tin nhân viên");
		lblThongTinNhanVien.setForeground(Color.RED);
		lblThongTinNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblThongTinNhanVien.setBounds(10, 10, 420, 45);
		pN.add(lblThongTinNhanVien);

		lbl1 = new JLabel("Mã nhân viên:");
		lbl1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl1.setBounds(220, 85, 125, 20);
		pN.add(lbl1);
		
		LblMaNhanVien = new JLabel("NV_01");
		LblMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		LblMaNhanVien.setBounds(370, 85, 125, 20);
		pN.add(LblMaNhanVien);

		lbl2 = new JLabel("Họ tên:");
		lbl2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl2.setBounds(220, 120, 85, 20);
		pN.add(lbl2);
		
		lblHoTen = new JLabel("Trâm");
		lblHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHoTen.setBounds(370, 120, 125, 20);
		pN.add(lblHoTen);

		lbl3 = new JLabel("Giới tính:");
		lbl3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl3.setBounds(220, 155, 86, 20);
		pN.add(lbl3);
		
		lblGioiTinh = new JLabel("Nữ");
		lblGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGioiTinh.setBounds(370, 155, 125, 20);
		pN.add(lblGioiTinh);

		lbl4 = new JLabel("Ngày sinh:");
		lbl4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl4.setBounds(220, 190, 95, 20);
		pN.add(lbl4);
		
		lblNgaySinh = new JLabel("19/09/2001");
		lblNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNgaySinh.setBounds(370, 190, 125, 20);
		pN.add(lblNgaySinh);

		lbl5 = new JLabel("Số điện thoại:");
		lbl5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl5.setBounds(220, 225, 120, 20);
		pN.add(lbl5);
		
		lblSoDienThoai = new JLabel("03231232131");
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSoDienThoai.setBounds(370, 225, 125, 20);
		pN.add(lblSoDienThoai);

		btnDong = new JButton("Đóng", new ImageIcon("img\\close.png"));
		btnDong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDong.setBackground(Color.RED);
		btnDong.setForeground(Color.WHITE);
		btnDong.setBounds(220, 300, 150, 26);
		btnDong.setToolTipText("Đóng");
		pN.add(btnDong);

		btnDong.addActionListener(this);

		JLabel lblImg = new JLabel();
		lblImg.setBounds(10, 70, 200, 200);
		setPicture(lblImg, "img\\pic_ThongTinNhanVien.jpg");
		pN.add(lblImg);

	}

	public void setPicture(JLabel label, String filename) throws IOException {
		BufferedImage image = ImageIO.read(new File(filename));
		ImageIcon icon = new ImageIcon(
				image.getScaledInstance(label.getWidth(), label.getHeight(), BufferedImage.SCALE_SMOOTH));
		label.setIcon(icon);
	}

	public static void main(String[] args) throws IOException {
		new Frm_ThongTinNhanVien().setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnDong)) {
			this.dispose();
		}
	}

	public void setEditData(NhanVien nhanVien) {
		// TODO Auto-generated method stub
		LblMaNhanVien.setText(nhanVien.getMaNhanvien());
		lblHoTen.setText(nhanVien.getTenNhanVien());
		boolean gt = nhanVien.isGioiTinh();
		if (gt = true) {
			lblGioiTinh.setText("Nam");
		} else
			lblGioiTinh.setText("Nữ");
		lblNgaySinh.setText(String.valueOf(nhanVien.getNgaySinh()));
		lblSoDienThoai.setText(nhanVien.getSoDienThoai());
	}

}
