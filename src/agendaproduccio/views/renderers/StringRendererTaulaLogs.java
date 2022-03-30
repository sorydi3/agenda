package agendaproduccio.views.renderers;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ToolTipManager;
import javax.swing.table.DefaultTableCellRenderer;

public class StringRendererTaulaLogs extends DefaultTableCellRenderer {

	private JTable m_table;

	public StringRendererTaulaLogs() {
		setHorizontalTextPosition(LEFT);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component l_component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		JLabel etiqueta = (JLabel) l_component;
		m_table = table;
		setOpaque(isSelected);
		renderStrings(etiqueta, value, row, column);
		this.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent me) {
				ToolTipManager.sharedInstance().setDismissDelay(45000);
			}

			public void mouseExited(MouseEvent me) {
				ToolTipManager.sharedInstance().setDismissDelay(0);
			}
		});
		return this;
	}

	private void renderStrings(JLabel etiqueta, Object value, int row, int column) {
		if (value instanceof String) {
			setToolTipText((String) value);
			this.setOpaque(row % 2 == 0);
			etiqueta.setBackground(new Color(235, 245, 251));

		}
	}

}
