package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.event.MouseInputListener;

import javax.swing.table.DefaultTableModel;

import GUI.ButtonRenderer;
import connectDB.ConnectDB;
import dao.PhuongTien_DAO;
import entity.KhachHang;
import entity.PhuongTien;



public class Frm_PhuongTien extends JPanel implements ActionListener, MouseInputListener {
	private JLabel lblTitel2;
	private JLabel lblTimPT;
	private JButton btnTimPhuongTien;
	private JButton btnThemPhuongTien;
	private DefaultTableModel modelTablePhuongTien;
	private JTable tablePhuongTien;
	private JTextField txtPT;
	private JButton btnSuaPhuongTien;
	private PhuongTien_DAO dsPhuongTien;
	private JButton btnCapNhat;
	private JButton btnDau;
	private JButton btnSau;
	private JLabel lblMauTin;
	private JButton btnTruoc;
	private JButton btnCuoi;
	private int mauTinHienHanh;
	private int tongSoMauTin;
	private int selectedIndex;
	private ArrayList<PhuongTien> listPT;


	public Frm_PhuongTien() {
		// TODO Auto-generated constructor stub
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setPreferredSize(new Dimension(1000, 600));
		this.setLayout(new BorderLayout());
		
		Box b_PT = Box.createVerticalBox();
		Box bb1,bb2, bb3, bb4 ;
		bb1 = Box.createHorizontalBox();
		bb2 = Box.createHorizontalBox();
		bb3 = Box.createHorizontalBox();
		bb4 = Box.createHorizontalBox();	
		
		JPanel pTitle2 = new JPanel();
		pTitle2.setBackground(Color.LIGHT_GRAY);
		pTitle2.add(lblTitel2 = new JLabel("Qu???n l?? ph????ng ti???n", new ImageIcon("img\\icon_ds.png"), SwingConstants.LEFT), BorderLayout.CENTER);
		lblTitel2.setFont(new Font("Time New Roman", Font.BOLD, 40));
		bb1.add(pTitle2);
		b_PT.add(bb1);
		
		//-----------Ph???n Center----------------

		bb2.add(lblTimPT = new JLabel("M?? ph????ng ti???n:", new ImageIcon("img\\PhuongTien.png"), SwingConstants.CENTER));
		lblTimPT.setFont(new Font("Time New Roman", Font.BOLD, 20));
		bb2.add(Box.createRigidArea(new Dimension(1000, 0)));
		b_PT.add(bb2);

		bb3.add(txtPT= new JTextField(10));
		
		bb3.add(Box.createRigidArea(new Dimension(10, 10)));
		bb3.add(btnTimPhuongTien = new JButton("T??m ki???m", new ImageIcon("img\\tim.png")));
		bb3.add(Box.createRigidArea(new Dimension(10, 0)));
		bb3.add(btnThemPhuongTien = new JButton("Th??m", new ImageIcon("img\\them.png")));
		bb3.add(Box.createRigidArea(new Dimension(10, 0)));
		bb3.add(btnSuaPhuongTien = new JButton("S???a", new ImageIcon("img\\update.png")));
		bb3.add(Box.createRigidArea(new Dimension(400, 0)));
		
		btnTimPhuongTien.setBackground(new Color(38, 177, 221));
		btnTimPhuongTien.setFont(new Font("Time New Roman", Font.BOLD, 20));
		btnTimPhuongTien.setForeground(Color.WHITE);
	
		btnThemPhuongTien.setBackground(new Color(42, 175, 45));
		btnThemPhuongTien.setFont(new Font("Time New Roman", Font.BOLD, 20));
		btnThemPhuongTien.setForeground(Color.WHITE);
		
		btnSuaPhuongTien.setBackground(new Color(129, 238, 150));
		btnSuaPhuongTien.setFont(new Font("Time New Roman", Font.BOLD, 20));
		btnSuaPhuongTien.setForeground(Color.WHITE);
		
		b_PT.add(bb3);
		b_PT.add(Box.createRigidArea(new Dimension(10, 10)));

		//ph???n table
		String headerPT[] = {"M?? ph????ng ti???n", "Lo???i xe", "Bi???n s??? xe","Ghi ch??",""};
		modelTablePhuongTien = new DefaultTableModel(headerPT, 0);
		tablePhuongTien = new JTable(modelTablePhuongTien);
		tablePhuongTien = new JTable(modelTablePhuongTien);
		tablePhuongTien.setDefaultEditor(Object.class, null);
		tablePhuongTien.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
		tablePhuongTien.getColumnModel().getColumn(4).setCellEditor(new PhuongTienTableButtonEditor(new JTextField("X??a")));
		
		tablePhuongTien.setRowHeight(20);
		tablePhuongTien.setFont(new Font("Time New Roman", Font.PLAIN, 18));
//		modelTablePhuongTien.addRow(new Object[] {"PT_01","Xe 7 ch???","71x-1212-213","Kh??ng"});
		dsPhuongTien = new PhuongTien_DAO();
		themDuLieuPhuongTienVaoBang();
		
		add(new JScrollPane(tablePhuongTien));
		b_PT.add(bb4);
		add(b_PT, BorderLayout.NORTH);
		//Tooltip cho n??t
		btnTimPhuongTien.setToolTipText("T??m ki???m ph????ng ti???n");
		btnThemPhuongTien.setToolTipText("Th??m ph????ng ti???n");
		btnSuaPhuongTien.setToolTipText("S???a ph????ng ti???n");
		//Tooltip cho b???ng
		tablePhuongTien.getTableHeader().setToolTipText("B???ng qu???n l?? th??ng tin ph????ng ti???n");
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
	
		btnTimPhuongTien.setComponentPopupMenu(popup);
		btnThemPhuongTien.setComponentPopupMenu(popup);
		txtPT.setComponentPopupMenu(popup);
		txtPT.setFont(new Font(TOOL_TIP_TEXT_KEY, ALLBITS, 20));
		
		tablePhuongTien.setComponentPopupMenu(popup);
		
		JPanel pSouth = new JPanel();
		
		pSouth.setLayout(new BoxLayout(pSouth, BoxLayout.X_AXIS));
		pSouth.add(btnCapNhat = new JButton("C???p nh???t l???i danh s??ch",new ImageIcon("img\\refesh.png")));
		btnCapNhat.setBackground(new Color(255, 215, 0));
		pSouth.add(Box.createRigidArea(new Dimension(200, 0)));
		pSouth.add(btnDau = new JButton(new ImageIcon("img\\icon_dau.png")));
		pSouth.add(btnSau = new JButton(new ImageIcon("img\\icon_sau.png")));
		pSouth.add(lblMauTin = new JLabel());
		pSouth.add(btnTruoc = new JButton(new ImageIcon("img\\icon_truoc.png")));
		pSouth.add(btnCuoi = new JButton(new ImageIcon("img\\icon_cuoi.png")));
		add(pSouth, BorderLayout.SOUTH);
		//--------C???P NH???T S??? L?????NG---------------------------------------------
		// C???p nh???t th??ng tin s??? l?????ng khi th??m v??o m???u tin hi???n h??nh v?? c??c n??t duy???t qua c??c m???u tin
		mauTinHienHanh = -1;
		tongSoMauTin = tablePhuongTien.getRowCount();
		if (tongSoMauTin > 0) {
			mauTinHienHanh = 0; // Kh???i t???o l?? m???u tin ?????u ti??n
			capNhatThongTinMauTin(mauTinHienHanh);
		}
		//????ng ki l???ng nghe
		tablePhuongTien.addMouseListener(this);
		btnSuaPhuongTien.addActionListener(this);
		btnThemPhuongTien.addActionListener(this);
		btnTimPhuongTien.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnDau.addActionListener(this);
		btnTruoc.addActionListener(this);
		btnSau.addActionListener(this);
		btnCuoi.addActionListener(this);

	}
	private void capNhatThongTinMauTin(int n) {
		// TODO Auto-generated method stub
		tablePhuongTien.setRowSelectionInterval(n, n);//????a con tr??? v??o d??ng d???u ti??n c???a b???ng
		lblMauTin.setText(mauTinHienHanh + 1 + "/" + tongSoMauTin);
//		int row  = tableLopHoc.getSelectedRow();
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getClickCount() == 2) {
			//JOptionPane.showConfirmDialog(null, "Hi???n th??? frm th??ng tin kh??ch h??ng");
		
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
		if(obj.equals(btnSuaPhuongTien)) {
			selectedIndex = tablePhuongTien.getSelectedRow();	
			if(selectedIndex == -1) {
				JOptionPane.showMessageDialog(btnSuaPhuongTien, "H??y ch???n d??ng c???n s???a !");
			}else {//ch???n d??ng c???n s???a v?? nh???n n??t
				Frm_SuaPhuongTien frmSua = new Frm_SuaPhuongTien(this, isFocusCycleRoot());
				frmSua.setEditData(listPT.get(selectedIndex));
				frmSua.setVisible(true);
			}
		}
		else if(obj.equals(btnThemPhuongTien)) {
			Frm_ThemPhuongTien frmThem = new Frm_ThemPhuongTien();
			frmThem.setVisible(true);
			frmThem.xoaRongTextfields();
		}else if (obj.equals(btnTimPhuongTien)) {
			timTheoMaPhuongTien();
		}else if (obj.equals(btnCapNhat)) {
			XoaAllTable();
			themDuLieuPhuongTienVaoBang();
			tablePhuongTien.setModel(modelTablePhuongTien);
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
	private void timTheoMaPhuongTien() {
		if (txtPT.getText().equals("")) {
			XoaAllTable();;
			themDuLieuPhuongTienVaoBang();
			tablePhuongTien.setModel(modelTablePhuongTien);
		}else {
			try {
				modelTablePhuongTien.setRowCount(0);
				PhuongTien pt = dsPhuongTien.getPhuongTienTheoMa(txtPT.getText().trim());
				if (pt != null) {
					modelTablePhuongTien.addRow(new Object[] {pt.getMaPhuongTien(), pt.getLoaiPhuongTien(), pt.getBienSoXe(), pt.getGhiChu()});
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	private void XoaAllTable() {
		DefaultTableModel dtm = (DefaultTableModel) tablePhuongTien.getModel();
		dtm.getDataVector().removeAllElements();
	}
	
	
	private void themDuLieuPhuongTienVaoBang() {
		listPT = dsPhuongTien.getAllPhuongTien();
		for (PhuongTien obj : listPT) {
			modelTablePhuongTien.addRow(new Object[] {obj.getMaPhuongTien(), obj.getLoaiPhuongTien(), obj.getBienSoXe(), obj.getGhiChu()});
		}
	}
	public void themPhuongTien(PhuongTien pt) throws SQLException {
		if(dsPhuongTien.create(pt)){
			themDuLieuPhuongTienVaoBang();
		}
		
	}
	public void suaPhuongTien(PhuongTien pt)  {
		dsPhuongTien.updatePhuongTien(pt);
		XoaAllTable();
		themDuLieuPhuongTienVaoBang();

	}
}
