package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import dao.HoaDon_DAO;
import dao.NhanVien_DAO;
import entity.HoaDon;

public class Frm_SuaHoaDonDatTour extends JFrame implements ActionListener {
	private JLabel lblMaDon;
	private JLabel lblMaTour;
	private JLabel lblTenKH;
	private JLabel lblSLNguoiLon;
	private JLabel lblNgayDat;
	private JLabel lblSLTreCon;
	private JLabel lblTrangThai;
	private JLabel lblTongTien;
	private JTextField txtMaDon;
	private JTextField txtTenKH;
	private JTextField txtMaTour;
	private JTextField txtSLNguoiLon;
	private JTextField txtNgayDat;
	private JTextField txtSLTreCon;
	private JTextField txtTongTien;
	private JButton btnLuu;
	private JButton btnDong;
	private JComboBox cbbTrangThai;
	private Container pnlNorth;
	private JLabel lblTieuDe;
	private Frm_HoaDonDatTour home_HD;
	private HoaDon_DAO dsHoaDon;
	private Frm_HoaDonDatTour frm_HD;

	public Frm_SuaHoaDonDatTour(JPanel panel, boolean modal) {
		setTitle("Sửa Thông TIn Đặt Tour");
		setSize(780, 300);
		setLocationRelativeTo(null);
		
		frm_HD = new Frm_HoaDonDatTour();
		frm_HD =(Frm_HoaDonDatTour) panel;
		buildUI();
	}
	
	private void buildUI() {
		JPanel pnlNorth;
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		lblTieuDe = new JLabel("Sửa thông tin đđạt tour");
		lblTieuDe.setForeground(new Color(224, 37, 37));
		lblTieuDe.setFont(new Font("Time New Roman", Font.BOLD, 30));
		pnlNorth.add(lblTieuDe);
		
		JPanel pnlCenter;
		add(pnlCenter = new JPanel(), BorderLayout.CENTER);
		
		pnlCenter.setPreferredSize(new Dimension(0,200));
		pnlCenter.setBorder(BorderFactory.createTitledBorder("Thông Tin"));
		pnlCenter.setLayout(null);

		pnlCenter.add(lblMaDon = new JLabel("Mã Đơn: "));
		pnlCenter.add(lblMaTour = new JLabel("Mã Tour: "));
		pnlCenter.add(lblTenKH = new JLabel("Tên Khách Hàng: "));
		pnlCenter.add(lblSLNguoiLon = new JLabel("Số Lượng Người Lớn: "));
		pnlCenter.add(lblNgayDat = new JLabel("Ngày Đặt: "));
		pnlCenter.add(lblSLTreCon = new JLabel("Số Lượng Trẻ Con: "));
		pnlCenter.add(lblTrangThai = new JLabel("Trạng Thái: "));
		pnlCenter.add(lblTongTien = new JLabel("Tổng Tiền: "));
		

		pnlCenter.add(txtMaDon = new JTextField());
		txtMaDon.setEditable(false);
		pnlCenter.add(txtMaTour = new JTextField());
		pnlCenter.add(txtTenKH = new JTextField());
		pnlCenter.add(txtSLNguoiLon = new JTextField());
		pnlCenter.add(txtNgayDat = new JTextField());
		pnlCenter.add(txtSLTreCon = new JTextField());
		cbbTrangThai= new JComboBox();
		cbbTrangThai.addItem("Chưa thanh toán");
		cbbTrangThai.addItem("Đã thanh toán");
		pnlCenter.add(cbbTrangThai);
		pnlCenter.add(txtTongTien = new JTextField());

		int w1 = 150, w2 = 200, h = 20;
		lblMaDon.setBounds(20, 27, w1, h);
		txtMaDon.setBounds(130, 27, w2, h);
		lblMaTour.setBounds(400, 27, w1, h);
		txtMaTour.setBounds(540, 27, w2, h);

		lblTenKH.setBounds(20, 52, w1, h);
		txtTenKH.setBounds(130, 52, w2, h);
		lblSLNguoiLon.setBounds(400, 52, w1, h);
		txtSLNguoiLon.setBounds(540, 52, w2, h);

		lblNgayDat.setBounds(20, 77, w1, h);
		txtNgayDat.setBounds(130, 77, w2, h);
		lblSLTreCon.setBounds(400, 77, w1, h);
		txtSLTreCon.setBounds(540, 77, w2, h);

		lblTrangThai.setBounds(20, 102, w1, h);
		cbbTrangThai.setBounds(130, 102, w2, h);
		lblTongTien.setBounds(400, 102, w1, h);
		txtTongTien.setBounds(540, 102, w2, h);
		
		
		JPanel pnlSouth;
		add(pnlSouth = new JPanel(), BorderLayout.SOUTH);
		btnLuu = new JButton("Lưu", new ImageIcon("img\\save.png"));
		btnLuu.setForeground(Color.WHITE);
		btnLuu.setBackground(new Color(42, 175, 45));
		btnLuu.setToolTipText("Lưu thông tin đặt tour");
		btnLuu.setFont(new Font("Time new roman", Font.BOLD, 20));
		
		pnlSouth.add(btnLuu);
		btnDong = new JButton("Đóng", new ImageIcon("img\\close.png"));
		btnDong.setForeground(Color.WHITE);
		btnDong.setBackground(new Color(224, 37, 37));
		btnDong.setToolTipText("Đóng");
		btnDong.setFont(new Font("time new roman", Font.BOLD, 20));
		pnlSouth.add(btnDong);
		
		btnLuu.addActionListener(this);
		btnDong.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnLuu)) {
			String maHoaDon = txtMaDon.getText().trim();
			String maTour = txtMaTour.getText().trim();
			String tenKH = txtTenKH.getText().trim();
			Date ngayDat = Date.valueOf(txtNgayDat.getText());
			String sLNguoiLon = txtSLNguoiLon.getText().trim();
			String  sLTreCon = txtSLTreCon.getText().trim();
			String tongTien = txtTongTien.getText().trim();
			
//			boolean tt;
//			if (cbbTrangThai.equals("Nam")) {
//				tt = true;
//			} else
//				tt = false;
			HoaDon hoaDonNew = new HoaDon(null, null, null, null, ngayDat, ERROR, ALLBITS, tongTien, rootPaneCheckingEnabled, ABORT);		
			home_HD = new Frm_HoaDonDatTour();
			home_HD.suaThongTinHoaDon(hoaDonNew);

	//		JOptionPane.showMessageDialog(this, "Lưu thành công !");
			this.dispose();

		}
		if (e.getSource().equals(btnDong)) {
			this.dispose();
		}
	}
	public void setEditData(HoaDon hoaDon) {
		// TODO Auto-generated method stub
		txtMaDon.setText(hoaDon.getMaHoaDon());
		txtMaTour.setText(hoaDon.getTour().getMaTour());
		txtTenKH.setText(hoaDon.getKhachHang().getMaKhachHang());
		txtNgayDat.setText(String.valueOf(hoaDon.getNgayDat()));
		txtSLNguoiLon.setText(String.valueOf(hoaDon.getSoLuongNguoiLon()));
		txtSLTreCon.setText(String.valueOf(hoaDon.getSoLuongTreEm()));
		cbbTrangThai.setSelectedItem(String.valueOf(hoaDon.getTrangThai()));
		txtTongTien.setText(String.valueOf(hoaDon.getTongTien()));
	}
	
}
