package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
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
import entity.HoaDon;

public class HoaDonTableButtonEditor extends DefaultCellEditor {
	protected JButton btn;
	private String lbl;
	private Boolean clicked;
	private JTable tableHD;
	private HoaDon_DAO dsHoaDon;
	private ArrayList<HoaDon> list_HD;
	private int rowSeLect;
	public HoaDonTableButtonEditor(JTextField textField) {
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
		tableHD = table;
		clicked = true;
		return btn;
	}
	@Override
	public Object getCellEditorValue() {
		if(clicked) {
			if(btn.getText().equals("Xóa")) {
				int selection = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa hóa đơn này không"
						, "Thông báo", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
				if(selection == JOptionPane.YES_OPTION) {
					dsHoaDon = new HoaDon_DAO();
					list_HD = dsHoaDon.getAllHoaDon();
					
					dsHoaDon.xoaHoaDon(list_HD.get(rowSeLect).getMaHoaDon());
					DefaultTableModel dm = (DefaultTableModel)tableHD.getModel();
					dm.removeRow(tableHD.getSelectedRow());
					JOptionPane.showConfirmDialog(null, "Xóa hóa đơn thành công", "Thông báo", JOptionPane.WARNING_MESSAGE,
							JOptionPane.OK_CANCEL_OPTION);

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
