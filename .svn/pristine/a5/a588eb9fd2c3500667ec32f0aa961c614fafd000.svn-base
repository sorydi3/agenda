package agendaproduccio.views.renderers.jtables;

import java.awt.Color;

import javax.swing.table.DefaultTableModel;

import agendaproduccio.models.entitatsbddAgenda.model.LogsModificacions;
import agendaproduccio.models.entitatsbddAgenda.model.OrderLiniaRutaPNavison;
import agendaproduccio.utils.JTableGUI;
import agendaproduccio.views.renderers.IntegerRenderer;
import agendaproduccio.views.renderers.StringRenderer;

public class JTableLogs extends JTableGUI {

	public static final int m_data = 0;
	public static final int m_concepte = 1;
	public static final int m_vnou = 2;
	public static final int m_vantic = 3;

	public JTableLogs() {
		super();
		this.configuraRenderers();
		ConfigurarColumnes();
	}

	@Override
	protected void ConfigurarTotalColumnes() {
		TOTAL_COLUMNES = 4;
	}

	public void AfegirFila(Object p_logsModif) {
		BuidarFila();
		LogsModificacions l_logModf = (LogsModificacions) p_logsModif;
		m_fila[m_data] = l_logModf.getData();
		m_fila[m_concepte] = l_logModf.getConcepte();
		m_fila[m_vantic] = l_logModf.getVAntic();
		m_fila[m_vnou] = l_logModf.getVNou();
		m_model.addRow(m_fila);
	}

	@Override
	protected DefaultTableModel CrearModel() {
		m_fila[m_data] = "Data";
		m_fila[m_concepte] = "Concepte";
		m_fila[m_vantic] = "Valor Antic";
		m_fila[m_vnou] = "Valor Nou";
		DefaultTableModel l_model = new DefaultTableModel(m_fila, 0) {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				switch (columnIndex) {
				default:
					return String.class;
				}

			};

			public boolean isCellEditable(int p_row, int p_col) {
				return false;
			}

			public void setValueAt(Object p_obj, int p_row, int p_col) {
				super.setValueAt(p_obj, p_row, p_col);
			}

			public Object getValueAt(int p_row, int p_col) {
				return (super.getValueAt(p_row, p_col));
			}

			@Override
			public int getColumnCount() {
				return super.getColumnCount();
			}

		};
		m_model = l_model;
		return l_model;
	}

	@Override
	protected void ConfigurarColumnes() {
		this.setBackground(Color.white);

//		int l_max = 40;
//		int l_min = 20;
//
//		int amagat_height = 30;
//		int amagat_width = 0;
//
//		getColumnModel().getColumn().setPreferredWidth(400);
//		getColumnModel().getColumn(m_capcelera).setMinWidth(100);
//		getColumnModel().getColumn(m_capcelera).setMaxWidth(400);
//
//		getColumnModel().getColumn(m_pla).setPreferredWidth(l_max);
//		getColumnModel().getColumn(m_pla).setMinWidth(l_min);
//		getColumnModel().getColumn(m_pla).setMaxWidth(l_max);
//
//		getColumnModel().getColumn(m_part).setPreferredWidth(l_max);
//		getColumnModel().getColumn(m_part).setMinWidth(l_min);
//		getColumnModel().getColumn(m_part).setMaxWidth(l_max);
//
//		getColumnModel().getColumn(m_com).setPreferredWidth(l_max);
//		getColumnModel().getColumn(m_com).setMinWidth(l_min);
//		getColumnModel().getColumn(m_com).setMaxWidth(l_max);
//
//		getColumnModel().getColumn(m_tir).setPreferredWidth(l_max);
//		getColumnModel().getColumn(m_tir).setMinWidth(l_min);
//		getColumnModel().getColumn(m_tir).setMaxWidth(l_max);
//
//		getColumnModel().getColumn(m_maq).setPreferredWidth(150);
//		getColumnModel().getColumn(m_maq).setMinWidth(20);
//		getColumnModel().getColumn(m_maq).setMaxWidth(150);

	}

	@Override
	protected void configuraRenderers() {
		// setDefaultRenderer(String.class, new StringRenderer());
		// setDefaultRenderer(Integer.class, new IntegerRenderer());
	}

	public void buidarTaula() {
		((DefaultTableModel) this.getModel()).setRowCount(0);
	}
}
