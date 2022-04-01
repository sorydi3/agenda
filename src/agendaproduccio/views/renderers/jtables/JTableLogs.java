package agendaproduccio.views.renderers.jtables;

import java.awt.Color;

import javax.swing.table.DefaultTableModel;

import agendaproduccio.models.entitatsbddAgenda.model.LogsModificacions;
import agendaproduccio.utils.JTableGUI;
import agendaproduccio.views.renderers.StringRendererTaulaLogs;

public class JTableLogs extends JTableGUI {

	public static final int m_data = 0;
	public static final int m_usuari = 1;
	public static final int m_concepte = 2;
	public static final int m_vantic = 3;
	public static final int m_vnou = 4;
	public static final int m_vdesc = 5;

	public JTableLogs() {
		super();
		this.configuraRenderers();
		ConfigurarColumnes();
	}

	@Override
	protected void ConfigurarTotalColumnes() {
		TOTAL_COLUMNES = 6;
	}

	public void AfegirFila(Object p_logsModif) {
		BuidarFila();
		LogsModificacions l_logModf = (LogsModificacions) p_logsModif;
		m_fila[m_data] = l_logModf.getData();
		m_fila[m_usuari] = l_logModf.getUsuari();
		m_fila[m_concepte] = l_logModf.getConcepte();
		m_fila[m_vantic] = l_logModf.getVAntic();
		m_fila[m_vnou] = l_logModf.getVNou();
		m_fila[m_vdesc] = l_logModf.getDesc();
		m_model.addRow(m_fila);
	}

	@Override
	protected DefaultTableModel CrearModel() {
		m_fila[m_data] = "Data";
		m_fila[m_usuari] = "Usuari";
		m_fila[m_concepte] = "Concepte";
		m_fila[m_vantic] = "Valor Antic";
		m_fila[m_vnou] = "Valor Nou";
		m_fila[m_vdesc] = "Descripció";
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

		getColumnModel().getColumn(m_usuari).setPreferredWidth(100);
		getColumnModel().getColumn(m_usuari).setMinWidth(80);
		getColumnModel().getColumn(m_usuari).setMaxWidth(100);

		getColumnModel().getColumn(m_data).setPreferredWidth(120);
		getColumnModel().getColumn(m_data).setMinWidth(90);
		getColumnModel().getColumn(m_data).setMaxWidth(120);

		getColumnModel().getColumn(m_vdesc).setPreferredWidth(0);
		getColumnModel().getColumn(m_vdesc).setMinWidth(0);
		getColumnModel().getColumn(m_vdesc).setMaxWidth(0);
	}

	@Override
	protected void configuraRenderers() {
		setDefaultRenderer(String.class, new StringRendererTaulaLogs());
	}

	public void buidarTaula() {
		((DefaultTableModel) this.getModel()).setRowCount(0);
	}
}
