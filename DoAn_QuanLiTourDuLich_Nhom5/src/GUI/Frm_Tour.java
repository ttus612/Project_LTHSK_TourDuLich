package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.HoaDon_DAO;
import dao.PhuongTien_DAO;
import dao.Tour_DAO;
import entity.PhuongTien;
import entity.Tour;

public class Frm_Tour extends JPanel implements ActionListener, MouseListener {
	private JTextField txtMaTour;
	private JTextField txtDiemDen;
	private JTextField txtNgayDi;
	private JComboBox<String> cbbTinhTrang;
	private JButton btnTimKiemTour;
	private JButton btnThemTour;
	private DefaultTableModel modelTableTour;
	private JTable tableTour;
	private JButton btnSuaTour;
	private Tour_DAO tour_DAO;
	private PhuongTien_DAO phuongTien_DAO;
	private PhuongTien phuongTien;
	private ArrayList<Tour> listTour;
	private HoaDon_DAO hoaDon_DAO;
	private int count;
	private DecimalFormat df;
	private JButton btnFirst;
	private JButton btnLeft;
	private JLabel lblMauTin;
	private JButton btnRight;
	private JButton btnLast;
	private int mauTinHienHanh;
	private int tongMauTin;
	private JButton btnCapNhat;
	private JButton btnDau;
	private JButton btnSau;
	private JButton btnTruoc;
	private JButton btnCuoi;

	public Frm_Tour() {
		this.setPreferredSize(new Dimension(1000, 600));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		tour_DAO = new Tour_DAO();
		phuongTien_DAO = new PhuongTien_DAO();
		hoaDon_DAO = new HoaDon_DAO();
		listTour = tour_DAO.getAllTour();
		df = new DecimalFormat("#,##0.00");

		// --------Quản lý tour--------//
		JPanel pQL = new JPanel();
		pQL.setLayout(new BorderLayout());
		JLabel lblTitle;
		JPanel pTitle = new JPanel();
		pTitle.setBackground(Color.LIGHT_GRAY);
		pTitle.add(lblTitle = new JLabel("Quản lý Tour", new ImageIcon("img\\icon_ds.png"), SwingConstants.CENTER));
		lblTitle.setFont(new Font("Time New Roman", Font.BOLD, 40));
		pQL.add(pTitle, BorderLayout.NORTH);

		// ---------JText----------//
		JPanel pTacVu = new JPanel();

		pTacVu.setLayout(new BoxLayout(pTacVu, BoxLayout.Y_AXIS));
		Box b = Box.createHorizontalBox();
		Box b1 = Box.createVerticalBox();
		JLabel lblMaTour;

		b1.add(lblMaTour = new JLabel("Mã tour", new ImageIcon("img\\tour.png"), SwingConstants.CENTER));
		lblMaTour.setFont(new Font("Time New Roman", Font.BOLD, 20));
		setLable(lblMaTour);
		b1.add(txtMaTour = new JTextField(10));
		txtMaTour.setFont(new Font(TOOL_TIP_TEXT_KEY, ALLBITS, 20));

		Box b2 = Box.createVerticalBox();
		JLabel lblDiemDem;
		b2.add(lblDiemDem = new JLabel("Địa điểm đến", new ImageIcon("img\\dia_diem.png"), SwingConstants.CENTER));
		lblDiemDem.setFont(new Font("Time New Roman", Font.BOLD, 20));
		setLable(lblDiemDem);
		b2.add(txtDiemDen = new JTextField(10));
		txtDiemDen.setFont(new Font(TOOL_TIP_TEXT_KEY, ALLBITS, 20));
		


		Box b3 = Box.createVerticalBox();
		JLabel lblNgayDi;
		b3.add(lblNgayDi = new JLabel("Ngày đi", new ImageIcon("img\\calender.png"), SwingConstants.CENTER));
		lblNgayDi.setFont(new Font("Time New Roman", Font.BOLD, 20));
		setLable(lblNgayDi);
		b3.add(txtNgayDi = new JTextField(10));
		txtNgayDi.setFont(new Font(TOOL_TIP_TEXT_KEY, ALLBITS, 20));

		Box b4 = Box.createVerticalBox();
		JLabel lblTinhTrang;
		b4.add(lblTinhTrang = new JLabel("Tình trạng"));
		lblTinhTrang.setFont(new Font("Time New Roman", Font.BOLD, 20));
		setLable(lblTinhTrang);
		b4.add(cbbTinhTrang = new JComboBox<String>());
		cbbTinhTrang.setFont(new Font(TOOL_TIP_TEXT_KEY, ALLBITS, 18));
		cbbTinhTrang.addItem("All");
		cbbTinhTrang.addItem("Còn chỗ");
		cbbTinhTrang.addItem("Hết chỗ");

		// ------Nút bấm-------//
		Box b5 = Box.createHorizontalBox();
		b5.add(btnTimKiemTour = new JButton("Tìm kiếm", new ImageIcon("img\\tim.png")));
		btnTimKiemTour.setFont(new Font("Time New Roman", Font.BOLD, 20));
		btnTimKiemTour.setBackground(new Color(38, 177, 221));
		btnTimKiemTour.setForeground(Color.WHITE);
		btnTimKiemTour.setToolTipText("Tìm kiếm tour");
		b5.add(Box.createRigidArea(new Dimension(20, 20)));

		b5.add(btnThemTour = new JButton("Thêm", new ImageIcon("img\\them.png")));
		btnThemTour.setFont(new Font("Time New Roman", Font.BOLD, 20));
		btnThemTour.setBackground(new Color(42, 175, 45));
		btnThemTour.setForeground(Color.WHITE);
		btnThemTour.setToolTipText("Thêm tour");
		b5.add(Box.createRigidArea(new Dimension(20, 20)));

		b5.add(btnSuaTour = new JButton("Sửa", new ImageIcon("img\\update.png")));
		btnSuaTour.setFont(new Font("Time New Roman", Font.BOLD, 20));
		btnSuaTour.setBackground(new Color(129, 238, 150));
		btnSuaTour.setForeground(Color.WHITE);
		btnSuaTour.setToolTipText("Sửa thông tin tour");
		b5.add(Box.createRigidArea(new Dimension(700, 20)));

		b.add(Box.createRigidArea(new Dimension(0, 40)));
		b.add(b1);
		b.add(Box.createRigidArea(new Dimension(40, 40)));
		b.add(b2);
		b.add(Box.createRigidArea(new Dimension(40, 40)));
		b.add(b3);
		b.add(Box.createRigidArea(new Dimension(40, 40)));
		b.add(b4);
		b.add(Box.createRigidArea(new Dimension(40, 40)));
		pTacVu.add(b);
		pTacVu.add(Box.createRigidArea(new Dimension(10, 10)));
		pTacVu.add(b5);
		pTacVu.add(Box.createRigidArea(new Dimension(20, 20)));
		pQL.add(pTacVu);
		add(pQL);

		// -----------TableTour-------------//
		JPanel pTable = new JPanel();
		pTable.setLayout(new BorderLayout());
		JLabel lblTitle1;
		JPanel pTitle1 = new JPanel();
		pTitle1.setBackground(Color.LIGHT_GRAY);
		pTitle1.add(lblTitle1 = new JLabel("Danh sách tour", new ImageIcon("img\\icon_ds.png"), SwingConstants.CENTER));
		lblTitle1.setFont(new Font("Time New Roman", Font.BOLD, 35));
		pTable.add(pTitle1, BorderLayout.NORTH);

		String header[] = { "Mã tour", "Tên tour", "Điểm xuất phát", "Điểm đến", "Ngày khởi hành", "Thời gian",
				"Số lượng khách quy định", "Phương tiện", "Giá", "Số lượng đã đăng kí", "Trạng thái", "" };
		modelTableTour = new DefaultTableModel(header, 0);
		tableTour = new JTable(modelTableTour);
		tableTour.setRowHeight(20);
		tableTour.setFont(new Font("Time New Roman", ALLBITS, 18));
		tableTour.setDefaultEditor(Object.class, null);
		tableTour.getColumnModel().getColumn(11).setCellRenderer(new ButtonRenderer());
		tableTour.getColumnModel().getColumn(11).setCellEditor(new TourTableButtonEditor(new JTextField("Xóa")));

		// --------Tải dữ liệu lên bảng------------//
//		modelTableTour.addRow(new Object[] {"NT_01","Nha trang _ HCM","Nha Trang",
//				"12/09/2022","3N2D","1300000","Còn chỗ"});
//		modelTableTour.addRow(new Object[] {"NT_01","Nha trang _ HCM","Nha Trang",
//				"12/09/2022","3N2D","1300000","Còn chỗ"});
		pTable.add(new JScrollPane(tableTour), BorderLayout.CENTER);

		themDuLieuTourVaoBang(listTour);
		add(pTable);
		
		JPanel pSouth = new JPanel();
		
		pSouth.setLayout(new BoxLayout(pSouth, BoxLayout.X_AXIS));
		pSouth.add(btnCapNhat = new JButton("Cập nhật lại danh sách",new ImageIcon("img\\refesh.png")));
		btnCapNhat.setBackground(new Color(255, 215, 0));
		pSouth.add(Box.createRigidArea(new Dimension(200, 0)));
		pSouth.add(btnDau = new JButton(new ImageIcon("img\\icon_dau.png")));
		pSouth.add(btnSau = new JButton(new ImageIcon("img\\icon_sau.png")));
		pSouth.add(lblMauTin = new JLabel());
		pSouth.add(btnTruoc = new JButton(new ImageIcon("img\\icon_truoc.png")));
		pSouth.add(btnCuoi = new JButton(new ImageIcon("img\\icon_cuoi.png")));
		pSouth.add(Box.createRigidArea(new Dimension(400, 0)));
		
		add(pSouth,BorderLayout.SOUTH);

		// Tooltip cho nút
		btnTimKiemTour.setToolTipText("Tìm");
		btnThemTour.setToolTipText("Thêm");
		// Tooltip cho bảng
		tableTour.getTableHeader().setToolTipText("Bảng quản lí thông tin tour");
		// PopMenu
		JPopupMenu popup = new JPopupMenu();
		JMenuItem openItem = new JMenuItem("Mở", new ImageIcon("img\\open.png"));
		JMenuItem refeshItem = new JMenuItem("Làm mới", new ImageIcon("img\\refesh.png"));
		JMenuItem coppyItem = new JMenuItem("Lưu", new ImageIcon("img\\save.png"));
		JMenuItem pasteItem = new JMenuItem("Dán", new ImageIcon("img\\paste.png"));
		JMenuItem cutItem = new JMenuItem("Cắt", new ImageIcon("img\\cut.png"));
		popup.add(openItem);
		popup.add(refeshItem);
		popup.add(coppyItem);
		popup.add(pasteItem);
		popup.add(cutItem);

		btnTimKiemTour.setComponentPopupMenu(popup);
		btnThemTour.setComponentPopupMenu(popup);
		txtMaTour.setComponentPopupMenu(popup);
		txtDiemDen.setComponentPopupMenu(popup);
		txtNgayDi.setComponentPopupMenu(popup);
		cbbTinhTrang.setComponentPopupMenu(popup);
		tableTour.setComponentPopupMenu(popup);

		// ---------Đky sự kiện-------------//
		btnThemTour.addActionListener(this);
		btnTimKiemTour.addActionListener(this);
		btnSuaTour.addActionListener(this);
		btnDau.addActionListener(this);
		btnCuoi.addActionListener(this);
		btnSau.addActionListener(this);
		btnTruoc.addActionListener(this);
		btnCapNhat.addActionListener(this);
		tableTour.addMouseListener(this);
		
		mauTinHienHanh = -1;
		tongMauTin = tableTour.getRowCount();
		if (tongMauTin > 0) {
			mauTinHienHanh = 0; // Khởi tạo là mẫu tin đầu tiên
			capNhatThongTinMauTin(mauTinHienHanh);
		}

	}

	public void setLable(JLabel lbl) {
		lbl.setFont(new Font("Time New Roman", Font.PLAIN, 20));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			// JOptionPane.showConfirmDialog(null, "Hiển thị frm thông tin tour");
			int row = tableTour.getSelectedRow();
			Frm_ThongTinChiTietTour frm_ThongTinTour = new Frm_ThongTinChiTietTour();
			frm_ThongTinTour.setVisible(true);
			frm_ThongTinTour.setData(listTour.get(row));

		}
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
		if (obj.equals(btnThemTour)) {
			Frm_ThemTour frmThem = new Frm_ThemTour(this, isFocusCycleRoot());
			frmThem.setVisible(true);
		} else if (obj.equals(btnSuaTour)) {
			Frm_SuaTour frm_SuaTour = new Frm_SuaTour(this, isFocusCycleRoot());
			frm_SuaTour.setData(listTour.get(tableTour.getSelectedRow()));
			frm_SuaTour.setVisible(true);
		} else if (obj.equals(btnTimKiemTour)) {
			if (txtMaTour.getText().length() == 0 && txtDiemDen.getText().length() == 0
					&& txtNgayDi.getText().length() == 0 && cbbTinhTrang.getSelectedItem().equals("All")) {
				xoaBang();
				themDuLieuTourVaoBang(listTour);
			}
			// --------Tìm theo mã tour---------//
			else if (txtMaTour.getText().length() > 0 && txtDiemDen.getText().length() == 0
					&& txtNgayDi.getText().length() == 0) {
				Tour tour = tour_DAO.getTourTheoMa(txtMaTour.getText());
				if (tour != null) {
					xoaBang();
					count = getSoLuongKhachDKy(tour.getMaTour());
					phuongTien = getPhuongTienTheoMa(tour.getPhuongTien().getMaPhuongTien());
					modelTableTour.addRow(new Object[] { tour.getMaTour(), tour.getTenTour(), tour.getDiemXuatPhat(),
							tour.getDiemDen(), tour.getNgayKhoiHanh(), tour.getThoiGian(),
							tour.getSoLuongKhachHangQuyDinh(), phuongTien.getLoaiPhuongTien(), df.format(tour.getGia()),
							count, tour.getTrangThai() });

				} else
					JOptionPane.showConfirmDialog(null, "Không tìm thấy Tour có mã " + txtMaTour.getText());

			}
			// ---------Tìm theo điểm đến-----------//
			else if (txtMaTour.getText().length() == 0 && txtDiemDen.getText().length() > 0
					&& txtNgayDi.getText().length() == 0 && cbbTinhTrang.getSelectedItem().equals("All")) {
				ArrayList<Tour> lstTheoDiemDen = tour_DAO.getTourTheoDiemDen(txtDiemDen.getText());
				if (lstTheoDiemDen.size() > 0) {
					xoaBang();
					themDuLieuTourVaoBang(lstTheoDiemDen);
				} else
					JOptionPane.showConfirmDialog(null, "Không tìm thấy Tour có điểm đến là " + txtDiemDen.getText());

			}
			// ---------Tìm theo ngày đi------------//
			else if (txtMaTour.getText().length() == 0 && txtDiemDen.getText().length() == 0
					&& txtNgayDi.getText().length() > 0 && cbbTinhTrang.getSelectedItem().equals("All")) {
				ArrayList<Tour> lstTheoNgayDi = tour_DAO.getTourTheoNgayDi(Date.valueOf(txtNgayDi.getText()));
				if (lstTheoNgayDi.size() > 0) {
					xoaBang();
					themDuLieuTourVaoBang(lstTheoNgayDi);
				} else
					JOptionPane.showConfirmDialog(null, "Không tìm thấy Tour có ngày đi là " + txtNgayDi.getText());

			}
			// ---------Tìm theo trang thai-----------//
			else if (txtMaTour.getText().length() == 0 && txtDiemDen.getText().length() == 0
					&& txtNgayDi.getText().length() == 0 && !cbbTinhTrang.getSelectedItem().equals("All")) {
				boolean bl = false;
				if (cbbTinhTrang.getSelectedItem().equals("Còn Chỗ"))
					bl = false;
				else if (cbbTinhTrang.getSelectedItem().equals("Hết chỗ"))
					bl = true;
				ArrayList<Tour> lstTheoTrangThai = tour_DAO.getTourTheoTrangThai(bl);
				if (lstTheoTrangThai.size() > 0) {
					xoaBang();
					themDuLieuTourVaoBang(lstTheoTrangThai);
				} else
					JOptionPane.showConfirmDialog(null,
							"Không tìm thấy Tour có trạng thái là " + cbbTinhTrang.getSelectedItem());

			}

			// --------Tìm theo điểm đến và ngày đi------------//
			else if (txtMaTour.getText().length() == 0 && txtDiemDen.getText().length() > 0
					&& txtNgayDi.getText().length() > 0 && cbbTinhTrang.getSelectedItem().equals("All")) {
				ArrayList<Tour> lstTheoDiemDenNgayDi = tour_DAO.getTourTheoDiemDenVaNgayDi(txtDiemDen.getText(),
						Date.valueOf(txtNgayDi.getText()));
				if (lstTheoDiemDenNgayDi.size() > 0) {
					xoaBang();
					themDuLieuTourVaoBang(lstTheoDiemDenNgayDi);
				} else
					JOptionPane.showConfirmDialog(null, "Không tìm thấy Tour có điểm đến là " + txtDiemDen.getText()
							+ " và đi trong ngày " + txtNgayDi.getText());
			}
			// --------Tìm theo điểm đến và trạng thái------------//
			else if (txtMaTour.getText().length() == 0 && txtDiemDen.getText().length() > 0
					&& txtNgayDi.getText().length() == 0) {
				boolean bl = false;
				if (cbbTinhTrang.getSelectedItem().equals("Còn Chỗ"))
					bl = false;
				else if (cbbTinhTrang.getSelectedItem().equals("Hết chỗ"))
					bl = true;
				ArrayList<Tour> lstTheoDiemDenTrangThai = tour_DAO.getTourTheoDiemDenVaTrangThai(txtDiemDen.getText(),
						bl);
				if (lstTheoDiemDenTrangThai.size() > 0) {
					xoaBang();
					themDuLieuTourVaoBang(lstTheoDiemDenTrangThai);
				} else
					JOptionPane.showConfirmDialog(null, "Không tìm thấy Tour có có điểm đến là " + txtDiemDen.getText()
							+ " có trạng thái " + cbbTinhTrang.getSelectedItem());

			}
			// --------Tìm theo ngày đi và trạng thái-------------//
			else if (txtMaTour.getText().length() == 0 && txtDiemDen.getText().length() == 0
					&& txtNgayDi.getText().length() > 0) {
				boolean bl = false;
				if (cbbTinhTrang.getSelectedItem().equals("Còn Chỗ"))
					bl = false;
				else if (cbbTinhTrang.getSelectedItem().equals("Hết chỗ"))
					bl = true;
				ArrayList<Tour> lstTheoNgayDiTrangThai = tour_DAO
						.getTourTheoNgayDiVaTrangThai(Date.valueOf(txtNgayDi.getText()), bl);
				if (lstTheoNgayDiTrangThai.size() > 0) {
					xoaBang();
					themDuLieuTourVaoBang(lstTheoNgayDiTrangThai);
				} else
					JOptionPane.showConfirmDialog(null, "Không tìm thấy Tour khởi hành vào ngày " + txtNgayDi.getText()
							+ " có trạng thái " + cbbTinhTrang.getSelectedItem());

			}

			// ---------Tìm theo điểm đến và ngày đi và trạng thái-------------//
			else if (txtMaTour.getText().length() == 0 && txtDiemDen.getText().length() > 0
					&& txtNgayDi.getText().length() > 0) {
				boolean bl = false;
				if (cbbTinhTrang.getSelectedItem().equals("Còn Chỗ"))
					bl = false;
				else if (cbbTinhTrang.getSelectedItem().equals("Hết chỗ"))
					bl = true;
				ArrayList<Tour> lstTheoDiemDenNgayDiTrangThai = tour_DAO.getTourTheoDiemDenVaNgayDiVaTrangThai(
						txtDiemDen.getText(), Date.valueOf(txtNgayDi.getText()), bl);
				if (lstTheoDiemDenNgayDiTrangThai.size() > 0) {
					xoaBang();
					themDuLieuTourVaoBang(lstTheoDiemDenNgayDiTrangThai);
				} else
					JOptionPane.showConfirmDialog(null, "Không tìm thấy Tour có có điểm đến là " + txtDiemDen.getText()
							+ " vào ngày " + txtNgayDi.getText() + " có trạng thái " + cbbTinhTrang.getSelectedItem());

			}

		}
		else if(obj.equals(btnCapNhat)) {
			xoaBang();
			listTour = tour_DAO.getAllTour();
			themDuLieuTourVaoBang(listTour);
		}
		if (tongMauTin > 0) {
			if (obj.equals(btnDau))
				mauTinHienHanh = 0;
			else if (obj.equals(btnCuoi))
				mauTinHienHanh = tongMauTin - 1;
			else if (obj.equals(btnTruoc) && mauTinHienHanh < tongMauTin - 1)
				mauTinHienHanh++;
			else if (obj.equals(btnSau) && mauTinHienHanh > 0)
				mauTinHienHanh--;
			capNhatThongTinMauTin(mauTinHienHanh);
		}

	}

	// ---------------Phương thức------------------/
	private void themDuLieuTourVaoBang(ArrayList<Tour> listT) {
		for (Tour obj : listT) {
			count = getSoLuongKhachDKy(obj.getMaTour());
			phuongTien = getPhuongTienTheoMa(obj.getPhuongTien().getMaPhuongTien());
			modelTableTour.addRow(new Object[] { obj.getMaTour(), obj.getTenTour(), obj.getDiemXuatPhat(),
					obj.getDiemDen(), obj.getNgayKhoiHanh(), obj.getThoiGian(), obj.getSoLuongKhachHangQuyDinh(),
					phuongTien.getLoaiPhuongTien(), df.format(obj.getGia()), count, obj.getTrangThai() });
		}
	}

	private void xoaBang() {
		DefaultTableModel dm = (DefaultTableModel) tableTour.getModel();
		dm.getDataVector().removeAllElements();
	}

	public int getSoLuongKhachDKy(String maTour) {
		return hoaDon_DAO.getSoLuongDKy(maTour);
	}

	public PhuongTien getPhuongTienTheoMa(String maPT) {
		return phuongTien_DAO.getPhuongTienTheoMa(maPT);
	}

	public void suaThongTinTour(Tour tour) {
		if (tour_DAO.updateTour(tour)) {
			xoaBang();
			listTour = tour_DAO.getAllTour();
			themDuLieuTourVaoBang(listTour);
			JOptionPane.showConfirmDialog(null, "Sửa thành công", "Thông báo", JOptionPane.WARNING_MESSAGE,
					JOptionPane.OK_CANCEL_OPTION);
		} else
			JOptionPane.showConfirmDialog(null, "Sửa không thành công", "Thông báo", JOptionPane.WARNING_MESSAGE,
					JOptionPane.OK_CANCEL_OPTION);
	}

	public void addTour(Tour tour) {

		if (tour_DAO.addTour(tour)) {
			xoaBang();
			listTour = tour_DAO.getAllTour();
			themDuLieuTourVaoBang(listTour);
			JOptionPane.showConfirmDialog(null, "Thêm Tour thành công", "Thông báo", JOptionPane.WARNING_MESSAGE,
					JOptionPane.OK_CANCEL_OPTION);

		} else {
			Exception e = new Exception();
			JOptionPane.showConfirmDialog(null, "Thêm Tour không thành công", "Thông báo", JOptionPane.WARNING_MESSAGE,
					JOptionPane.OK_CANCEL_OPTION);

		}

	}

	public void updateTrangThai(String maTour, boolean tt) {
		tour_DAO.updateTrangThaiTour(maTour, tt);
		xoaBang();
		listTour = tour_DAO.getAllTour();
		themDuLieuTourVaoBang(listTour);
	}
	
	private void capNhatThongTinMauTin(int n) {
		// TODO Auto-generated method stub
		tableTour.setRowSelectionInterval(n, n);//đưa con trỏ vào dòng dầu tiên của bảng
		lblMauTin.setText(mauTinHienHanh + 1 + "/" + tongMauTin);
//		int row  = tableLopHoc.getSelectedRow();
		
	}

}
