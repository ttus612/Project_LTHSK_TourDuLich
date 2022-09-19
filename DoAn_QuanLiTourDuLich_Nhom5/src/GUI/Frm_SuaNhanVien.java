package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.NhanVien_DAO;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhuongTien;
import entity.TaiKhoan;

public class Frm_SuaNhanVien extends JDialog implements ActionListener {
	private JLabel lblMaNhanVien;
	private JLabel lblHoTen;
	private JLabel lblGioiTinh;
	private JLabel lblNgaySinh;
	private JLabel lblSoDienThoai;
	private JButton btnDong, btnLuu;
	private JTextField txFieldMa;
	private JTextField txFieldTen;
	private JTextField textFieldNgaySinh;
	private JTextField textFieldSDT;
	private JTextField textFieldGioiTinh;
	private Frm_NhanVien home_NV;
	private NhanVien_DAO dsNhanVien;
	private Frm_NhanVien frmNhanVien;

	public Frm_SuaNhanVien(JPanel panel, boolean modal) {
		frmNhanVien = new Frm_NhanVien();
		frmNhanVien = (Frm_NhanVien) panel;
		
		this.setTitle("Sửa thông tin nhân viên");
		this.setSize(650, 470);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		buildGUI();
	}

	private void buildGUI() {
		JPanel pnlNorth = new JPanel();
		// add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		JLabel lblTieuDe = new JLabel("Sửa Thông Tin Nhân Viên");
		lblTieuDe.setForeground(new Color(224, 37, 37));
		lblTieuDe.setFont(new Font("Time New Roman", Font.BOLD, 25));
		pnlNorth.add(lblTieuDe);

		JPanel jPanelCenter = new JPanel();
		jPanelCenter.setLayout(new BoxLayout(jPanelCenter, BoxLayout.Y_AXIS));
		Box box = Box.createVerticalBox();
		box.add(pnlNorth);
		box.add(jPanelCenter);
		add(box, BorderLayout.NORTH);
		// add(jPanelCenter,BorderLayout.CENTER);

		Box boxMa = Box.createHorizontalBox();
		boxMa.add(Box.createRigidArea(new Dimension(50, 50)));
		boxMa.add(lblMaNhanVien = new JLabel("Mã nhân viên: "));
		lblMaNhanVien.setFont(new Font("time new roman", Font.PLAIN, 20));
		boxMa.add(txFieldMa = new JTextField(10));
		txFieldMa.setEditable(false);
		txFieldMa.setFont(new Font("Time new roman", Font.PLAIN, 20));
		boxMa.add(Box.createRigidArea(new Dimension(50, 50)));
		jPanelCenter.add(boxMa);
		jPanelCenter.add(Box.createRigidArea(new Dimension(20, 20)));

		Box boxTen = Box.createHorizontalBox();
		boxTen.add(Box.createRigidArea(new Dimension(50, 50)));
		boxTen.add(lblHoTen = new JLabel("Họ tên: "));
		lblHoTen.setFont(new Font("time new roman", Font.PLAIN, 20));
		boxTen.add(txFieldTen = new JTextField());
		txFieldTen.setFont(new Font("Time new roman", Font.PLAIN, 20));
		boxTen.add(Box.createRigidArea(new Dimension(50, 50)));
		jPanelCenter.add(boxTen);
		jPanelCenter.add(Box.createRigidArea(new Dimension(20, 20)));

		Box boxGioiTinh = Box.createHorizontalBox();
		boxGioiTinh.add(Box.createRigidArea(new Dimension(50, 50)));
		boxGioiTinh.add(lblGioiTinh = new JLabel("Giới tính: "));
		lblGioiTinh.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		boxGioiTinh.add(textFieldGioiTinh = new JTextField(10));
		textFieldGioiTinh.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		boxGioiTinh.add(Box.createRigidArea(new Dimension(50, 50)));
		jPanelCenter.add(boxGioiTinh);
		jPanelCenter.add(Box.createRigidArea(new Dimension(20, 20)));

		Box boxNgaySinh = Box.createHorizontalBox();
		boxNgaySinh.add(Box.createRigidArea(new Dimension(50, 50)));
		boxNgaySinh.add(lblNgaySinh = new JLabel("Ngày sinh: "));
		lblNgaySinh.setFont(new Font("Time New Roamn", Font.PLAIN, 20));
		boxNgaySinh.add(textFieldNgaySinh = new JTextField());
		textFieldNgaySinh.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		boxNgaySinh.add(Box.createRigidArea(new Dimension(50, 50)));
		jPanelCenter.add(boxNgaySinh);
		jPanelCenter.add(Box.createRigidArea(new Dimension(20, 20)));

		Box boxSDT = Box.createHorizontalBox();
		boxSDT.add(Box.createRigidArea(new Dimension(50, 50)));
		boxSDT.add(lblSoDienThoai = new JLabel("Số điện thoại: "));
		lblSoDienThoai.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		boxSDT.add(textFieldSDT = new JTextField(20));
		textFieldSDT.setFont(new Font("time new roman", Font.PLAIN, 20));
		boxSDT.add(Box.createRigidArea(new Dimension(50, 50)));
		jPanelCenter.add(boxSDT);
		jPanelCenter.add(Box.createRigidArea(new Dimension(20, 20)));

		lblHoTen.setPreferredSize(lblMaNhanVien.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblMaNhanVien.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblMaNhanVien.getPreferredSize());
		lblSoDienThoai.setPreferredSize(lblMaNhanVien.getPreferredSize());

//		jPanelCenter.add(boxMa);
//		jPanelCenter.add(boxTen);
//		jPanelCenter.add(boxNgaySinh);
//		jPanelCenter.add(boxGioiTinh);
//		jPanelCenter.add(boxSDT);

		JPanel jPanelSouth = new JPanel();
		add(jPanelSouth, BorderLayout.SOUTH);
		jPanelSouth.add(btnLuu = new JButton("Lưu", new ImageIcon("img\\save.png")));
		btnLuu.setForeground(Color.WHITE);
		btnLuu.setBackground(new Color(42, 175, 45));
		btnLuu.setFont(new Font("Time new roman", Font.BOLD, 20));
		btnLuu.setToolTipText("Lưu thông tin nhân viên");

		jPanelSouth.add(btnDong = new JButton("Đóng", new ImageIcon("img\\close.png")));
		btnDong.setForeground(Color.WHITE);
		btnDong.setBackground(new Color(224, 37, 37));
		btnDong.setFont(new Font("time new roman", Font.BOLD, 20));
		btnDong.setToolTipText("Đóng");

		btnDong.addActionListener(this);
		btnLuu.addActionListener(this);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnLuu)) {
			String maNV = txFieldMa.getText();
			String hoTen = txFieldTen.getText();
			Date ngayDi = Date.valueOf(textFieldNgaySinh.getText());
			String sdt = textFieldSDT.getText();
			String gioiTinh = textFieldGioiTinh.getText();
			TaiKhoan tk = new TaiKhoan(txFieldMa.getText());
			boolean gt;
			if (gioiTinh.equals("Nam")) {
				gt = true;
			} else
				gt = false;
			NhanVien nhanVienNew = new NhanVien(maNV, hoTen, gt, ngayDi, sdt, tk);
			frmNhanVien.suaThongTinNhanVien(nhanVienNew);
			JOptionPane.showMessageDialog(this, "Lưu thành công !");
			this.dispose();

		}
		if (e.getSource().equals(btnDong)) {
			this.dispose();
		}
	}

	public void setEditData(NhanVien nhanVien) {
		// TODO Auto-generated method stub
		txFieldMa.setText(nhanVien.getMaNhanvien());
		txFieldTen.setText(nhanVien.getTenNhanVien());
		boolean gt = nhanVien.isGioiTinh();
		if (gt == true) {
			textFieldGioiTinh.setText("Nam");
		} else if(gt == false)
			textFieldGioiTinh.setText("Nữ");
		textFieldNgaySinh.setText(String.valueOf(nhanVien.getNgaySinh()));
		textFieldSDT.setText(nhanVien.getSoDienThoai());
	}
}
