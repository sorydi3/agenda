package agendaproduccio.views.renderers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import agendaproduccio.utils.LabelHighlighted;
import agendaproduccio.utils.MyJTextField;


public class HighlightRenderer extends DefaultTableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyJTextField m_searchField;

	public HighlightRenderer(MyJTextField searchField) {
		super.setOpaque(true);
		this.m_searchField = searchField;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		Component l_component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		JLabel etiqueta = (JLabel) l_component;

		renderString(etiqueta, value, table, column, row);// render cells with string type
		etiqueta = highLightText(etiqueta, l_component);
		etiqueta.setAlignmentX(LEFT_ALIGNMENT);
		return etiqueta;
	}

	private JLabel highLightText(JLabel l_original, Component l_component) {

		if (m_searchField != null && !m_searchField.getText().isEmpty()) {
			LabelHighlighted l_labelHighLighted = new LabelHighlighted();
			l_labelHighLighted.setFont(l_original.getFont());
			l_labelHighLighted.setText(l_original.getText());
			l_labelHighLighted.setBackground(l_original.getBackground());
			l_labelHighLighted.setForeground(l_original.getForeground());
			l_labelHighLighted.setHorizontalTextPosition(l_original.getHorizontalTextPosition());;
			l_labelHighLighted.highlightText(m_searchField.getText());
			return l_labelHighLighted;
		} else {
			return l_original;
		}
	}

	private void renderString(JLabel etiqueta, Object value, JTable jtable, int column, int row) {
		if (value instanceof String) {
			etiqueta.setOpaque(true);
			etiqueta.setText((String) value);

			if (value.toString().equals("Ext.")) {
				
			}
			
			if(value.toString().equals("Ext.")) {
				
			}
			
			
			
			if(value.toString().equals("Ext.")) {
				
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillRect(0, this.getHeight() - 2, this.getWidth(), 1);
	}

}
