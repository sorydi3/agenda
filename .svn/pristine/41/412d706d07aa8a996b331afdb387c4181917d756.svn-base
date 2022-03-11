package agendaproduccio.views.renderers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.RowSorter.SortKey;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;



public class HeaderRenderrer extends DefaultTableCellRenderer  {
	/**
	   * Constructs a <code>DefaultTableHeaderCellRenderer</code>.
	   * <P>
	   * The horizontal alignment and text position are set as appropriate to a
	   * table header cell, and the opaque property is set to false.
	   */
	  public HeaderRenderrer() {
		  setOpaque(false);
	    setHorizontalTextPosition(LEFT);
	  }

	  /**
	   * Returns the default table header cell renderer.
	   * <P>
	   * If the column is sorted, the approapriate icon is retrieved from the
	   * current Look and Feel, and a border appropriate to a table header cell
	   * is applied.
	   * <P>
	   * Subclasses may overide this method to provide custom content or
	   * formatting.
	   *
	   * @param table the <code>JTable</code>.
	   * @param value the value to assign to the header cell
	   * @param isSelected This parameter is ignored.
	   * @param hasFocus This parameter is ignored.
	   * @param row This parameter is ignored.
	   * @param column the column of the header cell to render
	   * @return the default table header cell renderer
	   */
	  @Override
	  public Component getTableCellRendererComponent(JTable table, Object value,
	          boolean isSelected, boolean hasFocus, int row, int column) {
	    super.getTableCellRendererComponent(table, value,
	            isSelected, hasFocus, row, column);
	    JTableHeader tableHeader = table.getTableHeader();
	    if (tableHeader != null) {
	      setForeground(tableHeader.getForeground());
	    }
	    setIcon(getIcon(table, column));
	    setBorder(UIManager.getBorder("TableHeader.cellBorder"));
	    
	    Component l_component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	    this.setBackground(Color.red);
		JLabel etiqueta = (JLabel) l_component;
		this.renderString(etiqueta, value);
		
	    return this;
	  }

	  /**
	   * Overloaded to return an icon suitable to the primary sorted column, or null if
	   * the column is not the primary sort key.
	   *
	   * @param table the <code>JTable</code>.
	   * @param column the column index.
	   * @return the sort icon, or null if the column is unsorted.
	   */
	  protected Icon getIcon(JTable table, int column) {
	    SortKey sortKey = getSortKey(table, column);
	    if (sortKey != null && table.convertColumnIndexToView(sortKey.getColumn()) == column) {
	      switch (sortKey.getSortOrder()) {
	        case ASCENDING:
	          return UIManager.getIcon("Table.ascendingSortIcon");
	        case DESCENDING:
	          return UIManager.getIcon("Table.descendingSortIcon");
	      }
	    }
	    return null;
	  }

	  /**
	   * Returns the current sort key, or null if the column is unsorted.
	   *
	   * @param table the table
	   * @param column the column index
	   * @return the SortKey, or null if the column is unsorted
	   */
	  protected SortKey getSortKey(JTable table, int column) {
	    RowSorter rowSorter = table.getRowSorter();
	    if (rowSorter == null) {
	      return null;
	    }

	    List sortedColumns = rowSorter.getSortKeys();
	    if (sortedColumns.size() > 0) {
	      return (SortKey) sortedColumns.get(0);
	    }
	    return null;
	  }
	  
	  @Override
		public void paintComponent( Graphics g )
		{
			super.paintComponent( g );
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.black);
			g2d.fillRect( 0, this.getHeight( )-2, this.getWidth( ), 2 );					
		}
	  
	  
	  private void renderString(JLabel etiqueta, Object value) {
			if (value instanceof String) {
				etiqueta.setText((String) value);

				String str = (String) value;
				if (str.isEmpty()) {
					etiqueta.setBackground(Color.CYAN);
				} else {
					etiqueta.setFont(new Font("Arial", Font.BOLD, 12));
					Border border = etiqueta.getBorder();
					Border margin = new EmptyBorder(0,0,2,0);
					etiqueta.setBorder(new CompoundBorder(border, margin));
				}
			}
		}
	  
}
