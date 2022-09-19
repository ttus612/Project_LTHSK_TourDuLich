package GUI;


import java.awt.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.PhuongTien_DAO;
import entity.PhuongTien;

public class PhuongTienTableButtonEditor extends DefaultCellEditor {
	protected JButton btn;
	private String lbl;
	private Boolean clicked;
	private PhuongTien_DAO dsPhuongTien;
	private ArrayList<PhuongTien> list_PT;
	private int rowSeLect;
	private JTable tablePT;
	private DefaultTableModel modelTablePT;

	public PhuongTienTableButtonEditor(JTextField textField) {
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
		tablePT = table;
		clicked = true;
		return btn;
	}
	@Override
	public Object getCellEditorValue() {
		if(clicked) {
			if(btn.getText().equals("Xóa")) {
				int selection = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa pt này không"
						, "Thông báo", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
				if(selection == JOptionPane.YES_OPTION) {
					dsPhuongTien = new PhuongTien_DAO();
					list_PT = dsPhuongTien.getAllPhuongTien();
					dsPhuongTien.xoaPhuongTien(list_PT.get(rowSeLect).getMaPhuongTien());
					DefaultTableModel dm = (DefaultTableModel)tablePT.getModel();
					dm.removeRow(tablePT.getSelectedRow());
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
