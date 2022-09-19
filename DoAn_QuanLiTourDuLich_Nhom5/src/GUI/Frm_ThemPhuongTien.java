package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import entity.PhuongTien;

public class Frm_ThemPhuongTien extends JFrame implements ActionListener, MouseListener {
	
	private JTextField txtMaPhuongTien;
	private JTextField txtLoaiPhuongTien;
	private JTextField txtBienSo;
	private JTextField txtGhiChu;

	private JLabel lblMaPhuongTien;
	private JLabel lblLoaiPhuongTien;
	private JLabel lblBienSo;
	private JLabel lblGhiChu;
	private JButton btnLuu;
	private JButton btnDong;
	private JLabel lblTitle;
	private Frm_PhuongTien frmPhuongTien;
	public Frm_ThemPhuongTien() {
		setTitle("Thêm Dịch Vụ");
		setSize(1000, 550);
		setLocationRelativeTo(null);
		setResizable(false);
		add(lblTitle = new JLabel("Thêm phương tiện", SwingConstants.CENTER), BorderLayout.NORTH);
		lblTitle.setFont(new Font("Time New Roman", Font.BOLD, 35));
		lblTitle.setForeground(Color.red);
		

		lblMaPhuongTien = new JLabel("Mã phương tiện: ");
		lblMaPhuongTien.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		lblLoaiPhuongTien = new JLabel("Loại phương tiện: ");
		lblLoaiPhuongTien.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		lblBienSo = new JLabel("Biển số: ");
		lblBienSo.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		lblGhiChu = new JLabel("Ghi chú: ");
		lblGhiChu.setFont(new Font("Time New Roman", Font.PLAIN, 20));

		txtMaPhuongTien = new JTextField();
		txtMaPhuongTien.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		txtLoaiPhuongTien = new JTextField();
		txtLoaiPhuongTien.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		txtBienSo = new JTextField();
		txtBienSo.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		txtGhiChu = new JTextField();
		txtGhiChu.setFont(new Font("Time New Roman", Font.PLAIN, 20));


		btnLuu = new JButton("Lưu", new ImageIcon("img\\save.png"));
		btnLuu.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		btnLuu.setPreferredSize(new Dimension(100, 30));
		btnLuu.setToolTipText("Lưu thông tin phương tiện");
		
		btnDong = new JButton("Đóng", new ImageIcon("img\\close.png"));
		btnDong.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		btnDong.setPreferredSize(new Dimension(100, 30));
		btnDong.setToolTipText("Đóng");
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

		Box b1 = Box.createHorizontalBox();
		b1.add(lblMaPhuongTien);
		b1.add(Box.createRigidArea(new Dimension(35, 5)));
		b1.add(txtMaPhuongTien);
		b1.add(Box.createRigidArea(new Dimension(35, 5)));
		b1.add(lblBienSo);
		b1.add(Box.createRigidArea(new Dimension(35, 5)));
		b1.add(txtBienSo);

		p.add(Box.createRigidArea(new Dimension(30, 30)));
		p.add(b1);
		p.add(Box.createRigidArea(new Dimension(30, 30)));

		Box b2 = Box.createHorizontalBox();
		b2.add(lblLoaiPhuongTien);
		b2.add(Box.createRigidArea(new Dimension(35, 5)));
		b2.add(txtLoaiPhuongTien);

		p.add(b2);
		p.add(Box.createRigidArea(new Dimension(30, 30)));


		Box b5 = Box.createHorizontalBox();
		b5.add(lblGhiChu);
		b5.add(Box.createRigidArea(new Dimension(750, 0)));
		Box b6 = Box.createHorizontalBox();
		b6.add(txtGhiChu);
		b6.add(Box.createRigidArea(new Dimension(0, 150)));

		p.add(Box.createRigidArea(new Dimension(40, 40)));
		p.add(b5);
		p.add(Box.createRigidArea(new Dimension(10, 10)));
		p.add(b6);
		p.add(Box.createRigidArea(new Dimension(20, 20)));

	
		lblMaPhuongTien.setPreferredSize(lblLoaiPhuongTien.getPreferredSize());
		

		JPanel pBottom = new JPanel();
		pBottom.add(btnLuu);
		pBottom.add(btnDong);
		btnLuu.setBackground(new Color(42, 175, 45));
		btnLuu.setForeground(Color.WHITE);
		btnDong.setBackground(new Color(224, 37, 37));
		btnDong.setForeground(Color.WHITE);

		Box bTop = Box.createVerticalBox();
		bTop.setBorder(BorderFactory.createTitledBorder("Thông tin phương tiện"));
		bTop.add(p);

		Box bN = Box.createVerticalBox();
		bN.add(bTop);
		bN.add(pBottom);

		add(bN, BorderLayout.CENTER);
		bN.setPreferredSize(new Dimension(0, 500));

		btnLuu.addActionListener(this);
		btnDong.addActionListener(this);
	}
	public static void main(String[] args) {
		new Frm_ThemPhuongTien().setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnLuu)) {
			if(checkInput()) {
				String ma = txtMaPhuongTien.getText().trim();
				String bienSo = txtBienSo.getText().trim();
				String loaiPT = txtLoaiPhuongTien.getText().trim();
				String ghiChu = txtGhiChu.getText().trim();
				PhuongTien s =new PhuongTien(ma, loaiPT, bienSo, ghiChu);
				frmPhuongTien= new Frm_PhuongTien();
				try {
					frmPhuongTien.themPhuongTien(s);
					JOptionPane.showMessageDialog(this, "Thêm thành công!");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		
		}if(e.getSource().equals(btnDong)) {
			System.exit(0);
		}

	}
	private boolean checkInput() {
//		String ma = txtMaPhuongTien.getText().trim();
//		String bienSo = txtBienSo.getText().trim();
//		String loaiPT = txtLoaiPhuongTien.getText().trim();
//		if(!(ma.length()>0 && ma.matches("^[a-zA-Z0-9 ]+$"))) {
//			JOptionPane.showMessageDialog(null, "Mã không hợp lệ");
//			txtMaPhuongTien.requestFocus();
//			return false;
//		}if(!(bienSo.length()>0 && bienSo.matches("[0-9A-Z]{2,5}[-]{1}[.0-9]{3,6}"))) {
//			JOptionPane.showMessageDialog(null, "Biển số không hợp lệ");
//			txtBienSo.requestFocus();
//			return false;
//		}if(loaiPT.equals("^[a-zA-Z ]+$")) {
//			JOptionPane.showMessageDialog(null, "Loại phương tiện không hợp lệ");
//			txtLoaiPhuongTien.requestFocus();
//			return false;
//		}
		return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
	public void xoaRongTextfields() {
		txtMaPhuongTien.setText("");
		txtBienSo.setText("");
		txtLoaiPhuongTien.setText("");
		txtGhiChu.setText("");
		txtMaPhuongTien.requestFocus();
	}

}
