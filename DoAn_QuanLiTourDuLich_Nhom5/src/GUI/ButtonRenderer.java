package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer extends JButton implements TableCellRenderer{
	public ButtonRenderer() {
		setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object obj, boolean Selected, boolean hasFocus,
			int row, int column) {
		setText((obj==null) ? "Xóa": obj.toString());
		
		setBackground(Color.WHITE);
		setFont(new Font("Time New Roman", Font.BOLD,18));
		setForeground(Color.BLUE);
		setBorder(null);
		setPreferredSize(new Dimension(10, 20));
		return this;
	}
	
}
