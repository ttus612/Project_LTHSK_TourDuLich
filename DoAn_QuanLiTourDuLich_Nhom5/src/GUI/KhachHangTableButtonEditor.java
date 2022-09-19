package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultButtonModel;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import entity.KhachHang;

public class KhachHangTableButtonEditor extends DefaultCellEditor {
	protected JButton btn;
	private String lbl;
	private Boolean clicked;
	private JTable tableKH;
	private KhachHang_DAO dsKhachHang;
	private HoaDon_DAO dsHoaDon;
	private ArrayList<KhachHang> list_KH ;
	private int rowSeLect;
	public KhachHangTableButtonEditor(JTextField textField) {
		super(textField);
		// TODO Auto-generated constructor stub
		
		btn = new JButton();
		btn.setOpaque(true);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fireEditingStopped();
			}
		});
		
	}
	@Override
	public Component getTableCellEditorComponent(JTable table, Object obj, boolean Selected, int row, int column) {
		// TODO Auto-generated method stub
		lbl = ((obj==null) ? "Xóa" : obj.toString());
		btn.setText(lbl);
		clicked = true;
		tableKH = table;
		return btn;
	}
	@Override
	public Object getCellEditorValue() {
		if(clicked) {
			if(btn.getText().equals("Xóa")) {
				int selection = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa khách hàng này không"
						, "Thông báo", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
				if(selection == JOptionPane.YES_OPTION) {
					dsKhachHang = new KhachHang_DAO();
					list_KH = dsKhachHang.getAllKhachHang();
					dsKhachHang.xoaKhachHang(list_KH.get(rowSeLect).getMaKhachHang());
					DefaultTableModel dm = (DefaultTableModel)tableKH.getModel();
					dm.removeRow(tableKH.getSelectedRow());
				}
			}
		}
		clicked = false;
		return new String(lbl);
	}
	@Override
	public boolean stopCellEditing() {
		clicked = false;
		return super.stopCellEditing();
	}

	@Override
	protected void fireEditingStopped() {
		// TODO Auto-generated method stub
		super.fireEditingStopped();
	}
	
}
