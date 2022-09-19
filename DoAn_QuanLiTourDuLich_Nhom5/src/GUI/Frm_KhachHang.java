package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.swing.SwingConstants;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;

import dao.KhachHang_DAO;
import entity.HoaDon;
import entity.KhachHang;

public class Frm_KhachHang extends JPanel implements ActionListener, MouseInputListener{
	private JLabel lblTitel2;
	private DefaultTableModel modelTableKhachHang;
	private JTable tableKhachHang;
	private JButton btnTim;
	private Container lblTimBangMaKH;
	private JLabel lblTimBangSDT;
	private JLabel lblTimBangTrangThaiThanhToan;
	private JTextField txtTimBangMaKH;
	private JTextField txtTimBangSDT;
	private JComboBox<String> cbbTimBangTrangThaiThanhToan;
	private JButton btnSuaKH;
	private KhachHang_DAO dsKhachHang;
	private ArrayList<KhachHang> listKH;
	private int selectedIndex;
	private Frm_SuaKhachHang home_Sua_KH;
	private JButton btnCapNhat;
	private JButton btnDau;
	private JButton btnSau;
	private JLabel lblMauTin;
	private JButton btnTruoc;
	private JButton btnCuoi;
	private int mauTinHienHanh;
	private int tongSoMauTin;
	private JButton btnXoaRong;
	public Frm_KhachHang() {
		// TODO Auto-generated constructor stub
		this.setPreferredSize(new Dimension(1000, 600));
		this.setLayout(new BorderLayout());
		
		Box b_KH = Box.createVerticalBox();
		Box bb1,bb2, bb3, bb4, bb5, bb6 ;
		bb1 = Box.createHorizontalBox();
		bb2 = Box.createHorizontalBox();
		bb3 = Box.createHorizontalBox();
		bb4 = Box.createHorizontalBox();	
		bb5 = Box.createHorizontalBox();
		bb6 = Box.createHorizontalBox();
		JPanel pTitle2 = new JPanel();
		pTitle2.setBackground(Color.LIGHT_GRAY);
		pTitle2.add(lblTitel2 = new JLabel("Quản lí khách hàng", new ImageIcon("img\\icon_ds.png"), SwingConstants.LEFT), BorderLayout.CENTER);
		lblTitel2.setFont(new Font("Time New Roman", Font.BOLD, 40));
		bb1.add(pTitle2);
		b_KH.add(bb1);
		
		//-----------Phần Center----------------
		
		bb2.add(lblTimBangMaKH = new JLabel("Mã khách hàng:", new ImageIcon("img\\khach_hang.png"), SwingConstants.CENTER));
		lblTimBangMaKH.setFont(new Font("Time New Roman", Font.BOLD, 20));
		bb2.add(Box.createRigidArea(new Dimension(100, 18)));
		
		bb2.add(lblTimBangSDT = new JLabel("Số điện thoại:", new ImageIcon("img\\phone.png"), SwingConstants.CENTER));
		lblTimBangSDT.setFont(new Font("Time New Roman", Font.BOLD, 20));
		bb2.add(Box.createRigidArea(new Dimension(200, 18)));
		
		bb2.add(lblTimBangTrangThaiThanhToan = new JLabel("Trạng thái thanh toán:"));
		lblTimBangTrangThaiThanhToan.setFont(new Font("Time New Roman", Font.BOLD, 20));
		bb2.add(Box.createRigidArea(new Dimension(250, 18)));
		b_KH.add(bb2);
		
		Box bTV = Box.createVerticalBox();
		
		bb3.add(txtTimBangMaKH= new JTextField(10));
		txtTimBangMaKH.setFont(new Font(TOOL_TIP_TEXT_KEY, ALLBITS, 20));
		bb3.add(Box.createRigidArea(new Dimension(100, 20)));
		bb3.add(txtTimBangSDT= new JTextField(10));
		txtTimBangSDT.setFont(new Font(TOOL_TIP_TEXT_KEY, ALLBITS, 20));
		bb3.add(Box.createRigidArea(new Dimension(100, 20)));
		bb3.add(cbbTimBangTrangThaiThanhToan= new JComboBox<String>());
		cbbTimBangTrangThaiThanhToan.addItem("Hiện full");
		cbbTimBangTrangThaiThanhToan.addItem("Đã thanh toán");
		cbbTimBangTrangThaiThanhToan.addItem("Chưa thanh toán");
		bb3.add(Box.createRigidArea(new Dimension(200, 20)));
		bTV.add(bb3);
		bTV.add(Box.createRigidArea(new Dimension(10, 10)));
		
		bb5.add(btnTim = new JButton("Tìm kiếm", new ImageIcon("img\\tim.png")));
		bb5.add(Box.createRigidArea(new Dimension(10, 0)));		
		btnTim.setBackground(new Color(38, 177, 221));
		btnTim.setFont(new Font("Time New Roman", Font.BOLD, 20));
		btnTim.setForeground(Color.WHITE);
		
		bb5.add(btnSuaKH = new JButton("Sửa", new ImageIcon("img\\update.png")));
		bb5.add(Box.createRigidArea(new Dimension(10, 0)));		
		btnSuaKH.setBackground(new Color(129, 238, 150));
		
		bb5.add(btnXoaRong = new JButton("Xóa rỗng", new ImageIcon("img\\xoarong.png")));
		bb5.add(Box.createRigidArea(new Dimension(900, 0)));		
		btnXoaRong.setBackground(new Color(237, 53, 3));
		
		btnSuaKH.setFont(new Font("Time New Roman", Font.BOLD, 20));
		btnSuaKH.setForeground(Color.WHITE);
		
//		bb5.add(btnCapNhat = new JButton("Cập nhật lại danh sách", new ImageIcon("img\\tim.png")));
//		bb5.add(Box.createRigidArea(new Dimension(10, 0)));		
		bTV.add(bb5);
		b_KH.add(bTV);

		b_KH.add(Box.createRigidArea(new Dimension(10, 10)));
		//phần table
		String headerPT[] = {"Mã khách hàng", "Họ tên", "Email","Số điện thoại","Địa chỉ", "Trạng thái thanh toán", ""};
		modelTableKhachHang = new DefaultTableModel(headerPT, 0);
		tableKhachHang = new JTable(modelTableKhachHang);
		tableKhachHang.setDefaultEditor(Object.class, null);
		tableKhachHang.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
		tableKhachHang.getColumnModel().getColumn(6).setCellEditor(new KhachHangTableButtonEditor(new JTextField("Xóa")));
		
		tableKhachHang.setRowHeight(20);
		tableKhachHang.setFont(new Font("Time New Roman", Font.PLAIN, 18));
//		modelTableKhachHang.addRow(new Object[] {"KH01","Võ Nguyễn Thanh Tú","thanhtu@gmail","0123456789", "Bến Tre", "1/1/2018","Đã thanh toán"});
		dsKhachHang = new KhachHang_DAO();
		themDuLieuKhachHangVaoBang();

		add(new JScrollPane(tableKhachHang));
		b_KH.add(bb4);

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
		
		add(pSouth,BorderLayout.SOUTH);
		//		bb6.add(Box.createRigidArea(new Dimension(10, 0)));	
//		b_KH.add(bb6);
		//Tooltip cho nút
		btnTim.setToolTipText("Tìm");
		btnSuaKH.setToolTipText("Sửa thông tin khách hàng");
		//Tooltip cho bảng
		tableKhachHang.getTableHeader().setToolTipText("Bảng quản lí thông tin phương tiện");
		add(b_KH, BorderLayout.NORTH);
		//PopMenu
		JPopupMenu popup = new JPopupMenu();
		JMenuItem openItem = new JMenuItem("Mở",new ImageIcon("img\\open.png"));
		JMenuItem refeshItem = new JMenuItem("Làm mới",new ImageIcon("img\\refesh.png"));
		JMenuItem coppyItem = new JMenuItem("Lưu",new ImageIcon("img\\save.png"));
		JMenuItem pasteItem = new JMenuItem("Dán",new ImageIcon("img\\paste.png"));
		JMenuItem cutItem = new JMenuItem("Cắt",new ImageIcon("img\\cut.png"));
		popup.add(openItem);
		popup.add(refeshItem);
		popup.add(coppyItem);
		popup.add(pasteItem);
		popup.add(cutItem);
	
		btnTim.setComponentPopupMenu(popup);
		txtTimBangMaKH.setComponentPopupMenu(popup);
		txtTimBangSDT.setComponentPopupMenu(popup);
		cbbTimBangTrangThaiThanhToan.setComponentPopupMenu(popup);
		tableKhachHang.setComponentPopupMenu(popup);
		btnDau.addActionListener(this);
		btnTruoc.addActionListener(this);
		btnSau.addActionListener(this);
		btnCuoi.addActionListener(this);
		btnXoaRong.addActionListener(this);
		//--------CẬP NHẬT SỐ LƯỢNG---------------------------------------------
		// Cập nhật thông tin số lượng khi thêm vào mẫu tin hiện hành và các nút duyệt qua các mẫu tin
		mauTinHienHanh = -1;
		tongSoMauTin = tableKhachHang.getRowCount();
		if (tongSoMauTin > 0) {
			mauTinHienHanh = 0; // Khởi tạo là mẫu tin đầu tiên
			capNhatThongTinMauTin(mauTinHienHanh);
		}
		//đăng kí lăng nghe
		tableKhachHang.addMouseListener(this);
		btnSuaKH.addActionListener(this);
		btnTim.addActionListener(this);
		btnCapNhat.addActionListener(this);
//		cbbTimBangTrangThaiThanhToan.addActionListener(this);
	}
	private void capNhatThongTinMauTin(int n) {
		// TODO Auto-generated method stub
		tableKhachHang.setRowSelectionInterval(n, n);//đưa con trỏ vào dòng dầu tiên của bảng
		lblMauTin.setText(mauTinHienHanh + 1 + "/" + tongSoMauTin);
//		int row  = tableLopHoc.getSelectedRow();
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getClickCount() == 2) {
			//JOptionPane.showConfirmDialog(null, "Hiển thị frm thông tin khách hàng");
			Frm_ThongTinKhachHang frmThongTin = new Frm_ThongTinKhachHang();
			frmThongTin.setEditData(listKH.get(tableKhachHang.getSelectedRow()));
			frmThongTin.setVisible(true);
			
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
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnSuaKH)) {
			selectedIndex = tableKhachHang.getSelectedRow();
			if(selectedIndex == -1) {
				JOptionPane.showMessageDialog(btnSuaKH, "Hãy chọn dòng cần sửa !");
			}else {//chọn dòng cần sửa và nhấn nút
				Frm_SuaKhachHang frmSua = new Frm_SuaKhachHang(this, isFocusCycleRoot());
				
				frmSua.setEditData(listKH.get(selectedIndex));
				frmSua.setVisible(true);
			}
		}else if(obj.equals(btnTim)) {
			if (txtTimBangSDT.getText().equals("")) {
				timTheoMaKhachHang();
			}
			else if (txtTimBangMaKH.getText().equals("")) {
				timTheoSoDienThoai();	
			}
				else if (!txtTimBangSDT.getText().equals("") && !txtTimBangMaKH.getText().equals("")) {
				timTheoMaKhachHangVaSDT();
			}
			if(cbbTimBangTrangThaiThanhToan.getSelectedIndex() == 1 || cbbTimBangTrangThaiThanhToan.getSelectedIndex() == 2 ) {
				timTheoTrangThai();
			}
		}else if (obj.equals(btnCapNhat)) {
			XoaHetDuLieuTrenTableModel();
			themDuLieuKhachHangVaoBang();
			tableKhachHang.setModel(modelTableKhachHang);
		}else if (obj.equals(btnXoaRong)) {
			txtTimBangMaKH.setText("");
			txtTimBangSDT.setText("");
			cbbTimBangTrangThaiThanhToan.setSelectedIndex(0);
		}
//Vì tìm theo chức năng tìm kiếm nên không cần đăng kí sự kiện cbb
//		else  {
//			String str = (String)cbbTimBangTrangThaiThanhToan.getSelectedItem();
//			String str2 = (String)cbbTimBangTrangThaiThanhToan.getItemAt(0);
//			if (str != null && str.trim().length() > 0 && str != str2 ) {
//				try {
//					modelTableKhachHang.setRowCount(0);			
//						Boolean inDexComBoBox = null ;
//						if (cbbTimBangTrangThaiThanhToan.getSelectedIndex() == 1) {
//							inDexComBoBox = true;
//						}else if (cbbTimBangTrangThaiThanhToan.getSelectedIndex() == 2) {
//							inDexComBoBox = false;
//						}
//						ResultSet kh = dsKhachHang.searchKhachHangTheoTrangThai(inDexComBoBox);
//					    while (kh.next()) { 
//					    	modelTableKhachHang.addRow(new Object[] {kh.getString("maKhachHang"), kh.getString("tenKhachHang"), kh.getString("email"), kh.getString("soDienThoai"), kh.getString("diaChi"),kh.getBoolean("trangThai")});
//					    }
//				} catch (Exception e2) {
//					// TODO: handle exception
//					e2.printStackTrace();
//				}	
//			}else {
//				XoaHetDuLieuTrenTableModel();
//				themDuLieuKhachHangVaoBang();
//				tableKhachHang.setModel(modelTableKhachHang);
//			}
//		}
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

	private void themDuLieuKhachHangVaoBang() {
		listKH = dsKhachHang.getAllKhachHang();
		for (KhachHang obj : listKH) {
			modelTableKhachHang.addRow(new Object[] {obj.getMaKhachHang(), obj.getTenKhachHang(), obj.getEmail(), obj.getSoDienThoai(), obj.getDiaChi(), obj.getHoaDon().getTrangThai()});
		}
	}
	public void XoaHetDuLieuTrenTableModel() {
		DefaultTableModel dm = (DefaultTableModel) tableKhachHang.getModel();
		dm.getDataVector().removeAllElements();
	}
	private void timTheoMaKhachHang() {
		if (txtTimBangMaKH.getText().equals("")) {
			XoaHetDuLieuTrenTableModel();
			themDuLieuKhachHangVaoBang();
			tableKhachHang.setModel(modelTableKhachHang);
		}else {
			try {
				modelTableKhachHang.setRowCount(0);
				KhachHang kh = dsKhachHang.searchKhachHangTheoMa(txtTimBangMaKH.getText().trim());
				if (kh != null) {
					modelTableKhachHang.addRow(new Object[] {kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getEmail(), kh.getSoDienThoai(), kh.getDiaChi(), kh.getHoaDon().getTrangThai()});
				}
				cbbTimBangTrangThaiThanhToan.setSelectedIndex(0);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}
	private void timTheoSoDienThoai() {
		if (txtTimBangSDT.getText().equals("")) {
			XoaHetDuLieuTrenTableModel();
			themDuLieuKhachHangVaoBang();
			tableKhachHang.setModel(modelTableKhachHang);
		}else {
			try {
				modelTableKhachHang.setRowCount(0);
				KhachHang kh = dsKhachHang.searchKhachHangTheoSDT(txtTimBangSDT.getText().trim());
				if (kh != null) {
				}
				cbbTimBangTrangThaiThanhToan.setSelectedIndex(0);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}	
	private void timTheoMaKhachHangVaSDT() {
		if (txtTimBangSDT.getText().equals("") && txtTimBangMaKH.getText().equals("") ) {
			XoaHetDuLieuTrenTableModel();
			themDuLieuKhachHangVaoBang();
			tableKhachHang.setModel(modelTableKhachHang);
		}else {
			try {
				modelTableKhachHang.setRowCount(0);
				KhachHang kh = dsKhachHang.searchKhachHangTheoMaKhachHangVaSDT(txtTimBangMaKH.getText().trim(), txtTimBangSDT.getText().trim());
				if (kh != null) {
					modelTableKhachHang.addRow(new Object[] {kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getEmail(), kh.getSoDienThoai(), kh.getDiaChi(), kh.getHoaDon().getTrangThai()});
				}
				cbbTimBangTrangThaiThanhToan.setSelectedIndex(0);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	private void timTheoTrangThai() {
		if (txtTimBangSDT.getText().equals("") && txtTimBangMaKH.getText().equals("") && cbbTimBangTrangThaiThanhToan.getSelectedIndex() == 0 ) {
			XoaHetDuLieuTrenTableModel();
			themDuLieuKhachHangVaoBang();
			tableKhachHang.setModel(modelTableKhachHang);
		}else {
			try {
				modelTableKhachHang.setRowCount(0);
		
					Boolean inDexComBoBox = null ;
					if (cbbTimBangTrangThaiThanhToan.getSelectedIndex() == 1) {
						inDexComBoBox = true;
					}else if (cbbTimBangTrangThaiThanhToan.getSelectedIndex() == 2) {
						inDexComBoBox = false;
					}
					ResultSet kh = dsKhachHang.searchKhachHangTheoTrangThai(inDexComBoBox);
				    while (kh.next()) { 
				    	
				    	modelTableKhachHang.addRow(new Object[] {kh.getString("maKhachHang"), kh.getString("tenKhachHang"), kh.getString("email"), kh.getString("soDienThoai"), kh.getString("diaChi"),getTrangThaiThanhToan(kh.getBoolean("trangThai"))});
				    }
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	public void addKH(KhachHang kh) {
		listKH.add(kh);
		modelTableKhachHang.setRowCount(0);
		for (KhachHang khachHang : listKH) {
			modelTableKhachHang.addRow(new Object[] {khachHang.getMaKhachHang(), khachHang.getTenKhachHang(), khachHang.getEmail(), khachHang.getSoDienThoai(), khachHang.getDiaChi()});
		}
	}
	public void suaThongTinKhachHang(KhachHang KhachHangNew) {
		dsKhachHang.updateLopHoc(KhachHangNew);
		XoaHetDuLieuTrenTableModel();
		themDuLieuKhachHangVaoBang();
		
	}
	private String getTrangThaiThanhToan(boolean tt) {
		if(tt == true)
			return "Đã thanh toán";
		return "Chưa thanh toán";
	}
}
