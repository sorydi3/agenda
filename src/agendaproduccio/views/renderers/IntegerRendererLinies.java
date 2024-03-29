package agendaproduccio.views.renderers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class IntegerRendererLinies extends DefaultTableCellRenderer {
	
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public IntegerRendererLinies() {
		setHorizontalTextPosition(LEFT);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component l_component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		JLabel etiqueta = (JLabel) l_component;
		
		setOpaque(isSelected);
		renderInteger(etiqueta, value, row, column);
		return this;
	}

	private void renderInteger(JLabel etiqueta, Object value, int row, int column) {
		if (value instanceof Integer) {
			setToolTipText(String.valueOf((Integer) value));
			renderColums(column, row, etiqueta);
		}
	}

	public void renderColums(int column, int row, JLabel etiqueta) {
		this.setOpaque(row % 2 == 0);
		etiqueta.setBackground(new Color(235, 245, 251));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillRect(0, this.getHeight() - 0, this.getWidth(), 1);
	}

}
