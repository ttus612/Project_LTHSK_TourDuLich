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
import dao.Tour_DAO;
import entity.HoaDon;
import entity.KhachHang;
import entity.Tour;

public class TourTableButtonEditor extends DefaultCellEditor {
	protected JButton btn;
	private String lbl;
	private Boolean clicked;
	private JTable tableTour;
	private DefaultTableModel modelTable;
	private Tour_DAO tour_DAO;
	private ArrayList<Tour> listTour;
	private KhachHang_DAO khachHang_DAO;
	private HoaDon_DAO hoaDon_DAO;
	private ArrayList<HoaDon> listHoaDon;
	private ArrayList<KhachHang> listKhachHang;

	public TourTableButtonEditor(JTextField textField) {
		super(textField);
		// TODO Auto-generated constructor stub

		btn = new JButton();
		btn.setOpaque(true);
		tour_DAO = new Tour_DAO();
		khachHang_DAO = new KhachHang_DAO();
		hoaDon_DAO = new HoaDon_DAO();

		listTour = new ArrayList<Tour>();
		listHoaDon = new ArrayList<HoaDon>();
		listKhachHang = new ArrayList<KhachHang>();

		listTour = tour_DAO.getAllTour();
		listKhachHang = khachHang_DAO.getAllKhachHang();

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
		lbl = ((obj == null) ? "Xóa" : obj.toString());
		btn.setText(lbl);
		tableTour = table;
		modelTable = (DefaultTableModel) table.getModel();
		clicked = true;
		return btn;
	}

	@Override
	public Object getCellEditorValue() {
		if (clicked) {
			if (btn.getText().equals("Xóa")) {
				int selection = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa tour này không", "Thông báo",
						JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
				if (selection == JOptionPane.YES_OPTION) {
					hoaDon_DAO.deleteHoaDonTheoTour(modelTable.getValueAt(tableTour.getSelectedRow(), 0).toString());
					tour_DAO.deleteTour(modelTable.getValueAt(tableTour.getSelectedRow(), 0).toString());
					modelTable.removeRow(tableTour.getSelectedRow());
					JOptionPane.showConfirmDialog(null, "Xóa Tour thành công", "Thông báo", JOptionPane.WARNING_MESSAGE,
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
