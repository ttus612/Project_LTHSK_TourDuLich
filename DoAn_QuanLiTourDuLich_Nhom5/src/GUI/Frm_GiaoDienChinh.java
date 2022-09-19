package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;

public class Frm_GiaoDienChinh extends JFrame implements ActionListener {
	private JButton btnTrangChu;
	private JButton btnNhanVien;
	private JButton btnTour;
	private JButton btnPhuongTien;
	private JButton btnKhacHang;
	private JButton btnHoaDon;
	private JButton btnDangXuat;
	private JPanel pCenter;
	private JPanel pWest;
	private JPanel pNorth;
	public Frm_GiaoDienChinh() {
		// TODO Auto-generated constructor stub
		this.setTitle("Hệ thống quản lí tour du lịch");
		this.setSize(1350,780);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		
		pNorth = new JPanel();
		pWest = new JPanel(new BorderLayout());
		pCenter = new JPanel();
		
		/*--------------------------------------Phần North--------------------------------------*/
		//phần pNorth
		
		pNorth.setBackground(new Color(42, 175, 45));
		JLabel lblLogo1,lblLogo2;
		ImageIcon imgLogo;
		lblLogo1 = new JLabel(imgLogo = new ImageIcon("img\\logo.png"));
		pNorth.add(lblLogo1, BorderLayout.WEST);
		JLabel lblTen;
		lblTen = new JLabel("Đồ án quản lí tour du lịch - Nhóm 5");
		lblTen.setForeground(Color.WHITE);
		lblTen.setFont(new Font("Time New Roman", Font.BOLD, 40));
		pNorth.add(lblTen);
		lblLogo2 = new JLabel(imgLogo = new ImageIcon("img\\logo.png"));
		pNorth.add(lblLogo2, BorderLayout.EAST);
		add(pNorth, BorderLayout.NORTH);
		/*--------------------------------------Phần West--------------------------------------*/
		//phần pwest
		JPanel pWest_North = new JPanel();
		JPanel pWest_Center = new JPanel(new BorderLayout());
		JPanel pWest_South = new JPanel(new BorderLayout());

		pWest_South.add(btnDangXuat = new JButton("Đăng xuất", new ImageIcon("img\\dang_xuat.png")), BorderLayout.WEST);
		pWest_South.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		pWest_South.setBackground(new Color(129, 238, 150));
		btnDangXuat.setBackground(new Color(129, 238, 150));
		btnDangXuat.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		Font f1 = new Font("Times New Roman ",0,20);
		btnDangXuat.setFont(f1);
		pWest.add(pWest_South, BorderLayout.SOUTH);
		
		//phần pwest-phần center
		//phần pwest-phần center-center
		JPanel pWest_ChucNang = new JPanel(new GridLayout(6,1));
		btnTrangChu = new JButton("Trang chủ", new ImageIcon("img\\trang_chu.png"));
		btnNhanVien = new JButton("Nhân viên", new ImageIcon("img\\nhan_vien.png"));
		btnTour = new JButton("Tour", new ImageIcon("img\\tour.png"));    
		btnPhuongTien= new JButton("Phương tiện", new ImageIcon("img\\PhuongTien.png"));  
		btnKhacHang= new JButton("Khách hàng", new ImageIcon("img\\khach_hang.png"));  
		btnHoaDon= new JButton("Hóa đơn", new ImageIcon("img\\bao_cao.png")); 
		
		
		
		pWest_ChucNang.add(btnTrangChu);
		pWest_ChucNang.add(btnNhanVien);
		pWest_ChucNang.add(btnTour);
		pWest_ChucNang.add(btnPhuongTien);
		pWest_ChucNang.add(btnKhacHang);
		pWest_ChucNang.add(btnHoaDon);
		pWest_Center.add(pWest_ChucNang, BorderLayout.CENTER);
		pWest.add(pWest_Center, BorderLayout.CENTER);
		
		btnTrangChu.setBackground(new Color(129, 238, 150));
		btnNhanVien.setBackground(new Color(129, 238, 150));
		btnTour.setBackground(new Color(129, 238, 150));
		btnPhuongTien.setBackground(new Color(129, 238, 150));
		btnKhacHang.setBackground(new Color(129, 238, 150));
		btnHoaDon.setBackground(new Color(129, 238, 150));
		
		btnTrangChu.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		btnNhanVien.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		btnTour.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		btnPhuongTien.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		btnKhacHang.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		btnHoaDon.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	
	
		pWest_ChucNang.setBackground(new Color(129, 238, 150));
		pWest.setBackground(new Color(129, 238, 150));
		
		Font f = new Font("Times New Roman ",Font.BOLD,20);
		btnTrangChu.setFont(f);
		btnNhanVien.setFont(f);
		btnTour.setFont(f);
		btnPhuongTien.setFont(f);
		btnKhacHang.setFont(f);
		btnHoaDon.setFont(f);
		
		p.add(pWest);
		/*--------------------------------------Phần Center--------------------------------------*/
		pCenter = new JPanel();
		pCenter.add(new Frm_TrangChu());
		p.add(pCenter, BorderLayout.CENTER);
		//add vào thanh kéo giãn
		JSplitPane jspSouth = new JSplitPane(SwingConstants.VERTICAL, pWest, pCenter);
		p.add(jspSouth);
		
		//Tolltip
		btnTrangChu.setToolTipText("Trang chủ");
		btnNhanVien.setToolTipText("Nhân viên");
		btnTour.setToolTipText("Tour");
		btnPhuongTien.setToolTipText("Dịch vụ và phương tiện");
		btnKhacHang.setToolTipText("Khách hàng");
		btnHoaDon.setToolTipText("Báo cáo thống kê");
		btnDangXuat.setToolTipText("Đăng xuất");

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
		pNorth.setComponentPopupMenu(popup);
		pCenter.setComponentPopupMenu(popup);
		btnTrangChu.setComponentPopupMenu(popup);
		btnTour.setComponentPopupMenu(popup);
		btnNhanVien.setComponentPopupMenu(popup);
		btnPhuongTien.setComponentPopupMenu(popup);
		btnKhacHang.setComponentPopupMenu(popup);
		btnHoaDon.setComponentPopupMenu(popup);
		
		//add vào frame
		add(p);
		//Đăng kí lắng nghe
		btnTrangChu.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnTour.addActionListener(this);
		btnPhuongTien.addActionListener(this);
		btnKhacHang.addActionListener(this);
		btnHoaDon.addActionListener(this);
		btnDangXuat.addActionListener(this);
	}
	public static void main(String[] args) {
		new Frm_GiaoDienChinh().setVisible(true);
	}
	private void setPanel(JPanel pn) {
		pCenter.removeAll();
		pCenter.add(pn);
		pCenter.repaint();
		pCenter.revalidate();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnTrangChu)) {
			setPanel(new Frm_TrangChu());
		}
		else if(obj.equals(btnNhanVien)){
			setPanel(new Frm_NhanVien());
		}
		else if(obj.equals(btnPhuongTien)){
			setPanel(new Frm_PhuongTien());
		}
		else if (obj.equals(btnKhacHang)) {
			setPanel(new Frm_KhachHang());
		}
		else if (obj.equals(btnHoaDon)) {
			setPanel(new Frm_HoaDonDatTour());
		}
		else if (obj.equals(btnTour)) {
			setPanel(new Frm_Tour());
		}
		else if (obj.equals(btnDangXuat)) {
			Frm_DangNhap frmDangNhap = new Frm_DangNhap();
			this.setVisible(false);
			frmDangNhap.setVisible(true);
		}
	}
}
