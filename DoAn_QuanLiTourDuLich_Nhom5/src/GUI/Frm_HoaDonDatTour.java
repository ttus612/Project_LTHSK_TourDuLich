package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.lang.reflect.Array;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.HoaDon_DAO;
import entity.HoaDon;
import entity.HoaDon;

public class Frm_HoaDonDatTour extends JPanel implements ActionListener, MouseListener{
	private JLabel lblTitel2;
	private DefaultTableModel modelTableHD;
	private JTable tableHD;
	private JButton btnTim;
	private Container lblTimTheoMaHD;
	private JTextField txtTimTheoMaHD;
	private JLabel lblKQTongTien;
	private JButton btnTongTien;
	private JButton btnSuaHD;
	private HoaDon_DAO dsHoaDon;
	private ArrayList<HoaDon> listHD;
	private JButton btnCapNhat;
	private JButton btnDau;
	private JButton btnSau;
	private JLabel lblMauTin;
	private JButton btnTruoc;
	private JButton btnCuoi;
	private int mauTinHienHanh;
	private int tongSoMauTin;

	
	public Frm_HoaDonDatTour() {
		// TODO Auto-generated constructor stub
		this.setPreferredSize(new Dimension(1000, 600));
		this.setLayout(new BorderLayout());
		
		Box b_KH = Box.createVerticalBox();
		Box bb1,bb2, bb3, bb4 ;
		bb1 = Box.createHorizontalBox();
		bb2 = Box.createHorizontalBox();
		bb3 = Box.createHorizontalBox();
		bb4 = Box.createHorizontalBox();	
			
		JPanel pTitle2 = new JPanel();
		pTitle2.setBackground(Color.LIGHT_GRAY);
		pTitle2.add(lblTitel2 = new JLabel("H??a ????n", new ImageIcon("img\\icon_ds.png"), SwingConstants.LEFT), BorderLayout.CENTER);
		lblTitel2.setFont(new Font("Time New Roman", Font.BOLD, 40));
		bb1.add(pTitle2);
		b_KH.add(bb1);
		
		//-----------Ph???n Center----------------
		
		bb2.add(lblTimTheoMaHD = new JLabel("T??m ki???m theo m?? h??a ????n:", new ImageIcon("img\\calender.png"), SwingConstants.LEFT));
		lblTimTheoMaHD.setFont(new Font("Time New Roman", Font.BOLD, 20));
		bb2.add(Box.createRigidArea(new Dimension(1000, 0)));
		
		b_KH.add(bb2);

		bb3.add(txtTimTheoMaHD= new JTextField(10));
		txtTimTheoMaHD.setFont(new Font(TOOL_TIP_TEXT_KEY, ALLBITS, 20));
		bb3.add(Box.createRigidArea(new Dimension(40, 0)));
		bb3.add(btnTim = new JButton("T??m ki???m", new ImageIcon("img\\tim.png")));
		bb3.add(Box.createRigidArea(new Dimension(40, 0)));
		bb3.add(btnSuaHD = new JButton("S???a", new ImageIcon("img\\update.png")));
		bb3.add(Box.createRigidArea(new Dimension(400, 0)));
		
		btnTim.setBackground(new Color(38, 177, 221));
		btnTim.setFont(new Font("Time New Roman", Font.BOLD, 20));
		btnTim.setForeground(Color.WHITE);
		
		btnSuaHD.setBackground(new Color(129, 238, 150));
		btnSuaHD.setFont(new Font("Time New Roman", Font.BOLD, 20));
		btnSuaHD.setForeground(Color.WHITE);
		b_KH.add(bb3);

		b_KH.add(Box.createRigidArea(new Dimension(10, 10)));
		//ph???n table
		String headerPT[] = {"M?? h??a ????n", "M?? Tour", "M?? kh??ch h??ng", "M?? nh??n vi??n", "Ng??y ?????t","S??? l?????ng ng?????i l???n","S??? l?????ng tr??? con", "Ph????ng th???c thanh to??n", "Tr???ng th??i","T???ng ti???n",""};
		modelTableHD = new DefaultTableModel(headerPT, 0);
		tableHD = new JTable(modelTableHD);
		tableHD.setRowHeight(20);
		tableHD.setFont(new Font("Time New Roman", ALLBITS, 18));
		tableHD.setDefaultEditor(Object.class, null);
		tableHD.getColumnModel().getColumn(10).setCellRenderer(new ButtonRenderer());
		tableHD.getColumnModel().getColumn(10).setCellEditor(new HoaDonTableButtonEditor(new JTextField("X??a")));
		
//		modelTableHD.addRow(new Object[] {"HD3", "??er", "3/1/2001","??ef", "??2er", 123,123, 234});
		add(new JScrollPane(tableHD));
		dsHoaDon = new HoaDon_DAO();
		themDuLieuHoaDonVaoBang();
		b_KH.add(bb4);
		add(b_KH, BorderLayout.NORTH);
		
		JPanel pSouth = new JPanel();	
		pSouth.add(btnTongTien = new JButton("T???ng doanh thu", new ImageIcon("img\\next.png")));
		btnTongTien.setFont(new Font("Time New Roman", Font.BOLD, 20));
		btnTongTien.setBackground(new Color(255, 180, 110));
		pSouth.add(lblKQTongTien = new JLabel("..."));
	  	lblKQTongTien.setFont(new Font("Time New Roman", Font.BOLD, 30)); 
  	
	  	add(pSouth, BorderLayout.SOUTH);
		//Tooltip cho n??t
		btnTim.setToolTipText("T??m");
		//Tooltip cho b???ng
		tableHD.getTableHeader().setToolTipText("B???ng qu???n l?? th??ng tin b??o c??o");
		tableHD.setDefaultEditor(Object.class, null);
		//PopMenu
		JPopupMenu popup = new JPopupMenu();
		JMenuItem openItem = new JMenuItem("M???",new ImageIcon("img\\open.png"));
		JMenuItem refeshItem = new JMenuItem("L??m m???i",new ImageIcon("img\\refesh.png"));
		JMenuItem coppyItem = new JMenuItem("L??u",new ImageIcon("img\\save.png"));
		JMenuItem pasteItem = new JMenuItem("D??n",new ImageIcon("img\\paste.png"));
		JMenuItem cutItem = new JMenuItem("C???t",new ImageIcon("img\\cut.png"));
		popup.add(openItem);
		popup.add(refeshItem);
		popup.add(coppyItem);
		popup.add(pasteItem);
		popup.add(cutItem);
	
		btnTim.setComponentPopupMenu(popup);
		btnTongTien.setComponentPopupMenu(popup);
		txtTimTheoMaHD.setComponentPopupMenu(popup);
		tableHD.setComponentPopupMenu(popup);
		
		//????NG K?? L???NG NGHE
		btnTim.addActionListener(this);
		btnTongTien.addActionListener(this);
		btnSuaHD.addActionListener(this);
		tableHD.addMouseListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnTongTien)) {
			tongTien();		
		}
		if (obj.equals(btnSuaHD)) {
			ArrayList<HoaDon> listHD = dsHoaDon.getAllHoaDon();
			Frm_SuaHoaDonDatTour frm_SuaHD = new Frm_SuaHoaDonDatTour(this, isFocusCycleRoot());
			frm_SuaHD.setEditData(listHD.get(tableHD.getSelectedRow()));
			frm_SuaHD.setVisible(true);
		} else if (obj.equals(btnTim)) {
			timTheoMaHoaDon();

		} else if (obj.equals(btnCapNhat)) {
			XoaHetDuLieuTrenTableModel();
			themDuLieuHoaDonVaoBang();
			tableHD.setModel(modelTableHD);
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
	public void tongTien(){
		 Double total = 0.0;
		    for (int i = 0; i < tableHD.getRowCount(); i++){
		        Double amount = (Double)tableHD.getValueAt(i, 9);
		        total += amount;
		    }
			lblKQTongTien.setText(total+"VN??");
	}
//	public void tongHD(){
//		 int tong = 0;
//		    for (int i = 0; i < tableHD.getRowCount(); i++){
////		        Integer soHD = Integer.parseInt((String) tableBaoCao.getIn);
////		        tong += soHD;
//		    }
//			lblKQTongTien.setText(tong+"");
//	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getClickCount() == 2) {
			try {
				ArrayList<HoaDon> lst = dsHoaDon.getAllHoaDon();
				Frm_ThongTinHoaDonDatTour thongTin = new Frm_ThongTinHoaDonDatTour();
				thongTin.setEditData(lst.get(tableHD.getSelectedRow()));
				thongTin.setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
	private void themDuLieuHoaDonVaoBang() {
		ArrayList<HoaDon> listHD = dsHoaDon.getAllHoaDon();
		for (HoaDon obj : listHD) {
			modelTableHD.addRow(new Object[] {obj.getMaHoaDon(), obj.getTour().getMaTour(), obj.getKhachHang().getMaKhachHang(), obj.getNhanVien().getMaNhanvien(), obj.getNgayDat(), obj.getSoLuongNguoiLon(), obj.getSoLuongTreEm(), obj.getPhuongThucThanhToan(), obj.isTrangThai(), obj.getTongTien()});
		}
	}
	public void XoaHetDuLieuTrenTableModel() {
		DefaultTableModel dm = (DefaultTableModel) tableHD.getModel();
		dm.getDataVector().removeAllElements();
	}

	public void suaThongTinHoaDon(HoaDon hoaDonNew) {
		dsHoaDon.updateHoaDon(hoaDonNew);
		XoaHetDuLieuTrenTableModel();
		themDuLieuHoaDonVaoBang();
	}
	private void timTheoMaHoaDon() {
		if (txtTimTheoMaHD.getText().equals("")) {
			XoaHetDuLieuTrenTableModel();
			themDuLieuHoaDonVaoBang();
			tableHD.setModel(modelTableHD);
		} 
		if(!txtTimTheoMaHD.getText().equals("")) {
			try {
				modelTableHD.setRowCount(0);
				HoaDon hd = dsHoaDon.searchHoaDonTheoMa(txtTimTheoMaHD.getText().trim());
				if (hd != null) {
					modelTableHD.addRow(new Object[] {hd.getMaHoaDon(), hd.getTour().getMaTour(), hd.getKhachHang().getMaKhachHang(), hd.getNhanVien().getMaNhanvien(), hd.getNgayDat(), hd.getSoLuongNguoiLon(), hd.getSoLuongTreEm(), 
							hd.getPhuongThucThanhToan(), hd.isTrangThai(), hd.getTongTien() });
				}else
					JOptionPane.showConfirmDialog(null, "Kh??ng t??m th???y h??a ????n c?? m?? "+txtTimTheoMaHD.getText(), "Th??ng b??o", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	private void capNhatThongTinMauTin(int n) {
		// TODO Auto-generated method stub
		tableHD.setRowSelectionInterval(n, n);//????a con tr??? v??o d??ng d???u ti??n c???a b???ng
		lblMauTin.setText(mauTinHienHanh + 1 + "/" + tongSoMauTin);
//		int row  = tableLopHoc.getSelectedRow();
		
	}
}
