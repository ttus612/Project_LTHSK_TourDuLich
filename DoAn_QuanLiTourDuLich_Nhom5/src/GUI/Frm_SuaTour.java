package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.sun.jdi.Value;

import dao.PhuongTien_DAO;
import dao.Tour_DAO;
import entity.PhuongTien;
import entity.Tour;

public class Frm_SuaTour extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtMaTour;
	private JTextField txtTenTour;
	private JTextField txtDiaChiDen;
	private JTextField txtThoiGianXuatPhat;
	private JTextField txtThoiGian;
	private JTextField txtSoLuongKhach;
	private JComboBox<String> cbxPhuongTienDiChuyen;
	private JTextField txtGiaTour;
	private JTextArea txtChiTietTour;
	private DefaultComboBoxModel<String> cbxMode;

	private JLabel lblMaTour;
	private JLabel lblTenTour;
	private JLabel lblDiaChiDen;
	private JLabel lblThoiGianXuatPhat;
	private JLabel lblPhuongTienDiChuyen;
	private JLabel lblThoiGian;
	private JLabel lblSoLuongKhach;
	private JLabel lblGiaTour;
	private JLabel lblChiTietTour;

	private JButton btnLuu;
	private JButton btnDong;
	private JLabel lblTitle;
	private Frm_Tour frm_Tour;
	private JLabel lblDiemXuatPhat;
	private JTextField txtDiemXuatPhat;
	private Component lblTrangThai;
	private DefaultComboBoxModel cbxTTModel;
	private PhuongTien_DAO phuongTien_DAO;
	private ArrayList<PhuongTien> listPhuongTien;
	private ArrayList<Tour> listTour;
	private Tour_DAO tour_DAO;
	private JTextField txtTrangThai;
	private String vl;

	public Frm_SuaTour(JPanel panel, boolean modal) {
		frm_Tour = new Frm_Tour();
		frm_Tour = (Frm_Tour) panel;
		phuongTien_DAO = new PhuongTien_DAO();
		tour_DAO = new Tour_DAO();
		
		listPhuongTien = new ArrayList<PhuongTien>();
		listPhuongTien = phuongTien_DAO.getAllPhuongTien();
		
		listTour = new ArrayList<Tour>();
		
		setTitle("Sửa Tour");
		setSize(950, 850);
		setLocationRelativeTo(null);
		setResizable(false);
		
		add(lblTitle = new JLabel("Sửa thông tin Tour", SwingConstants.CENTER), BorderLayout.NORTH);
		lblTitle.setFont(new Font("Time New Roman", Font.BOLD, 35));
		lblTitle.setForeground(Color.red);

		lblMaTour = new JLabel("Mã Tour: ");
		lblMaTour.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		lblTenTour = new JLabel("Tên tour: ");
		lblTenTour.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		lblDiaChiDen = new JLabel("Địa chỉ đến: ");
		lblDiaChiDen.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		lblThoiGianXuatPhat = new JLabel("Thời gian xuất phát: ");
		lblThoiGianXuatPhat.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		lblPhuongTienDiChuyen = new JLabel("Phương tiện di chuyển: ");
		lblPhuongTienDiChuyen.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		lblThoiGian = new JLabel("Thời gian: ");
		lblThoiGian.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		lblSoLuongKhach = new JLabel("Số lượng khách: ");
		lblSoLuongKhach.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		lblGiaTour = new JLabel("Giá tour: ");
		lblGiaTour.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		lblChiTietTour = new JLabel("Chi tiết tour: ");
		lblChiTietTour.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		lblDiemXuatPhat = new JLabel("Điểm xuất phát: ");
		lblDiemXuatPhat.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		lblTrangThai = new JLabel("Trạng thái: ");
		lblTrangThai.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		

		txtMaTour = new JTextField(5);
		txtMaTour.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		txtMaTour.setEditable(false);
		
		txtTenTour = new JTextField(5);
		txtTenTour.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		txtDiaChiDen = new JTextField(5);
		txtDiaChiDen.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		txtThoiGianXuatPhat = new JTextField(5);
		txtThoiGianXuatPhat.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		txtThoiGian = new JTextField(5);
		txtThoiGian.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		txtSoLuongKhach = new JTextField(5);
		txtSoLuongKhach.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		txtGiaTour = new JTextField(5);
		txtGiaTour.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		txtDiemXuatPhat = new JTextField(5);
		txtDiemXuatPhat.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		txtTrangThai = new JTextField(5);
		txtTrangThai.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		txtTrangThai.setEditable(false);
		
		txtChiTietTour = new JTextArea();
		txtChiTietTour.setLineWrap(true);
		//txtChiTietTour.setFont(new Font("Time New Roman", Font.PLAIN, 20));

		cbxPhuongTienDiChuyen = new JComboBox<String>();
		cbxMode = new DefaultComboBoxModel<String>();
		cbxPhuongTienDiChuyen = new JComboBox<String>(cbxMode);
		for (PhuongTien pt : listPhuongTien) {
			cbxMode.addElement(pt.getMaPhuongTien());
		}
		cbxPhuongTienDiChuyen.setPreferredSize(new Dimension(200, 5));
		

		btnLuu = new JButton("Lưu", new ImageIcon("img\\save.png"));
		btnLuu.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		//btnLuu.setPreferredSize(new Dimension(100, 30));
		btnLuu.setToolTipText("Lưu thông tin tour");
		
		btnDong = new JButton("Đóng" , new ImageIcon("img\\close.png"));
		btnDong.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		//btnDong.setPreferredSize(new Dimension(100, 30));
		btnDong.setToolTipText("Đóng");
		btnLuu.setPreferredSize(btnDong.getPreferredSize());

//		JPanel p = new JPanel();
//		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		Box p = Box.createVerticalBox();

		Box b1 = Box.createHorizontalBox();
		b1.add(lblMaTour);
		b1.add(Box.createRigidArea(new Dimension(35, 5)));
		b1.add(txtMaTour);
		b1.add(Box.createRigidArea(new Dimension(35, 5)));
		b1.add(lblDiaChiDen);
		b1.add(Box.createRigidArea(new Dimension(35, 5)));
		b1.add(txtDiaChiDen);

		p.add(Box.createRigidArea(new Dimension(20, 20)));
		p.add(b1);
		p.add(Box.createRigidArea(new Dimension(10, 10)));

		Box b2 = Box.createHorizontalBox();
		b2.add(lblTenTour);
		b2.add(Box.createRigidArea(new Dimension(35, 5)));
		b2.add(txtTenTour);
		b2.add(Box.createRigidArea(new Dimension(35, 5)));
		b2.add(lblDiemXuatPhat);
		b2.add(Box.createRigidArea(new Dimension(35, 5)));
		b2.add(txtDiemXuatPhat);

		p.add(b2);
		p.add(Box.createRigidArea(new Dimension(10, 10)));

		Box b3 = Box.createHorizontalBox();
		b3.add(lblThoiGianXuatPhat);
		b3.add(Box.createRigidArea(new Dimension(35, 5)));
		b3.add(txtThoiGianXuatPhat);
		b3.add(Box.createRigidArea(new Dimension(35, 5)));
		b3.add(lblSoLuongKhach);
		b3.add(Box.createRigidArea(new Dimension(35, 5)));
		b3.add(txtSoLuongKhach);

		p.add(b3);
		p.add(Box.createRigidArea(new Dimension(10, 10)));

		Box b4 = Box.createHorizontalBox();
		b4.add(lblThoiGian);
		b4.add(Box.createRigidArea(new Dimension(35, 5)));
		b4.add(txtThoiGian);
		b4.add(Box.createRigidArea(new Dimension(35, 5)));
		b4.add(lblPhuongTienDiChuyen);
		b4.add(Box.createRigidArea(new Dimension(35, 5)));
		b4.add(cbxPhuongTienDiChuyen);
		
		p.add(b4);
		p.add(Box.createRigidArea(new Dimension(10, 10)));
		
		Box b7 = Box.createHorizontalBox();
		b7.add(lblGiaTour);
		b7.add(Box.createRigidArea(new Dimension(35, 5)));
		b7.add(txtGiaTour);
		b7.add(Box.createRigidArea(new Dimension(35, 5)));
		b7.add(lblTrangThai);
		b7.add(Box.createRigidArea(new Dimension(35, 5)));
		b7.add(txtTrangThai);
		
		p.add(b7);
		p.add(Box.createRigidArea(new Dimension(10, 10)));

		Box b5 = Box.createHorizontalBox();
		b5.add(lblChiTietTour);
		b5.add(Box.createRigidArea(new Dimension(750, 0)));
		Box b6 = Box.createHorizontalBox();
		b6.add(new JScrollPane(txtChiTietTour));
		b6.add(Box.createRigidArea(new Dimension(0, 150)));

		//p.add(Box.createRigidArea(new Dimension(40, 40)));
		p.add(b5);
		p.add(Box.createRigidArea(new Dimension(10, 10)));
		p.add(b6);
		p.add(Box.createRigidArea(new Dimension(20, 20)));

		lblMaTour.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		lblTenTour.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		lblThoiGianXuatPhat.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		lblThoiGian.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		lblDiaChiDen.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		lblSoLuongKhach.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		//lblPhuongTienDiChuyen.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		lblGiaTour.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		lblChiTietTour.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		lblDiemXuatPhat.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		lblTrangThai.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		
		
		JPanel pBottom = new JPanel();
		pBottom.add(btnLuu);
		pBottom.add(btnDong);
		btnLuu.setBackground(new Color(42, 175, 45));
		btnLuu.setForeground(Color.WHITE);
		btnDong.setBackground(new Color(224, 37, 37));
		btnDong.setForeground(Color.WHITE);

		Box bTop = Box.createVerticalBox();
		bTop.setBorder(BorderFactory.createTitledBorder("Thông tin tour"));
		bTop.add(p);

		Box bN = Box.createVerticalBox();
		bN.add(bTop);
		bN.add(pBottom);

		add(bN, BorderLayout.CENTER);
		bN.setPreferredSize(new Dimension(0, 500));

		btnLuu.addActionListener(this);
		btnDong.addActionListener(this);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnDong)) {
			this.dispose();
		}
		else if(obj.equals(btnLuu)) {
			Tour t = gianGiaTri();
			frm_Tour.suaThongTinTour(t);
			this.dispose();
		}
	}

	
	private Tour gianGiaTri() {
		String ma = txtMaTour.getText();
		String ten = txtTenTour.getText();
		String diemDi = txtDiemXuatPhat.getText();
		String diemDen = txtDiaChiDen.getText();
		Date ngayDi = Date.valueOf(txtThoiGianXuatPhat.getText());
		String thoiGian = txtThoiGian.getText();
		int sl = Integer.parseInt(txtSoLuongKhach.getText());
		Double gia = Double.parseDouble(txtGiaTour.getText());
		String moTa = txtChiTietTour.getText();
		String trangThai = txtTrangThai.getText();
		boolean bl;
		if(trangThai.equals("Còn chỗ")) {
			bl = false;
		}
		else bl = true;
		PhuongTien maPt = new PhuongTien((String)cbxMode.getSelectedItem());
		//PhuongTien pt = new PhuongTien(vl);
		return new Tour(ma, ten, diemDi, diemDen, ngayDi, thoiGian, sl, gia, bl, moTa, maPt);
	}
	public void setData(Tour t) {
		txtChiTietTour.setText(t.getMoTa());
		txtDiaChiDen.setText(t.getDiemDen());
		txtGiaTour.setText(String.valueOf(t.getGia()));
		txtMaTour.setText(t.getMaTour());
		txtSoLuongKhach.setText(String.valueOf(t.getSoLuongKhachHangQuyDinh()));
		txtTenTour.setText(t.getTenTour());
		txtThoiGian.setText(t.getThoiGian());
		txtThoiGianXuatPhat.setText(String.valueOf(t.getNgayKhoiHanh()));
		txtDiemXuatPhat.setText(t.getDiemXuatPhat());
		//PhuongTien pt = phuongTien_DAO.getPhuongTienTheoMa(t.getPhuongTien().getMaPhuongTien());
		cbxMode.setSelectedItem(t.getPhuongTien().getMaPhuongTien());
		txtTrangThai.setText(t.getTrangThai());
		txtTrangThai.setText(t.getTrangThai());
		
		
//		
	}
	

}
