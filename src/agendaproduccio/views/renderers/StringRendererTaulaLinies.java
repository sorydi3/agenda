package agendaproduccio.views.renderers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.ToolTipManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import agendaproduccio.models.entitatsbddAgenda.model.OrderLiniaRutaPNavison;
import agendaproduccio.models.entitatsbddAgenda.model.OrderLiniaRutaPNavison.Colors;
import agendaproduccio.utils.MyJTextField;
import agendaproduccio.views.renderers.jtables.JTableLinies;

public class StringRendererTaulaLinies extends DefaultTableCellRenderer implements ActionListener {
	private JTable m_table;
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public StringRendererTaulaLinies(MyJTextField searchField) {

		super.setOpaque(true);

	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component l_component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		JLabel etiqueta = (JLabel) l_component;
		m_table = table;
		setOpaque(isSelected);
		this.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent me) {
				ToolTipManager.sharedInstance().setDismissDelay(20000);
			}

			public void mouseExited(MouseEvent me) {
				ToolTipManager.sharedInstance().setDismissDelay(60000);
			}
		});
		renderStrings(etiqueta, value, row, column, table);
		return etiqueta;
	}

	private void renderStrings(JLabel etiqueta, Object value, int row, int column, JTable table) {
		if (value instanceof String) {
			if (column == JTableLinies.m_capcelera) {
				addTooltipCapcelera(row);
			} else {
				setToolTipText((String) value);
				addToolTipDataHora(row, column);
			}
			renderPriColum(column, row, etiqueta);
			renderAltresColum(column, row, etiqueta);
			renderBackgroundCanviLinia(row, column, etiqueta, table);
		}
	}

	public void renderPriColum(int column, int row, JLabel etiqueta) {
		OrderLiniaRutaPNavison l_order = (OrderLiniaRutaPNavison) m_table.getValueAt(row,
				JTableLinies.m_ordreLiniaRuta);
		if (column == JTableLinies.m_com) {
			if (l_order == null) {
				this.setOpaque(row % 2 == 0);
				etiqueta.setBackground(new Color(235, 245, 251));
			} else if (l_order.GetEstat() == Colors.YELLOW) {
				this.setOpaque(true);
				etiqueta.setBackground(new Color(255, 255, 153));
			} else if (l_order.GetEstat() == Colors.CHOCO) {
				this.setOpaque(true);
				etiqueta.setBackground(new Color(255, 204, 102)); // DARK CHOCOLATE
			} else if (l_order.GetEstat() == Colors.GREEN) {
				this.setOpaque(true);
				etiqueta.setBackground(new Color(0, 255, 51));
			} else if (l_order.GetEstat() == Colors.RED) {
				this.setOpaque(true);
				this.setBackground(Color.RED);
			} else {
				this.setOpaque(row % 2 == 0);
				etiqueta.setBackground(new Color(235, 245, 251));
			}
		}
	}

	private void addTooltipCapcelera(int row) {
		OrderLiniaRutaPNavison l_order = (OrderLiniaRutaPNavison) m_table.getValueAt(row,
				JTableLinies.m_ordreLiniaRuta);
		setToolTipText(l_order.getNLogs());
	}

	public void addToolTipDataHora(int row, int column) {
		OrderLiniaRutaPNavison l_order = (OrderLiniaRutaPNavison) m_table.getValueAt(row,
				JTableLinies.m_ordreLiniaRuta);
		if (column == JTableLinies.m_dh) {
			setToolTipText(l_order.getToolTipDataHora());
		}

	}

	public void renderAltresColum(int column, int row, JLabel etiqueta) {
		if (column >= JTableLinies.m_part && column <= JTableLinies.m_mae) {
			if (m_table.getValueAt(row, column) == null) {
				this.setOpaque(false);
			} else if ((m_table.getValueAt(row, column)).toString().equals("A co.")) {
				setBackgroundColorEtiqueta(etiqueta, new Color(255, 255, 153));
			} else if ((m_table.getValueAt(row, column)).toString().equals("Acab.")) {
				setBackgroundColorEtiqueta(etiqueta, new Color(255, 204, 102));
			} else if ((m_table.getValueAt(row, column)).toString().equals("Enge.")) {
				setBackgroundColorEtiqueta(etiqueta, new Color(0, 255, 51));
			} else if ((m_table.getValueAt(row, column)).toString().equals("Paus.")) {
				setBackgroundColorEtiqueta(etiqueta, new Color(255, 0, 0));
			} else if ((m_table.getValueAt(row, column)).toString().equals("Inci.")) {
				setBackgroundColorEtiqueta(etiqueta, new Color(255, 0, 0));
			} else if ((m_table.getValueAt(row, column)).toString().equals("Ext.")) {
				setBackgroundColorEtiqueta(etiqueta, new Color(153, 204, 255));
			} else {
				this.setOpaque(row % 2 == 0);
				etiqueta.setBackground(new Color(235, 245, 251));
			}
		}
	}

	public void setBackgroundColorEtiqueta(JLabel etiqueta, Color color) {
		this.setOpaque(true);
		etiqueta.setBackground(color);
	}

	public void renderBackgroundCanviLinia(int row, int colum, JLabel etiqueta, JTable table) {
		// int context = this;
		OrderLiniaRutaPNavison l_order = (OrderLiniaRutaPNavison) m_table.getValueAt(row,
				JTableLinies.m_ordreLiniaRuta);
		if (l_order.esMenorDtaJobTicket()
				&& (colum == JTableLinies.m_dataDataJobTicket || colum == JTableLinies.m_dataUltimCanvi)) {
			etiqueta.setText("<html> <font size = 3 color = red> <b>" + etiqueta.getText() + "</b></font></html>");
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillRect(0, this.getHeight(), this.getWidth(), 0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

//	Timer l_timer = new Timer(10000, new ActionListener() {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			SwingUtilities.invokeLater(new Runnable() {
//				@Override
//				public void run() {
//					String or_value = (String) m_table.getValueAt(row, colum);
//					for (int i = 0; i < 10; i++) {
//						DefaultTableModel l_model = ((DefaultTableModel) ((JTableLinies) m_table).getModel());
//						l_model.setValueAt("<html><font color = steelblue>>" + or_value + "</font></html>", row,colum);
//						try {
//							Thread.currentThread();
//							Thread.sleep(10000);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						l_model.setValueAt("<html><font color = steelblue>>" + " " + "</font></html>", row,colum);
//
//					}
//				}
//			});
//		}
//	});
//
//	l_timer.start();

}
