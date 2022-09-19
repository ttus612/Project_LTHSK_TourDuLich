package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


public class Frm_TrangChu extends JPanel {
	private JLabel lblHinh;
	private JLabel lblFaceBook;
	private JLabel lblWebSite;
	private JLabel lblDiaChi;
	private JLabel lblSdt;
	private JLabel lblEmail;
	public Frm_TrangChu() {

	//-----------------Tiêu đề--------------------------
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
	
	    JPanel pNorth = new JPanel();
		lblHinh = new JLabel(new ImageIcon("img\\anh_trang_chu_4.jpg"));
		pNorth.add(lblHinh);
		pNorth.setBackground(new Color(129, 238, 150));
		p.add(pNorth, BorderLayout.NORTH);
		
		JPanel pSouth = new JPanel();
		pSouth.add(lblDiaChi = new JLabel("Địa chỉ", new ImageIcon("IMG\\dia_chi.png"), SwingConstants.CENTER));
		pSouth.add(lblSdt = new JLabel("Sđt", new ImageIcon("IMG\\sdt.png"), SwingConstants.CENTER));
		pSouth.add(lblFaceBook = new JLabel("FaceBook", new ImageIcon("IMG\\facebook.png"), SwingConstants.CENTER));
		pSouth.add(lblWebSite = new JLabel("WebSite", new ImageIcon("IMG\\website.png"), SwingConstants.CENTER));
		pSouth.add(lblEmail = new JLabel("E-Mail", new ImageIcon("IMG\\email.png"), SwingConstants.CENTER));
		p.add(pSouth,BorderLayout.SOUTH);

		
		lblDiaChi.setPreferredSize(lblFaceBook.getPreferredSize());
		lblSdt.setPreferredSize(lblFaceBook.getPreferredSize());
		lblWebSite.setPreferredSize(lblFaceBook.getPreferredSize());
		lblEmail.setPreferredSize(lblFaceBook.getPreferredSize());
		
		lblDiaChi.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblSdt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblWebSite.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblEmail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblFaceBook.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//Tolltip
		lblDiaChi.setToolTipText("Địa chỉ");
		lblSdt.setToolTipText("Số điện thoại");
		lblFaceBook.setToolTipText("FaceBook");
		lblWebSite.setToolTipText("Website");
		lblEmail.setToolTipText("E-mail");
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
		lblDiaChi.setComponentPopupMenu(popup);
		lblEmail.setComponentPopupMenu(popup);
		lblFaceBook.setComponentPopupMenu(popup);
		lblHinh.setComponentPopupMenu(popup);
		lblSdt.setComponentPopupMenu(popup);
		lblWebSite.setComponentPopupMenu(popup);
		
		
		
		add(p);
	}

}
