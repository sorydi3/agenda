package agendaproduccio.views.renderers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class StringRenderer extends DefaultTableCellRenderer {
	private JTable m_table;
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public StringRenderer() {

		setHorizontalTextPosition(LEFT);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component l_component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		JLabel etiqueta = (JLabel) l_component;
		m_table = table;
		setOpaque(isSelected);
		renderStrings(etiqueta,value,row,column);
		return this;
	}

	private void renderStrings(JLabel etiqueta, Object value, int row, int column) {
		if (value instanceof String) {
			renderPriColum(column,row,etiqueta);
			renderAltresColum(column,row,etiqueta);
		}
	}
	
	
	public void renderPriColum(int column,int row,JLabel etiqueta) {
		int l_columnaCodiColors =18;
		if ( column == 1 )
		{
			System.out.println(m_table.getValueAt( row, l_columnaCodiColors ));
			if (m_table.getValueAt( row, l_columnaCodiColors ) == null )
			{
				this.setOpaque( row % 2 == 0 );
				etiqueta.setBackground( new Color( 235, 245,251) );
			}
			else if ( ((int) m_table.getValueAt( row, l_columnaCodiColors) == 1 ))
			{
				
				this.setOpaque(true);
				etiqueta.setBackground( new Color( 255, 255, 153 ) );
			}
			else if ( ((int) m_table.getValueAt( row, l_columnaCodiColors) == 2 ))
			{
				this.setOpaque(true);
				etiqueta.setBackground( new Color( 255, 204, 102 ) );  //DARK CHOCOLATE
			}
			else if ( ((int) m_table.getValueAt( row, l_columnaCodiColors) == 3 ))
			{
				this.setOpaque(true);
				etiqueta.setBackground( new Color( 0, 255, 51 ) );
			}
			else if ( ((int) m_table.getValueAt( row, l_columnaCodiColors) == 4 ))
			{
				this.setOpaque(true);
				this.setBackground( Color.RED );
			}else {
				
				this.setOpaque( row % 2 == 0 );
				etiqueta.setBackground( new Color( 235, 245,251) );
			}
		}
	}
	
	public void renderAltresColum(int column,int row,JLabel etiqueta) {
		if(column>=2 && column <=17) {
			if ( m_table.getValueAt( row, column ) == null )
			{
				
				this.setOpaque( false );
			}
			else if ( (m_table.getValueAt( row, column )).toString( ).equals( "A co." ) )
			{
				this.setOpaque(true);
				etiqueta.setBackground( new Color( 255, 255, 153 ) );
			}
			else if ( (m_table.getValueAt( row, column )).toString( ).equals( "Acab." ) )
			{
				this.setOpaque(true);
				etiqueta.setBackground( new Color( 255, 204, 102 ) );
			}
			else if ( (m_table.getValueAt( row, column )).toString( ).equals( "Enge." ))
			{
				this.setOpaque(true);
				etiqueta.setBackground( new Color( 0, 255, 51 ) );
			}
			else if ( (m_table.getValueAt( row, column )).toString( ).equals( "Paus." ) )
			{
				this.setOpaque(true);
				etiqueta.setBackground( new Color( 255, 0, 0 ) );
			}
			else if ( (m_table.getValueAt( row, column )).toString( ).equals( "Inci." ) )
			{
				this.setOpaque(true);
				etiqueta.setBackground( new Color( 255, 0, 0 ) );
			}
			else if ( (m_table.getValueAt( row, column )).toString( ).equals( "Ext." ) )
			{
				this.setOpaque(true);
				etiqueta.setBackground( new Color( 153, 204, 255 ) );
			}
			else
			{
				this.setOpaque( row % 2 == 0 );
				etiqueta.setBackground( new Color( 235, 245,251) );
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillRect(0, this.getHeight() - 0, this.getWidth(), 1);
	}

}
