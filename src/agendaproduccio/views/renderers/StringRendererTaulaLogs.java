package agendaproduccio.views.renderers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ToolTipManager;
import javax.swing.table.DefaultTableCellRenderer;
import agendaproduccio.views.renderers.jtables.JTableLogs;

public class StringRendererTaulaLogs extends DefaultTableCellRenderer {

	public StringRendererTaulaLogs() {
		setHorizontalTextPosition(LEFT);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component l_component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		JLabel etiqueta = (JLabel) l_component;
		renderStrings(table, etiqueta, value, row, column, isSelected);
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

	private void renderStrings(JTable table, JLabel etiqueta, Object value, int row, int column, boolean isSelected) {
		if (value instanceof String) {
			addToolTip(table, row, column, value);
			if (!isSelected) {
				this.setOpaque(row % 2 == 0);
				etiqueta.setBackground(new Color(235, 245, 251));
			} else {
				setOpaque(true);
				etiqueta.setBackground(new Color(151, 225, 183));
				setOpaque(true);
				etiqueta.setFont(new Font("Arial", Font.BOLD, 15));
			}
		}

	}

	private void addToolTip(JTable table, int row, int column, Object value) {
		if (column == JTableLogs.m_vantic) {
			String L_vAntic = (String) table.getValueAt(row, JTableLogs.m_vanticAmbTags);
			setToolTipText(L_vAntic);
		} else if (column == JTableLogs.m_vnou) {
			String L_vNou = (String) table.getValueAt(row, JTableLogs.m_vnouAmbTags);
			setToolTipText(L_vNou);
		} else {
			setToolTipText((String) value);
		}
	}

}
