
package GUI;

import javax.swing.SwingUtilities;

public class Frm_Starting {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Frm_DangNhap frm = new Frm_DangNhap();
				frm.setVisible(true);
			}
		});
	}
}

