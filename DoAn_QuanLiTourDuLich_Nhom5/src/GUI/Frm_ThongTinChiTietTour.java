package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import entity.PhuongTien;
import entity.Tour;

public class Frm_ThongTinChiTietTour extends JFrame implements ActionListener {
	private JLabel lblMaTour;
	private JLabel lblNgayDi;
	private JLabel lblTenTour;
	private JLabel lblThoiGian;
	private JLabel lblPhuongTien;
	private JLabel lblGiaTour;
	private JLabel lblSoLuong;
	private JLabel SLDKy;
	private JLabel SLQuyDinh;
	private JButton btnDong;
	private JButton btnDatTour;
	private JLabel lblDiemDen;
	private JLabel lblDiemXuatPhat;
	private Frm_Tour frm_Tour;
	private DecimalFormat df;
	private JTextArea chiTietTour;
	private JTextArea luuY;
	private String moTa;
	private int slQuyDinh;
	public Frm_ThongTinChiTietTour() {
		frm_Tour = new Frm_Tour();
		
		setTitle("Thông tin chi tiết tour");
		setSize(850, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		
		df = new DecimalFormat("#,##0.00");
		
		
		//----------Titel & img-----------//
		JPanel pImg = new JPanel();	
		pImg.setLayout(new BoxLayout(pImg, BoxLayout.Y_AXIS));
		JLabel lblimg;
		pImg.add(lblimg = new JLabel());
		lblimg.setSize(850, 150);
		setPicture(lblimg, "img\\NhaTrang.png");
		add(pImg, BorderLayout.NORTH);
		
		//-------------Thông tin tour-------------//
		JPanel pThongTin = new JPanel();
		pThongTin.setLayout(new GridLayout(5, 4));
		pThongTin.setBackground(Color.WHITE);
		pThongTin.setBorder(BorderFactory.createTitledBorder("Thông tin chi tiết tour"));
		JLabel lbl1;
		pThongTin.add(lbl1 = new JLabel("Mã Tour: "));
		lbl1.setFont(new Font(getName(), Font.BOLD, 18));
		pThongTin.add(lblMaTour = new JLabel("NT_01"));
		
		JLabel lbl2;
		pThongTin.add(lbl2 = new JLabel("Ngày khởi hành: "));
		lbl2.setFont(new Font(getName(), Font.BOLD, 18));
		pThongTin.add(lblNgayDi = new JLabel("12/09/2022"));
		
		JLabel lbl3;
		pThongTin.add(lbl3 = new JLabel("Tên Tour: "));
		lbl3.setFont(new Font(getName(), Font.BOLD, 18));
		pThongTin.add(lblTenTour = new JLabel("TP.CHM-Nha Trang"));
		
		JLabel lbl4;
		pThongTin.add(lbl4 = new JLabel("Thời gian: "));
		lbl4.setFont(new Font(getName(), Font.BOLD, 18));
		pThongTin.add(lblThoiGian = new JLabel("3N2D"));
		
		JLabel lbl8;
		pThongTin.add(lbl8 = new JLabel("Điểm xuất phát: "));
		lbl8.setFont(new Font(getName(), Font.BOLD, 18));
		pThongTin.add(lblDiemXuatPhat = new JLabel("Nha Trang"));
		

		
		JLabel lbl5;
		pThongTin.add(lbl5 = new JLabel("Phương tiện: "));
		lbl5.setFont(new Font(getName(), Font.BOLD, 18));
		pThongTin.add(lblPhuongTien = new JLabel("Máy bay"));
		
		
		JLabel lbl9;
		pThongTin.add(lbl9 = new JLabel("Điểm đến: "));
		lbl9.setFont(new Font(getName(), Font.BOLD, 18));
		pThongTin.add(lblDiemDen = new JLabel("Nha Trang"));
		
		JLabel lbl6;
		pThongTin.add(lbl6 = new JLabel("Giá Tour: "));
		lbl6.setFont(new Font(getName(), Font.BOLD, 18));
		pThongTin.add(lblGiaTour = new JLabel("2,300,000"));
		lblGiaTour.setForeground(new Color(224, 37, 37));
		lblGiaTour.setFont(new Font(getName(), Font.BOLD, 25));
		
		JLabel lbl7;
		pThongTin.add(lbl7 = new JLabel("Số lượng: "));
		lbl7.setFont(new Font(getName(), Font.BOLD, 18));
		pThongTin.add(lblSoLuong = new JLabel());
		
		
		
		setFontLable();
		
		add(pThongTin, BorderLayout.CENTER);
		
		//-----------TabbedPanel------------//
		JPanel ptabbed = new JPanel();
		ptabbed.setLayout(new BorderLayout());
		JTabbedPane tabbed = new JTabbedPane();
		chiTietTour = new JTextArea();
		
		luuY = new JTextArea();
		luuY.setText(docFile());
		JPanel panel1 = createJPanel(chiTietTour);
        JPanel panel2 = createJPanel(luuY);
        
        tabbed.addTab("Chi tiết tour", null, panel1, "Chi tiết tour");
        tabbed.addTab("Dịch vụ kèm theo", null, panel2, "Dịch vụ kèm theo");
        ptabbed.add(tabbed, BorderLayout.CENTER);
        
        JPanel p = new JPanel();
        p.add(btnDatTour = new JButton("Đặt tour"));
        btnDatTour.setForeground(Color.WHITE);
        btnDatTour.setBackground(new Color(42, 175, 45));
        btnDatTour.setFont(new Font("Time New Roman", Font.BOLD,18));
        btnDatTour.setToolTipText("Đặt tour");
        
        p.add(btnDong = new JButton("Đóng", new ImageIcon("img\\close.png")));
        btnDong.setForeground(Color.WHITE);
        btnDong.setBackground(new Color(224, 37, 37));
        btnDong.setFont(new Font("Time New Roman", Font.BOLD,18));
        btnDong.setToolTipText("Đóng");
        
        btnDatTour.setPreferredSize(btnDong.getPreferredSize());
        ptabbed.add(p,BorderLayout.SOUTH);
       
        add(ptabbed, BorderLayout.SOUTH);
        
        //----------Sự kiện--------------//
        btnDong.addActionListener(this);
        btnDatTour.addActionListener(this);
	}
	public  void setPicture(  JLabel label ,String filename ){
        try {
          BufferedImage image = ImageIO.read(new File(filename));

          ImageIcon icon = new ImageIcon(image.getScaledInstance(label.getWidth(), label.getHeight(), BufferedImage.SCALE_SMOOTH));
          label.setIcon(icon);
      } catch (IOException ex) {
          Logger.getLogger(Frm_ThongTinChiTietTour.class.getName()).log(Level.SEVERE, null, ex);
      }

  }
	private JPanel createJPanel(JTextArea textArea) {
        JPanel panel = new JPanel(new GridLayout(1, 1));
        panel.setPreferredSize(new Dimension(800, 250));
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        panel.add(new JScrollPane(textArea));
        return panel;
    }
	private void setFontLable() {
		lblDiemDen.setFont(new Font("Time new roman", Font.PLAIN, 18));
		lblMaTour.setFont(new Font("Time new roman", Font.PLAIN, 18));
		lblNgayDi.setFont(new Font("Time new roman", Font.PLAIN, 18));
		lblPhuongTien.setFont(new Font("Time new roman", Font.PLAIN, 18));
		lblSoLuong.setFont(new Font("Time new roman", Font.PLAIN, 18));
		lblTenTour.setFont(new Font("Time new roman", Font.PLAIN, 18));
		lblThoiGian.setFont(new Font("Time new roman", Font.PLAIN, 18));
		lblDiemXuatPhat.setFont(new Font("Time new roman", Font.PLAIN, 18));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnDong)) {
			this.dispose();
		}
		else if(e.getSource().equals(btnDatTour)){
			Frm_DatTour frm_DatTour = new Frm_DatTour();
			frm_DatTour.setData(lblMaTour.getText());
			frm_DatTour.setVisible(true);
			this.dispose();
		}
	}
	public void setData(Tour tour) {
		moTa = tour.getMoTa();
		lblMaTour.setText(tour.getMaTour());
		lblTenTour.setText(tour.getTenTour());
		lblDiemXuatPhat.setText(tour.getDiemXuatPhat());
		lblDiemDen.setText(tour.getDiemDen());
		lblNgayDi.setText(String.valueOf(tour.getNgayKhoiHanh()));
		lblThoiGian.setText(tour.getThoiGian());
		lblPhuongTien.setText(frm_Tour.getPhuongTienTheoMa(tour.getPhuongTien().getMaPhuongTien()).getLoaiPhuongTien());
		slQuyDinh = tour.getSoLuongKhachHangQuyDinh();
		lblSoLuong.setText(String.valueOf(frm_Tour.getSoLuongKhachDKy(tour.getMaTour()) +"\\"+ String.valueOf(tour.getSoLuongKhachHangQuyDinh())));
		chiTietTour.setText(tour.getMoTa());
		lblGiaTour.setText(String.valueOf(df.format(tour.getGia())));
		
		if(frm_Tour.getSoLuongKhachDKy(tour.getMaTour())>=tour.getSoLuongKhachHangQuyDinh()) {
			btnDatTour.setEnabled(false);
		}
	}
	private String docFile() {
		File file = new File("lib\\Luu_y.txt");
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader reader;
        String line = "";
        String out = "";
		try {
			inputStream = new FileInputStream(file);
			inputStreamReader = new InputStreamReader(inputStream);
		    reader = new BufferedReader(inputStreamReader);
		    try {
		    	while ((line = reader.readLine())!=null) {
					out = out + "\n" + line;
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return out;
	}
	
}
