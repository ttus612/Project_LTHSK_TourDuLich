package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.Tour_DAO;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Tour;

public class Frm_DatTour extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblDiemDen;
	private JLabel lblGiaTour;
	private JLabel lblPhuongTien;
	private JLabel lblThoiGian;
	private JLabel lblTenTour;
	private JLabel lblNgayKhoiHanh;
	private JLabel lblMaTour;
	private JLabel lblDiemXuatPhat;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtMail;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtVeLon;
	private JTextField txtVeNho;
	private JRadioButton radTienMat;
	private JRadioButton radChuyenKhoan;
	private JLabel lblTongTien;
	private JButton btnChapNhan;
	private JButton btnNhapLai;
	private JButton btnDong;
	private JLabel lblSoLuong;
	private JLabel lblMaNV;
	private JLabel lblKqMaHD;
	private Frm_Tour frm_Tour;
	private DecimalFormat df;
	private Tour_DAO tour_DAO;
	private JTextField txtMaHoaDon;
	private JTextField txtMaNhanVien;
	private JLabel lblMaHD;
	private String phuongThucTT;
	private KhachHang_DAO khachHang_DAO;
	private HoaDon_DAO hoaDon_DAO;
	private double tongTien;

	public Frm_DatTour() {
		frm_Tour = new Frm_Tour();

		df = new DecimalFormat("#,##0.00");
		tour_DAO = new Tour_DAO();
		khachHang_DAO = new KhachHang_DAO();
		hoaDon_DAO = new HoaDon_DAO();

		setSize(1000, 700);
		setTitle("?????t tour");
		JLabel lblTitle;
		setResizable(false);
		// setLocationRelativeTo(null);
		// this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel pTitle = new JPanel();
		pTitle.add(lblTitle = new JLabel("?????t tour"));
		lblTitle.setFont(new Font("Time new Roman", Font.BOLD, 35));
		lblTitle.setForeground(Color.RED);
		add(pTitle, BorderLayout.NORTH);

		JPanel pMain = new JPanel();
		pMain.setLayout(new BoxLayout(pMain, BoxLayout.Y_AXIS));

		// ----------Th??ng tin tour---------------//
		JPanel pThongTin = new JPanel();
		pThongTin.setLayout(new BoxLayout(pThongTin, BoxLayout.Y_AXIS));
		pThongTin.setBackground(Color.WHITE);
		pThongTin.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK),
				"  Th??ng tin Tour  "));
		pThongTin.setLayout(new GridLayout(5, 4));

		JLabel lbl1;
		pThongTin.add(lbl1 = new JLabel("M?? Tour: "));
		pThongTin.add(lblMaTour = new JLabel("NT_01"));

		JLabel lbl2;
		pThongTin.add(lbl2 = new JLabel("Ng??y Kh???i h??nh: "));
		pThongTin.add(lblNgayKhoiHanh = new JLabel("12/09/2022"));

		JLabel lbl3;
		pThongTin.add(lbl3 = new JLabel("T??n Tour: "));
		pThongTin.add(lblTenTour = new JLabel("TP.CHM-Nha Trang"));

		JLabel lbl4;
		pThongTin.add(lbl4 = new JLabel("Th???i gian: "));
		pThongTin.add(lblThoiGian = new JLabel("3N2D"));

		JLabel lbl8;
		pThongTin.add(lbl8 = new JLabel("??i???m xu???t ph??t: "));
		pThongTin.add(lblDiemXuatPhat = new JLabel("Nha Trang"));

		JLabel lbl5;
		pThongTin.add(lbl5 = new JLabel("Ph????ng ti???n: "));
		pThongTin.add(lblPhuongTien = new JLabel("M??y bay"));

		JLabel lbl7;
		pThongTin.add(lbl7 = new JLabel("??i???m ?????n: "));
		pThongTin.add(lblDiemDen = new JLabel("TPHCM"));

		JLabel lbl6;
		pThongTin.add(lbl6 = new JLabel("Gi?? Tour (D?????i 12 tu???i gi???m 50%): "));
		pThongTin.add(lblGiaTour = new JLabel("2,300,000"));
		lblGiaTour.setForeground(new Color(224, 37, 37));
		lblGiaTour.setFont(new Font(getName(), Font.BOLD, 20));

		JLabel lbl9;
		pThongTin.add(lbl9 = new JLabel("S??? l?????ng: "));
		pThongTin.add(lblSoLuong = new JLabel("40/50"));

		lbl1.setPreferredSize(lbl6.getPreferredSize());
		lbl2.setPreferredSize(lbl6.getPreferredSize());
		lbl3.setPreferredSize(lbl6.getPreferredSize());
		lbl4.setPreferredSize(lbl6.getPreferredSize());
		lbl5.setPreferredSize(lbl6.getPreferredSize());
		lbl6.setPreferredSize(lbl6.getPreferredSize());
		lbl7.setPreferredSize(lbl6.getPreferredSize());
		lbl8.setPreferredSize(lbl6.getPreferredSize());

		pMain.add(pThongTin);

		// ----------Th??ng tin kh??ch h??ng----------------//
		JPanel pKhachHang = new JPanel();
		pKhachHang.setBackground(Color.WHITE);
		pKhachHang.setLayout(new BoxLayout(pKhachHang, BoxLayout.Y_AXIS));
		// pKhachHang.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1,
		// 1, 1, 1, Color.BLACK),""));

		JPanel p = new JPanel();
		JLabel lblT;
		p.add(lblT = new JLabel("Th??ng tin kh??ch h??ng", new ImageIcon("img\\ThongTin.png"), SwingConstants.LEADING));
		lblT.setFont(new Font("Time New Roman", Font.BOLD, 25));
		pKhachHang.add(p);
		Box b10 = Box.createHorizontalBox();
		JLabel lblma;
		b10.add(Box.createRigidArea(new Dimension(40, 30)));
		b10.add(lblma = new JLabel("M?? kh??ch h??ng: "));
		b10.add(txtMaKH = new JTextField(20));
		txtMaKH.setFont(new Font(getName(), Font.PLAIN, 18));
		b10.add(Box.createRigidArea(new Dimension(40, 30)));
		pKhachHang.add(b10);
		pKhachHang.add(Box.createRigidArea(new Dimension(10, 10)));

		Box b11 = Box.createHorizontalBox();
		JLabel lblten;
		b11.add(Box.createRigidArea(new Dimension(40, 30)));
		b11.add(lblten = new JLabel("T??n: "));
		b11.add(txtTenKH = new JTextField(20));
		txtTenKH.setFont(new Font(getName(), Font.PLAIN, 18));
		JLabel lblsdt;
		b11.add(lblsdt = new JLabel("S??? ??i???n tho???i: "));
		b11.add(txtSDT = new JTextField(20));
		txtSDT.setFont(new Font(getName(), Font.PLAIN, 18));
		b11.add(Box.createRigidArea(new Dimension(40, 30)));
		pKhachHang.add(b11);
		pKhachHang.add(Box.createRigidArea(new Dimension(10, 10)));

		Box b12 = Box.createHorizontalBox();
		JLabel lbldiachi;
		b12.add(Box.createRigidArea(new Dimension(40, 30)));
		b12.add(lbldiachi = new JLabel("?????a ch???: "));
		b12.add(txtDiaChi = new JTextField(20));
		txtDiaChi.setFont(new Font(getName(), Font.PLAIN, 18));
		JLabel lblmail;
		b12.add(lblmail = new JLabel("Email: "));
		b12.add(txtMail = new JTextField(20));
		txtMail.setFont(new Font(getName(), Font.PLAIN, 18));
		b12.add(Box.createRigidArea(new Dimension(40, 30)));
		pKhachHang.add(b12);
		pKhachHang.add(Box.createRigidArea(new Dimension(10, 10)));

		Box b13 = Box.createHorizontalBox();
		JLabel lbldlon;
		b13.add(Box.createRigidArea(new Dimension(40, 30)));
		b13.add(lbldlon = new JLabel("S??? ng?????i l???n: "));
		b13.add(txtVeLon = new JTextField(20));
		txtVeLon.setFont(new Font(getName(), Font.PLAIN, 18));
		JLabel lblnho;
		b13.add(lblnho = new JLabel("S??? tr??? em: "));
		b13.add(txtVeNho = new JTextField(20));
		txtVeNho.setFont(new Font(getName(), Font.PLAIN, 18));
		b13.add(Box.createRigidArea(new Dimension(40, 30)));
		pKhachHang.add(b13);

		lbldlon.setPreferredSize(lblma.getPreferredSize());
		lblsdt.setPreferredSize(lblma.getPreferredSize());
		lbldiachi.setPreferredSize(lblma.getPreferredSize());
		lblmail.setPreferredSize(lblma.getPreferredSize());
		lblten.setPreferredSize(lblma.getPreferredSize());
		lblnho.setPreferredSize(lblma.getPreferredSize());

		pKhachHang.add(b13);
		pMain.add(pKhachHang);

		// ----------Thanh to??n-----------------//
		JPanel pThanhToan = new JPanel();
		pThanhToan.setBackground(Color.WHITE);
		pThanhToan.setLayout(new BoxLayout(pThanhToan, BoxLayout.Y_AXIS));
		JPanel p2 = new JPanel();
		JLabel lblTT;
		p2.add(lblTT = new JLabel("Ph????ng th???c thanh to??n v?? t???ng ti???n", new ImageIcon("img\\ThanhToan.png"),
				SwingConstants.LEADING));
		lblTT.setFont(new Font("Time New Roman", Font.BOLD, 25));
		pThanhToan.add(p2);

		JPanel p2_2 = new JPanel();
		p2_2.setBackground(Color.WHITE);
		p2_2.add(Box.createRigidArea(new Dimension(-806, 0)));
		p2_2.add(lblMaNV = new JLabel("M?? nh??n vi??n:"));
		p2_2.add(txtMaNhanVien = new JTextField(10));
		pThanhToan.add(p2_2);

		JPanel p2_3 = new JPanel();
		p2_3.add(Box.createRigidArea(new Dimension(-807, 0)));
		p2_3.setBackground(Color.WHITE);
		p2_3.add(lblMaHD = new JLabel("M?? h??a ????n:"));
		p2_3.add(txtMaHoaDon = new JTextField(10));
		pThanhToan.add(p2_3);

		lblMaHD.setPreferredSize(lblMaNV.getPreferredSize());

		JPanel p3 = new JPanel();
		p3.setBackground(Color.WHITE);
		p3.setLayout(new GridLayout(2, 2));
		p3.add(radTienMat = new JRadioButton("Ti???n m???t"));
		radTienMat.setBackground(Color.WHITE);
		p3.add(new JLabel("T???ng ti???n: "));
		p3.add(radChuyenKhoan = new JRadioButton("Chuy???n kho???n"));
		radChuyenKhoan.setBackground(Color.WHITE);
		p3.add(lblTongTien = new JLabel("0"));
		lblTongTien.setFont(new Font("Time New Roman", Font.BOLD, 20));
		lblTongTien.setForeground(Color.RED);
		pThanhToan.add(p3);
		pMain.add(pThanhToan);

		add(pMain, BorderLayout.CENTER);

		JPanel pButton = new JPanel();
		pButton.add(btnNhapLai = new JButton("Nh???p l???i", new ImageIcon("img\\refesh.png")));
		btnNhapLai.setBackground(new Color(129, 238, 150));
		btnNhapLai.setFont(new Font("Time New Roman", Font.BOLD, 20));
		btnNhapLai.setForeground(Color.WHITE);
		btnNhapLai.setToolTipText("Nh???p l???i th??ng tin");

		pButton.add(btnChapNhan = new JButton("Ch???p nh???n", new ImageIcon("img\\ChapNhan.png")));
		btnChapNhan.setBackground(new Color(42, 175, 45));
		btnChapNhan.setFont(new Font("Time New Roman", Font.BOLD, 20));
		btnChapNhan.setForeground(Color.WHITE);
		btnChapNhan.setToolTipText("Nh???p nh???n ?????t tour");

		pButton.add(btnDong = new JButton("????ng"));
		btnDong.setForeground(Color.WHITE);
		btnDong.setBackground(new Color(224, 37, 37));
		btnDong.setFont(new Font("Time New Roman", Font.BOLD, 20));
		btnDong.setToolTipText("????ng");

		add(pButton, BorderLayout.SOUTH);

		// ------------S??? ki???n--------------//
		btnChapNhan.addActionListener(this);
		btnNhapLai.addActionListener(this);
		btnDong.addActionListener(this);
		txtVeLon.addActionListener(this);
		txtVeNho.addActionListener(this);
		radChuyenKhoan.addActionListener(this);
		radTienMat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnChapNhan)) {
			KhachHang kh = gianGiaTriKhachHang();
			HoaDon hd = gianGiaTriHoaDon();

			ArrayList<KhachHang> listKh = khachHang_DAO.getAllKhachHang();
			if (listKh.contains(kh)) {
				JOptionPane.showConfirmDialog(null, "Tr??ng m??", "Th??ng b??o", JOptionPane.ERROR_MESSAGE);
				txtMaKH.requestFocus();
			} else {
				int select = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n ?????t tour n??y hay kh??ng ?");
				if (select == JOptionPane.YES_OPTION) {
					khachHang_DAO.addKhachHang(kh);
					hoaDon_DAO.addHoaDon(hd);
					int t = frm_Tour.getSoLuongKhachDKy(lblMaTour.getText());
					if (t >= 50) {
						frm_Tour.updateTrangThai(lblMaTour.getText(), true);
					}
					JOptionPane.showConfirmDialog(null, "?????t Tour th??nh c??ng.", "Th??ng b??o", JOptionPane.PLAIN_MESSAGE,
							JOptionPane.OK_OPTION);
					this.dispose();

				}
			}

		} else if (o.equals(btnNhapLai)) {
			txtDiaChi.setText("");
			txtMail.setText("");
			txtMaKH.setText("");
			txtSDT.setText("");
			txtTenKH.setText("");
			txtVeLon.setText("");
			txtVeNho.setText("");
			txtMaKH.requestFocus();
		} else if (o.equals(btnDong)) {
			this.dispose();
		} else if (o.equals(radChuyenKhoan)) {
			phuongThucTT = "Chuy???n kho???n";
		} else if (o.equals(radTienMat)) {
			phuongThucTT = "Ti???n m???t";
		} else if (txtVeLon.getText().length() > 0 && txtVeNho.getText().length() > 0) {
			tongTien = tinhTien(Integer.parseInt(txtVeLon.getText()), Integer.parseInt(txtVeNho.getText()));
			lblTongTien.setText(df.format(tongTien));
		}
	}

	public void setData(String maTour) {
		Tour tour = tour_DAO.getTourTheoMa(maTour);
		lblMaTour.setText(tour.getMaTour());
		lblTenTour.setText(tour.getTenTour());
		lblDiemXuatPhat.setText(tour.getDiemXuatPhat());
		lblDiemDen.setText(tour.getDiemDen());
		lblNgayKhoiHanh.setText(tour.getNgayKhoiHanh().toString());
		lblThoiGian.setText(tour.getThoiGian());
		lblPhuongTien.setText(frm_Tour.getPhuongTienTheoMa(tour.getPhuongTien().getMaPhuongTien()).getLoaiPhuongTien());
		lblSoLuong.setText(String.valueOf(frm_Tour.getSoLuongKhachDKy(tour.getMaTour()) + "\\"
				+ String.valueOf(tour.getSoLuongKhachHangQuyDinh())));
		// chiTietTour.setText(tour.getMaTour());
		lblGiaTour.setText(String.valueOf(df.format(tour.getGia())));

	}
	
	private HoaDon gianGiaTriHoaDon() {
		String maHD = txtMaHoaDon.getText();
		Tour tour = new Tour(lblMaTour.getText());
		KhachHang kh = new KhachHang(txtMaKH.getText());
		NhanVien nv = new NhanVien(txtMaNhanVien.getText());
		LocalDate ld = LocalDate.now();
		Date ngayDat = Date.valueOf(ld);
		int ngLon = Integer.parseInt(txtVeLon.getText());
		int treEm = Integer.parseInt(txtVeNho.getText());
		String pt = phuongThucTT;
		boolean tt = false;
		return new HoaDon(maHD, tour, kh, nv, ngayDat, ngLon, treEm, pt, tt, tongTien);
	}

	private KhachHang gianGiaTriKhachHang() {
		String maKH = txtMaKH.getText();
		String tenKh = txtTenKH.getText();
		String email = txtMail.getText();
		String sdt = txtSDT.getText();
		String diaChi = txtDiaChi.getText();
		return new KhachHang(maKH, tenKh, email, sdt, diaChi,null);
	}

	private double tinhTien(int veLon, int veNho) {
		double gia = Double.parseDouble(lblGiaTour.getText().replace(",", ""));
		return (veLon * gia) + (veNho * (gia * 0.5));
	}
}
