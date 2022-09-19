package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;

import dao.NhanVien_DAO;
import entity.KhachHang;
import entity.NhanVien;

public class Frm_NhanVien extends JPanel implements ActionListener, MouseListener {
	private DefaultTableModel modelTableNhanvien;
	private JTable tableNhanVien;
	private JTextField txtTimNhanvien;
	private JButton btnTimNhanvien;
	private JLabel lblTim;
	private JTextField txtSua;
	private JButton btnSuaNV;
	private NhanVien_DAO dsNhanVien;
	private ArrayList<NhanVien> listNV;
	private JButton btnCapNhat;
	private JButton btnDau;
	private JButton btnSau;
	private JLabel lblMauTin;
	private JButton btnTruoc;
	private JButton btnCuoi;
	private int mauTinHienHanh;
	private int tongSoMauTin;

	public Frm_NhanVien() {
		this.setPreferredSize(new Dimension(1000, 600));
		this.setLayout(new BorderLayout());

		// ------------Title------------------//
		JLabel lblTitel;
		JPanel pTitle = new JPanel();
		pTitle.setBackground(Color.LIGHT_GRAY);
		pTitle.add(
				lblTitel = new JLabel("Danh sách nhân viên", new ImageIcon("img\\icon_ds.png"), SwingConstants.CENTER),
				BorderLayout.CENTER);
		lblTitel.setFont(new Font("Time New Roman", Font.BOLD, 40));
		add(pTitle, BorderLayout.NORTH);

		// -----------Tìm kiếm nhân viên----------------//
		JPanel pCenter = new JPanel();
		pCenter.setLayout(new BorderLayout());
		Box bTimKiem = Box.createVerticalBox();
		bTimKiem.add(Box.createRigidArea(new Dimension(10, 10)));
		Box b1 = Box.createHorizontalBox();
		b1.add(lblTim = new JLabel("Mã nhân viên", new ImageIcon("img\\nhan_vien.png"), SwingConstants.CENTER));
		lblTim.setFont(new Font("Time New Roman", Font.BOLD, 20));
		b1.add(Box.createRigidArea(new Dimension(1000, 0)));
		bTimKiem.add(b1);
		Box b2 = Box.createHorizontalBox();
		b2.add(txtTimNhanvien = new JTextField(30));
		txtTimNhanvien.setFont(new Font("Time New Roman", ALLBITS, 20));
		b2.add(Box.createRigidArea(new Dimension(20, 20)));
		b2.add(btnTimNhanvien = new JButton("Tìm kiếm", new ImageIcon("img\\tim.png")));
		btnTimNhanvien.setBackground(new Color(38, 177, 221));
		btnTimNhanvien.setFont(new Font("Time New Roman", Font.BOLD, 18));
		btnTimNhanvien.setForeground(Color.WHITE);
		btnTimNhanvien.setToolTipText("Tìm kiếm nhân viên");

		b2.add(Box.createRigidArea(new Dimension(20, 20)));
		b2.add(btnSuaNV = new JButton("Sửa", new ImageIcon("img\\update.png")));
		btnSuaNV.setBackground(new Color(129, 238, 150));
		btnSuaNV.setFont(new Font("Time New Roman", Font.BOLD, 18));
		btnSuaNV.setForeground(Color.WHITE);

		b2.add(Box.createRigidArea(new Dimension(500, 0)));
		bTimKiem.add(b2);
		bTimKiem.add(Box.createRigidArea(new Dimension(20, 20)));
		pCenter.add(bTimKiem, BorderLayout.NORTH);

		// ------------TableNhanVien--------------------//
		String header[] = { "Mã nhân viên", "Họ tên", "Giới tính", "Ngày sinh", "Số điện thoại", "" };
		modelTableNhanvien = new DefaultTableModel(header, 0);
		tableNhanVien = new JTable(modelTableNhanvien);
		tableNhanVien.setDefaultEditor(Object.class, null);
		tableNhanVien.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
		tableNhanVien.getColumnModel().getColumn(5).setCellEditor(new NhanVienTableButtonEditor(new JTextField("Xóa")));

		tableNhanVien.setRowHeight(20);
		tableNhanVien.setFont(new Font("Time New Roman", Font.PLAIN, 18));
		pCenter.add(new JScrollPane(tableNhanVien), BorderLayout.CENTER);
		dsNhanVien = new NhanVien_DAO();
		themDuLieuNhanVienVaoBang();

		add(pCenter, BorderLayout.CENTER);
		
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
		btnTimNhanvien.setToolTipText("Tìm");
		btnSuaNV.setToolTipText("Sửa thông tin nhân viên");
		// Tooltip cho bảng
		tableNhanVien.getTableHeader().setToolTipText("Bảng quản lí thông tin nhân viên");
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

		btnTimNhanvien.setComponentPopupMenu(popup);
		txtTimNhanvien.setComponentPopupMenu(popup);
		tableNhanVien.setComponentPopupMenu(popup);

		mauTinHienHanh = -1;
		tongSoMauTin = tableNhanVien.getRowCount();
		if (tongSoMauTin > 0) {
			mauTinHienHanh = 0; // Khởi tạo là mẫu tin đầu tiên
			capNhatThongTinMauTin(mauTinHienHanh);
		}
		// đăng kí lắng nghe
		tableNhanVien.addMouseListener(this);
		btnSuaNV.addActionListener(this);
		btnTimNhanvien.addActionListener(this);
		btnDau.addActionListener(this);
		btnCuoi.addActionListener(this);
		btnTruoc.addActionListener(this);
		btnSau.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnSuaNV)) {
			ArrayList<NhanVien> listNV = dsNhanVien.getAllNhanVien();
			Frm_SuaNhanVien frm_SuaNV = new Frm_SuaNhanVien(this, isFocusCycleRoot());
			frm_SuaNV.setEditData(listNV.get(tableNhanVien.getSelectedRow()));
			frm_SuaNV.setVisible(true);
		} else if (obj.equals(btnTimNhanvien)) {
			timTheoMaNhanVien();

		} else if (obj.equals(btnCapNhat)) {
			XoaHetDuLieuTrenTableModel();
			themDuLieuNhanVienVaoBang();
			tableNhanVien.setModel(modelTableNhanvien);
		}
		if (tongSoMauTin > 0) {
			if (obj.equals(btnDau))
				mauTinHienHanh = 0;
			else if (obj.equals(btnCuoi))
				mauTinHienHanh = tongSoMauTin - 1;
			else if (obj.equals(btnTruoc) && mauTinHienHanh < tongSoMauTin - 1)
				mauTinHienHanh++;
			else if (obj.equals(btnSau) && mauTinHienHanh > 0)
				mauTinHienHanh--;
			capNhatThongTinMauTin(mauTinHienHanh);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			try {
				ArrayList<NhanVien> lst = dsNhanVien.getAllNhanVien();
				Frm_ThongTinNhanVien thongTin = new Frm_ThongTinNhanVien();
				thongTin.setEditData(lst.get(tableNhanVien.getSelectedRow()));
				thongTin.setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private void themDuLieuNhanVienVaoBang() {
		ArrayList<NhanVien> listNV = dsNhanVien.getAllNhanVien();
		String gt;
		for (NhanVien obj : listNV) {
			if(obj.isGioiTinh() == true) {
				gt = "Nam";
			}
			else gt="Nữ";
			modelTableNhanvien.addRow(new Object[] { obj.getMaNhanvien(), obj.getTenNhanVien(), gt,
					obj.getNgaySinh(), obj.getSoDienThoai() });
		}
	}

	public void XoaHetDuLieuTrenTableModel() {
		DefaultTableModel dm = (DefaultTableModel) tableNhanVien.getModel();
		dm.getDataVector().removeAllElements();
	}

	public void suaThongTinNhanVien(NhanVien nhanVienNew) {
		dsNhanVien.updateNhanVien(nhanVienNew);
		XoaHetDuLieuTrenTableModel();
		themDuLieuNhanVienVaoBang();

	}

	private void timTheoMaNhanVien() {
		if (txtTimNhanvien.getText().equals("")) {
			XoaHetDuLieuTrenTableModel();
			themDuLieuNhanVienVaoBang();
			tableNhanVien.setModel(modelTableNhanvien);
		} else if(!txtTimNhanvien.getText().equals("")) {
			try {
				modelTableNhanvien.setRowCount(0);
				NhanVien nv = dsNhanVien.searchNhanVienTheoMa(txtTimNhanvien.getText().trim());
				if (nv != null) {
					modelTableNhanvien.addRow(new Object[] { nv.getMaNhanvien(), nv.getTenNhanVien(), nv.isGioiTinh(),
							nv.getNgaySinh(), nv.getSoDienThoai() });
				}else
					JOptionPane.showConfirmDialog(null, "Không tìm thấy nhân viên có mã "+txtTimNhanvien.getText(), "Thông báo", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	private void capNhatThongTinMauTin(int n) {
		// TODO Auto-generated method stub
		tableNhanVien.setRowSelectionInterval(n, n);//đưa con trỏ vào dòng dầu tiên của bảng
		lblMauTin.setText(mauTinHienHanh + 1 + "/" + tongSoMauTin);
//		int row  = tableLopHoc.getSelectedRow();
		
	}
}
