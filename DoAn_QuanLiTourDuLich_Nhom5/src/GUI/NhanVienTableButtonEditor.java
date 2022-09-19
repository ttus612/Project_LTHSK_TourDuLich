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
import javax.swing.table.TableModel;

import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;
import entity.NhanVien;

public class NhanVienTableButtonEditor extends DefaultCellEditor {
	protected JButton btn;
	private String lbl;
	private Boolean clicked;
	private JTable tableNV;
	private NhanVien_DAO nhanVien_DAO;
	private TaiKhoan_DAO taiKhoan_DAO;
	private DefaultTableModel modelNV;
	private NhanVien_DAO dsNhanVien;
	private ArrayList<NhanVien> list_NV;
	private int rowSeLect;
	public NhanVienTableButtonEditor(JTextField textField) {
		super(textField);
		// TODO Auto-generated constructor stub
		
		nhanVien_DAO = new NhanVien_DAO();
		taiKhoan_DAO = new TaiKhoan_DAO();
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
		tableNV = table;
		modelNV = (DefaultTableModel) tableNV.getModel();
		clicked = true;
		return btn;
	}
	@Override
	public Object getCellEditorValue() {
		if(clicked) {
			if(btn.getText().equals("Xóa")) {
				int selection = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa nv này không"
						, "Thông báo", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
				if(selection == JOptionPane.YES_OPTION) {
					//nhanVien_DAO.xoaNhanVien(modelNV.getValueAt(tableNV.getSelectedRow(), 0).toString());
					dsNhanVien= new NhanVien_DAO();
					list_NV = dsNhanVien.getAllNhanVien();
					dsNhanVien.xoaNhanVien(list_NV.get(rowSeLect).getMaNhanvien());
			
					modelNV.removeRow(tableNV.getSelectedRow());
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
